package com.mts.gateway.serialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mts.gateway.classloader.SDPClassLoaderService;
import com.mts.gateway.dto.ClassSchema;
import com.mts.gateway.dto.ClassSchema.FieldSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Generic SMP Serializer
 * 
 * Converts SMP objects to JSON dynamically using reflection.
 * Works with any SMP class loaded at runtime without compile-time dependencies.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class GenericSMPSerializer {
    
    private final SDPClassLoaderService classLoaderService;
    private final ObjectMapper objectMapper;
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    
    /**
     * Serialize SMP object to JSON
     * 
     * @param smpObject Any SMP object instance
     * @param schema ClassSchema for the object
     * @return JSON representation
     */
    public JsonNode serialize(Object smpObject, ClassSchema schema) {
        if (smpObject == null) {
            return null;
        }
        
        try {
            ObjectNode jsonObject = objectMapper.createObjectNode();
            
            // Add CLASS_ID
            if (schema.getClassId() != null) {
                jsonObject.put("CLASS_ID", schema.getClassId());
            }
            
            // Add class name for identification
            jsonObject.put("_className", schema.getSimpleClassName());
            
            // Serialize each field
            for (FieldSchema fieldSchema : schema.getFields()) {
                String fieldName = fieldSchema.getName();
                
                try {
                    Field field = smpObject.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    
                    Object value = field.get(smpObject);
                    
                    if (value != null) {
                        serializeField(jsonObject, fieldName, value, fieldSchema);
                    }
                    
                } catch (NoSuchFieldException e) {
                    log.debug("Field {} not found in object", fieldName);
                } catch (IllegalAccessException e) {
                    log.warn("Cannot access field {}", fieldName, e);
                }
            }
            
            return jsonObject;
            
        } catch (Exception e) {
            log.error("Failed to serialize SMP object", e);
            throw new RuntimeException("Serialization failed", e);
        }
    }
    
    /**
     * Serialize a field based on its schema
     */
    private void serializeField(ObjectNode jsonObject, String fieldName, Object value, FieldSchema fieldSchema) {
        if (value == null) {
            jsonObject.putNull(fieldName);
            return;
        }
        
        String javaType = fieldSchema.getJavaType();
        
        // Handle arrays
        if (fieldSchema.isArray()) {
            serializeArray(jsonObject, fieldName, value);
            return;
        }
        
        // Handle nested objects
        if (fieldSchema.isNested() && fieldSchema.getNestedSchema() != null) {
            JsonNode nestedJson = serialize(value, fieldSchema.getNestedSchema());
            jsonObject.set(fieldName, nestedJson);
            return;
        }
        
        // Handle primitives and common types
        switch (javaType) {
            case "int", "Integer" -> jsonObject.put(fieldName, (Integer) value);
            case "long", "Long" -> jsonObject.put(fieldName, (Long) value);
            case "float", "Float" -> jsonObject.put(fieldName, (Float) value);
            case "double", "Double" -> jsonObject.put(fieldName, (Double) value);
            case "boolean", "Boolean" -> jsonObject.put(fieldName, (Boolean) value);
            case "String" -> jsonObject.put(fieldName, (String) value);
            case "Date" -> jsonObject.put(fieldName, DATE_FORMAT.format((Date) value));
            case "byte", "Byte" -> jsonObject.put(fieldName, (Byte) value);
            case "short", "Short" -> jsonObject.put(fieldName, (Short) value);
            default -> {
                // Try to convert to string
                jsonObject.put(fieldName, value.toString());
            }
        }
    }
    
    /**
     * Serialize array field
     */
    private void serializeArray(ObjectNode jsonObject, String fieldName, Object arrayValue) {
        var arrayNode = objectMapper.createArrayNode();
        
        int length = Array.getLength(arrayValue);
        for (int i = 0; i < length; i++) {
            Object element = Array.get(arrayValue, i);
            
            if (element == null) {
                arrayNode.addNull();
            } else if (element instanceof Integer) {
                arrayNode.add((Integer) element);
            } else if (element instanceof Long) {
                arrayNode.add((Long) element);
            } else if (element instanceof Float) {
                arrayNode.add((Float) element);
            } else if (element instanceof Double) {
                arrayNode.add((Double) element);
            } else if (element instanceof Boolean) {
                arrayNode.add((Boolean) element);
            } else if (element instanceof String) {
                arrayNode.add((String) element);
            } else {
                arrayNode.add(element.toString());
            }
        }
        
        jsonObject.set(fieldName, arrayNode);
    }
    
    /**
     * Serialize list of SMP objects
     */
    public List<JsonNode> serializeList(List<Object> smpObjects, ClassSchema schema) {
        List<JsonNode> jsonList = new ArrayList<>();
        
        for (Object smpObject : smpObjects) {
            jsonList.add(serialize(smpObject, schema));
        }
        
        return jsonList;
    }
    
    /**
     * Serialize to JSON string
     */
    public String serializeToString(Object smpObject, ClassSchema schema) {
        try {
            JsonNode jsonNode = serialize(smpObject, schema);
            return objectMapper.writeValueAsString(jsonNode);
        } catch (Exception e) {
            log.error("Failed to serialize to JSON string", e);
            throw new RuntimeException("Serialization failed", e);
        }
    }
}
