package com.mts.gateway.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mts.gateway.service.AuthService;
import com.mts.gateway.service.MarketDataService;
import com.mts.gateway.service.MarketDataUpsertService;
import com.mts.gateway.service.ActiveSubscriptionService;
import com.mts.gateway.sdp.SDPConnectionPool;
import com.mts.gateway.util.SMPMessageSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Handler for Market Data
 * 
 * Handles WebSocket connections from clients and broadcasts market data updates.
 * Also persists received data to the database.
 */
@Slf4j
@Component
public class MarketDataWebSocketHandler extends TextWebSocketHandler {
    
    private final MarketDataService marketDataService; // Keep for backward compatibility
    private final MarketDataUpsertService marketDataUpsertService; // NEW: For table-per-class UPSERT
    private final SDPConnectionPool connectionPool;
    private final AuthService authService;
    private final ActiveSubscriptionService activeSubscriptionService;
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private final Map<String, String> sessionTokens = new ConcurrentHashMap<>(); // sessionId -> token
    private final Map<String, String> sessionMarkets = new ConcurrentHashMap<>(); // sessionId -> market
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    // Constructor with @Lazy to break circular dependency
    public MarketDataWebSocketHandler(
            MarketDataService marketDataService,
            MarketDataUpsertService marketDataUpsertService,
            @Lazy SDPConnectionPool connectionPool,
            @Lazy AuthService authService,
            ActiveSubscriptionService activeSubscriptionService) {
        this.marketDataService = marketDataService;
        this.marketDataUpsertService = marketDataUpsertService;
        this.connectionPool = connectionPool;
        this.authService = authService;
        this.activeSubscriptionService = activeSubscriptionService;
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
        
        // Extract market from path (/ws/{market})
        String market = null;
        if (session.getUri() != null && session.getUri().getPath() != null) {
            String path = session.getUri().getPath();
            if (path.startsWith("/ws/")) {
                market = path.substring(4);
                // trim any trailing segments
                int slash = market.indexOf('/');
                if (slash != -1) market = market.substring(0, slash);
            }
        }
        if (market != null) {
            sessionMarkets.put(session.getId(), market);
        }

        // Extract token from query parameters or headers
        String token = extractToken(session);
        if (token != null) {
            sessionTokens.put(session.getId(), token);
        }
        
        log.info("WebSocket connection established: sessionId={}, token={}, total={}", 
            session.getId(), token != null ? "present" : "missing", sessions.size());
        
        // Send welcome message
        Map<String, Object> welcome = Map.of(
            "type", "connected",
            "sessionId", session.getId(),
            "message", "Connected to market data stream"
        );
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(welcome)));
    }
    
    private String extractToken(WebSocketSession session) {
        // Try to get token from query parameters
        String uri = session.getUri().toString();
        if (uri.contains("token=")) {
            int start = uri.indexOf("token=") + 6;
            int end = uri.indexOf("&", start);
            if (end == -1) end = uri.length();
            return uri.substring(start, end);
        }
        
        // Try to get from handshake headers
        var headers = session.getHandshakeHeaders();
        if (headers.containsKey("Authorization")) {
            String auth = headers.getFirst("Authorization");
            if (auth != null && auth.startsWith("Bearer ")) {
                return auth.substring(7);
            }
        }
        
        return null;
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
        String token = sessionTokens.remove(session.getId());
        sessionMarkets.remove(session.getId());
        
        log.info("WebSocket connection closed: sessionId={}, status={}, token={}, total={}", 
            session.getId(), status, token != null ? "present" : "missing", sessions.size());
        
        // If this was the last WebSocket connection, perform logout with the token
        if (sessions.isEmpty()) {
            log.info("Last WebSocket client disconnected - performing logout");
            authService.logout(token); // Pass the actual token (or null if not found)
        }
    }
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.debug("Received message from client {}: {}", session.getId(), message.getPayload());
        // Could handle subscription requests here if needed
    }
    
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("WebSocket transport error for session {}: {}", 
            session.getId(), exception.getMessage(), exception);
        if (session.isOpen()) {
            session.close(CloseStatus.SERVER_ERROR);
        }
        sessions.remove(session.getId());
    }
    
    /**
     * Broadcast market data to all connected clients
     * 
     * @param classId The class ID
     * @param className The class name
     * @param data The market data (SMP message object)
     */
    public void broadcastMarketData(Long classId, String className, Object data) {
        // Serialize SMP message to structured JSON (for WebSocket broadcast)
        String dataJson = SMPMessageSerializer.toJson(data);
        
        // Extract hashKey for UPSERT semantics in frontend
        Long hashKey = null;
        try {
            hashKey = (Long) data.getClass().getMethod("hashKey").invoke(data);
        } catch (Exception e) {
            log.warn("Failed to extract hashKey for class {}: {}", className, e.getMessage());
        }
        
        // NEW: UPSERT to dynamic table (table-per-class with hash_key)
        try {
            // Pass the SMP object directly for hashKey() extraction
            marketDataUpsertService.upsertMarketData(classId, className, data, "DATA");
        } catch (Exception e) {
            log.error("Failed to upsert market data for class {}: {}", className, e.getMessage());
        }
        
        if (sessions.isEmpty()) {
            log.trace("No WebSocket clients connected, skipping broadcast");
            return;
        }

        try {
            Map<String, Object> message = Map.of(
                "type", "marketData",
                "classId", classId,
                "className", className,
                "data", dataJson,
                "hashKey", hashKey != null ? hashKey : 0L,
                "timestamp", System.currentTimeMillis()
            );

            String json = objectMapper.writeValueAsString(message);
            TextMessage textMessage = new TextMessage(json);

            // Determine subscribed usernames for this classId
            var allSubs = activeSubscriptionService.getAllActiveSubscriptions();
            java.util.Set<String> subscribedUsers = new java.util.HashSet<>();
            for (var pair : allSubs) {
                var info = pair.getSubscriptionInfo();
                if (info != null && info.getClassId() != null && info.getClassId().equals(classId)) {
                    subscribedUsers.add(pair.getUsername());
                }
            }

            int sentCount = 0;
            if (subscribedUsers.isEmpty()) {
                log.debug("No active subscriptions found for class {} - skipping targeted send", classId);
            } else {
                log.info("Sending market data for class {} to subscribed users: {}", classId, subscribedUsers);
                // For each connected session, check if its token belongs to a subscribed user
                for (var entry : sessions.entrySet()) {
                    String sessionId = entry.getKey();
                    WebSocketSession session = entry.getValue();
                    String token = sessionTokens.get(sessionId);
                    // If session has market binding and no market provided (legacy), allow
                    String sessMarket = sessionMarkets.get(sessionId);
                    if (token == null) continue;
                    try {
                        var sess = authService.getSession(token);
                        if (sess == null) continue;
                        String username = sess.getUsername();
                        if (username == null) continue;
                        if (!subscribedUsers.contains(username)) continue;

                        if (session.isOpen()) {
                            synchronized (session) {
                                session.sendMessage(textMessage);
                                sentCount++;
                            }
                        }
                    } catch (Exception e) {
                        log.debug("Failed to map token to session username for session {}: {}", sessionId, e.getMessage());
                    }
                }

                log.info("Successfully sent market data for class {} to {} sessions", classId, sentCount);
            }

        } catch (Exception e) {
            log.error("Failed to route market data to subscribed clients: {}", e.getMessage(), e);
        }
    }

    /**
     * Broadcast market data scoped to a specific market path.
     * Only sessions connected to /ws/{market} will receive the message.
     */
    public void broadcastMarketData(String market, Long classId, String className, Object data) {
        if (market == null) {
            broadcastMarketData(classId, className, data);
            return;
        }

        String dataJson = SMPMessageSerializer.toJson(data);

        // Get subscribers as before
        var allSubs = activeSubscriptionService.getAllActiveSubscriptions();
        java.util.Set<String> subscribedUsers = new java.util.HashSet<>();
        for (var pair : allSubs) {
            var info = pair.getSubscriptionInfo();
            if (info != null && info.getClassId() != null && info.getClassId().equals(classId)) {
                subscribedUsers.add(pair.getUsername());
            }
        }

        if (sessions.isEmpty()) {
            log.trace("No WebSocket clients connected, skipping broadcast");
            return;
        }

        try {
            Map<String, Object> message = Map.of(
                "type", "marketData",
                "market", market,
                "classId", classId,
                "className", className,
                "data", dataJson,
                "timestamp", System.currentTimeMillis()
            );

            String json = objectMapper.writeValueAsString(message);
            TextMessage textMessage = new TextMessage(json);

            int sentCount = 0;
            for (var entry : sessions.entrySet()) {
                String sessionId = entry.getKey();
                WebSocketSession session = entry.getValue();
                String sessMarket = sessionMarkets.get(sessionId);
                if (sessMarket == null || !sessMarket.equals(market)) continue;

                String token = sessionTokens.get(sessionId);
                if (token == null) continue;

                try {
                    var sess = authService.getSession(token);
                    if (sess == null) continue;
                    String username = sess.getUsername();
                    if (username == null) continue;
                    if (!subscribedUsers.contains(username)) continue;

                    if (session.isOpen()) {
                        synchronized (session) {
                            session.sendMessage(textMessage);
                            sentCount++;
                        }
                    }
                } catch (Exception e) {
                    log.debug("Failed to send market data to session {}: {}", sessionId, e.getMessage());
                }
            }

            log.info("Sent market data for class {} on market {} to {} sessions", classId, market, sentCount);

        } catch (Exception e) {
            log.error("Failed to route market data to subscribed clients: {}", e.getMessage(), e);
        }
    }
    
    /**
     * Get number of connected clients
     */
    public int getConnectedClients() {
        return sessions.size();
    }
}
