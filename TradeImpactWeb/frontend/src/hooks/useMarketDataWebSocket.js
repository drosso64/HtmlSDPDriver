import { useEffect, useRef, useState, useCallback } from 'react';

/**
 * Hook per gestire la connessione WebSocket per i dati di mercato in tempo reale
 */
export const useMarketDataWebSocket = () => {
  const [isConnected, setIsConnected] = useState(false);
  const [marketData, setMarketData] = useState({});
  const [error, setError] = useState(null);
  const ws = useRef(null);
  const reconnectTimeout = useRef(null);
  const messageHandlers = useRef(new Set());

  const connect = useCallback(() => {
    try {
      // Ottieni l'URL del backend dalla configurazione
      const protocol = window.location.protocol === 'https:' ? 'wss:' : 'ws:';
      const host = window.location.hostname;
      const port = 8081; // Porta del backend (mappata da Docker: -p 8081:8080)
      const wsUrl = `${protocol}//${host}:${port}/ws/marketdata`;

      console.log('Connessione WebSocket a:', wsUrl);
      
      ws.current = new WebSocket(wsUrl);

      ws.current.onopen = () => {
        console.log('WebSocket connesso');
        setIsConnected(true);
        setError(null);
      };

      ws.current.onmessage = (event) => {
        try {
          const message = JSON.parse(event.data);
          console.log('Messaggio WebSocket ricevuto:', message);

          if (message.type === 'marketData') {
            // Aggiorna lo stato con i nuovi dati di mercato
            setMarketData(prev => ({
              ...prev,
              [message.classId]: {
                classId: message.classId,
                className: message.className,
                data: message.data,
                timestamp: message.timestamp
              }
            }));

            // Notifica gli handler registrati
            messageHandlers.current.forEach(handler => {
              handler(message);
            });
          } else if (message.type === 'welcome') {
            console.log('Messaggio di benvenuto:', message.message);
          }
        } catch (err) {
          console.error('Errore parsing messaggio WebSocket:', err);
        }
      };

      ws.current.onerror = (event) => {
        console.error('Errore WebSocket:', event);
        setError('Errore di connessione WebSocket');
      };

      ws.current.onclose = () => {
        console.log('WebSocket disconnesso');
        setIsConnected(false);
        
        // Tentativo di riconnessione dopo 3 secondi
        reconnectTimeout.current = setTimeout(() => {
          console.log('Tentativo di riconnessione...');
          connect();
        }, 3000);
      };
    } catch (err) {
      console.error('Errore creazione WebSocket:', err);
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
    setMarketData({});
  }, []);

  const addMessageHandler = useCallback((handler) => {
    messageHandlers.current.add(handler);
    return () => messageHandlers.current.delete(handler);
  }, []);

  // Connetti automaticamente al mount
  useEffect(() => {
    connect();

    return () => {
      disconnect();
    };
  }, [connect, disconnect]);

  return {
    isConnected,
    marketData,
    error,
    connect,
    disconnect,
    addMessageHandler
  };
};
