package com.mts.gateway.service;

import com.mts.gateway.classloader.SDPClassLoaderService;
import com.mts.gateway.dto.ClassInfo;
import com.mts.gateway.dto.TransactionRequest;
import com.mts.gateway.dto.TransactionResponse;
import com.mts.gateway.repository.ClassMetadataRepository;
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
    private final ClassMetadataRepository classMetadataRepository;
    
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
        
        try {
            // Create SMP message from request data
            SMPMessage smpMessage = createSMPMessage(request);
            
            // Send transaction and wait for response
            CompletableFuture<TransactionResponse> responseFuture = 
                connection.sendTransaction(smpMessage, request.getAction().name());
            
            // Wait for response with timeout
            TransactionResponse response = responseFuture.get(30, TimeUnit.SECONDS);
            response.setReferenceId(request.getReferenceId());
            
            return response;
        } finally {
            connectionPool.releaseConnection(connection);
        }
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
        
        try {
            SMPMessage smpMessage = createSMPMessage(request);
            
            CompletableFuture<TransactionResponse> responseFuture = 
                connection.sendMonitoredTransaction(smpMessage, request.getAction().name());
            
            TransactionResponse response = responseFuture.get(30, TimeUnit.SECONDS);
            response.setReferenceId(request.getReferenceId());
            
            // Risolvi il nome classe dal resClassId (se presente nella risposta)
            if (response.getResClassId() != null && response.getResClassId() != 0) {
                ClassInfo resClassInfo = classMetadataRepository.getClassInfo(response.getResClassId());
                if (resClassInfo != null) {
                    response.setResClassName(resClassInfo.getSimpleClassName());
                }
            }
            
            return response;
        } finally {
            connectionPool.releaseConnection(connection);
        }
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
        
        try {
            SMPMessage smpMessage = createSMPMessage(request);
            
            CompletableFuture<TransactionResponse> responseFuture = 
                connection.sendExtendedTransaction(smpMessage, request.getAction().name());
            
            TransactionResponse response = responseFuture.get(30, TimeUnit.SECONDS);
            response.setReferenceId(request.getReferenceId());
            
            return response;
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
    
    /**
     * Create SMP message from transaction request
     * 
     * Risolve il className dal classId numerico via ClassMetadataRepository,
     * poi usa SDPClassLoaderService.loadClass() che gestisce sia FQN che nomi semplici.
     * 
     * @param request Transaction request con classId numerico
     * @return SMPMessage instance
     */
    private SMPMessage createSMPMessage(TransactionRequest request) throws Exception {
        // Lookup ClassInfo dal classId numerico
        ClassInfo classInfo = classMetadataRepository.getClassInfo(request.getClassId());
        if (classInfo == null) {
            throw new IllegalArgumentException(
                "Class not found for classId: " + request.getClassId());
        }
        
        // Carica la classe Java usando il className (supporta sia FQN che nomi semplici)
        Class<?> messageClass = classLoaderService.loadClass(classInfo.getClassName());
        
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
            // I nomi arrivano in camelCase dal frontend (es. "memberId")
            // Il setter Java è "setMemberId" → prima lettera maiuscola
            String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
            
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
        
        // Sanitizzazione: SDP non supporta null.
        // Itera tutti i getter/setter della classe e sostituisce i null rimasti
        // (sia da campi non inviati dal frontend, sia da default BVF nulli)
        for (Method getter : messageClass.getMethods()) {
            String getterName = getter.getName();
            if (!getterName.startsWith("get") || getter.getParameterCount() != 0) {
                continue;
            }
            // Ignora metodi di Object e SMPMessage base
            if (getter.getDeclaringClass() == Object.class || 
                getterName.equals("getClass") || getterName.equals("getSMPClassId")) {
                continue;
            }
            try {
                Object currentValue = getter.invoke(message);
                if (currentValue == null) {
                    Class<?> returnType = getter.getReturnType();
                    String setterName = "s" + getterName.substring(1); // getX → setX
                    Method setter = findSetter(messageClass, setterName);
                    if (setter != null) {
                        Object defaultValue = convertValue(null, setter.getParameterTypes()[0]);
                        if (defaultValue != null) {
                            setter.invoke(message, defaultValue);
                            log.debug("Sanitized null field {} → {}", getterName.substring(3), defaultValue);
                        }
                    }
                }
            } catch (Exception e) {
                log.debug("Could not sanitize field {}: {}", getterName, e.getMessage());
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
        // Try exact match first
        for (Method method : messageClass.getMethods()) {
            if (method.getName().equals(setterName) && 
                method.getParameterCount() == 1) {
                return method;
            }
        }
        // Fallback: case-insensitive match
        for (Method method : messageClass.getMethods()) {
            if (method.getName().equalsIgnoreCase(setterName) && 
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
        // SDP non supporta valori null: numeri → 0, stringhe → "", enum → primo valore
        if (value == null) {
            if (targetType == String.class) {
                return "";
            } else if (targetType == int.class || targetType == Integer.class) {
                return 0;
            } else if (targetType == long.class || targetType == Long.class) {
                return 0L;
            } else if (targetType == double.class || targetType == Double.class) {
                return 0.0;
            } else if (targetType == float.class || targetType == Float.class) {
                return 0.0f;
            } else if (targetType == short.class || targetType == Short.class) {
                return (short) 0;
            } else if (targetType == byte.class || targetType == Byte.class) {
                return (byte) 0;
            } else if (targetType == boolean.class || targetType == Boolean.class) {
                return false;
            } else if (targetType.isEnum()) {
                Object[] constants = targetType.getEnumConstants();
                return (constants != null && constants.length > 0) ? constants[0] : null;
            }
            return null;
        }
        
        // Already correct type
        if (targetType.isAssignableFrom(value.getClass())) {
            return value;
        }
        
        // Enum conversions - usa rappresentazione intera (ordinal)
        // Gli enum BVF hanno getEnum(int) e setValue(int) per il valore intero.
        // Usiamo sempre la rappresentazione intera per consentire anche valori non previsti.
        if (targetType.isEnum()) {
            try {
                int intValue;
                if (value instanceof Number) {
                    intValue = ((Number) value).intValue();
                } else {
                    intValue = Integer.parseInt(value.toString());
                }
                
                // Usa il metodo statico getEnum(int) disponibile su tutti gli enum BVF
                Method getEnumMethod = targetType.getMethod("getEnum", int.class);
                Object enumInstance = getEnumMethod.invoke(null, intValue);
                
                // Verifica che il valore dell'enum corrisponda a quello richiesto.
                // getEnum() tronca i valori fuori range a values()[0]
                Method getValueMethod = targetType.getMethod("getValue");
                int actualValue = (int) getValueMethod.invoke(enumInstance);
                
                if (actualValue != intValue) {
                    // Fuori range: forza il valore intero desiderato
                    Method setValueMethod = targetType.getMethod("setValue", int.class);
                    setValueMethod.invoke(enumInstance, intValue);
                }
                
                return enumInstance;
            } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                // Fallback per enum senza getEnum(int) - non dovrebbe succedere con enum BVF
                log.warn("Enum {} does not have getEnum(int), trying valueOf", targetType.getSimpleName());
                @SuppressWarnings({"unchecked", "rawtypes"})
                Enum enumValue = Enum.valueOf((Class) targetType, value.toString());
                return enumValue;
            } catch (NumberFormatException e) {
                // Il valore non è numerico, prova valueOf per nome
                @SuppressWarnings({"unchecked", "rawtypes"})
                Enum enumValue = Enum.valueOf((Class) targetType, value.toString());
                return enumValue;
            }
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
            } else if (targetType == short.class || targetType == Short.class) {
                return Short.parseShort(strValue);
            } else if (targetType == boolean.class || targetType == Boolean.class) {
                return Boolean.parseBoolean(strValue);
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
