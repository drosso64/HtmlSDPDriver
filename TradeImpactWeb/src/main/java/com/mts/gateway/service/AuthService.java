package com.mts.gateway.service;

import com.mts.gateway.config.SDPConfigProperties;
import com.mts.gateway.dto.LoginRequest;
import com.mts.gateway.dto.LoginResponse;
import com.mts.gateway.sdp.SDPConnection;
import com.mts.gateway.sdp.SDPConnectionPool;
import com.mtsmarkets.sdp.sap.SAPAddressServiceReqExt;
import com.mtsmarkets.sdp.sap.SAPAddressServiceResExt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Authentication Service
 * 
 * Manages user sessions and IPSP connections.
 * IPSP connection is established only after successful login.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final SDPConnectionPool connectionPool;
    private final SDPConfigProperties config;
    private final com.mts.gateway.classloader.SDPClassLoaderService classLoaderService;
    
    // Active sessions: token -> session info
    private final Map<String, SessionInfo> activeSessions = new ConcurrentHashMap<>();
    
    // Temporary connection for address service request
    private SDPConnection ipspConnection;
    
    /**
     * Perform login and establish IPSP connection
     */
    public LoginResponse login(LoginRequest request) throws Exception {
        log.info("Attempting login for user: {}", request.getUsername());
        
        // TODO: Validate user credentials against database or external auth service
        // For now, we'll accept any non-empty credentials
        
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        
        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        
        // Update IPSP configuration with user-provided values
        System.setProperty("IPSP_HOST", request.getIpspHost());
        System.setProperty("IPSP_PORT", String.valueOf(request.getIpspPort()));
        System.setProperty("IPSP_SSL", String.valueOf(request.isUseSsl()));
        
        // Step 1: Connect to IPSP and request address service
        log.info("Connecting to IPSP at {}:{}", request.getIpspHost(), request.getIpspPort());
        
        try {
            // Get MarketFactory from class loader service
            com.mtsmarkets.sdp.smp.MarketFactory marketFactory = classLoaderService.getMarketFactory();
            if (marketFactory == null) {
                throw new IllegalStateException("MarketFactory not initialized. Check market JAR configuration.");
            }
            
            // Create temporary connection to IPSP for address service request
            ipspConnection = new SDPConnection(
                UUID.randomUUID().toString(),
                request.getIpspHost(),
                request.getIpspPort(),
                "IPSP_ADDRESS_SERVICE", // Service label for IPSP address service
                request.getUsername(),
                request.getPassword(),
                marketFactory
            );
            
            // IMPORTANT: Prepare the future BEFORE connecting
            // because onLogon() will send the address service request automatically
            ipspConnection.prepareAddressServiceFuture();
            
            // Connect and wait for logon
            ipspConnection.connect();
            
            // Wait for connection to be established
            int maxWaitSeconds = 10;
            for (int i = 0; i < maxWaitSeconds; i++) {
                if (ipspConnection.isConnected() && ipspConnection.isLoggedIn()) {
                    break;
                }
                Thread.sleep(1000);
            }
            
            if (!ipspConnection.isLoggedIn()) {
                throw new IllegalStateException("Failed to login to IPSP");
            }
            
            log.info("Successfully logged in to IPSP");
            
            // Step 2: Request address service information
            log.info("Requesting address service information for all enabled markets");
            
            SAPAddressServiceResExt addressResponse = requestAddressService();
            
            if (addressResponse == null) {
                throw new IllegalStateException("Failed to receive address service response from IPSP");
            }
            
            log.info("Received address service response");
            
            // Step 3: Initialize connections only for configured market
            // Use the same credentials as IPSP login
            log.info("Initializing connections for platform ID: {}", config.getPlatformId());
            connectionPool.initializeMarketConnections(
                addressResponse, 
                request.getUsername(), 
                request.getPassword()
            );
            
            // Close IPSP connection (no longer needed)
            ipspConnection.close();
            ipspConnection = null;
            
            // Generate session token
            String token = UUID.randomUUID().toString();
            
            // Store session
            SessionInfo session = SessionInfo.builder()
                .token(token)
                .username(request.getUsername())
                .ipspHost(request.getIpspHost())
                .ipspPort(request.getIpspPort())
                .useSsl(request.isUseSsl())
                .loginTime(System.currentTimeMillis())
                .build();
            
            activeSessions.put(token, session);
            
            log.info("Login successful. Market connections established for platform {}", config.getPlatformId());
            
            return LoginResponse.builder()
                .success(true)
                .message("Login successful. Connected to platform " + config.getPlatformId())
                .token(token)
                .username(request.getUsername())
                .ipspHost(request.getIpspHost())
                .ipspPort(request.getIpspPort())
                .connected(true)
                .build();
                
        } catch (Exception e) {
            log.error("Login failed", e);
            
            // Cleanup on failure
            if (ipspConnection != null) {
                try {
                    ipspConnection.close();
                } catch (Exception ex) {
                    log.warn("Failed to close IPSP connection", ex);
                }
                ipspConnection = null;
            }
            
            throw new RuntimeException("Login failed: " + e.getMessage(), e);
        }
    }
    
    /**
     * Request address service information from IPSP
     */
    private SAPAddressServiceResExt requestAddressService() throws Exception {
        log.info("Sending AddressServiceReqExt to IPSP");
        
        // Use the connection's method to request and receive address service information
        return ipspConnection.requestAddressService();
    }
    
    /**
     * Logout and close connections
     * Called by explicit logout (button) or implicit logout (WebSocket close)
     */
    public void logout(String token) {
        // Remove the specific session (may be null if called from WebSocket close)
        if (token != null) {
            SessionInfo session = activeSessions.remove(token);
            if (session != null) {
                log.info("User {} logged out", session.getUsername());
            }
        }
        
        // Always close all SDP connections and clear all sessions
        // (SDP connections are shared, so logout affects everyone)
        logoutAll();
    }
    
    /**
     * Internal method to close all connections and clear all sessions
     */
    private void logoutAll() {
        if (!activeSessions.isEmpty()) {
            log.info("Clearing {} active session(s)", activeSessions.size());
            activeSessions.clear();
        }
        
        // Close all SDP connections to Access Points
        try {
            connectionPool.shutdown();
            log.info("SDP connections closed successfully");
        } catch (Exception e) {
            log.error("Error closing SDP connections during logout", e);
        }
    }
    
    /**
     * Validate session token
     */
    public LoginResponse validateSession(String token) throws Exception {
        SessionInfo session = activeSessions.get(token);
        
        if (session == null) {
            throw new IllegalArgumentException("Invalid or expired session");
        }
        
        return LoginResponse.builder()
            .success(true)
            .token(token)
            .username(session.getUsername())
            .ipspHost(session.getIpspHost())
            .ipspPort(session.getIpspPort())
            .connected(true)
            .build();
    }
    
    /**
     * Get session info by token
     */
    public SessionInfo getSession(String token) {
        return activeSessions.get(token);
    }
    
    /**
     * Session information holder
     */
    @lombok.Data
    @lombok.Builder
    public static class SessionInfo {
        private String token;
        private String username;
        private String ipspHost;
        private Integer ipspPort;
        private boolean useSsl;
        private long loginTime;
    }
}
