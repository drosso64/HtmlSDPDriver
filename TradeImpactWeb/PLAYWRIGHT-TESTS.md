# 🎭 Playwright Tests

I test Playwright sono stati spostati nella directory dedicata: **`playwright-tests/`**

## 🚀 Quick Start

```bash
cd playwright-tests/

# Opzione 1: Esecuzione con Docker (consigliato, no npm richiesto)
./docker-build-playwright.sh    # Build immagine (prima volta)
./docker-run-playwright.sh       # Esegui test

# Opzione 2: Esecuzione locale (richiede npm)
npm install                      # Installa dipendenze (prima volta)
npm test                         # Esegui test
```

## 📁 Contenuto

```
playwright-tests/
├── tests/                              # Test Playwright
│   ├── bv-bond-subscription.spec.js   # Test principale BV_BOND
│   └── TEST_CONFIG.example.js         # Esempi configurazione
├── Dockerfile.playwright               # Immagine Docker
├── docker-build-playwright.sh          # Build Docker
├── docker-run-playwright.sh            # Run Docker
├── run-playwright-test.sh              # Run locale (npm)
├── playwright.config.js                # Configurazione Playwright
├── package.json                        # Dipendenze npm
├── README-PLAYWRIGHT.md                # Documentazione completa
├── QUICKSTART-PLAYWRIGHT.md            # Guida rapida
├── DOCKER-PLAYWRIGHT.md                # Guida Docker completa
└── DOCKER-PLAYWRIGHT-QUICKSTART.md     # Guida Docker rapida
```

## 📖 Documentazione

- **[DOCKER-PLAYWRIGHT-QUICKSTART.md](playwright-tests/DOCKER-PLAYWRIGHT-QUICKSTART.md)** - Start veloce con Docker
- **[DOCKER-PLAYWRIGHT.md](playwright-tests/DOCKER-PLAYWRIGHT.md)** - Guida Docker completa
- **[QUICKSTART-PLAYWRIGHT.md](playwright-tests/QUICKSTART-PLAYWRIGHT.md)** - Start veloce locale (npm)
- **[README-PLAYWRIGHT.md](playwright-tests/README-PLAYWRIGHT.md)** - Documentazione completa

## 🎯 Cosa testa

Il test automatico:
1. ✅ Login all'applicazione TradeImpactWeb
2. ✅ Connessione WebSocket
3. ✅ Sottoscrizione alla classe BV_BOND
4. ✅ Raccolta e stampa dei messaggi ricevuti
5. ✅ Statistiche (rate, record unici, ecc.)

## ⚙️ Configurazione

Prima di eseguire i test, configura le credenziali in:

**`playwright-tests/tests/bv-bond-subscription.spec.js`** (linee 19-30)

```javascript
const TEST_CONFIG = {
  username: 'tuo-username',      // ⚠️ CAMBIA QUI
  password: 'tua-password',      // ⚠️ CAMBIA QUI
  ipspHost: 'tuo-ipsp-host',     // ⚠️ CAMBIA QUI
  ipspPort: '8800',
  classToSubscribe: 'BV_BOND',
  maxMessagesToCollect: 10,
};
```

---

**Per iniziare, vai su:** [`playwright-tests/`](playwright-tests/)
