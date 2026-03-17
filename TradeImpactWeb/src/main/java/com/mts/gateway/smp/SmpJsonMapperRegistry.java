package com.mts.gateway.smp;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SmpJsonMapperRegistry {
    private final Map<String, SmpJsonMapper> registry = new ConcurrentHashMap<>();

    public void register(String market, SmpJsonMapper mapper) {
        registry.put(market.toUpperCase(), mapper);
    }

    public SmpJsonMapper getMapper(String market) {
        SmpJsonMapper m = registry.get(market == null ? null : market.toUpperCase());
        if (m == null) {
            throw new IllegalArgumentException("No SMP mapper registered for market: " + market);
        }
        return m;
    }
}
