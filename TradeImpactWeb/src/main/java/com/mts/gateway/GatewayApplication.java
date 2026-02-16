package com.mts.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * TradeImpact Web Gateway Application
 * 
 * Market-agnostic SDP protocol gateway with dynamic class loading.
 * Provides WebSocket interface for browser clients to interact with TradeImpact markets.
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
