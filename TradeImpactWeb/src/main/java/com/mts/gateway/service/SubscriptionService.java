package com.mts.gateway.service;

import com.mts.gateway.dto.ClassInfo;
import com.mts.gateway.dto.ClassSchema;
import com.mts.gateway.entity.MarketDataRecord;
import com.mts.gateway.entity.Subscription;
import com.mts.gateway.entity.Subscription.SubscriptionStatus;
import com.mts.gateway.repository.ClassMetadataRepository;
import com.mts.gateway.repository.MarketDataRepository;
import com.mts.gateway.repository.SubscriptionRepository;
import com.mts.gateway.sdp.SDPConnection;
import com.mts.gateway.sdp.SDPConnectionPool;
import com.mts.gateway.sdp.ServiceType;
import com.mts.gateway.serialization.GenericSMPSerializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.mtsmarkets.io.xdr.ULong;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Subscription Management Service
 * 
 * Manages user subscriptions to SMP classes and persists received data.
 * Provides CRUD operations for subscriptions and data retrieval.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {
    
    private final ActiveSubscriptionService activeSubscriptionService;
    private final MarketDataRepository marketDataRepository;
    private final ClassMetadataRepository classMetadataRepository;
    private final GenericSMPSerializer serializer;
    private final SDPConnectionPool connectionPool;
    private final DynamicTableService dynamicTableService; // NEW: For creating tables on subscription
    
    /**
     * Create a new subscription
     */
    @Transactional
    public ActiveSubscriptionService.SubscriptionInfo createSubscription(String username, Long classId) {
        log.info("Creating subscription for user={} classId={}", username, classId);
        
        // Check if subscription already exists in memory
        ActiveSubscriptionService.SubscriptionInfo existing = activeSubscriptionService.getSubscription(username, classId);
        if (existing != null) {
            log.info("Subscription already exists: classId={} subscriptionKey={}", classId, existing.getSubscriptionKey());
            // Ensure table exists even for existing subscriptions (in case it was dropped)
            dynamicTableService.ensureTableExists(classId);
            log.info("📊 Ensured table exists for existing subscription classId={}", classId);
            return existing;
        }
        
        // Get class metadata
        var metadata = classMetadataRepository.getClassInfo(classId);
        if (metadata == null) {
            throw new IllegalArgumentException("Class not found: " + classId);
        }
        
        // Send actual subscription to AP
        try {
            Long subscriptionKey = sendSubscriptionToAP(metadata, 0L);
            log.info("Received subscription key from AP: {}", subscriptionKey);
            
            // Store in memory
            activeSubscriptionService.addSubscription(username, classId, metadata.getSimpleClassName(), subscriptionKey);
            
            // NEW: Create database table immediately (even if no data arrives yet)
            // This allows users to add records to the class even before receiving any market data
            dynamicTableService.ensureTableExists(classId);
            log.info("📊 Ensured table exists for classId={}", classId);
            
            log.info("Subscription activated: classId={} className={} key={}", 
                classId, metadata.getSimpleClassName(), subscriptionKey);
            
            return new ActiveSubscriptionService.SubscriptionInfo(classId, metadata.getSimpleClassName(), subscriptionKey);
        } catch (Exception e) {
            log.error("Failed to send subscription to AP for class {}", classId, e);
            throw new RuntimeException("Failed to subscribe to AP: " + e.getMessage(), e);
        }
    }
    
    /**
     * Send subscription request to Access Point and wait for subscription key
     */
    private Long sendSubscriptionToAP(ClassInfo classInfo, Long filterKey) throws Exception {
        String serviceIdStr = classInfo.getServiceId();
        
        // Parse service type using enum
        ServiceType serviceType = ServiceType.fromString(serviceIdStr);
        
        // Check if service supports subscriptions
        if (!serviceType.supportsSubscriptions()) {
            throw new IllegalStateException("Service " + serviceType + 
                " does not support subscriptions");
        }
        
        // Get connection for the service
        SDPConnection connection = connectionPool.getConnection(serviceType.getName());
        if (connection == null) {
            throw new IllegalStateException("No connection available for service: " + serviceType);
        }
        
        try {
            // Send subscription request (will use appropriate channel based on service type)
            ULong classIdULong = new ULong(classInfo.getClassId());
            ULong filterKeyULong = filterKey != null ? new ULong(filterKey) : null;
            
            log.info("Sending subscription to AP: service={} (ID={}) class={} (ID={}) filterKey={}",
                serviceType.getName(), serviceType.getId(), classInfo.getSimpleClassName(), 
                classInfo.getClassId(), filterKey);
            
            // Subscribe and wait for subscription key
            CompletableFuture<Long> subscriptionFuture = connection.subscribe(classIdULong, filterKeyULong);
            
            // Wait for subscription key (with timeout)
            Long subscriptionKey = subscriptionFuture.get(30, java.util.concurrent.TimeUnit.SECONDS);
            
            log.info("Subscription request sent successfully, key: {}", subscriptionKey);
            return subscriptionKey;
        } catch (java.util.concurrent.TimeoutException e) {
            throw new RuntimeException("Timeout waiting for subscription response from AP", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send subscription to AP", e);
        } finally {
            // CRITICAL: Always release connection back to pool
            connectionPool.releaseConnection(connection);
        }
    }
    
    /**
     * Delete subscription and send unsubscribe request to AP
     */
    @Transactional
    public void deleteSubscription(String username, Long classId) {
        log.info("Deleting subscription for user={} classId={}", username, classId);
        
        // Get subscription from memory
        ActiveSubscriptionService.SubscriptionInfo subscription = activeSubscriptionService.getSubscription(username, classId);
        if (subscription == null) {
            throw new IllegalArgumentException("No subscription found for classId: " + classId);
        }
        
        // Send unsubscribe to AP
        Long subscriptionKey = subscription.getSubscriptionKey();
        try {
            ClassInfo classInfo = classMetadataRepository.getClassInfo(classId);
            sendUnsubscribeToAP(classInfo, subscriptionKey);
        } catch (Exception e) {
            log.error("Failed to send unsubscribe to AP for classId={}", classId, e);
            // Continue with removal even if AP unsubscribe fails
        }
        
        // Remove from memory
        activeSubscriptionService.removeSubscription(username, classId);
        log.info("Subscription deleted: classId={}", classId);
    }
    
    /**
     * Send unsubscribe request to Access Point
     */
    private void sendUnsubscribeToAP(ClassInfo classInfo, Long subscriptionKey) throws Exception {
        String serviceIdStr = classInfo.getServiceId();
        
        // Parse service type using enum
        ServiceType serviceType = ServiceType.fromString(serviceIdStr);
        
        // Get connection for the service
        SDPConnection connection = connectionPool.getConnection(serviceType.getName());
        if (connection == null) {
            throw new IllegalStateException("No connection available for service: " + serviceType);
        }
        
        try {
            // Send unsubscribe request
            ULong subscriptionKeyULong = new ULong(subscriptionKey);
            
            log.info("Sending unsubscribe to AP: service={} subscriptionKey={}",
                serviceType.getName(), subscriptionKey);
            
            connection.unsubscribe(subscriptionKeyULong);
            
            log.info("Unsubscribe request sent successfully");
        } finally {
            // CRITICAL: Always release connection back to pool
            connectionPool.releaseConnection(connection);
        }
    }
    
    /**
     * Get all subscriptions for a user
     */
    public List<ActiveSubscriptionService.SubscriptionInfo> getUserSubscriptions(String username) {
        return activeSubscriptionService.getActiveSubscriptions(username);
    }
    
    /**
     * Get active subscriptions for a user
     */
    public List<ActiveSubscriptionService.SubscriptionInfo> getActiveSubscriptions(String username) {
        log.info("Getting active subscriptions for user: {}", username);
        List<ActiveSubscriptionService.SubscriptionInfo> subscriptions = activeSubscriptionService.getActiveSubscriptions(username);
        log.info("Found {} active subscriptions for user {}", subscriptions.size(), username);
        subscriptions.forEach(sub -> 
            log.info("  - Subscription: classId={} className={} subscriptionKey={}", 
                sub.getClassId(), sub.getClassName(), sub.getSubscriptionKey())
        );
        return subscriptions;
    }
    
    /**
     * Clear all subscriptions for user (on logout/websocket disconnect)
     */
    public void clearUserSubscriptions(String username) {
        log.info("Clearing all subscriptions for user: {}", username);
        activeSubscriptionService.clearUserSubscriptions(username);
        // No need to unsubscribe one by one - SDP connection closure handles it
    }
    
    /**
     * Persist market data record
     */
    @Transactional
    public void persistMarketData(Long classId, String className, Object smpObject, ClassSchema schema, String action) {
        try {
            // Serialize SMP object to JSON
            JsonNode jsonNode = serializer.serialize(smpObject, schema);
            String jsonData = jsonNode.toString();
            
            // Create market data record
            MarketDataRecord record = MarketDataRecord.builder()
                .classId(schema.getClassId())
                .className(schema.getSimpleClassName())
                .jsonData(jsonData)
                .action(action)
                .build();
            
            marketDataRepository.save(record);
            
            log.debug("Persisted market data for class {} ({})", className, classId);
            
        } catch (Exception e) {
            log.error("Failed to persist market data for class {} ({})", className, classId, e);
        }
    }
    
    /**
     * Get market data for a class
     */
    public Page<MarketDataRecord> getMarketData(Long classId, Pageable pageable) {
        return marketDataRepository.findByClassId(classId, pageable);
    }
    
    /**
     * Get recent market data for a class
     */
    public List<MarketDataRecord> getRecentMarketData(Long classId, int limit) {
        Pageable pageable = Pageable.ofSize(limit);
        return marketDataRepository.findRecentByClassId(classId, pageable);
    }
    
    /**
     * Clear market data for a class
     */
    @Transactional
    public void clearMarketData(Long classId) {
        log.info("Clearing market data for class {}", classId);
        marketDataRepository.deleteByClassId(classId);
    }
    
    /**
     * Get subscription statistics
     */
    public SubscriptionStats getStats(String username) {
        long active = activeSubscriptionService.getActiveSubscriptions(username).size();
        
        return SubscriptionStats.builder()
            .totalSubscriptions(active)
            .activeSubscriptions(active)
            .build();
    }
    
    /**
     * Subscription Statistics DTO
     */
    @lombok.Data
    @lombok.Builder
    public static class SubscriptionStats {
        private long totalSubscriptions;
        private long activeSubscriptions;
    }
}
