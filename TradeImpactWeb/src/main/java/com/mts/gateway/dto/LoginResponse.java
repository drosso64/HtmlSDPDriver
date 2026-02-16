package com.mts.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Login Response DTO
 * 
 * Returned after successful or failed login attempt.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    
    private boolean success;
    
    private String message;
    
    private String token;
    
    private String username;
    
    private String ipspHost;
    
    private Integer ipspPort;
    
    private boolean connected;
}
