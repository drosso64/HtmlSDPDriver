package com.mts.gateway.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Subscription Entity
 * 
 * Stores user subscriptions to SMP classes.
 * Tracks which classes are currently subscribed and their status.
 */
@Entity
@Table(name = "subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * User identifier
     */
    @Column(nullable = false, length = 100)
    private String username;
    
    /**
     * SMP CLASS_ID
     */
    @Column(nullable = false)
    private Long classId;
    
    /**
     * Class name (for display)
     */
    @Column(nullable = false, length = 255)
    private String className;
    
    /**
     * Subscription status
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SubscriptionStatus status;
    
    /**
     * When subscription was created
     */
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    /**
     * Last update timestamp
     */
    @Column
    private LocalDateTime updatedAt;
    
    /**
     * Last activity timestamp (data received)
     */
    @Column
    private LocalDateTime lastActivity;
    
    /**
     * Number of records received
     */
    @Column(nullable = false)
    @Builder.Default
    private Long recordCount = 0L;
    
    /**
     * Subscription error message (if any)
     */
    @Column(length = 500)
    private String errorMessage;
    
    /**
     * Subscription Status enum
     */
    public enum SubscriptionStatus {
        PENDING,    // Subscription requested but not yet active
        ACTIVE,     // Subscription is active and receiving data
        PAUSED,     // Subscription is temporarily paused
        ERROR,      // Subscription encountered an error
        CLOSED      // Subscription was explicitly closed
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) {
            status = SubscriptionStatus.PENDING;
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
