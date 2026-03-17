package com.mts.gateway.rest.dto;

import java.util.Map;

public class TransactionRequest {
    private String market;
    private long classId;
    private String action;
    private Map<String, Object> smpPayload;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Map<String, Object> getSmpPayload() {
        return smpPayload;
    }

    public void setSmpPayload(Map<String, Object> smpPayload) {
        this.smpPayload = smpPayload;
    }
}
