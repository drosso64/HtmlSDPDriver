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
    
    private final SubscriptionRepository subscriptionRepository;
    private final MarketDataRepository marketDataRepository;
    private final ClassMetadataRepository classMetadataRepository;
    private final GenericSMPSerializer serializer;
    private final SDPConnectionPool connectionPool;
    
    /**
     * Create a new subscription
     */
    @Transactional
    public Subscription createSubscription(String username, Long classId) {
        log.info("Creating subscription for user={} classId={}", username, classId);
        
        // Check if subscription already exists
        Optional<Subscription> existing = subscriptionRepository.findByUsernameAndClassId(username, classId);
        if (existing.isPresent()) {
            log.info("Subscription already exists: {}", existing.get().getId());
            return existing.get();
        }
        
        // Get class metadata
        var metadata = classMetadataRepository.getClassInfo(classId);
        if (metadata == null) {
            throw new IllegalArgumentException("Class not found: " + classId);
        }
        
        // Create subscription
        Subscription subscription = Subscription.builder()
            .username(username)
            .classId(classId)
            .className(metadata.getSimpleClassName())
            .status(SubscriptionStatus.PENDING)
            .recordCount(0L)
            .build();
        
        subscription = subscriptionRepository.save(subscription);
        
        log.info("Subscription created: id={}", subscription.getId());
        
        // Send actual subscription to AP
        try {
            sendSubscriptionToAP(metadata, 0L);
            subscription.setStatus(SubscriptionStatus.ACTIVE);
            subscriptionRepository.save(subscription);
            log.info("Subscription activated for class {} on service {}", 
                metadata.getSimpleClassName(), metadata.getServiceId());
        } catch (Exception e) {
            log.error("Failed to send subscription to AP for class {}", classId, e);
            subscription.setStatus(SubscriptionStatus.ERROR);
            subscription.setErrorMessage(e.getMessage());
            subscriptionRepository.save(subscription);
            throw new RuntimeException("Failed to subscribe to AP: " + e.getMessage(), e);
        }
        
        return subscription;
    }
    
    /**
     * Send subscription request to Access Point
     */
    private void sendSubscriptionToAP(ClassInfo classInfo, Long filterKey) throws Exception {
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
            
            connection.subscribe(classIdULong, filterKeyULong);
            
            log.info("Subscription request sent successfully");
        } finally {
            // CRITICAL: Always release connection back to pool
            connectionPool.releaseConnection(connection);
        }
    }
    
    /**
     * Get all subscriptions for a user
     */
    public List<Subscription> getUserSubscriptions(String username) {
        return subscriptionRepository.findByUsername(username);
    }
    
    /**
     * Get active subscriptions for a user
     */
    public List<Subscription> getActiveSubscriptions(String username) {
        return subscriptionRepository.findByUsernameAndStatus(username, SubscriptionStatus.ACTIVE);
    }
    
    /**
     * Get subscription by ID
     */
    public Optional<Subscription> getSubscription(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId);
    }
    
    /**
     * Update subscription status
     */
    @Transactional
    public void updateSubscriptionStatus(Long subscriptionId, SubscriptionStatus status) {
        log.info("Updating subscription {} status to {}", subscriptionId, status);
        
        Optional<Subscription> optSub = subscriptionRepository.findById(subscriptionId);
        if (optSub.isPresent()) {
            Subscription subscription = optSub.get();
            subscription.setStatus(status);
            subscription.setLastActivity(LocalDateTime.now());
            subscriptionRepository.save(subscription);
        }
    }
    
    /**
     * Update subscription status with error
     */
    @Transactional
    public void updateSubscriptionError(Long subscriptionId, String errorMessage) {
        log.error("Subscription {} error: {}", subscriptionId, errorMessage);
        
        Optional<Subscription> optSub = subscriptionRepository.findById(subscriptionId);
        if (optSub.isPresent()) {
            Subscription subscription = optSub.get();
            subscription.setStatus(SubscriptionStatus.ERROR);
            subscription.setErrorMessage(errorMessage);
            subscriptionRepository.save(subscription);
        }
    }
    
    /**
     * Delete subscription
     */
    @Transactional
    public void deleteSubscription(Long subscriptionId) {
        log.info("Deleting subscription {}", subscriptionId);
        subscriptionRepository.deleteById(subscriptionId);
    }
    
    /**
     * Persist market data record
     */
    @Transactional
    public void persistMarketData(Long subscriptionId, Object smpObject, ClassSchema schema, String action) {
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
                .subscriptionId(subscriptionId)
                .build();
            
            marketDataRepository.save(record);
            
            // Update subscription statistics
            updateSubscriptionStats(subscriptionId);
            
            log.debug("Persisted market data for subscription {} class {}", 
                subscriptionId, schema.getSimpleClassName());
            
        } catch (Exception e) {
            log.error("Failed to persist market data for subscription {}", subscriptionId, e);
        }
    }
    
    /**
     * Update subscription statistics
     */
    @Transactional
    protected void updateSubscriptionStats(Long subscriptionId) {
        Optional<Subscription> optSub = subscriptionRepository.findById(subscriptionId);
        if (optSub.isPresent()) {
            Subscription subscription = optSub.get();
            subscription.setRecordCount(subscription.getRecordCount() + 1);
            subscription.setLastActivity(LocalDateTime.now());
            subscriptionRepository.save(subscription);
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
     * Get market data for a subscription
     */
    public List<MarketDataRecord> getSubscriptionData(Long subscriptionId) {
        return marketDataRepository.findBySubscriptionId(subscriptionId);
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
        long total = subscriptionRepository.findByUsername(username).size();
        long active = subscriptionRepository.countByUsernameAndStatus(username, SubscriptionStatus.ACTIVE);
        
        return SubscriptionStats.builder()
            .totalSubscriptions(total)
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
