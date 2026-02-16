import { useState, useEffect } from 'react';
import './ClassSubscription.css';
import { useWebSocket } from '../contexts/WebSocketContext';

function ClassSubscription() {
  const [classes, setClasses] = useState([]);
  const [selectedClasses, setSelectedClasses] = useState(new Set());
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [subscribing, setSubscribing] = useState(false);
  
  // WebSocket per dati in tempo reale
  const { isConnected, marketData, error: wsError } = useWebSocket();

  useEffect(() => {
    fetchClasses();
  }, []);

  const fetchClasses = async () => {
    try {
      const response = await fetch('/api/classes');
      if (response.ok) {
        const data = await response.json();
        console.log('Loaded classes:', data);
        setClasses(data);
      } else {
        setError('Errore nel caricamento delle classi');
      }
    } catch (err) {
      setError('Errore di connessione: ' + err.message);
    } finally {
      setLoading(false);
    }
  };

  const handleToggleClass = (classId) => {
    setSelectedClasses(prev => {
      const newSet = new Set(prev);
      if (newSet.has(classId)) {
        newSet.delete(classId);
      } else {
        newSet.add(classId);
      }
      return newSet;
    });
  };

  const handleSubscribe = async () => {
    if (selectedClasses.size === 0) {
      alert('Seleziona almeno una classe');
      return;
    }

    setSubscribing(true);
    try {
      const response = await fetch('/api/classes/subscribe', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          classIds: Array.from(selectedClasses),
          filterKey: 0
        })
      });

      if (response.ok) {
        const result = await response.json();
        alert(`Sottoscrizioni completate:\n✓ Successi: ${result.success}\n✗ Fallimenti: ${result.failures}`);
        setSelectedClasses(new Set());
      } else {
        alert('Errore nelle sottoscrizioni');
      }
    } catch (err) {
      alert('Errore di connessione: ' + err.message);
    } finally {
      setSubscribing(false);
    }
  };

  const handleUnsubscribe = async () => {
    if (selectedClasses.size === 0) {
      alert('Seleziona almeno una classe');
      return;
    }

    setSubscribing(true);
    try {
      const response = await fetch('/api/classes/unsubscribe', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          classIds: Array.from(selectedClasses)
        })
      });

      if (response.ok) {
        const result = await response.json();
        alert(`Annullamenti completati:\n✓ Successi: ${result.success}\n✗ Fallimenti: ${result.failures}`);
        setSelectedClasses(new Set());
      } else {
        alert('Errore negli annullamenti');
      }
    } catch (err) {
      alert('Errore di connessione: ' + err.message);
    } finally {
      setSubscribing(false);
    }
  };

  if (loading) {
    return <div className="loading">Caricamento classi...</div>;
  }

  if (error) {
    return <div className="error">{error}</div>;
  }

  return (
    <div className="class-subscription">
      <h1>Sottoscrizioni Classi</h1>
      
      {/* Status WebSocket */}
      <div className={`websocket-status ${isConnected ? 'connected' : 'disconnected'}`}>
        WebSocket: {isConnected ? '🟢 Connesso' : '🔴 Disconnesso'}
        {wsError && <span className="ws-error"> - {wsError}</span>}
      </div>
      
      <div className="subscription-info">
        <p>Seleziona le classi da sottoscrivere per ricevere aggiornamenti in tempo reale</p>
        <p className="active-count">
          Classi selezionate: <strong>{selectedClasses.size}</strong> / {classes.length}
        </p>
        {Object.keys(marketData).length > 0 && (
          <p className="data-count">
            Dati ricevuti per <strong>{Object.keys(marketData).length}</strong> classi
          </p>
        )}
      </div>

      <div className="action-buttons">
        <button 
          onClick={handleSubscribe} 
          disabled={selectedClasses.size === 0 || subscribing}
          className="btn-subscribe"
        >
          {subscribing ? 'Sottoscrizione...' : `Sottoscrivi (${selectedClasses.size})`}
        </button>
        <button 
          onClick={handleUnsubscribe} 
          disabled={selectedClasses.size === 0 || subscribing}
          className="btn-unsubscribe"
        >
          Annulla Sottoscrizione
        </button>
      </div>

      <div className="class-list">
        {classes.length === 0 ? (
          <div className="empty-message">Nessuna classe disponibile</div>
        ) : (
          classes.map(classItem => {
            const isSelected = selectedClasses.has(classItem.classId);
            return (
              <div key={classItem.classId} className={`class-item ${isSelected ? 'selected' : ''}`}>
                <label className="class-checkbox">
                  <input
                    type="checkbox"
                    checked={isSelected}
                    onChange={() => handleToggleClass(classItem.classId)}
                  />
                  <span className="checkbox-custom"></span>
                  <div className="class-info">
                    <div className="class-name">
                      {classItem.simpleClassName || classItem.className}
                      {marketData[classItem.classId] && (
                        <span className="live-indicator" title="Dati in tempo reale">📡</span>
                      )}
                    </div>
                    {classItem.description && (
                      <div className="class-meta">
                        <span className="class-description">{classItem.description}</span>
                      </div>
                    )}
                    {marketData[classItem.classId] && (
                      <div className="market-data-preview">
                        <small>
                          Ultimo aggiornamento: {new Date(marketData[classItem.classId].timestamp).toLocaleTimeString('it-IT')}
                        </small>
                      </div>
                    )}
                  </div>
                </label>
              </div>
            );
          })
        )}
      </div>
    </div>
  );
}

export default ClassSubscription;
