package com.mts.gateway.sdp;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ReqIdRouter {
    private static class ClientContext {
        final String market;
        final String sessionId;
        final Instant created = Instant.now();

        ClientContext(String market, String sessionId) {
            this.market = market;
            this.sessionId = sessionId;
        }
    }

    private final Map<Long, ClientContext> map = new ConcurrentHashMap<>();

    public void register(long reqId, String market, String sessionId) {
        map.put(reqId, new ClientContext(market, sessionId));
    }

    public void unregister(long reqId) {
        map.remove(reqId);
    }

    public String getMarketForReqId(long reqId) {
        ClientContext c = map.get(reqId);
        return c == null ? null : c.market;
    }
}
