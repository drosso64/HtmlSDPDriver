package com.mts.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Fallback controller for Single Page Application (SPA) routing.
 * 
 * This controller handles all non-API routes and forwards them to index.html,
 * allowing React Router to handle client-side routing.
 * 
 * When users directly access URLs like /class-view/123 or refresh the page,
 * this controller ensures the SPA is loaded and React Router can process the route.
 */
@Controller
public class SpaFallbackController {

    /**
     * Forward all non-API and non-WebSocket requests to index.html
     * This enables React Router to handle client-side routing for direct URL access
     * 
     * Excludes:
     * - /api/** (REST API endpoints)
     * - /ws/** (WebSocket endpoints)
     * - /error (Spring Boot error page)
     * - Static resources (automatically handled by Spring Boot)
     */
    @RequestMapping(value = {
        "/",
        "/login",
        "/subscriptions",
        "/data",
        "/class-view/**",
        "/query",
        "/cleanup"
    })
    public String forward() {
        // Forward to index.html to let React Router handle the routing
        return "forward:/index.html";
    }
}
