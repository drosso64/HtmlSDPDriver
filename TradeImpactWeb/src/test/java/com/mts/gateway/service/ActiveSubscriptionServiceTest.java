package com.mts.gateway.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActiveSubscriptionServiceTest {

    @Test
    public void testAddAndGetSubscription() {
        ActiveSubscriptionService svc = new ActiveSubscriptionService();
        svc.addSubscription("alice", 100L, "BOND", 555L);

        ActiveSubscriptionService.SubscriptionInfo info = svc.getSubscription("alice", 100L);
        assertNotNull(info);
        assertEquals(100L, info.getClassId());
        assertEquals("BOND", info.getClassName());
        assertEquals(555L, info.getSubscriptionKey());
    }

    @Test
    public void testGetAllActiveSubscriptionsAndClear() {
        ActiveSubscriptionService svc = new ActiveSubscriptionService();
        svc.addSubscription("bob", 200L, "QUOTE", 11L);
        svc.addSubscription("bob", 201L, "TRADE", 12L);

        var list = svc.getActiveSubscriptions("bob");
        assertEquals(2, list.size());

        svc.clearUserSubscriptions("bob");
        var empty = svc.getActiveSubscriptions("bob");
        assertTrue(empty.isEmpty());
    }
}
