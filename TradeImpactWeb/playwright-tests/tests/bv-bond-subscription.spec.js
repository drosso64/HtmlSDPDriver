import { test, expect } from '@playwright/test';

/**
 * Test Playwright per TradeImpactWeb
 * 
 * Questo test esegue:
 * 1. Login all'applicazione
 * 2. Sottoscrizione alla classe BV_BOND
 * 3. Cattura e stampa dei messaggi WebSocket ricevuti
 * 
 * PREREQUISITI:
 * - L'applicazione deve essere in esecuzione su http://localhost:8081
 * - Il backend deve essere connesso all'IPSP
 * - La classe BV_BOND deve essere disponibile
 * 
 * CONFIGURAZIONE:
 * Modifica le costanti sotto per adattarle al tuo ambiente
 */

// ====== CONFIGURAZIONE TEST ======
const TEST_CONFIG = {
  // Credenziali di login
  username: 'TRADER@35240',      // ⚠️ MODIFICA QUI
  password: 'TEQTEQ123',      // ⚠️ MODIFICA QUI
  ipspHost: '10.232.92.86',     // ⚠️ MODIFICA QUI (es: 'sdptest.mtsmarkets.com')
  ipspPort: '12001',               // Porta IPSP (default: 8800)
  
  // Configurazione classe
  classToSubscribe: 'BV_BOND',    // Classe da sottoscrivere
  
  // Timeout
  loginTimeout: 10000,            // 10 secondi per login
  subscriptionTimeout: 5000,      // 5 secondi per sottoscrizione
  websocketTimeout: 60000,        // 60 secondi per ricevere messaggi WebSocket
  
  // Numero di messaggi da raccogliere prima di terminare il test
  maxMessagesToCollect: 10,       // Raccogli 10 messaggi e poi termina
};

test.describe('TradeImpactWeb - BV_BOND Subscription Test', () => {
  
  test('Login, Subscribe BV_BOND e stampa messaggi WebSocket', async ({ page }) => {
    console.log('\n🚀 Inizio test BV_BOND Subscription\n');
    
    // Array per raccogliere i messaggi WebSocket
    const websocketMessages = [];
    let messageCount = 0;
    
    // ====== STEP 1: Intercetta WebSocket PRIMA di navigare ======
    console.log('📡 Configurazione intercettazione WebSocket...');
    
    page.on('websocket', ws => {
      console.log(`✅ WebSocket connesso: ${ws.url()}`);
      
      // Intercetta messaggi ricevuti
      ws.on('framereceived', event => {
        try {
          const message = JSON.parse(event.payload);
          
          // Filtra solo i messaggi di tipo 'marketData' per BV_BOND
          if (message.type === 'marketData' && message.classId === TEST_CONFIG.classToSubscribe) {
            messageCount++;
            websocketMessages.push(message);
            
            console.log(`\n📦 Messaggio #${messageCount} ricevuto:`);
            console.log(`   Classe: ${message.className} (${message.classId})`);
            console.log(`   HashKey: ${message.hashKey}`);
            console.log(`   Timestamp: ${message.timestamp}`);
            console.log(`   Dati:`, JSON.stringify(message.data, null, 2));
          } else if (message.type === 'connected') {
            console.log(`👋 ${message.message}`);
          }
        } catch (err) {
          console.error('❌ Errore parsing messaggio WebSocket:', err);
        }
      });
      
      // Intercetta messaggi inviati
      ws.on('framesent', event => {
        console.log(`📤 WebSocket messaggio inviato: ${event.payload}`);
      });
      
      // Intercetta chiusura
      ws.on('close', () => {
        console.log('🔌 WebSocket chiuso');
      });
    });
    
    // ====== STEP 2: Naviga alla pagina di login ======
    console.log('\n🌐 Navigazione alla pagina di login...');
    await page.goto('/login');
    
    // Verifica che la pagina sia caricata
    await expect(page.locator('h1')).toContainText('TradeImpact Web Gateway');
    console.log('✅ Pagina di login caricata');
    
    // ====== STEP 3: Compila il form di login ======
    console.log('\n🔐 Compilazione form di login...');
    
    await page.fill('input#username', TEST_CONFIG.username);
    await page.fill('input#password', TEST_CONFIG.password);
    await page.fill('input#ipspHost', TEST_CONFIG.ipspHost);
    await page.fill('input#ipspPort', TEST_CONFIG.ipspPort);
    
    console.log(`   Username: ${TEST_CONFIG.username}`);
    console.log(`   IPSP Host: ${TEST_CONFIG.ipspHost}:${TEST_CONFIG.ipspPort}`);
    
    // ====== STEP 4: Effettua il login ======
    console.log('\n🚪 Esecuzione login...');
    
    // Clicca sul pulsante di login
    await page.click('button[type="submit"]');
    
    // Attendi il redirect alla pagina delle sottoscrizioni
    await page.waitForURL('/subscriptions', { 
      timeout: TEST_CONFIG.loginTimeout 
    });
    
    console.log('✅ Login effettuato con successo!');
    
    // Attendi che il WebSocket si connetta (verifica lo stato)
    console.log('\n⏳ Attendo connessione WebSocket...');
    await page.waitForSelector('.websocket-status.connected', {
      timeout: 10000
    });
    console.log('✅ WebSocket connesso!');
    
    // ====== STEP 5: Trova e seleziona BV_BOND ======
    console.log(`\n🔍 Ricerca classe ${TEST_CONFIG.classToSubscribe}...`);
    
    // Attendi che le classi siano caricate
    await page.waitForSelector('.class-list', { timeout: 5000 });
    
    // Cerca l'elemento della classe per nome e trova il checkbox al suo interno
    const classItem = page.locator('.class-item', { hasText: TEST_CONFIG.classToSubscribe });

    // Verifica che la classe esista (il componente mostra il nome nella .class-name)
    await expect(classItem).toBeVisible({ timeout: 5000 });
    console.log(`✅ Classe ${TEST_CONFIG.classToSubscribe} trovata`);

    // Trova il checkbox interno e selezionalo
    const bvBondCheckbox = classItem.locator('input[type="checkbox"]');
    await bvBondCheckbox.check();
    console.log(`✅ Classe ${TEST_CONFIG.classToSubscribe} selezionata`);
    
    // ====== STEP 6: Sottoscrivi ======
    console.log(`\n📝 Sottoscrizione a ${TEST_CONFIG.classToSubscribe}...`);
    
    // Clicca sul pulsante Subscribe
    const subscribeButton = page.locator('button:has-text("Sottoscrivi")');
    await subscribeButton.click();
    
    // Attendi l'alert di conferma (Playwright gestisce automaticamente gli alert)
    page.on('dialog', async dialog => {
      console.log(`   Alert: ${dialog.message()}`);
      await dialog.accept();
    });
    
    // Attendi che la sottoscrizione sia completata
    await page.waitForTimeout(TEST_CONFIG.subscriptionTimeout);
    console.log('✅ Sottoscrizione completata!');
    
    // ====== STEP 7: Attendi e raccogli messaggi WebSocket ======
    console.log(`\n📊 Raccolta messaggi WebSocket (max ${TEST_CONFIG.maxMessagesToCollect})...`);
    console.log('   Attendere...\n');
    
    // Attendi fino a raccogliere il numero desiderato di messaggi o timeout
    const startTime = Date.now();
    while (
      websocketMessages.length < TEST_CONFIG.maxMessagesToCollect && 
      (Date.now() - startTime) < TEST_CONFIG.websocketTimeout
    ) {
      await page.waitForTimeout(1000); // Attendi 1 secondo tra i controlli
    }
    
    // ====== STEP 8: Stampa riepilogo ======
    console.log('\n' + '='.repeat(80));
    console.log('📈 RIEPILOGO TEST');
    console.log('='.repeat(80));
    console.log(`✅ Messaggi ricevuti: ${websocketMessages.length}`);
    console.log(`⏱️  Tempo di esecuzione: ${((Date.now() - startTime) / 1000).toFixed(2)}s`);
    
    if (websocketMessages.length > 0) {
      console.log('\n📋 DETTAGLIO MESSAGGI:');
      websocketMessages.forEach((msg, index) => {
        console.log(`\n--- Messaggio ${index + 1} ---`);
        console.log(`HashKey: ${msg.hashKey}`);
        console.log(`Timestamp: ${msg.timestamp}`);
        console.log(`Dati:`, JSON.stringify(msg.data, null, 2));
      });
      
      // Analisi record unici
      const uniqueHashes = new Set(websocketMessages.map(m => m.hashKey));
      console.log(`\n🔑 Record unici (per hashKey): ${uniqueHashes.size}`);
      
      // Calcola rate
      const duration = (Date.now() - startTime) / 1000;
      const rate = (websocketMessages.length / duration).toFixed(2);
      console.log(`📊 Rate: ${rate} messaggi/secondo`);
    } else {
      console.log('\n⚠️  Nessun messaggio ricevuto nel timeout specificato');
    }
    
    console.log('\n' + '='.repeat(80));
    console.log('✅ Test completato!');
    console.log('='.repeat(80) + '\n');
    
    // Verifica che abbiamo ricevuto almeno un messaggio
    expect(websocketMessages.length).toBeGreaterThan(0);
  });
  
});
