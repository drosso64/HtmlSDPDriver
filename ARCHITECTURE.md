# TradeImpact Web Gateway - Architettura e Flusso Dati

## Panoramica

Applicazione web per la visualizzazione e gestione di dati di mercato in tempo reale tramite protocollo SDP (Simple Data Protocol).

**Stato attuale (marzo 2026):**
- I dati visualizzati nelle griglie sono mantenuti in memoria lato backend e frontend. Le griglie NON leggono direttamente dal database H2, ma dal contesto WebSocket/in-memory.
- Tutte le modifiche recenti (gestione enum, null/default, UX WebSocket, JSON modal, persistenza tab) sono implementate e documentate sotto.
- Le funzioni di inserimento/modifica/cancellazione record (ADD/RWT/DEL) sono realmente implementate tramite TransactionController e collegate al frontend: il frontend invia richieste REST al backend che esegue la transazione secondo protocollo SDP.

**Stack Tecnologico:**
- Backend: Spring Boot 3.3 + Java 17
- Frontend: React 18 + TanStack Table v8
- Database: H2 (in-memory)
- Comunicazione real-time: WebSocket
- Build: Maven + Docker multi-stage

---

## Architettura a Livelli

```
┌─────────────────────────────────────────────────────────┐
│                    BROWSER (React)                       │
│  ┌────────────────┐  ┌──────────────┐  ┌──────────────┐│
│  │ ClassTabbedView│  │DynamicDataGrid│  │RecordDetail  ││
│  │  (Sottoscrizioni│  │  (Visualiz.)  │  │Modal (Edit)  ││
│  └────────────────┘  └──────────────┘  └──────────────┘│
│            ↕ WebSocket Context (Stato Globale)          │
└─────────────────────────────────────────────────────────┘
                            ↕ WebSocket
┌─────────────────────────────────────────────────────────┐
│                 SPRING BOOT BACKEND                      │
│  ┌─────────────────────────────────────────────────┐   │
│  │  MarketDataWebSocketHandler                      │   │
│  │  (Broadcast messaggi ai client connessi)        │   │
│  └─────────────────────────────────────────────────┘   │
│                            ↕                             │
│  ┌─────────────────────────────────────────────────┐   │
│  │  SDPConnection (Connessione SDP persistente)    │   │
│  │  - Riceve messaggi market data                   │   │
│  │  - Serializza a JSON (SMPMessageSerializer)      │   │
│  │  - Salva su DB H2 (MarketDataService)           │   │
│  └─────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────┘
                            ↕ SDP Protocol
┌─────────────────────────────────────────────────────────┐
│         TradeImpact IPSP / Access Points                 │
│         (Fornisce dati di mercato real-time)             │
└─────────────────────────────────────────────────────────┘
```

---

## Flusso Dati Dettagliato

### 1. Autenticazione e Inizializzazione

**Lato Backend:**
1. Utente invia username/password a `/api/auth/login`
2. `AuthController` valida credenziali (attualmente mock)
3. Ritorna JWT token e informazioni utente

**Lato Frontend:**
1. `Login.jsx` raccoglie credenziali
2. `App.jsx` gestisce stato autenticazione
3. Token salvato in `localStorage` (condiviso tra tab browser)
4. Header visualizzato solo per utenti autenticati

### 2. Connessione WebSocket

**Inizializzazione (Frontend):**
```javascript
// WebSocketContext.jsx
useEffect(() => {
  const wsUrl = 'ws://localhost:8080/ws/market-data';
  const socket = new WebSocket(wsUrl);
  
  socket.onopen = () => {
    // Invia autenticazione
    socket.send(JSON.stringify({ 
      type: 'AUTH', 
      token: localStorage.getItem('token') 
    }));
  };
  
  socket.onmessage = (event) => {
    const message = JSON.parse(event.data);
    // Aggiunge a allMessages array
    setAllMessages(prev => [...prev, message]);
  };
}, []);
```

**Gestione (Backend):**
```java
// MarketDataWebSocketHandler.java
public void broadcastMarketData(String jsonData) {
    // Itera su tutte le sessioni WebSocket attive
    // Invia messaggio JSON a tutti i client connessi
    sessions.forEach(session -> {
        session.sendMessage(new TextMessage(jsonData));
    });
}
```

### 3. Sottoscrizione Classi di Mercato

**Frontend Request:**
1. User clicka "Subscribe" in `ClassSubscription.jsx`
2. Chiamata REST a `/api/subscriptions/subscribe`
3. Backend invia messaggio SUB tramite SDP

**Backend Processing:**
```java
// SubscriptionController.java
@PostMapping("/subscribe")
public void subscribe(@RequestBody SubscribeRequest request) {
    // 1. Ottiene connessione SDP dal pool
    SDPConnection connection = sdpPool.getConnection(ServiceType.INFO_BRT);
    
    // 2. Crea messaggio SUB per la classe richiesta
    SUB subMessage = new SUB();
    subMessage.setClassId(request.getClassId());
    
    // 3. Invia tramite SDP
    connection.send(subMessage);
}
```


### 4. Ricezione e Processamento Dati Market

**Backend Flow (quando arriva un messaggio SDP):**

```java
// SDPConnection.java
private void handleReceivedMessage(Object sspMessage) {
    // STEP 1: Serializza messaggio SDP a JSON
    String jsonData = SMPMessageSerializer.toJson(sspMessage);
    // STEP 2: Broadcast a tutti i client WebSocket
    webSocketHandler.broadcastMarketData(jsonData);
    // STEP 3: Salva su database H2 (solo storico, NON letto dal frontend)
    marketDataService.saveMarketData(jsonData);
}
```

**Nota:** Il frontend NON legge i dati dal database H2, ma solo dal contesto WebSocket/in-memory. Tutti i dati visualizzati sono accumulati in memoria.

**SMPMessageSerializer - Logica Critica:**

```java
// SMPMessageSerializer.java
public static String toJson(Object smpMessage) {
    // USA LinkedHashMap per preservare l'ordine dei campi
    // (importante per frontend: colonne grid nello stesso ordine della classe Java)
    Map<String, Object> result = new LinkedHashMap<>();
    
    // Ottiene tutti i field tramite reflection
    for (Field field : clazz.getDeclaredFields()) {
        
        // FILTRA campi interni che non servono all'utente
        if (field.getName().equals("Class") ||
            field.getName().equals("ClassName") ||
            field.getName().equals("cLASS_ID") ||
            field.getName().equals("classid") ||
            field.getName().equals("SMPClassId")) {
            continue;  // Salta questi campi
        }
        
        // NORMALIZZA nome campo a camelCase
        // "InstrumentId" → "instrumentId"
        // Questo previene duplicati (field + getter)
        String fieldName = normalizeFieldName(field.getName());
        
        result.put(fieldName, serializeValue(value));
    }
    
    // Converte Map a JSON string
    return objectMapper.writeValueAsString(result);
}
```

### 5. Visualizzazione Dati nel Frontend

**WebSocketContext - Distribuzione Messaggi:**

```javascript
// WebSocketContext.jsx - Context Provider globale
const [allMessages, setAllMessages] = useState([]);

// Quando arriva messaggio WebSocket:
socket.onmessage = (event) => {
    const data = JSON.parse(event.data);
    
    // IMPORTANTE: Accumula TUTTI i messaggi in memoria
    // Problema potenziale: array cresce indefinitamente
    // Stato attuale: nessun limite, nessuna paginazione da DB
    setAllMessages(prev => [...prev, {
        timestamp: Date.now(),
        className: data._type,
        classId: extractClassId(data),
        data: data
    }]);
};

// Componenti figli accedono ai dati tramite context:
// const { allMessages } = useContext(WebSocketContext);
```

**ClassTabbedView - Organizzazione per Classe:**

```javascript
// ClassTabbedView.jsx
const { allMessages } = useContext(WebSocketContext);

// RAGGRUPPA messaggi per classe
const groupedByClass = useMemo(() => {
    const groups = {};
    allMessages.forEach(msg => {
        if (!groups[msg.classId]) {
            groups[msg.classId] = [];
        }
        groups[msg.classId].push(msg);
    });
    return groups;
}, [allMessages]);

// Crea TAB per ogni classe
Object.entries(groupedByClass).map(([classId, messages]) => (
    <Tab key={classId}>
        {className} ({messages.length})
    </Tab>
));
```

**DynamicDataGrid - Rendering Tabella:**

```javascript
// DynamicDataGrid.jsx
function DynamicDataGrid({ data }) {
    
    // STEP 1: Appiattisce struttura dati
    // Da: { timestamp, className, classId, data: {...} }
    // A:  { timestamp, className, instrumentId, coupon, ... }
    const flattenedData = useMemo(() => {
        return data.map(item => ({
            _rowId: idx,
            timestamp: item.timestamp,
            className: item.className,
            classId: item.classId,
            ...item.data  // Espande tutti i campi data
        }));
    }, [data]);
    
    // STEP 2: Estrae nomi colonne DAL PRIMO RECORD
    // Questo preserva l'ordine della classe Java (grazie a LinkedHashMap)
    const columnNames = useMemo(() => {
        const firstRecord = flattenedData[0];
        return Object.keys(firstRecord).filter(key => 
            !key.startsWith('_') &&
            key !== 'cLASS_ID' &&
            key !== 'classid' &&
            key !== 'className' &&
            key !== 'class' &&
            key !== 'sMPClassId'
        );
    }, [flattenedData]);
    
    // STEP 3: Crea definizioni colonne per TanStack Table
    const columns = columnNames.map(colName => ({
        accessorKey: colName,
        header: colName,
        enableColumnFilter: true,  // Abilita filtro Excel-like
        enableSorting: true,       // Abilita ordinamento
        enableResizing: true,      // Abilita ridimensionamento
        filterFn: (row, columnId, filterValue) => {
            // Filtro custom: checkbox list (come Excel)
            if (!filterValue || filterValue.length === 0) return true;
            return filterValue.includes(row.getValue(columnId));
        }
    }));
    
    // STEP 4: Inizializza TanStack Table
    const table = useReactTable({
        data: flattenedData,
        columns,
        // ... configurazione sorting, filtering, pagination
    });
    
    // STEP 5: Rendering HTML della tabella
    return (
        <table>
            <thead>
                {table.getHeaderGroups().map(headerGroup => (
                    <tr>
                        {headerGroup.headers.map(header => (
                            <th>
                                {header.column.columnDef.header}
                                {/* Filtro Excel-like dropdown */}
                                <ExcelLikeFilter column={header.column} />
                            </th>
                        ))}
                    </tr>
                ))}
            </thead>
            <tbody>
                {table.getRowModel().rows.map(row => (
                    <tr>
                        {row.getVisibleCells().map(cell => (
                            <td>{flexRender(cell.column.columnDef.cell, cell.getContext())}</td>
                        ))}
                    </tr>
                ))}
            </tbody>
        </table>
    );
}
```

### 6. Modifica/Inserimento Record (ADD/RWT/DEL)

**Frontend - Apertura Modal:**

```javascript
// Badge 📋 su ogni riga grid apre modal
<button onClick={() => setRecordDetailModal(row.original)}>
    📋
</button>

// RecordDetailModal.jsx
function RecordDetailModal({ record, onAction, isNewRecord }) {
    const [editedData, setEditedData] = useState({});
    const [isEditing, setIsEditing] = useState(isNewRecord);
    
    // Pulsanti disponibili:
    // - Se isNewRecord=true: solo ADD
    // - Se isNewRecord=false: ADD + RWT + DEL
    // Stato attuale: le azioni ADD/RWT/DEL inviano una richiesta REST al backend (TransactionController), che esegue la transazione secondo protocollo SDP e restituisce l’esito al frontend.
}
```

**Backend - Invio Transazioni (DA IMPLEMENTARE):**

```java
// TransactionController.java (futuro)
@PostMapping("/transaction/add")
public void addRecord(@RequestBody AddRequest request) {
    // 1. Ottiene connessione SDP per transazioni
    SDPConnection txnConn = sdpPool.getConnection(ServiceType.TXN);
    
    // 2. Crea oggetto SDP dalla richiesta JSON
    Object sdpObject = SMPMessageDeserializer.fromJson(
        request.getClassId(), 
        request.getData()
    );
    
    // 3. Invia via SDP
    txnConn.send(sdpObject);
}
```

---

## Pattern Architetturali Utilizzati

### 1. Context API (React)
**File:** `WebSocketContext.jsx`
**Scopo:** Stato globale per messaggi real-time senza prop drilling

### 2. Object Pool Pattern
**File:** `SDPConnectionPool.java`
**Scopo:** Riusa connessioni SDP persistenti (costose da creare)

### 3. Observer Pattern
**File:** `MarketDataWebSocketHandler.java`
**Scopo:** Broadcast messaggi a tutti i client connessi

### 4. DTO (Data Transfer Object)
**File:** `SMPMessageSerializer.java`
**Scopo:** Converte oggetti Java SDP → JSON per frontend

### 5. Headless UI Pattern
**Library:** TanStack Table
**Scopo:** Logica tabella separata dal rendering HTML/CSS

---

## Decisioni Architetturali Critiche

### LinkedHashMap invece di HashMap
**Motivazione:** Preserva l'ordine dei campi come dichiarati nella classe Java.
Frontend renderizza colonne nello stesso ordine visibile nel codice sorgente.

### Normalizzazione Nomi Campi (camelCase)
**Problema:** Field "InstrumentId" + getter "getInstrumentId()" → duplicati
**Soluzione:** Normalizza tutti a "instrumentId" (prima lettera minuscola)

### Filtro Campi Interni
**Nascosti:** Class, ClassName, cLASS_ID, classid, sMPClassId
**Motivo:** Campi tecnici non rilevanti per utente finale

### WebSocket invece di Polling
**Scelta:** Push-based real-time invece di HTTP polling
**Beneficio:** Latenza minima, meno carico server

### H2 In-Memory Database
**Scopo:** Storico messaggi (attualmente tutti inseriti, nessun UPSERT)
**Limitazione:** Dati persi al restart
**TODO:** Implementare UPSERT su chiavi business per ogni classe

---

## File Chiave da Conoscere

### Backend
| File | Responsabilità |
|------|----------------|
| `SDPConnection.java` | Gestisce connessione singola SDP, riceve messaggi |
| `SDPConnectionPool.java` | Pool connessioni (INFO_BRT, TXN, QUERY, etc.) |
| `SMPMessageSerializer.java` | Serializza oggetti SDP → JSON |
| `MarketDataWebSocketHandler.java` | Broadcast WebSocket ai client |
| `MarketDataService.java` | Salvataggio messaggi su DB H2 |
| `AuthController.java` | Autenticazione utenti |
| `SubscriptionController.java` | Gestione sottoscrizioni classi |

### Frontend
| File | Responsabilità |
|------|----------------|
| `App.jsx` | Routing, autenticazione, layout |
| `WebSocketContext.jsx` | Connessione WebSocket, stato messaggi |
| `ClassSubscription.jsx` | Interfaccia sottoscrizioni |
| `ClassTabbedView.jsx` | Tab dinamici per ogni classe |
| `DynamicDataGrid.jsx` | Griglia dati con TanStack Table |
| `ExcelLikeFilter.jsx` | Dropdown filtro Excel-like |
| `RecordDetailModal.jsx` | Visualizzazione/modifica record |

---

## Limitazioni Attuali e TODO

### Memoria Frontend Illimitata
**Problema:** `allMessages` array cresce indefinitamente
**Stato attuale:** nessun limite implementato; tutti i messaggi sono mantenuti in memoria.

### Nessun UPSERT su DB
**Problema:** Record duplicati salvati ogni volta
**Stato attuale:** il database H2 è usato solo come storico, non come fonte dati per le griglie; nessuna logica di UPSERT implementata.

### Transazioni Implementate
**Stato attuale:** le azioni ADD/RWT/DEL sono realmente implementate: il frontend invia una richiesta REST al backend (TransactionController), che esegue la transazione secondo protocollo SDP e restituisce l’esito al frontend.

### Enumerati Gestiti
**Stato attuale:** la conversione enum è robusta sia lato backend (convertValue, getEnum/setValue) che frontend (modali e griglie accettano valori enum e numerici).

### Validazione Dati
**Stato attuale:** validazione base su campi obbligatori e tipi; nessuna validazione business avanzata.

---

## Debug e Troubleshooting

### WebSocket Non Si Connette
1. Verifica URL: `ws://localhost:8080/ws/market-data`
2. Controlla CORS in `WebSocketConfig.java`
3. Verifica token in localStorage
4. Il frontend mostra uno spinner di attesa durante la connessione WebSocket (UX migliorata).

### Colonne Disordinate
1. Verifica uso di `LinkedHashMap` in SMPMessageSerializer
2. Check filtro campi interni
3. Verifica `Object.keys()` usa primo record

### Campi Duplicati
1. Verifica normalizzazione camelCase in SMPMessageSerializer
2. Check che getters non siano processati due volte

### Dati Non Aggiornati
1. Verifica WebSocket connection status
2. Controlla console browser per errori JSON parsing
3. Verifica backend logs per eccezioni serializzazione

---

## Estensibilità Futura

### Aggiungere Nuova Classe Market Data
1. SDP lib fornisce classe Java automaticamente
2. Backend serializza automaticamente (reflection)
3. Frontend crea tab e colonne automaticamente
4. **Nessuna modifica codice necessaria**
5. La gestione dei default/null è ora robusta: tutti i campi, inclusi quelli annidati, sono inizializzati con valori di default sia lato backend che frontend (modale JSON).

### Aggiungere Nuovo Tipo Transazione
1. Estendere `TransactionController` (non ancora implementato)
2. Implementare `SMPMessageDeserializer` (inverso del serializer, non ancora presente)
3. Aggiungere bottone in `RecordDetailModal` (già presente, ma solo log su console)

### Supportare Più Database
1. Sostituire H2 con PostgreSQL/MySQL
2. Implementare JPA entities per ogni classe
3. Creare repository con UPSERT logic

