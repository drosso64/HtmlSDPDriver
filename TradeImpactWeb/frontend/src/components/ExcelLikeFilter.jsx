import React, { useState, useEffect, useRef } from 'react';
import './ExcelLikeFilter.css';

/**
 * ExcelLikeFilter - Dropdown Filtro Stile Excel
 * 
 * SCOPO:
 * Replica l'esperienza del filtro colonna di Microsoft Excel:
 * - Dropdown con checkbox list di valori unici
 * - Search box per filtrare lista valori
 * - "Seleziona tutto" con stato indeterminato
 * - Sorting integrato (A→Z, Z→A) invece di click su header
 * 
 * COMPORTAMENTO:
 * 1. Click su icona 🔽 → Apre dropdown
 * 2. User seleziona/deseleziona valori → Filtra tabella
 * 3. Click fuori dropdown → Chiude automaticamente (useRef + listener)
 * 4. Icona blu quando filtro attivo (selectedValues.size > 0)
 * 
 * INTEGRAZIONE CON TANSTACK TABLE:
 * - onFilterChange(values) → aggiorna columnFilters in parent
 * - TanStack custom filterFn verifica se valore riga è in values array
 * - Sorting via column.toggleSorting() invece di setSorting diretto
 * 
 * STATO "SELEZIONA TUTTO":
 * - ☑️ Checked: tutti valori selezionati (mostra tutto)
 * - ☐ Unchecked: nessun valore selezionato (nascondi tutto)
 * - ⊟ Indeterminate: alcuni valori (filtro parziale)
 * 
 * FUNZIONALITÀ SORTING:
 * - 🔼 A→Z: ordina ascendente (onClick → column.toggleSorting(false))
 * - 🔽 Z→A: ordina discendente (onClick → column.toggleSorting(true))
 * - Chiude dropdown dopo sort (user vede immediatamente risultato)
 * 
 * PATTERN UI:
 * - Click-outside detection: useRef + addEventListener
 * - Controlled components: useState per searchTerm, selectedValues
 * - Callback propagation: onFilterChange, onSort verso parent
 * 
 * @param {Object} column - TanStack Table column object
 * @param {Array} uniqueValues - Lista valori unici colonna (da parent useMemo)
 * @param {Array} currentFilter - Filtro attualmente applicato
 * @param {Function} onFilterChange - Callback per aggiornare filtro
 * @param {Function} onSort - Callback per sorting (calls column.toggleSorting)
 * 
 * @see DynamicDataGrid.jsx - Usa questo component in header colonne
 * @see TanStack Table docs - filterFn custom implementation
 */
const ExcelLikeFilter = ({ column, uniqueValues, currentFilter, onFilterChange, onSort }) => {
  const [isOpen, setIsOpen] = useState(false);
  const [searchTerm, setSearchTerm] = useState('');
  const [selectedValues, setSelectedValues] = useState(new Set(currentFilter || []));
  const dropdownRef = useRef(null);

  // CLICK-OUTSIDE DETECTION
  // Chiude dropdown quando user clicca fuori (miglior UX)
  // Pattern standard: useRef per riferimento DOM + event listener
  useEffect(() => {
    const handleClickOutside = (event) => {
      // Se click è fuori dal dropdown, chiudi
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        setIsOpen(false);
      }
    };

    if (isOpen) {
      // Attiva listener solo quando dropdown aperto (performance)
      document.addEventListener('mousedown', handleClickOutside);
      return () => document.removeEventListener('mousedown', handleClickOutside);
    }
  }, [isOpen]);

  // SEARCH FILTERING
  // Filtra lista valori mostrati in base a ricerca user
  // Mantiene tutti i valori in selectedValues (filtro search != filtro tabella)
  const filteredValues = uniqueValues.filter(value =>
    String(value).toLowerCase().includes(searchTerm.toLowerCase())
  );

  const handleToggle = () => {
    setIsOpen(!isOpen);
  };

  const handleSelectAll = () => {
    // TOGGLE "Seleziona tutto"
    // Se tutti selezionati → deseleziona tutti (filtra tutto)
    // Se alcuni/nessuno → seleziona tutti (mostra tutto)
    if (selectedValues.size === uniqueValues.length) {
      // Deseleziona tutti
      setSelectedValues(new Set());
      onFilterChange([]);  // Array vuoto = nessuna riga passa il filtro
    } else {
      // Seleziona tutti
      const allValues = new Set(uniqueValues);
      setSelectedValues(allValues);
      onFilterChange(Array.from(allValues));  // Tutte le righe passano
    }
  };

  const handleValueToggle = (value) => {
    // TOGGLE singolo valore
    // Add se non presente, remove se presente
    const newSelected = new Set(selectedValues);
    if (newSelected.has(value)) {
      newSelected.delete(value);
    } else {
      newSelected.add(value);
    }
    setSelectedValues(newSelected);
    onFilterChange(Array.from(newSelected));  // Propaga a TanStack Table
  };

  const handleClear = () => {
    // RESET filtro
    // Deseleziona tutto + pulisce search box
    setSelectedValues(new Set());
    onFilterChange([]);
    setSearchTerm('');
  };

  const handleSortAsc = () => {
    // SORTING ASCENDENTE (A→Z, 0→9)
    // Chiama callback che esegue column.toggleSorting(false)
    // false = ascending
    onSort('asc');
    setIsOpen(false);  // Chiudi dropdown per mostrare risultato
  };

  const handleSortDesc = () => {
    // SORTING DISCENDENTE (Z→A, 9→0)
    // Chiama callback che esegue column.toggleSorting(true)
    // true = descending
    onSort('desc');
    setIsOpen(false);  // Chiudi dropdown per mostrare risultato
  };

  // STATO CHECKBOX "Seleziona tutto"
  const isAllSelected = selectedValues.size === uniqueValues.length;
  const isSomeSelected = selectedValues.size > 0 && !isAllSelected;

  return (
    <div className="excel-filter" ref={dropdownRef}>
      <button 
        className={`filter-toggle ${selectedValues.size > 0 ? 'active' : ''}`}
        onClick={handleToggle}
        title="Filtra colonna"
      >
        🔽
      </button>
      
      {isOpen && (
        <div className="filter-dropdown">
          {/* Opzioni ordinamento */}
          <div className="sort-options">
            <button onClick={handleSortAsc} className="sort-btn">
              <span className="sort-icon">🔼</span>
              <span>Ordina A → Z</span>
            </button>
            <button onClick={handleSortDesc} className="sort-btn">
              <span className="sort-icon">🔽</span>
              <span>Ordina Z → A</span>
            </button>
          </div>
          
          <div className="filter-divider"></div>
          
          <div className="filter-search">
            <input
              type="text"
              placeholder="Cerca..."
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              onClick={(e) => e.stopPropagation()}
            />
          </div>
          
          <div className="filter-options">
            <label className="filter-option select-all">
              <input
                type="checkbox"
                checked={isAllSelected}
                ref={input => {
                  if (input) input.indeterminate = isSomeSelected;
                }}
                onChange={handleSelectAll}
              />
              <span>(Seleziona tutto)</span>
              <span className="value-count">({uniqueValues.length})</span>
            </label>
            
            <div className="filter-divider"></div>
            
            <div className="filter-values-list">
              {filteredValues.length === 0 ? (
                <div className="no-results">Nessun risultato</div>
              ) : (
                filteredValues.map((value, idx) => (
                  <label key={idx} className="filter-option">
                    <input
                      type="checkbox"
                      checked={selectedValues.has(value)}
                      onChange={() => handleValueToggle(value)}
                    />
                    <span>{String(value)}</span>
                  </label>
                ))
              )}
            </div>
          </div>
          
          <div className="filter-actions">
            <button onClick={handleClear} className="clear-btn">
              Cancella filtro
            </button>
          </div>
        </div>
      )}
    </div>
  );
};

export default ExcelLikeFilter;
