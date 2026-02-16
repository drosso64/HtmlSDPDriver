# 🚀 Quick Start - TradeImpact Web

## Setup in 2 Comandi

Il tuo sistema ha **Podman** (compatibile Docker) già installato. Non servono permessi root!

### 1️⃣ Build

```bash
./docker-build.sh
```

Tempo stimato: **3-5 minuti**

Cosa fa:
- ✅ Scarica Node.js e builda frontend React
- ✅ Scarica Maven e builda backend Spring Boot
- ✅ Crea immagine Docker pronta all'uso

### 2️⃣ Run

```bash
docker-compose up -d
```

Oppure:

```bash
make run
```

### 3️⃣ Accedi

Apri browser: **http://localhost:8080**

---

## Comandi Utili

```bash
# Visualizza logs
docker-compose logs -f

# Ferma applicazione
docker-compose down

# Riavvia
docker-compose restart

# Rebuild completo
make rebuild
```

---

## Comandi Make Disponibili

```bash
make build     # Build immagine Docker
make run       # Avvia container
make stop      # Ferma container
make restart   # Riavvia
make logs      # Visualizza logs
make clean     # Pulisci tutto
make rebuild   # Rebuild completo
make shell     # Shell nel container
make test      # Test health endpoint
make backup    # Backup database
```

---

## Configurazione (Opzionale)

### Config SDP Server

```bash
# Crea file .env
cp .env.example .env

# Modifica
nano .env
```

```bash
SDP_HOST=your-server
SDP_PORT=9999
SDP_USERNAME=user
SDP_PASSWORD=pass
```

Poi restart:
```bash
docker-compose restart
```

---

## Struttura Progetto

```
TradeImpactWeb/
├── Dockerfile              # Multi-stage build (Node → Maven → JRE)
├── docker-compose.yml      # Orchestration
├── docker-build.sh         # Script build ✨
├── docker-run.sh           # Script run
├── Makefile               # Comandi rapidi
├── .env.example           # Template configurazione
├── DOCKER.md              # Documentazione completa
├── PODMAN.md              # Info Podman/Docker compatibilità
└── data/                  # Database H2 (auto-creata)
```

---

## Dettagli Build

### Multi-Stage Build

```
Stage 1: frontend-builder (Node 18)
  └─ npm install + npm run build
       ↓
Stage 2: backend-builder (Maven 3.9 + Java 17)
  └─ Copy frontend → resources/static
  └─ mvn package
       ↓
Stage 3: runtime (JRE 17 Alpine)
  └─ Copy JAR + libs
  └─ Immagine finale: ~200MB
```

### Zero Install Locale

✅ **Node.js** - Solo nel container build
✅ **npm** - Solo nel container build
✅ **Maven** - Solo nel container build
✅ **Java** - Solo nel container runtime

**Niente da installare localmente!** 🎉

---

## Persistenza Dati

### Volumi Automatici

```yaml
volumes:
  - ./data:/app/data    # Database H2
  - ./logs:/app/logs    # Log files
```

Directory create automaticamente al primo avvio.

### Backup

```bash
# Backup automatico
make backup

# Backup manuale
tar -czf backup.tar.gz data/
```

---

## Troubleshooting

### Port 8080 occupata

```bash
# Modifica porta in docker-compose.yml
ports:
  - "8081:8080"  # Usa 8081
```

### Permessi volumi (SELinux)

Già configurato! Se problemi:
```bash
# Aggiungi :Z ai volumi in docker-compose.yml
- ./data:/app/data:Z
```

### Build fallisce

```bash
# Pulisci cache e rebuild
make clean
make build
```

### Container non risponde

```bash
# Check logs
docker-compose logs

# Check health
docker ps
```

---

## Architettura Applicazione

```
Browser (http://localhost:8080)
    ↓
┌──────────────────────────┐
│   React Frontend         │
│   - Login                │
│   - Dashboard            │
│   - Subscriptions        │
│   - Real-time DataGrid   │
│   - Transactions         │
│   - Query Interface      │
│   - Database Cleanup     │
└──────────────────────────┘
    ↓ REST API + WebSocket
┌──────────────────────────┐
│   Spring Boot Backend    │
│   - SDP Connection Pool  │
│   - H2 Database          │
│   - Dynamic ClassLoader  │
└──────────────────────────┘
    ↓ SDP Protocol
┌──────────────────────────┐
│   TradeImpact Server     │
└──────────────────────────┘
```

---

## Funzionalità

### 🔐 Authentication
Login con username/password

### 📊 Dashboard
Statistiche real-time, stato connessione

### 📋 Class Subscription
**Flat list con checkboxes** per sottoscrizioni

### 📈 Real-time Data Grid
Tabella dinamica con WebSocket, sort/filter

### 💳 Transactions
Form dinamici per invio transazioni

### 🔍 Query Interface
Builder query con filtri personalizzati

### 🗄️ Database Cleanup
Gestione retention e pulizia manuale

---

## Development Mode

### Backend + Frontend separati (con hot-reload)

```bash
# Terminal 1: Backend in Docker
docker-compose up

# Terminal 2: Frontend locale (richiede Node.js locale)
cd frontend
npm install
npm run dev
```

Frontend dev su :3000, backend su :8080

---

## Production Deployment

### Single JAR

```bash
# Build
docker build -t tradeimpact-web:v1.0.0 .

# Run
docker run -d -p 8080:8080 tradeimpact-web:v1.0.0
```

### Docker Swarm

```bash
docker swarm init
docker stack deploy -c docker-compose.yml tradeimpact
```

### Kubernetes

Vedi [DOCKER.md](DOCKER.md#kubernetes) per deployment manifest completo.

---

## Documentazione Completa

📖 **[DOCKER.md](DOCKER.md)** - Guida Docker completa (build, deploy, monitoring, troubleshooting)

📖 **[PODMAN.md](PODMAN.md)** - Podman specifics e compatibilità Docker

📖 **[README.md](README.md)** - Architettura generale e funzionalità backend

📖 **[SETUP.md](SETUP.md)** - Setup locale (Node.js/npm se disponibile)

---

## Support

### Logs

```bash
# Application logs
docker-compose logs -f tradeimpact-web

# Solo errori
docker-compose logs | grep ERROR

# Ultimi 100 righe
docker-compose logs --tail 100
```

### Shell nel Container

```bash
make shell

# O
docker exec -it tradeimpact-web sh
```

### Health Check

```bash
make test

# O
curl http://localhost:8080/actuator/health
```

---

## Next Steps

Dopo il primo avvio:

1. **Configura SDP server** in `.env`
2. **Aggiungi JAR mercato** in `libs/` (se necessario)
3. **Test sottoscrizioni** via UI
4. **Verifica ricezione dati** real-time
5. **Setup backup automatico** (cron job)

---

## Summary

```bash
# 1. Build immagine (prima volta)
./docker-build.sh

# 2. Avvia applicazione
docker-compose up -d

# 3. Accedi
open http://localhost:8080
```

**That's it!** 🎉

---

## Links Rapidi

- **App**: http://localhost:8080
- **Health**: http://localhost:8080/actuator/health
- **Metrics**: http://localhost:8080/actuator/metrics

---

*Creato per deployment semplice senza dipendenze locali*
