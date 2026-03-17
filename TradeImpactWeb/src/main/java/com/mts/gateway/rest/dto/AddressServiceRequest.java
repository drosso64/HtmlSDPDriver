package com.mts.gateway.rest.dto;

import java.util.Map;

public class AddressServiceRequest {
    private String market;
    private Map<String, Object> serviceParams;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Map<String, Object> getServiceParams() {
        return serviceParams;
    }

    public void setServiceParams(Map<String, Object> serviceParams) {
        this.serviceParams = serviceParams;
    }
}
