# Test Modulare (API-only)

Questo file spiega come eseguire il nuovo test modulare che usa gli helper `login`, `subscribe`, `logout`.

File aggiunti:

- `tests/helpers/apiHelpers.js` — funzioni: `login(user,password,ip,port)`, `logout(user)`, `subscribe(classIds)`, `unsubscribe(classIds)`, `getToken()`
- `tests/bv-bond-subscription-modular.spec.js` — test che utilizza gli helper sopra

Variabili d'ambiente utili:

- `BASE_URL` — URL del backend (default: `http://localhost:8081`)
- `TEST_USERNAME` — username usato per il login
- `TEST_PASSWORD` — password usata per il login
- `TEST_IPSP_HOST` — host IPSP
- `TEST_IPSP_PORT` — porta IPSP
- `TEST_CLASS_ID` — ID numerico della classe da sottoscrivere (es. `400059`)
- `TEST_MAX_MESSAGES` — numero massimo di messaggi da raccogliere

Esempio: esecuzione locale (npm)

```bash
cd playwright-tests
npm install
# Esempio set env e run
BASE_URL=http://localhost:8081 TEST_USERNAME=TRADER@35240 TEST_PASSWORD=TEQTEQ123 TEST_IPSP_HOST=10.232.92.86 TEST_IPSP_PORT=12001 TEST_CLASS_ID=400059 npx playwright test tests/bv-bond-subscription-modular.spec.js
```

Esempio: esecuzione con Docker (consigliato)

```bash
# (opzionale) export delle variabili d'ambiente nel tuo shell
export BASE_URL=http://host.docker.internal:8081
export TEST_USERNAME=TRADER@35240
export TEST_PASSWORD=TEQTEQ123
export TEST_IPSP_HOST=10.232.92.86
export TEST_IPSP_PORT=12001
export TEST_CLASS_ID=400059

# Run dentro lo script helper (vedi docker-run-playwright.sh)
./docker-run-playwright.sh api
```

Nota: lo script `docker-run-playwright.sh` monta la cartella `tests/` così non serve ricostruire l'immagine per modifiche ai file JS.
