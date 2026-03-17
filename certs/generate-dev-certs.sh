#!/usr/bin/env bash
set -euo pipefail

OUTDIR="$(dirname "$0")"
mkdir -p "$OUTDIR"

KS_PASS=${KS_PASS:-changeit}
CLIENT_PASS=${CLIENT_PASS:-changeit}

echo "Generating server keystore..."
keytool -genkeypair -alias server -keyalg RSA -keysize 2048 -storetype PKCS12 \
  -keystore "$OUTDIR/server-keystore.p12" -storepass "$KS_PASS" -dname "CN=localhost"

echo "Generating client keystore..."
keytool -genkeypair -alias client1 -keyalg RSA -storetype PKCS12 \
  -keystore "$OUTDIR/client1-keystore.p12" -storepass "$CLIENT_PASS" -dname "CN=client1"

echo "Exporting client cert and importing into server truststore..."
keytool -export -alias client1 -keystore "$OUTDIR/client1-keystore.p12" -rfc -file "$OUTDIR/client1.cer" -storepass "$CLIENT_PASS"
keytool -importcert -alias client1 -file "$OUTDIR/client1.cer" -keystore "$OUTDIR/server-truststore.jks" -storepass "$KS_PASS" -noprompt

echo "Done. Files in $OUTDIR"
