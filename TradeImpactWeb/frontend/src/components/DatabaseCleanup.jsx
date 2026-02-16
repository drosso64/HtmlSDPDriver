import { useState, useEffect } from 'react';
import './DatabaseCleanup.css';

function DatabaseCleanup() {
  const [stats, setStats] = useState({
    totalRecords: 0,
    databaseSize: 0,
    oldestRecord: null,
    retentionDays: 30
  });
  const [retentionDays, setRetentionDays] = useState(30);
  const [loading, setLoading] = useState(false);
  const [cleanupResult, setCleanupResult] = useState(null);

  useEffect(() => {
    fetchStats();
  }, []);

  const fetchStats = async () => {
    try {
      const response = await fetch('/api/cleanup/stats');
      if (response.ok) {
        const data = await response.json();
        setStats(data);
        setRetentionDays(data.retentionDays || 30);
      }
    } catch (err) {
      console.error('Error fetching stats:', err);
    }
  };

  const handleUpdateRetention = async () => {
    try {
      const response = await fetch('/api/cleanup/retention', {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ days: retentionDays })
      });

      if (response.ok) {
        alert('Periodo di retention aggiornato');
        fetchStats();
      }
    } catch (err) {
      alert('Errore nell\'aggiornamento del periodo di retention');
    }
  };

  const handleCleanup = async () => {
    if (!confirm(`Confermi la pulizia dei dati più vecchi di ${retentionDays} giorni?`)) {
      return;
    }

    setLoading(true);
    setCleanupResult(null);

    try {
      const response = await fetch('/api/cleanup/execute', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        }
      });

      if (response.ok) {
        const data = await response.json();
        setCleanupResult(data);
        fetchStats();
      } else {
        alert('Errore durante la pulizia');
      }
    } catch (err) {
      alert('Errore di connessione');
    } finally {
      setLoading(false);
    }
  };

  const formatBytes = (bytes) => {
    if (bytes === 0) return '0 Bytes';
    const k = 1024;
    const sizes = ['Bytes', 'KB', 'MB', 'GB'];
    const i = Math.floor(Math.log(bytes) / Math.log(k));
    return Math.round(bytes / Math.pow(k, i) * 100) / 100 + ' ' + sizes[i];
  };

  return (
    <div className="database-cleanup">
      <h1>Gestione Database</h1>

      <div className="stats-grid">
        <div className="stat-card">
          <div className="stat-icon">💾</div>
          <div className="stat-content">
            <div className="stat-label">Record Totali</div>
            <div className="stat-value">{stats.totalRecords.toLocaleString()}</div>
          </div>
        </div>

        <div className="stat-card">
          <div className="stat-icon">📦</div>
          <div className="stat-content">
            <div className="stat-label">Dimensione Database</div>
            <div className="stat-value">{formatBytes(stats.databaseSize)}</div>
          </div>
        </div>

        <div className="stat-card">
          <div className="stat-icon">🕐</div>
          <div className="stat-content">
            <div className="stat-label">Record Più Vecchio</div>
            <div className="stat-value stat-time">
              {stats.oldestRecord 
                ? new Date(stats.oldestRecord).toLocaleDateString('it-IT')
                : 'N/A'
              }
            </div>
          </div>
        </div>

        <div className="stat-card">
          <div className="stat-icon">⏱️</div>
          <div className="stat-content">
            <div className="stat-label">Retention Configurato</div>
            <div className="stat-value">{stats.retentionDays} giorni</div>
          </div>
        </div>
      </div>

      <div className="cleanup-panel">
        <h2>Configurazione Retention</h2>
        <p>I dati più vecchi del periodo specificato verranno automaticamente eliminati</p>
        
        <div className="retention-config">
          <div className="form-group">
            <label>Periodo di Retention (giorni)</label>
            <div className="retention-input-group">
              <input
                type="number"
                min="1"
                max="365"
                value={retentionDays}
                onChange={(e) => setRetentionDays(parseInt(e.target.value))}
              />
              <button
                className="btn btn-primary"
                onClick={handleUpdateRetention}
              >
                Aggiorna
              </button>
            </div>
          </div>
        </div>
      </div>

      <div className="cleanup-panel">
        <h2>Pulizia Manuale</h2>
        <p>
          Elimina immediatamente i dati più vecchi di {retentionDays} giorni.
          Questa operazione non può essere annullata.
        </p>
        
        <button
          className="btn btn-danger"
          onClick={handleCleanup}
          disabled={loading}
        >
          {loading ? 'Pulizia in corso...' : '🗑️ Esegui Pulizia'}
        </button>

        {cleanupResult && (
          <div className="cleanup-result">
            <h3>✓ Pulizia Completata</h3>
            <div className="result-details">
              <div className="result-item">
                <span>Record eliminati:</span>
                <strong>{cleanupResult.deletedRecords.toLocaleString()}</strong>
              </div>
              <div className="result-item">
                <span>Spazio recuperato:</span>
                <strong>{formatBytes(cleanupResult.freedSpace)}</strong>
              </div>
              <div className="result-item">
                <span>Durata:</span>
                <strong>{cleanupResult.duration}ms</strong>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}

export default DatabaseCleanup;
