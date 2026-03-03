# TradeImpact Web Gateway

Applicazione web completa (frontend React + backend Spring Boot) per la gestione di messaggi SDP (Session Data Protocol) verso mercati finanziari.

## 🚀 Quick Start

**Deployment Docker** (consigliato - nessuna installazione locale richiesta):
GET  /api/classes/{classId}       # Dettagli classe
GET  /api/classes/{classId}/schema # Schema classe
POST /api/classes/subscribe       # Subscribe multiplo
POST /api/classes/unsubscribe     # Unsubscribe multiplo
POST /api/classes/reload          # Reload CSV class metadata
```bash
# Build immagine (include frontend + backend)
./docker-build.sh

POST   /api/subscriptions                        # Crea subscription
GET    /api/subscriptions/user/{username}        # Lista sottoscrizioni utente
GET    /api/subscriptions/user/{username}/active # Sottoscrizioni attive utente
DELETE /api/subscriptions/{username}/{classId}   # Disiscrivi utente da classe
GET    /api/subscriptions/class/{classId}/data   # Dati recenti classe
DELETE /api/subscriptions/class/{classId}/data   # Pulisce dati classe
POST   /api/subscriptions/cleanup                # Cleanup manuale
GET    /api/subscriptions/database/stats         # Statistiche DB subscriptions
# Accedi: http://localhost:8080
```
- **Spring Boot 3.2.2** - Framework applicativo
- **Java 17** - Runtime
POST /api/transactions            # Esegue transazione standard
POST /api/transactions/monitored  # Esegue transazione monitored
POST /api/transactions/extended   # Esegue transazione extended
```

### Database Management
```
GET    /api/database/stats                    # Statistiche DB aggregate
GET    /api/database/marketdata?classId=...   # Browse dati con paginazione
GET    /api/database/classes                  # Classi disponibili in DB
DELETE /api/database/marketdata/all           # Delete all + unsubscribe all
DELETE /api/database/marketdata/class/{classId} # Delete classe + unsubscribe classe
- **Dynamic ClassLoader**: Carica JAR di classi SMP a runtime senza dipendenze compile-time
- **Reflection-based Introspection**: Analizza strutture delle classi dinamicamente
- **Generic Serialization**: Converte JSON ↔ XDR senza conoscere le classi specifiche
- **Dynamic Schema Generation**: Genera schema DB dalle classi caricate

### Componenti Principali

```
┌─────────────────┐
│  React Frontend │  ← WebSocket (JSON)
└────────┬────────┘
         │
         ↓
┌────────────────────────────────┐
│   Gateway Server (Spring Boot) │
│                                 │
│  ┌──────────────────────────┐  │
│  │ SDPClassLoaderService    │  │  ← Carica JAR dinamicamente
│  └──────────────────────────┘  │
│                                 │
│  ┌──────────────────────────┐  │
│  │ SDPConnectionPool        │  │  ← Gestisce connessioni SDP
│  └──────────────────────────┘  │
│                                 │
│  ┌──────────────────────────┐  │
│  │ GenericSMP Serializer    │  │  ← JSON ↔ XDR conversion
│  └──────────────────────────┘  │
│                                 │
│  ┌──────────────────────────┐  │
│  │ H2 Database              │  │  ← Persistence locale
│  └──────────────────────────┘  │
└────────┬───────────────────────┘
         │
         ↓ SDP Protocol (XDR)
┌────────────────────┐
│ TradeImpact Server │
│ (IPSP / AP)        │
└────────────────────┘
```

## Struttura Progetto

```
TradeImpactWeb/
├── src/main/java/com/mts/gateway/       # Backend Spring Boot
│   ├── GatewayApplication.java          # Main Spring Boot
│   ├── classloader/
│   │   └── SDPClassLoaderService.java   # Dynamic class loading
│   ├── config/
│   │   ├── SDPConfigProperties.java     # Configuration binding
│   │   └── WebSocketConfig.java         # WebSocket setup
│   ├── controller/                      # REST Controllers (20 endpoints)
│   ├── dto/                             # Data Transfer Objects
│   ├── entity/                          # JPA Entities
│   ├── repository/                      # Spring Data JPA
│   ├── sdp/
│   │   ├── SDPConnection.java           # SDP Protocol wrapper
│   │   └── SDPConnectionPool.java       # Connection pool
│   ├── serialization/
│   │   ├── GenericSMPSerializer.java    # SMP → JSON
│   │   └── GenericSMPDeserializer.java  # JSON → SMP
│   └── service/                         # Business logic
│
├── frontend/                            # Frontend React
│   ├── src/
│   │   ├── components/                  # 7 React components
│   │   │   ├── Login.jsx               # Autenticazione
│   │   │   ├── Dashboard.jsx           # Overview statistiche
│   │   │   ├── ClassSubscription.jsx   # Lista flat con checkboxes
│   │   │   ├── DataGrid.jsx            # Tabella real-time
│   │   │   ├── TransactionForm.jsx     # Form transazioni
│   │   │   ├── QueryInterface.jsx      # Query builder
│   │   │   └── DatabaseCleanup.jsx     # Gestione database
│   │   ├── services/
│   │   │   ├── api.js                  # Axios HTTP client
│   │   │   └── websocket.js            # WebSocket client
│   │   ├── App.jsx                     # Router principale
│   │   └── main.jsx                    # Entry point
│   ├── package.json                    # Dipendenze npm
│   └── vite.config.js                  # Build → resources/static
│
├── libs/                                # JAR dependencies SDP
│   ├── sdp-protocol-5.0.0.jar
│   ├── sdp-client-5.0.0.jar
│   └── sdp-sample-5.0.0.jar
│
├── Dockerfile                           # Multi-stage build
├── docker-compose.yml                   # Orchestration
├── Makefile                             # Comandi rapidi
└── pom.xml                              # Maven dependencies
```

## Deployment

### Opzione 1: Docker (Consigliato)

**Nessuna installazione locale richiesta** - Node.js, npm e Maven sono usati solo nei container.

```bash
# Build immagine (multi-stage: Node → Maven → JRE)
./docker-build.sh

# Configura ambiente (opzionale)
cp .env.example .env
nano .env

# Avvia
docker-compose up -d

# Logs
docker-compose logs -f

# Ferma
docker-compose down
```

📖 Documentazione completa: **[DOCKER.md](DOCKER.md)**

### Opzione 2: Build Locale

**Prerequisiti:** Java 17, Maven 3.6+, Node.js 18+

```bash
# 1. Build frontend
cd frontend
npm install
npm run build  # Output → src/main/resources/static/

# 2. Build backend (include frontend)
cd ..
mvn clean package

# 3. Run
java -jar target/TradeImpactWeb-0.0.1-SNAPSHOT.jar
```

📖 Setup locale: **[SETUP.md](SETUP.md)**

### Opzione 3: Development Mode

Backend e frontend separati con hot-reload:

```bash
# Terminal 1: Backend
mvn spring-boot:run

# Terminal 2: Frontend (dev server su :3000)
cd frontend
npm run dev
```

## Funzionalità Frontend

### 🔐 Login & Authentication
- Form login con validazione
- Gestione sessione (session storage)
- Protezione route

### 📊 Dashboard
- Statistiche real-time
- Stato connessione SDP
- Contatori sottoscrizioni
- Messaggi ricevuti

### 📋 Class Subscription
- **Lista flat con checkboxes** (requisito utente)
- Sottoscrizione/disiscrizione real-time
- Indicatore stato attivo
- Descrizione classi

### 📈 Real-time Data Grid
- WebSocket streaming
- Tabella dinamica auto-generated
- Sort & filter
- 1000 record rolling window

### 💳 Transaction Form
- Form dinamico per tipo transazione
- Validazione campi
- Feedback esito

### 🔍 Query Interface
- Query builder con filtri
- Operatori (equals, contains, greater, less)
- Risultati tabulari

### 🗄️ Database Cleanup
- Statistiche database (size, records, oldest)
- Configurazione retention period
- Cleanup manuale on-demand
- Report spazio recuperato

## REST API

### Authentication
```
POST /api/auth/login              # Login
POST /api/auth/logout             # Logout
GET  /api/auth/session            # Verifica sessione
```

### Classes & Metadata
```
GET  /api/classes                 # Lista classi disponibili
GET  /api/classes/{classId}       # Dettagli classe
GET  /api/classes/{classId}/schema # Schema classe
POST /api/classes/subscribe       # Subscribe multiplo
POST /api/classes/unsubscribe     # Unsubscribe multiplo
POST /api/classes/reload          # Reload CSV class metadata

GET  /api/metadata/{classId}
GET  /api/metadata/{classId}/schema
GET  /api/metadata/by-name/{className}
GET  /api/metadata/by-name/{className}/schema
GET  /api/metadata/search?keyword=DEAL
POST /api/metadata/refresh
```

### Subscriptions
```
POST   /api/subscriptions                        # Crea subscription
GET    /api/subscriptions/user/{username}        # Lista sottoscrizioni utente
GET    /api/subscriptions/user/{username}/active # Sottoscrizioni attive utente
DELETE /api/subscriptions/{username}/{classId}   # Disiscrivi utente da classe
GET    /api/subscriptions/class/{classId}/data   # Dati recenti classe
DELETE /api/subscriptions/class/{classId}/data   # Pulisce dati classe
POST   /api/subscriptions/cleanup                # Cleanup manuale
GET    /api/subscriptions/database/stats         # Statistiche DB subscriptions
```

### Transactions
```
POST /api/transactions            # Esegue transazione standard
POST /api/transactions/monitored  # Esegue transazione monitored
POST /api/transactions/extended   # Esegue transazione extended
```

### Database Management
```
GET    /api/database/stats                       # Statistiche DB aggregate
GET    /api/database/marketdata?classId=...      # Browse dati con paginazione
GET    /api/database/classes                     # Classi presenti in DB
DELETE /api/database/marketdata/all              # Delete all + unsubscribe all
DELETE /api/database/marketdata/class/{classId}  # Delete classe + unsubscribe classe
```

## WebSocket

**Endpoint:** `ws://localhost:8080/ws/marketdata`

**Message Types:**
```javascript
// Handshake
{ "type": "connected", "message": "..." }

// Market data update
{ "type": "marketData", "classId": 12345, "className": "BV_...", "hashKey": 123456789, "data": {...}, "timestamp": 1730000000000 }
```

## Configurazione

### application.yml

```yaml
sdp:
  market-classes-jar: /path/to/sdp-bvf-BV14.1_20260128.1-sources.jar
  auto-reload: true
  
  ipsp:
    default-host: ${IPSP_HOST:ipsp.tradeimpact.example.com}
    default-port: ${IPSP_PORT:8800}
    use-ssl: ${IPSP_SSL:true}
    username: gateway_user
    password: ${IPSP_PASSWORD}
  
  connection-pool:
    min-size: 2
    max-size: 10
  
  database:
    retention-days: 30  # Cleanup automatico
```

## Compilazione

```bash
cd TradeImpactWeb
mvn clean package
```

## Esecuzione

```bash
java -jar target/tradeimpact-web-gateway-1.0.0-SNAPSHOT.jar \
  --sdp.ipsp.password=YOUR_PASSWORD
```

## REST API

### Metadata Classi

```
GET  /api/classes                    # Lista tutte le classi disponibili
GET  /api/classes/{classId}          # Dettagli classe
GET  /api/classes/{classId}/schema   # Schema completo con campi
POST /api/classes/reload             # Reload CSV metadata classi

# Endpoint metadata aggiuntivi
GET  /api/metadata/{classId}
GET  /api/metadata/{classId}/schema
GET  /api/metadata/by-name/{className}
GET  /api/metadata/by-name/{className}/schema
GET  /api/metadata/search?keyword=DEAL
POST /api/metadata/refresh
```

### Subscriptions

```
POST /api/subscriptions              # Crea subscription
  Body: { "username": "user1", "classId": 12345 }

GET  /api/subscriptions/user/{username}         # Liste subscriptions utente
GET  /api/subscriptions/{id}                    # Dettagli subscription
GET  /api/subscriptions/{id}/data               # Dati ricevuti
DELETE /api/subscriptions/{id}                  # Elimina subscription
```

### Database

```
GET  /api/subscriptions/database/stats          # Statistiche DB
POST /api/subscriptions/cleanup?retentionDays=7 # Cleanup manuale
```

## Hot-Reload JAR

L'applicazione supporta il ricaricamento dinamico del JAR delle classi di mercato:

1. Modifica `application.yml`:
   ```yaml
   sdp:
     market-classes-jar: /path/to/new-market-classes.jar
     auto-reload: true
   ```

2. Il `WatchService` rileva automaticamente le modifiche al file JAR

3. Le classi vengono ricaricate senza restart dell'applicazione

## Database H2

- **Location**: `./data/marketdata.mv.db` (file-mode, persiste dopo restart)
- **Retention**: 30 giorni default (configurabile)
- **Cleanup**: Automatico + manuale via UI
- **Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:file:./data/marketdata`
  - User: `sa`
  - Password: (vuoto)

### Tabelle

- `subscriptions`: Sottoscrizioni attive
- `market_data`: Dati di mercato ricevuti (JSON format)
- `transactions`: Log transazioni inviate
- `query_history`: Storico query eseguite

### Backup

```bash
# Docker
make backup

# Manuale
tar -czf backup-$(date +%Y%m%d).tar.gz data/
```

## Comandi Rapidi (Makefile)

```bash
make help      # Mostra tutti i comandi disponibili
make build     # Build Docker image
make run       # Avvia container
make stop      # Ferma container
make restart   # Riavvia
make logs      # Visualizza logs in tempo reale
make shell     # Shell nel container
make test      # Test health endpoint
make backup    # Backup database
make clean     # Pulizia completa
make rebuild   # Rebuild da zero
```

## Stato Implementazione

### ✅ Completato

- **Backend Spring Boot** (20 Java files)
  - SDP protocol integration (3 channel types)
  - Connection pooling con MarketFactory
  - REST API controllers (20 endpoints)
  - JPA entities e repositories
  - WebSocket support
  - Generic serialization (reflection-based)
  
- **Frontend React** (18 files)
  - 7 componenti completi con CSS
  - API service layer (Axios)
  - WebSocket service (auto-reconnect)
  - Routing con authentication guards
  - Responsive design
  
- **Docker Deployment**
  - Multi-stage Dockerfile
  - docker-compose.yml
  - Podman compatible
  - Makefile con comandi rapidi
  - Health checks
  - Volume persistence

### 🔧 Da Completare

- Unit tests (backend)
- E2E tests (frontend)
- Autenticazione avanzata (OAuth2/JWT)
- HTTPS/WSS in produzione
- Rate limiting API
- Metriche Prometheus
- Grafana dashboards

## Documentazione

- **[QUICKSTART.md](QUICKSTART.md)** - ⭐ Guida rapida in 2 comandi
- **[DOCKER.md](DOCKER.md)** - Documentazione Docker completa
- **[PODMAN.md](PODMAN.md)** - Info compatibilità Podman
- **[SETUP.md](SETUP.md)** - Setup locale (se Node.js disponibile)
- **[README.md](README.md)** - Questo file (overview generale)

## Troubleshooting

### Container non si avvia
```bash
docker-compose logs
docker inspect tradeimpact-web
```

### Porta 8080 occupata
```bash
# Cambia porta in docker-compose.yml
ports:
  - "8081:8080"
```

### Database locked
```bash
docker-compose down
rm data/marketdata.lock.db
docker-compose up -d
```

### Frontend non compila (build locale)
```bash
cd frontend
rm -rf node_modules package-lock.json
npm install
npm run build
```

## Sicurezza

⚠️ **Nota**: Questa è una versione di sviluppo. Per produzione:

- Configurare autenticazione robusta (Spring Security + JWT)
- Abilitare HTTPS/WSS
- Proteggere H2 console (disabilitare in prod)
- Cifrare credenziali SDP (vault o secrets manager)
- Rate limiting sulle API
- CORS policy restrittiva
- Input validation completa
- Audit logging

## Supporto

- **Issues**: Apri issue su GitLab/GitHub
- **Logs**: `docker-compose logs -f`
- **Shell debug**: `docker exec -it tradeimpact-web sh`
- **Health check**: `curl http://localhost:8080/actuator/health`

## Licenza

Proprietario - MTS Markets
