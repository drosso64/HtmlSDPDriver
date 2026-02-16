package com.mts.gateway.dto;

import lombok.Data;
import java.util.Map;

/**
 * Transaction Request DTO
 * 
 * Represents a transaction request from the frontend.
 */
@Data
public class TransactionRequest {
    
    /**
     * Username of the trader executing the transaction
     */
    private String username;
    
    /**
     * Class ID (e.g., "BV_MARKET_ORDER", "BV_IOI")
     */
    private String classId;
    
    /**
     * Transaction action
     */
    private TransactionAction action;
    
    /**
     * Transaction data - field name to value mapping
     * Example:
     * {
     *   "InstrumentId": 12345,
     *   "BuySell": "BUY",
     *   "Quantity": 1000000,
     *   "Price": 99.50
     * }
     */
    private Map<String, Object> data;
    
    /**
     * Optional: Reference ID for tracking
     */
    private String referenceId;
    
    /**
     * Transaction Action Types
     */
    public enum TransactionAction {
        /**
         * ADD - Insert new record
         */
        ADD,
        
        /**
         * DEL - Delete existing record
         */
        DEL,
        
        /**
         * RWT - Rewrite (update) existing record
         */
        RWT,
        
        /**
         * KILL - Force delete/cancel
         */
        KILL
    }
}
