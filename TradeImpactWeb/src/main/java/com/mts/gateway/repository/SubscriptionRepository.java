package com.mts.gateway.repository;

import com.mts.gateway.entity.Subscription;
import com.mts.gateway.entity.Subscription.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Subscription Repository
 * 
 * JPA repository for managing subscription persistence.
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    
    /**
     * Find all subscriptions for a user
     */
    List<Subscription> findByUsername(String username);
    
    /**
     * Find active subscriptions for a user
     */
    List<Subscription> findByUsernameAndStatus(String username, SubscriptionStatus status);
    
    /**
     * Find subscription by user and class
     */
    Optional<Subscription> findByUsernameAndClassId(String username, Long classId);
    
    /**
     * Find all active subscriptions
     */
    List<Subscription> findByStatus(SubscriptionStatus status);
    
    /**
     * Find subscriptions by class ID
     */
    List<Subscription> findByClassId(Long classId);
    
    /**
     * Find subscriptions updated before a certain time
     */
    List<Subscription> findByUpdatedAtBefore(LocalDateTime dateTime);
    
    /**
     * Delete subscriptions by username
     */
    void deleteByUsername(String username);
    
    /**
     * Count active subscriptions for a user
     */
    long countByUsernameAndStatus(String username, SubscriptionStatus status);
}
