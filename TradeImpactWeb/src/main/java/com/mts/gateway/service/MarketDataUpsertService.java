package com.mts.gateway.service;

import com.mts.gateway.util.SMPMessageSerializer;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * Service for upserting market data to dynamic class-specific tables.
 * 
 * Uses hashKey() method from SDP objects to implement INSERT/UPDATE logic.
 * If hash_key exists in table → UPDATE, otherwise → INSERT.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MarketDataUpsertService {
    
    private final EntityManager entityManager;
    private final DynamicTableService dynamicTableService;
    
    /**
     * Upsert market data record.
     * Asynchronous to avoid blocking WebSocket broadcast.
     * 
     * @param classId SDP CLASS_ID
     * @param className Simple class name
     * @param smpObject The SDP message object
     * @param action Action type (ADD, DEL, RWT, KILL)
     */
    @Async
    @Transactional
    public void upsertMarketData(Long classId, String className, Object smpObject, String action) {
        try {
            // 1. Ensure table exists
            dynamicTableService.ensureTableExists(classId);
            
            // 2. Extract hash key from object
            long hashKey = extractHashKey(smpObject);
            
            // 3. Serialize to JSON
            String jsonData = SMPMessageSerializer.toJson(smpObject);
            
            // 4. UPSERT via MERGE statement
            String tableName = dynamicTableService.getTableName(classId);
            
            String sql = "MERGE INTO " + tableName + " " +
                        "(hash_key, class_id, class_name, data, action, received_at, updated_at) " +
                        "KEY (hash_key) " +
                        "VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, NULL)";
            
            entityManager.createNativeQuery(sql)
                .setParameter(1, hashKey)
                .setParameter(2, classId)
                .setParameter(3, className)
                .setParameter(4, jsonData)
                .setParameter(5, action)
                .executeUpdate();
            
            log.debug("💾 UPSERT class {} hash_key={} action={}", className, hashKey, action);
            
        } catch (Exception e) {
            log.error("❌ Failed to upsert market data for class {}: {}", className, e.getMessage(), e);
        }
    }
    
    /**
     * Extract hash key from SDP object via reflection.
     * Calls the hashKey() method which returns a long.
     * 
     * @param smpObject The SDP message object
     * @return The hash key value
     * @throws RuntimeException if hashKey() method not found or invocation fails
     */
    private long extractHashKey(Object smpObject) {
        try {
            Method hashKeyMethod = smpObject.getClass().getMethod("hashKey");
            Object result = hashKeyMethod.invoke(smpObject);
            
            if (result instanceof Long) {
                return (Long) result;
            } else if (result instanceof Integer) {
                return ((Integer) result).longValue();
            } else {
                throw new IllegalStateException("hashKey() returned unexpected type: " + result.getClass());
            }
            
        } catch (NoSuchMethodException e) {
            log.error("❌ Class {} does not have hashKey() method", smpObject.getClass().getName());
            throw new RuntimeException("hashKey() method not found on " + smpObject.getClass().getName(), e);
            
        } catch (Exception e) {
            log.error("❌ Failed to invoke hashKey() on {}: {}", 
                smpObject.getClass().getName(), e.getMessage());
            throw new RuntimeException("Failed to extract hash key", e);
        }
    }
    
    /**
     * Delete a record by hash key.
     * Used when receiving DEL action.
     * 
     * @param classId SDP CLASS_ID
     * @param hashKey The hash key to delete
     */
    @Transactional
    public void deleteByHashKey(Long classId, long hashKey) {
        if (!dynamicTableService.tableExists(classId)) {
            log.warn("⚠️ Table for class {} does not exist, cannot delete", classId);
            return;
        }
        
        try {
            String tableName = dynamicTableService.getTableName(classId);
            String sql = "DELETE FROM " + tableName + " WHERE hash_key = ?";
            
            int deleted = entityManager.createNativeQuery(sql)
                .setParameter(1, hashKey)
                .executeUpdate();
            
            if (deleted > 0) {
                log.debug("🗑️ Deleted hash_key={} from class {}", hashKey, classId);
            }
            
        } catch (Exception e) {
            log.error("❌ Failed to delete hash_key={} from class {}: {}", 
                hashKey, classId, e.getMessage());
        }
    }
}
