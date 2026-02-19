package com.mts.gateway.controller;

import com.mts.gateway.dto.ClassInfo;
import com.mts.gateway.dto.ClassSchema;
import com.mts.gateway.repository.ClassMetadataRepository;
import com.mts.gateway.service.ClassIntrospectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Class Metadata Controller
 * 
 * REST API for retrieving SMP class metadata and schemas.
 * Used by the frontend to discover available classes and their structures.
 */
@Slf4j
@RestController
@RequestMapping("/api/metadata")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClassMetadataController {
    
    private final ClassMetadataRepository metadataRepository;
    private final ClassIntrospectionService introspectionService;
    
    /**
     * GET /api/classes
     * Get all available SMP classes
     * 
     * @return List of class metadata (simplified)
     */
    @GetMapping
    public ResponseEntity<List<ClassInfo>> getAllClasses() {
        log.info("GET /api/classes - Fetching all available classes");
        
        try {
            List<ClassInfo> classes = metadataRepository.getAllClasses();
            
            log.info("Found {} classes", classes.size());
            
            return ResponseEntity.ok(classes);
            
        } catch (Exception e) {
            log.error("Failed to fetch classes", e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * GET /api/classes/{classId}
     * Get class metadata by CLASS_ID
     * 
     * @param classId SMP CLASS_ID
     * @return Class metadata
     */
    @GetMapping("/{classId}")
    public ResponseEntity<ClassInfo> getClassById(@PathVariable Long classId) {
        log.info("GET /api/classes/{} - Fetching class metadata", classId);
        
        try {
            ClassInfo metadata = metadataRepository.getClassInfo(classId);
            
            if (metadata == null) {
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok(metadata);
            
        } catch (Exception e) {
            log.error("Failed to fetch class metadata for classId={}", classId, e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * GET /api/classes/{classId}/schema
     * Get complete schema for a class
     * 
     * @param classId SMP CLASS_ID
     * @return Complete class schema with fields
     */
    @GetMapping("/{classId}/schema")
    public ResponseEntity<ClassSchema> getClassSchema(@PathVariable Long classId) {
        log.info("GET /api/classes/{}/schema - Fetching class schema", classId);
        
        try {
            ClassSchema schema = metadataRepository.getCompleteSchema(classId);
            
            if (schema == null) {
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok(schema);
            
        } catch (Exception e) {
            log.error("Failed to fetch class schema for classId={}", classId, e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * GET /api/classes/by-name/{className}
     * Get class metadata by class name
     * 
     * @param className Simple or fully qualified class name
     * @return Class metadata
     */
    @GetMapping("/by-name/{className}")
    public ResponseEntity<ClassInfo> getClassByName(@PathVariable String className) {
        log.info("GET /api/classes/by-name/{} - Fetching class metadata", className);
        
        try {
            ClassInfo metadata = metadataRepository.getClassInfoByName(className);
            
            if (metadata == null) {
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok(metadata);
            
        } catch (Exception e) {
            log.error("Failed to fetch class metadata for className={}", className, e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * GET /api/classes/by-name/{className}/schema
     * Get complete schema by class name
     * 
     * @param className Simple or fully qualified class name
     * @return Complete class schema
     */
    @GetMapping("/by-name/{className}/schema")
    public ResponseEntity<ClassSchema> getClassSchemaByName(@PathVariable String className) {
        log.info("GET /api/classes/by-name/{}/schema - Fetching class schema", className);
        
        try {
            ClassSchema schema = metadataRepository.getCompleteSchemaByName(className);
            
            if (schema == null) {
                // Class not in CSV - try direct introspection
                log.warn("Class {} not in CSV, attempting direct introspection", className);
                schema = introspectionService.introspectClass(className);
                
                if (schema == null) {
                    log.error("Failed to introspect class {}", className);
                    return ResponseEntity.notFound().build();
                }
            }
            
            return ResponseEntity.ok(schema);
            
        } catch (Exception e) {
            log.error("Failed to fetch class schema for className={}", className, e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * POST /api/classes/refresh
     * Refresh class metadata cache
     * 
     * @return Success message
     */
    @PostMapping("/refresh")
    public ResponseEntity<Map<String, String>> refreshMetadata() {
        log.info("POST /api/classes/refresh - Refreshing metadata cache");
        
        try {
            metadataRepository.reloadCsv();
            List<ClassInfo> classes = metadataRepository.getAllClasses();
            
            String message = String.format("Metadata cache refreshed. Found %d classes", classes.size());
            
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", message,
                "classCount", String.valueOf(classes.size())
            ));
            
        } catch (Exception e) {
            log.error("Failed to refresh metadata cache", e);
            return ResponseEntity.internalServerError()
                .body(Map.of("status", "error", "message", e.getMessage()));
        }
    }
    
    /**
     * GET /api/classes/search
     * Search classes by keyword
     * 
     * @param keyword Search keyword
     * @return Matching classes
     */
    @GetMapping("/search")
    public ResponseEntity<List<ClassInfo>> searchClasses(@RequestParam String keyword) {
        log.info("GET /api/classes/search?keyword={}", keyword);
        
        try {
            List<ClassInfo> allClasses = metadataRepository.getAllClasses();
            
            String lowerKeyword = keyword.toLowerCase();
            
            List<ClassInfo> filtered = allClasses.stream()
                .filter(meta -> 
                    meta.getSimpleClassName().toLowerCase().contains(lowerKeyword) ||
                    meta.getDescription().toLowerCase().contains(lowerKeyword)
                )
                .toList();
            
            log.info("Found {} classes matching keyword '{}'", filtered.size(), keyword);
            
            return ResponseEntity.ok(filtered);
            
        } catch (Exception e) {
            log.error("Failed to search classes with keyword '{}'", keyword, e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
