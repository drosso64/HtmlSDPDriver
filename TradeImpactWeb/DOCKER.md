# TradeImpact Web - Docker Deployment

## Prerequisiti

**Solo Docker richiesto** - niente Node.js, npm, Maven o Java da installare localmente!

```bash
# Verifica Docker installato
docker --version

# Se non installato:
# https://docs.docker.com/engine/install/
```

## Quick Start

### 1. Build Immagine Docker

```bash
# Usa script automatico
./docker-build.sh

# Oppure manualmente
docker build -t tradeimpact-web:latest .
```

Questo comando:
- Scarica Node.js 18 e builda il frontend React
- Scarica Maven 3.9 e builda il backend Spring Boot  
- Crea immagine finale leggera con solo JRE 17
- **Tempo stimato**: 3-5 minuti (prima volta)

### 2. Configura Ambiente (opzionale)

```bash
# Copia file di esempio
cp .env.example .env

# Modifica configurazione
nano .env
```

```properties
# .env
SDP_HOST=your-sdp-server
SDP_PORT=9999
SDP_USERNAME=user
SDP_PASSWORD=pass
DATA_RETENTION_DAYS=30
```

### 3. Avvia Applicazione

**Opzione A: Script automatico**
```bash
./docker-run.sh
```

**Opzione B: Docker Compose (consigliato)**
```bash
# Avvia in background
docker-compose up -d

# Visualizza logs
docker-compose logs -f

# Ferma
docker-compose down
```

**Opzione C: Docker run manuale**
```bash
docker run -d \
  --name tradeimpact-web \
  -p 8080:8080 \
  -v $(pwd)/data:/app/data \
  -e SDP_HOST=localhost \
  -e SDP_PORT=9999 \
  tradeimpact-web:latest
```

### 4. Accedi all'Applicazione

Apri browser: **http://localhost:8080**

Login di default:
- Username: `admin`
- Password: `admin`

## Architettura Docker

### Multi-Stage Build

```
┌─────────────────────────────────┐
│ Stage 1: frontend-builder       │
│ FROM node:18-alpine             │
│ - npm install                   │
│ - npm run build                 │
│ → Produce: dist/ (React bundle) │
└─────────────────────────────────┘
              ↓
┌─────────────────────────────────┐
│ Stage 2: backend-builder        │
│ FROM maven:3.9-eclipse-temurin  │
│ - Copy dist/ → resources/static │
│ - mvn package                   │
│ → Produce: app.jar              │
└─────────────────────────────────┘
              ↓
┌─────────────────────────────────┐
│ Stage 3: runtime                │
│ FROM eclipse-temurin:17-jre     │
│ - Copy app.jar                  │
│ - Expose 8080                   │
│ → Immagine finale: ~200MB       │
└─────────────────────────────────┘
```

### Vantaggi

✅ **Zero dipendenze locali** - Node.js e Maven solo nel container
✅ **Build reproducibili** - stesse versioni sempre
✅ **Immagine leggera** - solo JRE runtime (~200MB)
✅ **Sicuro** - user non-root nel container
✅ **Portable** - funziona su qualsiasi sistema con Docker

## Gestione Container

### Comandi Base

```bash
# Visualizza container attivi
docker ps

# Visualizza tutti i container
docker ps -a

# Logs in tempo reale
docker logs -f tradeimpact-web

# Statistiche risorse
docker stats tradeimpact-web

# Shell nel container
docker exec -it tradeimpact-web sh

# Ferma container
docker stop tradeimpact-web

# Riavvia container
docker restart tradeimpact-web

# Rimuovi container
docker rm tradeimpact-web
```

### Con Docker Compose

```bash
# Avvia (detached)
docker-compose up -d

# Avvia (foreground con logs)
docker-compose up

# Ferma
docker-compose down

# Ferma e rimuovi volumi
docker-compose down -v

# Rebuild e restart
docker-compose up -d --build

# Logs
docker-compose logs -f

# Scala servizi
docker-compose up -d --scale tradeimpact-web=3
```

## Persistenza Dati

### Volumi Docker

```yaml
# docker-compose.yml
volumes:
  - ./data:/app/data      # Database H2
  - ./logs:/app/logs      # Log files
```

**Directory create automaticamente:**
- `./data/` - Database H2 (marketdata.mv.db)
- `./logs/` - Log applicazione

**Backup database:**
```bash
# Ferma container
docker-compose down

# Backup
tar -czf backup-$(date +%Y%m%d).tar.gz data/

# Riavvia
docker-compose up -d
```

**Restore:**
```bash
docker-compose down
rm -rf data/
tar -xzf backup-YYYYMMDD.tar.gz
docker-compose up -d
```

## Configurazione

### Variabili Ambiente

| Variable | Default | Descrizione |
|----------|---------|-------------|
| `SERVER_PORT` | `8080` | Porta applicazione |
| `SDP_HOST` | `localhost` | Hostname SDP server |
| `SDP_PORT` | `9999` | Porta SDP server |
| `SDP_USERNAME` | `user` | Username SDP |
| `SDP_PASSWORD` | `pass` | Password SDP |
| `DATA_RETENTION_DAYS` | `30` | Retention giorni |
| `JAVA_OPTS` | `-Xmx512m -Xms256m` | JVM options |
| `LOG_LEVEL` | `INFO` | Log level |

### Override Configurazione

**Metodo 1: File .env**
```bash
echo "SDP_HOST=production-server" > .env
docker-compose up -d
```

**Metodo 2: Variabili inline**
```bash
SDP_HOST=prod docker-compose up -d
```

**Metodo 3: docker-compose.override.yml**
```yaml
# docker-compose.override.yml
version: '3.8'
services:
  tradeimpact-web:
    environment:
      - SDP_HOST=production-server
      - JAVA_OPTS=-Xmx2g -Xms1g
```

## Sviluppo

### Build e Test Rapido

```bash
# Build immagine
docker build -t tradeimpact-web:dev .

# Run con logs
docker run --rm \
  -p 8080:8080 \
  --name tradeimpact-dev \
  tradeimpact-web:dev

# In altro terminal, test
curl http://localhost:8080/actuator/health
```

### Debug Mode

```bash
# Abilita remote debugging
docker run -d \
  -p 8080:8080 \
  -p 5005:5005 \
  -e JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" \
  tradeimpact-web:latest

# Connetti debugger IDE a localhost:5005
```

### Hot Reload Frontend

Per sviluppo frontend con hot-reload, usa setup locale:

```bash
# Terminal 1: Backend in Docker
docker run -d -p 8080:8080 tradeimpact-web:latest

# Terminal 2: Frontend locale (richiede Node.js)
cd frontend
npm install
npm run dev
# Frontend su :3000, proxy API a :8080
```

## Production Deployment

### Docker Swarm

```bash
# Init swarm
docker swarm init

# Deploy stack
docker stack deploy -c docker-compose.yml tradeimpact

# Scale
docker service scale tradeimpact_tradeimpact-web=3

# Update
docker service update --image tradeimpact-web:v2 tradeimpact_tradeimpact-web
```

### Kubernetes

```yaml
# deployment.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: tradeimpact-web
spec:
  replicas: 2
  selector:
    matchLabels:
      app: tradeimpact-web
  template:
    metadata:
      labels:
        app: tradeimpact-web
    spec:
      containers:
      - name: tradeimpact-web
        image: tradeimpact-web:latest
        ports:
        - containerPort: 8080
        env:
        - name: SDP_HOST
          valueFrom:
            configMapKeyRef:
              name: tradeimpact-config
              key: sdp.host
        volumeMounts:
        - name: data
          mountPath: /app/data
      volumes:
      - name: data
        persistentVolumeClaim:
          claimName: tradeimpact-data-pvc
---
apiVersion: v1
kind: Service
metadata:
  name: tradeimpact-web
spec:
  type: LoadBalancer
  ports:
  - port: 80
    targetPort: 8080
  selector:
    app: tradeimpact-web
```

### Registry Privato

```bash
# Tag immagine
docker tag tradeimpact-web:latest registry.company.com/tradeimpact-web:1.0.0

# Login
docker login registry.company.com

# Push
docker push registry.company.com/tradeimpact-web:1.0.0

# Pull e run su altro server
docker pull registry.company.com/tradeimpact-web:1.0.0
docker run -d -p 8080:8080 registry.company.com/tradeimpact-web:1.0.0
```

## Monitoring

### Health Check

```bash
# Container health
docker inspect --format='{{.State.Health.Status}}' tradeimpact-web

# Application health
curl http://localhost:8080/actuator/health

# Metrics
curl http://localhost:8080/actuator/metrics
```

### Logs

```bash
# Tail logs
docker logs -f --tail 100 tradeimpact-web

# Grep logs
docker logs tradeimpact-web 2>&1 | grep ERROR

# Export logs
docker logs tradeimpact-web > app.log
```

### Prometheus + Grafana

```yaml
# docker-compose.monitoring.yml
version: '3.8'
services:
  tradeimpact-web:
    # ... configurazione esistente ...
  
  prometheus:
    image: prom/prometheus
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml
    ports:
      - "9090:9090"
  
  grafana:
    image: grafana/grafana
    ports:
      - "3000:3000"
    environment:
      - GF_SECURITY_ADMIN_PASSWORD=admin
```

## Troubleshooting

### Container non si avvia

```bash
# Check logs
docker logs tradeimpact-web

# Check eventi
docker events

# Inspect container
docker inspect tradeimpact-web
```

### Porta già in uso

```bash
# Trova processo su porta 8080
sudo lsof -i :8080

# Usa porta diversa
docker run -p 8081:8080 tradeimpact-web:latest
```

### Database corrotto

```bash
# Stop container
docker-compose down

# Backup e rimuovi DB
mv data/marketdata.mv.db data/marketdata.mv.db.bak
rm -f data/marketdata.trace.db

# Restart (crea nuovo DB)
docker-compose up -d
```

### Out of Memory

```bash
# Aumenta memoria Java
docker run -e JAVA_OPTS="-Xmx2g -Xms1g" tradeimpact-web:latest

# Oppure in docker-compose.yml
environment:
  - JAVA_OPTS=-Xmx2g -Xms1g
```

### Rebuild Cache Pulita

```bash
# Rebuild senza cache
docker build --no-cache -t tradeimpact-web:latest .

# Pulisci build cache
docker builder prune
```

## Dimensioni Immagine

```bash
# Verifica dimensione
docker images tradeimpact-web

# Output tipico:
# REPOSITORY          TAG       SIZE
# tradeimpact-web     latest    ~200MB
```

**Layer breakdown:**
- Base JRE 17 Alpine: ~170MB
- Application JAR: ~20MB
- Dependencies: ~10MB

## Best Practices

✅ **Multi-stage build** - Minimizza dimensione finale
✅ **Non-root user** - Sicurezza container
✅ **Health checks** - Monitoring automatico
✅ **.dockerignore** - Build più veloce
✅ **Volume mounts** - Persistenza dati
✅ **Environment variables** - Configurazione flessibile
✅ **Versioning** - Tag semantico (v1.0.0, v1.1.0)
✅ **Logging** - STDOUT/STDERR per aggregazione

## Riferimenti

- [Dockerfile](Dockerfile) - Multi-stage build definition
- [docker-compose.yml](docker-compose.yml) - Orchestration setup
- [.env.example](.env.example) - Environment template
- [docker-build.sh](docker-build.sh) - Build script
- [docker-run.sh](docker-run.sh) - Run script
