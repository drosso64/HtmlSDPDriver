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
 * - allMessages: Array di TUTTI i messaggi ricevuti (⚠️ ATTENZIONE: cresce indefinitamente)
 * - marketData: Oggetto con ultimo messaggio per ogni classe (key = classId)
 * - isConnected: Stato connessione WebSocket
 * 
 * STRATEGIA DI NOTIFICA:
 * Quando arriva un messaggio WebSocket:
 * 1. Aggiunge a allMessages (storico completo)
 * 2. Aggiorna marketData (ultimo valore per classe)
 * 3. Notifica tutti i messageHandlers registrati (pattern Observer)
 * 
 * PROBLEMA NOTO:
 * allMessages cresce senza limiti → rischio esaurimento memoria
 * TODO: Limitare a ultimi N messaggi o caricare da DB con paginazione
 * 
 * @see ClassTabbedView.jsx - Consuma allMessages per creare tab dinamici
 * @see DynamicDataGrid.jsx - Renderizza dati in tabelle
 */
const WebSocketContext = createContext(null);

export const WebSocketProvider = ({ children }) => {
  const [isConnected, setIsConnected] = useState(false);
  const [marketData, setMarketData] = useState({});
  
  // ⚠️ ATTENZIONE: Questo array accumula TUTTI i messaggi ricevuti
  // Non viene mai svuotato → può causare memory leak in sessioni lunghe
  // SOLUZIONE FUTURA: Implementare ring buffer o paginazione da DB
  const [allMessages, setAllMessages] = useState([]);
  
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
      const wsUrl = `${protocol}//${host}:${port}/ws/marketdata`;

      console.log('🔌 Connessione WebSocket globale a:', wsUrl);
      
      ws.current = new WebSocket(wsUrl);

      ws.current.onopen = () => {
        console.log('✅ WebSocket connesso (globale)');
        setIsConnected(true);
        setError(null);
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
                timestamp: message.timestamp
              }
            }));

            // 2️⃣ allMessages: accumula TUTTO lo storico
            //    Usato per: visualizzazione serie temporali, analisi storico
            //    ⚠️ PROBLEMA: array cresce indefinitamente
            setAllMessages(prev => [...prev, {
              timestamp: message.timestamp,
              classId: message.classId,
              className: message.className,
              data: message.data
            }]);

            console.log('💾 Messaggio salvato nello storico globale');

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
        console.log('🔌 WebSocket disconnesso (globale)');
        setIsConnected(false);
        
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
  console.log('🔌 useWebSocket hook chiamato - allMessages:', context.allMessages?.length || 0);
  return context;
};
