# Market-Specific Container Configuration

## Overview

L'applicazione ora supporta **container specializzati per mercato**. Ogni istanza del container si connette esclusivamente al mercato configurato, filtrando automaticamente gli indirizzi ricevuti dall'IPSP.

## Architettura

### 1. Configurazione Market-ID

**File**: `application.yml`
```yaml
sdp:
  market-id: ${MARKET_ID:1}  # Default: BVF (Market ID 1)
  market-classes-jar: ${SDP_CLASSES_JAR:./libs/sdp-bvf-BV14.1_20260128.1-sources.jar}
```

**Configurazione Java**: `SDPConfigProperties.java`
```java
@ConfigurationProperties(prefix = "sdp")
public class SDPConfigProperties {
    private Integer marketId;  // Market identifier (numeric)
    // ...
}
```

### 2. Flusso di Login e Connessione

```
┌─────────────────────────────────────────────────────────────┐
│ 1. USER LOGIN                                               │
│    - Username, Password, IPSP Host, IPSP Port               │
└─────────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────────┐
│ 2. IPSP CONNECTION (AuthService)                            │
│    - Connessione temporanea all'IPSP                        │
│    - Login con credenziali utente                           │
└─────────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────────┐
│ 3. ADDRESS SERVICE REQUEST                                  │
│    - Invio SAPAddressServiceReqExt                          │
│    - Attesa risposta SAPAddressServiceResExt (30s timeout)  │
│    - IPSP ritorna TUTTI i mercati disponibili               │
└─────────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────────┐
│ 4. MARKET FILTERING (SDPConnectionPool)                     │
│    - Filtra SOLO il mercato configurato (market-id)         │
│    - Estrae indirizzi servizi per quel mercato:             │
│      * INFO_BRT (Broadcast/Subscriptions)                   │
│      * TXN_INFO_PRIV (Transactions)                         │
│      * QUERY (Query service)                                │
└─────────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────────┐
│ 5. MARKET-SPECIFIC CONNECTIONS                              │
│    - Crea connessioni SOLO per il mercato target            │
│    - Pool separati per ogni tipo di servizio                │
│    - Chiusura connessione temporanea IPSP                   │
└─────────────────────────────────────────────────────────────┘
```

## Implementazione

### SDPConnection - Address Service Request

**Metodo aggiunto**: `requestAddressService()`

```java
public SAPAddressServiceResExt requestAddressService() throws Exception {
    if (!loggedIn.get()) {
        throw new IllegalStateException("Must be logged in");
    }
    
    // Crea future per attendere risposta
    addressServiceFuture = new CompletableFuture<>();
    
    // Invia richiesta
    SAPAddressServiceReqExt request = new SAPAddressServiceReqExt(new SAPHeader());
    request.setReqId(new ULong(System.currentTimeMillis()));
    addressServiceChannel.addressService(request);
    
    // Attende risposta (timeout 30s)
    return addressServiceFuture.get(30, TimeUnit.SECONDS);
}
```

**Callback handler**: `onAddressService(SAPAddressServiceResExt res)`

```java
@Override
public void onAddressService(SAPAddressServiceResExt res) {
    // Logga tutti i mercati ricevuti
    for (Platform platform : res.getPlatforms()) {
        int marketId = platform.getPlatform().getValue();
        for (Service service : platform.getServices()) {
            log.info("Market {}: {} -> {}:{}", 
                marketId, service.getService(), 
                service.getAddress(), service.getPort());
        }
    }
    
    // Completa il future per sbloccare requestAddressService()
    if (addressServiceFuture != null && !addressServiceFuture.isDone()) {
        addressServiceFuture.complete(res);
    }
}
```

### SDPConnectionPool - Market Filtering

**Metodo aggiunto**: `initializeMarketConnections(SAPAddressServiceResExt)`

```java
public void initializeMarketConnections(SAPAddressServiceResExt addressResponse) {
    Integer targetMarketId = config.getMarketId();
    
    // Trova il platform/market target
    Platform targetPlatform = null;
    for (Platform platform : addressResponse.getPlatforms()) {
        if (platform.getPlatform().getValue() == targetMarketId) {
            targetPlatform = platform;
            break;
        }
    }
    
    if (targetPlatform == null) {
        throw new IllegalStateException(
            "Market ID " + targetMarketId + " not found in IPSP response"
        );
    }
    
    // Estrae servizi per il mercato target
    Map<String, Service> marketServices = new HashMap<>();
    for (Service service : targetPlatform.getServices()) {
        String poolService = mapSAPServiceTypeToPoolService(service.getService());
        if (poolService != null) {
            marketServices.put(poolService, service);
        }
    }
    
    // Crea connessioni SOLO per questo mercato
    for (Map.Entry<String, Service> entry : marketServices.entrySet()) {
        String serviceType = entry.getKey();
        Service serviceInfo = entry.getValue();
        
        // Crea minSize connessioni per questo servizio
        for (int i = 0; i < minSize; i++) {
            SDPConnection connection = createConnectionToMarket(
                serviceType,
                serviceInfo.getAddress(),
                serviceInfo.getPort()
            );
            connectionPools.get(serviceType).offer(connection);
        }
    }
}
```

### AuthService - Orchestrazione Login

```java
public LoginResponse login(LoginRequest request) throws Exception {
    // 1. Connessione temporanea IPSP
    ipspConnection = new SDPConnection(
        UUID.randomUUID().toString(),
        request.getIpspHost(),
        request.getIpspPort(),
        "INFO_PRIV",
        request.getUsername(),
        request.getPassword(),
        marketFactory
    );
    ipspConnection.connect();
    
    // Attende login (max 10s)
    for (int i = 0; i < 10; i++) {
        if (ipspConnection.isLoggedIn()) break;
        Thread.sleep(1000);
    }
    
    // 2. Richiesta indirizzi
    SAPAddressServiceResExt addressResponse = ipspConnection.requestAddressService();
    
    // 3. Inizializza connessioni per il mercato configurato
    connectionPool.initializeMarketConnections(addressResponse);
    
    // 4. Chiude connessione temporanea
    ipspConnection.close();
    
    return LoginResponse.builder()
        .success(true)
        .message("Connected to market " + config.getMarketId())
        .token(token)
        .build();
}
```

## Deployment

### Container per BVF (Market ID = 1)

```bash
docker run -d \
  --name tradeimpact-bvf \
  -e MARKET_ID=1 \
  -e SDP_CLASSES_JAR=/app/libs/sdp-bvf.jar \
  -v ./libs/sdp-bvf-BV14.1_20260128.1-sources.jar:/app/libs/sdp-bvf.jar \
  -p 8080:8080 \
  tradeimpact-web-gateway:latest
```

### Container per Altro Mercato (Market ID = 2)

```bash
docker run -d \
  --name tradeimpact-market2 \
  -e MARKET_ID=2 \
  -e SDP_CLASSES_JAR=/app/libs/sdp-market2.jar \
  -v ./libs/sdp-market2.jar:/app/libs/sdp-market2.jar \
  -p 8081:8080 \
  tradeimpact-web-gateway:latest
```

### Docker Compose - Multi-Market

```yaml
version: '3.8'

services:
  tradeimpact-bvf:
    image: tradeimpact-web-gateway:latest
    container_name: tradeimpact-bvf
    environment:
      - MARKET_ID=1
      - SDP_CLASSES_JAR=/app/libs/sdp-bvf.jar
    volumes:
      - ./libs/sdp-bvf.jar:/app/libs/sdp-bvf.jar
    ports:
      - "8080:8080"
    networks:
      - tradeimpact-net

  tradeimpact-market2:
    image: tradeimpact-web-gateway:latest
    container_name: tradeimpact-market2
    environment:
      - MARKET_ID=2
      - SDP_CLASSES_JAR=/app/libs/sdp-market2.jar
    volumes:
      - ./libs/sdp-market2.jar:/app/libs/sdp-market2.jar
    ports:
      - "8081:8080"
    networks:
      - tradeimpact-net

networks:
  tradeimpact-net:
    driver: bridge
```

## Vantaggi

### 1. Scalabilità Orizzontale
- Più istanze dello stesso mercato → Load balancing
- Mercati diversi su porte diverse → Separazione logica

### 2. Isolamento
- Errori su un mercato non impattano gli altri
- Aggiornamenti indipendenti per mercato

### 3. Sicurezza
- Ogni container ha accesso SOLO al mercato configurato
- Nessun rischio di cross-contamination dati

### 4. Operatività
- Deployment chiaro: 1 container = 1 mercato
- Log separati per mercato
- Monitoring granulare

## Esempio di Log

```
INFO  - Connecting to IPSP at ipsp.example.com:8800
INFO  - Successfully logged in to IPSP
INFO  - Requesting address service information
INFO  - Address service response received
INFO  - Platform/Market ID: 1
INFO  -   Service: INFO_BRT -> market1-brt.example.com:9001
INFO  -   Service: TXN_INFO_PRIV -> market1-txn.example.com:9002
INFO  -   Service: QUERY -> market1-query.example.com:9003
INFO  - Platform/Market ID: 2
INFO  -   Service: INFO_BRT -> market2-brt.example.com:9101
INFO  - Filtering address service response for market ID: 1
INFO  - Found target market 1 in address service response
INFO  - Mapped service INFO_BRT -> SERVICE_INFO_BRT (market1-brt.example.com:9001)
INFO  - Creating connections for service SERVICE_INFO_BRT to market1-brt.example.com:9001
INFO  - Market connections initialized successfully for market ID: 1
```

## Testing

### 1. Verifica Market Filtering

```bash
# Login con market-id=1
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "trader1",
    "password": "password",
    "ipspHost": "ipsp.example.com",
    "ipspPort": 8800
  }'

# Controlla log per verificare:
# - Ricezione di TUTTI i mercati dall'IPSP
# - Filtraggio SOLO market-id=1
# - Connessioni create SOLO per market-id=1
```

### 2. Verifica Errore Market Non Trovato

```bash
# Configura market-id=99 (non esistente)
docker run -e MARKET_ID=99 ...

# Atteso: errore "Market ID 99 not found in IPSP address service response"
```

## Troubleshooting

### Errore: "Market ID X not found"

**Causa**: Il market-id configurato non è presente nella risposta IPSP

**Soluzione**:
1. Verifica che l'utente sia abilitato per quel mercato
2. Controlla i log per vedere quali market-id sono ritornati dall'IPSP
3. Aggiorna la configurazione con un market-id valido

### Errore: "Timeout waiting for address service response"

**Causa**: IPSP non risponde entro 30 secondi

**Soluzione**:
1. Verifica connettività di rete IPSP
2. Controlla firewall e proxy
3. Aumenta il timeout se necessario

### Connessioni non create

**Causa**: Servizi mancanti nella risposta IPSP per il mercato target

**Soluzione**:
1. Verifica i log per vedere quali servizi sono ritornati
2. Controlla configurazione IPSP per quel mercato
3. Verifica che il mercato supporti INFO_BRT, TXN_INFO_PRIV, QUERY

## File Modificati

1. `application.yml` - Aggiunto `market-id`
2. `SDPConfigProperties.java` - Aggiunto campo `marketId`
3. `SDPConnection.java` - Aggiunto `requestAddressService()`, CompletableFuture
4. `SDPConnectionPool.java` - Aggiunto `initializeMarketConnections()`
5. `AuthService.java` - Aggiornato flusso login con filtraggio mercato

## Prossimi Passi

1. ✅ Build e test dell'applicazione
2. ⏳ Test con IPSP reale
3. ⏳ Verifica filtraggio mercati multipli
4. ⏳ Deployment in ambiente di test
5. ⏳ Monitoring e metriche per mercato
