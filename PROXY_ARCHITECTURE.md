# Architettura del Proxy REST ↔ WebSocket

Questa guida descrive l'architettura del proxy TradeImpact Web Gateway: come sono organizzati i componenti, il flusso dati principale, le dipendenze critiche e le istruzioni rapide per sviluppatori che devono prendere in carico il progetto. Il documento è scritto per chi non conosce a fondo concetti come API REST, WebSocket, mTLS o JWT: fornisce spiegazioni di base e collegamenti alla posizione dei file rilevanti nel repository.

---

**Obiettivo**: esporre le funzionalità del server TradeImpact (PDU SAP/SMP) tramite API REST per operazioni sincrone e tramite WebSocket per dati di mercato push (sottoscrizioni). Il proxy traduce payload JSON ↔ oggetti SMP Java e gestisce connessioni SDP verso gli Access Point/ IP Service Provider (IPSP).

**Principali responsabilità**
- Ricevere richieste REST (es. invio transazioni, gestione sottoscrizioni).
- Creare gli oggetti SMP corrispondenti ai PDU e inviarli via SDP.
- Ricevere callback asincroni / broadcast da SDP e inoltrarli ai client WebSocket autorizzati.
- Gestire sicurezza: TLS/mTLS per i canali di rete, validazione JWT per utenti HTTP/WebSocket, IP‑whitelist applicata su entry REST.
- Persistere e fornire accesso ai dati di mercato (table-per-class) per query e paginazione.

---

**Componenti principali (mappa a file)**
- Controller REST (endpoint):
  - `TransactionController` — `/api/markets/{market}/transactions` (monitored only exposed)
  - `SubscriptionController` — `/api/subscriptions` (crea/elimina/consulta sottoscrizioni)
  - `ClassController` / `ClassMetadataController` — metadati classi SMP e schema
  - `AuthController` — login/logout/session
  - `DatabaseManagementController` — strumenti di ispezione e cleanup DB

- WebSocket:
 4) Invio transazione sincrona/monitorata (REST)
 Client POST a `/api/markets/{market}/transactions` con payload JSON che include `classId` (il mercato è nel path).

- SDP / low-level protocol:
  - `SDPConnectionPool` — pool di connessioni verso AP per performance e riuso.
  - `SDPConnection` — singola connessione verso un Access Point/IPSP con canali: broadcast, transaction, addressService.
  - `SimpleSDPConnectionService` — servizio di alto livello usato dai controller per inviare transazioni e richiedere AddressService.

- Class loading e mapping dinamico:
  - `SDPClassLoaderService` — carica JAR di mercato dinamicamente (hot-reload opzionale) e istanzia `MarketFactory` dal JAR.
  - `CsvClassLoaderService` — fallback: carica mapping classe↔classId dal CSV (`config/classes.csv`).
  - `SmpJsonMapper` / `SmpJsonMapperRegistry` — mappatori market‑specific che convertono Map/JSON ↔ oggetti SMP.
  - `BvfFactoryAdapter` — adapter riflessivo per BV/BVF quando le librerie di mercato non sono in compile classpath.

- Serializzazione / deserializzazione:
  - `SMPMessageSerializer` — converte oggetti SMP in JSON strutturato per il frontend.
  - `GenericSMPSerializer` / `GenericSMPDeserializer` — serializzazione dinamica basata su schema/metadata.

- Sicurezza e TLS:
  - `SecurityConfig` — regole Spring Security (JWT, IP whitelist)
  - `SecurityServerConfig` — helper per abilitare HTTPS/mTLS nell'embedded server (imposta `server.ssl.*` da env).
  - `SSLContextFactory` — crea `SSLContext` da PKCS12 o keystore/truststore per connessioni SDP che richiedono TLS.
  - `IpWhitelistFilter` — filtro semplice per whitelist IP.

- Persistenza e tabelle dinamiche:
  - `MarketDataUpsertService` / `DynamicTableService` — salva dati di mercato in tabelle `market_data_<classId>` (UPSERT basato su `hashKey`).
  - `SubscriptionRepository` / `MarketDataRepository` — JPA repository per dati persistiti (se abilitato).

- Stato in memoria e routing:
  - `ActiveSubscriptionService` — mappa in memoria username → sottoscrizioni attive (classId, subscriptionKey).
  - `AuthService` — gestisce sessioni token, login (IPSP + inizializzazione connessioni) e logout.

---

Flussi principali (semplificati)

1) Login e inizializzazione
- Il client invia `POST /api/auth/login` con credenziali e parametri IPSP.
- `AuthService.login()` effettua una connessione temporanea all'IPSP per ottenere AddressService, quindi chiama `SDPConnectionPool.initializeMarketConnections(...)` per istanziare le connessioni verso gli Access Point configurati.
- Genera un `token` (UUID) per la sessione e lo ritorna al client; il token è usato per autorizzare REST e WebSocket.

2) Invio transazione sincrona/monitorata (REST)
- Client POST a `/api/markets/{market}/transactions` con payload JSON che include `classId`.
- Controller -> `TransactionService` (o `SimpleSDPConnectionService`) usa `SmpJsonMapperRegistry` per creare l'oggetto SMP dal payload JSON.
- Viene preso dalla `SDPConnectionPool` un `SDPConnection` per inviare la transazione tramite `transactionChannel`.
- Per monitored transaction il metodo ritorna immediatamente un `reqId` (txnId) che può essere usato dal client per correlare risposte asincrone.

3) Sottoscrizione e push dati (WebSocket)
- Client richiede una sottoscrizione via REST (`/api/subscriptions`) o apre una WebSocket collegandosi a `/ws...` includendo il `token`.
- `SubscriptionService` invia la richiesta di sottoscrizione via SDP (broadcast/subscribe) e registra la sottoscrizione in `ActiveSubscriptionService` e persistente (se abilitato).
- Quando `SDPConnection` riceve dati di sottoscrizione (`onSubscribeData`), serializza il messaggio con `SMPMessageSerializer.toJson()` e chiama `MarketDataWebSocketHandler.broadcastMarketData(classId, className, data)`.
- `MarketDataWebSocketHandler` ora non trasmette più a tutti: costruisce l'insieme degli utenti iscritti a `classId` (da `ActiveSubscriptionService`), mappa le sessioni WebSocket al `token` e dal token ricava lo `username` tramite `AuthService.getSession(token)`. Invia il messaggio solo alle sessioni il cui username è tra gli iscritti.

---

Sicurezza: concetti base e come sono applicati

- TLS / mTLS
  - TLS: cifratura del canale di rete (HTTPS per REST, TLS per SDP se abilitato) evita che terze parti leggano o modifichino i messaggi.
  - mTLS (mutual TLS): il server richiede anche un certificato dal client; utile per autenticazione forte tra servizi.
  - Configurazione: usare variabili d'ambiente `SERVER_SSL_*` per abilitare HTTPS/mTLS sul server e `sdp.ipsp.ssl.*` o `IPSP_SSL_*` per abilitare TLS nelle connessioni SDP.
  - Dev: esiste `certs/generate-dev-certs.sh` per creare PFX/JKS di sviluppo.

- JWT (JSON Web Token)
  - Token firmati che il client include in `Authorization: Bearer <token>` per dimostrare l'identità.
  - `SecurityConfig` configura un `JwtDecoder` che, se disponibile, usa un endpoint JWK (`JWT_JWK_SET_URI`) per verificare le firme; altrimenti usa un segreto HMAC di fallback (non sicuro per produzione).

- IP Whitelist
  - `IpWhitelistFilter` blocca richieste REST provenienti da IP non consentiti (utile in contesti con IP statici o per hardening addizionale).

---

Come si mette in piedi in sviluppo (quickstart)

1) Genera certificati di sviluppo (opzionale, per HTTPS/mTLS):
```bash
cd certs
./generate-dev-certs.sh
```

2) Variabili d'ambiente utili
- `JWT_JWK_SET_URI` → URL JWK per la verifica JWT (preferito)
- `SERVER_SSL_ENABLED=true|false` → abilita HTTPS sull'embedded server
- `SERVER_SSL_PFX_PATH` / `SERVER_SSL_PFX_PASSWORD` → PKCS12 per server
- `SERVER_SSL_KEYSTORE_PATH` / `SERVER_SSL_KEYSTORE_PASSWORD` e `SERVER_SSL_TRUSTSTORE_PATH` / `SERVER_SSL_TRUSTSTORE_PASSWORD` → alternative JKS
- `SERVER_SSL_CLIENT_AUTH=need|want|false` → richiedi certificato client (mTLS)
- `SDP_CLASSES_JAR` → path al jar del market se disponibile

3) Avviare l'applicazione
```bash
mvn -f TradeImpactWeb/pom.xml spring-boot:run
```

4) Test rapidi
- REST: usa `curl` o Postman per `POST /api/auth/login` e ottenere token; poi chiama le altre API con `Authorization: Bearer <token>`.
- WebSocket: connetti a `wss://<host>:<port>/ws/{market}` includendo `?token=<token>` nella query o impostando header `Authorization: Bearer <token>`.

---

Punti di attenzione / troubleshooting
- Le librerie di mercato (sdp-bvf, ecc.) potrebbero non essere nel classpath: in tal caso il sistema usa `CsvClassLoaderService` (CSV `config/classes.csv`) e `BvfFactoryAdapter` riflessivo come fallback. Per comportamento reale installare i JAR di mercato e impostare `SDP_CLASSES_JAR`.
- maven in ambiente con /tmp montato noexec (errori jansi): impostare `-Djansi.tmpdir=/some/executable/tmp` se necessario.
- JWT: in produzione usare `JWT_JWK_SET_URI` e non il segreto HMAC hardcoded.
- mTLS: la configurazione `server.ssl.*` è impostata tramite `SecurityServerConfig` leggendo le env; verificare che il keystore/truststore siano corretti e che i client presentino certificati firmati dalla CA Truststore.

---

Dove iniziare per un nuovo sviluppatore
1. Leggi questo file e poi apri `TransactionController` e `MarketDataWebSocketHandler` per vedere i flussi principali.
2. Esegui l'app localmente con `mvn -f TradeImpactWeb/pom.xml spring-boot:run` e prova le chiamate REST unità alla volta.
3. Se ti servono i JAR di mercato per test reali, chiedi all'operations o scaricali e imposta `SDP_CLASSES_JAR`.
4. Per aggiungere un nuovo endpoint REST: crea il controller sotto `com.mts.gateway.controller`, delega la logica a un `@Service`, usa i DTO presenti in `rest/dto`.

---

File utili da consultare (rapida lista)
- `TradeImpactWeb/src/main/java/com/mts/gateway/controller/TransactionController.java`
- `TradeImpactWeb/src/main/java/com/mts/gateway/websocket/MarketDataWebSocketHandler.java`
- `TradeImpactWeb/src/main/java/com/mts/gateway/sdp/SDPConnection.java`
- `TradeImpactWeb/src/main/java/com/mts/gateway/sdp/SDPConnectionPool.java`
- `TradeImpactWeb/src/main/java/com/mts/gateway/smp` (mappers)
- `TradeImpactWeb/src/main/java/com/mts/gateway/security/SecurityConfig.java`
- `TradeImpactWeb/src/main/java/com/mts/gateway/ssl/SSLContextFactory.java`
- `TradeImpactWeb/config/classes.csv` (se presente)

---

Se vuoi, posso:
- generare una pagina README step‑by‑step per avviare l'ambiente dev con certificati di test;
- creare esempi `curl` e uno script di smoke‑test per REST + WebSocket;
- o procedere a documentare in dettaglio ogni controller (endpoints, payload, esempi).

Fine della panoramica architetturale.
