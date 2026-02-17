package com.mts.gateway.service;

import com.mts.gateway.entity.MarketDataRecord;
import com.mts.gateway.repository.MarketDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for persisting market data received from subscriptions
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MarketDataService {
    
    private final MarketDataRepository marketDataRepository;
    
    /**
     * Save market data asynchronously to avoid blocking WebSocket broadcast
     * 
     * @param classId The class ID
     * @param className The class name
     * @param jsonData The market data as JSON string (already serialized)
     */
    @Async
    @Transactional
    public void saveMarketData(Long classId, String className, String jsonData) {
        try {
            MarketDataRecord record = MarketDataRecord.builder()
                .classId(classId)
                .className(className)
                .jsonData(jsonData)
                .action("DATA")
                .build();
            
            marketDataRepository.save(record);
            
            log.info("✅ Saved market data for class {} (ID: {}): {} bytes", className, classId, jsonData.length());
        } catch (Exception e) {
            log.error("❌ Failed to save market data for class {}: {}", className, e.getMessage(), e);
        }
    }
}
