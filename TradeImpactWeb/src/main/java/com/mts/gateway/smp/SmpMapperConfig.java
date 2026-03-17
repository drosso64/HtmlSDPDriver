package com.mts.gateway.smp;

import com.mts.gateway.smp.factory.BvfFactoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class SmpMapperConfig {

    @Autowired
    private SmpJsonMapperRegistry registry;

    @Autowired
    private BvfFactoryAdapter bvfAdapter;

    @PostConstruct
    public void init() {
        registry.register("BV", bvfAdapter);
    }
}
