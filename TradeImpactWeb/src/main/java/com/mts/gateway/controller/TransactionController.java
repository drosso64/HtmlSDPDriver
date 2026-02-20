package com.mts.gateway.controller;

import com.mts.gateway.dto.TransactionRequest;
import com.mts.gateway.dto.TransactionResponse;
import com.mts.gateway.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Transaction Controller
 * 
 * REST API for executing transactions (ADD/DEL/RWT/KILL) on market data classes.
 * Follows SDP protocol patterns from SampleTXNTransaction.
 */
@Slf4j
@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TransactionController {
    
    private final TransactionService transactionService;
    
    /**
     * POST /api/transactions
     * Execute a transaction (ADD/DEL/RWT/KILL)
     * 
     * Request body:
     * {
     *   "username": "trader1",
     *   "classId": "BV_MARKET_ORDER",
     *   "action": "ADD",
     *   "data": {
     *     "InstrumentId": 12345,
     *     "BuySell": "BUY",
     *     "Quantity": 1000000,
     *     ...
     *   }
     * }
     * 
     * @param request Transaction request
     * @return Transaction response with result and transaction ID
     */
    @PostMapping
    public ResponseEntity<TransactionResponse> executeTransaction(@RequestBody TransactionRequest request) {
        log.info("POST /api/transactions - user={} classId={} action={}", 
            request.getUsername(), request.getClassId(), request.getAction());
        
        try {
            // Validate request
            if (request.getUsername() == null || request.getUsername().isEmpty()) {
                return ResponseEntity.badRequest().body(
                    TransactionResponse.error("Username is required")
                );
            }
            
            if (request.getClassId() == null) {
                return ResponseEntity.badRequest().body(
                    TransactionResponse.error("Class ID is required")
                );
            }
            
            if (request.getAction() == null) {
                return ResponseEntity.badRequest().body(
                    TransactionResponse.error("Action is required")
                );
            }
            
            if (request.getData() == null || request.getData().isEmpty()) {
                return ResponseEntity.badRequest().body(
                    TransactionResponse.error("Transaction data is required")
                );
            }
            
            // Execute transaction
            TransactionResponse response = transactionService.executeTransaction(request);
            
            // Sempre 200: il rifiuto dal mercato non è un errore server,
            // è una risposta business valida con success=false
            return ResponseEntity.ok(response);
            
        } catch (IllegalArgumentException e) {
            log.error("Invalid transaction request", e);
            return ResponseEntity.badRequest().body(
                TransactionResponse.error(e.getMessage())
            );
            
        } catch (Exception e) {
            log.error("Failed to execute transaction", e);
            return ResponseEntity.internalServerError().body(
                TransactionResponse.error("Transaction failed: " + e.getMessage())
            );
        }
    }
    
    /**
     * POST /api/transactions/monitored
     * Execute a monitored transaction (with monitoring capability)
     * 
     * Monitored transactions allow tracking the transaction lifecycle
     * through subsequent status updates from the market.
     * 
     * @param request Transaction request
     * @return Transaction response with monitoring ID
     */
    @PostMapping("/monitored")
    public ResponseEntity<TransactionResponse> executeMonitoredTransaction(
            @RequestBody TransactionRequest request) {
        
        log.info("POST /api/transactions/monitored - user={} classId={} action={}", 
            request.getUsername(), request.getClassId(), request.getAction());
        
        try {
            // Validate request
            if (request.getUsername() == null || request.getUsername().isEmpty()) {
                return ResponseEntity.badRequest().body(
                    TransactionResponse.error("Username is required")
                );
            }
            
            if (request.getClassId() == null) {
                return ResponseEntity.badRequest().body(
                    TransactionResponse.error("Class ID is required")
                );
            }
            
            if (request.getAction() == null) {
                return ResponseEntity.badRequest().body(
                    TransactionResponse.error("Action is required")
                );
            }
            
            if (request.getData() == null || request.getData().isEmpty()) {
                return ResponseEntity.badRequest().body(
                    TransactionResponse.error("Transaction data is required")
                );
            }
            
            TransactionResponse response = transactionService.executeMonitoredTransaction(request);
            
            // Sempre 200: il rifiuto dal mercato non è un errore server,
            // è una risposta business valida con success=false
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("Failed to execute monitored transaction", e);
            return ResponseEntity.internalServerError().body(
                TransactionResponse.error("Monitored transaction failed: " + e.getMessage())
            );
        }
    }
    
    /**
     * POST /api/transactions/extended
     * Execute an extended transaction (with extended fields)
     * 
     * Extended transactions support additional fields beyond
     * the standard transaction structure.
     * 
     * @param request Transaction request
     * @return Transaction response
     */
    @PostMapping("/extended")
    public ResponseEntity<TransactionResponse> executeExtendedTransaction(
            @RequestBody TransactionRequest request) {
        
        log.info("POST /api/transactions/extended - user={} classId={} action={}", 
            request.getUsername(), request.getClassId(), request.getAction());
        
        try {
            TransactionResponse response = transactionService.executeExtendedTransaction(request);
            
            // Sempre 200: il rifiuto dal mercato non è un errore server,
            // è una risposta business valida con success=false
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("Failed to execute extended transaction", e);
            return ResponseEntity.internalServerError().body(
                TransactionResponse.error("Extended transaction failed: " + e.getMessage())
            );
        }
    }
}
