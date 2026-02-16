package com.mts.gateway.sdp;

import com.mts.gateway.dto.TransactionResponse;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.sdp.client.*;
import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.common.SDPResult;
import com.mtsmarkets.sdp.sap.*;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.smp.SMPMessage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * SDP Connection - Following pattern from SampleBRTSubscribe and SampleTXNTransaction
 * 
 * Manages SDP protocol connections using SAPBroadcastChannel, SAPTransactionChannel,
 * and SAPAddressServiceChannel for communication with TradeImpact server.
 */
@Slf4j
@Getter
public class SDPConnection implements Closeable {
    
    private final String connectionId;
    private final String host;
    private final int port;
    private final String serviceName;
    private final String username;
    private final String password;
    private final MarketFactory marketFactory;
    
    // Optional WebSocket handler for broadcasting data
    private Object webSocketHandler;
    
    private BroadcastChannelImpl broadcastChannel;
    private TransactionChannelImpl transactionChannel;
    private AddressServiceChannelImpl addressServiceChannel;
    
    private final AtomicBoolean connected = new AtomicBoolean(false);
    private final AtomicBoolean loggedIn = new AtomicBoolean(false);
    private final AtomicBoolean inUse = new AtomicBoolean(false);
    
    // CompletableFuture for address service response
    private CompletableFuture<SAPAddressServiceResExt> addressServiceFuture;
    
    // Transaction response tracking
    private final Map<Long, CompletableFuture<TransactionResponse>> pendingTransactions = new ConcurrentHashMap<>();
    private final AtomicLong transactionIdCounter = new AtomicLong(1);
    
    private Instant lastActivity;
    private Instant createdAt;
    
    public SDPConnection(String connectionId, String host, int port, String serviceName, 
                         String username, String password, MarketFactory marketFactory) {
        this.connectionId = connectionId;
        this.host = host;
        this.port = port;
        this.serviceName = serviceName;
        this.username = username;
        this.password = password;
        this.marketFactory = marketFactory;
        this.createdAt = Instant.now();
        this.lastActivity = Instant.now();
    }
    
    /**
     * Set WebSocket handler for broadcasting market data
     */
    public void setWebSocketHandler(Object handler) {
        this.webSocketHandler = handler;
        log.debug("WebSocket handler set for connection {}", connectionId);
    }
    
    /**
     * Connect to TradeImpact server - follows pattern from samples
     */
    public void connect() throws SDPException {
        if (connected.get()) {
            log.warn("Connection {} already connected", connectionId);
            return;
        }
        
        boolean isIPSP = "IPSP_ADDRESS_SERVICE".equals(serviceName);
        
        log.info("========================================");
        log.info("Connecting to {}: {}:{}", isIPSP ? "IPSP" : "Access Point", host, port);
        log.info("Service: {}", serviceName);
        log.info("Username: {}", username);
        log.info("Connection ID: {}", connectionId);
        log.info("========================================");
        
        try {
            // Create TCP context (no SSL for now)
            log.debug("Creating TCP context...");
            TCPContext tcpContext = new TCPContext();
            
            if (isIPSP) {
                // IPSP connection - only AddressServiceChannel needed
                log.debug("Creating address service context and channel for IPSP...");
                AddressServiceContext addressContext = new AddressServiceContext(marketFactory, tcpContext);
                addressServiceChannel = new AddressServiceChannelImpl(addressContext);
                
                log.debug("Connecting to IPSP...");
                addressServiceChannel.connect(host, port);
                
            } else {
                // Access Point connection - create appropriate channels based on service type
                log.debug("Creating channels for Access Point...");
                
                // Create broadcast channel (for INFO_BRT service)
                if ("INFO_BRT".equals(serviceName)) {
                    log.info("Creating broadcast channel for INFO_BRT service...");
                    BroadcastContext brtContext = new BroadcastContext(marketFactory, tcpContext);
                    broadcastChannel = new BroadcastChannelImpl(brtContext);
                    
                    log.info("About to connect broadcast channel:");
                    log.info("  host = '{}' (length={}, null={})", host, host != null ? host.length() : -1, host == null);
                    log.info("  port = {}", port);
                    
                    broadcastChannel.connect(host, port);
                    log.info("Broadcast channel connect() method completed");
                }
                // Create transaction channel (for TXN_INFO_PRIV or QUERY services)
                else if ("TXN_INFO_PRIV".equals(serviceName) || "QUERY".equals(serviceName)) {
                    log.info("Creating transaction channel for {} service...", serviceName);
                    TransactionContext txnContext = new TransactionContext(marketFactory, tcpContext);
                    transactionChannel = new TransactionChannelImpl(txnContext);
                    
                    log.info("About to connect transaction channel:");
                    log.info("  host = '{}' (length={}, null={})", host, host != null ? host.length() : -1, host == null);
                    log.info("  port = {}", port);
                    
                    transactionChannel.connect(host, port);
                    log.info("Transaction channel connect() method completed");
                } else {
                    throw new SDPException(com.mtsmarkets.sdp.common.SDPResultCode.TCP_CONNECT_FAILED, 
                        "Unknown service type: " + serviceName);
                }
            }
            
            connected.set(true);
            log.info("✓ Connected successfully to {}:{}", host, port);
            log.info("Waiting for onConnected() callback...");
            touchActivity();
            
        } catch (SDPException e) {
            log.error("✗ FAILED to connect to {}:{} - {}", host, port, e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error("✗ Unexpected error during connection: {}", e.getMessage(), e);
            throw new SDPException(com.mtsmarkets.sdp.common.SDPResultCode.TCP_CONNECT_FAILED, e.getMessage());
        }
    }
    
    /**
     * Disconnect from server
     */
    public void disconnect() {
        if (!connected.get()) {
            return;
        }
        
        log.info("Disconnecting from {}:{}", host, port);
        
        try {
            if (broadcastChannel != null) {
                broadcastChannel.disconnect();
            }
            if (transactionChannel != null) {
                transactionChannel.disconnect();
            }
            if (addressServiceChannel != null) {
                addressServiceChannel.disconnect();
            }
        } catch (Exception e) {
            log.error("Error disconnecting channels", e);
        }
        
        connected.set(false);
        loggedIn.set(false);
        log.info("Disconnected from {}:{}", host, port);
    }
    
    /**
     * Prepare the future for address service response.
     * MUST be called BEFORE connect() to ensure the future is ready
     * when the automatic response arrives in onLogon().
     */
    public void prepareAddressServiceFuture() {
        log.info("Preparing CompletableFuture for address service response");
        addressServiceFuture = new CompletableFuture<>();
    }
    
    /**
     * Request address service information from IPSP
     * 
     * The request is automatically sent after successful login.
     * This method just waits for the response.
     * 
     * @return SAPAddressServiceResExt with all available markets and services
     * @throws Exception if request fails or timeout occurs
     */
    public SAPAddressServiceResExt requestAddressService() throws Exception {
        if (addressServiceFuture == null) {
            throw new IllegalStateException("Future not prepared. Call prepareAddressServiceFuture() before connect()");
        }
        
        log.info("Waiting for address service response (request was sent automatically after login)...");
        
        try {
            // Wait for response with timeout (30 seconds)
            // The request is sent automatically in onLogon()
            SAPAddressServiceResExt response = addressServiceFuture.get(30, TimeUnit.SECONDS);
            
            log.info("Address service response received successfully");
            
            return response;
            
        } catch (java.util.concurrent.TimeoutException e) {
            log.error("Timeout waiting for address service response");
            throw new Exception("Timeout waiting for address service response", e);
        } catch (Exception e) {
            log.error("Error requesting address service", e);
            throw new Exception("Failed to request address service: " + e.getMessage(), e);
        } finally {
            addressServiceFuture = null;
        }
    }
    
    /**
     * Check if connection is alive and logged in
     */
    public boolean isAlive() {
        return connected.get() && loggedIn.get();
    }
    
    /**
     * Check if connected to server
     */
    public boolean isConnected() {
        return connected.get();
    }
    
    /**
     * Check if logged in
     */
    public boolean isLoggedIn() {
        return loggedIn.get();
    }
    
    /**
     * Get idle time in seconds
     */
    public long getIdleSeconds() {
        return java.time.Duration.between(lastActivity, Instant.now()).getSeconds();
    }
    
    /**
     * Mark connection as in use
     */
    public boolean acquire() {
        return inUse.compareAndSet(false, true);
    }
    
    /**
     * Release connection back to pool
     */
    public void release() {
        inUse.set(false);
        touchActivity();
    }
    
    /**
     * Update last activity timestamp
     */
    public void touchActivity() {
        this.lastActivity = Instant.now();
    }
    
    // =========================================================================    // Subscription Methods
    // =========================================================================
    
    /**
     * Start subscription for a class
     * 
     * @param classId The class ID to subscribe to
     * @param filterKey Optional filter key (can be null)
     * @throws IllegalStateException if no suitable channel is available
     * @throws SDPException if subscription request fails
     */
    public void subscribe(ULong classId, ULong filterKey) throws SDPException {
        // Try broadcast channel first (INFO_BRT, INFO_PRIV services)
        if (broadcastChannel != null) {
            log.info("Using broadcast channel for subscription");
            broadcastChannel.startSubscribe(classId, filterKey);
            return;
        }
        
        // Fall back to transaction channel (TXN_INFO_PRIV, DATA_FEED, QUERY services)
        if (transactionChannel != null) {
            log.info("Using transaction channel for subscription");
            transactionChannel.startSubscribe(classId, filterKey);
            return;
        }
        
        throw new IllegalStateException("No suitable channel available for subscription");
    }
    
    // =========================================================================    // Transaction Methods - Send actions to the market
    // =========================================================================
    
    /**
     * Send a standard transaction (SAPActionReq)
     * 
     * @param smpMessage The market message to send
     * @param action Action type (ADD/DEL/RWT/KILL)
     * @return CompletableFuture with transaction response
     */
    public CompletableFuture<TransactionResponse> sendTransaction(SMPMessage smpMessage, String action) {
        if (transactionChannel == null) {
            return CompletableFuture.failedFuture(
                new IllegalStateException("Transaction channel not initialized"));
        }
        
        long txnId = transactionIdCounter.getAndIncrement();
        CompletableFuture<TransactionResponse> future = new CompletableFuture<>();
        pendingTransactions.put(txnId, future);
        
        try {
            SAPActionReq request = new SAPActionReq(smpMessage);
            // Set transaction ID as ULong array [high, low]
            request.setTransId(new ULong[] { new ULong(0), new ULong(txnId) });
            request.setAction(SAPActionType.valueOf(action));
            
            log.info("Sending transaction: id={} action={} class={}", 
                txnId, action, smpMessage.getClass().getSimpleName());
            
            transactionChannel.action(request);
            touchActivity();
            
            // Set timeout
            future.orTimeout(30, TimeUnit.SECONDS)
                .whenComplete((result, error) -> {
                    if (error != null) {
                        pendingTransactions.remove(txnId);
                    }
                });
            
            return future;
            
        } catch (Exception e) {
            pendingTransactions.remove(txnId);
            log.error("Failed to send transaction", e);
            return CompletableFuture.failedFuture(e);
        }
    }
    
    /**
     * Send a monitored transaction (SAPMonitoredActionReq)
     * 
     * Monitored transactions allow tracking lifecycle through status updates.
     * 
     * @param smpMessage The market message to send
     * @param action Action type (ADD/DEL/RWT/KILL)
     * @return CompletableFuture with transaction response
     */
    public CompletableFuture<TransactionResponse> sendMonitoredTransaction(
            SMPMessage smpMessage, String action) {
        
        if (transactionChannel == null) {
            return CompletableFuture.failedFuture(
                new IllegalStateException("Transaction channel not initialized"));
        }
        
        long txnId = transactionIdCounter.getAndIncrement();
        CompletableFuture<TransactionResponse> future = new CompletableFuture<>();
        pendingTransactions.put(txnId, future);
        
        try {
            SAPMonitoredActionReq request = new SAPMonitoredActionReq(smpMessage);
            // Set transaction ID as ULong array [high, low]
            request.setTransId(new ULong[] { new ULong(0), new ULong(txnId) });
            request.setAction(SAPActionType.valueOf(action));
            
            log.info("Sending monitored transaction: id={} action={} class={}", 
                txnId, action, smpMessage.getClass().getSimpleName());
            
            transactionChannel.monitoredAction(request);
            touchActivity();
            
            future.orTimeout(30, TimeUnit.SECONDS)
                .whenComplete((result, error) -> {
                    if (error != null) {
                        pendingTransactions.remove(txnId);
                    }
                });
            
            return future;
            
        } catch (Exception e) {
            pendingTransactions.remove(txnId);
            log.error("Failed to send monitored transaction", e);
            return CompletableFuture.failedFuture(e);
        }
    }
    
    /**
     * Send an extended transaction (SAPExtActionReq)
     * 
     * Extended transactions support additional fields.
     * 
     * @param smpMessage The market message to send
     * @param action Action type (ADD/DEL/RWT/KILL)
     * @return CompletableFuture with transaction response
     */
    public CompletableFuture<TransactionResponse> sendExtendedTransaction(
            SMPMessage smpMessage, String action) {
        
        if (transactionChannel == null) {
            return CompletableFuture.failedFuture(
                new IllegalStateException("Transaction channel not initialized"));
        }
        
        long txnId = transactionIdCounter.getAndIncrement();
        CompletableFuture<TransactionResponse> future = new CompletableFuture<>();
        pendingTransactions.put(txnId, future);
        
        try {
            SAPExtActionReq request = new SAPExtActionReq(smpMessage);
            // Set transaction ID as ULong array [high, low]
            request.setTransId(new ULong[] { new ULong(0), new ULong(txnId) });
            request.setAction(SAPActionType.valueOf(action));
            
            log.info("Sending extended transaction: id={} action={} class={}", 
                txnId, action, smpMessage.getClass().getSimpleName());
            
            transactionChannel.extAction(request);
            touchActivity();
            
            future.orTimeout(30, TimeUnit.SECONDS)
                .whenComplete((result, error) -> {
                    if (error != null) {
                        pendingTransactions.remove(txnId);
                    }
                });
            
            return future;
            
        } catch (Exception e) {
            pendingTransactions.remove(txnId);
            log.error("Failed to send extended transaction", e);
            return CompletableFuture.failedFuture(e);
        }
    }
    
    @Override
    public void close() {
        disconnect();
    }
    
    // =========================================================================
    // Inner Classes - Following pattern from AppSAPBroadcastChannel/AppSAPTransactionChannel
    // =========================================================================
    
    /**
     * Address Service Channel implementation - handles service discovery and login
     */
    private class AddressServiceChannelImpl extends SAPAddressServiceChannel {
        
        public AddressServiceChannelImpl(AddressServiceContext context) throws SDPException {
            super(context);
        }
        
        @Override
        public void onConnected() {
            log.info("=== Address service channel connected to {}:{} ===", host, port);
            log.info("Preparing login request for user: {}", username);
            
            // Prepare and send login request
            SAPLogonReq sapLogonReq = new SAPLogonReq();
            sapLogonReq.setService(SAPServiceType.IP_Request);  // Service 0 for IPSP login
            sapLogonReq.setProtocolRevision(new ULong(0));  // Use 0 like in the sample
            sapLogonReq.setSignature(new ULong(1));
            sapLogonReq.setSoftwareRevision(new ULong(1));
            sapLogonReq.setPassword(password);
            sapLogonReq.setUserName(username);
            
            log.info("Sending login request with service type: {} (IP_Request)", SAPServiceType.IP_Request);
            
            try {
                logon(sapLogonReq);
                log.info("Login request sent successfully");
            } catch (SDPException e) {
                log.error("ERROR sending logon request: {}", e.getMessage(), e);
            }
        }
        
        @Override
        public void onLogon(SAPLogonRes sapLogonRes) {
            log.info("Address service logged in: {}", sapLogonRes.getResult());
            if (sapLogonRes.getResult() == SAPLogonRes.Result.LoginOK) {
                loggedIn.set(true);
                
                // Now request address service - this is the correct pattern!
                log.info("Login successful, requesting address service information...");
                try {
                    SAPAddressServiceReqExt request = new SAPAddressServiceReqExt();
                    request.setReqId(new ULong(0));
                    addressService(request);
                    log.info("Address service request sent");
                } catch (SDPException e) {
                    log.error("ERROR sending address service request: {}", e.getMessage(), e);
                    if (addressServiceFuture != null && !addressServiceFuture.isDone()) {
                        addressServiceFuture.completeExceptionally(e);
                    }
                }
            } else {
                log.error("Login failed: {}", sapLogonRes.getResult());
                if (addressServiceFuture != null && !addressServiceFuture.isDone()) {
                    addressServiceFuture.completeExceptionally(
                        new Exception("Login failed: " + sapLogonRes.getResult()));
                }
            }
        }
        
        @Override
        public void onLogonToken(SAPLogonTokenRes sapLogonTokenRes) {
            log.debug("Logon token received");
        }
        
        @Override
        public void onLogoff(SAPLogoffRes sapLogoffRes) {
            log.debug("Logged off");
        }
        
        @Override
        public void onChangePassword(SAPChangePasswordRes sapChangePasswordRes) {
            log.debug("Password changed");
        }
        
        @Override
        public void onAddressService(SAPAddressServiceResExt res) {
            try {
                log.info("=== Address service response received ===");
                log.info("ReqId: {}", res.getReqId());
                
                // Log all received platforms and services
                if (res.getPlatforms() == null) {
                    log.warn("Platforms array is null!");
                    return;
                }
                
                log.info("Processing {} platforms...", res.getPlatforms().length);
                
                for (int i = 0; i < res.getPlatforms().length; i++) {
                    SAPAddressServiceResExt.Platform platform = res.getPlatforms()[i];
                    
                    if (platform == null) {
                        log.debug("Platform[{}] is null, skipping", i);
                        continue;
                    }
                    
                    if (platform.getPlatform() == null) {
                        log.debug("Platform[{}].getPlatform() is null, skipping", i);
                        continue;
                    }
                    
                    int platformId = (int) platform.getPlatform().getValue();
                    if (platformId == 0) {
                        continue; // Skip empty platform entries
                    }
                    
                    log.info("Platform ID: {}", platformId);
                    
                    if (platform.getServices() == null) {
                        log.warn("Platform {} has null services array", platformId);
                        continue;
                    }
                    
                    for (int j = 0; j < platform.getServices().length; j++) {
                        SAPAddressServiceResExt.Service service = platform.getServices()[j];
                        
                        if (service == null) {
                            log.debug("Service[{}] is null, skipping", j);
                            continue;
                        }
                        
                        if (service.getService() == null || service.getAddress() == null || service.getAddress().isEmpty()) {
                            continue; // Skip empty service entries
                        }
                        
                        log.info("  Service: {} -> {}:{}", 
                            service.getService(), 
                            service.getAddress(), 
                            service.getPort());
                    }
                }
                
                log.info("=== Address service processing completed ===");
                
                // Complete the future if someone is waiting for the response
                if (addressServiceFuture != null && !addressServiceFuture.isDone()) {
                    addressServiceFuture.complete(res);
                    log.info("Address service future completed successfully");
                } else {
                    log.warn("Address service future is null or already completed");
                }
                
            } catch (Exception e) {
                log.error("ERROR processing address service response: {}", e.getMessage(), e);
                if (addressServiceFuture != null && !addressServiceFuture.isDone()) {
                    addressServiceFuture.completeExceptionally(e);
                }
            }
        }
        
        @Override
        public void onDisconnected(SDPResult sdpResult) {
            log.error("=== Address service disconnected ===");
            log.error("SDPResult code: {}", sdpResult.getCode());
            log.error("SDPResult detail: {}", sdpResult.getDetail());
            log.error("SDPResult toString: {}", sdpResult.toString());
            
            connected.set(false);
            loggedIn.set(false);
            
            // Complete the future with exception if pending
            if (addressServiceFuture != null && !addressServiceFuture.isDone()) {
                addressServiceFuture.completeExceptionally(
                    new Exception("Connection disconnected: " + sdpResult.toString()));
            }
        }
    }
    
    /**
     * Broadcast Channel implementation - handles subscriptions
     */
    private class BroadcastChannelImpl extends SAPBroadcastChannel {
        
        private final AtomicLong reqIdCounter = new AtomicLong(0);
        
        public BroadcastChannelImpl(BroadcastContext context) throws SDPException {
            super(context);
        }
        
        @Override
        public void onConnected() {
            log.debug("Broadcast channel connected");
            // Prepare and send login request
            SAPLogonReq sapLogonReq = new SAPLogonReq();
            sapLogonReq.setService(SAPServiceType.INFO_BRT);
            sapLogonReq.setProtocolRevision(new ULong(1));
            sapLogonReq.setSignature(new ULong(1));
            sapLogonReq.setSoftwareRevision(new ULong(1));
            sapLogonReq.setPassword(password);
            sapLogonReq.setUserName(username);
            try {
                logon(sapLogonReq);
            } catch (SDPException e) {
                log.error("Error sending logon request", e);
            }
        }
        
        @Override
        public void onLogon(SAPLogonRes sapLogonRes) {
            log.info("Broadcast channel logged in: {}", sapLogonRes.getResult());
            if (sapLogonRes.getResult() == SAPLogonRes.Result.LoginOK) {
                loggedIn.set(true);
                touchActivity();
                log.info("Broadcast channel login successful");
            } else {
                log.error("Broadcast channel login failed: {}", sapLogonRes.getResult());
            }
        }
        
        @Override
        public void onLogonToken(SAPLogonTokenRes sapLogonTokenRes) {
            log.debug("Logon token received");
        }
        
        @Override
        public void onLogoff(SAPLogoffRes sapLogoffRes) {
            log.debug("Logged off");
        }
        
        @Override
        public void onChangePassword(SAPChangePasswordRes sapChangePasswordRes) {
            log.debug("Password changed");
        }
        
        @Override
        public void onSubscribeData(SAPSubscribeData data) {
            log.info("Received subscription data for class {}", data.getClassId());
            touchActivity();
            
            // Broadcast to WebSocket clients if handler is set
            if (webSocketHandler != null) {
                try {
                    // Use reflection to call broadcastMarketData method
                    java.lang.reflect.Method method = webSocketHandler.getClass()
                        .getMethod("broadcastMarketData", Long.class, String.class, Object.class);
                    
                    // Convert ULong to Long
                    Long classId = data.getClassId() != null ? data.getClassId().getValue() : 0L;
                    String className = data.getSmpMessage() != null ? 
                        data.getSmpMessage().getClass().getSimpleName() : "Unknown";
                    
                    log.info("Broadcasting market data: class={} (ID={})", className, classId);
                    method.invoke(webSocketHandler, classId, className, data.getSmpMessage());
                    log.info("Market data broadcast successful");
                } catch (Exception e) {
                    log.error("Failed to broadcast market data via WebSocket", e);
                }
            } else {
                log.warn("WebSocket handler not set, cannot broadcast market data");
            }
        }
        
        @Override
        public void onSubscribeStart(SAPSubscribeStartRes res) {
            log.info("Subscription started for class {} with result {}", 
                    res.getClassId(), res.getResult());
        }
        
        @Override
        public void onSubscribeStop(SAPSubscribeStopRes res) {
            log.info("Subscription stopped");
        }
        
        @Override
        public void onSubscribeIdle(SAPSubscribeIdle idle) {
            log.info("Subscription idle for class {}", idle.getClassId());
        }
        
        @Override
        public void onFilterCreate(SAPFilterCreateRes res) {
            log.info("Filter created with key {}", res.getFilterKey());
        }
        
        @Override
        public void onFilterSet(SAPFilterSetRes res) {
            log.debug("Filter set");
        }
        
        @Override
        public void onFilterDestroy(SAPFilterDestroyRes res) {
            log.debug("Filter destroyed");
        }
        
        @Override
        public void onDisconnected(SDPResult sdpResult) {
            log.warn("Broadcast channel disconnected: {}", sdpResult.getCode());
        }
        
        /**
         * Start subscription for a class - follows pattern from AppSAPBroadcastChannel
         */
        public void startSubscribe(ULong classId, ULong filterKey) throws SDPException {
            SAPSubscribeStartReq sapSubscribeStartReq = new SAPSubscribeStartReq();
            sapSubscribeStartReq.setReqId(new ULong(reqIdCounter.incrementAndGet()));
            sapSubscribeStartReq.setSubscribeType(SAPSubscribeStartReq.SubscribeType.All);
            sapSubscribeStartReq.setClassId(classId);
            if (filterKey != null) {
                sapSubscribeStartReq.setFilterKey(filterKey);
            }
            subscribeRequest(sapSubscribeStartReq);
            log.info("Started subscription for class {}", classId);
        }
    }
    
    /**
     * Transaction Channel implementation - handles queries and transactions
     */
    private class TransactionChannelImpl extends SAPTransactionChannel {
        
        private final AtomicLong reqIdCounter = new AtomicLong(0);
        
        public TransactionChannelImpl(TransactionContext context) throws SDPException {
            super(context);
        }
        
        @Override
        public void onConnected() {
            log.debug("Transaction channel connected");
            
            // Determine service type based on serviceName
            SAPServiceType serviceType;
            if ("QUERY".equals(serviceName)) {
                serviceType = SAPServiceType.QUERY;
            } else if ("TXN_INFO_PRIV".equals(serviceName)) {
                serviceType = SAPServiceType.TXN_INFO_PRIV;
            } else {
                log.error("Unknown transaction service type: {}", serviceName);
                serviceType = SAPServiceType.TXN_INFO_PRIV; // fallback
            }
            
            log.info("Transaction channel sending logon with service: {} ({})", serviceType, serviceName);
            
            // Prepare and send login request
            SAPLogonReq sapLogonReq = new SAPLogonReq();
            sapLogonReq.setService(serviceType);
            sapLogonReq.setProtocolRevision(new ULong(1));
            sapLogonReq.setSignature(new ULong(1));
            sapLogonReq.setSoftwareRevision(new ULong(1));
            sapLogonReq.setPassword(password);
            sapLogonReq.setUserName(username);
            try {
                logon(sapLogonReq);
            } catch (SDPException e) {
                log.error("Error sending logon request", e);
            }
        }
        
        @Override
        public void onLogon(SAPLogonRes sapLogonRes) {
            log.info("Transaction channel logged in: {}", sapLogonRes.getResult());
            if (sapLogonRes.getResult() == SAPLogonRes.Result.LoginOK) {
                loggedIn.set(true);
                touchActivity();
                log.info("Transaction channel login successful");
            } else {
                log.error("Transaction channel login failed: {}", sapLogonRes.getResult());
            }
        }
        
        @Override
        public void onLogonToken(SAPLogonTokenRes sapLogonTokenRes) {
            log.debug("Logon token received");
        }
        
        @Override
        public void onLogoff(SAPLogoffRes sapLogoffRes) {
            log.debug("Logged off");
        }
        
        @Override
        public void onChangePassword(SAPChangePasswordRes sapChangePasswordRes) {
            log.debug("Password changed");
        }
        
        @Override
        public void onSubscribeData(SAPSubscribeData data) {
            log.info("Received subscription data for class {}", data.getClassId());
            touchActivity();
            
            // Broadcast to WebSocket clients if handler is set
            if (webSocketHandler != null) {
                try {
                    // Use reflection to call broadcastMarketData method
                    java.lang.reflect.Method method = webSocketHandler.getClass()
                        .getMethod("broadcastMarketData", Long.class, String.class, Object.class);
                    
                    // Convert ULong to Long
                    Long classId = data.getClassId() != null ? data.getClassId().getValue() : 0L;
                    String className = data.getSmpMessage() != null ? 
                        data.getSmpMessage().getClass().getSimpleName() : "Unknown";
                    
                    log.info("Broadcasting market data: class={} (ID={})", className, classId);
                    method.invoke(webSocketHandler, classId, className, data.getSmpMessage());
                    log.info("Market data broadcast successful");
                } catch (Exception e) {
                    log.error("Failed to broadcast market data via WebSocket", e);
                }
            } else {
                log.warn("WebSocket handler not set, cannot broadcast market data");
            }
        }
        
        @Override
        public void onSubscribeStart(SAPSubscribeStartRes res) {
            log.info("Subscription started for class {}", res.getClassId());
        }
        
        @Override
        public void onSubscribeStop(SAPSubscribeStopRes res) {
            log.info("Subscription stopped");
        }
        
        @Override
        public void onQuery(SAPQueryRes res) {
            log.info("Query response: {}", res.getResult());
        }
        
        @Override
        public void onQueryRowsData(SAPQueryRowsData data) {
            log.debug("Received query data");
            touchActivity();
            // Data will be handled by registered listeners
        }
        
        @Override
        public void onQueryRowsDataRes(SAPQueryRowsDataRes res) {
            log.info("Query rows data response: {}", res.getResult());
        }
        
        @Override
        public void onQueryRowsEnd(SAPQueryRowsEnd end) {
            log.info("Query rows ended");
        }
        
        @Override
        public void onQueryDestroy(SAPQueryDestroyRes res) {
            log.info("Query destroyed with result {}", res.getResult());
        }
        
        @Override
        public void onSubscribeIdle(SAPSubscribeIdle idle) {
            log.info("Subscription idle for class {}", idle.getClassId());
        }
        
        @Override
        public void onFilterCreate(SAPFilterCreateRes res) {
            log.info("Filter created with key {}", res.getFilterKey());
        }
        
        @Override
        public void onFilterSet(SAPFilterSetRes res) {
            log.debug("Filter set");
        }
        
        @Override
        public void onFilterDestroy(SAPFilterDestroyRes res) {
            log.debug("Filter destroyed");
        }
        
        @Override
        public void onTransaction(SAPActionRes res) {
            long txnId = res.getTransId()[1].getValue();
            log.info("Transaction response: txnId={} result={}", 
                txnId, res.getResult());
            
            CompletableFuture<TransactionResponse> future = 
                pendingTransactions.remove(txnId);
            
            if (future != null) {
                TransactionResponse response = TransactionResponse.builder()
                    .success(res.getResult() == SAPActionRes.Result.TransOK)
                    .message(res.getResult().name())
                    .transactionId(txnId)
                    .errorCode((int) res.getReasonCode().getValue())
                    .build();
                
                future.complete(response);
            } else {
                log.warn("Received transaction response for unknown txnId: {}", txnId);
            }
        }
        
        @Override
        public void onTransactionExtended(SAPExtActionRes res) {
            long txnId = res.getTransId()[1].getValue();
            log.info("Extended transaction response: txnId={} result={}", 
                txnId, res.getResult());
            
            CompletableFuture<TransactionResponse> future = 
                pendingTransactions.remove(txnId);
            
            if (future != null) {
                TransactionResponse response = TransactionResponse.builder()
                    .success(res.getResult() == SAPActionRes.Result.TransOK)
                    .message(res.getResult().name())
                    .transactionId(txnId)
                    .errorCode((int) res.getReasonCode().getValue())
                    .build();
                
                future.complete(response);
            }
        }
        
        @Override
        public void onTransactionMonitored(SAPMonitoredActionRes res) {
            long txnId = res.getTransId()[1].getValue();
            log.info("Monitored transaction response: txnId={} result={} inTime={}", 
                txnId, res.getResult(), res.getInTimeStamp().getValue());
            
            CompletableFuture<TransactionResponse> future = 
                pendingTransactions.remove(txnId);
            
            if (future != null) {
                TransactionResponse response = TransactionResponse.builder()
                    .success(res.getResult() == SAPMonitoredActionRes.Result.TransOK)
                    .message(res.getResult().name())
                    .transactionId(txnId)
                    .monitoringId(res.getInTimeStamp().getValue())
                    .errorCode((int) res.getReasonCode().getValue())
                    .build();
                
                future.complete(response);
            }
        }
        
        /**
         * Start subscription for a class
         */
        public void startSubscribe(ULong classId, ULong filterKey) throws SDPException {
            SAPSubscribeStartReq sapSubscribeStartReq = new SAPSubscribeStartReq();
            sapSubscribeStartReq.setReqId(new ULong(reqIdCounter.incrementAndGet()));
            sapSubscribeStartReq.setSubscribeType(SAPSubscribeStartReq.SubscribeType.All);
            sapSubscribeStartReq.setClassId(classId);
            if (filterKey != null) {
                sapSubscribeStartReq.setFilterKey(filterKey);
            }
            subscribeRequest(sapSubscribeStartReq);
            log.info("Started subscription for class {} on transaction channel", classId);
        }
        
        @Override
        public void onDisconnected(SDPResult sdpResult) {
            log.warn("Transaction channel disconnected: {}", sdpResult.getCode());
        }
    }
}
