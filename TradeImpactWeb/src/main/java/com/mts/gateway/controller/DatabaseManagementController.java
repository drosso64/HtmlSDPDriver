package com.mts.gateway.controller;


import com.mts.gateway.repository.MarketDataRepository;
import com.mts.gateway.repository.SubscriptionRepository;
import com.mts.gateway.service.ActiveSubscriptionService;
import com.mts.gateway.service.DynamicTableService;
import com.mts.gateway.service.SubscriptionService;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Database Management Controller
 * 
 * Provides endpoints for viewing database statistics and cleaning up data.
 * Useful for testing and debugging.
 */
@Slf4j
@RestController
@RequestMapping("/api/database")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DatabaseManagementController {
    
    private final EntityManager entityManager;
    private final DynamicTableService dynamicTableService; // NEW: For dynamic table management
    private final SubscriptionRepository subscriptionRepository; // For managing subscriptions
    private final SubscriptionService subscriptionService; // For stopping active subscriptions
    private final ActiveSubscriptionService activeSubscriptionService; // For getting active subscriptions in memory
    
    /**
     * Helper method to convert CLOB or String to String
     * H2 returns CLOB fields as Clob objects, not as String
     */
    private String convertToString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Clob) {
            try {
                Clob clob = (Clob) obj;
                Reader reader = clob.getCharacterStream();
                BufferedReader bufferedReader = new BufferedReader(reader);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                bufferedReader.close();
                return sb.toString();
            } catch (Exception e) {
                log.error("Failed to convert CLOB to String: {}", e.getMessage());
                return null;
            }
        }
        // Fallback: toString()
        return obj.toString();
    }
    
    /**
     * Get database statistics
     * Sums records across all market_data_* tables
     */
    @GetMapping("/stats")
    public ResponseEntity<DatabaseStats> getStats() {
        log.info("📊 Database stats request - querying all dynamic tables");
        
        // Discover all market_data_* tables
        String discoverQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES " +
                              "WHERE TABLE_NAME LIKE 'MARKET_DATA_%'";
        
        @SuppressWarnings("unchecked")
        List<Object> rawResults = entityManager.createNativeQuery(discoverQuery).getResultList();
        List<String> tableNames = rawResults.stream()
            .map(Object::toString)
            .collect(Collectors.toList());
        
        log.info("📊 Found {} dynamic tables", tableNames.size());
        
        // Sum record counts across all tables
        long totalRecords = 0;
        LocalDateTime lastUpdate = null;
        
        for (String tableName : tableNames) {
            try {
                // Count records
                String countQuery = "SELECT COUNT(*) FROM " + tableName;
                long count = ((Number) entityManager.createNativeQuery(countQuery).getSingleResult()).longValue();
                totalRecords += count;
                
                // Get latest timestamp
                String timeQuery = "SELECT MAX(received_at) FROM " + tableName;
                Object maxTime = entityManager.createNativeQuery(timeQuery).getSingleResult();
                if (maxTime != null) {
                    LocalDateTime tableLastUpdate = ((java.sql.Timestamp) maxTime).toLocalDateTime();
                    if (lastUpdate == null || tableLastUpdate.isAfter(lastUpdate)) {
                        lastUpdate = tableLastUpdate;
                    }
                }
            } catch (Exception e) {
                log.error("Error querying table {}: {}", tableName, e.getMessage());
            }
        }
        
        log.info("📊 Total records across all tables: {}", totalRecords);
        
        // Estimate size (~1KB per record)
        long estimatedSizeKb = totalRecords > 0 ? totalRecords : 0;
        
        return ResponseEntity.ok(DatabaseStats.builder()
            .marketDataRecords(totalRecords)
            .marketDataSizeKb(estimatedSizeKb)
            .totalSizeKb(estimatedSizeKb)
            .lastUpdate(lastUpdate != null ? lastUpdate.toString() : null)
            .build());
    }
    
    /**
     * Get market data records with pagination from dynamic table
     */
    @GetMapping("/marketdata")
    public ResponseEntity<?> browseMarketData(
        @RequestParam(required = false) Long classId,
        @RequestParam(required = false) String className,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "50") int size
    ) {
        if (classId == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "classId is required"));
        }
        
        String tableName = dynamicTableService.getTableName(classId);
        
        // Check if table exists
        if (!dynamicTableService.tableExists(classId)) {
            log.warn("Table {} does not exist", tableName);
            return ResponseEntity.ok(Map.of(
                "content", List.of(),
                "totalElements", 0,
                "totalPages", 0,
                "number", page,
                "size", size
            ));
        }
        
        // Query dynamic table
        String countQuery = "SELECT COUNT(*) FROM " + tableName;
        long totalElements = ((Number) entityManager.createNativeQuery(countQuery).getSingleResult()).longValue();
        
        int offset = page * size;
        String dataQuery = "SELECT hash_key, class_id, class_name, data, action, received_at, updated_at " +
                          "FROM " + tableName + " " +
                          "ORDER BY received_at DESC " +
                          "LIMIT " + size + " OFFSET " + offset;
        
        @SuppressWarnings("unchecked")
        List<Object[]> results = entityManager.createNativeQuery(dataQuery).getResultList();
        
        List<MarketDataRecordDTO> records = results.stream()
            .map(row -> MarketDataRecordDTO.builder()
                .hashKey(((Number) row[0]).longValue())
                .classId(((Number) row[1]).longValue())
                .className(convertToString(row[2]))
                .jsonData(convertToString(row[3]))
                .action(convertToString(row[4]))
                .receivedAt(row[5] != null ? ((java.sql.Timestamp) row[5]).toLocalDateTime().toString() : null)
                .updatedAt(row[6] != null ? ((java.sql.Timestamp) row[6]).toLocalDateTime().toString() : null)
                .build())
            .collect(Collectors.toList());
        
        int totalPages = (int) Math.ceil((double) totalElements / size);
        
        return ResponseEntity.ok(Map.of(
            "content", records,
            "totalElements", totalElements,
            "totalPages", totalPages,
            "number", page,
            "size", size
        ));
    }
    
    /**
     * Get unique classes with counts from dynamic tables
     */
    @GetMapping("/classes")
    public ResponseEntity<List<ClassSummary>> getClassSummaries() {
        log.info("📁 Fetching class summaries from dynamic tables");
        
        // Discover all market_data_* tables
        String discoverQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES " +
                              "WHERE TABLE_NAME LIKE 'MARKET_DATA_%'";
        
        @SuppressWarnings("unchecked")
        List<Object> rawResults = entityManager.createNativeQuery(discoverQuery).getResultList();
        List<String> tableNames = rawResults.stream()
            .map(Object::toString)
            .collect(Collectors.toList());
        
        log.info("📁 Found {} dynamic tables", tableNames.size());
        
        // Query each table for summary
        List<ClassSummary> summaries = tableNames.stream()
            .map(tableName -> {
                try {
                    // Extract classId from table name (market_data_<classId>)
                    String classIdStr = tableName.replace("MARKET_DATA_", "").replace("market_data_", "");
                    Long classId = Long.parseLong(classIdStr);
                    
                    // Query for class_name, count, and last_update
                    String query = "SELECT class_name, COUNT(*), MAX(received_at) " +
                                  "FROM " + tableName + " " +
                                  "GROUP BY class_name";
                    
                    @SuppressWarnings("unchecked")
                    List<Object[]> results = entityManager.createNativeQuery(query).getResultList();
                    
                    if (!results.isEmpty()) {
                        Object[] row = results.get(0);
                        String className = (String) row[0];
                        long count = ((Number) row[1]).longValue();
                        LocalDateTime lastUpdate = row[2] != null ? ((java.sql.Timestamp) row[2]).toLocalDateTime() : null;
                        
                        return ClassSummary.builder()
                            .classId(classId)
                            .className(className)
                            .recordCount(count)
                            .lastUpdate(lastUpdate != null ? lastUpdate.toString() : null)
                            .build();
                    }
                } catch (Exception e) {
                    log.error("Error processing table {}: {}", tableName, e.getMessage());
                }
                return null;
            })
            .filter(summary -> summary != null)
            .sorted((a, b) -> Long.compare(b.getRecordCount(), a.getRecordCount()))
            .collect(Collectors.toList());
        
        log.info("📁 Returning {} class summaries", summaries.size());
        return ResponseEntity.ok(summaries);
    }
    
    /**
     * Delete all market data from all dynamic tables AND stop all active subscriptions
     */
    @DeleteMapping("/marketdata/all")
    @Transactional
    public ResponseEntity<DeleteResult> deleteAllMarketData() {
        log.warn("⚠️ Deleting ALL market data and stopping all subscriptions");
        
        // 1. Stop all active subscriptions (from in-memory service)
        log.info("🛑 Stopping all active subscriptions...");
        List<ActiveSubscriptionService.UserSubscriptionPair> activeSubscriptions = 
            activeSubscriptionService.getAllActiveSubscriptions();
        int unsubscribeCount = 0;
        for (ActiveSubscriptionService.UserSubscriptionPair pair : activeSubscriptions) {
            try {
                subscriptionService.deleteSubscription(pair.getUsername(), pair.getSubscriptionInfo().getClassId());
                unsubscribeCount++;
                log.info("🛑 Unsubscribed classId {} for user {}", 
                    pair.getSubscriptionInfo().getClassId(), pair.getUsername());
            } catch (Exception e) {
                log.error("Error unsubscribing classId {}: {}", 
                    pair.getSubscriptionInfo().getClassId(), e.getMessage());
            }
        }
        
        // 2. Delete all subscription records from DB (if any)
        long subscriptionsDeleted = subscriptionRepository.count();
        subscriptionRepository.deleteAll();
        log.info("🗑️ Deleted {} subscription records from DB", subscriptionsDeleted);
        
        // 3. Discover all market_data_* tables
        String discoverQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES " +
                              "WHERE TABLE_NAME LIKE 'MARKET_DATA_%'";
        
        @SuppressWarnings("unchecked")
        List<Object> rawResults = entityManager.createNativeQuery(discoverQuery).getResultList();
        List<String> tableNames = rawResults.stream()
            .map(Object::toString)
            .collect(Collectors.toList());
        
        // 4. Delete all records from market data tables
        long totalDeleted = 0;
        for (String tableName : tableNames) {
            try {
                // Count before delete
                String countQuery = "SELECT COUNT(*) FROM " + tableName;
                long count = ((Number) entityManager.createNativeQuery(countQuery).getSingleResult()).longValue();
                
                // Delete all records
                String deleteQuery = "DELETE FROM " + tableName;
                entityManager.createNativeQuery(deleteQuery).executeUpdate();
                
                totalDeleted += count;
                log.info("🗑️ Deleted {} records from {}", count, tableName);
            } catch (Exception e) {
                log.error("Error deleting from table {}: {}", tableName, e.getMessage());
            }
        }
        
        log.info("✅ Total: unsubscribed {} active, deleted {} subscription records, {} market data records from {} tables", 
                 unsubscribeCount, subscriptionsDeleted, totalDeleted, tableNames.size());
        return ResponseEntity.ok(new DeleteResult(totalDeleted, 
            "Stopped " + unsubscribeCount + " active subscriptions and deleted all market data from " + tableNames.size() + " tables"));
    }
    
    /**
     * Delete by classId from dynamic table
     */
    @DeleteMapping("/marketdata/class/{classId}")
    @Transactional
    public ResponseEntity<DeleteResult> deleteByClass(@PathVariable Long classId) {
        log.warn("⚠️ Deleting market data and stopping subscriptions for class: {}", classId);
        
        // 1. Stop all active subscriptions for this class
        log.info("🛑 Stopping subscriptions for classId {}...", classId);
        List<ActiveSubscriptionService.UserSubscriptionPair> activeSubscriptions = 
            activeSubscriptionService.getAllActiveSubscriptions();
        
        int unsubscribeCount = 0;
        for (ActiveSubscriptionService.UserSubscriptionPair pair : activeSubscriptions) {
            if (pair.getSubscriptionInfo().getClassId().equals(classId)) {
                try {
                    subscriptionService.deleteSubscription(pair.getUsername(), classId);
                    unsubscribeCount++;
                    log.info("🛑 Unsubscribed classId {} for user {}", classId, pair.getUsername());
                } catch (Exception e) {
                    log.error("Error unsubscribing classId {} for user {}: {}", 
                        classId, pair.getUsername(), e.getMessage());
                }
            }
        }
        log.info("✅ Stopped {} active subscription(s) for classId {}", unsubscribeCount, classId);
        
        // 2. Delete data from table
        String tableName = dynamicTableService.getTableName(classId);
        
        if (!dynamicTableService.tableExists(classId)) {
            log.warn("Table {} does not exist", tableName);
            return ResponseEntity.ok(new DeleteResult(0, 
                String.format("Stopped %d subscription(s), table does not exist", unsubscribeCount)));
        }
        
        try {
            // Count before delete
            String countQuery = "SELECT COUNT(*) FROM " + tableName;
            long count = ((Number) entityManager.createNativeQuery(countQuery).getSingleResult()).longValue();
            
            // Delete all records from table
            String deleteQuery = "DELETE FROM " + tableName;
            entityManager.createNativeQuery(deleteQuery).executeUpdate();
            
            log.info("✅ Deleted {} records from {}", count, tableName);
            return ResponseEntity.ok(new DeleteResult(count, 
                String.format("Stopped %d subscription(s), deleted %d records for class %d", 
                    unsubscribeCount, count, classId)));
        } catch (Exception e) {
            log.error("Error deleting from {}: {}", tableName, e.getMessage());
            return ResponseEntity.internalServerError()
                .body(new DeleteResult(0, "Error deleting: " + e.getMessage()));
        }
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    public static class DatabaseStats {
        private long marketDataRecords;
        private long marketDataSizeKb;
        private long totalSizeKb;
        private String lastUpdate;
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    public static class ClassSummary {
        private Long classId;
        private String className;
        private long recordCount;
        private String lastUpdate;
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    public static class DeleteResult {
        private long deletedCount;
        private String message;
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    public static class MarketDataRecordDTO {
        private Long hashKey;        // NEW: Primary key from hashKey()
        private Long classId;
        private String className;
        private String jsonData;     // Complete JSON data
        private String action;       // ADD, DEL, RWT, KILL, DATA
        private String receivedAt;   // Timestamp when received
        private String updatedAt;    // Timestamp when last updated (UPSERT)
    }
}
