package com.mts.gateway.serialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mts.gateway.classloader.SDPClassLoaderService;
import com.mts.gateway.dto.ClassSchema;
import com.mts.gateway.dto.ClassSchema.FieldSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Generic SMP Deserializer
 * 
 * Converts JSON to SMP objects dynamically using reflection.
 * Works with any SMP class loaded at runtime without compile-time dependencies.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class GenericSMPDeserializer {
    
    private final SDPClassLoaderService classLoaderService;
    private final ObjectMapper objectMapper;
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    
    /**
     * Deserialize JSON to SMP object
     * 
     * @param jsonNode JSON representation
     * @param schema ClassSchema for target class
     * @return SMP object instance
     */
    public Object deserialize(JsonNode jsonNode, ClassSchema schema) {
        if (jsonNode == null || jsonNode.isNull()) {
            return null;
        }
        
        try {
            // Load the class dynamically
            Class<?> smpClass = classLoaderService.loadClass(schema.getClassName());
            
            // Create instance
            Object smpObject = smpClass.getDeclaredConstructor().newInstance();
            
            // Deserialize each field
            for (FieldSchema fieldSchema : schema.getFields()) {
                String fieldName = fieldSchema.getName();
                
                if (!jsonNode.has(fieldName)) {
                    continue;
                }
                
                JsonNode fieldValue = jsonNode.get(fieldName);
                
                try {
                    Field field = smpClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    
                    Object value = deserializeField(fieldValue, fieldSchema);
                    
                    if (value != null) {
                        field.set(smpObject, value);
                    }
                    
                } catch (NoSuchFieldException e) {
                    log.debug("Field {} not found in class {}", fieldName, schema.getClassName());
                } catch (IllegalAccessException e) {
                    log.warn("Cannot set field {}", fieldName, e);
                }
            }
            
            return smpObject;
            
        } catch (Exception e) {
            log.error("Failed to deserialize JSON to SMP object", e);
            throw new RuntimeException("Deserialization failed", e);
        }
    }
    
    /**
     * Deserialize a field based on its schema
     */
    private Object deserializeField(JsonNode fieldValue, FieldSchema fieldSchema) {
        if (fieldValue == null || fieldValue.isNull()) {
            return null;
        }
        
        String javaType = fieldSchema.getJavaType();
        
        // Handle arrays
        if (fieldSchema.isArray()) {
            return deserializeArray(fieldValue, fieldSchema);
        }
        
        // Handle nested objects
        if (fieldSchema.isNested() && fieldSchema.getNestedSchema() != null) {
            return deserialize(fieldValue, fieldSchema.getNestedSchema());
        }
        
        // Handle primitives and common types
        try {
            return switch (javaType) {
                case "int" -> fieldValue.asInt();
                case "Integer" -> fieldValue.isNull() ? null : fieldValue.asInt();
                case "long" -> fieldValue.asLong();
                case "Long" -> fieldValue.isNull() ? null : fieldValue.asLong();
                case "float" -> (float) fieldValue.asDouble();
                case "Float" -> fieldValue.isNull() ? null : (float) fieldValue.asDouble();
                case "double" -> fieldValue.asDouble();
                case "Double" -> fieldValue.isNull() ? null : fieldValue.asDouble();
                case "boolean" -> fieldValue.asBoolean();
                case "Boolean" -> fieldValue.isNull() ? null : fieldValue.asBoolean();
                case "String" -> fieldValue.asText();
                case "Date" -> DATE_FORMAT.parse(fieldValue.asText());
                case "byte" -> (byte) fieldValue.asInt();
                case "Byte" -> fieldValue.isNull() ? null : (byte) fieldValue.asInt();
                case "short" -> (short) fieldValue.asInt();
                case "Short" -> fieldValue.isNull() ? null : (short) fieldValue.asInt();
                default -> fieldValue.asText();
            };
        } catch (Exception e) {
            log.warn("Failed to deserialize field type {}: {}", javaType, e.getMessage());
            return null;
        }
    }
    
    /**
     * Deserialize array field
     */
    private Object deserializeArray(JsonNode arrayNode, FieldSchema fieldSchema) {
        if (!arrayNode.isArray()) {
            return null;
        }
        
        // Get component type
        String componentType = fieldSchema.getJavaType().replace("[]", "");
        
        int size = arrayNode.size();
        Object array = createArray(componentType, size);
        
        for (int i = 0; i < size; i++) {
            JsonNode element = arrayNode.get(i);
            
            if (element.isNull()) {
                continue;
            }
            
            Object value = deserializeArrayElement(element, componentType);
            if (value != null) {
                Array.set(array, i, value);
            }
        }
        
        return array;
    }
    
    /**
     * Create typed array
     */
    private Object createArray(String componentType, int size) {
        return switch (componentType) {
            case "int" -> new int[size];
            case "long" -> new long[size];
            case "float" -> new float[size];
            case "double" -> new double[size];
            case "boolean" -> new boolean[size];
            case "byte" -> new byte[size];
            case "short" -> new short[size];
            case "String" -> new String[size];
            case "Integer" -> new Integer[size];
            case "Long" -> new Long[size];
            case "Float" -> new Float[size];
            case "Double" -> new Double[size];
            case "Boolean" -> new Boolean[size];
            case "Byte" -> new Byte[size];
            case "Short" -> new Short[size];
            default -> new Object[size];
        };
    }
    
    /**
     * Deserialize array element
     */
    private Object deserializeArrayElement(JsonNode element, String componentType) {
        return switch (componentType) {
            case "int", "Integer" -> element.asInt();
            case "long", "Long" -> element.asLong();
            case "float", "Float" -> (float) element.asDouble();
            case "double", "Double" -> element.asDouble();
            case "boolean", "Boolean" -> element.asBoolean();
            case "String" -> element.asText();
            case "byte", "Byte" -> (byte) element.asInt();
            case "short", "Short" -> (short) element.asInt();
            default -> element.asText();
        };
    }
    
    /**
     * Deserialize from JSON string
     */
    public Object deserializeFromString(String jsonString, ClassSchema schema) {
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            return deserialize(jsonNode, schema);
        } catch (Exception e) {
            log.error("Failed to deserialize JSON string", e);
            throw new RuntimeException("Deserialization failed", e);
        }
    }
}
