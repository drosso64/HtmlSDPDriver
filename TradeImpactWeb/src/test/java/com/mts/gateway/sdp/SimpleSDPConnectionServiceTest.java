package com.mts.gateway.sdp;

import com.mts.gateway.rest.dto.TransactionRequest;
import com.mts.gateway.smp.SmpJsonMapper;
import com.mts.gateway.smp.SmpJsonMapperRegistry;
import com.mtsmarkets.sdp.smp.SMPMessage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SimpleSDPConnectionServiceTest {

    @Test
    public void testSendMonitoredAction() throws Exception {
        // Prepare registry with a simple mapper
        SmpJsonMapperRegistry registry = new SmpJsonMapperRegistry();

        // Create a mock SMPMessage to be returned by mapper
        SMPMessage mockSmp = mock(SMPMessage.class);

        SmpJsonMapper mapper = new SmpJsonMapper() {
            @Override
            public Object fromJson(java.util.Map<String, Object> json, long classId) {
                return mockSmp;
            }

            @Override
            public java.util.Map<String, Object> toJson(Object smpObject) {
                return new HashMap<>();
            }
        };

        registry.register("BV", mapper);

        // Mock connection pool and connection
        SDPConnectionPool pool = mock(SDPConnectionPool.class);
        SDPConnection conn = mock(SDPConnection.class);
        when(pool.getTransactionConnection()).thenReturn(conn);

        // When sendMonitoredTransactionAndReturnReqId is called, return a known value
        when(conn.sendMonitoredTransactionAndReturnReqId(eq(mockSmp), anyString())).thenReturn(12345L);

        SimpleSDPConnectionService service = new SimpleSDPConnectionService(registry, pool);

        TransactionRequest req = new TransactionRequest();
        req.setMarket("BV");
        req.setClassId(999L);
        req.setAction("ADD");
        req.setSmpPayload(new HashMap<>());

        long reqId = service.sendMonitoredAction(req);
        assertEquals(12345L, reqId);

        // Verify releaseConnection called
        verify(pool).releaseConnection(conn);
    }
}
