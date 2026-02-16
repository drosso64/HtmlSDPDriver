import { useState, useEffect } from 'react';
import './TransactionForm.css';

function TransactionForm() {
  const [transactionTypes, setTransactionTypes] = useState([]);
  const [selectedType, setSelectedType] = useState('');
  const [fields, setFields] = useState([]);
  const [formData, setFormData] = useState({});
  const [loading, setLoading] = useState(false);
  const [result, setResult] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchTransactionTypes();
  }, []);

  useEffect(() => {
    if (selectedType) {
      fetchTransactionFields(selectedType);
    }
  }, [selectedType]);

  const fetchTransactionTypes = async () => {
    try {
      const response = await fetch('/api/transactions/types');
      if (response.ok) {
        const data = await response.json();
        setTransactionTypes(data);
      }
    } catch (err) {
      console.error('Error fetching transaction types:', err);
    }
  };

  const fetchTransactionFields = async (type) => {
    try {
      const response = await fetch(`/api/transactions/types/${type}/fields`);
      if (response.ok) {
        const data = await response.json();
        setFields(data);
        setFormData({});
        setResult(null);
        setError(null);
      }
    } catch (err) {
      console.error('Error fetching transaction fields:', err);
    }
  };

  const handleFieldChange = (fieldName, value) => {
    setFormData(prev => ({
      ...prev,
      [fieldName]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setResult(null);
    setError(null);

    try {
      const response = await fetch('/api/transactions', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          type: selectedType,
          data: formData
        })
      });

      if (response.ok) {
        const data = await response.json();
        setResult(data);
        setFormData({});
      } else {
        const errorData = await response.json();
        setError(errorData.message || 'Errore nella transazione');
      }
    } catch (err) {
      setError('Errore di connessione');
    } finally {
      setLoading(false);
    }
  };

  const renderField = (field) => {
    const value = formData[field.name] || '';

    switch (field.type) {
      case 'string':
      case 'text':
        return (
          <input
            type="text"
            value={value}
            onChange={(e) => handleFieldChange(field.name, e.target.value)}
            required={field.required}
            placeholder={field.placeholder}
          />
        );
      
      case 'number':
      case 'double':
      case 'int':
        return (
          <input
            type="number"
            value={value}
            onChange={(e) => handleFieldChange(field.name, e.target.value)}
            required={field.required}
            step={field.type === 'double' ? '0.01' : '1'}
            placeholder={field.placeholder}
          />
        );
      
      case 'boolean':
        return (
          <select
            value={value}
            onChange={(e) => handleFieldChange(field.name, e.target.value)}
            required={field.required}
          >
            <option value="">Seleziona...</option>
            <option value="true">Sì</option>
            <option value="false">No</option>
          </select>
        );
      
      case 'enum':
        return (
          <select
            value={value}
            onChange={(e) => handleFieldChange(field.name, e.target.value)}
            required={field.required}
          >
            <option value="">Seleziona...</option>
            {field.options && field.options.map(opt => (
              <option key={opt} value={opt}>{opt}</option>
            ))}
          </select>
        );
      
      default:
        return (
          <input
            type="text"
            value={value}
            onChange={(e) => handleFieldChange(field.name, e.target.value)}
            required={field.required}
          />
        );
    }
  };

  return (
    <div className="transaction-form-container">
      <h1>Transazioni</h1>

      <div className="form-card">
        <div className="form-group">
          <label>Tipo Transazione</label>
          <select
            value={selectedType}
            onChange={(e) => setSelectedType(e.target.value)}
            className="transaction-type-select"
          >
            <option value="">Seleziona tipo transazione...</option>
            {transactionTypes.map(type => (
              <option key={type.name} value={type.name}>
                {type.label || type.name}
              </option>
            ))}
          </select>
        </div>

        {selectedType && fields.length > 0 && (
          <form onSubmit={handleSubmit}>
            <div className="fields-container">
              {fields.map(field => (
                <div key={field.name} className="form-group">
                  <label>
                    {field.label || field.name}
                    {field.required && <span className="required">*</span>}
                  </label>
                  {renderField(field)}
                  {field.description && (
                    <small className="field-help">{field.description}</small>
                  )}
                </div>
              ))}
            </div>

            <div className="form-actions">
              <button
                type="submit"
                className="btn btn-primary"
                disabled={loading}
              >
                {loading ? 'Invio...' : 'Invia Transazione'}
              </button>
              <button
                type="button"
                className="btn"
                onClick={() => setFormData({})}
                disabled={loading}
              >
                Reset
              </button>
            </div>
          </form>
        )}

        {result && (
          <div className="success-message">
            <h3>✓ Transazione completata</h3>
            <pre>{JSON.stringify(result, null, 2)}</pre>
          </div>
        )}

        {error && (
          <div className="error-message">
            <h3>✗ Errore</h3>
            <p>{error}</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default TransactionForm;
