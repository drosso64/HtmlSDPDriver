import { useState, useEffect, useMemo } from 'react';
import DataDetailModal from './DataDetailModal';
import './RecordDetailModal.css';

/**
 * RecordDetailModal - Modal per Visualizzazione/Modifica Record
 * 
 * ARCHITETTURA:
 * Il popup è SEMPRE costruito dallo schema (reflection Java).
 * Lo schema definisce: quali campi mostrare, i loro tipi, l'ordine.
 * Se il record esiste, i valori vengono popolati. Se no, restano vuoti.
 * 
 * UN SOLO CODICE per entrambi i casi:
 * - Record esistente: schema → struttura, record → valori
 * - Nuovo record: schema → struttura, valori = default (null/0/false)
 * 
 * @param {boolean} isOpen - Controlla visibilità modal
 * @param {function} onClose - Callback per chiudere modal
 * @param {object} record - Record con valori (può essere template vuoto)
 * @param {function} onAction - Callback per azioni (ADD/RWT/DEL)
 * @param {boolean} isNewRecord - Se true, editing abilitato di default
 * @param {object} schema - Schema classe dalla reflection Java
 */
function RecordDetailModal({ isOpen, onClose, record, onAction, isNewRecord = false, schema = null }) {
  const [editedData, setEditedData] = useState({});
  const [isEditing, setIsEditing] = useState(false);
  const [structuredDataModal, setStructuredDataModal] = useState(null);

  // Lista campi definita dallo SCHEMA (unica fonte di verità per la struttura)
  // Se lo schema non è disponibile, fallback su Object.keys(record)
  const fields = useMemo(() => {
    if (schema?.fields) {
      return schema.fields.map(f => f.name);
    }
    // Fallback: usa le chiavi del record, filtrate
    if (!record) return [];
    return Object.keys(record).filter(
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
  }, [schema, record]);

  // Build a fieldName → fieldSchema map for quick type lookup
  const fieldSchemaMap = useMemo(() => {
    if (!schema?.fields) return {};
    const map = {};
    schema.fields.forEach(f => { map[f.name] = f; });
    return map;
  }, [schema]);

  useEffect(() => {
    if (record && isOpen) {
      // Inizializza i valori del form.
      // I CAMPI sono definiti dallo schema (o dal record come fallback).
      // I VALORI vengono dal record: se il campo esiste nel record, usa
      // quel valore; altrimenti usa il default dal tipo dello schema.
      const initialData = {};
      fields.forEach(fieldName => {
        if (record[fieldName] !== undefined) {
          initialData[fieldName] = record[fieldName];
        } else {
          // Campo nello schema ma non nel record: usa default per tipo
          const fieldSchema = fieldSchemaMap[fieldName];
          if (fieldSchema) {
            if (fieldSchema.array) initialData[fieldName] = [];
            else if (fieldSchema.nested) initialData[fieldName] = {};
            else if (fieldSchema.jsonType === 'boolean') initialData[fieldName] = false;
            else if (fieldSchema.jsonType === 'number') initialData[fieldName] = 0;
            else initialData[fieldName] = null;
          } else {
            initialData[fieldName] = null;
          }
        }
      });
      setEditedData(initialData);
      setIsEditing(isNewRecord);
    }
  }, [record, isOpen, isNewRecord, fields, fieldSchemaMap]);

  if (!isOpen || !record) return null;

  const handleFieldChange = (fieldName, value) => {
    setEditedData(prev => ({
      ...prev,
      [fieldName]: value
    }));
  };

  const handleADD = () => {
    // ADD = INSERT (nuovo record)
    // Il modale resta aperto fino a completamento transazione
    if (onAction) {
      onAction('ADD', editedData);
    }
  };

  const handleRWT = () => {
    // RWT = REWRITE (update record esistente)
    // Il modale resta aperto fino a completamento transazione
    if (onAction) {
      onAction('RWT', editedData);
    }
  };

  const handleDEL = () => {
    // DEL = DELETE (elimina record)
    // Il modale resta aperto fino a completamento transazione
    if (onAction) {
      onAction('DEL', record);
    }
  };

  const handleStructuredDataSave = (newData) => {
    // Update the field in editedData with the modified array/object
    const fieldName = structuredDataModal.fieldName;
    console.log('📥 Receiving structured data:', fieldName, newData);
    handleFieldChange(fieldName, newData);
    setStructuredDataModal(null);
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
  /**
   * Determina il tipo di un campo usando UNA SOLA logica:
   * 1. Se il valore ha un tipo runtime riconoscibile, usa quello
   * 2. Altrimenti consulta lo schema (stessa reflection Java)
   * 
   * Questo garantisce comportamento identico per record nuovi e esistenti.
   */
  const getFieldType = (fieldName, value) => {
    // Runtime type detection (quando il valore è presente)
    if (Array.isArray(value)) return 'array';
    if (typeof value === 'object' && value !== null) return 'object';
    if (typeof value === 'boolean') return 'boolean';
    if (typeof value === 'number') return 'number';
    if (typeof value === 'string' && value !== '') return 'string';
    
    // Schema type detection (quando il valore è null/0/vuoto)
    const fieldSchema = fieldSchemaMap[fieldName];
    if (fieldSchema) {
      if (fieldSchema.array) return 'array';
      if (fieldSchema.nested) return 'object';
      if (fieldSchema.jsonType === 'boolean') return 'boolean';
      if (fieldSchema.jsonType === 'number') return 'number';
    }
    
    return 'string';
  };

  const renderFieldInput = (fieldName, value) => {
    const fieldType = getFieldType(fieldName, value);
    
    // CASO 1: Tipi complessi (Array, Object)
    // Mostra badge per aprire modal editabile
    if (fieldType === 'array' || fieldType === 'object') {
      const displayValue = value ?? (fieldType === 'array' ? [] : {});
      const typeLabel = fieldType === 'array' 
        ? `Array[${Array.isArray(displayValue) ? displayValue.length : 0}]` 
        : (displayValue?._type || 'Object');
      // Passa lo schema nested al modal: serve per creare righe vuote in array
      // e mostrare campi in oggetti vuoti
      const nestedSchema = fieldSchemaMap[fieldName]?.nestedSchema || null;
      return (
        <button
          className="field-structured-btn"
          onClick={() => setStructuredDataModal({ data: displayValue, title: fieldName, fieldName, nestedSchema })}
          type="button"
        >
          {typeLabel} 👁️ {isEditing ? '✏️' : ''}
        </button>
      );
    }

    // CASO 2: Boolean → Checkbox
    if (fieldType === 'boolean') {
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

    // CASO 3: Number
    if (fieldType === 'number') {
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

    // CASO 4: String (default)
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
                  {renderFieldInput(fieldName, editedData[fieldName])}
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
          isEditing={isEditing}
          onSave={handleStructuredDataSave}
          schema={structuredDataModal.nestedSchema}
        />
      )}
    </div>
  );
}

export default RecordDetailModal;
