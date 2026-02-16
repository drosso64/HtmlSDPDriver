package com.mts.gateway.sdp;

import lombok.Getter;

/**
 * SDP Service Types
 * 
 * Maps numeric service IDs to service names for SDP protocol communication.
 * Based on SAPServiceType enum values.
 */
@Getter
public enum ServiceType {
    
    IP_REQUEST(0, "IP_Request", "Address service (not distributed)"),
    TXN(1, "TXN", "Transaction service"),
    INFO_BRT(2, "INFO_BRT", "Broadcast information (subscriptions)"),
    INFO_PRIV(3, "INFO_PRIV", "Private information"),
    TXN_INFO_PRIV(4, "TXN_INFO_PRIV", "Private transactions"),
    DATA_FEED(5, "DATA_FEED", "Data feed service"),
    QUERY(6, "QUERY", "Query service");
    
    private final int id;
    private final String name;
    private final String description;
    
    ServiceType(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    /**
     * Get service type by numeric ID
     */
    public static ServiceType fromId(int id) {
        for (ServiceType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown service ID: " + id);
    }
    
    /**
     * Get service type by string ID or name
     */
    public static ServiceType fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Service type cannot be null");
        }
        
        // Try as numeric ID
        try {
            int id = Integer.parseInt(value);
            return fromId(id);
        } catch (NumberFormatException e) {
            // Not a number, try as name
        }
        
        // Try as name
        for (ServiceType type : values()) {
            if (type.name.equalsIgnoreCase(value)) {
                return type;
            }
        }
        
        throw new IllegalArgumentException("Unknown service type: " + value + 
            " (expected 0-6 or service name)");
    }
    
    /**
     * Check if this service type supports subscriptions
     * Most services support subscriptions through either broadcast or transaction channels
     */
    public boolean supportsSubscriptions() {
        return this != IP_REQUEST; // All services except IP_REQUEST support subscriptions
    }
    
    /**
     * Check if this service type supports transactions
     */
    public boolean supportsTransactions() {
        return this == TXN || this == TXN_INFO_PRIV || this == QUERY;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
