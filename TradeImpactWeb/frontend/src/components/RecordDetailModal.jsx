import { useState, useEffect } from 'react';
import DataDetailModal from './DataDetailModal';
import './RecordDetailModal.css';

/**
 * RecordDetailModal - Modal per Visualizzazione/Modifica Record Completo
 * 
 * SCOPO:
 * Mostra TUTTI i campi di un record (anche quelli nascosti nella griglia)
 * in un form editabile con tre azioni: ADD (insert), RWT (update), DEL (delete)
 * 
 * DUE MODALITÀ D'USO:
 * 
 * 1. VISUALIZZA/MODIFICA record esistente (badge 📋 su riga grid)
 *    - Passa isNewRecord={false}
 *    - Mostra tutti e tre i bottoni: ADD, RWT, DEL
 *    - Toggle "Abilita Modifica" per editare campi
 * 
 * 2. INSERISCI nuovo record (badge ➕ Nuovo Record in header)
 *    - Passa isNewRecord={true}
 *    - Mostra solo bottone ADD
 *    - Editing automaticamente abilitato
 *    - record contiene template vuoto (tutti campi = null o default)
 * 
 * FILTRAGGIO CAMPI:
 * Esclude stessi campi interni della grid:
 * - Metadata: _rowId, _type (interni React/TanStack)
 * - Timestamp: gestito separatamente (solo visualizzazione)
 * - Campi SDP: cLASS_ID, classid, class, sMPClassId, className
 * 
 * GESTIONE TIPI DATI:
 * - Boolean: Checkbox
 * - Number: Input type="number"
 * - String: Input type="text"
 * - Array/Object: Solo visualizzazione "(non modificabile)"
 * 
 * TODO FUTURE:
 * - Combo/select per campi enum (es: Side: BUY/SELL)
 * - Validazione campi prima di submit
 * - Date picker per campi timestamp
 * - Nested object editor (attualmente read-only)
 * 
 * AZIONI:
 * - ADD: Inserisce nuovo record (TODO: implementare SDP transaction)
 * - RWT: Aggiorna record esistente (TODO: implementare SDP transaction)
 * - DEL: Elimina record (TODO: implementare SDP transaction)
 * 
 * @param {boolean} isOpen - Controlla visibilità modal
 * @param {function} onClose - Callback per chiudere modal
 * @param {object} record - Record da visualizzare/modificare
 * @param {function} onAction - Callback per azioni (ADD/RWT/DEL)
 * @param {boolean} isNewRecord - Se true, è inserimento nuovo record
 * 
 * @see DynamicDataGrid.jsx - Apre questo modal con badge 📋 e ➕
 * @see MAINTENANCE.md#scenario-4 - Come implementare transazioni SDP
 */
function RecordDetailModal({ isOpen, onClose, record, onAction, isNewRecord = false }) {
  const [editedData, setEditedData] = useState({});
  const [isEditing, setIsEditing] = useState(false);
  const [structuredDataModal, setStructuredDataModal] = useState(null);

  useEffect(() => {
    if (record && isOpen) {
      // INIZIALIZZAZIONE FORM
      // Copia tutti i campi dal record escludendo metadata tecnici
      // Stessa logica di filtraggio della grid per coerenza
      const initialData = {};
      Object.keys(record).forEach(key => {
        if (!key.startsWith('_') &&          // Escludi _rowId, _type
            key !== 'timestamp' &&            // Timestamp non editabile
            key !== 'className' &&            // Già mostrato in header
            key !== 'cLASS_ID' &&             // Metadata SDP
            key !== 'classid' &&              // Metadata SDP (lowercase)
            key !== 'classId' &&              // Metadata SDP (camelCase)
            key !== 'ClassId' &&              // Metadata SDP (PascalCase)
            key !== 'class' &&                // Duplicate
            key !== 'sMPClassId') {           // Metadata SDP
          initialData[key] = record[key];
        }
      });
      setEditedData(initialData);
      
      // AUTO-ENABLE editing per nuovi record
      // (non ha senso inserire record in read-only)
      setIsEditing(isNewRecord);
    }
  }, [record, isOpen, isNewRecord]);

  if (!isOpen || !record) return null;

  const handleFieldChange = (fieldName, value) => {
    setEditedData(prev => ({
      ...prev,
      [fieldName]: value
    }));
  };

  const handleADD = () => {
    // ADD = INSERT (nuovo record)
    // Invia tutti i campi editati al backend
    // TODO: Implementare chiamata REST a TransactionController
    if (onAction) {
      onAction('ADD', editedData);
    }
    onClose();
  };

  const handleRWT = () => {
    // RWT = REWRITE (update record esistente)
    // Invia solo campi modificati (editedData contiene tutti i campi)
    // TODO: Implementare chiamata REST a TransactionController
    if (onAction) {
      onAction('RWT', editedData);
    }
    onClose();
  };

  const handleDEL = () => {
    // DEL = DELETE (elimina record)
    // Invia chiave business per identificare record da eliminare
    // TODO: Implementare chiamata REST a TransactionController
    if (onAction) {
      onAction('DEL', record);
    }
    onClose();
  };

  /**
   * Renderizza input appropriato per tipo di dato
   * 
   * STRATEGIA:
   * - Boolean → checkbox
   * - Number → input type="number"
   * - String → input type="text"
   * - Array/Object → label "(non modificabile)" (TODO: nested editor)
   * 
   * TODO FUTURE:
   * - Enum → select dropdown con valori possibili
   * - Date → date picker
   * - Nested objects → modal ricorsivo o JSON editor
   */
  const renderFieldInput = (fieldName, value) => {
    // CASO 1: Tipi complessi (Array, Object)
    // Mostra badge per aprire modal editabile
    if (Array.isArray(value) || (typeof value === 'object' && value !== null)) {
      const typeLabel = Array.isArray(value) ? `Array[${value.length}]` : (value._type || 'Object');
      return (
        <button
          className="field-structured-btn"
          onClick={() => setStructuredDataModal({ data: value, title: fieldName, fieldName })}
          type="button"
        >
          {typeLabel} 👁️ {isEditing ? '✏️' : ''}
        </button>
      );
    }

    // CASO 2: Boolean → Checkbox
    if (typeof value === 'boolean') {
      return (
        <label className="field-checkbox">
          <input
            type="checkbox"
            checked={editedData[fieldName] ?? false}
            onChange={(e) => handleFieldChange(fieldName, e.target.checked)}
            disabled={!isEditing}
          />
          <span>{editedData[fieldName] ? 'true' : 'false'}</span>
        </label>
      );
    }

    // Number
    if (typeof value === 'number') {
      return (
        <input
          type="number"
          value={editedData[fieldName] ?? ''}
          onChange={(e) => handleFieldChange(fieldName, parseFloat(e.target.value) || 0)}
          disabled={!isEditing}
          className="field-input"
        />
      );
    }

    // String (default)
    return (
      <input
        type="text"
        value={editedData[fieldName] ?? ''}
        onChange={(e) => handleFieldChange(fieldName, e.target.value)}
        disabled={!isEditing}
        className="field-input"
      />
    );
  };

  const fields = Object.keys(record).filter(
    key => !key.startsWith('_') && 
           key !== 'timestamp' && 
           key !== 'className' && 
           key !== 'cLASS_ID' && 
           key !== 'classid' &&
           key !== 'classId' &&
           key !== 'ClassId' &&
           key !== 'class' &&
           key !== 'sMPClassId'
  );

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content record-detail-modal" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h3>{isNewRecord ? 'Nuovo Record' : 'Dettagli Record'} - {record.className}</h3>
          <button className="modal-close" onClick={onClose} aria-label="Chiudi">
            ✕
          </button>
        </div>

        <div className="modal-body">
          <div className="record-metadata">
            <div className="metadata-item">
              <span className="metadata-label">Classe:</span>
              <span className="metadata-value">{record.className} ({record.classId})</span>
            </div>
            <div className="metadata-item">
              <span className="metadata-label">Timestamp:</span>
              <span className="metadata-value">
                {new Date(record.timestamp).toLocaleString('it-IT')}
              </span>
            </div>
          </div>

          {!isNewRecord && (
            <div className="edit-toggle">
              <label className="toggle-switch">
                <input
                  type="checkbox"
                  checked={isEditing}
                  onChange={(e) => setIsEditing(e.target.checked)}
                />
                <span className="toggle-slider"></span>
                <span className="toggle-label">Abilita modifica</span>
              </label>
            </div>
          )}

          <div className="fields-list">
            {fields.map(fieldName => (
              <div key={fieldName} className="field-row">
                <label className="field-label">{fieldName}</label>
                <div className="field-value">
                  {renderFieldInput(fieldName, record[fieldName])}
                </div>
              </div>
            ))}
          </div>
        </div>

        <div className="modal-footer">
          <div className="action-buttons">
            {isNewRecord ? (
              <button
                className="btn btn-success"
                onClick={handleADD}
                disabled={!isEditing}
                title="Add - Inserisci nuovo record"
              >
                ➕ ADD (Insert)
              </button>
            ) : (
              <>
                <button
                  className="btn btn-success"
                  onClick={handleADD}
                  disabled={!isEditing}
                  title="Add - Inserisci come nuovo record"
                >
                  ➕ ADD (Insert)
                </button>
                <button
                  className="btn btn-primary"
                  onClick={handleRWT}
                  disabled={!isEditing}
                  title="Rewrite - Aggiorna il record"
                >
                  🔄 RWT (Update)
                </button>
                <button
                  className="btn btn-danger"
                  onClick={handleDEL}
                  title="Delete - Elimina il record"
                >
                  🗑️ DEL (Delete)
                </button>
              </>
            )}
          </div>
          <button className="btn btn-secondary" onClick={onClose}>
            Annulla
          </button>
        </div>
      </div>

      {/* Structured Data Modal (for arrays/objects) */}
      {structuredDataModal && (
        <DataDetailModal
          isOpen={true}
          onClose={() => setStructuredDataModal(null)}
          data={structuredDataModal.data}
          title={structuredDataModal.title}
        />
      )}
    </div>
  );
}

export default RecordDetailModal;
