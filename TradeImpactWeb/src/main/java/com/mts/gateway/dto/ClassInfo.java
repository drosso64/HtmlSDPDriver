package com.mts.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Information from CSV
 * 
 * Contains metadata about subscribable classes:
 * - Class name (fully qualified)
 * - Class ID (numeric identifier)
 * - Service ID (which service to use for subscription/transaction)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassInfo {
    
    /**
     * Fully qualified class name (e.g., com.mtsmarkets.sdp.smp.bvf.BV_MARKET)
     */
    private String className;
    
    /**
     * Simple class name (e.g., BV_MARKET)
     */
    private String simpleClassName;
    
    /**
     * Numeric class identifier
     */
    private Long classId;
    
    /**
     * Service identifier (e.g., INFO_BRT, TXN_INFO_PRIV, QUERY)
     */
    private String serviceId;
    
    /**
     * Optional description
     */
    private String description;
}
