import { test, expect } from '@playwright/test';
import WebSocket from 'ws';

/**
 * API-only test: usa solo chiamate REST + WebSocket (no UI)
 * - Effettua login via REST
 * - Sottoscrive la classe BV_BOND via REST
 * - Apre una connessione WebSocket e raccoglie messaggi
 * - Effettua unsubscribe alla fine
 *
 * Configura il backend tramite la variabile d'ambiente `BASE_URL`.
 */

const TEST_CONFIG = {
  username: process.env.TEST_USERNAME || 'TRADER@35240',
  password: process.env.TEST_PASSWORD || 'TEQTEQ123',
  ipspHost: process.env.TEST_IPSP_HOST || '10.232.92.86',
  ipspPort: process.env.TEST_IPSP_PORT || '12001',
  classToSubscribe: process.env.TEST_CLASS || 'BV_BOND',
  maxMessagesToCollect: Number(process.env.TEST_MAX_MESSAGES) || 10,
  websocketTimeout: Number(process.env.TEST_WS_TIMEOUT) || 60000,
};

const getBase = () => process.env.BASE_URL || 'http://localhost:8081';

async function tryJson(res) {
  try {
    return await res.json();
  } catch (e) {
    return { status: res.status, text: await res.text() };
  }
}

test.describe('API-only BV_BOND subscription', () => {
  test.setTimeout(180000);

  test('login -> subscribe -> websocket -> unsubscribe', async () => {
    const base = getBase();
    console.log('Using backend:', base);

    // 1) LOGIN
    const loginPaths = ['/api/auth/login', '/auth/login'];
    let loginResp = null;
    let token = null;

    for (const p of loginPaths) {
      const url = `${base}${p}`;
      console.log('Trying login URL:', url);
      try {
        const res = await fetch(url, {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            username: TEST_CONFIG.username,
            password: TEST_CONFIG.password,
            ipspHost: TEST_CONFIG.ipspHost,
            ipspPort: Number(TEST_CONFIG.ipspPort),
            useSsl: true,
          }),
        });

        const j = await tryJson(res);
        loginResp = { status: res.status, body: j };

        if (res.ok && (j.token || j.data?.token)) {
          token = j.token || j.data.token;
          console.log('Login successful, token found');
          break;
        } else if (res.ok && j.success && j.token) {
          token = j.token;
          break;
        } else {
          console.log('Login response:', loginResp);
        }
      } catch (err) {
        console.log('Login attempt failed for', url, err.message);
      }
    }

    expect(token, 'Could not obtain auth token from login').toBeTruthy();

    // Resolve class id if a name was provided
    const subscribeUrl = `${base}/api/classes/subscribe`;
    console.log('Subscribe URL:', subscribeUrl);
    let classIdToSubscribe = TEST_CONFIG.classToSubscribe;
    if (typeof classIdToSubscribe === 'string' && isNaN(Number(classIdToSubscribe))) {
      console.log('Resolving class name to numeric ID for', classIdToSubscribe);
      try {
        const classesResp = await fetch(`${base}/api/classes`, { method: 'GET' });
        if (classesResp.ok) {
          const classes = await classesResp.json();
          const found = classes.find(c => c.simpleClassName === classIdToSubscribe || c.className === classIdToSubscribe);
          if (found && found.classId) {
            classIdToSubscribe = found.classId;
            console.log('Resolved', TEST_CONFIG.classToSubscribe, '->', classIdToSubscribe);
          } else {
            console.warn('Could not resolve class name to ID:', TEST_CONFIG.classToSubscribe);
          }
        } else {
          console.warn('Failed to fetch classes for resolution:', classesResp.status);
        }
      } catch (e) {
        console.warn('Error resolving class name:', e.message);
      }
    }

    // 3) WEBSOCKET: open WS BEFORE subscribe and wait for 'connected'
    const wsUrl = (() => {
      const u = new URL(base);
      u.protocol = u.protocol === 'https:' ? 'wss:' : 'ws:';
      u.pathname = '/ws/marketdata';
      u.searchParams.set('token', token);
      return u.toString();
    })();

    console.log('Opening WebSocket to', wsUrl, 'and waiting for connected message');
    const ws = new WebSocket(wsUrl);

    const messages = [];
    let resolved = false;
    let connectedResolved = false;

    const start = Date.now();

    // Collector promise - resolves when enough messages collected or timeout
    let resolveCollector;
    const collectorPromise = new Promise((collectorResolve) => {
      resolveCollector = collectorResolve;
      const totalTimeout = setTimeout(() => {
        if (!resolved) {
          resolved = true;
          console.log('WebSocket overall timeout reached');
          try { ws.terminate(); } catch (e) {}
          collectorResolve();
        }
      }, TEST_CONFIG.websocketTimeout);

      ws.on('close', () => {
        if (!resolved) {
          resolved = true;
          clearTimeout(totalTimeout);
          collectorResolve();
        }
      });
    });

    // Handler for messages (connected + marketData)
    ws.on('open', () => console.log('WebSocket opened'));

    ws.on('message', (data) => {
      try {
        const msg = JSON.parse(data.toString());

        if (msg.type === 'connected') {
          if (!connectedResolved) {
            connectedResolved = true;
            console.log('Received WS connected message');
          }
          return;
        }

        if (msg.type === 'marketData' && msg.classId === Number(classIdToSubscribe)) {
          messages.push(msg);
          console.log('Received marketData:', msg.hashKey, 'total:', messages.length);
          if (messages.length >= TEST_CONFIG.maxMessagesToCollect && !resolved) {
            resolved = true;
            try { ws.close(); } catch (e) {}
            resolveCollector();
          }
        }
      } catch (err) {
        console.warn('Invalid WS message', err.message);
      }
    });

    ws.on('error', (err) => console.error('WebSocket error', err && err.message));

    // Wait for connected message (but don't fail hard if it doesn't arrive quickly)
    try {
      await new Promise((res, rej) => {
        const connTimeout = setTimeout(() => rej(new Error('WS connected timeout')), 10000);
        if (connectedResolved) {
          clearTimeout(connTimeout);
          return res();
        }
        const onMsg = (data) => {
          try {
            const msg = JSON.parse(data.toString());
            if (msg.type === 'connected') {
              clearTimeout(connTimeout);
              ws.off('message', onMsg);
              return res();
            }
          } catch (e) {}
        };
        ws.on('message', onMsg);
      });
      console.log('WebSocket reported connected');
    } catch (e) {
      console.warn('Did not receive connected message in time, proceeding with subscribe');
    }

    // small stabilization delay to let server-side AP connections settle
    await new Promise(r => setTimeout(r, 2000));

    // 2) SUBSCRIBE via REST (after WS is open/connected)
    const subRes = await fetch(subscribeUrl, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      },
      body: JSON.stringify({
        username: TEST_CONFIG.username,
        classIds: [Number(classIdToSubscribe)],
        filterKey: 0
      })
    });

    const subJson = await tryJson(subRes);
    console.log('Subscribe response:', subRes.status, subJson);
    expect(subRes.ok, 'Subscribe failed').toBeTruthy();

    // Wait for collector to complete (messages or timeout)
    await collectorPromise;

    const duration = (Date.now() - start) / 1000;
    console.log(`Collected ${messages.length} messages in ${duration}s`);

    // 4) UNSUBSCRIBE
    const unsubscribeUrl = `${base}/api/classes/unsubscribe`;
    const unsubRes = await fetch(unsubscribeUrl, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      },
      body: JSON.stringify({ classIds: [Number(classIdToSubscribe)] })
    });

    const unsubJson = await tryJson(unsubRes);
    console.log('Unsubscribe response:', unsubRes.status, unsubJson);

    // Logout to ensure session is cleaned up on the server
    try {
      const logoutUrl = `${base}/api/auth/logout`;
      console.log('Calling logout at', logoutUrl);
      const logoutRes = await fetch(logoutUrl, {
        method: 'POST',
        headers: {
          // AuthController expects the raw token value (no "Bearer ")
          'Authorization': token
        }
      });
      const logoutJson = await tryJson(logoutRes);
      console.log('Logout response:', logoutRes.status, logoutJson);
    } catch (e) {
      console.warn('Logout call failed:', e.message);
    }

    // Assertions
    expect(messages.length).toBeGreaterThan(0);
  });
});
