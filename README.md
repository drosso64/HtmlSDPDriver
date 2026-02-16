# TradeImpact Web Gateway

Gateway web per visualizzazione e gestione dati market in tempo reale via protocollo SDP.

## 🎯 Scegli la Tua Guida

### 1. Prima Volta sul Progetto?
👉 **Leggi:** [`ARCHITECTURE.md`](ARCHITECTURE.md)
- Panoramica completa del sistema
- Flusso dati end-to-end
- Diagrammi architetturali
- Pattern utilizzati

### 2. Devi Fare Manutenzione/Bug Fix?
👉 **Leggi:** [`MAINTENANCE.md`](MAINTENANCE.md)
- Scenari comuni di modifica
- Debug rapido problemi frequenti
- FAQ operative
- Guida senza AI

### 3. Vuoi Capire SOLO il Codice?
👉 **Leggi i commenti inline** nei file:
- `SMPMessageSerializer.java` - Serializzazione SDP → JSON
- `WebSocketContext.jsx` - Gestione connessione real-time
- `DynamicDataGrid.jsx` - Rendering tabella con TanStack

---

## 🚀 Quick Start

### Con Docker (Raccomandato)
```bash
docker build -t trade-impact-web .
docker run -p 8081:8080 trade-impact-web
```
Apri browser: `http://localhost:8081`

### Development Locale
```bash
# Terminal 1 - Backend
cd TradeImpactWeb
mvn clean install && mvn spring-boot:run

# Terminal 2 - Frontend
cd TradeImpactWeb/frontend
npm install && npm start
```
Frontend: `http://localhost:3000` (proxy → backend su 8080)

---

## 📋 Struttura Progetto

```
HtmlDriver/
├── ARCHITECTURE.md           ← 📘 Documentazione tecnica completa
├── MAINTENANCE.md            ← 🔧 Guida operativa per manutenzione
├── TradeImpact.md            ← Specifiche progetto originale
└── TradeImpactWeb/
    ├── src/main/java/        ← Backend Spring Boot
    │   ├── sdp/              ← Connessione SDP protocol
    │   ├── util/             ← SMPMessageSerializer (☆ CRITICO)
    │   └── websocket/        ← WebSocket broadcast
    ├── frontend/src/         ← Frontend React
    │   ├── contexts/         ← WebSocketContext (☆ CRITICO)
    │   └── components/       ← DynamicDataGrid, ExcelLikeFilter, Modals
    ├── pom.xml               ← Maven dependencies
    ├── Dockerfile            ← Multi-stage build (Maven + Node)
    └── docker-compose.yml    ← Orchestrazione container
```

---

## ⚡ Features Implementate

✅ **Connessione SDP Real-time**
- Pool di connessioni persistenti (INFO_BRT, TXN, QUERY)
- Sottoscrizioni dinamiche classi market data
- Broadcast WebSocket a tutti i client

✅ **Griglia Dati Dinamica**
- Colonne generate automaticamente dai dati
- Ordine colonne = ordine campi classe Java
- Filtri Excel-like (dropdown, checkbox, search)
- Sorting, resizing, pagination

✅ **Gestione Record**
- View/Edit modal con tutti i campi
- Badge "➕ Nuovo Record" per inserimenti
- Badge "📋" per row per visualizzazione completa
- Bottoni ADD/RWT/DEL (TODO: implementare SDP transactions)

✅ **Tab Dinamici**
- Tab automatici per ogni classe sottoscritta
- Contatori record in tempo reale
- Pop-out su nuova finestra browser

---

## 🔧 Stack Tecnologico

| Layer | Tecnologia | Versione |
|-------|------------|----------|
| Backend | Spring Boot | 3.3 |
| Frontend | React | 18 |
| Table Library | TanStack Table | 8.11.0 |
| Database | H2 (in-memory) | - |
| Build | Maven + npm | - |
| Container | Docker | Multi-stage |
| Protocol | SDP (MTS) | Proprietario |

---

## 📝 Note per Manutenzione

### ⚠️ Problemi Noti

1. **Memory Leak Frontend**
   - `allMessages` array cresce indefinitamente
   - Soluzione: Ring buffer o paginazione DB
   - Dettagli: [`MAINTENANCE.md#scenario-5`](MAINTENANCE.md#scenario-5-risolvere-memory-leak-allmessages-cresce-allinfinito)

2. **Transazioni Non Implementate**
   - ADD/RWT/DEL loggano solo console
   - Serve implementare `TransactionController` + deserializer
   - Dettagli: [`MAINTENANCE.md#scenario-4`](MAINTENANCE.md#scenario-4-implementare-transazioni-addrwtdel)

3. **Database Schema Generico**
   - Singola tabella per tutti i messaggi (JSON blob)
   - Migliore: tabelle per classe con UPSERT su business key
   - TODO: Attendere mapping business keys dal team TradeImpact

### 🎯 Prossime Priorità

1. 🔴 **CRITICO:** Ring buffer per allMessages (previene crash)
2. 🟠 **IMPORTANTE:** Implementare transazioni SDP (ADD/RWT/DEL)
3. 🟡 **MEDIO:** Schema DB per classe con UPSERT
4. 🟢 **NICE-TO-HAVE:** Combo/select per campi enum

---

## 🧪 Testing

### Backend
```bash
mvn test
```

### Frontend
```bash
cd frontend
npm test
```

### Integration Test
```bash
# Richiede TradeImpact server accessibile
./run-integration-tests.sh
```

---

## 📞 Supporto

**Per domande tecniche:**
- Consulta [`ARCHITECTURE.md`](ARCHITECTURE.md) per design system
- Consulta [`MAINTENANCE.md`](MAINTENANCE.md) per scenari pratici
- Leggi commenti inline nei file sorgente

**Per domande business:**
- Contatta team TradeImpact per:
  - Nuove classi SDP
  - Business keys mapping
  - Logiche transazionali

---

## 📜 License

Proprietario - MTS Markets

---

**Ultimo aggiornamento documentazione:** Dicembre 2024

