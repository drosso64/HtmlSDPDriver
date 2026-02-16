package com.mts.gateway.config;

import com.mts.gateway.websocket.MarketDataWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * WebSocket Configuration
 * 
 * Configures WebSocket endpoint for client connections.
 * Handles message size limits and allowed origins.
 */
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    
    private final MarketDataWebSocketHandler marketDataHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(marketDataHandler, "/ws/marketdata")
                .setAllowedOrigins("*"); // Allow all origins for development
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(1048576); // 1MB
        container.setMaxBinaryMessageBufferSize(1048576);
        return container;
    }
    
    /**
     * Configure ObjectMapper for JSON serialization/deserialization
     */
    @Bean
    public com.fasterxml.jackson.databind.ObjectMapper objectMapper() {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        mapper.configure(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper;
    }
}
