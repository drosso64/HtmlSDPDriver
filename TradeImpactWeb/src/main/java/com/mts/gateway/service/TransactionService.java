package com.mts.gateway.service;

import com.mts.gateway.classloader.SDPClassLoaderService;
import com.mts.gateway.dto.TransactionRequest;
import com.mts.gateway.dto.TransactionResponse;
import com.mts.gateway.sdp.SDPConnection;
import com.mts.gateway.sdp.SDPConnectionPool;
import com.mtsmarkets.sdp.smp.SMPMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Transaction Service
 * 
 * Handles transaction execution through SDP protocol.
 * Follows patterns from SampleTXNTransaction.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {
    
    private final SDPConnectionPool connectionPool;
    private final SDPClassLoaderService classLoaderService;
    
    /**
     * Execute a standard transaction (SAPActionReq)
     * 
     * @param request Transaction request
     * @return Transaction response
     */
    public TransactionResponse executeTransaction(TransactionRequest request) throws Exception {
        log.info("Executing transaction: classId={} action={}", 
            request.getClassId(), request.getAction());
        
        // Get connection from transaction pool
        SDPConnection connection = connectionPool.getTransactionConnection();
        if (connection == null) {
            throw new IllegalStateException("No transaction connection available. Please login first.");
        }
        
        // Create SMP message from request data
        SMPMessage smpMessage = createSMPMessage(request);
        
        // Send transaction and wait for response
        CompletableFuture<TransactionResponse> responseFuture = 
            connection.sendTransaction(smpMessage, request.getAction().name());
        
        // Wait for response with timeout
        TransactionResponse response = responseFuture.get(30, TimeUnit.SECONDS);
        response.setReferenceId(request.getReferenceId());
        
        return response;
    }
    
    /**
     * Execute a monitored transaction (SAPMonitoredActionReq)
     * 
     * Monitored transactions allow tracking the lifecycle through status updates.
     * 
     * @param request Transaction request
     * @return Transaction response with monitoring ID
     */
    public TransactionResponse executeMonitoredTransaction(TransactionRequest request) throws Exception {
        log.info("Executing monitored transaction: classId={} action={}", 
            request.getClassId(), request.getAction());
        
        SDPConnection connection = connectionPool.getTransactionConnection();
        if (connection == null) {
            throw new IllegalStateException("No transaction connection available. Please login first.");
        }
        
        SMPMessage smpMessage = createSMPMessage(request);
        
        CompletableFuture<TransactionResponse> responseFuture = 
            connection.sendMonitoredTransaction(smpMessage, request.getAction().name());
        
        TransactionResponse response = responseFuture.get(30, TimeUnit.SECONDS);
        response.setReferenceId(request.getReferenceId());
        
        return response;
    }
    
    /**
     * Execute an extended transaction (SAPExtActionReq)
     * 
     * Extended transactions support additional fields beyond standard structure.
     * 
     * @param request Transaction request
     * @return Transaction response
     */
    public TransactionResponse executeExtendedTransaction(TransactionRequest request) throws Exception {
        log.info("Executing extended transaction: classId={} action={}", 
            request.getClassId(), request.getAction());
        
        SDPConnection connection = connectionPool.getTransactionConnection();
        if (connection == null) {
            throw new IllegalStateException("No transaction connection available. Please login first.");
        }
        
        SMPMessage smpMessage = createSMPMessage(request);
        
        CompletableFuture<TransactionResponse> responseFuture = 
            connection.sendExtendedTransaction(smpMessage, request.getAction().name());
        
        TransactionResponse response = responseFuture.get(30, TimeUnit.SECONDS);
        response.setReferenceId(request.getReferenceId());
        
        return response;
    }
    
    /**
     * Create SMP message from transaction request
     * 
     * Uses reflection to instantiate the market class and populate fields.
     * 
     * @param request Transaction request
     * @return SMPMessage instance
     */
    private SMPMessage createSMPMessage(TransactionRequest request) throws Exception {
        // Load class from market JAR
        Class<?> messageClass = classLoaderService.getMarketClassLoader()
            .loadClass(request.getClassId());
        
        if (!SMPMessage.class.isAssignableFrom(messageClass)) {
            throw new IllegalArgumentException(
                "Class " + request.getClassId() + " is not an SMPMessage");
        }
        
        // Create instance
        SMPMessage smpMessage = (SMPMessage) messageClass.getDeclaredConstructor().newInstance();
        
        // Populate fields from request data
        populateMessageFields(smpMessage, request.getData());
        
        log.debug("Created SMP message: {}", smpMessage);
        return smpMessage;
    }
    
    /**
     * Populate message fields using reflection
     * 
     * Converts field names to setter methods and invokes them with values.
     * Example: "InstrumentId" -> setInstrumentId(value)
     * 
     * @param message SMP message instance
     * @param data Field name to value mapping
     */
    private void populateMessageFields(SMPMessage message, Map<String, Object> data) throws Exception {
        Class<?> messageClass = message.getClass();
        
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();
            
            // Convert field name to setter method name
            String setterName = "set" + fieldName;
            
            try {
                // Find setter method
                Method setter = findSetter(messageClass, setterName);
                
                if (setter != null) {
                    // Convert value to appropriate type if needed
                    Object convertedValue = convertValue(value, setter.getParameterTypes()[0]);
                    setter.invoke(message, convertedValue);
                    log.debug("Set field {} = {}", fieldName, convertedValue);
                } else {
                    log.warn("Setter not found for field: {}", fieldName);
                }
                
            } catch (Exception e) {
                log.error("Failed to set field {}: {}", fieldName, e.getMessage());
                throw new IllegalArgumentException(
                    "Failed to set field " + fieldName + ": " + e.getMessage(), e);
            }
        }
    }
    
    /**
     * Find setter method for field
     * 
     * @param messageClass Message class
     * @param setterName Setter method name
     * @param value Value to set (used for type matching)
     * @return Method or null if not found
     */
    private Method findSetter(Class<?> messageClass, String setterName) {
        // Try to find exact match first
        for (Method method : messageClass.getMethods()) {
            if (method.getName().equals(setterName) && 
                method.getParameterCount() == 1) {
                return method;
            }
        }
        return null;
    }
    
    /**
     * Convert value to target type
     * 
     * Handles common conversions:
     * - String to primitive types
     * - Number conversions (Integer to Long, etc.)
     * - String to enum
     * 
     * @param value Original value
     * @param targetType Target type
     * @return Converted value
     */
    private Object convertValue(Object value, Class<?> targetType) {
        if (value == null) {
            return null;
        }
        
        // Already correct type
        if (targetType.isAssignableFrom(value.getClass())) {
            return value;
        }
        
        // String conversions
        if (value instanceof String) {
            String strValue = (String) value;
            
            if (targetType == int.class || targetType == Integer.class) {
                return Integer.parseInt(strValue);
            } else if (targetType == long.class || targetType == Long.class) {
                return Long.parseLong(strValue);
            } else if (targetType == double.class || targetType == Double.class) {
                return Double.parseDouble(strValue);
            } else if (targetType == float.class || targetType == Float.class) {
                return Float.parseFloat(strValue);
            } else if (targetType == boolean.class || targetType == Boolean.class) {
                return Boolean.parseBoolean(strValue);
            } else if (targetType.isEnum()) {
                @SuppressWarnings({"unchecked", "rawtypes"})
                Enum enumValue = Enum.valueOf((Class) targetType, strValue);
                return enumValue;
            }
        }
        
        // Number conversions
        if (value instanceof Number) {
            Number numValue = (Number) value;
            
            if (targetType == int.class || targetType == Integer.class) {
                return numValue.intValue();
            } else if (targetType == long.class || targetType == Long.class) {
                return numValue.longValue();
            } else if (targetType == double.class || targetType == Double.class) {
                return numValue.doubleValue();
            } else if (targetType == float.class || targetType == Float.class) {
                return numValue.floatValue();
            } else if (targetType == short.class || targetType == Short.class) {
                return numValue.shortValue();
            } else if (targetType == byte.class || targetType == Byte.class) {
                return numValue.byteValue();
            }
        }
        
        // Default: return as-is and hope for the best
        return value;
    }
}
