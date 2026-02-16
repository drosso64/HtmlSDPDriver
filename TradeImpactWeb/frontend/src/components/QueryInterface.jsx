import { useState, useEffect } from 'react';
import './QueryInterface.css';

function QueryInterface() {
  const [classes, setClasses] = useState([]);
  const [selectedClass, setSelectedClass] = useState('');
  const [filters, setFilters] = useState([]);
  const [results, setResults] = useState([]);
  const [columns, setColumns] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchClasses();
  }, []);

  const fetchClasses = async () => {
    try {
      const response = await fetch('/api/classes');
      if (response.ok) {
        const data = await response.json();
        setClasses(data);
      }
    } catch (err) {
      console.error('Error fetching classes:', err);
    }
  };

  const handleAddFilter = () => {
    setFilters([...filters, { field: '', operator: 'equals', value: '' }]);
  };

  const handleRemoveFilter = (index) => {
    setFilters(filters.filter((_, i) => i !== index));
  };

  const handleFilterChange = (index, key, value) => {
    const newFilters = [...filters];
    newFilters[index][key] = value;
    setFilters(newFilters);
  };

  const handleExecuteQuery = async () => {
    if (!selectedClass) {
      setError('Seleziona una classe');
      return;
    }

    setLoading(true);
    setError(null);

    try {
      const response = await fetch('/api/query', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          className: selectedClass,
          filters: filters.filter(f => f.field && f.value)
        })
      });

      if (response.ok) {
        const data = await response.json();
        setResults(data.results || []);
        setColumns(data.columns || []);
      } else {
        const errorData = await response.json();
        setError(errorData.message || 'Errore nell\'esecuzione della query');
      }
    } catch (err) {
      setError('Errore di connessione');
    } finally {
      setLoading(false);
    }
  };

  const handleClear = () => {
    setFilters([]);
    setResults([]);
    setColumns([]);
    setError(null);
  };

  return (
    <div className="query-interface">
      <h1>Interfaccia Query</h1>

      <div className="query-builder">
        <div className="form-group">
          <label>Classe</label>
          <select
            value={selectedClass}
            onChange={(e) => setSelectedClass(e.target.value)}
          >
            <option value="">Seleziona classe...</option>
            {classes.map(cls => (
              <option key={cls.name} value={cls.name}>{cls.name}</option>
            ))}
          </select>
        </div>

        <div className="filters-section">
          <div className="filters-header">
            <h3>Filtri</h3>
            <button
              type="button"
              className="btn btn-sm"
              onClick={handleAddFilter}
            >
              + Aggiungi Filtro
            </button>
          </div>

          {filters.length === 0 ? (
            <div className="no-filters">
              Nessun filtro impostato. Clicca "Aggiungi Filtro" per iniziare.
            </div>
          ) : (
            <div className="filters-list">
              {filters.map((filter, index) => (
                <div key={index} className="filter-row">
                  <input
                    type="text"
                    placeholder="Campo"
                    value={filter.field}
                    onChange={(e) => handleFilterChange(index, 'field', e.target.value)}
                  />
                  <select
                    value={filter.operator}
                    onChange={(e) => handleFilterChange(index, 'operator', e.target.value)}
                  >
                    <option value="equals">Uguale</option>
                    <option value="notEquals">Diverso</option>
                    <option value="greaterThan">Maggiore</option>
                    <option value="lessThan">Minore</option>
                    <option value="contains">Contiene</option>
                  </select>
                  <input
                    type="text"
                    placeholder="Valore"
                    value={filter.value}
                    onChange={(e) => handleFilterChange(index, 'value', e.target.value)}
                  />
                  <button
                    type="button"
                    className="btn-remove"
                    onClick={() => handleRemoveFilter(index)}
                  >
                    ✕
                  </button>
                </div>
              ))}
            </div>
          )}
        </div>

        <div className="query-actions">
          <button
            className="btn btn-primary"
            onClick={handleExecuteQuery}
            disabled={loading || !selectedClass}
          >
            {loading ? 'Esecuzione...' : 'Esegui Query'}
          </button>
          <button
            className="btn"
            onClick={handleClear}
            disabled={loading}
          >
            Reset
          </button>
        </div>

        {error && (
          <div className="error-message">{error}</div>
        )}
      </div>

      {results.length > 0 && (
        <div className="query-results">
          <h2>Risultati ({results.length})</h2>
          <div className="table-wrapper">
            <table>
              <thead>
                <tr>
                  {columns.map(col => (
                    <th key={col.name}>{col.label || col.name}</th>
                  ))}
                </tr>
              </thead>
              <tbody>
                {results.map((row, index) => (
                  <tr key={index}>
                    {columns.map(col => (
                      <td key={col.name}>{String(row[col.name] || '')}</td>
                    ))}
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}
    </div>
  );
}

export default QueryInterface;
