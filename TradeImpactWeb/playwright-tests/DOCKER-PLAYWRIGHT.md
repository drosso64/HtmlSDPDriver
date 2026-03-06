# 🐳 Docker Playwright - Guida Completa

Esegui i test Playwright in un container Docker senza installare npm/Node.js sul tuo sistema.

## 🚀 Quick Start (2 passi)

### 1️⃣ Configura le credenziali

Modifica **`tests/bv-bond-subscription.spec.js`** (linee 19-30):

```javascript
const TEST_CONFIG = {
  username: 'tuo-username',           // ⚠️ CAMBIA QUI
  password: 'tua-password',           // ⚠️ CAMBIA QUI
  ipspHost: 'sdptest.mtsmarkets.com', // ⚠️ CAMBIA QUI
  ipspPort: '8800',
  classToSubscribe: 'BV_BOND',
  maxMessagesToCollect: 10,
};
```

### 2️⃣ Build ed esegui

```bash
# Build dell'immagine (solo la prima volta)
./docker-build-playwright.sh

# Esegui i test
./docker-run-playwright.sh
```

**Fatto!** 🎉

---

## 📋 Comandi Disponibili

### Build dell'immagine

```bash
# Build con tag 'latest' (default)
./docker-build-playwright.sh

# Build con tag personalizzato
./docker-build-playwright.sh v1.0.0
```

### Esecuzione test

```bash
# Headless (senza browser visibile) - default
./docker-run-playwright.sh

# Con browser visibile
./docker-run-playwright.sh headed

# Shell interattiva nel container
./docker-run-playwright.sh bash
```

### Comandi diretti Docker

```bash
# Build manuale
docker build -f Dockerfile.playwright -t tradeimpact-playwright:latest .

# Run manuale
docker run --rm --network host \
  -v "$(pwd)/tests:/tests/tests:ro" \
  -v "$(pwd)/playwright-report:/tests/playwright-report" \
  -v "$(pwd)/test-results:/tests/test-results" \
  tradeimpact-playwright:latest

# Shell interattiva
docker run --rm -it --network host \
  -v "$(pwd)/tests:/tests/tests:ro" \
  tradeimpact-playwright:latest /bin/bash
```

---

## 🏗️ Architettura

### Dockerfile.playwright

Basato su **`mcr.microsoft.com/playwright:v1.40.0-jammy`**:
- ✅ Ubuntu 22.04 LTS (Jammy)
- ✅ Node.js 18+ preinstallato
- ✅ Playwright e browser (Chromium, Firefox, WebKit)
- ✅ Tutte le dipendenze di sistema

### Volume Mounts

```
Host                          Container
─────────────────────────────────────────────────────────
./tests                  →    /tests/tests (read-only)
./playwright-report      →    /tests/playwright-report
./test-results           →    /tests/test-results
```

- **tests/**: I tuoi test (read-only, non modificabili dal container)
- **playwright-report/**: Report HTML generato
- **test-results/**: Screenshot, video, trace in caso di errore

### Network

Il container usa **`--network host`** per accedere all'applicazione su `localhost:8081`.

Se l'app è esposta su un'altra porta o host, imposta la variabile:

```bash
BACKEND_URL=http://192.168.1.100:8080 ./docker-run-playwright.sh
```

---

## 📊 Output e Report

### Console Output

Durante l'esecuzione vedrai:

```
🚀 Inizio test BV_BOND Subscription

✅ Login effettuato con successo!
✅ WebSocket connesso!
📦 Messaggio #1 ricevuto:
   Classe: BV_BOND
   HashKey: ABC123
   ...

================================================================================
📈 RIEPILOGO TEST
================================================================================
✅ Messaggi ricevuti: 10
⏱️  Tempo di esecuzione: 15.23s
================================================================================
```

### Report HTML

Dopo l'esecuzione, apri il report:

```bash
# Su Linux/macOS
xdg-open playwright-report/index.html

# Su Windows WSL
explorer.exe playwright-report/index.html

# Oppure apri direttamente nel browser
firefox playwright-report/index.html
```

Il report include:
- ✅ Risultati dei test (pass/fail)
- 📸 Screenshot in caso di errore
- 🎥 Video della sessione
- 🔍 Trace interattivo per debug

---

## 🔧 Troubleshooting

### "Cannot connect to http://localhost:8081"

L'applicazione deve essere in esecuzione e raggiungibile dal container.

**Soluzioni:**

1. Verifica che l'app sia in esecuzione:
   ```bash
   curl http://localhost:8081
   ```

2. Se usi Docker Desktop su Windows/Mac, l'app potrebbe non essere raggiungibile via `localhost`. Usa:
   ```bash
   BACKEND_URL=http://host.docker.internal:8081 ./docker-run-playwright.sh
   ```

3. Se l'app è su un altro host:
   ```bash
   BACKEND_URL=http://192.168.1.100:8081 ./docker-run-playwright.sh
   ```

### "Image not found"

L'immagine non è stata ancora creata. Esegui:

```bash
./docker-build-playwright.sh
```

### Permessi su report/risultati

I file creati dal container potrebbero avere permessi diversi. Per aggiustarli:

```bash
sudo chown -R $(whoami):$(whoami) playwright-report test-results
```

### Test timeout

Aumenta i timeout nel file di test:

```javascript
websocketTimeout: 120000,  // 2 minuti invece di 1
```

---

## 🎯 Esempi d'uso

### Test rapido

```bash
# Build + run in un comando
./docker-build-playwright.sh && ./docker-run-playwright.sh
```

### Debug interattivo

```bash
# Entra nella shell del container
./docker-run-playwright.sh bash

# Poi dentro il container:
npm test                    # Esegui i test
npm run test:headed         # Con browser visibile
ls -la tests/               # Ispeziona i file
```

### Test automatizzato in CI/CD

```bash
#!/bin/bash
set -e

# Build
./docker-build-playwright.sh

# Run
./docker-run-playwright.sh

# Pubblica report
cp -r playwright-report /var/www/html/test-reports/
```

### Rebuild completo

```bash
# Rimuovi l'immagine esistente
docker rmi tradeimpact-playwright:latest

# Rebuild da zero (senza cache)
docker build --no-cache -f Dockerfile.playwright -t tradeimpact-playwright:latest .
```

---

## 📁 File creati

```
TradeImpactWeb/
├── Dockerfile.playwright          # Dockerfile per l'immagine
├── docker-build-playwright.sh     # Script per build
├── docker-run-playwright.sh       # Script per esecuzione ⭐
├── DOCKER-PLAYWRIGHT.md           # Questa documentazione
├── tests/
│   └── bv-bond-subscription.spec.js
├── playwright-report/             # Report HTML (generato)
└── test-results/                  # Screenshot/video (generato)
```

---

## ⚙️ Variabili d'ambiente

| Variabile | Default | Descrizione |
|-----------|---------|-------------|
| `BACKEND_URL` | `http://host.docker.internal:8081` | URL dell'applicazione |
| `IMAGE_TAG` | `latest` | Tag dell'immagine Docker |

**Esempio:**

```bash
BACKEND_URL=http://192.168.1.100:8080 \
IMAGE_TAG=v1.0.0 \
./docker-run-playwright.sh
```

---

## 🔄 Update Playwright

Per aggiornare Playwright a una versione più recente:

1. Modifica `Dockerfile.playwright`:
   ```dockerfile
   FROM mcr.microsoft.com/playwright:v1.41.0-jammy  # Nuova versione
   ```

2. Modifica `package.json`:
   ```json
   "@playwright/test": "^1.41.0"
   ```

3. Rebuild l'immagine:
   ```bash
   docker rmi tradeimpact-playwright:latest
   ./docker-build-playwright.sh
   ```

---

## 📚 Risorse

- [Playwright Docker Documentation](https://playwright.dev/docs/docker)
- [Playwright Test Documentation](https://playwright.dev/docs/intro)
- [Microsoft Playwright Images](https://mcr.microsoft.com/en-us/product/playwright/about)

---

## ✅ Vantaggi Docker

✅ **No installazione Node.js** - Tutto dentro il container  
✅ **Ambiente isolato** - Non sporca il sistema host  
✅ **Riproducibile** - Stesso ambiente ovunque  
✅ **Portabile** - Funziona su Linux, Windows, macOS  
✅ **CI/CD ready** - Pronto per automazione  

---

**🎉 Buon testing!**
