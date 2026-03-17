package com.mts.gateway.rest.dto;

public class GenericAck {
    private long reqId;
    private String status;

    public GenericAck() {}

    public GenericAck(long reqId, String status) {
        this.reqId = reqId;
        this.status = status;
    }

    public long getReqId() {
        return reqId;
    }

    public void setReqId(long reqId) {
        this.reqId = reqId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
