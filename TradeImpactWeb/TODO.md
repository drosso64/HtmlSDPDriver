# TODO List - TradeImpact Web Gateway

## Critiche (Blockers)

### 1. SDP Protocol JAR Completo
**Status**: ❌ BLOCKING  
**Problema**: Il JAR `sdp-protocol-5.0.0-sources.jar` contiene solo i sorgenti, non i .class compilati.  
**Soluzione Richiesta**:
- Ottenere `sdp-protocol-5.0.0.jar` con le classi compilate, oppure
- Compilare il JAR sources manualmente con `javac`

**Classi Mancanti**:
- `com.mtsmarkets.sdp.ssp.SSPClient`
- `com.mtsmarkets.sdp.sap.SAPClient`  
- `com.mtsmarkets.sdp.smp.SMPMessage`

**File Dipendenti** (commentati temporaneamente):
- [SDPConnection.java](src/main/java/com/mts/gateway/sdp/SDPConnection.java) - riga 3-4
- [SDPConnectionPool.java](src/main/java/com/mts/gateway/sdp/SDPConnectionPool.java) - usa SDPConnection
- [ClassMetadataRepository.java](src/main/java/com/mts/gateway/repository/ClassMetadataRepository.java) - riga 8

### 2. WebSocket Handler Implementation
**Status**: ⏳ TO DO  
**File da Creare**: `src/main/java/com/mts/gateway/websocket/SDPWebSocketHandler.java`

**Responsabilità**:
- Gestire connessioni WebSocket dai client
- Ricevere richieste JSON (subscribe, unsubscribe, transaction, query)
- Mappare richieste a operazioni SDP
- Inviare aggiornamenti real-time ai client

**Schema Messaggi**:
```json
// Client → Server
{
  "type": "subscribe",
  "classId": 12345,
  "username": "user1"
}

// Server → Client  
{
  "type": "data",
  "classId": 12345,
  "action": "ADD",
  "data": { ... }
}
```

## Implementazioni Mancanti

### 3. XDR Codec Completo
**Status**: ⏳ TO DO  
**File**: `GenericSMPSerializer.java` e `GenericSMPDeserializer.java`

**Da Implementare**:
- Encoding XDR per primitive types (int, long, float, double, string)
- Encoding array con padding corretto
- Encoding strutture nested
- Decoding da byte stream XDR

**Riferimento**: RFC 4506 (XDR: External Data Representation Standard)

### 4. Frontend React
**Status**: ⏳ TO DO  
**Directory**: `TradeImpactWeb/frontend/`

**Componenti Necessari**:
- [ ] `LoginPage.jsx` - Autenticazione utente
- [ ] `ClassSubscriptionSelector.jsx` - Lista flat con checkboxes
- [ ] `DynamicGrid.jsx` - Tabella dati con colonne dinamiche
- [ ] `DynamicForm.jsx` - Form input basato su schema
- [ ] `QueryInterface.jsx` - Query builder generico
- [ ] `DatabaseCleanup.jsx` - Menu pulizia dati

**Setup**:
```bash
cd TradeImpactWeb
npx create-react-app frontend
cd frontend
npm install socket.io-client axios
```

### 5. Autenticazione e Autorizzazione
**Status**: ⏳ TO DO

**Da Aggiungere**:
- Spring Security configuration
- JWT token authentication
- User roles and permissions
- HTTPS/WSS per produzione

### 6. Testing
**Status**: ⏳ TO DO

**Test da Scrivere**:
- Unit tests per serializers
- Integration tests per controllers
- End-to-end tests con frontend
- Performance tests per connection pool

## Configurazione Produzione

### 7. Environment Variables
**Da Configurare**:
```bash
export SDP_IPSP_HOST=ipsp.production.com
export SDP_IPSP_PORT=7000
export SDP_IPSP_USERNAME=gateway_prod
export SDP_IPSP_PASSWORD=<secret>
export SDP_MARKET_JAR=/opt/market/sdp-bvf-latest.jar
```

### 8. Docker Setup
**Status**: ⏳ TO DO

Creare:
- [ ] `Dockerfile` per applicazione
- [ ] `docker-compose.yml` con H2 e applicazione
- [ ] Volume mounts per database persistence

### 9. Monitoring e Logging
**Da Aggiungere**:
- Actuator endpoints (health, metrics)
- Prometheus metrics export
- ELK stack integration
- Alert su errori connessione SDP

## Known Issues

1. **SimpleDateFormat non thread-safe**: Usare `ThreadLocal` o `DateTimeFormatter`
2. **Reflection setAccessible warnings**: Aggiungere `--add-opens` JVM args
3. **H2 file locking**: Usare `AUTO_SERVER=TRUE` mode
4. **Connection pool leak**: Implementare finally block ovunque

## Priorità Implementazione

1. ✅ Project structure
2. ✅ Configuration e DTO
3. ✅ ClassLoader service
4. ❌ **SDP Connection (BLOCKED - JAR mancante)**
5. ✅ Introspection e Metadata
6. ✅ Generic Serialization
7. ✅ Database entities e repositories
8. ✅ REST Controllers
9. ⏳ WebSocket Handler
10. ⏳ Frontend React

## Note di Sviluppo

- Tutte le classi usano Lombok per ridurre boilerplate
- Logging configurato con SLF4J + Logback
- Database H2 file-based: `./data/marketdata.mv.db`
- Hot-reload JAR supportato via WatchService

## Contatti

Per domande sull'implementazione:
- Analista: <email>
- Repo: git@github.com:mts/tradeimpact-gateway.git
