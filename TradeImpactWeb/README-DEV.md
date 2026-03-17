# TradeImpact Web Gateway — Quickstart Sviluppo

Questa guida rapida spiega come avviare e testare l'applicazione in ambiente di sviluppo. È pensata per uno sviluppatore che prende in carico il progetto e non conosce necessariamente i concetti di REST, WebSocket, JWT o mTLS: ogni concetto è spiegato brevemente e collegato alle configurazioni rilevanti.

## Prerequisiti
- Java 17+ (OpenJDK). Verificare con `java -version`.
- Maven 3.6+ (`mvn`).
- (Opzionale) Node.js + `wscat` o `websocat` per testare WebSocket.
- Accesso al repository con i JAR di mercato (opzionale) oppure usare il fallback CSV in `config/classes.csv`.

## Concetti veloci
- REST: API HTTP sincrone (es. `POST /api/markets/{market}/transactions`) per inviare richieste.
- WebSocket: canale TCP persistente per ricevere push di dati di mercato in tempo reale.
- JWT: token firmati usati per autenticare richieste HTTP/WebSocket; vengono verificati dal server.
- mTLS: TLS mutuo — sia server che client presentano certificati per autenticarsi reciprocamente.

## Generare certificati di sviluppo (opzionale)
Per testare HTTPS/mTLS in locale:

```bash
cd certs
./generate-dev-certs.sh
```

Lo script genera keystore/PFX per server e client nella cartella `certs/`.

## Variabili d'ambiente utili
- `JWT_JWK_SET_URI` — URL del JWK Set per verificare le firme JWT (preferito).
- `SERVER_SSL_ENABLED=true|false` — abilita HTTPS nell'embedded server.
- `SERVER_SSL_PFX_PATH` / `SERVER_SSL_PFX_PASSWORD` — PKCS12 per server (alternativa JKS con `SERVER_SSL_KEYSTORE_*`).
- `SERVER_SSL_CLIENT_AUTH=need|want|false` — richiedi certificato client (mTLS).
- `SDP_CLASSES_JAR` — percorso al JAR di mercato (se disponibile).
- `JANSI_TMPDIR` / usare `-Djansi.tmpdir=/path` — workaround per ambienti con `/tmp` montato `noexec` (vedi note sotto).

Esempio minimale (Linux/macOS):

```bash
export SERVER_SSL_ENABLED=true
export SERVER_SSL_PFX_PATH=certs/server.p12
export SERVER_SSL_PFX_PASSWORD=changeit
export SERVER_SSL_CLIENT_AUTH=want
export JWT_JWK_SET_URI=https://auth.example.com/.well-known/jwks.json
```

## Avviare l'applicazione

1) Avviare in modalità sviluppo (hot-reload non garantito):

```bash
mvn -f TradeImpactWeb/pom.xml spring-boot:run
```

2) O costruire e lanciare il JAR:

```bash
mvn -f TradeImpactWeb/pom.xml -DskipTests package
java -jar TradeImpactWeb/target/tradeimpact-web-gateway-1.0.0-SNAPSHOT.jar
```

Se ricevi errori legati a `libjansi` in ambienti con `/tmp` montato `noexec`, avvia con:

```bash
mvn -f TradeImpactWeb/pom.xml spring-boot:run -Djansi.tmpdir=/path/to/executable/tmp
```

## Test rapidi (smoke tests)

1) Ottenere un token (login):

```bash
curl -s -X POST http://localhost:8080/api/auth/login \
  -H 'Content-Type: application/json' \
  -d '{"username":"dev","password":"dev","ipspConfig":{}}' | jq
```

Risposta attesa: JSON con campo `token` (UUID o JWT a seconda della configurazione).

2) Inviare una transazione (esempio generico):

```bash
TOKEN=<token-from-login>
curl -s -X POST http://localhost:8080/api/markets/BV/transactions \
  -H "Authorization: Bearer $TOKEN" \
  -H 'Content-Type: application/json' \
  -d '{"classId":"BOND","smpPayload":{"field1":"value"}}' | jq
```

3) Creare una sottoscrizione (REST)

```bash
curl -s -X POST http://localhost:8080/api/markets/BV/subscriptions \
  -H "Authorization: Bearer $TOKEN" \
  -H 'Content-Type: application/json' \
  -d '{"classId":"BOND","subscriptionParams":{}}' | jq
```

4) Connettersi via WebSocket e ricevere dati di mercato

Con `wscat` (installare via `npm i -g wscat`):

```bash
wscat -c "ws://localhost:8080/ws/BV?token=$TOKEN"
# oppure per wss:
wscat -c "wss://localhost:8443/ws/BV?token=$TOKEN" --no-check
```

Quando vengono pubblicati eventi di mercato per la `classId` a cui sei iscritto, li vedrai nella sessione WebSocket.

## Eseguire test automatici (unit/integration)

```bash
mvn -f TradeImpactWeb/pom.xml test
```

Nota: alcuni test richiedono JAR di mercato o certs; se non vuoi eseguirli tutti, usa `-DskipITs=true` o filtra i test.

## Debug e troubleshooting
- JWT: se non hai un `JWT_JWK_SET_URI`, il codice ricade su un segreto HMAC di sviluppo — non usarlo in produzione.
- mTLS: assicurati che il `truststore` contenga la CA che ha firmato i certificati client.
- Classi di mercato mancanti: se i JAR di mercato non sono presenti il sistema userà i mapper CSV in `config/classes.csv` e `BvfFactoryAdapter` come fallback (comportamento limitato).

## Dove trovare i file chiave
- Documentazione architetturale: [PROXY_ARCHITECTURE.md](../PROXY_ARCHITECTURE.md)
- Controller principali: [TradeImpactWeb/src/main/java/com/mts/gateway/controller](src/main/java/com/mts/gateway/controller)
- WebSocket handler: [TradeImpactWeb/src/main/java/com/mts/gateway/websocket/MarketDataWebSocketHandler.java](src/main/java/com/mts/gateway/websocket/MarketDataWebSocketHandler.java)
- Sicurezza: [TradeImpactWeb/src/main/java/com/mts/gateway/security/SecurityConfig.java](src/main/java/com/mts/gateway/security/SecurityConfig.java)
- SSL helpers: [TradeImpactWeb/src/main/java/com/mts/gateway/ssl/SSLContextFactory.java](src/main/java/com/mts/gateway/ssl/SSLContextFactory.java)

## Documentazione API & smoke-test
- API HTML e smoke-test script sono disponibili in: [TradeImpactWeb/docs/developer](docs/developer)
  - [API-WS-Documentation.html](docs/developer/API-WS-Documentation.html)
  - `docs/developer/smoke-test.sh` (rendilo eseguibile: `chmod +x docs/developer/smoke-test.sh`)

---

Se vuoi, posso generare:
- un set di `curl` più dettagliati per ogni endpoint (con esempi di payload),
- uno script di smoke test `scripts/smoke-test.sh` che esegue login→subscribe→send txn→check ws,
- o una pagina di debugging per configurare e testare mTLS con `openssl`.
