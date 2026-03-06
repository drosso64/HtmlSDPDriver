# 🚀 Playwright Test - Quick Start

Test automatico per sottoscrizione BV_BOND con Playwright.

## ⚡ Avvio Rapido (3 passi)

### 1️⃣ Installa dipendenze

```bash
cd /home/OAD/drosso/git/HtmlDriver/TradeImpactWeb
npm install
npx playwright install
```

### 2️⃣ Configura credenziali

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

### 3️⃣ Esegui il test

```bash
./run-playwright-test.sh
```

**Oppure direttamente:**
```bash
npm test
```

---

## 📊 Output Atteso

```
🚀 Inizio test BV_BOND Subscription

✅ Login effettuato con successo!
✅ WebSocket connesso!
✅ Classe BV_BOND selezionata
✅ Sottoscrizione completata!

📦 Messaggio #1 ricevuto:
   Classe: BV_BOND
   HashKey: ABC123
   Timestamp: 2026-03-05T10:30:45.123Z
   Dati: { ... }

📦 Messaggio #2 ricevuto:
   ...

================================================================================
📈 RIEPILOGO TEST
================================================================================
✅ Messaggi ricevuti: 10
⏱️  Tempo di esecuzione: 15.23s
🔑 Record unici: 8
📊 Rate: 0.66 messaggi/secondo
================================================================================
```

---

## 🎯 Modalità di Esecuzione

| Comando | Descrizione |
|---------|-------------|
| `./run-playwright-test.sh` | Esecuzione normale (headless) |
| `./run-playwright-test.sh headed` | Con browser visibile |
| `./run-playwright-test.sh debug` | Modalità debug step-by-step |
| `./run-playwright-test.sh ui` | UI interattiva |
| `npm run test:report` | Visualizza report HTML |

---

## 🔧 Personalizzazioni Comuni

### Cambiare il numero di messaggi da raccogliere

```javascript
maxMessagesToCollect: 20,  // Invece di 10
```

### Testare una classe diversa

```javascript
classToSubscribe: 'MTS_BOND',  // Invece di BV_BOND
```

### Aumentare il timeout

```javascript
websocketTimeout: 120000,  // 2 minuti invece di 1
```

---

## ⚠️ Prerequisiti

- ✅ Applicazione in esecuzione su `http://localhost:8081`
- ✅ Backend connesso all'IPSP
- ✅ Classe BV_BOND disponibile e con dati
- ✅ Node.js 18+ installato

---

## 🐛 Problemi Comuni

### Test timeout
→ Verifica che l'app sia in esecuzione e che la classe BV_BOND riceva dati

### Login fallito
→ Controlla username, password, ipspHost, ipspPort in TEST_CONFIG

### WebSocket non si connette
→ Verifica che il backend sia avviato e connesso all'IPSP

---

## 📚 Documentazione Completa

Vedi **[README-PLAYWRIGHT.md](README-PLAYWRIGHT.md)** per la documentazione completa.

---

## 📁 File Creati

```
TradeImpactWeb/
├── playwright.config.js              # Configurazione Playwright
├── package.json                      # Dipendenze npm
├── run-playwright-test.sh            # Script runner (consigliato)
├── tests/
│   ├── bv-bond-subscription.spec.js  # Test principale ⭐
│   └── TEST_CONFIG.example.js        # Esempi configurazione
├── README-PLAYWRIGHT.md              # Documentazione completa
└── QUICKSTART-PLAYWRIGHT.md          # Questa guida
```

---

**✨ Pronto! Buon testing!**
