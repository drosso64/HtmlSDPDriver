package com.mts.gateway.classloader;

import com.mts.gateway.config.SDPConfigProperties;
import com.mts.gateway.sdp.SDPConnectionPool;
import com.mtsmarkets.sdp.smp.MarketFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Dynamic SDP ClassLoader Service
 * 
 * Loads market classes JARs dynamically at runtime without compile-time dependencies.
 * Supports hot-reload on JAR file changes.
 * 
 * Architecture:
 * - Isolated URLClassLoader for market classes
 * - WatchService for monitoring JAR file changes
 * - Thread-safe reload mechanism
 * - Notification system for class reload events
 */
@Service
@Slf4j
public class SDPClassLoaderService {

    private final SDPConfigProperties config;
    private final SDPConnectionPool connectionPool;
    private volatile URLClassLoader marketClassLoader;
    private volatile MarketFactory marketFactory;
    private final List<ClassLoaderReloadListener> reloadListeners = new CopyOnWriteArrayList<>();
    private WatchService watchService;
    private ScheduledExecutorService watchExecutor;
    private final Object reloadLock = new Object();

    public SDPClassLoaderService(SDPConfigProperties config, SDPConnectionPool connectionPool) {
        this.config = config;
        this.connectionPool = connectionPool;
    }

    @PostConstruct
    public void initialize() {
        log.info("Initializing SDP ClassLoader Service");
        try {
            loadMarketClasses();
            createMarketFactory();
            
            if (config.isAutoReload()) {
                startWatchService();
            }
            
            log.info("SDP ClassLoader Service initialized successfully");
        } catch (Exception e) {
            log.error("Failed to initialize SDP ClassLoader Service", e);
            throw new RuntimeException("ClassLoader initialization failed", e);
        }
    }

    @PreDestroy
    public void shutdown() {
        log.info("Shutting down SDP ClassLoader Service");
        
        if (watchExecutor != null) {
            watchExecutor.shutdown();
        }
        
        if (watchService != null) {
            try {
                watchService.close();
            } catch (Exception e) {
                log.warn("Error closing watch service", e);
            }
        }
        
        if (marketClassLoader != null) {
            try {
                marketClassLoader.close();
            } catch (Exception e) {
                log.warn("Error closing class loader", e);
            }
        }
    }

    /**
     * Load market classes from configured JAR file
     */
    private void loadMarketClasses() throws Exception {
        synchronized (reloadLock) {
            List<URL> urls = new ArrayList<>();
            
            // Add main market classes JAR
            String mainJarPath = config.getMarketClassesJar();
            if (mainJarPath != null && !mainJarPath.isEmpty()) {
                File jarFile = new File(mainJarPath);
                if (jarFile.exists()) {
                    urls.add(jarFile.toURI().toURL());
                    log.info("Added market classes JAR: {}", jarFile.getAbsolutePath());
                } else {
                    log.warn("Market classes JAR not found: {}", mainJarPath);
                }
            }
            
            // Add additional JARs
            String additionalJars = config.getAdditionalJars();
            if (additionalJars != null && !additionalJars.isEmpty()) {
                for (String jarPath : additionalJars.split(",")) {
                    File jarFile = new File(jarPath.trim());
                    if (jarFile.exists()) {
                        urls.add(jarFile.toURI().toURL());
                        log.info("Added additional JAR: {}", jarFile.getAbsolutePath());
                    }
                }
            }
            
            // Close previous class loader
            if (marketClassLoader != null) {
                try {
                    marketClassLoader.close();
                } catch (Exception e) {
                    log.warn("Error closing previous class loader", e);
                }
            }
            
            // Create new class loader
            if (!urls.isEmpty()) {
                marketClassLoader = new URLClassLoader(
                    urls.toArray(new URL[0]),
                    getClass().getClassLoader() // Parent: application classloader
                );
                log.info("Market class loader created with {} JAR(s)", urls.size());
            } else {
                log.warn("No market classes JARs found - class loader not initialized");
            }
        }
    }
    
    /**
     * Create MarketFactory from loaded classes
     * This is called after market JAR is loaded to instantiate the MarketFactory
     * and pass it to the SDPConnectionPool
     */
    private void createMarketFactory() throws Exception {
        if (marketClassLoader == null) {
            log.warn("Market class loader not initialized - skipping MarketFactory creation");
            return;
        }
        
        synchronized (reloadLock) {
            try {
                Class<?> factoryClass = null;
                
                // Check if factory class is explicitly configured
                if (config.getMarketFactoryClass() != null && !config.getMarketFactoryClass().isEmpty()) {
                    log.info("Using configured MarketFactory class: {}", config.getMarketFactoryClass());
                    factoryClass = Class.forName(config.getMarketFactoryClass(), true, marketClassLoader);
                } else {
                    // Auto-detect: scan JAR for MarketFactory implementations
                    log.info("No factory class configured, scanning JAR for MarketFactory implementations");
                    factoryClass = findMarketFactoryImplementation();
                }
                
                if (factoryClass == null) {
                    log.error("Could not find any MarketFactory implementation in market JAR");
                    throw new ClassNotFoundException("No MarketFactory implementation found");
                }
                
                log.info("Using MarketFactory implementation: {}", factoryClass.getName());
                
                // Create instance (factory implementations should have default constructor)
                Object factoryInstance = factoryClass.getDeclaredConstructor().newInstance();
                
                if (factoryInstance instanceof MarketFactory) {
                    marketFactory = (MarketFactory) factoryInstance;
                    
                    // Pass MarketFactory to connection pool
                    connectionPool.setMarketFactory(marketFactory);
                    
                    log.info("MarketFactory created and passed to connection pool: {}", marketFactory.getClass().getName());
                } else {
                    throw new IllegalStateException("Loaded class is not a MarketFactory instance");
                }
                
            } catch (ClassNotFoundException e) {
                log.error("MarketFactory class not found in loaded JARs. Make sure sdp-client JAR is included.", e);
                throw e;
            } catch (Exception e) {
                log.error("Failed to create MarketFactory instance", e);
                throw e;
            }
        }
    }
    
    /**
     * Find MarketFactory implementation by scanning JAR
     */
    private Class<?> findMarketFactoryImplementation() throws Exception {
        log.info("Scanning market JAR for MarketFactory implementations");
        
        // Common patterns for market factory classes
        String[] patterns = {
            "com.mtsmarkets.sdp.smp.bvf.BVF_Factory",      // BVF
            "com.mtsmarkets.sdp.smp.cmf.CMF_Factory",      // CMF
            "com.mtsmarkets.sdp.smp.mts.MTS_Factory",      // MTS
            "com.mtsmarkets.sdp.smp.euromts.EMTS_Factory", // EuroMTS
        };
        
        // Try common patterns first
        for (String className : patterns) {
            try {
                Class<?> clazz = Class.forName(className, true, marketClassLoader);
                if (MarketFactory.class.isAssignableFrom(clazz)) {
                    log.info("Found MarketFactory implementation: {}", className);
                    return clazz;
                }
            } catch (ClassNotFoundException e) {
                log.debug("Pattern {} not found", className);
            }
        }
        
        // If not found, scan JAR entries
        log.info("Common patterns not found, scanning JAR file: {}", config.getMarketClassesJar());
        
        java.io.File jarFile = new java.io.File(config.getMarketClassesJar());
        if (!jarFile.exists()) {
            throw new java.io.FileNotFoundException("Market JAR not found: " + config.getMarketClassesJar());
        }
        
        try (java.util.jar.JarFile jar = new java.util.jar.JarFile(jarFile)) {
            java.util.Enumeration<java.util.jar.JarEntry> entries = jar.entries();
            
            while (entries.hasMoreElements()) {
                java.util.jar.JarEntry entry = entries.nextElement();
                String name = entry.getName();
                
                // Look for classes ending with _Factory or Factory in smp package
                if (name.endsWith(".class") && 
                    name.contains("com/mtsmarkets/sdp/smp/") && 
                    (name.endsWith("_Factory.class") || name.endsWith("Factory.class"))) {
                    
                    // Convert path to class name
                    String className = name.replace('/', '.').replace(".class", "");
                    
                    try {
                        Class<?> clazz = Class.forName(className, true, marketClassLoader);
                        
                        // Check if it implements MarketFactory
                        if (MarketFactory.class.isAssignableFrom(clazz) && 
                            !clazz.isInterface() && 
                            !java.lang.reflect.Modifier.isAbstract(clazz.getModifiers())) {
                            
                            log.info("Found MarketFactory implementation by scanning: {}", className);
                            return clazz;
                        }
                    } catch (Exception e) {
                        log.debug("Could not load class {}: {}", className, e.getMessage());
                    }
                }
            }
        }
        
        log.error("No MarketFactory implementation found in JAR");
        return null;
    }
    
    /**
     * Get MarketFactory instance (available after initialization)
     */
    public MarketFactory getMarketFactory() {
        return marketFactory;
    }
    
    /**
     * Get market class loader (available after initialization)
     */
    public URLClassLoader getMarketClassLoader() {
        return marketClassLoader;
    }

    /**
     * Start watch service for auto-reload
     */
    private void startWatchService() {
        try {
            watchService = FileSystems.getDefault().newWatchService();
            
            // Register directory containing JAR file
            String jarPath = config.getMarketClassesJar();
            if (jarPath != null) {
                File jarFile = new File(jarPath);
                Path dirPath = jarFile.getParentFile().toPath();
                dirPath.register(watchService, 
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_CREATE);
                
                log.info("Started watching directory for changes: {}", dirPath);
            }
            
            // Schedule periodic check
            watchExecutor = Executors.newSingleThreadScheduledExecutor();
            watchExecutor.scheduleWithFixedDelay(
                this::checkForChanges,
                config.getReloadCheckInterval().getSeconds(),
                config.getReloadCheckInterval().getSeconds(),
                TimeUnit.SECONDS
            );
            
        } catch (Exception e) {
            log.error("Failed to start watch service", e);
        }
    }

    /**
     * Check for JAR file changes
     */
    private void checkForChanges() {
        try {
            WatchKey key = watchService.poll();
            if (key != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    Path changed = (Path) event.context();
                    
                    // Check if it's our JAR file
                    String jarFileName = new File(config.getMarketClassesJar()).getName();
                    if (changed.toString().equals(jarFileName)) {
                        log.info("Detected change in market classes JAR, reloading...");
                        reload();
                    }
                }
                key.reset();
            }
        } catch (Exception e) {
            log.error("Error checking for file changes", e);
        }
    }

    /**
     * Reload market classes
     */
    public void reload() {
        log.info("Reloading market classes...");
        try {
            loadMarketClasses();
            notifyReloadListeners();
            log.info("Market classes reloaded successfully");
        } catch (Exception e) {
            log.error("Failed to reload market classes", e);
            throw new RuntimeException("Reload failed", e);
        }
    }

    /**
     * Known SDP packages for resolving simple class names.
     * All market classes reside in one of these packages.
     */
    private static final String[] KNOWN_PACKAGES = {
        "com.mtsmarkets.sdp.smp.bvf",
        "com.mtsmarkets.sdp.smp.cmf",
        "com.mtsmarkets.sdp.smp.mts",
        "com.mtsmarkets.sdp.smp.euromts"
    };

    /**
     * Load a class by name from market class loader.
     * 
     * Supports both fully qualified names (com.mtsmarkets.sdp.smp.bvf.BV_BOND)
     * and simple names (BV_BOND). If a simple name is provided, it tries all
     * known SDP packages until a match is found.
     * 
     * @param className Simple or fully qualified class name
     * @return The loaded Class
     * @throws ClassNotFoundException if class not found in any known package
     */
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        if (marketClassLoader == null) {
            throw new IllegalStateException("Market class loader not initialized");
        }
        
        // If already fully qualified (contains a dot), load directly
        if (className.contains(".")) {
            return Class.forName(className, true, marketClassLoader);
        }
        
        // Simple name: try all known packages
        for (String pkg : KNOWN_PACKAGES) {
            String fqn = pkg + "." + className;
            try {
                Class<?> clazz = Class.forName(fqn, true, marketClassLoader);
                log.debug("Resolved simple name '{}' → '{}'", className, fqn);
                return clazz;
            } catch (ClassNotFoundException e) {
                // Try next package
            }
        }
        
        throw new ClassNotFoundException(
            "Class '" + className + "' not found in any known package: " + 
            String.join(", ", KNOWN_PACKAGES));
    }

    /**
     * Check if class loader is initialized
     */
    public boolean isInitialized() {
        return marketClassLoader != null;
    }

    /**
     * Register reload listener
     */
    public void addReloadListener(ClassLoaderReloadListener listener) {
        reloadListeners.add(listener);
    }

    /**
     * Unregister reload listener
     */
    public void removeReloadListener(ClassLoaderReloadListener listener) {
        reloadListeners.remove(listener);
    }

    /**
     * Notify all reload listeners
     */
    private void notifyReloadListeners() {
        for (ClassLoaderReloadListener listener : reloadListeners) {
            try {
                listener.onClassLoaderReload();
            } catch (Exception e) {
                log.error("Error notifying reload listener", e);
            }
        }
    }

    /**
     * Interface for reload notifications
     */
    public interface ClassLoaderReloadListener {
        void onClassLoaderReload();
    }
}
