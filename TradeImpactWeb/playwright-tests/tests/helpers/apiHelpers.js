import WebSocket from 'ws';

// ---------------------------------------------------------------------------
// Internal session state – never exported
// ---------------------------------------------------------------------------
const sessionStore = {
  currentUser: null,
  currentToken: null,
  baseUrl: null,
  ws: null,           // single shared WebSocket for the session
};

async function tryJson(res) {
  try {
    if (res.bodyUsed) return { status: res.status, text: '<body already consumed>' };
  } catch (e) { /* ignore */ }
  try {
    return await res.json();
  } catch (e) {
    try { return { status: res.status, text: await res.text() }; }
    catch (e2) { return { status: res.status, text: '<unreadable body>' }; }
  }
}

function getBase() {
  return sessionStore.baseUrl || process.env.BASE_URL || 'http://localhost:8081';
}

// ---------------------------------------------------------------------------
// Internal helpers: open / close WebSocket
// ---------------------------------------------------------------------------

async function _openWebSocket(connectedTimeout = 10000) {
  const base = getBase();
  const u = new URL(base);
  u.protocol = u.protocol === 'https:' ? 'wss:' : 'ws:';
  u.pathname = '/ws/marketdata';
  u.searchParams.set('token', sessionStore.currentToken);

  const ws = new WebSocket(u.toString());
  sessionStore.ws = ws;

  // wait for 'connected' message from server
  await new Promise((resolve, reject) => {
    let settled = false;
    const onMsg = (data) => {
      try {
        const msg = JSON.parse(data.toString());
        if (msg.type === 'connected' && !settled) {
          settled = true; cleanup(); resolve();
        }
      } catch (e) { /* ignore */ }
    };
    const onError = (err) => { if (!settled) { settled = true; cleanup(); reject(err); } };
    const cleanup = () => {
      clearTimeout(timer);
      try { ws.off('message', onMsg); } catch (e) {}
      try { ws.off('error', onError); } catch (e) {}
    };
    ws.on('message', onMsg);
    ws.on('error', onError);
    const timer = setTimeout(() => {
      if (!settled) {
        settled = true; cleanup();
        try { ws.terminate(); } catch (e) {}
        sessionStore.ws = null;
        reject(new Error('WS connected timeout'));
      }
    }, connectedTimeout);
  });

  // mandatory stabilization delay: let backend SDP connections settle before subscribe
  await new Promise(r => setTimeout(r, 2000));
}

async function _closeWebSocket(timeout = 5000) {
  const ws = sessionStore.ws;
  if (!ws) return;
  sessionStore.ws = null;
  await new Promise((resolve) => {
    let settled = false;
    const onClose = () => { if (!settled) { settled = true; resolve(); } };
    ws.on('close', onClose);
    try { ws.close(); } catch (e) { try { ws.terminate(); } catch (e2) {} }
    setTimeout(() => { if (!settled) { settled = true; try { ws.terminate(); } catch (e) {} resolve(); } }, timeout);
  });
}

// ---------------------------------------------------------------------------
// Exported API
// ---------------------------------------------------------------------------

/**
 * Login. Stores token and baseUrl internally.
 * Parameters: user, password, ip, port, [baseUrl]
 */
export async function login(user, password, ip, port, baseUrl = process.env.BASE_URL || 'http://localhost:8081') {
  sessionStore.baseUrl = baseUrl;
  const loginPaths = ['/api/auth/login', '/auth/login'];
  let token = null;
  let lastResp = null;

  for (const p of loginPaths) {
    const url = `${baseUrl}${p}`;
    try {
      const res = await fetch(url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: user, password, ipspHost: ip, ipspPort: Number(port), useSsl: true }),
      });
      const j = await tryJson(res);
      lastResp = { status: res.status, body: j };
      if (res.ok && (j.token || j.data?.token)) { token = j.token || j.data.token; break; }
    } catch (err) { /* try next */ }
  }

  if (!token) { const err = new Error('Login failed'); err.details = lastResp; throw err; }
  sessionStore.currentUser = user;
  sessionStore.currentToken = token;
  console.log('Login ok, user:', user);
  return { user, token };
}

/**
 * Logout. Uses stored user.
 * Parameters: user
 */
export async function logout(user) {
  if (!sessionStore.currentUser || sessionStore.currentUser !== user)
    throw new Error('No active session for user: ' + user);
  const token = sessionStore.currentToken;
  const res = await fetch(`${getBase()}/api/auth/logout`, { method: 'POST', headers: { Authorization: token } });
  const body = await tryJson(res);
  sessionStore.currentUser = null;
  sessionStore.currentToken = null;
  console.log('Logout ok, status:', res.status);
  return { ok: res.ok, status: res.status, body };
}

/**
 * Register a predicate-based handler for marketData messages.
 * Opens WebSocket internally if not already open (includes 2s stabilization delay).
 * Parameters: classIds, predicate(msg)=>bool, onMatch(msg)=>void, { once, timeout }
 * Returns: { dispose, promise }  — promise resolves with matching msg or null on timeout
 */
export async function registerRecordHandler(classIds, predicate, onMatch, { once = true, timeout = 60000 } = {}) {
  if (!sessionStore.currentToken) throw new Error('No active session. Call login() first.');

  // open WS (includes 2s stabilization delay) only if not already open
  if (!sessionStore.ws || sessionStore.ws.readyState !== WebSocket.OPEN) {
    await _openWebSocket();
  }

  const localWs = sessionStore.ws;
  const ids = Array.isArray(classIds) ? classIds.map(Number) : [Number(classIds)];
  let disposed = false;
  let timer = null;
  let resolvePromise;
  const promise = new Promise((resolve) => { resolvePromise = resolve; });

  const onMessage = async (data) => {
    if (disposed) return;
    let msg;
    try { msg = JSON.parse(data.toString()); } catch (e) { return; }
    if (msg.type !== 'marketData' || !ids.includes(msg.classId)) return;
    try {
      const ok = await Promise.resolve(predicate(msg));
      if (ok) {
        try { onMatch(msg); } catch (e) { console.error('onMatch error', e); }
        resolvePromise(msg);
        if (once) dispose();
      }
    } catch (e) { console.error('predicate error', e); }
  };

  const dispose = () => {
    if (disposed) return;
    disposed = true;
    try { localWs.off('message', onMessage); } catch (e) {}
    if (timer) { clearTimeout(timer); timer = null; }
    resolvePromise(null);
  };

  localWs.on('message', onMessage);
  if (timeout) timer = setTimeout(() => { if (!disposed) dispose(); }, timeout);

  return { dispose, promise };
}

/**
 * Subscribe to one or more classes via REST.
 * WebSocket must already be open (call registerRecordHandler first).
 * Parameters: classIds, { waitForMessages, maxMessages, timeout }
 * Returns: { subscribeResult, messages }
 */
export async function subscribe(classIds, { waitForMessages = true, maxMessages = 10, timeout = 60000 } = {}) {
  if (!sessionStore.currentToken || !sessionStore.currentUser)
    throw new Error('No active session. Call login() first.');
  if (!sessionStore.ws || sessionStore.ws.readyState !== WebSocket.OPEN)
    throw new Error('WebSocket not open. Call registerRecordHandler() first.');

  const ids = Array.isArray(classIds) ? classIds.map(Number) : [Number(classIds)];

  // start collector BEFORE sending REST subscribe to avoid missing early messages
  const collectorResult = waitForMessages ? _startCollector(ids, maxMessages, timeout) : null;

  const res = await fetch(`${getBase()}/api/classes/subscribe`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${sessionStore.currentToken}` },
    body: JSON.stringify({ username: sessionStore.currentUser, classIds: ids, filterKey: 0 }),
  });
  const body = await tryJson(res);
  console.log('Subscribe REST result:', res.status);

  if (!waitForMessages) return { subscribeResult: { ok: res.ok, status: res.status, body }, messages: [] };

  const messages = await collectorResult.promise;
  console.log('Collected', messages.length, 'messages');
  return { subscribeResult: { ok: res.ok, status: res.status, body }, messages };
}

/**
 * Unsubscribe from one or more classes via REST, then close WebSocket gracefully.
 * Parameters: classIds
 */
export async function unsubscribe(classIds) {
  if (!sessionStore.currentToken) throw new Error('No active token');
  const ids = Array.isArray(classIds) ? classIds.map(Number) : [Number(classIds)];
  const res = await fetch(`${getBase()}/api/classes/unsubscribe`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json', 'Authorization': `Bearer ${sessionStore.currentToken}` },
    body: JSON.stringify({ classIds: ids }),
  });
  const body = await tryJson(res);
  console.log('Unsubscribe REST result:', res.status);

  // close WS gracefully after unsubscribe (awaitable)
  await _closeWebSocket();

  return { ok: res.ok, status: res.status, body };
}

// ---------------------------------------------------------------------------
// Internal: message collector
// ---------------------------------------------------------------------------

function _startCollector(ids, maxMessages, timeout) {
  const ws = sessionStore.ws;
  const messages = [];
  let finished = false;
  let timer = null;
  let resolveFn;
  const promise = new Promise((resolve) => { resolveFn = resolve; });

  const onMsg = (data) => {
    try {
      const msg = JSON.parse(data.toString());
      if (msg.type === 'marketData' && ids.includes(msg.classId)) {
        messages.push(msg);
        if (messages.length >= maxMessages && !finished) { finished = true; cleanup(); resolveFn(messages); }
      }
    } catch (e) { /* ignore */ }
  };

  const onClose = () => { if (!finished) { finished = true; cleanup(); resolveFn(messages); } };

  const cleanup = () => {
    try { ws.off('message', onMsg); } catch (e) {}
    try { ws.off('close', onClose); } catch (e) {}
    if (timer) { clearTimeout(timer); timer = null; }
  };

  ws.on('message', onMsg);
  ws.on('close', onClose);
  timer = setTimeout(() => { if (!finished) { finished = true; cleanup(); resolveFn(messages); } }, timeout);

  return { promise, messages, stop: () => { if (!finished) { finished = true; cleanup(); resolveFn(messages); } } };
}
