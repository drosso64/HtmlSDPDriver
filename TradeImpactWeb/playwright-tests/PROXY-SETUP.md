# 🔧 Risoluzione Problema Proxy

Hai riscontrato un errore di timeout durante il build Docker. Ecco come risolverlo.

## 🎯 Soluzione Rapida

### Opzione 1: Rilevamento Automatico (Consigliato)

```bash
cd playwright-tests/

# Rileva automaticamente il proxy dal sistema
./detect-proxy.sh

# Se trovato, crea .env.proxy
# Poi riprova il build
./docker-build-playwright.sh
```

### Opzione 2: Configurazione Manuale

```bash
cd playwright-tests/

# Copia il file di esempio
cp .env.proxy.example .env.proxy

# Modifica con le impostazioni del tuo proxy
nano .env.proxy
```

Inserisci i valori del tuo proxy aziendale:

```bash
HTTP_PROXY=http://proxy.tuaazienda.com:8080
HTTPS_PROXY=http://proxy.tuaazienda.com:8080
NO_PROXY=localhost,127.0.0.1
```

Poi riprova:

```bash
./docker-build-playwright.sh
```

---

## 🔍 Come Trovare le Impostazioni Proxy

### Metodo 1: Variabili d'ambiente

```bash
echo $HTTP_PROXY
echo $HTTPS_PROXY
```

### Metodo 2: Configurazione npm (se installato)

```bash
npm config get proxy
npm config get https-proxy
```

### Metodo 3: File di sistema

```bash
cat /etc/environment | grep -i proxy
env | grep -i proxy
```

### Metodo 4: Chiedi all'IT

Contatta il tuo reparto IT e chiedi:
- Indirizzo del proxy HTTP/HTTPS
- Porta del proxy
- Eventuale username/password

---

## 📋 Formato Proxy

### Senza autenticazione:
```
HTTP_PROXY=http://proxy.example.com:8080
```

### Con autenticazione:
```
HTTP_PROXY=http://username:password@proxy.example.com:8080
```

⚠️ **Attenzione**: 
- Se la password contiene caratteri speciali, devono essere URL-encoded
- Esempio: `@` diventa `%40`, `:` diventa `%3A`

---

## ✅ Test della Configurazione

Dopo aver configurato `.env.proxy`, prova il build:

```bash
./docker-build-playwright.sh
```

Dovresti vedere:

```
📡 Caricamento configurazione proxy da .env.proxy
   HTTP_PROXY: http://proxy.example.com:8080
   HTTPS_PROXY: http://proxy.example.com:8080
```

---

## 🐛 Troubleshooting

### "Still getting timeout"

1. **Verifica che il proxy sia corretto:**
   ```bash
   curl --proxy http://proxy.example.com:8080 https://registry.npmjs.org
   ```

2. **Prova con certificati SSL disabilitati** (temporaneo, solo per test):
   ```bash
   # Aggiungi al .env.proxy:
   NODE_TLS_REJECT_UNAUTHORIZED=0
   ```

3. **Aumenta i timeout:**
   Il Dockerfile ora usa timeout più lunghi (5 minuti invece di default)

### "Proxy richiede autenticazione"

Aggiungi username e password all'URL:

```bash
HTTP_PROXY=http://username:password@proxy.example.com:8080
```

### "Caratteri speciali nella password"

Usa URL encoding:

```bash
# Password originale: P@ssw0rd!
# Password encoded: P%40ssw0rd%21
HTTP_PROXY=http://user:P%40ssw0rd%21@proxy.example.com:8080
```

### "Non sono dietro un proxy"

Se sei sicuro di non essere dietro un proxy, il problema potrebbe essere:

1. **Firewall aziendale** - Chiedi all'IT di permettere connessioni a:
   - registry.npmjs.org
   - mcr.microsoft.com

2. **Problemi di rete temporanei** - Riprova più tardi

3. **DNS issues** - Prova con l'IP:
   ```bash
   # Trova l'IP
   nslookup registry.npmjs.org
   
   # Aggiungi a /etc/hosts (con sudo)
   104.16.xx.xx registry.npmjs.org
   ```

---

## 📚 File Creati

- **`.env.proxy.example`** - Template per configurazione proxy
- **`detect-proxy.sh`** - Script per rilevamento automatico
- **Dockerfile.playwright** - Aggiornato con supporto proxy
- **docker-build-playwright.sh** - Aggiornato per usare .env.proxy

---

## 💡 Alternativa: Build Senza Docker

Se il proxy continua a dare problemi con Docker, puoi installare npm localmente:

```bash
# Chiedi all'IT di installare Node.js
# Oppure usa nvm (Node Version Manager) senza sudo:
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
nvm install 18
nvm use 18

# Poi esegui i test localmente
cd playwright-tests/
npm install
npm test
```

---

**Riprova ora con:** `./docker-build-playwright.sh`
