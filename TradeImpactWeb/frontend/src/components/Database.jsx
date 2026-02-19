import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Database.css';
import { useWebSocket } from '../contexts/WebSocketContext';

function Database() {
  const ws = useWebSocket();
  const [stats, setStats] = useState(null);
  const [classes, setClasses] = useState([]);
  const [selectedClass, setSelectedClass] = useState(null);
  const [records, setRecords] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [loading, setLoading] = useState(false);

  const api = axios.create({
    baseURL: '/api',
    headers: {
      'Content-Type': 'application/json'
    }
  });

  // Add auth token to requests
  api.interceptors.request.use((config) => {
    const token = localStorage.getItem('authToken');
    if (token) {
      config.headers['Authorization'] = token;
    }
    return config;
  });

  useEffect(() => {
    loadStats();
    loadClasses();
  }, []);

  const loadStats = async () => {
    try {
      const response = await api.get('/database/stats');
      setStats(response.data);
    } catch (error) {
      console.error('Failed to load stats:', error);
    }
  };

  const loadClasses = async () => {
    try {
      const response = await api.get('/database/classes');
      setClasses(response.data);
    } catch (error) {
      console.error('Failed to load classes:', error);
    }
  };

  const loadRecords = async (classId = null, pageNum = 0) => {
    setLoading(true);
    try {
      const params = { page: pageNum, size: 50 };
      if (classId) params.classId = classId;
      
      const response = await api.get('/database/marketdata', { params });
      setRecords(response.data.content);
      setTotalPages(response.data.totalPages);
      setPage(pageNum);
    } catch (error) {
      console.error('Failed to load records:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleDeleteAll = async () => {
    if (!window.confirm('⚠️ Are you sure you want to delete ALL data?')) return;
    
    try {
      const response = await api.delete('/database/marketdata/all');
      alert(`✅ ${response.data.message || `Deleted ${response.data.deletedCount} records`}`);
      
      // Reset WebSocket state to remove all TABs
      if (ws?.resetAllData) {
        ws.resetAllData();
      }
      
      loadStats();
      loadClasses();
      setRecords([]);
      setSelectedClass(null);
    } catch (error) {
      alert('❌ Failed to delete data: ' + error.message);
    }
  };

  const handleDeleteClass = async (classId, className) => {
    if (!window.confirm(`⚠️ Delete all data for class ${className} (${classId})?`)) return;
    
    try {
      const response = await api.delete(`/database/marketdata/class/${classId}`);
      alert(`✅ ${response.data.message || `Deleted ${response.data.deletedCount} records`}`);
      
      // Remove this class from WebSocket state
      if (ws?.removeClassData) {
        ws.removeClassData(classId);
      }
      
      loadStats();
      loadClasses();
      if (selectedClass === classId) {
        setRecords([]);
        setSelectedClass(null);
      }
    } catch (error) {
      alert('❌ Failed to delete class data: ' + error.message);
    }
  };

  const formatTimestamp = (timestamp) => {
    if (!timestamp) return 'N/A';
    return new Date(timestamp).toLocaleString('it-IT', {
      year: 'numeric',
      month: '2-digit',
      day: '2-digit',
      hour: '2-digit',
      minute: '2-digit',
      second: '2-digit'
    });
  };

  return (
    <div className="database-container">
      <h2>📊 Database Management</h2>

      {/* Statistics Card */}
      {stats && (
        <div className="stats-card">
          <h3>Database Statistics</h3>
          <div className="stats-grid">
            <div className="stat-item">
              <label>Market Data Records:</label>
              <span className="stat-value">{stats.marketDataRecords.toLocaleString()}</span>
            </div>
            <div className="stat-item">
              <label>Database Size:</label>
              <span className="stat-value">{(stats.totalSizeKb / 1024).toFixed(2)} MB</span>
            </div>
            <div className="stat-item">
              <label>Last Update:</label>
              <span className="stat-value">{formatTimestamp(stats.lastUpdate)}</span>
            </div>
          </div>
          <button onClick={handleDeleteAll} className="btn-danger">
            🗑️ Delete All Data
          </button>
        </div>
      )}

      {/* Classes Table */}
      <div className="classes-section">
        <h3>📁 Classes ({classes.length})</h3>
        {classes.length === 0 ? (
          <p className="empty-message">No data in database</p>
        ) : (
          <table className="classes-table">
            <thead>
              <tr>
                <th>Class ID</th>
                <th>Class Name</th>
                <th>Records</th>
                <th>Last Update</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {classes.map(cls => (
                <tr key={cls.classId} className={selectedClass === cls.classId ? 'selected' : ''}>
                  <td>{cls.classId}</td>
                  <td className="class-name-cell">{cls.className}</td>
                  <td>{cls.recordCount.toLocaleString()}</td>
                  <td>{formatTimestamp(cls.lastUpdate)}</td>
                  <td>
                    <button 
                      onClick={() => { 
                        setSelectedClass(cls.classId); 
                        loadRecords(cls.classId); 
                      }}
                      className="btn-small btn-primary"
                      disabled={loading}
                    >
                      📄 Browse
                    </button>
                    <button 
                      onClick={() => handleDeleteClass(cls.classId, cls.className)}
                      className="btn-small btn-danger"
                    >
                      🗑️ Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>

      {/* Records Viewer */}
      {selectedClass && (
        <div className="records-section">
          <div className="records-header">
            <h3>📝 Records for Class {selectedClass}</h3>
            <button 
              onClick={() => setSelectedClass(null)}
              className="btn-close"
            >
              ✖ Close
            </button>
          </div>
          {loading ? (
            <p className="loading-message">Loading...</p>
          ) : records.length === 0 ? (
            <p className="empty-message">No records found</p>
          ) : (
            <>
              <div className="records-list">
                {records.map(record => (
                  <div key={record.id} className="record-item">
                    <div className="record-header">
                      <span className="record-id">#{record.id}</span>
                      <span className="record-class">{record.className}</span>
                      <span className="record-action">{record.action || 'N/A'}</span>
                      <span className="record-time">{formatTimestamp(record.receivedAt)}</span>
                    </div>
                    <pre className="record-data">{JSON.stringify(JSON.parse(record.jsonData), null, 2)}</pre>
                  </div>
                ))}
              </div>
              
              {/* Pagination */}
              {totalPages > 1 && (
                <div className="pagination">
                  <button 
                    onClick={() => loadRecords(selectedClass, page - 1)}
                    disabled={page === 0 || loading}
                    className="btn-page"
                  >
                    ← Previous
                  </button>
                  <span className="page-info">Page {page + 1} of {totalPages}</span>
                  <button 
                    onClick={() => loadRecords(selectedClass, page + 1)}
                    disabled={page >= totalPages - 1 || loading}
                    className="btn-page"
                  >
                    Next →
                  </button>
                </div>
              )}
            </>
          )}
        </div>
      )}
    </div>
  );
}

export default Database;
