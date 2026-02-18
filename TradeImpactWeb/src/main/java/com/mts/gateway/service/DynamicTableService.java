package com.mts.gateway.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service for managing dynamic table creation per SDP class.
 * 
 * Each subscribed class gets its own table: market_data_<classId>
 * with hash_key as primary key and JSON data storage.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DynamicTableService {
    
    private final EntityManager entityManager;
    
    // Cache of created tables: classId -> true
    private final Map<Long, Boolean> createdTables = new ConcurrentHashMap<>();
    
    /**
     * Ensure table exists for the given class ID.
     * Creates table on first call, subsequent calls are no-op (cached).
     * 
     * @param classId The SDP CLASS_ID
     */
    @Transactional
    public void ensureTableExists(Long classId) {
        if (createdTables.containsKey(classId)) {
            return;  // Already created
        }
        
        synchronized (this) {
            // Double-check pattern
            if (createdTables.containsKey(classId)) {
                return;
            }
            
            createTable(classId);
            createdTables.put(classId, true);
            log.info("✅ Created table for class {}", classId);
        }
    }
    
    /**
     * Create the table with standard schema:
     * - hash_key BIGINT PRIMARY KEY (from hashKey() method)
     * - class_id, class_name for reference
     * - data CLOB for complete JSON record
     * - action VARCHAR(10) for ADD/DEL/RWT/KILL
     * - timestamps for auditing
     */
    private void createTable(Long classId) {
        String tableName = "market_data_" + classId;
        
        StringBuilder ddl = new StringBuilder();
        ddl.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (");
        ddl.append("  hash_key BIGINT PRIMARY KEY,");
        ddl.append("  class_id BIGINT NOT NULL,");
        ddl.append("  class_name VARCHAR(255) NOT NULL,");
        ddl.append("  data CLOB NOT NULL,");
        ddl.append("  action VARCHAR(10),");
        ddl.append("  received_at TIMESTAMP NOT NULL,");
        ddl.append("  updated_at TIMESTAMP");
        ddl.append(")");
        
        try {
            entityManager.createNativeQuery(ddl.toString()).executeUpdate();
            
            // Create index on received_at for chronological queries
            String indexDdl = "CREATE INDEX IF NOT EXISTS idx_" + tableName + "_received " +
                            "ON " + tableName + " (received_at DESC)";
            entityManager.createNativeQuery(indexDdl).executeUpdate();
            
            log.info("📊 Created table {} with hash_key primary key", tableName);
            
        } catch (Exception e) {
            log.error("❌ Failed to create table {}: {}", tableName, e.getMessage(), e);
            throw new RuntimeException("Failed to create table for class " + classId, e);
        }
    }
    
    /**
     * Check if table exists for a class (useful for queries)
     */
    public boolean tableExists(Long classId) {
        if (createdTables.containsKey(classId)) {
            return true;
        }
        
        // Query INFORMATION_SCHEMA to check if table exists
        String tableName = "market_data_" + classId;
        String query = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES " +
                      "WHERE TABLE_NAME = ? AND TABLE_SCHEMA = 'PUBLIC'";
        
        try {
            Long count = (Long) entityManager.createNativeQuery(query)
                .setParameter(1, tableName.toUpperCase())
                .getSingleResult();
            
            boolean exists = count > 0;
            if (exists) {
                createdTables.put(classId, true);
            }
            return exists;
            
        } catch (Exception e) {
            log.warn("Error checking table existence for class {}: {}", classId, e.getMessage());
            return false;
        }
    }
    
    /**
     * Get table name for a class
     */
    public String getTableName(Long classId) {
        return "market_data_" + classId;
    }
    
    /**
     * Clear the cache (useful for testing)
     */
    public void clearCache() {
        createdTables.clear();
        log.info("Cleared table creation cache");
    }
}
