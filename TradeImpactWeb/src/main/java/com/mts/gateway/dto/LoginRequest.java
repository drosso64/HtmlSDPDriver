package com.mts.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Login Request DTO
 * 
 * Contains user credentials and IPSP connection parameters.
 * Connection to IPSP is established only after login.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    
    @NotBlank(message = "Username is required")
    private String username;
    
    @NotBlank(message = "Password is required")
    private String password;
    
    @NotBlank(message = "IPSP host is required")
    private String ipspHost;
    
    @NotNull(message = "IPSP port is required")
    private Integer ipspPort;
    
    @Builder.Default
    private boolean useSsl = true;
}
