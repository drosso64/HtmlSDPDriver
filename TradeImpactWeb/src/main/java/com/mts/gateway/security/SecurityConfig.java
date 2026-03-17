package com.mts.gateway.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/status").permitAll()
                .requestMatchers("/api/**").authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt());

        // insert IP whitelist filter early in the chain
        http.addFilterBefore(ipWhitelistFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public IpWhitelistFilter ipWhitelistFilter() {
        return new IpWhitelistFilter();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        // If a JWK Set URI is provided via env var, prefer it for verification
        String jwkUri = System.getenv("JWT_JWK_SET_URI");
        if (jwkUri != null && !jwkUri.isBlank()) {
            return NimbusJwtDecoder.withJwkSetUri(jwkUri).build();
        }

        // Fallback: use a local shared secret (HMAC). Change this in production.
        byte[] secret = "changeit-changeit-changeit-0000".getBytes();
        SecretKeySpec key = new SecretKeySpec(secret, "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(key).build();
    }
}
