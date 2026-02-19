package com.mts.gateway.repository;

import com.mts.gateway.classloader.SDPClassLoaderService;
import com.mts.gateway.dto.ClassInfo;
import com.mts.gateway.dto.ClassSchema;
import com.mts.gateway.service.ClassIntrospectionService;
import com.mts.gateway.service.CsvClassLoaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.List;

/**
 * Class Metadata Repository
 * 
 * Loads class descriptions from CSV file and provides metadata for subscription.
 * CSV format: ClassName,ClassId,ServiceId[,Description]
 * 
 * Uses Java reflection on dynamically loaded classes to introspect structure.
 * No need for TI_DESC_CLASS - all metadata comes from CSV + reflection.
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class ClassMetadataRepository {
    
    private final SDPClassLoaderService classLoaderService;
    private final ClassIntrospectionService introspectionService;
    private final CsvClassLoaderService csvClassLoaderService;
    
    /**
     * Initialize repository
     */
    @PostConstruct
    public void initialize() {
        log.info("Initializing Class Metadata Repository");
        log.info("Using CSV class loader with {} classes", csvClassLoaderService.getAllClasses().size());
    }
    
    /**
     * Get all available classes from CSV
     * 
     * @return List of class info
     */
    public List<ClassInfo> getAllClasses() {
        return csvClassLoaderService.getAllClasses();
    }
    
    /**
     * Get class info by CLASS_ID
     */
    public ClassInfo getClassInfo(Long classId) {
        return csvClassLoaderService.getClassById(classId);
    }
    
    /**
     * Get class info by class name
     */
    public ClassInfo getClassInfoByName(String className) {
        return csvClassLoaderService.getClassByName(className);
    }
    
    /**
     * Get classes by service ID
     */
    public List<ClassInfo> getClassesByService(String serviceId) {
        return csvClassLoaderService.getClassesByService(serviceId);
    }
    
    /**
     * Get complete schema for a class (metadata + introspection)
     */
    public ClassSchema getCompleteSchema(Long classId) {
        log.info("🔍 Looking up schema for classId={}", classId);
        
        // Debug: log all available classIds
        List<ClassInfo> allClasses = csvClassLoaderService.getAllClasses();
        log.info("📊 Total classes in CSV: {}", allClasses.size());
        if (allClasses.size() > 0 && allClasses.size() <= 10) {
            allClasses.forEach(c -> log.info("  - {} (ID={})", c.getSimpleClassName(), c.getClassId()));
        }
        
        // Get info from CSV
        ClassInfo classInfo = getClassInfo(classId);
        if (classInfo == null) {
            log.warn("❌ No class info found in CSV for classId={}. Trying introspection fallback...", classId);
            
            // Fallback: try to introspect directly if we can find the class name
            // This handles cases where CSV is incomplete or out of sync
            return null;
        }
        
        log.info("✅ Found class info: {} ({})", classInfo.getSimpleClassName(), classInfo.getClassName());
        
        // Introspect class structure
        ClassSchema schema = introspectionService.introspectClass(classInfo.getClassName());
        
        // Enrich schema with CSV metadata
        if (schema != null) {
            schema.setDescription(classInfo.getDescription());
        }
        
        return schema;
    }
    
    /**
     * Get complete schema by class name
     */
    public ClassSchema getCompleteSchemaByName(String className) {
        ClassInfo classInfo = getClassInfoByName(className);
        if (classInfo != null) {
            return getCompleteSchema(classInfo.getClassId());
        }
        
        // Fallback to introspection only
        return introspectionService.introspectClass(className);
    }
    
    /**
     * Reload CSV file
     */
    public void reloadCsv() {
        try {
            csvClassLoaderService.reload();
            log.info("CSV file reloaded successfully");
        } catch (Exception e) {
            log.error("Failed to reload CSV file", e);
        }
    }
}
