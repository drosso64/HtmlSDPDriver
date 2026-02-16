# Setup Frontend - Istruzioni Completamento

## Stato Attuale

✅ **Backend**: Completo e funzionante
- 20 file Java implementati
- SDP protocol integration completa
- REST API implementate
- Database H2 configurato
- BUILD SUCCESS

✅ **Frontend**: Struttura completa
- 18 file React creati:
  - `package.json` con tutte le dipendenze
  - `vite.config.js` configurato per build integrata
  - `index.html`, `main.jsx`, `App.jsx`
  - 7 componenti completi (Login, Dashboard, ClassSubscription, DataGrid, TransactionForm, QueryInterface, DatabaseCleanup)
  - 2 services (api.js, websocket.js)
  - CSS per tutti i componenti

❌ **Node.js**: Non installato nel sistema

## Prossimi Passi

### 1. Installare Node.js e npm

**Opzione A: Usando package manager (consigliato)**
```bash
# RedHat/CentOS/Fedora
curl -fsSL https://rpm.nodesource.com/setup_lts.x | sudo bash -
sudo yum install -y nodejs

# Verifica installazione
node --version  # dovrebbe mostrare v18.x o superiore
npm --version   # dovrebbe mostrare v9.x o superiore
```

**Opzione B: Download manuale**
```bash
# Scarica Node.js LTS da https://nodejs.org/
# Estrai e aggiungi al PATH
wget https://nodejs.org/dist/v18.19.0/node-v18.19.0-linux-x64.tar.xz
tar -xf node-v18.19.0-linux-x64.tar.xz
export PATH=$HOME/node-v18.19.0-linux-x64/bin:$PATH
```

### 2. Installare le dipendenze React

```bash
cd /home/OAD/drosso/git/HtmlDriver/TradeImpactWeb/frontend
npm install
```

Questo installerà:
- react@18.2.0
- react-dom@18.2.0
- react-router-dom@6.20.1
- axios@1.6.2
- vite@5.0.8
- @vitejs/plugin-react@4.2.1

### 3. Build del frontend

```bash
cd /home/OAD/drosso/git/HtmlDriver/TradeImpactWeb/frontend
npm run build
```

Questo comando:
- Compila il codice React
- Ottimizza bundle JavaScript e CSS
- **Copia tutto in `src/main/resources/static/`** (configurato in vite.config.js)

### 4. Build finale del progetto Spring Boot

```bash
cd /home/OAD/drosso/git/HtmlDriver/TradeImpactWeb
mvn clean package
```

Questo creerà un JAR eseguibile che include:
- Backend Spring Boot
- Frontend React compilato
- Tutte le dipendenze

### 5. Esecuzione

```bash
cd /home/OAD/drosso/git/HtmlDriver/TradeImpactWeb
java -jar target/TradeImpactWeb-0.0.1-SNAPSHOT.jar
```

L'applicazione sarà disponibile su: **http://localhost:8080**

## Comandi di Sviluppo

### Modalità Development

Durante lo sviluppo, puoi eseguire frontend e backend separatamente con hot-reload:

**Terminal 1 - Backend**
```bash
cd /home/OAD/drosso/git/HtmlDriver/TradeImpactWeb
mvn spring-boot:run
```

**Terminal 2 - Frontend (dev server)**
```bash
cd /home/OAD/drosso/git/HtmlDriver/TradeImpactWeb/frontend
npm run dev
```

Frontend disponibile su: http://localhost:3000
- Hot reload automatico
- Proxy API configurato verso :8080
- WebSocket proxy configurato

### Build di Produzione

```bash
# 1. Build frontend
cd frontend
npm run build

# 2. Build backend (include frontend già buildato)
cd ..
mvn clean package

# 3. Run
java -jar target/TradeImpactWeb-0.0.1-SNAPSHOT.jar
```

## Verifica Setup

### Checklist Pre-Build

- [ ] Node.js installato (`node --version`)
- [ ] npm installato (`npm --version`)
- [ ] Dipendenze frontend installate (`ls frontend/node_modules/`)
- [ ] Frontend buildato (`ls src/main/resources/static/`)
- [ ] Backend compila (`mvn clean compile`)

### Test Build Frontend

```bash
cd frontend
npm run build

# Verifica output
ls -la ../src/main/resources/static/
# Dovresti vedere:
# - index.html
# - assets/ (con file .js e .css)
```

### Test Backend

```bash
mvn clean package

# Verifica JAR creato
ls -lh target/*.jar

# Test esecuzione
java -jar target/TradeImpactWeb-0.0.1-SNAPSHOT.jar
```

## Struttura File Generati

Dopo il build completo:

```
TradeImpactWeb/
├── target/
│   └── TradeImpactWeb-0.0.1-SNAPSHOT.jar  ← JAR finale
├── src/main/resources/static/              ← Frontend compilato
│   ├── index.html
│   └── assets/
│       ├── index-[hash].js                 ← React bundle
│       └── index-[hash].css                ← CSS bundle
└── frontend/
    ├── node_modules/                       ← Dipendenze npm
    └── dist/                                ← Build output (copiato in static/)
```

## Risoluzione Problemi

### npm install fallisce

```bash
# Cancella cache npm
npm cache clean --force

# Riprova installazione
rm -rf node_modules package-lock.json
npm install
```

### Build frontend fallisce

```bash
# Verifica versione Node.js (minimo 18)
node --version

# Se versione vecchia, aggiorna Node.js
```

### Port 8080 già in uso

```bash
# Trova processo
lsof -i :8080

# Cambia porta in application.properties
echo "server.port=8081" >> src/main/resources/application.properties
```

### WebSocket non connette

- Verifica che backend sia running
- Check console browser per errori
- Verifica firewall non blocchi WebSocket

## Next Steps

Dopo l'installazione completa:

1. **Configura connessione SDP** in `application.properties`:
   ```properties
   sdp.host=your-sdp-server
   sdp.port=9999
   sdp.username=user
   sdp.password=pass
   ```

2. **Aggiungi JAR di mercato** in `libs/`:
   ```bash
   cp /path/to/market-classes.jar libs/
   # Aggiorna pom.xml se necessario
   ```

3. **Test completo**:
   - Login: http://localhost:8080/login
   - Dashboard: verifica statistiche
   - Sottoscrizioni: test subscribe/unsubscribe
   - Dati: verifica ricezione real-time
   - Transazioni: test invio
   - Query: test ricerca dati
   - Cleanup: test statistiche database

## Configurazione Opzionale

### Cambio Porta

```properties
# application.properties
server.port=8081
```

```javascript
// frontend/vite.config.js - dev server
export default defineConfig({
  server: {
    port: 3001,
    proxy: {
      '/api': 'http://localhost:8081'  // aggiorna porta backend
    }
  }
})
```

### Retention Database

```properties
# application.properties
data.retention.days=60  # default: 30
```

### Log Level

```properties
# application.properties
logging.level.com.tradeimpact=DEBUG
```

## Supporto

File creati:
- **18 file React** in `frontend/src/`
- **Vite config** per build integrata
- **Package.json** con tutte le dipendenze

Manca solo:
- Installazione Node.js/npm
- `npm install`
- `npm run build`

Dopo questi 3 comandi, l'applicazione sarà completa e pronta all'uso!
