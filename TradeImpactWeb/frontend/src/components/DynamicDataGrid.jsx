import { useState, useMemo, Fragment, useEffect } from 'react';
import {
  useReactTable,
  getCoreRowModel,
  getSortedRowModel,
  getFilteredRowModel,
  getPaginationRowModel,
  flexRender,
} from '@tanstack/react-table';
import DataDetailModal from './DataDetailModal';
import RecordDetailModal from './RecordDetailModal';
import ExcelLikeFilter from './ExcelLikeFilter';
import axios from 'axios';
import './DynamicDataGrid.css';

/**
 * DynamicDataGrid - Griglia Dinamica con TanStack Table
 * 
 * RESPONSABILITÀ:
 * Renderizza dati market in tabella interattiva con:
 * - Sorting (click su colonna o dropdown Excel-like)
 * - Filtering (checkbox list come filtro Excel)
 * - Resizing colonne (drag bordo colonna)
 * - Pagination (prev/next page con dimensione configurabile)
 * - Modals per vedere/modificare singoli record
 * 
 * ARCHITETTURA COLONNE:
 * 1. Estrae nomi colonne DA DATI (NON da schema hardcoded)
 * 2. Usa Object.keys() sul primo record → preserva ordine JSON
 * 3. Ordine JSON deriva da LinkedHashMap backend → ordine classe Java
 * 4. Filtra campi interni (cLASS_ID, classid, etc.) prima del rendering
 * 
 * MODALI:
 * - DataDetailModal: visualizza array/oggetti complessi (solo lettura)
 * - RecordDetailModal: visualizza/modifica record completo (CRUD)
 * 
 * EXCEL-LIKE FILTERING:
 * Ogni colonna ha dropdown ExcelLikeFilter con:
 * - Checkbox list dei valori unici
 * - Search box per filtrare valori
 * - Sorting integrato (A→Z, Z→A)
 * - "Seleziona tutto" con stato indeterminato
 * 
 * TANSTACK TABLE:
 * Libreria headless (solo logica, rendering custom)
 * - getCoreRowModel: gestione base righe
 * - getSortedRowModel: ordinamento
 * - getFilteredRowModel: filtraggio
 * - getPaginationRowModel: paginazione
 * 
 * @param {Array} data - Array di messaggi da WebSocketContext
 * @param {Number} classId - ID della classe (per caricare schema se tabella vuota)
 * @param {String} className - Nome della classe (per template nuovo record)
 * @see WebSocketContext.jsx - Sorgente dati
 * @see ExcelLikeFilter.jsx - Componente filtro dropdown
 * @see RecordDetailModal.jsx - Modal per modifica record
 */
function DynamicDataGrid({ data, classId, className }) {
  const [sorting, setSorting] = useState([]);
  const [columnFilters, setColumnFilters] = useState([]);
  const [columnVisibility, setColumnVisibility] = useState({});
  const [columnSizing, setColumnSizing] = useState({});
  const [expandedRows, setExpandedRows] = useState(new Set());
  const [modalData, setModalData] = useState(null);
  const [recordDetailModal, setRecordDetailModal] = useState(null);
  const [showAddRecordModal, setShowAddRecordModal] = useState(false);
  const [classSchema, setClassSchema] = useState(null);

  console.log('🔷 DynamicDataGrid render - dati ricevuti:', data?.length || 0, 'records', 'classId:', classId, 'className:', className);

  // Load schema from API (needed for type information and creating new records)
  // Lo schema è caricato SEMPRE, e viene ricaricato quando si cambia classe (tab).
  useEffect(() => {
    if (classId) {
      console.log('📥 Loading schema for classId:', classId, className);
      const token = localStorage.getItem('authToken');
      axios.get(`/api/classes/${classId}/schema`, {
        headers: { Authorization: token }
      })
      .then(response => {
        console.log('✅ Schema loaded:', response.data?.fields?.length, 'fields');
        setClassSchema(response.data);
      })
      .catch(error => {
        console.error('❌ Failed to load schema:', error);
        setClassSchema(null);
      });
    }
  }, [classId]);  // Ricarica quando classId cambia (cambio tab)

  // STEP 1: Appiattimento Struttura Dati
  // Da: { timestamp, className, classId, data: { field1, field2, ... } }
  // A:  { _rowId, timestamp, className, classId, field1, field2, ... }
  // 
  // Questo rende i dati compatibili con TanStack Table (flat structure)
  const flattenedData = useMemo(() => {
    console.log('📊 Flattening data - input length:', data.length);
    const result = data.map((item, idx) => {
      const flattened = {
        _rowId: idx,          // ID univoco per React (keys)
        timestamp: item.timestamp,
        className: item.className,  // Nome classe SDP (es: BV_BOND)
        classId: item.classId,
      };
      
      // Espande tutti i campi da item.data nel record flat
      // Esempio: { data: { instrumentId: 123, coupon: 3.5 } }
      //       → { instrumentId: 123, coupon: 3.5 }
      if (item.data && typeof item.data === 'object') {
        Object.keys(item.data).forEach(key => {
          // Salta campi interni (iniziano con _)
          if (!key.startsWith('_')) {
            flattened[key] = item.data[key];
          }
        });
      }
      
      return flattened;
    });
    console.log('📊 Flattened data - output length:', result.length);
    console.log('📊 First item:', result[0]);
    return result;
  }, [data]);

  // STEP 2: Estrazione Nomi Colonne (preservando ordine)
  //
  // ⚠️ DECISIONE CRITICA: Usa Object.keys(firstRecord)
  // JavaScript Object.keys() preserva l'ordine di inserimento (ES2015+)
  // Backend usa LinkedHashMap → JSON mantiene ordine → Object.keys() mantiene ordine
  // Quindi: colonne appaiono nello stesso ordine della classe Java
  //
  // FILTRAGGIO: Esclude campi interni che non servono all'utente
  // - campi con _ (interni React/TanStack)
  // - cLASS_ID, classid (metadati SDP protocol)
  // - className, class (duplicati)
  // - sMPClassId (metadato SDP)
  const columnNames = useMemo(() => {
    if (flattenedData.length === 0) return [];
    
    // Usa PRIMO record come template (tutti i record hanno stessi campi)
    const firstRecord = flattenedData[0];
    const orderedCols = [];
    
    // timestamp sempre prima colonna (utile per debugging)
    orderedCols.push('timestamp');
    
    // Aggiungi altri campi nell'ordine in cui appaiono nel JSON
    // (che deriva dall'ordine della classe Java grazie a LinkedHashMap)
    Object.keys(firstRecord).forEach(key => {
      if (!key.startsWith('_') &&       // Non _rowId, _type, etc.
          key !== 'cLASS_ID' &&          // Metadata SDP
          key !== 'classid' &&           // Metadata SDP (lowercase variant)
          key !== 'classId' &&           // Metadata SDP (camelCase variant)
          key !== 'className' &&         // Already in tab name
          key !== 'class' &&             // Duplicate
          key !== 'sMPClassId' &&        // Metadata SDP
          key !== 'timestamp') {         // Already added (first column)
        orderedCols.push(key);
      }
    });
    
    return orderedCols;
  }, [flattenedData]);

  const formatTimestamp = (ts) => {
    return new Date(ts).toLocaleTimeString('it-IT', {
      hour: '2-digit',
      minute: '2-digit',
      second: '2-digit',
      fractionalSecondDigits: 3
    });
  };

  const renderCellValue = (value, fieldName) => {
    if (value === null || value === undefined) {
      return <span className="cell-null">-</span>;
    }

    // Array - make it clickable
    if (Array.isArray(value)) {
      return (
        <button 
          className="cell-array cell-clickable"
          onClick={(e) => {
            e.stopPropagation();
            setModalData({ 
              data: value, 
              title: `${fieldName}: Array [${value.length} elementi]` 
            });
          }}
        >
          Array[{value.length}] 👁️
        </button>
      );
    }

    // Nested object - make it clickable
    if (typeof value === 'object') {
      const typeName = value._type || 'Object';
      return (
        <button 
          className="cell-object cell-clickable"
          onClick={(e) => {
            e.stopPropagation();
            setModalData({ 
              data: value, 
              title: `${fieldName}: ${typeName}` 
            });
          }}
        >
          {typeName} 👁️
        </button>
      );
    }

    // Primitive
    const str = String(value);
    if (str.length > 50) {
      return <span title={str}>{str.substring(0, 50)}...</span>;
    }
    
    return <span>{str}</span>;
  };

  const handleRecordAction = (action, recordData) => {
    console.log(`🔧 Action requested: ${action}`, recordData);
    // TODO: Implementare chiamata SDP per ADD, RWT o DEL
    // Per ora solo log
    if (action === 'ADD') {
      console.log('➕ ADD (Insert) - New record:', recordData);
      // TODO: Inviare transazione ADD via SDP
    } else if (action === 'RWT') {
      console.log('📝 RWT (Update) - Data to send:', recordData);
      // TODO: Inviare transazione RWT via SDP
    } else if (action === 'DEL') {
      console.log('🗑️ DEL (Delete) - Record to delete:', recordData);
      // TODO: Inviare transazione DEL via SDP
    }
  };

  // Create empty record template for ADD operation (memoized)
  const emptyRecordTemplate = useMemo(() => {
    const template = {
      className: className || (flattenedData.length > 0 ? flattenedData[0].className : 'Unknown'),
      classId: classId || (flattenedData.length > 0 ? flattenedData[0].classId : null),
      timestamp: Date.now(),
    };
    
    // If we have data, use column names from data
    if (flattenedData.length > 0) {
      columnNames.forEach(colName => {
        if (colName !== 'timestamp') {
          template[colName] = null;
        }
      });
    }
    // If table is empty but we have schema, use fields from schema
    else if (classSchema && classSchema.fields) {
      console.log('📋 Creating template from schema with', classSchema.fields.length, 'fields');
      classSchema.fields.forEach(field => {
        const fieldName = field.name;
        // Set default value based on jsonType from backend schema
        if (field.jsonType === 'boolean') {
          template[fieldName] = false;
        } else if (field.jsonType === 'number') {
          template[fieldName] = 0;
        } else {
          template[fieldName] = null;
        }
      });
    }
    
    console.log('📝 Empty record template created:', template);
    return template;
  }, [flattenedData, columnNames, classSchema, classId, className]);

  // Define columns for TanStack Table
  const columns = useMemo(() => {
    const cols = [
      {
        id: 'expander',
        header: '',
        size: 40,
        enableResizing: false,
        enableSorting: false,
        enableColumnFilter: false,
        cell: ({ row }) => {
          const isExpanded = expandedRows.has(row.original._rowId);
          return (
            <button
              className="expand-btn"
              onClick={() => {
                const newExpanded = new Set(expandedRows);
                if (newExpanded.has(row.original._rowId)) {
                  newExpanded.delete(row.original._rowId);
                } else {
                  newExpanded.add(row.original._rowId);
                }
                setExpandedRows(newExpanded);
              }}
              aria-label={isExpanded ? 'Comprimi' : 'Espandi'}
            >
              {isExpanded ? '▼' : '▶'}
            </button>
          );
        },
      },
      {
        id: 'actions',
        header: '',
        size: 50,
        enableResizing: false,
        enableSorting: false,
        enableColumnFilter: false,
        cell: ({ row }) => (
          <button
            className="record-detail-btn"
            onClick={() => setRecordDetailModal(row.original)}
            title="Visualizza/Modifica record"
            aria-label="Dettagli record"
          >
            📋
          </button>
        ),
      },
    ];

    columnNames.forEach(colName => {
      cols.push({
        accessorKey: colName,
        id: colName,
        header: colName,
        size: 150,
        minSize: 80,
        maxSize: 500,
        enableColumnFilter: true,
        cell: ({ getValue, row }) => {
          const value = getValue();
          // Debug first cell
          if (row.index === 0) {
            console.log(`🟢 Cell render for column '${colName}':`, value);
          }
          if (colName === 'timestamp') {
            return formatTimestamp(value);
          }
          return renderCellValue(value, colName);
        },
        filterFn: (row, columnId, filterValue) => {
          // Se non c'è filtro, mostra tutto
          if (!filterValue || filterValue.length === 0) return true;
          // Controlla se il valore della cella è nell'array dei valori selezionati
          const cellValue = row.getValue(columnId);
          return filterValue.includes(cellValue);
        },
      });
    });

    return cols;
  }, [columnNames]);

  // TanStack Table instance
  const table = useReactTable({
    data: flattenedData,
    columns,
    state: {
      sorting,
      columnFilters,
      columnVisibility,
      columnSizing,
    },
    onSortingChange: setSorting,
    onColumnFiltersChange: setColumnFilters,
    onColumnVisibilityChange: setColumnVisibility,
    onColumnSizingChange: setColumnSizing,
    getCoreRowModel: getCoreRowModel(),
    getSortedRowModel: getSortedRowModel(),
    getFilteredRowModel: getFilteredRowModel(),
    getPaginationRowModel: getPaginationRowModel(),
    columnResizeMode: 'onChange',
    enableColumnResizing: true,
    initialState: {
      pagination: {
        pageSize: 25,
      },
    },
  });

  // Calcola valori unici per ogni colonna (per Excel filter)
  const uniqueValuesByColumn = useMemo(() => {
    const result = {};
    columnNames.forEach(colName => {
      const values = new Set();
      flattenedData.forEach(row => {
        const val = row[colName];
        if (val !== null && val !== undefined && !Array.isArray(val) && typeof val !== 'object') {
          values.add(val);
        }
      });
      result[colName] = Array.from(values).sort();
    });
    return result;
  }, [flattenedData, columnNames]);

  return (
    <div className="grid-container">
      {/* Table info and Add Record button - always shown */}
      <div className="table-info">
        <span>
          Visualizzati {table.getFilteredRowModel().rows.length} di {data.length} record
          {table.getState().columnFilters.length > 0 && ' (filtrati)'}
        </span>
        <button
          className="add-record-badge"
          onClick={() => setShowAddRecordModal(true)}
          title="Aggiungi nuovo record"
        >
          ➕ Nuovo Record
        </button>
      </div>

      {/* Data table or empty message */}
      {data.length === 0 ? (
        <div className="empty-message">
          📭 Nessun dato disponibile. Clicca "Nuovo Record" per aggiungere il primo record.
        </div>
      ) : (
        <>
          <div className="table-container">
            <table className="data-table tanstack-table">
          <thead>
            {/* Header row only */}
            <tr className="header-row">
              {table.getHeaderGroups()[0].headers.map(header => (
                <th
                  key={header.id}
                  style={{
                    width: header.getSize(),
                    position: 'relative',
                  }}
                >
                  {header.isPlaceholder ? null : (
                    <>
                      <div className="header-content">
                        {flexRender(
                          header.column.columnDef.header,
                          header.getContext()
                        )}
                        {/* Excel-like filter */}
                        {header.column.getCanFilter() && uniqueValuesByColumn[header.id] && (
                          <ExcelLikeFilter
                            column={header.column}
                            uniqueValues={uniqueValuesByColumn[header.id]}
                            currentFilter={header.column.getFilterValue() || []}
                            onFilterChange={(values) => header.column.setFilterValue(values)}
                            onSort={(direction) => {
                              header.column.toggleSorting(direction === 'desc');
                            }}
                          />
                        )}
                      </div>
                      {/* Resize handle */}
                      {header.column.getCanResize() && (
                        <div
                          onMouseDown={header.getResizeHandler()}
                          onTouchStart={header.getResizeHandler()}
                          className={`resizer ${
                            header.column.getIsResizing() ? 'isResizing' : ''
                          }`}
                        />
                      )}
                    </>
                  )}
                </th>
              ))}
            </tr>
          </thead>
          <tbody>
            {table.getRowModel().rows.map((row) => {
              const isExpanded = expandedRows.has(row.original._rowId);
              // Debug empty rows
              if (row.index < 10) {
                console.log(`🟡 Row ${row.index}:`, row.original, 'cells:', row.getVisibleCells().length);
              }
              return (
                <Fragment key={row.id}>
                  <tr className="data-row">
                    {row.getVisibleCells().map(cell => (
                      <td
                        key={cell.id}
                        style={{
                          width: cell.column.getSize(),
                        }}
                      >
                        {flexRender(cell.column.columnDef.cell, cell.getContext())}
                      </td>
                    ))}
                  </tr>
                  {isExpanded && (
                    <tr className="expanded-row">
                      <td colSpan={columns.length}>
                        <div className="expanded-content">
                          <strong>Dettagli completi:</strong>
                          <pre>{JSON.stringify(data[row.original._rowId].data, null, 2)}</pre>
                        </div>
                      </td>
                    </tr>
                  )}
                </Fragment>
              );
            })}
          </tbody>
        </table>
      </div>

      {/* Pagination - shown only when there's data */}
      {data.length > 0 && (
        <div className="pagination">
        <div className="pagination-info">
          <span>Record per pagina: </span>
          <select
            value={table.getState().pagination.pageSize}
            onChange={(e) => {
              table.setPageSize(Number(e.target.value));
            }}
          >
            {[10, 25, 50, 100].map(pageSize => (
              <option key={pageSize} value={pageSize}>
                {pageSize}
              </option>
            ))}
          </select>
          <span className="record-count">
            Pagina {table.getState().pagination.pageIndex + 1} di{' '}
            {table.getPageCount()}
          </span>
        </div>
        <div className="pagination-controls">
          <button
            onClick={() => table.setPageIndex(0)}
            disabled={!table.getCanPreviousPage()}
            aria-label="Prima pagina"
          >
            «
          </button>
          <button
            onClick={() => table.previousPage()}
            disabled={!table.getCanPreviousPage()}
            aria-label="Pagina precedente"
          >
            ‹
          </button>
          <span className="page-indicator">
            {table.getState().pagination.pageIndex + 1} / {table.getPageCount()}
          </span>
          <button
            onClick={() => table.nextPage()}
            disabled={!table.getCanNextPage()}
            aria-label="Pagina successiva"
          >
            ›
          </button>
          <button
            onClick={() => table.setPageIndex(table.getPageCount() - 1)}
            disabled={!table.getCanNextPage()}
            aria-label="Ultima pagina"
          >
            »
          </button>
        </div>
      </div>
      )}
      </>
      )}

      {/* Data Detail Modal */}
      {modalData && (
        <DataDetailModal
          isOpen={true}
          onClose={() => setModalData(null)}
          data={modalData.data}
          title={modalData.title}
        />
      )}

      {/* Record Detail Modal */}
      <RecordDetailModal
        isOpen={recordDetailModal !== null}
        onClose={() => setRecordDetailModal(null)}
        record={recordDetailModal}
        onAction={handleRecordAction}
        schema={classSchema}
      />

      {/* Add New Record Modal */}
      <RecordDetailModal
        isOpen={showAddRecordModal}
        onClose={() => setShowAddRecordModal(false)}
        record={emptyRecordTemplate || {}}
        onAction={handleRecordAction}
        isNewRecord={true}
        schema={classSchema}
      />
    </div>
  );
}

export default DynamicDataGrid;
