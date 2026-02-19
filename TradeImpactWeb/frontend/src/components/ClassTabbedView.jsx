import { useState, useMemo, useEffect } from 'react';
import DynamicDataGrid from './DynamicDataGrid';
import * as api from '../services/api';
import { useWebSocket } from '../contexts/WebSocketContext';
import './ClassTabbedView.css';

/**
 * Tabbed view component that creates a tab for each subscribed class
 * Allows opening individual class data in separate browser windows
 */
function ClassTabbedView({ data, user }) {
  const [activeTab, setActiveTab] = useState(null);
  const [closedClassIds, setClosedClassIds] = useState(new Set());
  const { removeClassData } = useWebSocket();

  console.log('🔷 ClassTabbedView render - dati ricevuti:', data?.length || 0, 'records');

  // Group data by class
  const classTabs = useMemo(() => {
    console.log('🔷 ClassTabbedView: Grouping', data?.length || 0, 'records');
    const grouped = {};
    data.forEach(item => {
      console.log('  - Processing item:', item.classId, item.className, 'isEmpty:', item.isEmpty);
      const classId = item.classId;
      // Skip closed subscriptions
      if (closedClassIds.has(classId)) {
        console.log('    ⏭️ Skipping closed classId:', classId);
        return;
      }
      if (!grouped[classId]) {
        grouped[classId] = {
          classId,
          className: item.className,
          records: []
        };
        console.log('    ✅ Created tab for classId:', classId, 'className:', item.className);
      }
      // Don't add placeholder records to the grid (isEmpty flag)
      // They're only used to create the TAB
      if (!item.isEmpty) {
        grouped[classId].records.push(item);
      } else {
        console.log('    📭 Placeholder record for empty class (TAB only)');
      }
    });

    // Convert to array and sort by className
    const tabs = Object.values(grouped).sort((a, b) => 
      a.className.localeCompare(b.className)
    );
    console.log('✅ ClassTabbedView: Created', tabs.length, 'tabs:', tabs.map(t => `${t.classId}:${t.className}`));
    return tabs;
  }, [data, closedClassIds]);

  // Set active tab to first available class or restore from session storage
  useEffect(() => {
    if (classTabs.length === 0) {
      setActiveTab(null);
      return;
    }

    // Try to restore from session storage
    const savedTab = sessionStorage.getItem('activeClassTab');
    if (savedTab) {
      const tabExists = classTabs.find(tab => tab.classId === savedTab);
      if (tabExists) {
        setActiveTab(savedTab);
        return;
      }
    }

    // Default to first tab
    setActiveTab(classTabs[0].classId);
  }, [classTabs]);

  // Save active tab to session storage
  useEffect(() => {
    if (activeTab) {
      sessionStorage.setItem('activeClassTab', activeTab);
    }
  }, [activeTab]);

  // Get data for active tab
  const activeTabData = useMemo(() => {
    if (!activeTab) return [];
    const tab = classTabs.find(t => t.classId === activeTab);
    return tab ? tab.records : [];
  }, [activeTab, classTabs]);

  // Open class in new browser tab
  const openInNewWindow = (classId, className) => {
    const url = `/class-view/${classId}?className=${encodeURIComponent(className)}`;
    // Open in new tab (not popup window) by using '_blank' without window features
    window.open(url, '_blank');
  };

  // Close subscription
  const closeSubscription = async (classId, className) => {
    try {
      console.log('🗑️ Closing subscription for user:', user.username, 'classId:', classId);
      await api.subscriptions.deleteByClassId(user.username, classId);
      
      // Remove data from WebSocket context (clears antenna in subscriptions page)
      removeClassData(classId);
      
      // Add to closed classes to hide tab
      setClosedClassIds(prev => new Set([...prev, classId]));
      
      // Reset active tab if it was the closed one
      if (activeTab === classId) {
        setActiveTab(null);
      }
      
      console.log('✅ Subscription closed successfully');
      
    } catch (error) {
      console.error('❌ Failed to close subscription:', error);
      alert(`Errore nella chiusura della sottoscrizione: ${error.message}`);
    }
  };

  if (classTabs.length === 0) {
    return (
      <div className="no-tabs-message">
        <p>Nessuna classe sottoscritta.</p>
        <p className="hint">
          Vai alla pagina <strong>Sottoscrizioni</strong> per sottoscrivere le classi dati.
        </p>
      </div>
    );
  }

  return (
    <div className="class-tabs-container">
      {/* Tabs bar */}
      <div className="tabs-bar">
        {classTabs.map(tab => (
          <div
            key={tab.classId}
            className={`tab-item ${activeTab === tab.classId ? 'active' : ''}`}
          >
            <button
              className="tab-button"
              onClick={() => setActiveTab(tab.classId)}
              title={`Mostra ${tab.className}`}
            >
              <span className="tab-name">{tab.className}</span>
              <span className="tab-count">{tab.records.length}</span>
            </button>
            <button
              className="popout-button"
              onClick={(e) => {
                e.stopPropagation();
                openInNewWindow(tab.classId, tab.className);
              }}
              title={`Apri ${tab.className} in nuovo tab del browser`}
              aria-label="Apri in nuovo tab"
            >
              🗗
            </button>
            <button
              className="close-button"
              onClick={(e) => {
                e.stopPropagation();
                closeSubscription(tab.classId, tab.className);
              }}
              title={`Chiudi sottoscrizione per ${tab.className}`}
              aria-label="Chiudi sottoscrizione"
            >
              ✕
            </button>
          </div>
        ))}
      </div>

      {/* Active tab content */}
      <div className="tab-content">
        {activeTab ? (
          <DynamicDataGrid data={activeTabData} />
        ) : (
          <div className="no-data-message">
            <p>Seleziona un tab per visualizzare i dati.</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default ClassTabbedView;
