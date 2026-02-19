import { useState, useEffect, useMemo } from 'react';
import { useWebSocket } from '../contexts/WebSocketContext';
import ClassTabbedView from './ClassTabbedView';
import './DataGrid.css';

function DataGrid() {
  const { isConnected, allMessages, marketData, error } = useWebSocket();
  const [status, setStatus] = useState('Connessione al server...');
  const [user, setUser] = useState(null);

  // Load user from localStorage
  useEffect(() => {
    const savedUser = localStorage.getItem('user');
    if (savedUser) {
      setUser(JSON.parse(savedUser));
    }
  }, []);

  console.log('🔷 DataGrid render - allMessages disponibili:', Object.keys(allMessages || {}).length);

  // Parsing dei dati per la griglia
  const parsedData = useMemo(() => {
    console.log('🔄 DataGrid: Parsing allMessages (Map structure)');
    console.log('📊 allMessages keys:', Object.keys(allMessages || {}));
    console.log('📊 marketData keys:', Object.keys(marketData || {}));
    
    if (!allMessages || Object.keys(allMessages).length === 0) {
      console.log('⚠️ No allMessages, returning empty array');
      return [];
    }
    
    // Convert Map structure to flat array
    // allMessages = { classId: { hashKey: record } }
    const flatArray = [];
    
    Object.entries(allMessages).forEach(([classId, hashKeyMap]) => {
      const numRecords = Object.keys(hashKeyMap).length;
      console.log(`  - ClassId ${classId}: ${numRecords} records`);
      
      if (numRecords === 0) {
        // Empty class (subscribed but no data yet)
        // Create placeholder entry so TAB is created
        const classInfo = marketData[classId];
        console.log(`    🔍 Looking for marketData[${classId}]:`, classInfo);
        if (classInfo && classInfo.className) {
          console.log('📭 DataGrid: Empty class bucket for', classId, classInfo.className);
          flatArray.push({
            timestamp: classInfo.timestamp || new Date().toISOString(),
            classId: Number(classId),
            className: classInfo.className,
            hashKey: null,
            data: null,
            isEmpty: true // Flag to identify placeholder
          });
        } else {
          console.warn('⚠️ No marketData found for empty class', classId);
        }
      } else {
        // Normal records
        Object.values(hashKeyMap).forEach(message => {
          let parsedDataObj = message.data;
          
          if (typeof message.data === 'string') {
            try {
              parsedDataObj = JSON.parse(message.data);
            } catch (e) {
              console.error('❌ Failed to parse data JSON:', e);
              parsedDataObj = { raw: message.data };
            }
          }
          
          flatArray.push({
            timestamp: message.timestamp,
            classId: message.classId,
            className: message.className,
            hashKey: message.hashKey,
            data: parsedDataObj
          });
        });
      }
    });
    
    console.log('✅ DataGrid: Converted Map to', flatArray.length, 'records');
    return flatArray;
  }, [allMessages, marketData]);

  // Update status quando arrivano dati
  useEffect(() => {
    const totalMessages = Object.keys(allMessages || {}).reduce((count, classId) => {
      return count + Object.keys(allMessages[classId] || {}).length;
    }, 0);
    
    console.log('📊 DataGrid useEffect - total unique records:', totalMessages);
    if (totalMessages > 0) {
      setStatus(`Ricevuti ${totalMessages} record unici (UPSERT)`);
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
        <h2>Live Data</h2>
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
          <ClassTabbedView data={parsedData} user={user} />
        )}
      </div>
    </div>
  );
}

export default DataGrid;
