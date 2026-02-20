package com.mts.gateway.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * Transaction Response DTO
 * 
 * Represents the result of a transaction execution.
 * Include i dati della risposta del mercato (se presenti).
 */
@Data
@Builder
public class TransactionResponse {
    
    /**
     * Whether the transaction was successful
     */
    private boolean success;
    
    /**
     * Result message from the market
     */
    private String message;
    
    /**
     * Transaction ID assigned by the market (if successful)
     */
    private Long transactionId;
    
    /**
     * Monitoring ID for monitored transactions
     */
    private Long monitoringId;
    
    /**
     * Error code (if failed)
     */
    private Integer errorCode;
    
    /**
     * Reference ID from the request (for tracking)
     */
    private String referenceId;
    
    /**
     * Class ID della risposta del mercato (resClassId dalla SAPMonitoredActionRes).
     * Se != null e != 0, responseData contiene i dati della classe.
     */
    private Long resClassId;
    
    /**
     * Nome della classe di risposta (per visualizzazione frontend)
     */
    private String resClassName;
    
    /**
     * Dati della risposta del mercato, serializzati come mappa campo→valore.
     * Presente solo se resClassId != 0 nella SAPMonitoredActionRes.
     */
    private Map<String, Object> responseData;
    
    /**
     * Create a successful response
     */
    public static TransactionResponse success(String message, Long transactionId) {
        return TransactionResponse.builder()
            .success(true)
            .message(message)
            .transactionId(transactionId)
            .build();
    }
    
    /**
     * Create an error response
     */
    public static TransactionResponse error(String message) {
        return TransactionResponse.builder()
            .success(false)
            .message(message)
            .build();
    }
    
    /**
     * Create an error response with error code
     */
    public static TransactionResponse error(String message, Integer errorCode) {
        return TransactionResponse.builder()
            .success(false)
            .message(message)
            .errorCode(errorCode)
            .build();
    }
}
