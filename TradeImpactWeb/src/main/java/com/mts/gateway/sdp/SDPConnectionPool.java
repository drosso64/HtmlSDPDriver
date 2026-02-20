package com.mts.gateway.sdp;

import com.mts.gateway.config.SDPConfigProperties;
import com.mtsmarkets.sdp.smp.MarketFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SDP Connection Pool
 * 
 * Manages a pool of persistent connections to TradeImpact IPSP and Access Points.
 * Provides connection lifecycle management, health checks, and automatic reconnection.
 * 
 * Supports all service types defined in ServiceType enum:
 * - TXN: Transaction service
 * - INFO_BRT: Broadcast information (subscriptions)
 * - INFO_PRIV: Private information
 * - TXN_INFO_PRIV: Private transactions
 * - DATA_FEED: Data feed service
 * - QUERY: Query service
 * 
 * Note: IP_REQUEST is IPSP-only and not pooled.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SDPConnectionPool {
    
    private final SDPConfigProperties config;
    private final com.mts.gateway.websocket.MarketDataWebSocketHandler webSocketHandler;
    private MarketFactory marketFactory; // Will be set when market JAR is loaded
    
    // Connection pools by service type
    private final Map<String, LinkedBlockingQueue<SDPConnection>> connectionPools = new ConcurrentHashMap<>();
    private final Map<String, SDPConnection> activeConnections = new ConcurrentHashMap<>();
    
    private final ReentrantLock initLock = new ReentrantLock();
    private volatile boolean initialized = false;
    
    /**
     * Initialize connection pools (lazy initialization - no connections created yet)
     */
    @PostConstruct
    public void initialize() {
        if (initialized) {
            return;
        }
        
        initLock.lock();
        try {
            if (initialized) {
                return;
            }
            
            log.info("Initializing SDP Connection Pool (lazy mode)");
            log.info("IPSP: {}:{}", config.getIpsp().getHost(), config.getIpsp().getPort());
            log.info("Pool size: min={}, max={}", config.getConnectionPool().getMinSize(), config.getConnectionPool().getMaxSize());
            
            // Initialize empty pools for all service types (except IP_REQUEST which is IPSP-only)
            for (ServiceType serviceType : ServiceType.values()) {
                if (serviceType != ServiceType.IP_REQUEST) {
                    connectionPools.put(serviceType.getName(), new LinkedBlockingQueue<>());
                    log.debug("Initialized pool for service: {} (ID={})", serviceType.getName(), serviceType.getId());
                }
            }
            
            // Don't pre-create connections - will be created on first use after logon
            log.info("Connection pools initialized. Connections will be created after MarketFactory is set.");
            
            initialized = true;
            log.info("SDP Connection Pool initialized successfully");
            
        } catch (Exception e) {
            log.error("Failed to initialize SDP Connection Pool", e);
            throw new RuntimeException("Connection pool initialization failed", e);
        } finally {
            initLock.unlock();
        }
    }
    
    /**
     * Get a connection from the pool
     * 
     * @param serviceType Service type (INFO_BRT, TXN_INFO_PRIV, QUERY)
     * @return Available connection
     * @throws IOException if no connection available within timeout
     */
    public SDPConnection getConnection(String serviceType) throws IOException {
        if (!initialized) {
            throw new IllegalStateException("Connection pool not initialized");
        }
        
        LinkedBlockingQueue<SDPConnection> pool = connectionPools.get(serviceType);
        if (pool == null) {
            throw new IllegalArgumentException("Unknown service type: " + serviceType);
        }
        
        try {
            // Try to get available connection
            SDPConnection connection = pool.poll(
                config.getConnectionPool().getAcquireTimeout().toMillis(),
                TimeUnit.MILLISECONDS
            );
            
            if (connection == null) {
                // No connection available, try to create new one if under max size
                connection = createConnectionIfPossible(serviceType);
                
                if (connection == null) {
                    throw new IOException("No connection available for service: " + serviceType);
                }
            }
            
            // Validate connection
            if (!connection.isAlive()) {
                log.warn("Connection {} is dead, reconnecting", connection.getConnectionId());
                reconnect(connection);
            }
            
            // Acquire connection
            if (!connection.acquire()) {
                // Connection already in use, return to pool and try again
                pool.offer(connection);
                return getConnection(serviceType);
            }
            
            activeConnections.put(connection.getConnectionId(), connection);
            
            log.debug("Acquired connection {} for service {}", connection.getConnectionId(), serviceType);
            
            return connection;
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted while acquiring connection", e);
        }
    }
    
    /**
     * Return connection to the pool
     */
    public void releaseConnection(SDPConnection connection) {
        if (connection == null) {
            return;
        }
        
        connection.release();
        activeConnections.remove(connection.getConnectionId());
        
        LinkedBlockingQueue<SDPConnection> pool = connectionPools.get(connection.getServiceName());
        if (pool != null) {
            pool.offer(connection);
            log.debug("Released connection {} to pool", connection.getConnectionId());
        }
    }
    
    /**
     * Get a transaction connection (TXN_INFO_PRIV)
     * Convenience method for transaction operations
     * 
     * @return Transaction connection
     * @throws IOException if no connection available
     */
    public SDPConnection getTransactionConnection() throws IOException {
        return getConnection(ServiceType.TXN_INFO_PRIV.getName());
    }
    
    /**
     * Get an info connection (INFO_BRT)
     * Convenience method for broadcast subscriptions
     * 
     * @return Info connection
     * @throws IOException if no connection available
     */
    public SDPConnection getInfoConnection() throws IOException {
        return getConnection(ServiceType.INFO_BRT.getName());
    }
    
    /**
     * Get a query connection (QUERY)
     * Convenience method for query operations
     * 
     * @return Query connection
     * @throws IOException if no connection available
     */
    public SDPConnection getQueryConnection() throws IOException {
        return getConnection(ServiceType.QUERY.getName());
    }
    
    /**
     * Create minimum connections for a service
     */
    private void createMinimumConnections(String serviceType) {
        int minSize = config.getConnectionPool().getMinSize();
        
        for (int i = 0; i < minSize; i++) {
            try {
                SDPConnection connection = createConnection(serviceType);
                connectionPools.get(serviceType).offer(connection);
                log.info("Created connection {} for service {}", connection.getConnectionId(), serviceType);
            } catch (Exception e) {
                log.error("Failed to create connection for service {}", serviceType, e);
            }
        }
    }
    
    /**
     * Create new connection if under max size
     */
    private SDPConnection createConnectionIfPossible(String serviceType) {
        LinkedBlockingQueue<SDPConnection> pool = connectionPools.get(serviceType);
        int currentSize = pool.size() + countActiveConnections(serviceType);
        
        if (currentSize < config.getConnectionPool().getMaxSize()) {
            try {
                return createConnection(serviceType);
            } catch (Exception e) {
                log.error("Failed to create new connection for service {}", serviceType, e);
            }
        }
        
        return null;
    }
    
    /**
     * Create a new connection
     */
    private SDPConnection createConnection(String serviceType) throws Exception {
        if (marketFactory == null) {
            throw new IllegalStateException("MarketFactory not initialized - load market JAR first");
        }
        
        String connectionId = UUID.randomUUID().toString();
        
        SDPConnection connection = new SDPConnection(
            connectionId,
            config.getIpsp().getHost(),
            config.getIpsp().getPort(),
            serviceType,
            config.getIpsp().getUsername(),
            config.getIpsp().getPassword(),
            marketFactory
        );
        
        connection.setWebSocketHandler(webSocketHandler);
        connection.connect();
        
        return connection;
    }
    
    /**
     * Set MarketFactory (called when market JAR is loaded)
     */
    public void setMarketFactory(MarketFactory marketFactory) {
        this.marketFactory = marketFactory;
        log.info("MarketFactory set: {}", marketFactory.getClass().getName());
    }
    
    /**
     * Initialize market connections based on AddressServiceResponse
     * 
     * Filters services for the configured market-id and creates connections only for that market.
     * 
     * @param addressResponse Response from IPSP containing all available markets and services
     * @throws Exception if market not found or connection creation fails
     */
    public void initializeMarketConnections(
            com.mtsmarkets.sdp.sap.SAPAddressServiceResExt addressResponse,
            String username,
            String password) throws Exception {
        if (marketFactory == null) {
            throw new IllegalStateException("MarketFactory not initialized - cannot create connections");
        }
        
        Integer targetPlatformId = config.getPlatformId();
        log.info("Filtering address service response for platform ID: {}", targetPlatformId);
        
        // Find the target market in the response
        com.mtsmarkets.sdp.sap.SAPAddressServiceResExt.Platform targetPlatform = null;
        
        for (com.mtsmarkets.sdp.sap.SAPAddressServiceResExt.Platform platform : addressResponse.getPlatforms()) {
            int platformId = (int) platform.getPlatform().getValue();
            
            if (platformId == targetPlatformId) {
                targetPlatform = platform;
                log.info("Found target platform {} in address service response", targetPlatformId);
                break;
            }
        }
        
        if (targetPlatform == null) {
            throw new IllegalStateException(
                String.format("Market ID %d not found in IPSP address service response. " +
                    "Check that this platform is enabled for your user.", targetPlatformId));
        }
        
        // Extract services for target market
        java.util.Map<String, com.mtsmarkets.sdp.sap.SAPAddressServiceResExt.Service> marketServices = new java.util.HashMap<>();
        
        log.info("Processing {} services from platform {}...", targetPlatform.getServices().length, targetPlatformId);
        
        for (com.mtsmarkets.sdp.sap.SAPAddressServiceResExt.Service service : targetPlatform.getServices()) {
            log.debug("Service: type={}, address='{}', port={}", 
                service.getService(), 
                service.getAddress(), 
                service.getPort());
                
            if (service.getService() == null || service.getAddress() == null || service.getAddress().isEmpty()) {
                log.debug("Skipping service - null or empty (type={}, address='{}')", 
                    service.getService(), service.getAddress());
                continue; // Skip empty entries
            }
            
            String serviceType = mapSAPServiceTypeToPoolService(service.getService());
            if (serviceType != null) {
                marketServices.put(serviceType, service);
                log.info("Mapped service {} -> {} ({}:{})", 
                    service.getService(), serviceType, service.getAddress(), service.getPort());
            }
        }
        
        // Create connections for each required service
        for (java.util.Map.Entry<String, com.mtsmarkets.sdp.sap.SAPAddressServiceResExt.Service> entry : marketServices.entrySet()) {
            String serviceType = entry.getKey();
            com.mtsmarkets.sdp.sap.SAPAddressServiceResExt.Service serviceInfo = entry.getValue();
            
            // Double-check address is valid
            if (serviceInfo.getAddress() == null || serviceInfo.getAddress().trim().isEmpty()) {
                log.warn("Skipping service {} - address is null or empty", serviceType);
                continue;
            }
            
            log.info("Creating connections for service {} to {}:{}", 
                serviceType, serviceInfo.getAddress(), serviceInfo.getPort());
            
            // Create minimum connections for this service
            int minSize = config.getConnectionPool().getMinSize();
            for (int i = 0; i < minSize; i++) {
                try {
                    SDPConnection connection = createConnectionToMarket(
                        serviceType,
                        serviceInfo.getAddress(),
                        serviceInfo.getPort(),
                        username,
                        password
                    );
                    connectionPools.get(serviceType).offer(connection);
                    log.info("Created connection {} for service {} (market {})", 
                        connection.getConnectionId(), serviceType, targetPlatformId);
                } catch (Exception e) {
                    log.error("Failed to create connection for service {} (platform {})",
                        serviceType, targetPlatformId, e);
                }
            }
        }
        
        log.info("Market connections initialized successfully for platform ID: {}", targetPlatformId);
    }
    
    /**
     * Map SAPServiceType to internal pool service type
     */
    private String mapSAPServiceTypeToPoolService(com.mtsmarkets.sdp.sap.SAPServiceType sapServiceType) {
        switch (sapServiceType) {
            case INFO_BRT:
                return ServiceType.INFO_BRT.getName();
            case TXN_INFO_PRIV:
                return ServiceType.TXN_INFO_PRIV.getName();
            case QUERY:
                return ServiceType.QUERY.getName();
            default:
                return null; // Ignore other service types
        }
    }
    
    /**
     * Create a connection to a specific market service
     */
    private SDPConnection createConnectionToMarket(
            String serviceType, 
            String address, 
            int port,
            String username,
            String password) throws Exception {
        String connectionId = java.util.UUID.randomUUID().toString();
        
        // Trim address to remove any whitespace or special characters
        String cleanAddress = address != null ? address.trim() : null;
        
        SDPConnection connection = new SDPConnection(
            connectionId,
            cleanAddress,
            port,
            serviceType,
            username,
            password,
            marketFactory
        );
        
        connection.setWebSocketHandler(webSocketHandler);
        connection.connect();
        
        return connection;
    }
    
    /**
     * Reconnect a dead connection
     */
    private void reconnect(SDPConnection connection) throws IOException {
        try {
            connection.close();
            connection.connect();
            log.info("Successfully reconnected {}", connection.getConnectionId());
        } catch (Exception e) {
            log.error("Failed to reconnect {}", connection.getConnectionId(), e);
            throw new IOException("Reconnection failed", e);
        }
    }
    
    /**
     * Count active connections for a service
     */
    private int countActiveConnections(String serviceType) {
        return (int) activeConnections.values().stream()
            .filter(conn -> conn.getServiceName().equals(serviceType))
            .count();
    }
    
    /**
     * Health check - runs every 30 seconds
     */
    @Scheduled(fixedRate = 30000)
    public void healthCheck() {
        if (!initialized || marketFactory == null) {
            // Skip health check until MarketFactory is initialized
            return;
        }
        
        log.debug("Running connection pool health check");
        
        for (Map.Entry<String, LinkedBlockingQueue<SDPConnection>> entry : connectionPools.entrySet()) {
            String serviceType = entry.getKey();
            LinkedBlockingQueue<SDPConnection> pool = entry.getValue();
            
            // Check each connection in pool
            for (SDPConnection connection : pool) {
                if (!connection.isAlive()) {
                    log.warn("Connection {} is dead, removing from pool", connection.getConnectionId());
                    pool.remove(connection);
                    connection.close();
                }
            }
            
            // Only maintain minimum connections if MarketFactory is available
            // (connections are created lazily after logon)
            int currentSize = pool.size();
            int minSize = config.getConnectionPool().getMinSize();
            
            if (currentSize < minSize && currentSize > 0) {
                // Only maintain minimum if we already have some connections
                log.info("Pool {} below minimum size ({} < {}), creating connections", 
                    serviceType, currentSize, minSize);
                createMinimumConnections(serviceType);
            }
        }
    }
    
    /**
     * Cleanup idle connections - runs every minute
     */
    @Scheduled(fixedRate = 60000)
    public void cleanupIdleConnections() {
        if (!initialized) {
            return;
        }
        
        long maxIdleSeconds = config.getConnectionPool().getMaxIdleTime().toSeconds();
        
        for (LinkedBlockingQueue<SDPConnection> pool : connectionPools.values()) {
            for (SDPConnection connection : pool) {
                if (connection.getIdleSeconds() > maxIdleSeconds && 
                    pool.size() > config.getConnectionPool().getMinSize()) {
                    
                    log.info("Closing idle connection {}", connection.getConnectionId());
                    pool.remove(connection);
                    connection.close();
                }
            }
        }
    }
    
    /**
     * Shutdown connection pool
     */
    @PreDestroy
    public void shutdown() {
        if (!initialized) {
            return;
        }
        
        log.info("Shutting down SDP Connection Pool");
        
        // Close all connections
        for (LinkedBlockingQueue<SDPConnection> pool : connectionPools.values()) {
            for (SDPConnection connection : pool) {
                connection.close();
            }
            pool.clear();
        }
        
        // Close active connections
        for (SDPConnection connection : activeConnections.values()) {
            connection.close();
        }
        activeConnections.clear();
        
        // Don't clear the pools themselves - just empty them
        // This allows re-initialization after logout/login
        // connectionPools.clear(); // REMOVED - keep empty pools for reuse
        
        // Keep initialized = true so pools remain available
        // initialized = false; // REMOVED - pool structure remains valid
        
        log.info("SDP Connection Pool shutdown complete");
    }
    
    /**
     * Get pool statistics
     */
    public Map<String, Map<String, Integer>> getPoolStats() {
        Map<String, Map<String, Integer>> stats = new ConcurrentHashMap<>();
        
        for (Map.Entry<String, LinkedBlockingQueue<SDPConnection>> entry : connectionPools.entrySet()) {
            String serviceType = entry.getKey();
            int available = entry.getValue().size();
            int active = countActiveConnections(serviceType);
            
            stats.put(serviceType, Map.of(
                "available", available,
                "active", active,
                "total", available + active
            ));
        }
        
        return stats;
    }
}
