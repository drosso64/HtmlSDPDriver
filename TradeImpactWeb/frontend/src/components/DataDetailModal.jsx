import { useState, useEffect, useMemo } from 'react';
import './DataDetailModal.css';

/**
 * Modal for displaying complex data structures (objects, arrays)
 * @param {boolean} isEditing - If true, allows editing the data
 * @param {function} onSave - Callback when saving edited data
 */
/**
 * @param {object} schema - Schema nested (da ClassIntrospectionService).
 *   Contiene .fields[] con la struttura dei campi.
 *   Usato per:
 *   - Mostrare campi in oggetti vuoti
 *   - Creare righe vuote in array vuoti
 */
function DataDetailModal({ isOpen, onClose, data, title, isEditing = false, onSave, schema = null }) {
  const [nestedModal, setNestedModal] = useState(null);
  const [editedData, setEditedData] = useState(data);

  // Update editedData when data changes
  // Se l'oggetto è vuoto ma lo schema ha i campi, inizializza con i defaults.
  // Questo garantisce che i campi siano editabili fin dall'apertura.
  useEffect(() => {
    if (data && typeof data === 'object' && !Array.isArray(data) && 
        Object.keys(data).length === 0 && schema?.fields) {
      // Oggetto vuoto + schema disponibile: crea defaults
      const defaults = {};
      schema.fields.forEach(f => {
        if (f.jsonType === 'boolean') defaults[f.name] = false;
        else if (f.jsonType === 'number') defaults[f.name] = 0;
        else if (f.array) defaults[f.name] = [];
        else if (f.nested) defaults[f.name] = {};
        else defaults[f.name] = null;
      });
      console.log('📋 DataDetailModal: initialized empty object from schema with', Object.keys(defaults).length, 'fields');
      setEditedData(defaults);
    } else {
      setEditedData(data);
    }
  }, [data, schema]);

  // Mappa fieldName → fieldSchema per lookup rapido del sotto-schema
  // Serve per propagare lo schema ai livelli annidati
  const fieldSchemaMap = useMemo(() => {
    if (!schema?.fields) return {};
    const map = {};
    schema.fields.forEach(f => { map[f.name] = f; });
    return map;
  }, [schema]);

  if (!isOpen) return null;

  /**
   * Apre il modal annidato per un campo complesso.
   * 
   * IMPORTANTE: cerca il sotto-schema per il campo cliccato.
   * Per un campo array/nested, il sotto-schema è fieldSchema.nestedSchema.
   * Questo garantisce che il modal annidato possa:
   * - Mostrare campi per oggetti vuoti (creazione nuovo record)
   * - Creare righe vuote per array vuoti
   * - Propagare ricorsivamente lo schema a ulteriori livelli
   */
  const handleNestedClick = (nestedData, nestedTitle, fieldName, arrayIndex) => {
    // Cerca il sotto-schema per questo campo
    const fieldSchema = fieldSchemaMap[fieldName];
    const nestedSchema = fieldSchema?.nestedSchema || null;
    setNestedModal({ data: nestedData, title: nestedTitle, fieldName, arrayIndex, schema: nestedSchema });
  };

  const handleNestedSave = (newData) => {
    // Aggiorna il campo nel parent editedData
    const { fieldName, arrayIndex } = nestedModal;
    setEditedData(prev => {
      if (Array.isArray(prev) && arrayIndex != null) {
        // Parent è un array: aggiorna l'elemento all'indice specificato
        const newArray = [...prev];
        if (fieldName && typeof newArray[arrayIndex] === 'object' && !Array.isArray(newArray[arrayIndex])) {
          // Aggiorna un campo specifico dell'elemento (es. editedData[2].legs = newData)
          newArray[arrayIndex] = { ...newArray[arrayIndex], [fieldName]: newData };
        } else {
          // Sostituisce l'intero elemento (es. editedData[2] = newData)
          newArray[arrayIndex] = newData;
        }
        return newArray;
      }
      if (fieldName) {
        // Parent è un oggetto: aggiorna il campo
        return { ...prev, [fieldName]: newData };
      }
      return newData;
    });
    setNestedModal(null);
  };

  const closeNestedModal = () => {
    setNestedModal(null);
  };

  /**
   * Renderizza il valore di un campo.
   * @param value - il valore da renderizzare
   * @param displayKey - etichetta di visualizzazione (es. "campo[0]")
   * @param schemaKey - nome del campo per lookup nello schema (es. "campo"); se omesso, usa displayKey
   * @param arrayIndex - indice dell'elemento nell'array parent (opzionale, solo per celle in array di oggetti)
   */
  const renderValue = (value, displayKey, schemaKey, arrayIndex) => {
    const fieldName = schemaKey || displayKey;

    if (value === null || value === undefined) {
      return <span className="null-value">null</span>;
    }

    // Array
    if (Array.isArray(value)) {
      return (
        <button
          className="detail-link"
          onClick={() => handleNestedClick(value, `${displayKey} [${value.length} elementi]`, fieldName, arrayIndex)}
        >
          Array[{value.length}] 👁️ {isEditing ? '✏️' : ''}
        </button>
      );
    }

    // Nested object
    if (typeof value === 'object') {
      const typeName = value._type || 'Object';
      return (
        <button
          className="detail-link"
          onClick={() => handleNestedClick(value, `${displayKey}: ${typeName}`, fieldName, arrayIndex)}
        >
          {typeName} 👁️ {isEditing ? '✏️' : ''}
        </button>
      );
    }

    // Primitive
    return <span className="primitive-value">{String(value)}</span>;
  };

  const handleObjectFieldChange = (key, value) => {
    if (!isEditing) return;
    setEditedData(prev => ({ ...prev, [key]: value }));
  };

  const renderObjectDetails = (obj) => {
    const entries = Object.entries(obj).filter(([key]) => !key.startsWith('_'));
    
    return (
      <div className="object-details">
        <table className="detail-table">
          <thead>
            <tr>
              <th>Campo</th>
              <th>Valore</th>
            </tr>
          </thead>
          <tbody>
            {entries.map(([key, value]) => (
              <tr key={key}>
                <td className="field-name">{key}</td>
                <td className="field-value">
                  {isEditing && (value === null || typeof value === 'string' || typeof value === 'number' || typeof value === 'boolean')
                    ? renderEditableObjectField(key, value)
                    : renderValue(value, key)}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  };

  const renderEditableObjectField = (key, value) => {
    if (typeof value === 'boolean') {
      return (
        <label className="field-checkbox">
          <input type="checkbox" checked={!!editedData[key]} 
                 onChange={(e) => handleObjectFieldChange(key, e.target.checked)} />
          <span>{editedData[key] ? 'true' : 'false'}</span>
        </label>
      );
    }
    if (typeof value === 'number') {
      return (
        <input type="number" value={editedData[key] ?? 0} className="cell-input"
               onChange={(e) => handleObjectFieldChange(key, parseFloat(e.target.value) || 0)} />
      );
    }
    // String or null
    return (
      <input type="text" value={editedData[key] ?? ''} className="cell-input"
             onChange={(e) => handleObjectFieldChange(key, e.target.value)} />
    );
  };

  const renderArrayOfScalars = (arr) => {
    return (
      <div className="array-details">
        <table className="detail-table">
          <thead>
            <tr>
              <th>Index</th>
              <th>Valore</th>
            </tr>
          </thead>
          <tbody>
            {arr.map((item, index) => (
              <tr key={index}>
                <td className="array-index">{index}</td>
                <td className="field-value">
                  {typeof item === 'object' ? renderValue(item, `[${index}]`, undefined, index) : String(item)}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  };

  const handleArrayItemChange = (index, key, value) => {
    if (!isEditing) return;
    
    const newArray = [...editedData];
    newArray[index] = { ...newArray[index], [key]: value };
    setEditedData(newArray);
  };

  /**
   * Crea un oggetto vuoto dalla struttura dello schema o dal primo elemento esistente.
   * Lo schema è la fonte di verità; il primo elemento è il fallback.
   */
  const createEmptyRow = () => {
    const newRow = {};
    
    // PRIORITÀ 1: usa lo schema (reflection Java)
    if (schema?.fields) {
      schema.fields.forEach(f => {
        if (f.jsonType === 'boolean') newRow[f.name] = false;
        else if (f.jsonType === 'number') newRow[f.name] = 0;
        else if (f.array) newRow[f.name] = [];
        else if (f.nested) newRow[f.name] = {};
        else newRow[f.name] = '';
      });
      return newRow;
    }
    
    // PRIORITÀ 2: copia struttura dal primo elemento esistente
    if (Array.isArray(editedData) && editedData.length > 0 && typeof editedData[0] === 'object') {
      Object.keys(editedData[0]).forEach(key => {
        const value = editedData[0][key];
        if (typeof value === 'boolean') newRow[key] = false;
        else if (typeof value === 'number') newRow[key] = 0;
        else if (typeof value === 'string') newRow[key] = '';
        else newRow[key] = null;
      });
      return newRow;
    }
    
    return newRow;
  };

  const handleAddRow = () => {
    if (!isEditing || !Array.isArray(editedData)) return;
    
    const newRow = createEmptyRow();
    if (Object.keys(newRow).length === 0) return; // Nessuna struttura nota
    
    setEditedData([...editedData, newRow]);
  };

  const handleDeleteRow = (index) => {
    if (!isEditing) return;
    
    const newArray = editedData.filter((_, i) => i !== index);
    setEditedData(newArray);
  };

  const handleSave = () => {
    console.log('💾 Saving edited data:', editedData);
    if (onSave) {
      onSave(editedData);
    }
    onClose();
  };

  const renderArrayOfObjects = (arr) => {
    if (arr.length === 0) {
      // Array vuoto: mostra solo il pulsante "Aggiungi" se in editing e lo schema è disponibile
      return (
        <div className="array-details">
          <div className="empty-array">Array vuoto - {schema?.fields ? `${schema.fields.length} campi definiti nello schema` : 'nessuno schema disponibile'}</div>
          {isEditing && schema?.fields && (
            <div className="array-actions">
              <button className="btn-add-row" onClick={handleAddRow}>
                ➕ Aggiungi Riga
              </button>
            </div>
          )}
        </div>
      );
    }

    console.log('🔍 Array to render:', arr);
    console.log('🔍 Array length:', arr.length);
    console.log('🔍 First 3 items:', arr.slice(0, 3));

    // Get all unique keys from first object to preserve field order
    // Then add any additional keys from other objects
    const keys = [];
    const seenKeys = new Set();
    
    // First pass: get keys from first object (preserves order)
    if (arr[0] && typeof arr[0] === 'object') {
      console.log('🔍 First array item:', arr[0]);
      console.log('🔍 Keys in first item:', Object.keys(arr[0]));
      
      Object.keys(arr[0]).forEach(key => {
        // Filter out internal/metadata fields
        if (!key.startsWith('_') &&
            key !== 'cLASS_ID' &&
            key !== 'classid' &&
            key !== 'classId' &&
            key !== 'ClassId' &&
            key !== 'className' &&
            key !== 'class' &&
            key !== 'sMPClassId') {
          keys.push(key);
          seenKeys.add(key);
        }
      });
    }
    
    console.log('🔍 Final keys for columns:', keys);
    
    // Second pass: add any missing keys from other objects
    arr.forEach(obj => {
      if (typeof obj === 'object' && obj !== null) {
        Object.keys(obj).forEach(key => {
          if (!seenKeys.has(key) &&
              !key.startsWith('_') &&
              key !== 'cLASS_ID' &&
              key !== 'classid' &&
              key !== 'classId' &&
              key !== 'ClassId' &&
              key !== 'className' &&
              key !== 'class' &&
              key !== 'sMPClassId') {
            keys.push(key);
            seenKeys.add(key);
          }
        });
      }
    });
    
    console.log('🔍 Final keys for columns:', keys);

    return (
      <div className="array-details">
        <table className="detail-table">
          <thead>
            <tr>
              <th>Idx</th>
              {keys.map(key => {
                console.log('🔍 Header column:', key);
                return <th key={key}>{key}</th>;
              })}
              {isEditing && <th className="action-column">Azioni</th>}
            </tr>
          </thead>
          <tbody>
            {arr.map((item, index) => {
              if (index === 0) console.log(`🔍 First row item:`, item);
              
              return (
                <tr key={index}>
                  <td className="array-index">{index}</td>
                  {keys.map(key => {
                    const cellValue = item && typeof item === 'object' ? item[key] : '-';
                    if (index === 0) console.log(`  🔍 Cell [0][${key}]:`, cellValue);
                    
                    // Render editable input if in edit mode
                    if (isEditing && item && typeof item === 'object') {
                      const value = item[key];
                      
                      // Handle different types
                      if (typeof value === 'boolean') {
                        return (
                          <td key={key} className="field-value">
                            <input
                              type="checkbox"
                              checked={!!value}
                              onChange={(e) => handleArrayItemChange(index, key, e.target.checked)}
                            />
                          </td>
                        );
                      } else if (typeof value === 'number') {
                        return (
                          <td key={key} className="field-value">
                            <input
                              type="number"
                              value={value ?? 0}
                              onChange={(e) => handleArrayItemChange(index, key, parseFloat(e.target.value) || 0)}
                              className="cell-input"
                            />
                          </td>
                        );
                      } else if (typeof value === 'string') {
                        return (
                          <td key={key} className="field-value">
                            <input
                              type="text"
                              value={value ?? ''}
                              onChange={(e) => handleArrayItemChange(index, key, e.target.value)}
                              className="cell-input"
                            />
                          </td>
                        );
                      }
                    }
                    
                    // Read-only mode or complex types (array/object) in edit mode
                    return (
                      <td key={key} className="field-value">
                        {item && typeof item === 'object' 
                          ? renderValue(item[key], `${key}[${index}]`, key, index)
                          : '-'}
                      </td>
                    );
                  })}
                  {isEditing && (
                    <td className="action-column">
                      <button
                        className="btn-delete-row"
                        onClick={() => handleDeleteRow(index)}
                        title="Elimina questa riga"
                      >
                        🗑️
                      </button>
                    </td>
                  )}
                </tr>
              );
            })}
          </tbody>
        </table>
        {isEditing && (
          <div className="array-actions">
            <button className="btn-add-row" onClick={handleAddRow}>
              ➕ Aggiungi Riga
            </button>
          </div>
        )}
      </div>
    );
  };

  const renderContent = () => {
    const dataToRender = isEditing ? editedData : data;
    
    if (!dataToRender) {
      return <div className="no-data">Nessun dato disponibile</div>;
    }

    // Array
    if (Array.isArray(dataToRender)) {
      if (dataToRender.length === 0) {
        // Array vuoto: usa renderArrayOfObjects per mostrare il pulsante "Aggiungi"
        // se lo schema è disponibile
        return renderArrayOfObjects(dataToRender);
      }

      // Check if array of objects or scalars
      const firstItem = dataToRender[0];
      const isObjectArray = typeof firstItem === 'object' && firstItem !== null && !Array.isArray(firstItem);

      return isObjectArray ? renderArrayOfObjects(dataToRender) : renderArrayOfScalars(dataToRender);
    }

    // Object
    if (typeof dataToRender === 'object') {
      // Se l'oggetto è vuoto e non abbiamo schema, non c'è nulla da mostrare
      if (Object.keys(dataToRender).length === 0) {
        return <div className="empty-array">Oggetto vuoto{!schema?.fields ? ' - nessuno schema disponibile' : ''}</div>;
      }
      return renderObjectDetails(dataToRender);
    }

    // Primitive
    return <div className="primitive-value">{String(dataToRender)}</div>;
  };

  return (
    <>
      <div className="modal-overlay" onClick={onClose}>
        <div className="modal-content" onClick={(e) => e.stopPropagation()}>
          <div className="modal-header">
            <h3>{title}</h3>
            <button className="modal-close" onClick={onClose}>✕</button>
          </div>
          <div className="modal-body">
            {renderContent()}
          </div>
          <div className="modal-footer">
            {isEditing && (
              <button className="btn-save" onClick={handleSave}>
                💾 Salva
              </button>
            )}
            <button className="btn-close" onClick={onClose}>Chiudi</button>
          </div>
        </div>
      </div>

      {/* Nested modal - STESSO codice ricorsivo con schema/isEditing/onSave propagati */}
      {nestedModal && (
        <DataDetailModal
          isOpen={true}
          onClose={closeNestedModal}
          data={nestedModal.data}
          title={nestedModal.title}
          isEditing={isEditing}
          onSave={handleNestedSave}
          schema={nestedModal.schema}
        />
      )}
    </>
  );
}

export default DataDetailModal;
