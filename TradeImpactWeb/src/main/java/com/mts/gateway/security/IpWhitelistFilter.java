package com.mts.gateway.security;

import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class IpWhitelistFilter extends OncePerRequestFilter {
    private final Set<String> allowed = new HashSet<>();

    public IpWhitelistFilter() {
        // default allow localhost for dev; can be configured via properties
        allowed.add("127.0.0.1");
        allowed.add("::1");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String ip = request.getRemoteAddr();
        if (!allowed.contains(ip)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "IP not allowed");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
