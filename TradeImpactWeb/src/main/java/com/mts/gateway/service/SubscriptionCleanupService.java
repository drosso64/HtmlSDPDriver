package com.mts.gateway.service;

import com.mts.gateway.entity.Subscription;
import com.mts.gateway.repository.SubscriptionRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service to cleanup ALL data on application startup.
 * 
 * Since H2 database persists in the container (but not on host volume),
 * data from previous sessions remains until the container is destroyed.
 * This service provides a clean slate on every application restart by:
 * 1. Deleting all subscriptions (regardless of status)
 * 2. Dropping all market_data_* tables
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionCleanupService {
    
    private final SubscriptionRepository subscriptionRepository;
    private final EntityManager entityManager;
    
    /**
     * Clean up ALL data on application startup.
     * Provides a fresh start even if container wasn't destroyed.
     * Runs after the application is fully started.
     */
    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void cleanupOrphanedSubscriptions() {
        log.info("🧹 Cleaning up ALL data from previous sessions...");
        
        try {
            // 1. Delete ALL subscriptions (regardless of status)
            long subscriptionCount = subscriptionRepository.count();
            if (subscriptionCount > 0) {
                log.warn("⚠️ Deleting {} subscriptions from previous session", subscriptionCount);
                subscriptionRepository.deleteAll();
                log.info("✅ Deleted {} subscriptions", subscriptionCount);
            } else {
                log.info("✅ No subscriptions to delete");
            }
            
            // 2. Drop all market_data_* tables
            String discoverQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES " +
                                  "WHERE TABLE_NAME LIKE 'MARKET_DATA_%'";
            
            @SuppressWarnings("unchecked")
            List<Object> rawResults = entityManager.createNativeQuery(discoverQuery).getResultList();
            List<String> tableNames = rawResults.stream()
                .map(Object::toString)
                .toList();
            
            if (tableNames.isEmpty()) {
                log.info("✅ No market data tables to drop");
            } else {
                log.warn("⚠️ Dropping {} market data tables from previous session", tableNames.size());
                for (String tableName : tableNames) {
                    try {
                        String dropQuery = "DROP TABLE IF EXISTS " + tableName;
                        entityManager.createNativeQuery(dropQuery).executeUpdate();
                        log.info("🗑️ Dropped table: {}", tableName);
                    } catch (Exception e) {
                        log.error("❌ Failed to drop table {}: {}", tableName, e.getMessage());
                    }
                }
                log.info("✅ Dropped {} market data tables", tableNames.size());
            }
            
            log.info("✅ Cleanup completed - fresh start ready");
            
        } catch (Exception e) {
            log.error("❌ Failed to cleanup data: {}", e.getMessage(), e);
        }
    }
}
