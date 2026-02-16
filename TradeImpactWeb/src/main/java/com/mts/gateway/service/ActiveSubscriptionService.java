package com.mts.gateway.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * In-memory service for managing active subscriptions
 * Subscriptions live only as long as SDP connections are active
 */
@Slf4j
@Service
public class ActiveSubscriptionService {
    
    // Map: username -> (classId -> SubscriptionInfo)
    private final Map<String, Map<Long, SubscriptionInfo>> userSubscriptions = new ConcurrentHashMap<>();
    
    /**
     * Add active subscription
     */
    public void addSubscription(String username, Long classId, String className, Long subscriptionKey) {
        log.info("Adding subscription: user={} classId={} className={} subscriptionKey={}", 
            username, classId, className, subscriptionKey);
        
        userSubscriptions.computeIfAbsent(username, k -> new ConcurrentHashMap<>())
            .put(classId, new SubscriptionInfo(classId, className, subscriptionKey));
    }
    
    /**
     * Remove subscription
     */
    public SubscriptionInfo removeSubscription(String username, Long classId) {
        log.info("Removing subscription: user={} classId={}", username, classId);
        
        Map<Long, SubscriptionInfo> userSubs = userSubscriptions.get(username);
        if (userSubs != null) {
            return userSubs.remove(classId);
        }
        return null;
    }
    
    /**
     * Get subscription by classId
     */
    public SubscriptionInfo getSubscription(String username, Long classId) {
        Map<Long, SubscriptionInfo> userSubs = userSubscriptions.get(username);
        if (userSubs != null) {
            return userSubs.get(classId);
        }
        return null;
    }
    
    /**
     * Get all active subscriptions for user
     */
    public List<SubscriptionInfo> getActiveSubscriptions(String username) {
        Map<Long, SubscriptionInfo> userSubs = userSubscriptions.get(username);
        if (userSubs != null) {
            return new ArrayList<>(userSubs.values());
        }
        return new ArrayList<>();
    }
    
    /**
     * Clear all subscriptions for user (called on logout/websocket close)
     */
    public void clearUserSubscriptions(String username) {
        log.info("Clearing all subscriptions for user: {}", username);
        userSubscriptions.remove(username);
    }
    
    /**
     * Clear all subscriptions (called on app shutdown)
     */
    public void clearAll() {
        log.info("Clearing all subscriptions");
        userSubscriptions.clear();
    }
    
    /**
     * Subscription info holder
     */
    @lombok.Data
    @lombok.AllArgsConstructor
    public static class SubscriptionInfo {
        private Long classId;
        private String className;
        private Long subscriptionKey;
    }
}
