import { useState, useMemo, useEffect } from 'react';
import DynamicDataGrid from './DynamicDataGrid';
import './ClassTabbedView.css';

/**
 * Tabbed view component that creates a tab for each subscribed class
 * Allows opening individual class data in separate browser windows
 */
function ClassTabbedView({ data }) {
  const [activeTab, setActiveTab] = useState(null);

  console.log('🔷 ClassTabbedView render - dati ricevuti:', data?.length || 0, 'records');

  // Group data by class
  const classTabs = useMemo(() => {
    const grouped = {};
    data.forEach(item => {
      const classId = item.classId;
      if (!grouped[classId]) {
        grouped[classId] = {
          classId,
          className: item.className,
          records: []
        };
      }
      grouped[classId].records.push(item);
    });

    // Convert to array and sort by className
    return Object.values(grouped).sort((a, b) => 
      a.className.localeCompare(b.className)
    );
  }, [data]);

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
          </div>
        ))}
      </div>

      {/* Active tab content */}
      <div className="tab-content">
        {activeTab && activeTabData.length > 0 ? (
          <DynamicDataGrid data={activeTabData} />
        ) : (
          <div className="no-data-message">
            <p>Nessun dato disponibile per questa classe.</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default ClassTabbedView;
