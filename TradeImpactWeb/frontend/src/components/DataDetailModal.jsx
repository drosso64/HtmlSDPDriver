import { useState } from 'react';
import './DataDetailModal.css';

/**
 * Modal for displaying complex data structures (objects, arrays)
 */
function DataDetailModal({ isOpen, onClose, data, title }) {
  const [nestedModal, setNestedModal] = useState(null);

  if (!isOpen) return null;

  const handleNestedClick = (nestedData, nestedTitle) => {
    setNestedModal({ data: nestedData, title: nestedTitle });
  };

  const closeNestedModal = () => {
    setNestedModal(null);
  };

  const renderValue = (value, key) => {
    if (value === null || value === undefined) {
      return <span className="null-value">null</span>;
    }

    // Array
    if (Array.isArray(value)) {
      return (
        <button
          className="detail-link"
          onClick={() => handleNestedClick(value, `${key} [${value.length} elementi]`)}
        >
          Array[{value.length}] 👁️
        </button>
      );
    }

    // Nested object
    if (typeof value === 'object') {
      const typeName = value._type || 'Object';
      return (
        <button
          className="detail-link"
          onClick={() => handleNestedClick(value, `${key}: ${typeName}`)}
        >
          {typeName} 👁️
        </button>
      );
    }

    // Primitive
    return <span className="primitive-value">{String(value)}</span>;
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
                <td className="field-value">{renderValue(value, key)}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
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
                  {typeof item === 'object' ? renderValue(item, `[${index}]`) : String(item)}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  };

  const renderArrayOfObjects = (arr) => {
    if (arr.length === 0) {
      return <div className="empty-array">Array vuoto</div>;
    }

    // Get all unique keys from all objects
    const allKeys = new Set();
    arr.forEach(obj => {
      if (typeof obj === 'object' && obj !== null) {
        Object.keys(obj).forEach(key => {
          if (!key.startsWith('_')) {
            allKeys.add(key);
          }
        });
      }
    });

    const keys = Array.from(allKeys);

    return (
      <div className="array-details">
        <table className="detail-table">
          <thead>
            <tr>
              <th>Idx</th>
              {keys.map(key => (
                <th key={key}>{key}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {arr.map((item, index) => (
              <tr key={index}>
                <td className="array-index">{index}</td>
                {keys.map(key => (
                  <td key={key} className="field-value">
                    {item && typeof item === 'object' 
                      ? renderValue(item[key], `${key}[${index}]`)
                      : '-'}
                  </td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  };

  const renderContent = () => {
    if (!data) {
      return <div className="no-data">Nessun dato disponibile</div>;
    }

    // Array
    if (Array.isArray(data)) {
      if (data.length === 0) {
        return <div className="empty-array">Array vuoto</div>;
      }

      // Check if array of objects or scalars
      const firstItem = data[0];
      const isObjectArray = typeof firstItem === 'object' && firstItem !== null && !Array.isArray(firstItem);

      return isObjectArray ? renderArrayOfObjects(data) : renderArrayOfScalars(data);
    }

    // Object
    if (typeof data === 'object') {
      return renderObjectDetails(data);
    }

    // Primitive
    return <div className="primitive-value">{String(data)}</div>;
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
            <button className="btn-close" onClick={onClose}>Chiudi</button>
          </div>
        </div>
      </div>

      {/* Nested modal */}
      {nestedModal && (
        <DataDetailModal
          isOpen={true}
          onClose={closeNestedModal}
          data={nestedModal.data}
          title={nestedModal.title}
        />
      )}
    </>
  );
}

export default DataDetailModal;
