import React, { createContext, useContext, useEffect, useRef, useState, useCallback } from 'react';

/**
 * WebSocket Context - Connessione WebSocket Globale Condivisa
 * 
 * RUOLO NEL SISTEMA:
 * Mantiene una SINGOLA connessione WebSocket condivisa dall'intera applicazione.
 * Tutti i componenti che necessitano di dati real-time accedono a questo context.
 * 
 * FLUSSO DATI:
 * Backend (SpringBoot) → WebSocket → Questo Context → Componenti React
 * 
 * STATO GESTITO:
 * - allMessages: Map strutturata { classId: { hashKey: record } } con UPSERT semantics
 * - marketData: Oggetto con ultimo messaggio per ogni classe (key = classId)
 * - isConnected: Stato connessione WebSocket
 * 
 * STRATEGIA DI NOTIFICA:
 * Quando arriva un messaggio WebSocket:
 * 1. UPSERT in allMessages usando hashKey (update se esiste, insert se nuovo)
 * 2. Aggiorna marketData (ultimo valore per classe)
 * 3. Notifica tutti i messageHandlers registrati (pattern Observer)
 * 
 * UPSERT SEMANTICS:
 * Grazie alla struttura Map basata su hashKey, gli aggiornamenti dello stesso record
 * sovrascrivono il valore precedente invece di accumulare duplicati.
 * Questo previene memory bloat e riflette lo stesso comportamento del database.
 * 
 * @see ClassTabbedView.jsx - Consuma allMessages convertito in array
 * @see DynamicDataGrid.jsx - Renderizza dati in tabelle
 */
const WebSocketContext = createContext(null);

export const WebSocketProvider = ({ children }) => {
  const [isConnected, setIsConnected] = useState(false);
  const [marketData, setMarketData] = useState({});
  
  // NEW: UPSERT semantics using Map structure
  // allMessages: { classId: { hashKey: record } }
  // This prevents memory bloat by updating existing records instead of appending
  const [allMessages, setAllMessages] = useState({});
  
  const [error, setError] = useState(null);
  const ws = useRef(null);
  const reconnectTimeout = useRef(null);
  
  // Set di callback registrate dai componenti per ricevere notifiche
  // Pattern: Observer (ogni componente può registrare un handler)
  const messageHandlers = useRef(new Set());

  const connect = useCallback(() => {
    // Non riconnettere se già connesso
    if (ws.current && ws.current.readyState === WebSocket.OPEN) {
      return;
    }

    try {
      const protocol = window.location.protocol === 'https:' ? 'wss:' : 'ws:';
      const host = window.location.hostname;
      const port = 8081; // Porta del backend (mappata da Docker: -p 8081:8080)
      
      // Add token to WebSocket URL for session tracking
      const token = localStorage.getItem('authToken');
      const wsUrl = token 
        ? `${protocol}//${host}:${port}/ws/marketdata?token=${encodeURIComponent(token)}`
        : `${protocol}//${host}:${port}/ws/marketdata`;

      console.log('🔌 Connessione WebSocket globale a:', wsUrl.replace(/token=[^&]+/, 'token=***'));
      
      ws.current = new WebSocket(wsUrl);

      ws.current.onopen = () => {
        console.log('✅ WebSocket connesso (globale) - resettando stato');
        setIsConnected(true);
        setError(null);
        
        // Reset data on reconnection (backend may have restarted and cleaned database)
        setAllMessages({});
        setMarketData({});
      };

      ws.current.onmessage = (event) => {
        try {
          const message = JSON.parse(event.data);
          console.log('📨 Messaggio WebSocket ricevuto:', message.type, '- Handler registrati:', messageHandlers.current.size);

          if (message.type === 'marketData') {
            // STRATEGIA DI STORAGE DUALE:
            
            // 1️⃣ marketData: mantiene SOLO ultimo valore per ogni classe
            //    Chiave: classId → Valore: ultimo messaggio ricevuto
            //    Usato per: mostrare stato corrente, query real-time
            setMarketData(prev => ({
              ...prev,
              [message.classId]: {
                classId: message.classId,
                className: message.className,
                data: message.data,
                hashKey: message.hashKey,
                timestamp: message.timestamp
              }
            }));

            // 2️⃣ allMessages: UPSERT semantics using hashKey
            //    Structure: { classId: { hashKey: record } }
            //    If hashKey exists: UPDATE, else: INSERT
            //    This prevents memory bloat from duplicate updates
            setAllMessages(prev => {
              const classId = message.classId;
              const hashKey = message.hashKey;
              
              // Get or create class bucket
              const classBucket = prev[classId] || {};
              
              // UPSERT: Update existing or insert new
              const updatedBucket = {
                ...classBucket,
                [hashKey]: {
                  timestamp: message.timestamp,
                  classId: message.classId,
                  className: message.className,
                  hashKey: message.hashKey,
                  data: message.data
                }
              };
              
              return {
                ...prev,
                [classId]: updatedBucket
              };
            });

            console.log('💾 Messaggio UPSERT (hashKey:', message.hashKey, ')');

            // 3️⃣ Notifica tutti i component che hanno registrato un handler
            //    Pattern OBSERVER: broadcast a tutti gli interessati
            console.log('🔔 Notificando', messageHandlers.current.size, 'handler...');
            messageHandlers.current.forEach(handler => {
              try {
                handler(message);
              } catch (err) {
                console.error('Errore in message handler:', err);
              }
            });
          } else if (message.type === 'connected') {
            console.log('👋 Messaggio di benvenuto:', message.message);
          }
        } catch (err) {
          console.error('❌ Errore parsing messaggio WebSocket:', err);
        }
      };

      ws.current.onerror = (event) => {
        console.error('❌ Errore WebSocket:', event);
        setError('Errore di connessione WebSocket');
      };

      ws.current.onclose = () => {
        console.log('🔌 WebSocket disconnesso (globale) - resettando dati');
        setIsConnected(false);
        
        // Reset data on disconnect (backend may have stopped or user logged out)
        setAllMessages({});
        setMarketData({});
        
        // Tentativo di riconnessione dopo 3 secondi
        reconnectTimeout.current = setTimeout(() => {
          console.log('🔄 Tentativo di riconnessione...');
          connect();
        }, 3000);
      };
    } catch (err) {
      console.error('❌ Errore creazione WebSocket:', err);
      setError(`Errore connessione: ${err.message}`);
    }
  }, []);

  const disconnect = useCallback(() => {
    if (reconnectTimeout.current) {
      clearTimeout(reconnectTimeout.current);
    }
    if (ws.current) {
      ws.current.close();
      ws.current = null;
    }
    setIsConnected(false);
  }, []);

  const removeClassData = useCallback((classId) => {
    console.log('🗑️ Removing data for classId:', classId);
    
    // Remove from marketData
    setMarketData(prev => {
      const newData = { ...prev };
      delete newData[classId];
      return newData;
    });
    
    // Remove from allMessages (now a Map structure)
    setAllMessages(prev => {
      const newMessages = { ...prev };
      delete newMessages[classId];
      return newMessages;
    });
  }, []);

  const resetAllData = useCallback(() => {
    console.log('🔄 Resetting all WebSocket data (Delete All triggered)');
    setAllMessages({});
    setMarketData({});
  }, []);

  const addMessageHandler = useCallback((handler) => {
    messageHandlers.current.add(handler);
    console.log('➕ Handler aggiunto - Totale handler:', messageHandlers.current.size);
    return () => {
      messageHandlers.current.delete(handler);
      console.log('➖ Handler rimosso - Totale handler:', messageHandlers.current.size);
    };
  }, []);

  // Connetti automaticamente al mount e mantieni connessione
  useEffect(() => {
    connect();

    // NON disconnettere al unmount - mantieni la connessione globale
    return () => {
      // Cleanup solo quando l'applicazione intera viene smontata
      if (reconnectTimeout.current) {
        clearTimeout(reconnectTimeout.current);
      }
    };
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []); // Dipendenze vuote - connetti solo una volta

  const value = {
    isConnected,
    marketData,
    allMessages, // Storico completo di tutti i messaggi ricevuti
    error,
    connect,
    disconnect,
    removeClassData,
    resetAllData,
    addMessageHandler
  };

  return (
    <WebSocketContext.Provider value={value}>
      {children}
    </WebSocketContext.Provider>
  );
};

/**
 * Hook per accedere al WebSocket globale
 */
export const useWebSocket = () => {
  const context = useContext(WebSocketContext);
  if (!context) {
    throw new Error('useWebSocket deve essere usato dentro WebSocketProvider');
  }
  
  // Count unique records across all classes
  const totalRecords = Object.keys(context.allMessages || {}).reduce((count, classId) => {
    return count + Object.keys(context.allMessages[classId] || {}).length;
  }, 0);
  
  console.log('🔌 useWebSocket hook chiamato - unique records:', totalRecords);
  return context;
};
