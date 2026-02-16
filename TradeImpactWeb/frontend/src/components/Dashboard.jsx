import { useState, useEffect } from 'react';
import './Dashboard.css';

function Dashboard() {
  const [stats, setStats] = useState({
    activeSubscriptions: 0,
    connectionStatus: 'disconnected',
    totalMessages: 0,
    lastUpdate: null
  });
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchStats();
    const interval = setInterval(fetchStats, 5000);
    return () => clearInterval(interval);
  }, []);

  const fetchStats = async () => {
    try {
      const response = await fetch('/api/dashboard/stats');
      if (response.ok) {
        const data = await response.json();
        setStats(data);
      }
    } catch (error) {
      console.error('Error fetching stats:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="dashboard">
      <h1>Dashboard</h1>
      
      {loading ? (
        <div className="loading">Caricamento...</div>
      ) : (
        <div className="stats-grid">
          <div className="stat-card">
            <div className="stat-icon">📡</div>
            <div className="stat-content">
              <div className="stat-label">Stato Connessione</div>
              <div className={`stat-value status-${stats.connectionStatus}`}>
                {stats.connectionStatus === 'connected' ? 'Connesso' : 'Disconnesso'}
              </div>
            </div>
          </div>

          <div className="stat-card">
            <div className="stat-icon">📋</div>
            <div className="stat-content">
              <div className="stat-label">Sottoscrizioni Attive</div>
              <div className="stat-value">{stats.activeSubscriptions}</div>
            </div>
          </div>

          <div className="stat-card">
            <div className="stat-icon">📊</div>
            <div className="stat-content">
              <div className="stat-label">Messaggi Ricevuti</div>
              <div className="stat-value">{stats.totalMessages.toLocaleString()}</div>
            </div>
          </div>

          <div className="stat-card">
            <div className="stat-icon">🕒</div>
            <div className="stat-content">
              <div className="stat-label">Ultimo Aggiornamento</div>
              <div className="stat-value stat-time">
                {stats.lastUpdate ? new Date(stats.lastUpdate).toLocaleTimeString() : 'N/A'}
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default Dashboard;
