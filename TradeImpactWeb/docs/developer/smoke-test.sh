#!/usr/bin/env bash
set -euo pipefail

# Smoke test script for TradeImpact Web Gateway
# Usage: ./smoke-test.sh [BASE_URL]
# Requires: curl, jq. Optional: websocat or wscat for WebSocket test.

BASE_URL=${1:-http://localhost:8080}

echo "Base URL: $BASE_URL"

echo "1) Login"
LOGIN_RESP=$(curl -s -X POST "$BASE_URL/api/auth/login" \
  -H 'Content-Type: application/json' \
  -d '{"username":"dev","password":"dev","ipspHost":"127.0.0.1","ipspPort":8800,"useSsl":false}')

echo "$LOGIN_RESP" | jq || true
TOKEN=$(echo "$LOGIN_RESP" | jq -r '.token // empty')
if [ -z "$TOKEN" ]; then
  echo "Login failed or no token returned. Aborting smoke test." >&2
  exit 1
fi
echo "Token: $TOKEN"

echo
echo "2) Create subscription"
SUB_RESP=$(curl -s -X POST "$BASE_URL/api/markets/BV/subscriptions" \
  -H "Authorization: Bearer $TOKEN" \
  -H 'Content-Type: application/json' \
  -d '{"classId":100003,"subscriptionParams":{}}')
echo "$SUB_RESP" | jq || true
SUB_ID=$(echo "$SUB_RESP" | jq -r '.subscriptionId // .id // empty')
echo "Subscription ID: ${SUB_ID:-<none>}"

echo
echo "3) Send monitored transaction"
TXN_RESP=$(curl -s -X POST "$BASE_URL/api/markets/BV/transactions" \
  -H "Authorization: Bearer $TOKEN" \
  -H 'Content-Type: application/json' \
  -d '{"classId":114809,"action":"ADD","smpPayload":{"InstrumentId":12345}}')
echo "$TXN_RESP" | jq || true

echo
echo "4) WebSocket helper (manual step)"
echo "If you have 'websocat' installed you can run (in separate terminal):"
echo "  websocat \"ws://localhost:8080/ws/BV?token=$TOKEN\""
echo "Or with wscat (npm):"
echo "  wscat -c \"ws://localhost:8080/ws/BV?token=$TOKEN\""

echo
echo "Smoke test completed. Check server logs for subscription/txn routing and WebSocket messages."
