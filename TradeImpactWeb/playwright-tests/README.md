# 🎭 Playwright Tests - TradeImpactWeb

Test automatizzati per l'applicazione TradeImpactWeb usando Playwright.

## 🚀 Quick Start

### Con Docker (consigliato - no npm richiesto) 🐳

```bash
# 1. Configura le credenziali
nano tests/bv-bond-subscription.spec.js  # Modifica TEST_CONFIG

# 2. Build ed esegui
./docker-build-playwright.sh
./docker-run-playwright.sh
```

### Con npm locale

```bash
# 1. Configura le credenziali
nano tests/bv-bond-subscription.spec.js  # Modifica TEST_CONFIG

# 2. Installa ed esegui
npm install
npm test
```

---

## 📚 Documentazione

| Documento | Descrizione |
|-----------|-------------|
| **[DOCKER-PLAYWRIGHT-QUICKSTART.md](DOCKER-PLAYWRIGHT-QUICKSTART.md)** | 🐳 Start veloce con Docker (consigliato) |
| **[DOCKER-PLAYWRIGHT.md](DOCKER-PLAYWRIGHT.md)** | 🐳 Guida Docker completa |
| **[QUICKSTART-PLAYWRIGHT.md](QUICKSTART-PLAYWRIGHT.md)** | ⚡ Start veloce locale (npm) |
| **[README-PLAYWRIGHT.md](README-PLAYWRIGHT.md)** | 📖 Documentazione completa locale |

---

## 📁 Struttura

```
playwright-tests/
├── tests/                              # Test specs
│   ├── bv-bond-subscription.spec.js   # Test principale BV_BOND ⭐
│   └── TEST_CONFIG.example.js         # Esempi configurazione
│
├── Dockerfile.playwright               # Immagine Docker
├── docker-build-playwright.sh          # Build Docker 🐳
├── docker-run-playwright.sh            # Run Docker 🐳
│
├── run-playwright-test.sh              # Run locale (npm)
├── playwright.config.js                # Configurazione Playwright
├── package.json                        # Dipendenze npm
│
└── docs/                               # Documentazione
    ├── DOCKER-PLAYWRIGHT-QUICKSTART.md
    ├── DOCKER-PLAYWRIGHT.md
    ├── QUICKSTART-PLAYWRIGHT.md
    └── README-PLAYWRIGHT.md
```

---

## ⚙️ Configurazione

**IMPORTANTE**: Prima di eseguire i test, configura le credenziali.

Apri **`tests/bv-bond-subscription.spec.js`** e modifica (linee 19-30):

```javascript
const TEST_CONFIG = {
  // ⚠️ MODIFICA QUI ⚠️
  username: 'tuo-username',
  password: 'tua-password',
  ipspHost: 'sdptest.mtsmarkets.com',  // esempio
  ipspPort: '8800',
  
  // Configurazione test
  classToSubscribe: 'BV_BOND',
  maxMessagesToCollect: 10,
};
```

---

## 🎯 Cosa testa

Il test **`bv-bond-subscription.spec.js`** esegue:

1. ✅ **Login** - Compila form con credenziali
2. ✅ **WebSocket** - Verifica connessione WebSocket
3. ✅ **Sottoscrizione** - Sottoscrive la classe BV_BOND
4. ✅ **Raccolta dati** - Intercetta messaggi WebSocket
5. ✅ **Stampa** - Mostra tutti i dati ricevuti
6. ✅ **Statistiche** - Rate, record unici, tempo

---

## 📊 Modalità di esecuzione

### Docker

```bash
./docker-run-playwright.sh           # Headless (default)
./docker-run-playwright.sh headed    # Con browser visibile
./docker-run-playwright.sh bash      # Shell interattiva
```

### npm locale

```bash
npm test                # Headless
npm run test:headed     # Con browser visibile
npm run test:debug      # Debug step-by-step
npm run test:ui         # UI interattiva
npm run test:report     # Visualizza report HTML
```

---

## 📈 Report

Dopo l'esecuzione, i report sono salvati in:

- **`playwright-report/`** - Report HTML interattivo
- **`test-results/`** - Screenshot, video, trace (in caso di errore)

Apri il report:

```bash
# Su Linux
xdg-open playwright-report/index.html

# Oppure con npm
npm run test:report
```

---

## 🐛 Troubleshooting

### Test fallisce subito

→ Verifica che l'app sia in esecuzione su `http://localhost:8081`

```bash
curl http://localhost:8081
```

### Login fallisce

→ Controlla le credenziali in `tests/bv-bond-subscription.spec.js`

### WebSocket non si connette

→ Verifica che il backend sia avviato e connesso all'IPSP

### Docker: "Cannot connect"

→ Se usi Docker, l'app potrebbe non essere raggiungibile. Usa:

```bash
BACKEND_URL=http://host.docker.internal:8081 ./docker-run-playwright.sh
```

---

## 💡 Suggerimenti

### Raccogliere più messaggi

Modifica in `tests/bv-bond-subscription.spec.js`:

```javascript
maxMessagesToCollect: 20,  // Invece di 10
websocketTimeout: 120000,   // 2 minuti invece di 1
```

### Testare altra classe

```javascript
classToSubscribe: 'MTS_BOND',  // Invece di BV_BOND
```

### Vedere il browser durante il test

```bash
# Docker
./docker-run-playwright.sh headed

# npm
npm run test:headed
```

---

## ✅ Prerequisiti

### Docker (consigliato)

- ✅ Docker installato
- ✅ Applicazione TradeImpactWeb in esecuzione

### npm locale

- ✅ Node.js 18+
- ✅ npm
- ✅ Applicazione TradeImpactWeb in esecuzione

---

## 🌟 Vantaggi Docker

Usando Docker hai:

✅ **No installazione npm/Node.js** sul tuo sistema  
✅ **Ambiente isolato** e pulito  
✅ **Riproducibile** ovunque  
✅ **Browser già installati** (Chromium, Firefox, WebKit)  
✅ **Pronto per CI/CD**  

---

## 🔗 Link utili

- [Playwright Documentation](https://playwright.dev)
- [Playwright Docker](https://playwright.dev/docs/docker)
- [Playwright API](https://playwright.dev/docs/api/class-playwright)

---

**🎉 Pronto per testare! Scegli Docker o npm e segui il Quick Start sopra.**
