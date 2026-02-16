package com.mts.gateway.controller;

import com.mts.gateway.dto.LoginRequest;
import com.mts.gateway.dto.LoginResponse;
import com.mts.gateway.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * Authentication Controller
 * 
 * Handles user authentication and IPSP connection initialization.
 * The connection to IPSP is NOT established automatically at startup,
 * but only after the user provides credentials through the login form.
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    
    private final AuthService authService;
    
    /**
     * Login endpoint
     * 
     * Establishes connection to IPSP with user-provided credentials.
     * Only after successful login, the SDP connections become available.
     * 
     * @param loginRequest Contains username, password, IPSP host and port
     * @return LoginResponse with session token and user info
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("Login request from user: {}", loginRequest.getUsername());
        log.info("IPSP: {}:{}", loginRequest.getIpspHost(), loginRequest.getIpspPort());
        
        try {
            LoginResponse response = authService.login(loginRequest);
            log.info("Login successful for user: {}", loginRequest.getUsername());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("Login failed for user: {}", loginRequest.getUsername(), e);
            return ResponseEntity
                .status(401)
                .body(LoginResponse.builder()
                    .success(false)
                    .message("Login failed: " + e.getMessage())
                    .build());
        }
    }
    
    /**
     * Logout endpoint
     * 
     * Closes IPSP connection and invalidates session.
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
        log.info("Logout request with token: {}", token);
        
        try {
            authService.logout(token);
            return ResponseEntity.ok().build();
            
        } catch (Exception e) {
            log.error("Logout failed", e);
            return ResponseEntity.internalServerError().build();
        }
    }
    
    /**
     * Check session validity
     */
    @GetMapping("/session")
    public ResponseEntity<LoginResponse> checkSession(@RequestHeader("Authorization") String token) {
        try {
            LoginResponse response = authService.validateSession(token);
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }
}
