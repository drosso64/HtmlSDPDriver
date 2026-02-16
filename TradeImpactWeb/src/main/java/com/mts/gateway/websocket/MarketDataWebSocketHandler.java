package com.mts.gateway.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mts.gateway.service.MarketDataService;
import com.mts.gateway.util.SMPMessageSerializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequiredArgsConstructor
public class MarketDataWebSocketHandler extends TextWebSocketHandler {
    
    private final MarketDataService marketDataService;
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
        log.info("WebSocket connection established: sessionId={}, total={}", 
            session.getId(), sessions.size());
        
        // Send welcome message
        Map<String, Object> welcome = Map.of(
            "type", "connected",
            "sessionId", session.getId(),
            "message", "Connected to market data stream"
        );
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(welcome)));
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
        log.info("WebSocket connection closed: sessionId={}, status={}, total={}", 
            session.getId(), status, sessions.size());
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
     * @param data The market data (SMP message)
     */
    public void broadcastMarketData(Long classId, String className, Object data) {
        // Serialize SMP message to structured JSON (once for both DB and WebSocket)
        String dataJson = SMPMessageSerializer.toJson(data);
        
        // Persist to database asynchronously
        try {
            marketDataService.saveMarketData(classId, className, dataJson);
        } catch (Exception e) {
            log.error("Failed to persist market data for class {}: {}", className, e.getMessage());
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
                "data", dataJson, // Structured JSON string
                "timestamp", System.currentTimeMillis()
            );
            
            String json = objectMapper.writeValueAsString(message);
            log.info("Sending WebSocket message to {} clients: {}", sessions.size(), 
                json.length() > 200 ? json.substring(0, 200) + "..." : json);
            TextMessage textMessage = new TextMessage(json);
            
            int sentCount = 0;
            // Broadcast to all connected sessions
            for (WebSocketSession session : sessions.values()) {
                try {
                    if (session.isOpen()) {
                        synchronized (session) {
                            session.sendMessage(textMessage);
                            sentCount++;
                        }
                    }
                } catch (IOException e) {
                    log.error("Failed to send message to session {}: {}", 
                        session.getId(), e.getMessage());
                }
            }
            
            log.info("Successfully sent market data for class {} to {}/{} clients", 
                className, sentCount, sessions.size());
            
        } catch (Exception e) {
            log.error("Failed to broadcast market data: {}", e.getMessage(), e);
        }
    }
    
    /**
     * Get number of connected clients
     */
    public int getConnectedClients() {
        return sessions.size();
    }
}
