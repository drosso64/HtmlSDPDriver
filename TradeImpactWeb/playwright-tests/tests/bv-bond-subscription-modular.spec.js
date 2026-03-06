import { test, expect } from '@playwright/test';
import WebSocket from 'ws';
import { login, logout, subscribe, unsubscribe, registerRecordHandler } from './helpers/apiHelpers.js';

const TEST_CONFIG = {
  username: process.env.TEST_USERNAME || 'TRADER@35240',
  password: process.env.TEST_PASSWORD || 'TEQTEQ123',
  ip: process.env.TEST_IPSP_HOST || '10.232.92.86',
  port: process.env.TEST_IPSP_PORT || '12001',
  classIds: [Number(process.env.TEST_CLASS_ID || 400059)],
  maxMessagesToCollect: Number(process.env.TEST_MAX_MESSAGES) || 10,
  websocketTimeout: Number(process.env.TEST_WS_TIMEOUT) || 60000,
};

const getBase = () => process.env.BASE_URL || 'http://localhost:8081';

test.describe('Modular API BV_BOND subscription', () => {
  test.setTimeout(180000);

  test('login -> subscribe (helpers) -> websocket -> unsubscribe -> logout', async () => {
    const base = getBase();
    console.log('Using backend:', base);

    // login via helper (stores token internally)
    const { user, token } = await login(TEST_CONFIG.username, TEST_CONFIG.password, TEST_CONFIG.ip, TEST_CONFIG.port, base);
    expect(token).toBeTruthy();

    // Example: register a predicate-based handler that logs the first matching record
    const { dispose: handlerDispose, promise: handlerPromise } = await registerRecordHandler(TEST_CONFIG.classIds,
      (msg) => true,
      (m) => { console.log('registerRecordHandler matched:', m.hashKey); },
      { once: true, timeout: 30000 }
    );

    // subscribe via helper; subscribe will open WS if needed and collect messages internally
    const { subscribeResult, messages } = await subscribe(TEST_CONFIG.classIds, { waitForMessages: true, maxMessages: TEST_CONFIG.maxMessagesToCollect, timeout: TEST_CONFIG.websocketTimeout });
    console.log('Subscribe result', subscribeResult.status);
    expect(subscribeResult.ok).toBeTruthy();

    console.log('Collected', messages.length, 'messages');

    // unsubscribe
    const unsub = await unsubscribe(TEST_CONFIG.classIds);
    console.log('Unsubscribe result', unsub.status);

    // logout via helper (uses stored user)
    const lo = await logout(TEST_CONFIG.username);
    console.log('Logout result', lo.status);

    expect(messages.length).toBeGreaterThan(0);
  });
});
