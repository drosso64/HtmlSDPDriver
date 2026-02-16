package com.mts.gateway.service;

import com.mts.gateway.config.SDPConfigProperties;
import com.mts.gateway.dto.ClassInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CSV Class Loader Service
 * 
 * Loads class metadata from a CSV file.
 * CSV format: ClassName,ClassId,ServiceId[,Description]
 * 
 * Example:
 * com.mtsmarkets.sdp.smp.bvf.BV_MARKET,100001,INFO_BRT,Market information
 * com.mtsmarkets.sdp.smp.bvf.BV_QUOTE,100002,INFO_BRT,Quote information
 * com.mtsmarkets.sdp.smp.bvf.BV_TRADE,100003,TXN_INFO_PRIV,Trade transaction
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CsvClassLoaderService {
    
    private final SDPConfigProperties config;
    
    // Cache for loaded classes
    private final Map<Long, ClassInfo> classesById = new ConcurrentHashMap<>();
    private final Map<String, ClassInfo> classesByName = new ConcurrentHashMap<>();
    private final List<ClassInfo> allClasses = new ArrayList<>();
    
    private volatile boolean loaded = false;
    
    /**
     * Initialize and load CSV on startup
     */
    @PostConstruct
    public void initialize() {
        log.info("Initializing CSV Class Loader Service");
        String csvPath = config.getClassesCsv();
        
        if (csvPath == null || csvPath.isEmpty()) {
            log.warn("No classes CSV file configured (sdp.classes-csv). Class list will be empty.");
            return;
        }
        
        try {
            loadFromCsv(csvPath);
            log.info("Successfully loaded {} classes from CSV: {}", allClasses.size(), csvPath);
        } catch (Exception e) {
            log.error("Failed to load classes from CSV: {}", csvPath, e);
        }
    }
    
    /**
     * Load classes from CSV file
     * 
     * @param csvPath Path to CSV file
     * @throws IOException if file cannot be read
     */
    public void loadFromCsv(String csvPath) throws IOException {
        Path path = Paths.get(csvPath);
        
        if (!Files.exists(path)) {
            log.error("CSV file not found: {}", csvPath);
            throw new IOException("CSV file not found: " + csvPath);
        }
        
        log.info("Loading classes from CSV: {}", csvPath);
        
        // Clear existing data
        classesById.clear();
        classesByName.clear();
        allClasses.clear();
        
        int lineNumber = 0;
        int loadedCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                
                // Skip empty lines and comments
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#") || line.startsWith("//")) {
                    continue;
                }
                
                // Skip header line if present
                if (lineNumber == 1 && line.toLowerCase().startsWith("classname")) {
                    log.debug("Skipping CSV header line");
                    continue;
                }
                
                try {
                    ClassInfo classInfo = parseCsvLine(line);
                    if (classInfo != null) {
                        addClassInfo(classInfo);
                        loadedCount++;
                    }
                } catch (Exception e) {
                    log.warn("Failed to parse CSV line {}: {} - Error: {}", lineNumber, line, e.getMessage());
                }
            }
        }
        
        log.info("Loaded {} classes from {} lines in CSV file", loadedCount, lineNumber);
        loaded = true;
    }
    
    /**
     * Parse a CSV line
     * 
     * Format: ClassName,ClassId,ServiceId[,Description]
     */
    private ClassInfo parseCsvLine(String line) {
        String[] parts = line.split(",", -1);
        
        if (parts.length < 3) {
            log.warn("Invalid CSV line (need at least 3 fields): {}", line);
            return null;
        }
        
        try {
            String className = parts[0].trim();
            Long classId = Long.parseLong(parts[1].trim());
            String serviceId = parts[2].trim();
            String description = parts.length > 3 ? parts[3].trim() : null;
            
            // Extract simple class name
            String simpleClassName = className;
            int lastDot = className.lastIndexOf('.');
            if (lastDot >= 0) {
                simpleClassName = className.substring(lastDot + 1);
            }
            
            return ClassInfo.builder()
                .className(className)
                .simpleClassName(simpleClassName)
                .classId(classId)
                .serviceId(serviceId)
                .description(description)
                .build();
                
        } catch (NumberFormatException e) {
            log.warn("Invalid class ID in CSV line: {}", line);
            return null;
        }
    }
    
    /**
     * Add class info to cache
     */
    private void addClassInfo(ClassInfo classInfo) {
        classesById.put(classInfo.getClassId(), classInfo);
        classesByName.put(classInfo.getClassName(), classInfo);
        classesByName.put(classInfo.getSimpleClassName(), classInfo);
        allClasses.add(classInfo);
        
        log.debug("Added class: {} (ID={}, Service={})", 
            classInfo.getSimpleClassName(), classInfo.getClassId(), classInfo.getServiceId());
    }
    
    /**
     * Get all available classes
     */
    public List<ClassInfo> getAllClasses() {
        return new ArrayList<>(allClasses);
    }
    
    /**
     * Get class by ID
     */
    public ClassInfo getClassById(Long classId) {
        return classesById.get(classId);
    }
    
    /**
     * Get class by name (supports both simple and fully qualified names)
     */
    public ClassInfo getClassByName(String className) {
        return classesByName.get(className);
    }
    
    /**
     * Check if classes are loaded
     */
    public boolean isLoaded() {
        return loaded;
    }
    
    /**
     * Get classes by service ID
     */
    public List<ClassInfo> getClassesByService(String serviceId) {
        List<ClassInfo> result = new ArrayList<>();
        for (ClassInfo classInfo : allClasses) {
            if (serviceId.equals(classInfo.getServiceId())) {
                result.add(classInfo);
            }
        }
        return result;
    }
    
    /**
     * Reload CSV file
     */
    public void reload() throws IOException {
        String csvPath = config.getClassesCsv();
        if (csvPath != null && !csvPath.isEmpty()) {
            loadFromCsv(csvPath);
        }
    }
}
