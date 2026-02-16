package com.mts.gateway.dto;

import lombok.Data;
import lombok.Builder;
import java.util.List;
import java.util.Map;

/**
 * Class Schema DTO
 * 
 * Represents the complete structure of an SMP class including:
 * - Fields with types and constraints
 * - Primary/foreign keys
 * - Supported actions (ADD, DEL, RWT, KILL)
 * - Nested structures
 */
@Data
@Builder
public class ClassSchema {
    
    /**
     * SMP Class ID (unique identifier)
     */
    private Long classId;
    
    /**
     * Fully qualified class name (e.g., "com.mtsmarkets.sdp.smp.bvf.BV_DEAL")
     */
    private String className;
    
    /**
     * Simple class name (e.g., "BV_DEAL")
     */
    private String simpleClassName;
    
    /**
     * Human-readable description
     */
    private String description;
    
    /**
     * Market identifier (CMF, BV, MMF, PAF)
     */
    private String market;
    
    /**
     * List of fields in the class
     */
    private List<FieldSchema> fields;
    
    /**
     * Primary key fields
     */
    private List<String> primaryKeys;
    
    /**
     * Supported actions
     */
    private List<String> supportedActions;
    
    /**
     * Whether this class can be subscribed
     */
    private boolean subscribable;
    
    /**
     * Whether this class supports transactions
     */
    private boolean transactional;
    
    /**
     * Additional metadata
     */
    private Map<String, Object> metadata;
    
    /**
     * Field Schema
     */
    @Data
    @Builder
    public static class FieldSchema {
        
        /**
         * Field name
         */
        private String name;
        
        /**
         * Java type name
         */
        private String javaType;
        
        /**
         * SQL type for database storage
         */
        private String sqlType;
        
        /**
         * JSON type for serialization
         */
        private String jsonType;
        
        /**
         * Whether field is required
         */
        private boolean required;
        
        /**
         * Whether field is nullable
         */
        private boolean nullable;
        
        /**
         * Maximum length (for strings)
         */
        private Integer maxLength;
        
        /**
         * Minimum value (for numbers)
         */
        private Object minValue;
        
        /**
         * Maximum value (for numbers)
         */
        private Object maxValue;
        
        /**
         * Default value
         */
        private Object defaultValue;
        
        /**
         * Whether this is an array field
         */
        private boolean array;
        
        /**
         * Array dimensions (if array)
         */
        private Integer arraySize;
        
        /**
         * Whether this is a nested structure
         */
        private boolean nested;
        
        /**
         * Nested class schema (if nested)
         */
        private ClassSchema nestedSchema;
        
        /**
         * Whether this is an enum
         */
        private boolean enumType;
        
        /**
         * Enum values (if enum)
         */
        private List<String> enumValues;
        
        /**
         * Field description
         */
        private String description;
        
        /**
         * Additional metadata
         */
        private Map<String, Object> metadata;
    }
}
