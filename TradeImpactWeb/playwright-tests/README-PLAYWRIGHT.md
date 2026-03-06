# Test Playwright per TradeImpactWeb

Questo documento descrive come eseguire i test Playwright per l'applicazione TradeImpactWeb.

## 📋 Prerequisiti

1. **Node.js 18+** installato
2. **Applicazione in esecuzione** su `http://localhost:8081`
3. **Backend connesso** all'IPSP con la classe BV_BOND disponibile

## 🚀 Installazione

### 1. Installa le dipendenze

```bash
cd /home/OAD/drosso/git/HtmlDriver/TradeImpactWeb
npm install
```

### 2. Installa i browser Playwright

```bash
npx playwright install
```

Questo comando scarica i browser necessari (Chromium, Firefox, WebKit).

## ⚙️ Configurazione

**IMPORTANTE**: Prima di eseguire il test, devi configurare le tue credenziali in:

📄 **`tests/bv-bond-subscription.spec.js`**

Modifica la sezione `TEST_CONFIG`:

```javascript
const TEST_CONFIG = {
  // Credenziali di login
  username: 'your-username',      // ⚠️ MODIFICA QUI
  password: 'your-password',      // ⚠️ MODIFICA QUI
  ipspHost: 'your-ipsp-host',     // ⚠️ MODIFICA QUI (es: 'sdptest.mtsmarkets.com')
  ipspPort: '8800',               // Porta IPSP (default: 8800)
  
  // Configurazione classe
  classToSubscribe: 'BV_BOND',    // Classe da sottoscrivere
  
  // Numero di messaggi da raccogliere
  maxMessagesToCollect: 10,       // Raccogli 10 messaggi e poi termina
};
```

## 🧪 Esecuzione Test

### Modalità Headless (default)

```bash
npm test
```

Esegue il test senza aprire il browser (più veloce).

### Modalità Headed (con browser visibile)

```bash
npm run test:headed
```

Utile per vedere cosa sta succedendo durante il test.

### Modalità Debug

```bash
npm run test:debug
```

Apre il Playwright Inspector per debugging passo-passo.

### Modalità UI (interfaccia grafica)

```bash
npm run test:ui
```

Apre un'interfaccia grafica per eseguire e debuggare i test.

## 📊 Output del Test

Il test stampa a console informazioni dettagliate:

```
🚀 Inizio test BV_BOND Subscription

📡 Configurazione intercettazione WebSocket...
✅ WebSocket connesso: ws://localhost:8081/ws/marketdata

🌐 Navigazione alla pagina di login...
✅ Pagina di login caricata

🔐 Compilazione form di login...
   Username: your-username
   IPSP Host: sdptest.mtsmarkets.com:8800

🚪 Esecuzione login...
✅ Login effettuato con successo!

⏳ Attendo connessione WebSocket...
✅ WebSocket connesso!

🔍 Ricerca classe BV_BOND...
✅ Classe BV_BOND trovata
✅ Classe BV_BOND selezionata

📝 Sottoscrizione a BV_BOND...
✅ Sottoscrizione completata!

📊 Raccolta messaggi WebSocket (max 10)...
   Attendere...

📦 Messaggio #1 ricevuto:
   Classe: BV_BOND (BV_BOND)
   HashKey: ABC123
   Timestamp: 2026-03-05T10:30:45.123Z
   Dati: {
     "field1": "value1",
     "field2": "value2"
   }

...

================================================================================
📈 RIEPILOGO TEST
================================================================================
✅ Messaggi ricevuti: 10
⏱️  Tempo di esecuzione: 15.23s

📋 DETTAGLIO MESSAGGI:
...

🔑 Record unici (per hashKey): 8
📊 Rate: 0.66 messaggi/secondo

================================================================================
✅ Test completato!
================================================================================
```

## 📁 Struttura File

```
TradeImpactWeb/
├── playwright.config.js         # Configurazione Playwright
├── package.json                 # Dipendenze e script npm
├── tests/
│   └── bv-bond-subscription.spec.js  # Test principale
└── README-PLAYWRIGHT.md         # Questa documentazione
```

## 🔧 Personalizzazione

### Modificare il numero di messaggi da raccogliere

Nel file `tests/bv-bond-subscription.spec.js`:

```javascript
maxMessagesToCollect: 20,  // Raccoglie 20 messaggi invece di 10
```

### Modificare i timeout

```javascript
loginTimeout: 15000,       // 15 secondi per login
websocketTimeout: 120000,  // 120 secondi per WebSocket
```

### Testare una classe diversa

```javascript
classToSubscribe: 'ALTRA_CLASSE',  // Cambia la classe
```

## 📸 Screenshot e Video

In caso di errore, Playwright salva automaticamente:
- **Screenshot**: `test-results/*/test-failed-1.png`
- **Video**: `test-results/*/video.webm`

## 📖 Report HTML

Dopo l'esecuzione, visualizza il report dettagliato:

```bash
npm run test:report
```

Apre un report HTML interattivo con:
- Risultati dei test
- Screenshot
- Video
- Trace viewer

## 🐛 Troubleshooting

### "Test timeout of 120000ms exceeded"

L'applicazione non ha inviato messaggi nel tempo specificato. Verifica:
- L'applicazione è in esecuzione su `http://localhost:8081`
- Il backend è connesso all'IPSP
- La classe BV_BOND è disponibile e sta ricevendo dati

### "locator.check: Target closed"

Il browser si è chiuso inaspettatamente. Prova a:
- Eseguire con `--headed` per vedere cosa succede
- Aumentare i timeout
- Verificare che le credenziali siano corrette

### "WebSocket non si connette"

Verifica che:
- L'applicazione backend sia in esecuzione
- Il WebSocket endpoint sia `ws://localhost:8081/ws/marketdata`
- Non ci siano firewall o proxy che bloccano la connessione

## 📚 Risorse

- [Documentazione Playwright](https://playwright.dev)
- [API Reference](https://playwright.dev/docs/api/class-playwright)
- [Best Practices](https://playwright.dev/docs/best-practices)

## 🤝 Contribuire

Per modificare o estendere i test:

1. Crea un nuovo file in `tests/`
2. Importa `@playwright/test`
3. Scrivi il test seguendo la struttura esistente
4. Esegui con `npm test nome-file.spec.js`
