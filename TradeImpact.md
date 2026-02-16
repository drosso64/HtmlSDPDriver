# Trade Impact - Architettura MTS Markets

> Estratto da: Presentazione ENXT.pptx

## Indice
- [Visione ad Alto Livello](#visione-ad-alto-livello)
- [Architettura a 3 Livelli](#architettura-a-3-livelli)
- [Layer Infrastrutturale](#layer-infrastrutturale)
- [Layer Applicativo](#layer-applicativo)
- [Protocolli di Comunicazione](#protocolli-di-comunicazione)
- [Distributed Memory Caches](#distributed-memory-caches)
- [Scalabilità](#scalabilità)
- [Persistenza](#persistenza)
- [Subsystem MTS Datafeed](#subsystem-mts-datafeed)
- [Use Cases](#use-cases)

---

## Visione ad Alto Livello

Trade Impact è una piattaforma component-based e service-oriented per la gestione dei mercati finanziari MTS.

### Mercati Supportati
- **CMF** (Cash Market Floor)
- **BV** (Bond Vision)
- **MMF** (Money Market Floor)
- **PAF** (in fase di migrazione alla nuova infrastruttura)

### Tipologia di Architettura
- **Component-based**: funzionalità divise in componenti riutilizzabili
- **Service-oriented**: comunicazione basata su servizi
- **Piattaforma unificata**: i mercati sono visti come un'unica piattaforma grazie al Service Provider e all'Information Bus

---

## Architettura a 3 Livelli

```
┌─────────────────────────────────────┐
│         FRONT-END                   │
│  (SDP/FIX ↔ ASIO/IDP/AMQP)         │
├─────────────────────────────────────┤
│         BACK-END                    │
│     (Business Logic)                │
├─────────────────────────────────────┤
│         PERSISTENCE                 │
│  (Trading DB + Historical DB)       │
└─────────────────────────────────────┘
```

### Front-End Level
Interfaccia con il mondo esterno:
- **Lato esterno**: protocolli di mercato (SDP, FIX)
- **Lato interno**: protocolli interni (boost.ASIO, CORBA legacy, IDP, AMQP)

### Back-End Level
Implementa tutta la logica di business:
- Matching engines
- Generazione informazioni
- Gestione stato membri

### Persistence Level
Due schemi Oracle per mercato:
- **Trading DB**: dati operativi di trading
- **Historical DB**: dati storici

---

## Layer Infrastrutturale

### YASS (Yet Another Service Server)
- Istanziato su ogni nodo della piattaforma
- Responsabile di Start/Stop/Restart dei componenti
- Monitora lo stato dei componenti
- Un'istanza Master gestisce il failover dei nodi (eletto tramite elezione)

### MON (Monitor)
- Monitora performance dei nodi (CPU, RAM)
- Informazioni visualizzate sulla console Trade Impact

### PS (Push Server)
- Broker per comunicazione interna (IDP)
- Paradigma Publish/Subscribe
- Istanze dedicate per tipo di informazione e distribuzione del carico

### PA (Performance Analyzer)
- Raccoglie informazioni dai componenti di mercato
- Necessarie per monitoraggio SLA

---

## Layer Applicativo

### Front-End Components

#### IPSP (IP Service Provider)
- Load Balancing delle connessioni in ingresso
- Distribuisce i servizi SDP richiesti dalle applicazioni periferiche
- Istanze multiple attive sul Service Provider Market Instance
- Serve tutti i mercati MTS

#### AP SDP (Access Point)
- Entry point per tutte le funzionalità di mercato
- Gestisce connessioni fisiche (TCP-IP Sockets) con i client
- Responsabile della comunicazione protocollo SDP
- Invoca i server del Back-End con transazioni **boost.ASIO** (CMF/BV/MMF) o **CORBA** (PAF)
- Istanze specializzate per mercato/servizio, dedicate a subset di Members

#### AP FIX
- Accesso a subset di funzionalità via protocollo FIX
- Istanze specializzate, dedicate a subset di Members

#### GW FIX (Gateway FIX)
- Livello intermedio tra periferia e Front-End del mercato
- Implementa subset messaggi FIX (Order Staging, Trade Capture)
- Non richiede performance elevate
- Gestisce molteplici dizionari FIX customizzati per i members
- NON comunica direttamente con Back-End, ma tramite AP SDP

#### Proxy SDP
- Termina connessioni SSL per accesso via Internet
- Disaccoppia comunicazione periferia ↔ AP SDP

#### Proxy FIX
- Termina connessioni SSL per accesso via Internet
- Disaccoppia comunicazione periferia ↔ AP FIX/GW FIX

### Back-End Components

Componenti specializzati per mercato:

#### Configurazioni Mercato
- **PSM** (Platform Service Manager)
- **MSM** (Market Service Manager)

#### Stato Members
- **TSM** (Trader Status Manager)

#### Matching Engines
- **CMF**: AT (Auto Trader), MPE (Mid Price Engine)
- **BV**: IQE (Inventory Quotes Engine), RME (RFCQ Matching Engine), RAP (RFCQ Auto Player)
- **MMF**: AT (Auto Trader)

#### Generazione Informazioni Pubbliche
- **BV**: AT-IND (Auto Trader Indicative)
- **BV/CMF/MMF**: CE (Contribution Engine)

#### Generazione Informazioni Private
- **BV**: IDS (Inventory Depth Server), IBDS (Inventory By Dealer Server)
- **MMF**: BS (Best Server), IBS (Inventory By Size Server)

#### Datafeed
- **DF** (DataFeed)

#### Dati Storici
- **QM** (Query Manager)

#### Feeder Dati Esterni
- **ECE** (External Contribution Engine)
- **OSM** (Order Staging Manager)

#### Comunicazione Intra-Platform
- **Bridge** (Platform Bridge)

#### Post-Trading
- **FM** (Fill Manager)

#### Governance
- **GOV** (Governance)

### Cardinalità Componenti (Esempi)

| Component        | CMF | BV  | MMF | PAF |
|------------------|-----|-----|-----|-----|
| TXN AP           | 42  | 84  | 12  | 2   |
| BRT AP           | 36  | 78  | 12  | 2   |
| Push PRI         | 8   | 19  | 7   | 1   |
| Push BRT         | 5   | 8   | 7   | 1   |
| AT               | 18  | 16  | 4   | 1   |
| IQE              | -   | 16  | -   | -   |
| IDS              | -   | 16  | -   | -   |
| IBDS             | -   | 16  | -   | -   |
| BS               | -   | -   | 7   | -   |

---

## Protocolli di Comunicazione

### Protocolli Esterni

#### SDP (SIA Data Protocol)
Protocollo proprietario SIA, basato su TCP/IP, con 3 livelli:
- **SSP** (SIA Session Protocol): livello più basso
- **SAP** (SIA Application Protocol): livello intermedio
- **SMP** (SIA Market Protocol): livello applicativo dove sono definiti i messaggi di mercato ("classi")

##### Servizi SDP

| Servizio | Nome | Descrizione |
|----------|------|-------------|
| **INFO_BRT** | Public Information Service | Sottoscrizione Master Data e Info Pubbliche (Market Depth, Last Deals, Market Statistics, etc.) |
| **TXN_INFO_PRIV** | Transactional & Private Information Service | Invio transazioni (Trade on/off, quotes, orders) + ricezione ACK sincroni e aggiornamenti asincroni dati privati |
| **TXN** | Pure Transactional Service | Transazioni alta priorità (quick/smart editing quotes) + ACK sincroni |
| **QUERY** | Query Service | Query per recuperare dati storici |
| **IP_REQUEST** | IP Provider Service | Addressing e balancing - richiesto prima di connettersi ai servizi |

#### FIX
Protocollo standard FIX

**Accesso**: entrambi i protocolli sono utilizzabili via Leased Line o Internet

### Protocolli Interni

#### CORBA
- **Tipo**: Client-Server
- **Utilizzo**: comunicazione transazionale tra Access Point e Back-End Servers (solo **PAF**)
- **Caratteristiche**: sincrono, affidabile
- **Stato**: tecnologia legacy, in dismissione
- **Nota**: i mercati **CMF**, **BV** e **MMF** usano **boost.ASIO** al posto di CORBA

#### IDP (Internal Data Protocol)
- **Tipo**: Publish-Subscribe
- **Sviluppo**: in-house, basato su TCP/IP
- **Utilizzo**: i "Consumer" sottoscrivono informazioni dai "Producer" direttamente o tramite "Broker" (Push Server)
- **Stato**: sarà sostituito da Apache Artemis

#### AMQP (Advanced Message Queuing Protocol)
- **Tipo**: standard open application layer protocol
- **Utilizzo**: alto volume e/o bassa latenza (Inventory Quoting, MTS Live, MTS Datafeed)
- **Implementazioni**:
  - Apache QPID (attualmente in uso)
  - RabbitMQ (MTS Datafeed microservices)
- **Stato**: QPID sarà sostituito da Apache Artemis

---

## Distributed Memory Caches

Per ragioni di performance, la piattaforma lavora prevalentemente in memoria, lasciando la persistenza DB solo dove strettamente necessario (spesso in modalità asincrona).

### JBoss DataGrid (Apache Infinispan)
- **Tipo**: key/value data store
- **Dati**: da oggetti complessi a plain text
- **Utilizzo**: 
  - CMF: immagini iniziali e finali delle quote
  - BV: immagini Inventory Depth
- **Caratteristiche**:
  - Cache replicate o distribuite
  - Backup su nodi/siti diversi
  - Alta resilienza in caso di failure sw/hw

### Apache Ignite
- **Tipo**: key/value data store con REST APIs
- **Vantaggio**: query SQL-like sui dati in cache
- **Vista**: le cache sono viste come tabelle DB relazionali
- **Query**: supporta join, union, group-by, predicati SQL
- **Utilizzo**: esclusivamente in MTS Datafeed Subsystem

---

## Scalabilità

Trade Impact implementa due approcci complementari di scalabilità:

### Scalabilità Orizzontale (Clusterization)

**Concetto**: definizione di più istanze dello stesso componente (es. Matching Engine), dove ogni istanza gestisce solo un subset degli oggetti totali (es. strumenti).

**Implementazione**: principalmente configurazione sul Trading DB su come partizionare gli oggetti tra le istanze.

**Esempio**: 
```
AT Instance 1 → Strumenti 1-100
AT Instance 2 → Strumenti 101-200
AT Instance 3 → Strumenti 201-300
```

### Scalabilità Verticale (Sub-Clusterization)

**Concetto**: componenti multi-threaded dove ogni thread gestisce solo un subset degli oggetti gestiti dall'istanza del componente.

**Caratteristiche**:
- Sub-clusterization può seguire regole diverse dalla clusterization
- Esempio: componente clustered by member, sub-clustered by instrument

**Implementazione**: configurazione sul Trading DB + Market Server Framework

---

## Market Server Framework

Framework sviluppato internamente per costruire applicazioni multi-threaded.

### Punti Chiave

#### Thread Switcher
- Unico thread che riceve le transazioni da processare
- Determina a quale thread/sub-cluster assegnare la transazione
- Basato su:
  - Configurazione statica DB
  - Strategie dinamiche (round robin, least busy thread, etc.)

#### Sub-Cluster Threads
- Ogni thread ha una **copia locale in memoria** di tutte le informazioni necessarie
- **No interazioni** con altri thread durante il processing
- **No context switch** (o raramente)

#### Processing Flow
```
Transazione → Switcher → Sub-Cluster Thread → Processing
                                            ↓
                          Persistenza (DB/DataGrid/Memory only)
                                            ↓
                          Pubblicazione Info (IDP/AMQP)
```

**Vantaggi**:
- Massima performance
- Isolamento tra thread
- Riduzione contention

---

## Persistenza

Per garantire bassa latenza, la persistenza è ridotta al minimo indispensabile.

### Strategie di Persistenza

#### 1. Persistenza su DB
- **Utilizzo**: transazioni di configurazione, casi non time-critical
- **Modalità**:
  - **Sincrona**: per dati critici
  - **Asincrona**: tramite componenti dedicati (DBWriter) che sottoscrivono informazioni e persistono su DB

#### 2. Persistenza su Data Grid (JBoss/Infinispan)
- **Utilizzo**: bassa latenza richiesta
- **Selettività**: può essere ristretta solo ad alcuni eventi
- **Esempio CMF Quotes**:
  - Prima immagine → salvata su Data Grid
  - Immagini intermedie → solo in memoria
  - Immagine finale → salvata su Data Grid
  - Motivazione: in caso di failure del Matching Engine, al restart le quote sono sospese e i prezzi devono essere ritrasmessi

#### 3. Persistenza su Apache Ignite
- **Utilizzo**: esclusivamente MTS Datafeed
- **Caratteristiche**: tempi di accesso estremamente bassi con query SQL-like

---

## Master Data (Anagrafica)

### Database Anagrafica
Database Oracle centralizzato contenente:
- Master data dei mercati
- Sezioni
- Members
- Tutti gli strumenti finanziari tradati nei mercati MTS

### Trading Promotion
Ogni sera, dopo il Day-End promotion:
- Anagrafica alimenta il Trading DB di ogni mercato
- Dati effettivi per il giorno di trading successivo

### Accesso
- GUI dedicata per utenti MTS

### Integrazione Refinitiv (BV Market)
- **Processo**: Download quotidiano da Refinitiv DSS
- **Tecnologia**: software Java invoca REST services Refinitiv
- **Flow**: Refinitiv → Staging Tables → (validazione utente) → Anagrafica DB

---

## Platform Integration

### Service Provider Market Instance
Istanza dedicata che fornisce funzionalità di addressing per applicazioni periferiche:
- Centralizza l'accesso ai servizi dei singoli mercati
- Permette alle GUI di connettersi a CMF, BV, MMF come piattaforma unificata

### Information Bus (AMQP)
- Permette ai mercati di scambiare informazioni
- **Esempio**: notifica agli altri mercati quando un trader è aggiunto/modificato su un mercato

### Connection Flow
```
GUI → IPSP (IP_REQUEST) → Ottiene indirizzi servizi (CMF, BV, MMF)
    ↓
  Logout da IPSP
    ↓
  Login ai singoli AP dei mercati (INFO_BRT, TXN_INFO_PRIV, TXN)
```

---

## Tipi di Informazioni

### Private
Informazioni ricevute dai partecipanti relative ai loro dati personali e di trading:
- Ordini
- Quote
- Contratti

### Public
Informazioni visibili a tutti i partecipanti:
- Dati strumenti
- Depth (prime N linee Order Book)
- Best (prima linea Depth)
- Last Deal
- Statistiche end-of-day

### Datafeed
Informazioni dedicate a MTS:
- Tutte le attività di mercato
- Tutte le operazioni dei members
- Feed completo per analisi e reporting

---

## Configurabilità

Molti comportamenti della piattaforma possono essere modificati agendo solo sulla configurazione DB, senza modifiche al codice.

### Configurabile da DB
- Clusterization e Sub-Clusterization
- Code AMQP e relative caratteristiche
- Comportamento Access Point

### Configurazione Access Point
Set dedicato di tabelle DB permette di:
- **Routing**: definire il componente destinatario di una transazione o sorgente di un'informazione
- **Permessi**: definire permessi su messaggi per profilo member/trader o singolo member
- **Conversioni**: definire conversioni da formato interno a formato esterno (mapping messaggi protocollo)
- **Visibilità**: definire livello di visibilità messaggi in base al contenuto stesso

---

## Subsystem MTS Live

### Architettura
Sistema dedicato per feed tick-by-tick delle quote CMF.

### Componenti

#### Producers (AT CMF)
- Istanze AT del mercato CMF
- Scrivono feed quote in code QPID dedicate
- Una coda per ogni istanza AT

#### QPID Brokers
- **Primary**: istanza principale attiva
- **Backup**: istanza in hot-standby
- **Replicazione**: sincrona Primary → Backup

#### Consumers (MTS Live Feeders)
- Leggono da code QPID
- Inviano a consumer FIX/FAST
- Applicazioni periferiche connesse a FIX/FAST

### Failover
- Producers e Consumers connessi normalmente a Primary
- Switch automatico a Backup in caso di failure Primary

### Diagramma
```
CMF AT Instances → QPID Queues (Primary) ⟺ QPID Queues (Backup)
                         ↓
                   MTS Live Feeders
                         ↓
                   FIX/FAST Consumers
                         ↓
                   FIX Applications
```

---

## Subsystem MTS Datafeed

### Architettura
Microservizi Java basati su architettura moderna cloud-native.

### Design Pattern
- **Architettura**: Microservizi
- **Pipeline**: diversi microservizi lavorano in pipeline
- **Messaggi**: processano messaggi dai mercati alimentati in code QPID

### Tipi di Code QPID

#### High Volume Queues
- **Tipo**: Quotes
- **Caratteristiche**: alto throughput

#### Sequential Processing Queues
- **Tipo**: Snapshot Queues
- **Caratteristiche**: messaggi processati nell'esatto ordine di ricezione

#### Parallel Processing Queues
- **Tipo**: Ticker Queues
- **Caratteristiche**: messaggi processabili in parallelo (ordine non importante)

### Processing Flow
```
Markets → QPID Queues → Microservices → Apache Ignite Caches
                              ↓
                    (retrieve, process, convert, enrich)
```

**Enrichment**: aggiunta informazioni denormalizzate

### Tecnologie

#### Linguaggio
- **Java** esclusivamente

#### Deployment
- **Kubernetes**: orchestrazione container
- **Docker**: immagini container

#### Comunicazione Microservizi
- **RabbitMQ**: scelta primaria per microservizi
  - Integrato in framework open source (Spring Boot)
  - Più lightweight di Apache QPID
  - Ampiamente usato nell'ecosistema microservizi

#### Storage
- **Apache Ignite Caches**: storage finale dati processati
- **On-Disk**: backup su disco per persistenza

### Nodes
Sistema distribuito su:
- Node 1-4: QPID + processing
- Node 5-8: Ignite cluster

### Queues Structure
```
Markets (CMF/BV/MMF/PAF) 
    ↓
QPID-DF-SNAPSHOT / QPID-DF-TICKER / QPID-DF-QUOTE
    ↓
smp-snapshot / smp-ticker / smp-quote
    ↓
XDR-SNAPSHOT / XDR-TICKER / XDR-QUOTE
    ↓
CLIENT IGNITE CACHES (SNAPSHOT/TICKER/QUOTE)
```

---

## Use Cases

### Use Case 1: CMF Quote Submission

**Componenti coinvolti**:
- CMF Quote GUI / CMF Quick Edit / CMF Smart Edit
- Access Point
- AT (Auto Trader) Cluster
  - Instrument Cluster
  - Member Cluster
- Push Server (PRIV + BRT)
- JBoss Data Grid (CMF Quote Cache)

**Flow**:
1. Quote submission da GUI
2. AP riceve e valida
3. AT processa quote (clustered by instrument/member)
4. Salvataggio su CMF Quote Cache (JBoss Data Grid)
5. Pubblicazione via Push Server
6. Update depth CMF

### Use Case 2: BV Inventory Quote Submission

**Componenti coinvolti**:
- Inv. Quote GUI
- Access Point
- IQE (Inventory Quotes Engine) Cluster
  - Instrument Cluster
  - Member Cluster
- IOIS (Indication Of Interest Server) Cluster
- IDS (Inventory Depth Server) Cluster
- Push Server PRIV

**Flow**:
1. Inventory Quote/IOI submission
2. IQE processa quote
3. IOIS gestisce IOI
4. IDS aggiorna Inventory Depth
5. Pubblicazione info private via Push Server
6. Update IOI Depth e IOI Info

### Use Case 3: Trade Generation

**Componenti coinvolti**:
- Matching Engine Cluster
  - Instrument Cluster
  - NO Member Cluster (transazioni non clustered by member)
- Access Point
- Fill Manager
- Push Server PRIV
- X-TRM (external system)
- PSE (Post Settlement Engine)
- Trading DB / Auxiliary DB

**Flow**:
1. ORDER → Matching Engine
2. QUOTE matching
3. TRADE Undefined generato
4. Fill Manager processa TRADE
5. DEAL creazione
6. TRADE Defined (CMF/MMF/BV)
7. Persistenza su Trading DB
8. Notifica X-TRM e PSE
9. Pubblicazione via Push Server

---

## Architettura Interna dei Componenti

Questa sezione analizza in dettaglio l'architettura interna dei componenti Trade Impact, utilizzando **MSM (Market Service Manager)** come esempio rappresentativo.

### Framework MarketServer

Tutti i componenti di Back-End sono costruiti utilizzando il **MarketServer Framework**, sviluppato internamente. Questo framework fornisce:

- **Pattern Message Handler**: gestione standardizzata dei messaggi
- **Sub-Clusterization**: multi-threading con isolamento dati
- **Switcher**: routing automatico delle transazioni
- **Cache Management**: astrazione per cache DB e DataGrid
- **AMQP Integration**: pubblicazione/sottoscrizione messaggi

### Struttura del Componente

#### Entry Point
```cpp
// main.cpp
int main(int argc, char *argv[], char **envp)
{
    Config::Init(argc, argv);
    Oracle::Init();
    StartD(argc, argv, envp, LocalEventProcedure);
    return 0;
}

// EntryPoint.cpp - InitProcModule()
case MODULE_ACTION_SETUP:
{
    MessageServer::CreateTracer();
    FilterSubjectsVector filterSubjectsVector;
    Helper::Subscribe::processSubscriptionsWrapper(JSON_SUBSCRIBE_FILE, filterSubjectsVector);
    MessageServer* messageServer = MessageServer::CreateInstance(filterSubjectsVector);
    messageServer->AddASIOServer("IDS");
    messageServer->AddASIOServer("IOIS");
    messageServer->StartASIOClientInterface();
}
```

**Fasi di inizializzazione:**
1. Lettura parametri configurazione
2. Connessione database Oracle
3. Creazione MessageServer
4. Setup sottoscrizioni AMQP (da file JSON)
5. Avvio server ASIO (boost.ASIO per BV/MMF)
6. Inizializzazione Switcher e Manager

### Gestione Transazioni in Ingresso

#### Pattern Message Handler

Ogni tipo di messaggio ha un handler dedicato che implementa il pattern:

```cpp
class MsgTraderStatus : public MessageRegistrationHelper<MsgTraderStatus, INT_TI_TRADER_STATUS_ID>
{
    protected:
    void SetMessage(const void* msg);      // 1. Ricezione
    bool CheckValidity();                  // 2. Validazione
    void PrepareForAdd();                  // 3. Preparazione commit
    void PrepareForEdit();
    void PrepareForDel();
    void UserMethod();                     // Inizializzazione (chiamato una volta)
};
```

#### Ciclo di Vita di una Transazione

**1. Ricezione Messaggio**
```cpp
void SetMessage(const void* msg) 
{
    _msgReceived.Fill((const char*)msg);
    TRACEDUMP("Message received", &_msgReceived);
    
    // Recupera manager del sub-cluster
    _cacheManager = CacheManagerInterface::GetInstance()->GetCacheManager(_refSubClusterId);
    _memberManager = MemberManagerInterface::GetInstance()->GetMemberManager(_refSubClusterId);
}
```

**2. Validazione Business**
```cpp
bool CheckValidity() 
{
    // Verifica marketId
    if (_msgReceived.getMarketId() != MARKET_BV_ID)
        return false;
    
    // Verifica data aggiornamento
    if (_msgReceived.getUpdateDate() != _today)
        return false;
    
    // Recupera stato corrente da cache
    _msgFromCache = _memberManager->GetTrader(...);
    
    // Verifica sequenzialità timestamp (ottimistic locking)
    if (_msgFromCache->UpdateTime >= _msgReceived.getUpdateTime())
        return false;
    
    return true;
}
```

**3. Preparazione & Commit**
```cpp
void PrepareForAdd()
{
    try {
        // Aggiorna stato in memoria
        _memberManager->SetTraderStatus(_msgReceived.getMemberId(), 
                                       _msgReceived.getTraderId(), 
                                       _msgReceived.getTraderStatus(), 
                                       _msgReceived.getUpdateTime());
        
        // Commit cache (può persistere su DB o DataGrid)
        _cacheManager->Commit();
    }
    catch (...) {
        _cacheManager->Rollback();
        throw;
    }
}
```

**4. Pubblicazione AMQP**

La pubblicazione va fatta nei metodi PrepareForAdd(), PrepareForEdit() e PrepareForDel() usando il metodo AMQPPublish() e la action in base al metodo (EntityADD, EntityRWT o EntityDEL).

#### Inizializzazione MessageHandler (UserMethod)

Il metodo `UserMethod()` viene chiamato **una sola volta** dalla libreria MarketServer durante l'inizializzazione del MessageHandler, prima che questo inizi a processare messaggi.

**Compiti del UserMethod:**
- Inizializzare i comandi di accesso al DB (DBMSTable instances)
- Recuperare le istanze dei vari Manager necessari (MemberManager, InstrumentManager, etc.)
- Configurare le cache locali per il sub-cluster
- Effettuare la pubblicazione iniziale dei dati recuperati dal DB tramite AMQP per sincronizzazione con altri componenti

```cpp
void UserMethod() 
{
    // Inizializzazione DBMSTable per accesso DB
    _pTabTrader = DBMSTable<TI_TRADER>::GetInstance(_connection);
    _pTabMember = DBMSTable<TI_MEMBER>::GetInstance(_connection);
    
    // Recupero istanze Manager
    _memberManager = MemberManagerInterface::GetInstance()->GetMemberManager(_refSubClusterId);
    _instrumentManager = InstrumentManagerInterface::GetInstance()->GetInstrumentManager(_refSubClusterId);
    
    // Pubblicazione iniziale dati da DB
    PublishInitialData();
}
```

**Nota:** Questo metodo viene invocato solo all'avvio del componente, non dopo ogni transazione.

#### Auto-Registrazione Message Handlers

Pattern template per registrazione automatica al boot:
```cpp
template <>
bool* MessageRegistrationHelper<MsgTraderStatus, INT_TI_TRADER_STATUS_ID>::_registered = 
    MsgTraderStatus::ExecRegistration(INT_TI_TRADER_STATUS_ID);
```

Questo pattern garantisce che tutti gli handler siano registrati prima dell'avvio del componente.

### Switcher: Routing dei Messaggi

Il **Switcher** è responsabile di instradare le transazioni ai sub-cluster corretti:

```cpp
class SwitchMessage : public SwitcherRegistrationHelper<SwitchMessage>
{
    void InitSwitcher();
    bool GetValueIdFromMessage(void* msg, ClassId_t classId, unsigned long& valueId);
};
```

**Logica di Routing:**
1. Estrae **ValueId** dal messaggio (tipicamente MemberId o InstrumentId)
2. Consulta configurazione DB (`CONF_CUR_CLUSTER_ALLOCATION`)
3. Determina SubClusterId target
4. Accoda messaggio al sub-cluster

**Configurazione Clustering:**
```sql
SELECT TOKENCLUSTERED 
FROM CONF_CUR_CLUSTER_ALLOCATION 
WHERE COMPONENTID = :componentId 
  AND CLUSTERID = :clusterId
```

### Sub-Clusterization

Ogni componente può avere **N sub-cluster**, ognuno con:

```cpp
class MSMSubCluster : public SubClusterRegistrationHelper<MSMSubCluster> 
{
    private:
    SubClusterId _subClusterId;
    Connection* _connection;            // Connessione DB dedicata
    ValueIdSet _valueIdSet;             // Set di oggetti gestiti
    
    public:
    MSMSubCluster(SubClusterId subClusterId);
    bool SkipMessage(ClassId_t classId, void* msg);
};
```

**Creazione Manager per Sub-Cluster:**
```cpp
void SwitchMessage::InitSwitcherInterfaces()
{
    std::vector<SubCluster*> subClusterVector;
    GetSubClusterVector(subClusterVector);
    
    for (int idx = 1; idx <= subClusterVector.size(); ++idx)
    {
        marketManagerInterface->CreateMarketManager(idx);
        memberManagerInterface->CreateMemberManager(idx, subClusterVector[idx-1]->GetConnection());
        instrumentManagerInterface->CreateInstrumentManager(idx);
        cacheManagerInterface->CreateCacheManager(idx, 
                                                  subClusterVector[idx-1]->GetValueIdSet(), 
                                                  subClusterVector[idx-1]->GetConnection());
        dataGridManagerInterface->CreateDataGridManager(idx);
    }
}
```

**Vantaggi:**
- Ogni thread ha **copia locale** dei dati gestiti
- **No context switch** tra thread durante processing
- **No contention** su strutture dati condivise
- Scalabilità verticale trasparente

### Gestione Cache (CacheLibrary)

La libreria **Components/CacheLibrary** fornisce un'astrazione unificata per cache in-memory, DB e DataGrid.

#### Pattern CacheBookInterface

```cpp
// Creazione cache backed by Oracle DB
_tradeRegistrationHeaderArchive = CacheBookInterface::GetInstance<INT_DB_BV_TRADE_REGISTRATION_HEADER>(
    MSDataBaseParameters::DbPlatform(),  // "Oracle"
    _connection,                         // Connessione DB
    "INT_DB_BV_TRADE_REGISTRATION_HEADER",  // Nome tabella
    false                                // load = false (caricamento lazy)
);

// Creazione cache backed by JBoss DataGrid
_inventoryDepthCache = CacheBookInterface::GetInstance<BV_INVENTORY_DEPTH>(
    poolId,
    addresses,
    "BV_INVENTORY_DEPTH_CACHE",
    true  // load = true (carica subito)
);
```

#### Indici Multi-Key

Le cache supportano indici multipli per ricerche efficienti:

```cpp
// Indice primario: (SectionId, MsgId)
_archive->BuildKey("MsgInfo_SectionId");
_archive->BuildKey("MsgInfo_MsgId");
int sectionKeyIndex = _archive->AddKey();

_archive->SetSearchCriterium(sectionKeyIndex, "MsgInfo_SectionId", OP_EQUAL);
_archive->SetSearchCriterium(sectionKeyIndex, "MsgInfo_MsgId", OP_GREATER_EQUAL);

// Indice secondario: (MemberId, DealerOrderId)
_archive->BuildKey("Provider_MemberId");
_archive->BuildKey("DealerOrderId");
int memberKeyIndex = _archive->AddKey();

_archive->SetSearchCriterium(memberKeyIndex, "Provider_MemberId", OP_EQUAL);
_archive->SetSearchCriterium(memberKeyIndex, "DealerOrderId", OP_EQUAL);
```

**Operatori supportati:**
- `OP_EQUAL`: uguaglianza
- `OP_GREATER`: maggiore
- `OP_GREATER_EQUAL`: maggiore o uguale
- `OP_LESS`: minore
- `OP_LESS_EQUAL`: minore o uguale

#### Operazioni CRUD

```cpp
// Insert
INT_DB_BV_TRADE_REGISTRATION_HEADER record;
record.setMsgId(msgId);
record.setSectionId(sectionId);
_archive->Insert(record);

// Search
SearchResult searchResult = _archive->Search(sectionKeyIndex);
if (searchResult.IsEmpty() == false)
{
    INT_DB_BV_TRADE_REGISTRATION_HEADER* found = 
        (INT_DB_BV_TRADE_REGISTRATION_HEADER*)searchResult.GetFirst();
    // ... elaborazione ...
}

// Update
_archive->Update(record);

// Delete
_archive->Delete(record);

// Commit/Rollback
_archive->Commit();   // Persiste modifiche (DB/DataGrid)
_archive->Rollback(); // Annulla modifiche
```

#### Pattern di Ricerca Corretto

Le cache gestite tramite `CacheBookInterface` richiedono un pattern specifico per le ricerche.

**Configurazione delle Chiavi (in Initialize):**
```cpp
// Configurare le chiavi necessarie per la ricerca
_cache->BuildKey("Campo1");
_cache->BuildKey("Campo2");
_keyIndex = _cache->AddKey();
_cache->SetSearchCriterium(_keyIndex, "Campo1", OP_EQUAL);
_cache->SetSearchCriterium(_keyIndex, "Campo2", OP_EQUAL);
```

**Note importanti**:
- `OP_GREATER_EQUAL` può essere usato per ottenere il primo record che soddisfa i criteri (es. per ottenere il SalesId più basso)
- I criteri di ricerca devono corrispondere ai campi configurati con `BuildKey`

**Esecuzione della Ricerca:**
```cpp
// 1. Creare un'istanza dell'oggetto
TIPO_CACHE oggetto;
TIPO_CACHEPtr oggettoOut;

// 2. Impostare i valori di ricerca usando i setter
oggetto.setCampo1(valore1);
oggetto.setCampo2(valore2);

// 3. Eseguire la ricerca passando oggetto e keyIndex
if (_cache->Search(&oggetto, _keyIndex) == false)
{
    // Record non trovato
    return 0;
}

// 4. Recuperare il risultato
TRACE(TL_Class, "Ricerca - %s", oggetto.Dump().c_str());
oggettoOut = (TIPO_CACHEPtr)_cache->GetFound();

// 5. Accedere ai campi tramite membri pubblici (non getter)
return oggettoOut->Campo;
```

**Pattern chiave:**
- ❌ **NON usare**: `ResetSearchCriterium()`, `SetSearchValue()`, `Search(keyIndex)`
- ✅ **Usare**: creare oggetto, impostare valori con setter, `Search(&oggetto, keyIndex)`, accesso diretto ai membri

**Esempio completo:**
```cpp
INT_BV_LIQUID_INSTRUMENT_THRESHOLDS thresholds;
INT_BV_LIQUID_INSTRUMENT_THRESHOLDSPtr thresholdsOut;

thresholds.setInstrumentId(tradableInstrumentId);
thresholds.setAreaCodeId(areaCodeId);

if (_liquidInstrumentThresholdCache->Search(&thresholds, _thresholdKeyIndex) == false)
{
    throw MarketException("Record not found", TI_ERROR_ProductNotFound);
}

thresholdsOut = (INT_BV_LIQUID_INSTRUMENT_THRESHOLDSPtr)_liquidInstrumentThresholdCache->GetFound();
return thresholdsOut->RatingCategory;
```

#### Copy-on-Write

Per operazioni parallele o snapshot:
```cpp
CacheBook* _snapshotArchive = _mainArchive->Copy();
```

Crea una copia isolata della cache senza condividere dati con l'originale.

#### Backend Supportati

| Backend | Classe | Uso |
|---------|--------|-----|
| **Oracle DB** | `DBCacheBook` | Persistenza transazionale, consistenza ACID |
| **JBoss DataGrid** | `DGCacheBook` | Performance, cache distribuite, resilienza |
| **Memory Only** | `CacheBook` | Performance massime, dati volatili |

**Configurazione:**
La scelta del backend è configurabile via:
- Parametri costruttore (`dbImplementation` / `poolId`)
- Configurazione DB (tabella `CONF_CACHE_BACKEND`)

### Pubblicazioni AMQP

#### Modalità di Pubblicazione

**A) EnterAMQP - Pubblicazione Diretta**
```cpp
MessageServer::EnterAMQP(
    BV_CUTOFF_ID,              // ClassId del messaggio
    0,                         // ChannelId (0 = auto-assign)
    cutoff->Data(),            // Puntatore ai dati raw
    EntityADD,                 // Action: ADD/EDIT/DEL
    0,                         // ClusterId (0 = broadcast)
    0                          // SubPartitionId
);
```

**B) AMQPPublish - Via MessageHandler**
```cpp
// Metodo disponibile nel MessageHandler
_msg->AMQPPublish(
    &_providerDeal,            // Record tipizzato
    EntityADD,                 // Action
    memberClusterId,           // Target cluster specifico
    0                          // ChannelId
);
```

**C) EnterMRG - Information Bus Cross-Market**
```cpp
// Pubblicazione su Message Routing Gateway per altri mercati
MessageServer::GetInstance()->EnterMRG(
    INT_TI_TRADER_PSM_AMQP_ID,
    _subClusterId,
    _tiTraderAMQP.Data()
);
```

#### Pattern Multi-Destinazione

Esempio tipico: pubblicare deal a provider, aggressor e datafeed:

```cpp
void DealPublisher::Publish(const INT_BV_RFCQ_DEAL& deal)
{
    SetRecord(deal);
    SetProviderRecord(_intDeal);
    SetAggressorRecord(_intDeal);
    
    // 1. Pubblicazione privata al provider (cluster-specific)
    ClusterId providerClusterId = MemberManagerInterface::GetInstance()
        ->GetClusterIdByMember(_providerDeal.getReceiverMemberId());
    
    MessageServer::EnterAMQP(BV_DEAL_ID, 0, _providerDeal.Data(), 
                            EntityADD, providerClusterId, 0);
    
    // 2. Pubblicazione privata all'aggressor (cluster-specific)
    ClusterId aggressorClusterId = MemberManagerInterface::GetInstance()
        ->GetClusterIdByMember(_aggressorDeal.getReceiverMemberId());
    
    MessageServer::EnterAMQP(BV_DEAL_ID, 0, _aggressorDeal.Data(), 
                            EntityADD, aggressorClusterId, 0);
    
    // 3. Pubblicazione pubblica per Datafeed e Fill Manager (broadcast)
    MessageServer::EnterAMQP(INT_BV_DEAL_ID, 0, _intDeal.Data(), 
                            EntityADD, 0, 0);
    
    MessageServer::EnterAMQP(BV_RFCQ_DEAL_ID, 0, _rfcqDeal.Data(), 
                            EntityADD, 0, 0);
}
```

**Routing AMQP:**
- **ClusterId = 0**: broadcast a tutti i consumer sottoscritti
- **ClusterId = N**: solo ai consumer del cluster N (routing key con cluster)
- **ChannelId**: usato per sub-partitioning all'interno del cluster

#### Sottoscrizioni AMQP (JSON-based)

Le sottoscrizioni AMQP sono definite in file JSON:

```cpp
FilterSubjectsVector filterSubjectsVector;
Helper::Subscribe::processSubscriptionsWrapper(
    JSON::MSM::SUBSCRIBE_REQ,  // File JSON
    filterSubjectsVector
);
MessageServer* messageServer = MessageServer::CreateInstance(filterSubjectsVector);
```

**Struttura JSON:**
```json
{
  "subscriptions": [
    {
      "subject": "BV.DEAL.*.ADD",
      "queue": "MSM_DEAL_QUEUE",
      "partitionType": "subcluster"
    },
    {
      "subject": "BV.TRADER_STATUS.#",
      "queue": "MSM_TRADER_QUEUE",
      "partitionType": "both"
    }
  ]
}
```

**PartitionType:**
- `subcluster`: partizionamento per sub-cluster
- `channel`: partizionamento per canale
- `both`: entrambi i livelli di partizionamento

### Comunicazione boost.ASIO (CMF/BV/MMF)

#### Setup Server ASIO

```cpp
// Configurazione server ASIO in EntryPoint.cpp
messageServer->AddASIOServer("IDS");   // Inventory Depth Server (BV)
messageServer->AddASIOServer("IOIS");  // Indication Of Interest Server (BV)
messageServer->AddASIOServer("AT");    // Auto Trader (CMF)
messageServer->StartASIOClientInterface();
```

**boost.ASIO sostituisce CORBA per CMF/BV/MMF perché:**

| Caratteristica | CORBA | boost.ASIO |
|----------------|-------|------------|
| **Modello** | Sincrono, bloccante | Asincrono, non-bloccante |
| **Performance** | Overhead RPC | Zero-copy possibile |
| **Scalabilità** | Thread per connection | Event-driven, migliaia di connessioni |
| **Timeout** | Complesso | Nativo con timers |
| **Backpressure** | Limitato | Flow control integrato |
| **Footprint** | Heavy | Lightweight, header-only |

#### Handlers ASIO

```cpp
class ConnectionHandler
{
    void HandleConnection(ASIO_CONNECTION_EVENT event);
    void SendResponse(void* data, size_t length);
};

class RfcqConnectionHandler : public ConnectionHandler
{
    void HandleRFCQConnection(ASIO_RFCQ_REQUEST& request);
};
```

**Eventi gestiti:**
- `ASIO_CONNECT`: nuova connessione
- `ASIO_DISCONNECT`: chiusura connessione
- `ASIO_DATA_RECEIVED`: dati ricevuti
- `ASIO_ERROR`: errore I/O

### Sequence Generators

Pattern per generazione ID univoci distribuiti con garanzie di unicità globale:

```cpp
class Sequence
{
    private:
    static Mutex _paramUpdMutex;
    static unsigned long _paramUpdId;
    
    public:
    static unsigned long GetParamUpdId()
    {
        unsigned long id = 0;
        try {
            _paramUpdMutex.Lock();
            
            // Genera timestamp
            id = DateTime32::NowAsLong();
            
            // Garantisce monotonia
            if (id <= _paramUpdId) {
                _paramUpdId = DateTime32::AddMillisecToTimeStamp(_paramUpdId, 1);
                id = _paramUpdId;
            } else {
                _paramUpdId = id;
            }
            
            _paramUpdMutex.Unlock();
        }
        catch (...) {
            _paramUpdMutex.Unlock();
            throw;
        }
        
        // Prefisso con ClusterId per unicità globale
        return (MSInstanceInformation::ClusterId() * 1000000000) + id;
    }
};
```

**Garanzie:**
- ✅ **Thread-safe**: mutex su strutture condivise
- ✅ **Unicità locale**: timestamp + incremento monotono
- ✅ **Unicità globale**: prefisso ClusterId
- ✅ **Ordinamento**: ID crescenti nel tempo

**Formato ID:**
```
[ClusterId: 3 digit] [Timestamp: 9 digit]
Esempio: 1000001234567890
         ^ Cluster 1
            ^^^^^^^^^^^^^^ Timestamp in millisecondi
```

### Managers & Interfaces

#### Pattern Singleton per Manager

```cpp
class MemberManagerInterface
{
    private:
    static MemberManagerInterface* _instance;
    std::vector<MemberManager*> _managerPerSubCluster;
    
    public:
    static MemberManagerInterface* GetInstance(Connection* connection);
    
    void CreateMemberManager(SubClusterId subClusterId, Connection* connection);
    MemberManager* GetMemberManager(SubClusterId subClusterId);
};
```

**Manager Principali:**

| Manager | Responsabilità |
|---------|----------------|
| **MarketManager** | Configurazione mercato, sezioni, fasi |
| **MemberManager** | Anagrafica membri, trader, permessi |
| **InstrumentManager** | Strumenti finanziari, caratteristiche |
| **CacheManager** | Gestione cache locali (trade registration, etc.) |
| **DataGridManager** | Interfaccia con JBoss DataGrid |
| **PortfolioManager** | Gestione portfolio, dealer groups |
| **RfcqCommonManager** | Logica comune RFCQ |

**Ogni Manager:**
- Ha un'interfaccia singleton per accesso globale
- Viene istanziato una volta per sub-cluster
- Mantiene stato locale isolato
- Fornisce metodi thread-safe

#### CalculationData

Componente speciale per dati di calcolo:

```cpp
Calculation::CalculationDataInterface* calculationDataInterface = 
    Calculation::CalculationDataInterface::GetInstance(_connection);

calculationDataInterface->CreateCalculationData(subClusterId, connection);
```

Fornisce:
- Curve di prezzo
- Tassi di interesse
- Parametri di calcolo yield/price
- Dati di mercato real-time

### Timers e Scheduled Tasks

#### Cutoff Timers

```cpp
void SwitchMessage::SetCutoffTimers()
{
    // Lettura configurazione cutoff da DB
    DataSet cutoffDataSet = ...;
    
    while (cutoffDataSet.Next())
    {
        uint64_t cutoffTime = cutoffDataSet.GetFieldValue("CUTOFF_TIME").AsLong();
        
        // Creazione timer per cutoff
        Timer::Create(
            cutoffTime,                    // Tempo di attivazione
            SendCutoff,                    // Callback
            new BV_CUTOFF(cutoffDataSet)   // User data
        );
    }
}

void SwitchMessage::SendCutoff(BV_CUTOFF* cutoff)
{
    // Pubblicazione AMQP
    MessageServer::EnterAMQP(BV_CUTOFF_ID, 0, cutoff->Data(), EntityADD, 0, 0);
    
    // Pubblicazione IDP (per compatibilità legacy)
    MessageServer::GetInstance()->EnterIDP(BV_CUTOFF_ID, cutoff->Data(), EntityADD, true);
    
    delete cutoff;
}
```

**Timers supportati:**
- One-shot: esecuzione singola
- Recurring: esecuzione ripetuta
- Drift-compensation: correzione drift clock

### Gestione Errori & Rollback

#### Pattern Try-Catch con Rollback

```cpp
void MsgTraderStatus::PrepareForAdd()
{
    try {
        // Operazioni su manager
        _memberManager->SetTraderStatus(...);
        
        // Operazioni su cache
        _cacheManager->InsertTrader(_msgReceived);
        
        // Operazioni su DB
        GetConnectionInUse()->ExecuteCommand(...);
        
        // Commit atomico
        _cacheManager->Commit();
        GetConnectionInUse()->Commit();
    }
    catch (MarketException& ex) {
        // Rollback cache
        _cacheManager->Rollback();
        
        // Rollback DB
        GetConnectionInUse()->Rollback();
        
        // Re-throw
        throw;
    }
    catch (...) {
        _cacheManager->Rollback();
        GetConnectionInUse()->Rollback();
        throw;
    }
}
```

**Livelli di Rollback:**
1. **Cache in-memory**: immediato, no side-effects
2. **Cache DataGrid**: distributed transaction rollback
3. **Database Oracle**: transactional rollback
4. **AMQP**: no rollback (compensating transactions)

#### Exception Handling

```cpp
// Eccezioni tipizzate
Components::Exception::MarketException* Exceptions::_doubleException = 
    new MarketException("Invalid data", TI_ERROR_InvalidData);

// Codici errore standard
MessageServer::SetGenericExceptionCode(TI_ERROR_InternalError);
MessageServer::SetDataBaseExceptionCode(TI_ERROR_InternalDatabaseError);
MessageServer::SetDataGridExceptionCode(TI_ERROR_DataGridError);
```

### Tracing & Monitoring

#### Tracing Multi-Livello

```cpp
// Trace levels
TL_Critical  // Solo errori critici
TL_Error     // Errori
TL_Warning   // Warning
TL_Info      // Informazioni generali
TL_Debug     // Debug dettagliato
TL_Verbose   // Tutto

// Esempio utilizzo
TRACE(TL_Info, "MsgTraderStatus::PrepareForAdd - MemberId=%lu, TraderId=%lu", 
      _msgReceived.getMemberId(), _msgReceived.getTraderId());

TRACEDUMP("Message received", &_msgReceived);  // Dump completo struttura
```

#### Performance Analyzer

```cpp
// Statistiche per SLA monitoring
class PerformanceAnalyzer
{
    void RecordTransactionTime(ClassId_t classId, uint64_t duration);
    void RecordQueueDepth(SubClusterId subClusterId, size_t depth);
    void RecordThroughput(ClassId_t classId, size_t count);
};
```

**Metriche raccolte:**
- Latenza per tipo messaggio
- Throughput per sub-cluster
- Profondità code
- Hit rate cache
- Errori per componente

### Data Grid Integration

#### Configurazione Remote Cache

```cpp
class DataGridConnectionInfo
{
    typedef std::map<unsigned long, ExtDepthInfo> ExtDepthInfoMap;
    
    static ExtDepthInfoMap _bvInventoryDepthByServiceIdMap;
    static ExtDepthInfoMap _bvIOIDepthByServiceIdMap;
    static ExtDepthInfoMap _bvPortfolioPreviewByServiceIdMap;
};
```

#### Pubblicazione su DataGrid

```cpp
void DataGridManager::PublishToDataGrid(const BV_INVENTORY_DEPTH& depth)
{
    // Recupera configurazione cache remota
    ExtDepthInfo& info = DataGridConnectionInfo::_bvInventoryDepthByServiceIdMap[serviceId];
    
    // Pubblicazione
    CacheBook* remoteCache = info.cache;
    remoteCache->Insert(depth);
    remoteCache->Commit();  // Commit su JBoss DataGrid
}
```

**Caratteristiche DataGrid:**
- **Replication**: sincrona o asincrona tra nodi
- **Partitioning**: sharding automatico per chiave
- **Eviction**: LRU, LIRS, UNORDERED
- **Expiration**: TTL su entries
- **Listeners**: callback su eventi cache

### Configuration Management

#### Lettura Configurazione DB

```cpp
// Configurazione clustering
const char* CLUSTER_ALLOCATION_QUERY = 
    "SELECT AUTOEXECUTIONRULEOWNERSHIPFG, MEMBERID "
    "FROM V_BV_MEMBER_PRIVATE_INFO "
    "WHERE MEMBERID IN (SELECT TOKENCLUSTERED "
    "                   FROM CONF_CUR_CLUSTER_ALLOCATION "
    "                   WHERE COMPONENTID = %d AND CLUSTERID = %d)";

Command* cmd = new Command(_connection, CLUSTER_ALLOCATION_QUERY);
cmd->SetParameter(1, componentId);
cmd->SetParameter(2, clusterId);
DataSet dataSet = cmd->ExecuteQuery();
```

#### Parametri Runtime

```cpp
// Lettura parametri da command-line
Components::ParamReader param;

param.Read("-tradingSummaryTimer", Parameters::_tradingSummaryTimer);
param.Read("-listingTimer", Parameters::_listingTimer);
param.Read("-doubleTolerance", tolerance);
param.Read("-algoInfoValidation", Parameters::_algoInfoValidation);

// Default values se non specificati
Parameters::_tradingSummaryTimer = Parameters::_tradingSummaryTimer ?: 1000000;
```

### Best Practices & Patterns

#### 1. Separation of Concerns
- **Interface**: singleton, thread-safe, accesso globale
- **Implementation**: per-subcluster, isolato, no shared state
- **Cache**: astrazione storage, swappable backend

#### 2. Fail-Fast Validation
```cpp
bool CheckValidity() 
{
    // Validazioni quick fail prima di operazioni pesanti
    if (marketId != EXPECTED) return false;
    if (date != today) return false;
    if (timestamp <= cached) return false;
    return true;
}
```

#### 3. Optimistic Locking
```cpp
// Versioning basato su timestamp
if (_msgFromCache->UpdateTime >= _msgReceived.getUpdateTime())
{
    throw MarketException("Stale update", TI_ERROR_OptimisticLockFailed);
}
```

#### 4. Copy-on-Write per Snapshots
```cpp
// Snapshot isolato per long-running queries
CacheBook* snapshot = _mainCache->Copy();
// Lavoro su snapshot senza bloccare la cache principale
```

#### 5. Resource Acquisition Is Initialization (RAII)
```cpp
Mutex::Lock();
try {
    // Critical section
    Mutex::Unlock();
} catch (...) {
    Mutex::Unlock();
    throw;
}
```

### Flusso Completo: Da Transazione a Pubblicazione

```
1. AP riceve transazione SDP/FIX da client
         ↓
2. AP invia via ASIO (o CORBA solo per PAF) al componente BE (es. MSM)
         ↓
3. MessageServer riceve e accoda messaggio
         ↓
4. Switcher estrae ValueId e determina SubCluster target
         ↓
5. SubCluster dequeue messaggio e crea MessageHandler
         ↓
6. MessageHandler.SetMessage() riceve dati
         ↓
7. MessageHandler.CheckValidity() valida business logic
         ↓
8. MessageHandler.PrepareForAdd/Edit/Del() esegue logica
   - Aggiorna Manager locali (in-memory)
   - Aggiorna Cache (DB/DataGrid)
   - Esegue query DB se necessario
   - Commit atomico
         ↓
9. Framework pubblica automaticamente su AMQP
   - EnterAMQP per info pubbliche/private
   - EnterMRG per information bus cross-market
   - EnterIDP per compatibilità legacy
         ↓
10. Consumer AMQP ricevono messaggi:
    - AP per push ai client (IDP)
    - Datafeed per feeding esterno
    - Altri componenti BE per reazioni
    - Fill Manager per post-trading
         ↓
11. Performance Analyzer registra metriche SLA
```

---

## Glossario Componenti

| Acronimo | Nome Completo | Descrizione |
|----------|---------------|-------------|
| **AP** | Access Point | Entry point mercato |
| **AT** | Auto Trader | Matching engine automatico |
| **BS** | Best Server | Generazione info Best |
| **CE** | Contribution Engine | Generazione info pubbliche |
| **DBD** | DB Data Distribution | Distribuzione dati DB |
| **DBW** | DB Writer | Scrittura asincrona su DB |
| **DF** | DataFeed | Sistema feed dati |
| **DIP** | Depth Info Server | Server informazioni depth |
| **ECE** | External Contribution Engine | Engine contributi esterni |
| **FM** | Fill Manager | Gestione fill post-trading |
| **GOV** | Governance | Governance mercato |
| **IBDS** | Inventory By Dealer Server | Server inventario per dealer |
| **IDS** | Inventory Depth Server | Server depth inventario |
| **IOIS** | Indication Of Interest Server | Server IOI |
| **IPSP** | IP Service Provider | Service provider IP |
| **IQE** | Inventory Quotes Engine | Engine quote inventario |
| **MON** | Monitor | Monitoraggio sistema |
| **MPE** | Mid Price Engine | Engine prezzo medio |
| **MSM** | Market Service Manager | Manager servizi mercato |
| **OSM** | Order Staging Manager | Manager staging ordini |
| **PA** | Performance Analyzer | Analizzatore performance |
| **PS** | Push Server | Server push info |
| **PSM** | Platform Service Manager | Manager servizi piattaforma |
| **QM** | Query Manager | Manager query storiche |
| **RAP** | RFCQ Auto Player | Auto player RFCQ |
| **RME** | RFCQ Matching Engine | Matching engine RFCQ |
| **RRV** | RFCQ Request Validator | Validatore richieste RFCQ |
| **TSM** | Trader Status Manager | Manager stato trader |
| **VAM** | Virtual Access Manager | Manager accesso virtuale |
| **YASS** | Yet Another Services Server | Server gestione servizi |

---

## Note Tecniche

### Linguaggi di Programmazione
- **C++**: maggior parte componenti Trade Impact core
- **Java**: MTS Datafeed microservices, integrazioni Refinitiv
- **SQL/PL-SQL**: stored procedures, configurazioni DB

### Database
- **Oracle**: Trading DB, Historical DB, Anagrafica

### Message Brokers
- **Apache QPID**: alto volume (in dismissione → Artemis)
- **RabbitMQ**: microservizi Datafeed
- **Apache Artemis**: sostituto futuro di QPID e IDP

### Container & Orchestration
- **Docker**: containerizzazione microservizi
- **Kubernetes**: orchestrazione container (MTS Datafeed)

### Frameworks
- **Spring Boot**: framework microservizi Java
- **CORBA**: middleware transazionale (solo PAF, legacy)
- **boost.ASIO**: comunicazione client-server asincrona (CMF, BV, MMF)

### Conversione Tipi SDP → C++
Quando si implementano componenti C++ che utilizzano classi generate dal protocollo SDP, seguire questa tabella di conversione:

| Tipo SDP | Tipo C++ | Note |
|----------|----------|------|
| `ULONG` | `unsigned long` | Intero senza segno a 32/64 bit (dipende dalla piattaforma) |
| `LDATE` | `unsigned long` | Data in formato Julian (numero di giorni da epoch) |
| `UTIME` | `uint64_t` | Timestamp in microsecondi da epoch |
| `ENUM` | `unsigned int` | Enumerazione gestita come tipo enum specifico |

**Esempi di utilizzo:**
```cpp
// ✅ CORRETTO - Utilizzo tipi C++ standard
unsigned long memberId = config.getMemberId();
unsigned long tradeDate = trade.getDate();
uint64_t tradeTime = trade.getTime();

// ❌ ERRATO - Tipi SDP non definiti nel framework
ULONG memberId = config.getMemberId();  // ULONG non esiste
LDATE tradeDate = trade.getDate();      // LDATE non esiste
UTIME tradeTime = trade.getTime();      // UTIME non esiste
```

**NOTA IMPORTANTE**: I tipi `ULONG`, `LDATE`, `UTIME` sono convenzioni della documentazione del protocollo SDP, ma NON sono typedef definiti nel framework MTS. Utilizzare sempre i tipi C++ standard equivalenti nelle implementazioni.

### Best Practices per Tracing

Quando si aggiungono chiamate TRACE nel codice, seguire queste linee guida:

**Livelli di Tracing:**
- **TL_Info** (default): Utilizzare come livello di default per informazioni generali sul flusso di esecuzione
- **TL_Warning**: Situazioni anomale che non bloccano l'esecuzione ma richiedono attenzione
- **TL_Error**: Errori che impediscono il completamento dell'operazione
- **TL_Debug**: Solo per debugging dettagliato (da evitare come default)

**Esempi:**
```cpp
// ✅ CORRETTO - TL_Info come default per flusso normale
TRACE(TL_Info, "MsgHandler::ProcessMessage - Processing message type %d", msgType);

// ✅ CORRETTO - TL_Warning per condizioni anomale non bloccanti
TRACE(TL_Warning, "Cache::CheckLimit - Limit approaching: current=%u, max=%u", current, max);

// ✅ CORRETTO - TL_Error per errori che bloccano l'esecuzione
TRACE(TL_Error, "Database::Connect - Connection failed: %s", errorMsg);

// ❌ EVITARE - TL_Debug come default (riservato a debugging specifico)
TRACE(TL_Debug, "RoutineOperation - Value=%d", value);
```

**Regola generale**: Iniziare sempre con `TL_Info` per nuove trace; sarà lo sviluppatore a modificare il livello successivamente se necessario per debugging o ottimizzazione dei log.

---

## Differenze Architetturali: Trade Impact vs MTS Datafeed

| Aspetto | Trade Impact | MTS Datafeed |
|---------|--------------|--------------|
| **Linguaggio** | C++ | Java |
| **Architettura** | Monolitica component-based | Microservizi |
| **Deployment** | Processi standalone | Container Docker su Kubernetes |
| **Comunicazione AP-BE** | boost.ASIO (CMF/BV/MMF), CORBA (PAF legacy) | - |
| **Comunicazione Interna** | boost.ASIO + IDP + AMQP | RabbitMQ (tra microservizi) |
| **Broker AMQP** | Apache QPID | RabbitMQ |
| **Cache** | JBoss DataGrid (Infinispan) | Apache Ignite |
| **Scalabilità** | Clusterization + Sub-clusterization | Kubernetes horizontal scaling |

---

*Documento generato da: Presentazione ENXT.pptx*  
*Data estrazione: 20 Gennaio 2026*

---

## Sessione di Sviluppo: 11 Febbraio 2026

### Implementazione WebSocket per Streaming Dati di Mercato in Tempo Reale

#### Problema Risolto
I dati di sottoscrizione arrivavano correttamente al backend dall'Access Point ma non erano visibili nel frontend. Implementato meccanismo di push real-time per trasmettere i dati al browser via WebSocket + persistenza automatica su database H2 locale.

#### Architettura Implementata

```
Access Point (10.232.92.86:22034) → [SDP] → SDPConnection.onSubscribeData()
                                                       ↓
                                          MarketDataWebSocketHandler
                                         /                      \
                                        /                        \
                            [WebSocket Push]              [Async DB Save]
                                   ↓                              ↓
                         Browser (Real-time)               H2 Database
                              ↓                          (MARKET_DATA_RECORD)
                   📡 Live indicator + Stream
```

#### File Backend Modificati/Creati

**MarketDataWebSocketHandler.java** (NUOVO)
- Gestione connessioni WebSocket con `ConcurrentHashMap<String, WebSocketSession>`
- Metodo `broadcastMarketData(Long classId, String className, Object data)`
- Formato JSON: `{type: "marketData", classId, className, data, timestamp}`
- Salvataggio asincrono DB tramite `MarketDataService`

**MarketDataService.java** (NUOVO)
- Salvataggio asincrono (`@Async`) su tabella `MARKET_DATA_RECORD`
- Campi: `class_id`, `class_name`, `json_data`, `action`, `received_at`

**WebSocketConfig.java** (AGGIORNATO)
- Registrato endpoint: `/ws/marketdata`
- CORS abilitato: `setAllowedOrigins("*")`

**SDPConnection.java** (AGGIORNATO)
- Campo `private Object webSocketHandler` (reflection per evitare dipendenze circolari)
- Metodo `setWebSocketHandler(Object handler)`
- `onSubscribeData()` chiama `broadcastMarketData()` via reflection
- Fix conversione: `ULong → Long` con `Long.valueOf(ulongValue.toString())`

**SDPConnectionPool.java** (AGGIORNATO)
- Dependency injection di `MarketDataWebSocketHandler`
- Chiamata `connection.setWebSocketHandler(webSocketHandler)` dopo ogni `new SDPConnection()`

#### File Frontend Creati/Aggiornati

**useMarketDataWebSocket.js** (NUOVO)
- Custom React hook per gestione WebSocket
- Auto-connect al mount, auto-reconnect ogni 3s se disconnesso
- Stato: `{isConnected, marketData, error}`

**ClassSubscription.jsx** (AGGIORNATO)
- Status connessione: 🟢 Connesso / 🔴 Disconnesso
- Indicatore live: 📡 accanto alle classi con dati attivi
- Timestamp ultimo aggiornamento

**ClassSubscription.css** (AGGIORNATO)
- Stili per status WebSocket, indicatori live, animazione pulse

**MarketDataViewer.jsx** + **MarketDataViewer.css** (CREATI)
- Componente per visualizzazione stream completo
- Filtri per classe, grid layout, auto-scroll

**App.jsx + Header.jsx** (AGGIORNATI)
- Route `/marketdata` per viewer
- Link "Live Data" in menu

#### Database H2 Locale

**Configurazione**
```
URL: http://localhost:8080/h2-console
JDBC: jdbc:h2:file:./data/tradeimpact
User: sa / Password: password
```

**Query Utili**
```sql
-- Ultimi 100 dati ricevuti
SELECT * FROM MARKET_DATA_RECORD ORDER BY RECEIVED_AT DESC LIMIT 100;

-- Conteggio per classe
SELECT CLASS_NAME, COUNT(*) as TOTAL FROM MARKET_DATA_RECORD GROUP BY CLASS_NAME;

-- Dati ultime 24h
SELECT * FROM MARKET_DATA_RECORD 
WHERE RECEIVED_AT > CURRENT_TIMESTAMP - INTERVAL '24' HOUR;
```

#### Deployment

```bash
cd /home/OAD/drosso/git/HtmlDriver/TradeImpactWeb

# Build completo (include frontend React + backend Maven)
./docker-build.sh

# Avvio
./docker-run.sh

# Oppure con docker-compose
docker compose up -d --build
docker compose logs -f | grep -i websocket
```

#### Test WebSocket da Browser Console

```javascript
const ws = new WebSocket('ws://localhost:8080/ws/marketdata');
ws.onopen = () => console.log('✅ Connesso');
ws.onmessage = (e) => console.log('📊 Dati:', JSON.parse(e.data));
```

#### Workflow Utente

1. Login → Menu "Subscriptions" → Seleziona classi → "Sottoscrivi"
2. Verifica 🟢 Connesso + indicatore 📡 sulle classi attive
3. Menu "Live Data" → Stream completo in tempo reale
4. H2 Console → Query storico dati salvati

#### Pattern Implementati

- **Reflection**: Disaccoppiamento SDPConnection ↔ WebSocketHandler
- **Observer**: WebSocket clients registrati per broadcast
- **Async**: Salvataggio DB non bloccante con `@Async`
- **Thread-Safety**: `ConcurrentHashMap` + `synchronized(session)`
- **Try-Finally**: Rilascio connessioni pool garantito

#### Compilazione Verificata

```
mvn clean compile -DskipTests
[INFO] BUILD SUCCESS - 33 source files compiled
```

#### Configurazione SDP (Non Modificata)

- IPSP: 10.232.92.86:12001
- INFO_BRT AP: 10.232.92.86:22034 (BV platform)
- Classi: 386 da `/app/config/classes_BV.csv`
- ServiceType: INFO_BRT (ID=2) per sottoscrizioni broadcast

---

**Stato: ✅ Pronto per deployment**  
**Build: Compilazione backend verificata, frontend da compilare in Docker**

