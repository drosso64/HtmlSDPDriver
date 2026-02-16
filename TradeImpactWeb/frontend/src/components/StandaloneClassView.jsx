import { useMemo } from 'react';
import { useParams, useSearchParams } from 'react-router-dom';
import { useWebSocket } from '../contexts/WebSocketContext';
import DynamicDataGrid from './DynamicDataGrid';
import './StandaloneClassView.css';

/**
 * Standalone view for a single class in a separate browser window
 * Receives data from shared WebSocket connection
 */
function StandaloneClassView() {
  const { classId } = useParams();
  const [searchParams] = useSearchParams();
  const className = searchParams.get('className') || `Class ${classId}`;
  const { isConnected, allMessages, error } = useWebSocket();

  console.log('✅ StandaloneClassView MOUNTED - classId:', classId, 'className:', className);
  console.log('✅ Current URL:', window.location.href);
  console.log('✅ Total messages:', allMessages?.length || 0);

  // Filter data for this specific class
  const classData = useMemo(() => {
    if (!allMessages || allMessages.length === 0) {
      return [];
    }

    const filtered = allMessages.filter(message => 
      String(message.classId) === String(classId)
    );

    console.log('🔷 Filtered data for classId', classId, ':', filtered.length, 'records');

    return filtered.map(message => {
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
  }, [allMessages, classId]);

  return (
    <div className="standalone-class-view">
      {/* Header */}
      <div className="standalone-header">
        <div className="header-title">
          <h2>{className}</h2>
          <span className="class-id-badge">ID: {classId}</span>
        </div>
        <div className="header-status">
          <div className={`connection-indicator ${isConnected ? 'connected' : 'disconnected'}`}>
            <span className="indicator-dot"></span>
            <span className="indicator-text">
              {isConnected ? 'Connesso' : 'Disconnesso'}
            </span>
          </div>
          <div className="data-counter">
            <span>Record: {classData.length}</span>
          </div>
        </div>
        {error && (
          <div className="error-message">
            <strong>Errore:</strong> {error}
          </div>
        )}
      </div>

      {/* Content */}
      <div className="standalone-content">
        {classData.length === 0 ? (
          <div className="no-data-message">
            <p>Nessun dato disponibile per la classe <strong>{className}</strong>.</p>
            <p className="hint">
              In attesa di messaggi dal server...
            </p>
          </div>
        ) : (
          <DynamicDataGrid data={classData} />
        )}
      </div>
    </div>
  );
}

export default StandaloneClassView;
