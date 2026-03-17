package com.mts.gateway.smp;

import java.util.Map;

public interface SmpJsonMapper {
    /**
     * Convert JSON-like structure into an SMP Java object suitable for embedding in a PDU.
     * Implementations are market-specific.
     */
    Object fromJson(Map<String,Object> json, long classId);

    /**
     * Convert an SMP Java object to a JSON-friendly structure.
     */
    Map<String,Object> toJson(Object smpObject);
}
