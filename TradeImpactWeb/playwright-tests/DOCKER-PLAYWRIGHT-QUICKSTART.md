# 🐳 Playwright Test - Docker Quick Start

Test Playwright in Docker (senza npm sul tuo sistema).

## ⚡ 2 Passi

### 1. Configura credenziali

Modifica **[tests/bv-bond-subscription.spec.js](tests/bv-bond-subscription.spec.js#L19-L30)**:

```javascript
const TEST_CONFIG = {
  username: 'tuo-username',      // ⚠️ CAMBIA
  password: 'tua-password',      // ⚠️ CAMBIA
  ipspHost: 'tuo-ipsp-host',     // ⚠️ CAMBIA
  ipspPort: '8800',
};
```

### 2. Esegui

```bash
# Build (solo la prima volta)
./docker-build-playwright.sh

# Run test
./docker-run-playwright.sh
```

---

## 📋 Comandi

```bash
./docker-run-playwright.sh           # Test headless
./docker-run-playwright.sh headed    # Con browser
./docker-run-playwright.sh bash      # Shell interattiva
```

---

## 📊 Report

Apri dopo l'esecuzione:

```bash
firefox playwright-report/index.html
```

---

## ⚙️ Backend URL

Se l'app non è su `localhost:8081`:

```bash
BACKEND_URL=http://192.168.1.100:8081 ./docker-run-playwright.sh
```

---

## 📚 Documentazione completa

Vedi **[DOCKER-PLAYWRIGHT.md](DOCKER-PLAYWRIGHT.md)**

---

## ✅ Vantaggi

✅ No npm/Node.js sul tuo sistema  
✅ Ambiente isolato e riproducibile  
✅ Tutti i browser già installati  
✅ Pronto per CI/CD  

**🎉 Fatto!**
