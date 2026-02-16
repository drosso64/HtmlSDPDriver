package com.mts.gateway.controller;

import com.mts.gateway.entity.MarketDataRecord;
import com.mts.gateway.service.ActiveSubscriptionService;
import com.mts.gateway.service.DatabaseCleanupService;
import com.mts.gateway.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Subscription Controller
 * 
 * REST API for managing user subscriptions and retrieving market data.
 */
@Slf4j
@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SubscriptionController {
    
    private final SubscriptionService subscriptionService;
    private final DatabaseCleanupService cleanupService;
    
    /**
     * POST /api/subscriptions
     * Create a new subscription
     * 
     * @param request Subscription request
     * @return Created subscription
     */
    @PostMapping
    public ResponseEntity<ActiveSubscriptionService.SubscriptionInfo> createSubscription(@RequestBody SubscriptionRequest request) {
        log.info("POST /api/subscriptions - user={} classId={}", request.username, request.classId);
        
        try {
            ActiveSubscriptionService.SubscriptionInfo subscription = subscriptionService.createSubscription(
                request.username,
                request.classId
            );
            
            return ResponseEntity.ok(subscription);
            
        } catch (Exception e) {
            log.error("Failed to create subscription", e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * GET /api/subscriptions/user/{username}
     * Get all subscriptions for a user
     * 
     * @param username User identifier
     * @return List of subscriptions
     */
    @GetMapping("/user/{username}")
    public ResponseEntity<List<ActiveSubscriptionService.SubscriptionInfo>> getUserSubscriptions(@PathVariable String username) {
        log.info("GET /api/subscriptions/user/{}", username);
        
        try {
            List<ActiveSubscriptionService.SubscriptionInfo> subscriptions = subscriptionService.getUserSubscriptions(username);
            return ResponseEntity.ok(subscriptions);
            
        } catch (Exception e) {
            log.error("Failed to get user subscriptions", e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * GET /api/subscriptions/user/{username}/active
     * Get active subscriptions for a user
     * 
     * @param username User identifier
     * @return List of active subscriptions
     */
    @GetMapping("/user/{username}/active")
    public ResponseEntity<List<ActiveSubscriptionService.SubscriptionInfo>> getActiveSubscriptions(@PathVariable String username) {
        log.info("GET /api/subscriptions/user/{}/active", username);
        
        try {
            List<ActiveSubscriptionService.SubscriptionInfo> subscriptions = subscriptionService.getActiveSubscriptions(username);
            log.info("Returning {} active subscriptions for user {}", subscriptions.size(), username);
            return ResponseEntity.ok(subscriptions);
            
        } catch (Exception e) {
            log.error("Failed to get active subscriptions", e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * DELETE /api/subscriptions/{username}/{classId}
     * Delete subscription and send unsubscribe to AP
     * 
     * @param username User identifier
     * @param classId Class ID
     * @return Success response
     */
    @DeleteMapping("/{username}/{classId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable String username, @PathVariable Long classId) {
        log.info("DELETE /api/subscriptions/{}/{}", username, classId);
        
        try {
            subscriptionService.deleteSubscription(username, classId);
            return ResponseEntity.ok().build();
            
        } catch (IllegalArgumentException e) {
            log.error("Subscription not found: user={} classId={}", username, classId);
            return ResponseEntity.notFound().build();
            
        } catch (Exception e) {
            log.error("Failed to delete subscription user={} classId={}", username, classId, e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * GET /api/subscriptions/class/{classId}/data
     * Get market data for a class
     * 
     * @param classId Class ID
     * @param limit Maximum number of records
     * @return Recent market data
     */
    @GetMapping("/class/{classId}/data")
    public ResponseEntity<List<MarketDataRecord>> getClassData(
        @PathVariable Long classId,
        @RequestParam(defaultValue = "100") int limit
    ) {
        log.info("GET /api/subscriptions/class/{}/data?limit={}", classId, limit);
        
        try {
            List<MarketDataRecord> data = subscriptionService.getRecentMarketData(classId, limit);
            return ResponseEntity.ok(data);
            
        } catch (Exception e) {
            log.error("Failed to get class data", e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * DELETE /api/subscriptions/class/{classId}/data
     * Clear market data for a class
     * 
     * @param classId Class ID
     * @return Success response
     */
    @DeleteMapping("/class/{classId}/data")
    public ResponseEntity<Map<String, String>> clearClassData(@PathVariable Long classId) {
        log.info("DELETE /api/subscriptions/class/{}/data", classId);
        
        try {
            subscriptionService.clearMarketData(classId);
            
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Market data cleared for class " + classId
            ));
            
        } catch (Exception e) {
            log.error("Failed to clear class data", e);
            return ResponseEntity.internalServerError()
                .body(Map.of("status", "error", "message", e.getMessage()));
        }
    }
    
    /**
     * GET /api/subscriptions/user/{username}/stats
     * Get subscription statistics for a user
     * 
     * @param username User identifier
     * @return Subscription statistics
     */
    @GetMapping("/user/{username}/stats")
    public ResponseEntity<SubscriptionService.SubscriptionStats> getStats(@PathVariable String username) {
        log.info("GET /api/subscriptions/user/{}/stats", username);
        
        try {
            var stats = subscriptionService.getStats(username);
            return ResponseEntity.ok(stats);
            
        } catch (Exception e) {
            log.error("Failed to get subscription stats", e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * POST /api/subscriptions/cleanup
     * Manual database cleanup
     * 
     * @param retentionDays Number of days to retain
     * @return Cleanup result
     */
    @PostMapping("/cleanup")
    public ResponseEntity<Map<String, Object>> manualCleanup(
        @RequestParam(defaultValue = "30") int retentionDays
    ) {
        log.info("POST /api/subscriptions/cleanup?retentionDays={}", retentionDays);
        
        try {
            int deletedCount = cleanupService.cleanupManual(retentionDays);
            
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", String.format("Deleted %d old records", deletedCount),
                "deletedCount", deletedCount
            ));
            
        } catch (Exception e) {
            log.error("Failed to perform manual cleanup", e);
            return ResponseEntity.internalServerError()
                .body(Map.of("status", "error", "message", e.getMessage()));
        }
    }
    
    /**
     * GET /api/subscriptions/database/stats
     * Get database statistics
     * 
     * @return Database statistics
     */
    @GetMapping("/database/stats")
    public ResponseEntity<DatabaseCleanupService.DatabaseStats> getDatabaseStats() {
        log.info("GET /api/subscriptions/database/stats");
        
        try {
            var stats = cleanupService.getStats();
            return ResponseEntity.ok(stats);
            
        } catch (Exception e) {
            log.error("Failed to get database stats", e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * Subscription Request DTO
     */
    record SubscriptionRequest(String username, Long classId) {}
}
