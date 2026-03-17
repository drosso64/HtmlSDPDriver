package com.mts.gateway.smp;

import com.mts.gateway.smp.factory.BvfFactoryAdapter;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SmpMapperAutoConfig {

    private final SmpJsonMapperRegistry registry;
    private final BvfFactoryAdapter bvfAdapter;

    public SmpMapperAutoConfig(SmpJsonMapperRegistry registry, BvfFactoryAdapter bvfAdapter) {
        this.registry = registry;
        this.bvfAdapter = bvfAdapter;
    }

    @PostConstruct
    public void init() {
        // register BVF/BV markets to the BVF adapter
        registry.register("BV", bvfAdapter);
        registry.register("BVF", bvfAdapter);
    }
}
