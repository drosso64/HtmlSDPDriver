package com.mts.gateway.repository;

import com.mts.gateway.entity.MarketDataRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Market Data Repository
 * 
 * JPA repository for managing market data persistence.
 */
@Repository
public interface MarketDataRepository extends JpaRepository<MarketDataRecord, Long> {
    
    /**
     * Find records by class ID with pagination
     */
    Page<MarketDataRecord> findByClassId(Long classId, Pageable pageable);
    
    /**
     * Find records by class ID and time range
     */
    List<MarketDataRecord> findByClassIdAndReceivedAtBetween(
        Long classId, 
        LocalDateTime startTime, 
        LocalDateTime endTime
    );
    
    /**
     * Find records by subscription ID
     */
    List<MarketDataRecord> findBySubscriptionId(Long subscriptionId);
    
    /**
     * Find recent records by class ID
     */
    @Query("SELECT m FROM MarketDataRecord m WHERE m.classId = :classId ORDER BY m.receivedAt DESC")
    List<MarketDataRecord> findRecentByClassId(@Param("classId") Long classId, Pageable pageable);
    
    /**
     * Count records by class ID
     */
    long countByClassId(Long classId);
    
    /**
     * Count records received after a certain time
     */
    long countByReceivedAtAfter(LocalDateTime dateTime);
    
    /**
     * Delete old records
     */
    @Modifying
    @Query("DELETE FROM MarketDataRecord m WHERE m.receivedAt < :cutoffDate")
    int deleteOldRecords(@Param("cutoffDate") LocalDateTime cutoffDate);
    
    /**
     * Delete records by class ID
     */
    @Modifying
    void deleteByClassId(Long classId);
    
    /**
     * Find records by action type
     */
    List<MarketDataRecord> findByAction(String action);
}
