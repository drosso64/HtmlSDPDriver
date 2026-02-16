# SDP Protocol Architecture

## Overview
The SDP (Structured Data Protocol) is a 3-layer protocol for communicating with TradeImpact servers:

```
┌─────────────────────────────────────┐
│   SMP (Market Protocol)             │  ← Market-specific messages (loaded dynamically)
├─────────────────────────────────────┤
│   SAP (Application Protocol)        │  ← Login, subscriptions, queries
├─────────────────────────────────────┤
│   SSP (Session Protocol)            │  ← Connection management, keepalive
└─────────────────────────────────────┘
         │
         ▼
    TCP/IP + XDR Serialization
```

## Available Classes in sdp-protocol-5.0.0-jar-with-dependencies.jar

### NIO Layer (com.mtsmarkets.nio)
- **NioClient**: Low-level TCP/NIO client for socket communication
- **ClientHandler**: Handler interface for processing received data
- **Worker**: Background processing threads

### SSP - Session Protocol (com.mtsmarkets.sdp.ssp)
Message classes for session management:
- **SSPConOpenReq / SSPConOpenRes**: Open connection
- **SSPConCloseReq / SSPConCloseRes**: Close connection
- **SSPConAlive**: Keepalive heartbeat
- **SSPConProbeReq / SSPConProbeRes**: Connection probe
- **SSPSendMsg / SSPSendMsgAck**: Send/Ack messages (wraps SAP messages)
- **SSPSendData**: Send data
- **SSPErrorMsg**: Error messages

### SAP - Application Protocol (com.mtsmarkets.sdp.sap)
Message classes for application-level operations:
- **SAPLogonReq / SAPLogonRes**: Login with username/password
- **SAPLogonTokenReq / SAPLogonTokenRes**: Token-based login
- **SAPLogoffReq**: Logout
- **SAPChangePasswordReq / SAPChangePasswordRes**: Password change
- **SAPSubscribeStartReq / SAPSubscribeStartRes**: Start subscription
- **SAPSubscribeStopReq**: Stop subscription
- **SAPSubscribeIdle**: Subscription idle notification
- **SAPQueryRowsDataReq / SAPQueryRowsData**: Query rows
- **SAPQueryDestroyReq**: Destroy query
- **SAPFilterCreateRes**: Create filter
- **SAPActionReq / SAPActionRes**: Generic action
- **SAPErrorMsg**: Error messages

### SMP - Market Protocol (com.mtsmarkets.sdp.smp)
- **SMPMessage**: Base class for all market-specific messages
- **TI_DESC_CLASS**: Market class metadata (CLASS_ID = 100049)
- **TI_DESC_CLASS_FIELD**: Field metadata
- **TI_DESC_FIELD_TYPE_Enum**: Field type enumeration
- **TI_DESC_ENTITY_TYPE_Enum**: Entity type enumeration
- **TI_DESC_CLASS_KEY**: Key metadata
- **MarketFactory**: Factory for creating market-specific message instances

### Serialization (com.mtsmarkets.sdp.serializer / deserializer)
- **SDPSerializer**: Serialize SSP messages to XDR ByteBuffer
- **SDPDeserializer / SDPDeserializerAsync / SDPDeserializerSync**: Deserialize XDR to messages
- **SAPPublisher / SSPPublisher**: Publish received messages to listeners
- **SAPNotify / SSPNotify**: Notification interfaces

### XDR Encoding (com.mtsmarkets.io.xdr)
- **XDRByteBuffer**: ByteBuffer wrapper for XDR encoding
- **XDRable**: Interface for XDR serializable objects
- **ULong, UInt, UShort**: Unsigned integer types
- **BigLong**: 64-bit integer

## Communication Flow

### 1. Connection Establishment
```
Client                          Server
  │                               │
  ├─ TCP Connect ────────────────>│
  │                               │
  ├─ SSPConOpenReq ──────────────>│
  │<────────────────── SSPConOpenRes │
  │                               │
  ├─ SSPSendMsg(SAPLogonReq) ───>│
  │<────────────── SSPSendMsg(SAPLogonRes) │
  │                               │
```

### 2. Subscription
```
Client                                    Server
  │                                         │
  ├─ SSPSendMsg(SAPSubscribeStartReq) ───>│
  │<──────────────────────────── SSPSendMsg(SAPSubscribeStartRes) │
  │                                         │
  │<──────────────────────────── SSPSendMsg(SMP Market Data) │
  │<──────────────────────────── SSPSendMsg(SMP Market Data) │
  │<──────────────────────────── SSPSendMsg(SMP Market Data) │
  ...                                      ...
```

### 3. Query
```
Client                                  Server
  │                                       │
  ├─ SSPSendMsg(SAPQueryRowsDataReq) ──>│
  │<────────────────────── SSPSendMsg(SAPQueryRowsData) │
  │                                       │
  ├─ SSPSendMsg(SAPQueryDestroyReq) ───>│
  │                                       │
```

### 4. Heartbeat
```
Client                  Server
  │                       │
  ├─ SSPConAlive ───────>│
  │<────────── SSPConAlive │
  │                       │
  ... every N seconds ...
```

## Implementation Strategy

### SDPConnection Class
Must implement:
1. **TCP Connection**: Use `NioClient` to establish socket connection
2. **Message Serialization**: Use `SDPSerializer` to serialize SSP messages to XDR
3. **Message Deserialization**: Use `SDPDeserializer` to parse incoming XDR bytes
4. **Session Management**: Handle SSP connection lifecycle (open, keepalive, close)
5. **Login**: Send SAPLogonReq wrapped in SSPSendMsg
6. **Asynchronous Handling**: Implement `ClientHandler` to process incoming messages

### ClassMetadataRepository Class
Must implement:
1. **Query TI_DESC_CLASS**: Send SAPQueryRowsDataReq for CLASS_ID = 100049
2. **Parse Results**: Deserialize TI_DESC_CLASS instances from query response
3. **Query TI_DESC_CLASS_FIELD**: For each class, query its fields
4. **Cache**: Store class metadata to avoid repeated queries

### MarketFactory
- Used to create instances of dynamically loaded SMP classes
- Must be configured with the `ClassLoader` from `SDPClassLoaderService`
- Allows instantiation of market-specific classes by name or CLASS_ID

## Key Differences from Original Design

| Original Assumption | Reality |
|-------------------|---------|
| `SSPClient` class exists | ❌ No - must use `NioClient` + message classes |
| `SAPClient` class exists | ❌ No - must use message classes directly |
| High-level API | ❌ No - low-level message protocol only |
| Synchronous operations | ❌ No - asynchronous NIO with callbacks |

## Next Steps

1. ✅ Understand JAR structure and available classes
2. ⏳ Refactor `SDPConnection` to use `NioClient` + `SDPSerializer/Deserializer`
3. ⏳ Implement `ClientHandler` for async message processing
4. ⏳ Implement login flow with `SAPLogonReq/Res`
5. ⏳ Implement metadata query with `TI_DESC_CLASS`
6. ⏳ Implement subscription with `SAPSubscribeStartReq`
7. ⏳ Test connection with real TradeImpact server
