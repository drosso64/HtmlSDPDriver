package com.mts.gateway.service;

import com.mts.gateway.config.SDPConfigProperties;
import com.mts.gateway.entity.MarketDataRecord;
import com.mts.gateway.repository.MarketDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Database Cleanup Service
 * 
 * Automatically cleans up old market data records based on retention policy.
 * Runs scheduled cleanup jobs to prevent database growth.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DatabaseCleanupService {
    
    private final MarketDataRepository marketDataRepository;
    private final SDPConfigProperties config;
    
    /**
     * Cleanup old market data - runs daily at 2 AM
     */
    @Scheduled(cron = "0 0 2 * * *")
    @Transactional
    public void cleanupOldData() {
        log.info("Starting scheduled database cleanup");
        
        try {
            int retentionDays = config.getDatabase().getRetentionDays();
            LocalDateTime cutoffDate = LocalDateTime.now().minusDays(retentionDays);
            
            log.info("Deleting market data records older than {} (retention: {} days)", 
                cutoffDate, retentionDays);
            
            int deletedCount = marketDataRepository.deleteOldRecords(cutoffDate);
            
            log.info("Database cleanup completed. Deleted {} old records", deletedCount);
            
        } catch (Exception e) {
            log.error("Database cleanup failed", e);
        }
    }
    
    /**
     * Manual cleanup trigger
     */
    @Transactional
    public int cleanupManual(int retentionDays) {
        log.info("Manual database cleanup requested (retention: {} days)", retentionDays);
        
        LocalDateTime cutoffDate = LocalDateTime.now().minusDays(retentionDays);
        int deletedCount = marketDataRepository.deleteOldRecords(cutoffDate);
        
        log.info("Manual cleanup completed. Deleted {} records", deletedCount);
        
        return deletedCount;
    }
    
    /**
     * Get database statistics
     */
    public DatabaseStats getStats() {
        long totalRecords = marketDataRepository.count();
        long recentRecords = marketDataRepository.countByReceivedAtAfter(
            LocalDateTime.now().minusDays(1)
        );
        
        return DatabaseStats.builder()
            .totalRecords(totalRecords)
            .last24Hours(recentRecords)
            .retentionDays(config.getDatabase().getRetentionDays())
            .build();
    }
    
    /**
     * Database Statistics DTO
     */
    @lombok.Data
    @lombok.Builder
    public static class DatabaseStats {
        private long totalRecords;
        private long last24Hours;
        private int retentionDays;
    }
}
