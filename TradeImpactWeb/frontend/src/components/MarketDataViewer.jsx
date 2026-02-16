import { useState, useEffect, useMemo } from 'react';
import { useWebSocket } from '../contexts/WebSocketContext';
import DynamicDataGrid from './DynamicDataGrid';
import './MarketDataViewer.css';

function MarketDataViewer() {
  const { isConnected, allMessages, error } = useWebSocket();
  const [status, setStatus] = useState('Connessione al server...');

  console.log('🔷 MarketDataViewer render - allMessages disponibili:', allMessages?.length || 0);

  // Parsing dei dati per la griglia
  const parsedData = useMemo(() => {
    console.log('🔄 MarketDataViewer: Parsing', allMessages?.length || 0, 'messaggi');
    
    if (!allMessages || allMessages.length === 0) {
      return [];
    }
    
    return allMessages.map(message => {
      let parsedDataObj = message.data;
      
      if (typeof message.data === 'string') {
        try {
          parsedDataObj = JSON.parse(message.data);
        } catch (e) {
          console.error('❌ Failed to parse data JSON:', e);
          parsedDataObj = { raw: message.data };
        }
      }
      
      return {
        timestamp: message.timestamp,
        classId: message.classId,
        className: message.className,
        data: parsedDataObj
      };
    });
  }, [allMessages]);

  // Update status quando arrivano dati
  useEffect(() => {
    console.log('📊 MarketDataViewer useEffect - allMessages.length:', allMessages?.length);
    if (allMessages && allMessages.length > 0) {
      setStatus(`Ricevuti ${allMessages.length} messaggi`);
    }
  }, [allMessages]);

  // Connection status
  useEffect(() => {
    if (isConnected) {
      setStatus('Connesso - In attesa di dati...');
    } else {
      setStatus('Disconnesso dal server');
    }
  }, [isConnected]);

  return (
    <div className="market-data-viewer">
      <div className="viewer-header">
        <h2>Market Data Viewer</h2>
        <div className="status-bar">
          <div className={`connection-indicator ${isConnected ? 'connected' : 'disconnected'}`}>
            <span className="indicator-dot"></span>
            <span className="indicator-text">
              WebSocket: {isConnected ? 'Connesso' : 'Disconnesso'}
            </span>
          </div>
          <div className="data-counter">
            <span>Record totali: {parsedData.length}</span>
          </div>
        </div>
        {error && (
          <div className="error-message">
            <strong>Errore:</strong> {error}
          </div>
        )}
      </div>

      <div className="viewer-content">
        {parsedData.length === 0 ? (
          <div className="no-data-message">
            <p>{status}</p>
            <p className="hint">
              Vai alla pagina <strong>Sottoscrizioni</strong> per sottoscrivere le classi dati.
            </p>
          </div>
        ) : (
          <DynamicDataGrid data={parsedData} />
        )}
      </div>
    </div>
  );
}

export default MarketDataViewer;
