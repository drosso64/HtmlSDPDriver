package com.mts.gateway.service;

import com.mts.gateway.classloader.SDPClassLoaderService;
import com.mts.gateway.dto.ClassSchema;
import com.mts.gateway.dto.ClassSchema.FieldSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
     * Introspect all fields.
     * 
     * IMPORTANTE: Applica gli STESSI filtri e la STESSA normalizzazione
     * di SMPMessageSerializer.toJson() per garantire consistenza.
     * Se un campo compare nel JSON WebSocket, deve comparire nello schema.
     * Se un campo è filtrato dal JSON WebSocket, non deve essere nello schema.
     */
    private List<FieldSchema> introspectFields(Class<?> clazz) {
        List<FieldSchema> fieldSchemas = new ArrayList<>();
        Set<String> addedNames = new HashSet<>();
        
        // STEP 1: Declared fields - STESSA logica di SMPMessageSerializer.toJson()
        for (Field field : clazz.getDeclaredFields()) {
            // Skip esattamente come SMPMessageSerializer
            if (field.isSynthetic() || 
                field.getName().startsWith("this$") ||
                field.getName().equals("Class") ||
                field.getName().equals("ClassName") ||
                field.getName().equals("cLASS_ID") ||
                field.getName().equals("classid") ||
                field.getName().equals("SMPClassId") ||
                field.getName().equals("CLASS_ID") ||
                field.getName().equals("serialVersionUID")) {
                continue;
            }
            
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers)) {
                continue;
            }
            
            // Normalizza a camelCase come SMPMessageSerializer
            String normalizedName = normalizeFieldName(field.getName());
            if (!addedNames.contains(normalizedName)) {
                addedNames.add(normalizedName);
                fieldSchemas.add(introspectField(field, normalizedName));
            }
        }
        
        // STEP 2: Getter methods - STESSA logica di SMPMessageSerializer.toJson()
        // I getters catturano campi ereditati dalla superclasse che getDeclaredFields() non vede.
        // getMethods() ritorna TUTTI i metodi pubblici, inclusi quelli ereditati.
        for (Method method : clazz.getMethods()) {
            if (!isGetter(method)) continue;
            
            String fieldName = getFieldNameFromGetter(method.getName());
            
            // Skip campi già aggiunti da getDeclaredFields()
            if (addedNames.contains(fieldName)) continue;
            
            // Skip campi interni (stessi filtri di SMPMessageSerializer)
            if (fieldName.equals("class") || 
                fieldName.equals("className") || 
                fieldName.equals("cLASS_ID") ||
                fieldName.equals("classid") ||
                fieldName.equals("sMPClassId")) {
                continue;
            }
            
            addedNames.add(fieldName);
            fieldSchemas.add(introspectFieldFromGetter(method, fieldName));
        }
        
        return fieldSchemas;
    }
    
    /**
     * Verifica se un metodo è un getter (get* o is*).
     * STESSA logica di SMPMessageSerializer.isGetter().
     */
    private boolean isGetter(Method method) {
        if (!method.getName().startsWith("get") && !method.getName().startsWith("is")) {
            return false;
        }
        if (method.getParameterCount() != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }
    
    /**
     * Estrae il nome del campo dal nome del getter.
     * STESSA logica di SMPMessageSerializer.getFieldNameFromGetter().
     */
    private String getFieldNameFromGetter(String methodName) {
        String name = methodName.startsWith("is") 
            ? methodName.substring(2) 
            : methodName.substring(3);
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }
    
    /**
     * Introspect a single field from a getter method (per campi ereditati).
     * Usa il return type del getter come tipo del campo.
     */
    private FieldSchema introspectFieldFromGetter(Method method, String normalizedName) {
        Class<?> fieldType = method.getReturnType();
        String javaTypeName = fieldType.getSimpleName();
        
        // Handle arrays
        boolean isArray = fieldType.isArray();
        Integer arraySize = null;
        if (isArray) {
            fieldType = fieldType.getComponentType();
            javaTypeName = fieldType.getSimpleName() + "[]";
        }
        
        // Handle nested structures
        // Enum NON è nested: viene serializzato come stringa da SMPMessageSerializer
        boolean isNested = !fieldType.isPrimitive() && 
                          !fieldType.isEnum() &&
                          !fieldType.getName().startsWith("java.lang") &&
                          !fieldType.getName().equals("java.util.Date");
        
        ClassSchema nestedSchema = null;
        if (isNested) {
            // Introspect sia per oggetti nested sia per array di oggetti nested
            try {
                nestedSchema = introspectClass(fieldType.getName());
            } catch (Exception e) {
                log.warn("Failed to introspect nested class from getter: {}", fieldType.getName());
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
            .name(normalizedName)
            .javaType(javaTypeName)
            .sqlType(isEnum ? "VARCHAR(255)" : getSqlType(fieldType.getSimpleName()))
            .jsonType(isEnum ? "string" : getJsonType(fieldType.getSimpleName()))
            .required(fieldType.isPrimitive())
            .nullable(!fieldType.isPrimitive())
            .maxLength(javaTypeName.equals("String") ? 255 : null)
            .array(isArray)
            .arraySize(arraySize)
            .nested(isNested)
            .nestedSchema(nestedSchema)
            .enumType(isEnum)
            .enumValues(enumValues)
            .description(normalizedName)
            .metadata(new HashMap<>())
            .build();
    }
    
    /**
     * Normalize field name to camelCase (lowercase first letter).
     * STESSA logica di SMPMessageSerializer.normalizeFieldName().
     */
    private String normalizeFieldName(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) {
            return fieldName;
        }
        return Character.toLowerCase(fieldName.charAt(0)) + fieldName.substring(1);
    }
    
    /**
     * Introspect a single field.
     * 
     * @param field The Java reflection Field
     * @param normalizedName The camelCase-normalized name (consistent with SMPMessageSerializer)
     */
    private FieldSchema introspectField(Field field, String normalizedName) {
        Class<?> fieldType = field.getType();
        String javaTypeName = fieldType.getSimpleName();
        
        // Handle arrays
        boolean isArray = fieldType.isArray();
        Integer arraySize = null;
        if (isArray) {
            fieldType = fieldType.getComponentType();
            javaTypeName = fieldType.getSimpleName() + "[]";
        }
        
        // Handle nested structures
        // Enum NON è nested: viene serializzato come stringa da SMPMessageSerializer
        boolean isNested = !fieldType.isPrimitive() && 
                          !fieldType.isEnum() &&
                          !fieldType.getName().startsWith("java.lang") &&
                          !fieldType.getName().equals("java.util.Date");
        
        ClassSchema nestedSchema = null;
        if (isNested) {
            // Introspect sia per oggetti nested sia per array di oggetti nested
            // Così il frontend conosce la struttura degli elementi anche se l'array è vuoto
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
            .name(normalizedName)  // camelCase, consistente con SMPMessageSerializer
            .javaType(javaTypeName)
            .sqlType(isEnum ? "VARCHAR(255)" : getSqlType(fieldType.getSimpleName()))
            .jsonType(isEnum ? "string" : getJsonType(fieldType.getSimpleName()))
            .required(fieldType.isPrimitive())
            .nullable(!fieldType.isPrimitive())
            .maxLength(javaTypeName.equals("String") ? 255 : null)
            .array(isArray)
            .arraySize(arraySize)
            .nested(isNested)
            .nestedSchema(nestedSchema)
            .enumType(isEnum)
            .enumValues(enumValues)
            .description(normalizedName)
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
