package com.mts.gateway.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Market Data Record Entity
 * 
 * Stores generic market data records received via subscriptions.
 * Uses CLOB to store JSON representation of SMP objects.
 */
@Entity
@Table(name = "market_data", indexes = {
    @Index(name = "idx_class_id", columnList = "classId"),
    @Index(name = "idx_received_at", columnList = "receivedAt"),
    @Index(name = "idx_class_received", columnList = "classId,receivedAt")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketDataRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * SMP CLASS_ID
     */
    @Column(nullable = false)
    private Long classId;
    
    /**
     * Class name
     */
    @Column(nullable = false, length = 255)
    private String className;
    
    /**
     * JSON representation of the SMP object
     */
    @Lob
    @Column(nullable = false, columnDefinition = "CLOB")
    private String jsonData;
    
    /**
     * Action type (ADD, DEL, RWT, KILL)
     */
    @Column(length = 10)
    private String action;
    
    /**
     * When record was received
     */
    @Column(nullable = false)
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime receivedAt;
    
    /**
     * Associated subscription ID
     */
    @Column
    private Long subscriptionId;
    
    @PrePersist
    protected void onCreate() {
        if (receivedAt == null) {
            receivedAt = LocalDateTime.now();
        }
    }
}
