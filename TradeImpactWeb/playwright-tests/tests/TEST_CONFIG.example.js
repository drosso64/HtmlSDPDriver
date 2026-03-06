/**
 * ESEMPIO DI CONFIGURAZIONE PER IL TEST PLAYWRIGHT
 * 
 * Copia questo contenuto nel file: tests/bv-bond-subscription.spec.js
 * Sostituisci i valori di esempio con le tue credenziali reali
 */

const TEST_CONFIG = {
  // ===============================================
  // CREDENZIALI DI LOGIN
  // ===============================================
  
  // Username per accedere all'IPSP
  // Esempio: 'mario.rossi' o 'testuser'
  username: 'your-username',
  
  // Password per accedere all'IPSP
  // Esempio: 'MySecureP@ssw0rd'
  password: 'your-password',
  
  // Host del server IPSP
  // Esempio: 'sdptest.mtsmarkets.com' o '192.168.1.100'
  ipspHost: 'your-ipsp-host',
  
  // Porta del server IPSP
  // Default: '8800'
  ipspPort: '8800',
  
  // ===============================================
  // CONFIGURAZIONE CLASSE
  // ===============================================
  
  // Classe da sottoscrivere
  // Opzioni comuni: 'BV_BOND', 'MTS_BOND', 'REPO', ecc.
  classToSubscribe: 'BV_BOND',
  
  // ===============================================
  // TIMEOUT
  // ===============================================
  
  // Timeout per completare il login (millisecondi)
  loginTimeout: 10000,
  
  // Timeout per completare la sottoscrizione (millisecondi)
  subscriptionTimeout: 5000,
  
  // Timeout massimo per ricevere messaggi WebSocket (millisecondi)
  websocketTimeout: 60000,
  
  // ===============================================
  // RACCOLTA DATI
  // ===============================================
  
  // Numero massimo di messaggi da raccogliere prima di terminare il test
  // Il test termina quando:
  // - Raggiunge questo numero di messaggi, OPPURE
  // - Scade il websocketTimeout
  maxMessagesToCollect: 10,
};

// ===============================================
// ESEMPI DI CONFIGURAZIONE
// ===============================================

/*
  ESEMPIO 1 - Ambiente di test:
  
  username: 'testuser',
  password: 'Test123!',
  ipspHost: 'sdptest.mtsmarkets.com',
  ipspPort: '8800',
  classToSubscribe: 'BV_BOND',
  maxMessagesToCollect: 10,
*/

/*
  ESEMPIO 2 - Ambiente di produzione:
  
  username: 'produser',
  password: 'Pr0dP@ss',
  ipspHost: 'sdp.mtsmarkets.com',
  ipspPort: '8800',
  classToSubscribe: 'MTS_BOND',
  maxMessagesToCollect: 20,
*/

/*
  ESEMPIO 3 - Raccolta dati estesa:
  
  username: 'datauser',
  password: 'D@t@P@ss',
  ipspHost: '192.168.1.100',
  ipspPort: '8800',
  classToSubscribe: 'BV_BOND',
  websocketTimeout: 300000,  // 5 minuti
  maxMessagesToCollect: 100, // Raccogli 100 messaggi
*/
