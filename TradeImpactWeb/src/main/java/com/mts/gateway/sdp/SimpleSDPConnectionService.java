package com.mts.gateway.sdp;

import com.mts.gateway.rest.dto.TransactionRequest;
import com.mts.gateway.rest.dto.AddressServiceRequest;
import com.mts.gateway.smp.SmpJsonMapperRegistry;
import com.mtsmarkets.sdp.smp.SMPMessage;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SimpleSDPConnectionService implements SDPConnectionService {
    private final AtomicLong counter = new AtomicLong(1000);
    private final SmpJsonMapperRegistry mapperRegistry;
    private final SDPConnectionPool connectionPool;

    public SimpleSDPConnectionService(SmpJsonMapperRegistry mapperRegistry, SDPConnectionPool connectionPool) {
        this.mapperRegistry = mapperRegistry;
        this.connectionPool = connectionPool;
    }

    @Override
    public long sendMonitoredAction(TransactionRequest req) {
        try {
            // The REST DTO carries the SMP payload as a Map in getSmpPayload()
            Object smpObj = mapperRegistry.getMapper(req.getMarket()).fromJson(req.getSmpPayload(), req.getClassId());
            if (!(smpObj instanceof SMPMessage)) {
                throw new IllegalArgumentException("Mapper did not return SMPMessage for market=" + req.getMarket());
            }
            SMPMessage smp = (SMPMessage) smpObj;
            SDPConnection connection = connectionPool.getTransactionConnection();
            try {
                // action is provided as String in the REST DTO (e.g., "ADD", "DEL")
                long reqId = connection.sendMonitoredTransactionAndReturnReqId(smp, req.getAction());
                return reqId;
            } finally {
                connectionPool.releaseConnection(connection);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to acquire SDP transaction connection", e);
        }
    }

    @Override
    public long requestAddressService(AddressServiceRequest req) {
        // Address service typically uses IPSP and a dedicated connection; keep placeholder for now
        return counter.incrementAndGet();
    }
}
