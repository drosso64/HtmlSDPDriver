package com.mts.gateway.controller;

import com.mts.gateway.entity.MarketDataRecord;
import com.mts.gateway.repository.MarketDataRepository;
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
import org.springframework.web.bind.annotation.*;

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
    
    private final MarketDataRepository marketDataRepository;
    private final EntityManager entityManager;
    
    /**
     * Get database statistics
     */
    @GetMapping("/stats")
    public ResponseEntity<DatabaseStats> getStats() {
        long marketDataCount = marketDataRepository.count();
        log.info("📊 Database stats request - total records: {}", marketDataCount);
        
        // For H2, calculate approximate size based on record count
        // Assume ~1KB per record on average
        long estimatedSizeKb = marketDataCount > 0 ? marketDataCount : 0;
        
        LocalDateTime lastUpdate = marketDataRepository.findTopByOrderByReceivedAtDesc()
            .map(MarketDataRecord::getReceivedAt)
            .orElse(null);
        
        return ResponseEntity.ok(DatabaseStats.builder()
            .marketDataRecords(marketDataCount)
            .marketDataSizeKb(estimatedSizeKb)
            .totalSizeKb(estimatedSizeKb)
            .lastUpdate(lastUpdate != null ? lastUpdate.toString() : null)
            .build());
    }
    
    /**
     * Get market data records with pagination
     */
    @GetMapping("/marketdata")
    public ResponseEntity<Page<MarketDataRecordDTO>> browseMarketData(
        @RequestParam(required = false) Long classId,
        @RequestParam(required = false) String className,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "50") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("receivedAt").descending());
        
        Page<MarketDataRecord> result;
        if (classId != null) {
            result = marketDataRepository.findByClassId(classId, pageable);
        } else if (className != null) {
            result = marketDataRepository.findByClassName(className, pageable);
        } else {
            result = marketDataRepository.findAll(pageable);
        }
        
        // Convert to DTO to avoid LocalDateTime serialization issues
        Page<MarketDataRecordDTO> dtoPage = result.map(record -> MarketDataRecordDTO.builder()
            .id(record.getId())
            .classId(record.getClassId())
            .className(record.getClassName())
            .jsonData(record.getJsonData())
            .action(record.getAction())
            .receivedAt(record.getReceivedAt() != null ? record.getReceivedAt().toString() : null)
            .build());
        
        return ResponseEntity.ok(dtoPage);
    }
    
    /**
     * Get unique classes with counts
     */
    @GetMapping("/classes")
    public ResponseEntity<List<ClassSummary>> getClassSummaries() {
        log.info("📁 Fetching class summaries from database");
        
        String query = "SELECT class_id, class_name, COUNT(*) as count, MAX(received_at) as last_update " +
                      "FROM market_data " +
                      "GROUP BY class_id, class_name " +
                      "ORDER BY count DESC";
        
        log.info("📁 Executing query: {}", query);
        
        @SuppressWarnings("unchecked")
        List<Object[]> results = entityManager.createNativeQuery(query).getResultList();
        
        log.info("📁 Query returned {} results", results.size());
        
        List<ClassSummary> summaries = results.stream()
            .map(row -> {
                LocalDateTime lastUpdate = row[3] != null ? ((java.sql.Timestamp) row[3]).toLocalDateTime() : null;
                return ClassSummary.builder()
                    .classId(((Number) row[0]).longValue())
                    .className((String) row[1])
                    .recordCount(((Number) row[2]).longValue())
                    .lastUpdate(lastUpdate != null ? lastUpdate.toString() : null)
                    .build();
            })
            .collect(Collectors.toList());
        
        log.info("📁 Returning {} class summaries", summaries.size());
        return ResponseEntity.ok(summaries);
    }
    
    /**
     * Delete all market data
     */
    @DeleteMapping("/marketdata/all")
    public ResponseEntity<DeleteResult> deleteAllMarketData() {
        log.warn("Deleting ALL market data records");
        long count = marketDataRepository.count();
        marketDataRepository.deleteAll();
        log.info("Deleted {} market data records", count);
        return ResponseEntity.ok(new DeleteResult(count, "All market data deleted"));
    }
    
    /**
     * Delete by classId
     */
    @DeleteMapping("/marketdata/class/{classId}")
    public ResponseEntity<DeleteResult> deleteByClass(@PathVariable Long classId) {
        log.warn("Deleting market data for class: {}", classId);
        long count = marketDataRepository.countByClassId(classId);
        marketDataRepository.deleteByClassId(classId);
        log.info("Deleted {} records for class {}", count, classId);
        return ResponseEntity.ok(new DeleteResult(count, "Deleted records for class " + classId));
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
        private Long id;
        private Long classId;
        private String className;
        private String jsonData;
        private String action;
        private String receivedAt;
    }
}
