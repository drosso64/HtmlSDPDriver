# TradeImpact Web Gateway - Guida Operativa

## 🎯 Per Chi Prende in Carico il Progetto

Questa guida è per sviluppatori che devono **mantenere o modificare** il codice senza assistenza AI.

---

## 🔍 Capire Rapidamente il Sistema

### Domanda: "Da dove arrivano i dati che vedo nel browser?"

```
TradeImpact Server (SDP Protocol)
        ↓
SDPConnection.java (riceve messaggi)
        ↓
SMPMessageSerializer.java (converte a JSON)
        ↓
MarketDataWebSocketHandler.java (broadcast)
        ↓
WebSocket (ws://localhost:8080/ws/marketdata)
        ↓
WebSocketContext.jsx (React Context)
        ↓
ClassTabbedView.jsx (crea tab per classe)
        ↓
DynamicDataGrid.jsx (renderizza tabella)
        ↓
BROWSER (utente finale)
```

### Domanda: "Perché le colonne appaiono in un certo ordine?"

**Risposta:** L'ordine è **preservato** attraverso tutta la catena:

1. **Classe Java** dichiara campi in un ordine (es: `public int InstrumentId; public String InstrumentDesc;`)
2. **SMPMessageSerializer** usa `LinkedHashMap` (non `HashMap`) → mantiene ordine inserimento
3. **Reflection** `getDeclaredFields()` ritorna campi nell'ordine di dichiarazione
4. **JSON** risultante ha campi nello stesso ordine
5. **Frontend** usa `Object.keys(firstRecord)` che in JavaScript (ES2015+) preserva ordine
6. **Colonne tabella** appaiono nello stesso ordine della classe Java

⚠️ **NON USARE HashMap** in SMPMessageSerializer o perderai l'ordine!

### Domanda: "Perché alcuni campi non appaiono nella griglia?"

**Risposta:** Sono **filtrati** perché sono metadati tecnici SDP, non dati business:

Filtrati nel **backend** (SMPMessageSerializer.java):
```java
if (field.getName().equals("Class") ||
    field.getName().equals("ClassName") ||
    field.getName().equals("cLASS_ID") ||
    field.getName().equals("classid") ||
    field.getName().equals("SMPClassId")) {
    continue;  // Salta questi campi
}
```

Filtrati nel **frontend** (DynamicDataGrid.jsx):
```javascript
if (key !== 'cLASS_ID' && 
    key !== 'classid' &&
    key !== 'className' && 
    key !== 'class' &&
    key !== 'sMPClassId') {
    // Mostra questa colonna
}
```

### Domanda: "Perché non vedo duplicati tipo 'InstrumentId' e 'instrumentId'?"

**Risposta:** Il serializer **normalizza** i nomi a camelCase:

```java
// SMPMessageSerializer.java
private static String normalizeFieldName(String fieldName) {
    // "InstrumentId" → "instrumentId" (prima lettera minuscola)
    return Character.toLowerCase(fieldName.charAt(0)) + fieldName.substring(1);
}
```

Quindi:
- Field `InstrumentId` → serializzato come `instrumentId`
- Getter `getInstrumentId()` → estratto come `instrumentId`
- Entrambi mappano allo stesso nome JSON → **nessun duplicato**

---

## 📝 Scenari Comuni di Modifica

### Scenario 1: Aggiungere una nuova classe SDP

**Domanda:** Ho una nuova classe Java `BV_NEW_CLASS` da SDP lib. Devo modificare il codice?

**Risposta:** ❌ **NO**, funziona automaticamente!

1. Backend usa **reflection** → serializza automaticamente qualsiasi classe
2. Frontend costruisce colonne **dai dati** → crea automaticamente colonne per nuovi campi
3. ClassTabbedView crea tab **dinamicamente** → nuovo tab appare automaticamente

**Unica necessità:** Assicurati che la classe SDP sia nel classpath (dependency Maven).

---

### Scenario 2: Escludere un nuovo campo interno

**Domanda:** C'è un campo `mtsInternalId` che non voglio mostrare all'utente.

**Risposta:** ✅ Aggiungi a entrambi i filtri:

**Backend** (SMPMessageSerializer.java riga ~42):
```java
if (field.getName().equals("Class") ||
    field.getName().equals("ClassName") ||
    field.getName().equals("cLASS_ID") ||
    field.getName().equals("classid") ||
    field.getName().equals("SMPClassId") ||
    field.getName().equals("mtsInternalId")) {  // ⬅️ AGGIUNGI QUI
    continue;
}
```

**Frontend** (DynamicDataGrid.jsx riga ~77):
```javascript
if (!key.startsWith('_') && 
    key !== 'cLASS_ID' && 
    key !== 'classid' &&
    key !== 'className' && 
    key !== 'class' &&
    key !== 'sMPClassId' &&
    key !== 'mtsInternalId') {  // ⬅️ AGGIUNGI QUI
    orderedCols.push(key);
}
```

**Stesso filtro** va anche in `RecordDetailModal.jsx` (riga ~38 circa).

---

### Scenario 3: Cambiare ordine colonne

**Domanda:** Voglio che `coupon` appaia prima di `instrumentDesc`.

**Risposta:** ✅ Modifica la **classe Java SDP**:

```java
// PRIMA (ordine originale):
public class BV_BOND {
    public int InstrumentId;
    public String InstrumentDesc;  // ⬅️ Questo prima
    public double Coupon;           // ⬅️ Questo dopo
}

// DOPO (nuovo ordine):
public class BV_BOND {
    public int InstrumentId;
    public double Coupon;           // ⬅️ Sposto prima
    public String InstrumentDesc;  // ⬅️ Sposto dopo
}
```

L'ordine delle colonne nel browser **seguirà automaticamente** l'ordine dei field nella classe.

⚠️ **ATTENZIONE:** Modificare classi SDP può richiedere coordinamento con team TradeImpact.

---

### Scenario 4: Implementare transazioni ADD/RWT/DEL

**Domanda:** I bottoni ADD/RWT/DEL nel modal loggano solo console. Come li implemento?

**Risposta:** ✅ Crea `TransactionController.java`:

```java
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    
    @Autowired
    private SDPConnectionPool sdpPool;
    
    @PostMapping("/add")
    public ResponseEntity<?> addRecord(@RequestBody AddRequest request) {
        try {
            // 1. Ottieni connessione per transazioni
            SDPConnection conn = sdpPool.getConnection(ServiceType.TXN);
            
            // 2. Ricostruisci oggetto SDP da JSON (TODO: implementare deserializer)
            // Object sdpObject = SMPMessageDeserializer.fromJson(request);
            
            // 3. Invia tramite SDP
            // conn.send(sdpObject);
            
            return ResponseEntity.ok("Record added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
    
    // Stesso pattern per /rwt e /del
}
```

**Frontend** (RecordDetailModal.jsx):
```javascript
const handleADD = async () => {
    const response = await fetch('/api/transactions/add', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            classId: record.classId,
            className: record.className,
            data: editedData
        })
    });
    
    if (response.ok) {
        console.log('✅ Record added successfully');
        onClose();
    } else {
        console.error('❌ Error adding record');
    }
};
```

**TODO Critico:** Implementare `SMPMessageDeserializer` (inverso di serializer).

---

### Scenario 5: Risolvere memory leak (allMessages cresce all'infinito)

**Domanda:** Dopo ore di uso, il browser si blocca. Cosa succede?

**Risposta:** ⚠️ **Problema Noto:** `WebSocketContext.allMessages` accumula TUTTI i messaggi.

**Soluzione 1 - Ring Buffer (semplice):**
```javascript
// WebSocketContext.jsx
const MAX_MESSAGES = 10000;  // Ultimi 10K messaggi

setAllMessages(prev => {
    const newMessages = [...prev, newMessage];
    // Taglia array se troppo grande
    if (newMessages.length > MAX_MESSAGES) {
        return newMessages.slice(-MAX_MESSAGES);
    }
    return newMessages;
});
```

**Soluzione 2 - Carica da DB (migliore ma più complessa):**
```javascript
// Invece di accumulare in memoria, carica da DB on-demand
const fetchHistoricalData = async (classId, startTime, endTime) => {
    const response = await fetch(
        `/api/marketdata/history?classId=${classId}&start=${startTime}&end=${endTime}`
    );
    return await response.json();
};
```

---

## 🛠️ Debug Rapido

### "WebSocket non si connette"

1. **Console browser** (F12 → Network → WS):
   - Vedi tentativo connessione a `ws://localhost:8081/ws/marketdata`?
   - Status: 101 Switching Protocols → OK
   - Status: 404 / 500 → problema backend

2. **Backend logs**:
   ```
   grep "WebSocket" logs/spring-boot-application.log
   ```

3. **Verifica URL**:
   - Frontend: `ws://localhost:8081` (porta **Docker mapped**)
   - Backend: interno container usa porta 8080

### "Colonne disordinate"

1. **Verifica LinkedHashMap**:
   ```java
   // SMPMessageSerializer.java riga ~32
   Map<String, Object> result = new LinkedHashMap<>();  // ✅ OK
   // Map<String, Object> result = new HashMap<>();     // ❌ SBAGLIATO
   ```

2. **Verifica reflection**:
   ```java
   for (Field field : clazz.getDeclaredFields()) {
       // Questo preserva ordine dichiarazione
   }
   ```

### "Campo non appare / appare duplicato"

1. **Console browser** (F12):
   ```javascript
   console.log('First record:', flattenedData[0]);
   // Verifica quali chiavi sono presenti nel JSON
   ```

2. **Backend logs**:
   ```java
   // Aggiungi log temporaneo in SMPMessageSerializer
   log.info("Field: {} → JSON key: {}", field.getName(), normalizeFieldName(field.getName()));
   ```

---

## 📚 File Chiave da Conoscere

| File | Cosa Fa | Modifica Quando |
|------|---------|-----------------|
| `SMPMessageSerializer.java` | Converte SDP → JSON | Serve nuovo tipo di serializzazione, escludere campi |
| `SDPConnection.java` | Gestisce connessione SDP | Cambia logica sottoscrizioni, transazioni |
| `WebSocketContext.jsx` | Stato globale messaggi | Cambia strategia storage, gestione connessioni |
| `DynamicDataGrid.jsx` | Rendering tabella | Cambia aspetto/funzionalità grid |
| `ExcelLikeFilter.jsx` | Filtro Excel dropdown | Cambia logica filtri |
| `RecordDetailModal.jsx` | Modal CRUD record | Implementa transazioni ADD/RWT/DEL |

---

## 🚀 Build & Deploy

### Development Locale
```bash
# Backend (Spring Boot)
cd TradeImpactWeb
mvn clean install
mvn spring-boot:run

# Frontend (React - altra shell)
cd TradeImpactWeb/frontend
npm install
npm start
```

### Docker Build
```bash
docker build -t trade-impact-web .
docker run -p 8081:8080 trade-impact-web
```

Accedi a: `http://localhost:8081`

---

## ❓ Domande Frequenti

**Q: Posso usare HashMap invece di LinkedHashMap per performance?**  
A: ❌ NO. Perderesti l'ordine colonne. Performance non è un problema (serializer chiamato ~100 volte/sec max).

**Q: Posso rimuovere la normalizzazione camelCase?**  
A: ⚠️ Rischio duplicati. Se rimuovi, devi anche filtrare getters per evitare `InstrumentId` + `instrumentId`.

**Q: Devo aggiungere codice per ogni nuova classe SDP?**  
A: ❌ NO. Reflection + dynamic columns gestiscono tutto automaticamente.

**Q: Come aggiungo autenticazione reale (non mock)?**  
A: Modifica `AuthController.java` per interrogare LDAP/AD/database invece del mock attuale.

**Q: allMessages crasherà sempre il browser?**  
A: Sì, dopo ~100K messaggi (dipende da RAM browser). Implementa ring buffer o paginazione DB.

---

## 📞 Contatti

- **Repository:** `/home/OAD/drosso/git/HtmlDriver`
- **Documentazione Architettura:** `ARCHITECTURE.md` (dettagli tecnici completi)
- **Questo File:** `MAINTENANCE.md` (guida operativa rapida)

**Ultimo aggiornamento:** Data creazione commenti nel codice

