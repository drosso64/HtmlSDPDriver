import { defineConfig, devices } from '@playwright/test';

/**
 * Configurazione Playwright per TradeImpactWeb
 * @see https://playwright.dev/docs/test-configuration
 */
export default defineConfig({
  testDir: './tests',
  
  /* Timeout massimo per ogni test */
  timeout: 120 * 1000, // 2 minuti (per attendere i messaggi WebSocket)
  
  /* Configurazione generale */
  fullyParallel: false, // Esegui i test in sequenza
  forbidOnly: !!process.env.CI,
  retries: process.env.CI ? 2 : 0,
  workers: 1, // Un solo worker per evitare conflitti
  
  /* Reporter */
  reporter: [
    ['html'],
    ['list']
  ],
  
  /* Configurazione condivisa per tutti i progetti */
  use: {
    /* URL base dell'applicazione */
    baseURL: 'http://localhost:8081',
    
    /* Screenshot solo on failure */
    screenshot: 'only-on-failure',
    
    /* Video solo on failure */
    video: 'retain-on-failure',
    
    /* Trace on first retry */
    trace: 'on-first-retry',
  },

  /* Configurazione dei progetti (browser) */
  projects: [
    {
      name: 'chromium',
      use: { ...devices['Desktop Chrome'] },
    },
  ],

  /* Non avviare automaticamente il dev server */
  // webServer: {
  //   command: 'npm run dev',
  //   url: 'http://localhost:8081',
  //   reuseExistingServer: !process.env.CI,
  // },
});
