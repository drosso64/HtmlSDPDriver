# Transaction API Documentation

## Overview

Il Transaction API permette l'esecuzione di transazioni (ADD/DEL/RWT/KILL) sulle classi di dati del mercato attraverso il protocollo SDP.

## Architettura

```
Frontend Request
      ↓
TransactionController (REST API)
      ↓
TransactionService (Business Logic)
      ↓
SDPConnectionPool.getTransactionConnection()
      ↓
SDPConnection.sendTransaction() / sendMonitoredTransaction() / sendExtendedTransaction()
      ↓
SAPTransactionChannel → TradeImpact Server
      ↓
onTransaction() / onTransactionMonitored() / onTransactionExtended() (Response Callback)
      ↓
CompletableFuture.complete()
      ↓
TransactionResponse → Frontend
```

## REST API Endpoints

### 1. Execute Standard Transaction

**POST** `/api/transactions`

Esegue una transazione standard (SAPActionReq).

**Request Body:**
```json
{
  "username": "trader1",
  "classId": "BV_MARKET_ORDER",
  "action": "ADD",
  "referenceId": "optional-tracking-id",
  "data": {
    "InstrumentId": 12345,
    "BuySell": "BUY",
    "Quantity": 1000000,
    "Price": 99.50,
    "TraderAccountId": 100
  }
}
```

**Response:**
```json
{
  "success": true,
  "message": "SDP_OK",
  "transactionId": 123456,
  "referenceId": "optional-tracking-id",
  "errorCode": null
}
```

**Error Response:**
```json
{
  "success": false,
  "message": "SDP_ERR_INVALID_PARAMETER",
  "errorCode": 5,
  "referenceId": "optional-tracking-id"
}
```

### 2. Execute Monitored Transaction

**POST** `/api/transactions/monitored`

Esegue una transazione con monitoring (SAPMonitoredActionReq). Permette di tracciare il ciclo di vita della transazione attraverso status update.

**Request Body:**
```json
{
  "username": "trader1",
  "classId": "BV_IOI",
  "action": "ADD",
  "data": {
    "InstrumentId": 12345,
    "BuySell": "BUY",
    "Quantity": 5000000,
    "IOIType": "INDICATION"
  }
}
```

**Response:**
```json
{
  "success": true,
  "message": "SDP_OK",
  "transactionId": 123457,
  "monitoringId": 98765,
  "errorCode": null
}
```

### 3. Execute Extended Transaction

**POST** `/api/transactions/extended`

Esegue una transazione estesa (SAPExtActionReq) con campi addizionali.

**Request Body:**
```json
{
  "username": "trader1",
  "classId": "BV_MARKET_ORDER",
  "action": "RWT",
  "data": {
    "OrderId": 999,
    "Quantity": 2000000,
    "Price": 100.25
  }
}
```

## Transaction Actions

| Action | Description | Use Case |
|--------|-------------|----------|
| **ADD** | Inserisce un nuovo record | Creazione di un nuovo ordine, IOI, quote |
| **DEL** | Elimina un record esistente | Cancellazione ordine, rimozione quote |
| **RWT** | Modifica (rewrite) un record esistente | Modifica quantità/prezzo ordine |
| **KILL** | Forza eliminazione/cancellazione | Cancellazione forzata in situazioni di emergenza |

## Examples

### Example 1: Add Market Order (BV_MARKET_ORDER)

```bash
curl -X POST http://localhost:8081/api/transactions \
  -H "Content-Type: application/json" \
  -d '{
    "username": "trader1",
    "classId": "BV_MARKET_ORDER",
    "action": "ADD",
    "data": {
      "InstrumentId": 12345,
      "BuySell": "BUY",
      "Quantity": 1000000,
      "Price": 99.50,
      "TraderAccountId": 100,
      "OrderType": "LIMIT"
    }
  }'
```

**Response:**
```json
{
  "success": true,
  "message": "SDP_OK",
  "transactionId": 123456
}
```

### Example 2: Modify Order (RWT)

```bash
curl -X POST http://localhost:8081/api/transactions \
  -H "Content-Type: application/json" \
  -d '{
    "username": "trader1",
    "classId": "BV_MARKET_ORDER",
    "action": "RWT",
    "data": {
      "OrderId": 123456,
      "Quantity": 2000000,
      "Price": 100.00
    }
  }'
```

### Example 3: Delete Order (DEL)

```bash
curl -X POST http://localhost:8081/api/transactions \
  -H "Content-Type: application/json" \
  -d '{
    "username": "trader1",
    "classId": "BV_MARKET_ORDER",
    "action": "DEL",
    "data": {
      "OrderId": 123456
    }
  }'
```

### Example 4: Add IOI with Monitoring

```bash
curl -X POST http://localhost:8081/api/transactions/monitored \
  -H "Content-Type: application/json" \
  -d '{
    "username": "trader1",
    "classId": "BV_IOI",
    "action": "ADD",
    "data": {
      "InstrumentId": 12345,
      "BuySell": "SELL",
      "Quantity": 5000000,
      "IOIType": "INDICATION",
      "ValidUntil": "2026-02-11T18:00:00Z"
    }
  }'
```

**Response:**
```json
{
  "success": true,
  "message": "SDP_OK",
  "transactionId": 123457,
  "monitoringId": 98765
}
```

## Data Type Conversion

Il sistema converte automaticamente i tipi di dati dal JSON ai tipi Java:

| JSON Type | Java Type | Notes |
|-----------|-----------|-------|
| Number (int) | int, Integer, long, Long | Auto-conversion |
| Number (float) | float, Float, double, Double | Auto-conversion |
| String | String | Direct assignment |
| String (enum) | Enum | Parsed to enum value |
| Boolean | boolean, Boolean | Direct assignment |

**Example:**
```json
{
  "InstrumentId": 12345,           // → Long or Integer
  "Price": 99.50,                  // → Double or Float
  "BuySell": "BUY",                // → String or Enum
  "IsActive": true                 // → Boolean
}
```

## Error Handling

### Common Error Codes

| Error Code | SDP Result | Description |
|------------|------------|-------------|
| 0 | SDP_OK | Success |
| 1 | SDP_ERR_GENERIC | Generic error |
| 3 | SDP_ERR_NOT_LOGGED_IN | Not logged in |
| 5 | SDP_ERR_INVALID_PARAMETER | Invalid parameter |
| 10 | SDP_ERR_NOT_AUTHORIZED | Not authorized |
| 15 | SDP_ERR_TIMEOUT | Timeout |

### Error Response Example

```json
{
  "success": false,
  "message": "SDP_ERR_INVALID_PARAMETER",
  "errorCode": 5
}
```

### Exception Handling

Il sistema gestisce diverse categorie di errori:

1. **Validation Errors** (400 Bad Request)
   - Username, classId, action, o data mancanti
   - Formato dati non valido

2. **Business Logic Errors** (500 Internal Server Error)
   - Connessione non disponibile
   - Classe non trovata nel JAR
   - Campo non valido per la classe

3. **SDP Protocol Errors** (200 OK con success: false)
   - Errori restituiti dal server TradeImpact
   - Errori di autorizzazione
   - Errori di validazione lato server

## Implementation Details

### TransactionService

```java
@Service
public class TransactionService {
    
    public TransactionResponse executeTransaction(TransactionRequest request) {
        // 1. Get connection from pool
        SDPConnection connection = connectionPool.getTransactionConnection();
        
        // 2. Create SMP message using reflection
        SMPMessage smpMessage = createSMPMessage(request);
        
        // 3. Send transaction and wait for response
        CompletableFuture<TransactionResponse> future = 
            connection.sendTransaction(smpMessage, request.getAction().name());
        
        // 4. Wait for response (30s timeout)
        return future.get(30, TimeUnit.SECONDS);
    }
}
```

### SDPConnection Transaction Methods

```java
public class SDPConnection {
    
    // Track pending transactions
    private final Map<Long, CompletableFuture<TransactionResponse>> pendingTransactions;
    private final AtomicLong transactionIdCounter = new AtomicLong(1);
    
    public CompletableFuture<TransactionResponse> sendTransaction(
            SMPMessage smpMessage, String action) {
        
        // Generate unique transaction ID
        long txnId = transactionIdCounter.getAndIncrement();
        
        // Create future for response
        CompletableFuture<TransactionResponse> future = new CompletableFuture<>();
        pendingTransactions.put(txnId, future);
        
        // Create and send SAPActionReq
        SAPActionReq request = new SAPActionReq(smpMessage);
        request.setTransactionId(txnId);
        transactionChannel.send(request);
        
        // Set 30s timeout
        future.orTimeout(30, TimeUnit.SECONDS);
        
        return future;
    }
}
```

### Response Callback

```java
@Override
public void onTransaction(SAPActionRes res) {
    // Find pending future by transaction ID
    CompletableFuture<TransactionResponse> future = 
        pendingTransactions.remove(res.getTransactionId());
    
    if (future != null) {
        // Build response
        TransactionResponse response = TransactionResponse.builder()
            .success(res.getResult() == SDPResult.SDP_OK)
            .message(res.getResult().name())
            .transactionId(res.getTransactionId())
            .errorCode(res.getResult().getCode())
            .build();
        
        // Complete the future
        future.complete(response);
    }
}
```

## Testing

### 1. Start Container

```bash
docker run -d --name bvf-market8 \
  -e MARKET_ID=8 \
  -e SDP_CLASSES_JAR=/app/libs/sdp-bvf.jar \
  -v /path/to/sdp-bvf.jar:/app/libs/sdp-bvf.jar \
  -p 8081:8080 \
  tradeimpact-web:latest
```

### 2. Login

```bash
curl -X POST http://localhost:8081/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "trader1",
    "password": "password",
    "ipspHost": "ipsp.example.com",
    "ipspPort": 8800
  }'
```

### 3. Execute Transaction

```bash
curl -X POST http://localhost:8081/api/transactions \
  -H "Content-Type: application/json" \
  -d '{
    "username": "trader1",
    "classId": "BV_MARKET_ORDER",
    "action": "ADD",
    "data": {
      "InstrumentId": 12345,
      "BuySell": "BUY",
      "Quantity": 1000000,
      "Price": 99.50
    }
  }'
```

### 4. Check Logs

```bash
docker logs -f bvf-market8 | grep -E 'Transaction|Action'
```

Expected logs:
```
Sending transaction: id=1 action=ADD class=BV_MARKET_ORDER
Transaction response: txnId=1 result=SDP_OK
```

## Best Practices

### 1. Connection Management

- Le connessioni vengono gestite automaticamente dal pool
- Non è necessario gestire manualmente il ciclo di vita delle connessioni
- Il pool garantisce il riuso delle connessioni

### 2. Error Handling

```javascript
// Frontend example
async function sendOrder(orderData) {
  try {
    const response = await fetch('/api/transactions', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        username: currentUser,
        classId: 'BV_MARKET_ORDER',
        action: 'ADD',
        referenceId: generateUUID(),
        data: orderData
      })
    });
    
    const result = await response.json();
    
    if (result.success) {
      console.log('Order sent successfully:', result.transactionId);
      return result.transactionId;
    } else {
      console.error('Order failed:', result.message);
      throw new Error(result.message);
    }
    
  } catch (error) {
    console.error('Network error:', error);
    throw error;
  }
}
```

### 3. Transaction Tracking

Usa `referenceId` per tracciare le transazioni:

```json
{
  "username": "trader1",
  "classId": "BV_MARKET_ORDER",
  "action": "ADD",
  "referenceId": "order-2026-02-11-001",
  "data": { ... }
}
```

Il `referenceId` viene restituito nella response per correlazione.

### 4. Monitored Transactions

Usa transazioni monitorate quando hai bisogno di tracking:

```javascript
// Send monitored transaction
const response = await fetch('/api/transactions/monitored', {
  method: 'POST',
  body: JSON.stringify(transactionRequest)
});

const result = await response.json();

if (result.success) {
  // Store monitoring ID for later status checks
  const monitoringId = result.monitoringId;
  // Subscribe to updates using monitoringId...
}
```

## Troubleshooting

### Transaction Timeout

**Sintomo:**
```
TimeoutException after 30 seconds
```

**Soluzioni:**
1. Verificare che la connessione TXN_INFO_PRIV sia attiva
2. Controllare i log del server per errori
3. Verificare i permessi dell'utente per quella classe

### Invalid Parameter Error

**Sintomo:**
```json
{
  "success": false,
  "message": "SDP_ERR_INVALID_PARAMETER",
  "errorCode": 5
}
```

**Soluzioni:**
1. Verificare che tutti i campi richiesti siano presenti
2. Controllare che i tipi di dati siano corretti
3. Verificare che i valori enum siano validi

### Class Not Found

**Sintomo:**
```
ClassNotFoundException: BV_MARKET_ORDER
```

**Soluzioni:**
1. Verificare che il JAR del mercato sia caricato
2. Controllare che il `classId` sia corretto (case-sensitive)
3. Verificare che la classe esista nel JAR con `list_jars`

### Not Logged In

**Sintomo:**
```json
{
  "success": false,
  "message": "No transaction connection available. Please login first."
}
```

**Soluzione:**
Eseguire il login prima di tentare transazioni:
```bash
curl -X POST http://localhost:8081/api/auth/login ...
```

## Summary

Il Transaction API fornisce:

✅ **3 tipi di transazioni**: Standard, Monitored, Extended  
✅ **4 azioni**: ADD, DEL, RWT, KILL  
✅ **Conversione automatica** dei tipi di dati  
✅ **Timeout management** (30 secondi)  
✅ **Error handling** completo  
✅ **Connection pooling** automatico  
✅ **Transaction tracking** con referenceId  
✅ **Async/Future pattern** per performance  

---

**Documento generato il**: 11 Febbraio 2026  
**Versione API**: 1.0.0  
**Status**: ✅ Implementazione Completa
