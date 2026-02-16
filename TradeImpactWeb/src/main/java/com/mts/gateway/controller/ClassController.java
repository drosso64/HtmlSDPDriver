package com.mts.gateway.controller;

import com.mts.gateway.dto.ClassInfo;
import com.mts.gateway.repository.ClassMetadataRepository;
import com.mts.gateway.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Controller
 * 
 * Provides REST API for class metadata and bulk subscriptions
 */
@Slf4j
@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClassController {
    
    private final ClassMetadataRepository classMetadataRepository;
    private final SubscriptionService subscriptionService;
    
    /**
     * Get all available classes from CSV
     * 
     * GET /api/classes
     */
    @GetMapping
    public ResponseEntity<List<ClassInfo>> getAllClasses() {
        try {
            List<ClassInfo> classes = classMetadataRepository.getAllClasses();
            
            // Sort alphabetically by simple class name
            classes.sort((a, b) -> {
                String nameA = a.getSimpleClassName() != null ? a.getSimpleClassName() : a.getClassName();
                String nameB = b.getSimpleClassName() != null ? b.getSimpleClassName() : b.getClassName();
                return nameA.compareToIgnoreCase(nameB);
            });
            
            log.info("Returning {} available classes (sorted A-Z)", classes.size());
            return ResponseEntity.ok(classes);
        } catch (Exception e) {
            log.error("Failed to get classes", e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * Get class by ID
     * 
     * GET /api/classes/{classId}
     */
    @GetMapping("/{classId}")
    public ResponseEntity<ClassInfo> getClass(@PathVariable Long classId) {
        ClassInfo classInfo = classMetadataRepository.getClassInfo(classId);
        if (classInfo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(classInfo);
    }
    
    /**
     * Start subscriptions for multiple classes
     * 
     * POST /api/classes/subscribe
     * Body: {
     *   "classIds": [100001, 100002, 100003],
     *   "filterKey": 0  // optional
     * }
     */
    @PostMapping("/subscribe")
    public ResponseEntity<Map<String, Object>> subscribeMultiple(@RequestBody SubscribeRequest request) {
        log.info("Starting subscriptions for {} classes", request.getClassIds().size());
        
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> results = new ArrayList<>();
        int successCount = 0;
        int failureCount = 0;
        
        for (Long classId : request.getClassIds()) {
            Map<String, Object> result = new HashMap<>();
            result.put("classId", classId);
            
            try {
                ClassInfo classInfo = classMetadataRepository.getClassInfo(classId);
                if (classInfo == null) {
                    result.put("status", "error");
                    result.put("message", "Class not found");
                    failureCount++;
                } else {
                    // Start subscription
                    subscriptionService.createSubscription(
                        "default-user",  // TODO: get from security context
                        classId
                    );
                    
                    result.put("status", "success");
                    result.put("className", classInfo.getSimpleClassName());
                    result.put("serviceId", classInfo.getServiceId());
                    successCount++;
                    
                    log.info("Started subscription for class {} on service {}", 
                        classInfo.getSimpleClassName(), classInfo.getServiceId());
                }
            } catch (Exception e) {
                log.error("Failed to subscribe to class {}", classId, e);
                result.put("status", "error");
                result.put("message", e.getMessage());
                failureCount++;
            }
            
            results.add(result);
        }
        
        response.put("total", request.getClassIds().size());
        response.put("success", successCount);
        response.put("failures", failureCount);
        response.put("results", results);
        
        log.info("Subscription batch completed: {} success, {} failures", successCount, failureCount);
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Stop subscriptions for multiple classes
     * 
     * POST /api/classes/unsubscribe
     * Body: {
     *   "classIds": [100001, 100002, 100003]
     * }
     */
    @PostMapping("/unsubscribe")
    public ResponseEntity<Map<String, Object>> unsubscribeMultiple(@RequestBody UnsubscribeRequest request) {
        log.info("Stopping subscriptions for {} classes", request.getClassIds().size());
        
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> results = new ArrayList<>();
        int successCount = 0;
        int failureCount = 0;
        
        for (Long classId : request.getClassIds()) {
            Map<String, Object> result = new HashMap<>();
            result.put("classId", classId);
            
            try {
                ClassInfo classInfo = classMetadataRepository.getClassInfo(classId);
                if (classInfo == null) {
                    result.put("status", "error");
                    result.put("message", "Class not found");
                    failureCount++;
                } else {
                    // Stop subscription - find and delete by username and classId
                    var subscriptions = subscriptionService.getUserSubscriptions("default-user");
                    subscriptions.stream()
                        .filter(s -> s.getClassId().equals(classId))
                        .findFirst()
                        .ifPresent(s -> subscriptionService.deleteSubscription(s.getId()));
                    
                    result.put("status", "success");
                    result.put("className", classInfo.getSimpleClassName());
                    successCount++;
                    
                    log.info("Stopped subscription for class {}", classInfo.getSimpleClassName());
                }
            } catch (Exception e) {
                log.error("Failed to unsubscribe from class {}", classId, e);
                result.put("status", "error");
                result.put("message", e.getMessage());
                failureCount++;
            }
            
            results.add(result);
        }
        
        response.put("total", request.getClassIds().size());
        response.put("success", successCount);
        response.put("failures", failureCount);
        response.put("results", results);
        
        log.info("Unsubscription batch completed: {} success, {} failures", successCount, failureCount);
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Reload CSV file
     * 
     * POST /api/classes/reload
     */
    @PostMapping("/reload")
    public ResponseEntity<Map<String, Object>> reloadCsv() {
        try {
            classMetadataRepository.reloadCsv();
            int classCount = classMetadataRepository.getAllClasses().size();
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("classCount", classCount);
            
            log.info("CSV file reloaded successfully, {} classes loaded", classCount);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Failed to reload CSV file", e);
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", e.getMessage());
            
            return ResponseEntity.internalServerError().body(response);
        }
    }
    
    // Request DTOs
    
    @lombok.Data
    public static class SubscribeRequest {
        private List<Long> classIds;
        private Long filterKey;  // optional, defaults to 0
        
        public Long getFilterKey() {
            return filterKey != null ? filterKey : 0L;
        }
    }
    
    @lombok.Data
    public static class UnsubscribeRequest {
        private List<Long> classIds;
    }
}
