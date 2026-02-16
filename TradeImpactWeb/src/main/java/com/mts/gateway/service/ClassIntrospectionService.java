package com.mts.gateway.service;

import com.mts.gateway.classloader.SDPClassLoaderService;
import com.mts.gateway.dto.ClassSchema;
import com.mts.gateway.dto.ClassSchema.FieldSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class Introspection Service
 * 
 * Uses reflection to analyze SMP classes dynamically and extract field metadata.
 * This service operates entirely on runtime classes loaded via SDPClassLoaderService
 * without any compile-time dependencies on market-specific classes.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ClassIntrospectionService {
    
    private final SDPClassLoaderService classLoaderService;
    
    // Cache for introspected schemas
    private final Map<String, ClassSchema> schemaCache = new ConcurrentHashMap<>();
    
    // XDR type to SQL type mapping
    private static final Map<String, String> XDR_TO_SQL_TYPE = Map.ofEntries(
        Map.entry("int", "INTEGER"),
        Map.entry("long", "BIGINT"),
        Map.entry("float", "REAL"),
        Map.entry("double", "DOUBLE"),
        Map.entry("boolean", "BOOLEAN"),
        Map.entry("byte", "TINYINT"),
        Map.entry("short", "SMALLINT"),
        Map.entry("String", "VARCHAR"),
        Map.entry("Date", "TIMESTAMP"),
        Map.entry("byte[]", "VARBINARY")
    );
    
    // Java type to JSON type mapping
    private static final Map<String, String> JAVA_TO_JSON_TYPE = Map.ofEntries(
        Map.entry("int", "number"),
        Map.entry("long", "number"),
        Map.entry("float", "number"),
        Map.entry("double", "number"),
        Map.entry("boolean", "boolean"),
        Map.entry("byte", "number"),
        Map.entry("short", "number"),
        Map.entry("String", "string"),
        Map.entry("Date", "string"),
        Map.entry("Integer", "number"),
        Map.entry("Long", "number"),
        Map.entry("Float", "number"),
        Map.entry("Double", "number"),
        Map.entry("Boolean", "boolean"),
        Map.entry("Byte", "number"),
        Map.entry("Short", "number")
    );
    
    /**
     * Introspect a class by name and generate its schema
     * 
     * @param className Fully qualified class name
     * @return ClassSchema with complete field information
     */
    public ClassSchema introspectClass(String className) {
        // Check cache first
        ClassSchema cached = schemaCache.get(className);
        if (cached != null) {
            log.debug("Returning cached schema for class: {}", className);
            return cached;
        }
        
        try {
            log.info("Introspecting class: {}", className);
            
            // Load the class dynamically
            Class<?> clazz = classLoaderService.loadClass(className);
            
            // Extract CLASS_ID constant
            Long classId = extractClassId(clazz);
            
            // Introspect all fields
            List<FieldSchema> fields = introspectFields(clazz);
            
            // Build schema
            ClassSchema schema = ClassSchema.builder()
                .classId(classId)
                .className(className)
                .simpleClassName(clazz.getSimpleName())
                .description(extractDescription(clazz))
                .market(extractMarket(className))
                .fields(fields)
                .primaryKeys(extractPrimaryKeys(fields))
                .supportedActions(extractSupportedActions(clazz))
                .subscribable(isSubscribable(clazz))
                .transactional(isTransactional(clazz))
                .metadata(new HashMap<>())
                .build();
            
            // Cache the schema
            schemaCache.put(className, schema);
            
            log.info("Successfully introspected class: {} with {} fields", className, fields.size());
            
            return schema;
            
        } catch (Exception e) {
            log.error("Failed to introspect class: {}", className, e);
            throw new RuntimeException("Class introspection failed for: " + className, e);
        }
    }
    
    /**
     * Extract CLASS_ID constant from SMP class
     */
    private Long extractClassId(Class<?> clazz) {
        try {
            Field classIdField = clazz.getDeclaredField("CLASS_ID");
            classIdField.setAccessible(true);
            return (Long) classIdField.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.warn("CLASS_ID not found in class: {}", clazz.getName());
            return null;
        }
    }
    
    /**
     * Extract description from class javadoc or annotations
     */
    private String extractDescription(Class<?> clazz) {
        // In a full implementation, this would parse Javadoc or custom annotations
        return clazz.getSimpleName().replaceAll("_", " ");
    }
    
    /**
     * Extract market identifier from package name
     */
    private String extractMarket(String className) {
        // Example: com.mtsmarkets.sdp.smp.bvf.BV_DEAL -> BV
        if (className.contains(".bvf.")) return "BV";
        if (className.contains(".cmf.")) return "CMF";
        if (className.contains(".mmf.")) return "MMF";
        if (className.contains(".paf.")) return "PAF";
        return "UNKNOWN";
    }
    
    /**
     * Introspect all non-static, non-final fields
     */
    private List<FieldSchema> introspectFields(Class<?> clazz) {
        List<FieldSchema> fieldSchemas = new ArrayList<>();
        
        // Get all declared fields (including private)
        Field[] fields = clazz.getDeclaredFields();
        
        for (Field field : fields) {
            // Skip static and final fields
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers)) {
                continue;
            }
            
            // Skip CLASS_ID and other constants
            if (field.getName().equals("CLASS_ID") || field.getName().equals("serialVersionUID")) {
                continue;
            }
            
            FieldSchema fieldSchema = introspectField(field);
            fieldSchemas.add(fieldSchema);
        }
        
        return fieldSchemas;
    }
    
    /**
     * Introspect a single field
     */
    private FieldSchema introspectField(Field field) {
        Class<?> fieldType = field.getType();
        String javaTypeName = fieldType.getSimpleName();
        
        // Handle arrays
        boolean isArray = fieldType.isArray();
        Integer arraySize = null;
        if (isArray) {
            fieldType = fieldType.getComponentType();
            javaTypeName = fieldType.getSimpleName() + "[]";
            // Array size would be extracted from annotations or XDR metadata
        }
        
        // Handle nested structures
        boolean isNested = !fieldType.isPrimitive() && 
                          !fieldType.getName().startsWith("java.lang") &&
                          !fieldType.getName().equals("java.util.Date");
        
        ClassSchema nestedSchema = null;
        if (isNested && !isArray) {
            try {
                nestedSchema = introspectClass(fieldType.getName());
            } catch (Exception e) {
                log.warn("Failed to introspect nested class: {}", fieldType.getName());
            }
        }
        
        // Handle enums
        boolean isEnum = fieldType.isEnum();
        List<String> enumValues = null;
        if (isEnum) {
            enumValues = Arrays.stream(fieldType.getEnumConstants())
                .map(Object::toString)
                .toList();
        }
        
        return FieldSchema.builder()
            .name(field.getName())
            .javaType(javaTypeName)
            .sqlType(getSqlType(fieldType.getSimpleName()))
            .jsonType(getJsonType(fieldType.getSimpleName()))
            .required(fieldType.isPrimitive()) // Primitives are always required
            .nullable(!fieldType.isPrimitive())
            .maxLength(javaTypeName.equals("String") ? 255 : null)
            .array(isArray)
            .arraySize(arraySize)
            .nested(isNested)
            .nestedSchema(nestedSchema)
            .enumType(isEnum)
            .enumValues(enumValues)
            .description(field.getName())
            .metadata(new HashMap<>())
            .build();
    }
    
    /**
     * Map Java type to SQL type
     */
    private String getSqlType(String javaType) {
        return XDR_TO_SQL_TYPE.getOrDefault(javaType, "VARCHAR(255)");
    }
    
    /**
     * Map Java type to JSON type
     */
    private String getJsonType(String javaType) {
        return JAVA_TO_JSON_TYPE.getOrDefault(javaType, "object");
    }
    
    /**
     * Extract primary keys from fields
     * In a full implementation, this would read from annotations or TI_DESC_CLASS metadata
     */
    private List<String> extractPrimaryKeys(List<FieldSchema> fields) {
        // Common primary key patterns in SDP
        List<String> primaryKeys = new ArrayList<>();
        
        for (FieldSchema field : fields) {
            String name = field.getName().toLowerCase();
            if (name.contains("id") || name.contains("key") || name.equals("isin")) {
                primaryKeys.add(field.getName());
            }
        }
        
        return primaryKeys.isEmpty() ? List.of("id") : primaryKeys;
    }
    
    /**
     * Extract supported actions from class
     */
    private List<String> extractSupportedActions(Class<?> clazz) {
        // In a full implementation, this would check for method presence or annotations
        // For now, return common actions
        return List.of("ADD", "DEL", "RWT", "KILL");
    }
    
    /**
     * Check if class is subscribable
     */
    private boolean isSubscribable(Class<?> clazz) {
        // In a full implementation, check for subscription-related methods or annotations
        // Most SMP classes are subscribable
        return true;
    }
    
    /**
     * Check if class supports transactions
     */
    private boolean isTransactional(Class<?> clazz) {
        // In a full implementation, check for transaction-related methods
        // Classes with ADD/DEL/RWT/KILL typically support transactions
        return true;
    }
    
    /**
     * Clear schema cache (useful after JAR reload)
     */
    public void clearCache() {
        log.info("Clearing class schema cache");
        schemaCache.clear();
    }
    
    /**
     * Get all cached schemas
     */
    public Collection<ClassSchema> getCachedSchemas() {
        return new ArrayList<>(schemaCache.values());
    }
}
