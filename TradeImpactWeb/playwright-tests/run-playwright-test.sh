#!/bin/bash

###############################################################################
# Script per eseguire il test Playwright BV_BOND Subscription
###############################################################################

set -e  # Exit on error

# Colori per output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
NC='\033[0m' # No Color

echo -e "${BLUE}╔════════════════════════════════════════════════════════════════╗${NC}"
echo -e "${BLUE}║     TradeImpactWeb - Playwright Test Runner                   ║${NC}"
echo -e "${BLUE}║     BV_BOND WebSocket Subscription Test                        ║${NC}"
echo -e "${BLUE}╚════════════════════════════════════════════════════════════════╝${NC}"
echo ""

# Controlla se siamo nella directory corretta
if [ ! -f "playwright.config.js" ]; then
    echo -e "${RED}❌ Errore: playwright.config.js non trovato${NC}"
    echo -e "${YELLOW}   Esegui questo script dalla directory TradeImpactWeb${NC}"
    exit 1
fi

# Controlla se Node.js è installato
if ! command -v node &> /dev/null; then
    echo -e "${RED}❌ Node.js non è installato${NC}"
    echo -e "${YELLOW}   Installa Node.js 18+ da https://nodejs.org${NC}"
    exit 1
fi

echo -e "${GREEN}✅ Node.js versione: $(node --version)${NC}"

# Controlla se npm è installato
if ! command -v npm &> /dev/null; then
    echo -e "${RED}❌ npm non è installato${NC}"
    exit 1
fi

echo -e "${GREEN}✅ npm versione: $(npm --version)${NC}"
echo ""

# Controlla se le dipendenze sono installate
if [ ! -d "node_modules" ]; then
    echo -e "${YELLOW}⚠️  node_modules non trovato${NC}"
    echo -e "${BLUE}📦 Installazione dipendenze...${NC}"
    npm install
    echo ""
fi

# Controlla se Playwright è installato
if [ ! -d "node_modules/@playwright" ]; then
    echo -e "${YELLOW}⚠️  Playwright non trovato${NC}"
    echo -e "${BLUE}📦 Installazione Playwright...${NC}"
    npm install
    echo ""
fi

# Controlla se i browser Playwright sono installati
echo -e "${BLUE}🌐 Verifica browser Playwright...${NC}"
if ! npx playwright --version &> /dev/null; then
    echo -e "${YELLOW}⚠️  Browser Playwright non trovati${NC}"
    echo -e "${BLUE}📥 Installazione browser...${NC}"
    npx playwright install
    echo ""
fi

# Controlla se il test è configurato
echo -e "${BLUE}🔍 Verifica configurazione test...${NC}"
if grep -q "your-username" tests/bv-bond-subscription.spec.js 2>/dev/null; then
    echo -e "${YELLOW}⚠️  ATTENZIONE: Il test non è ancora configurato!${NC}"
    echo -e "${YELLOW}   Modifica il file: tests/bv-bond-subscription.spec.js${NC}"
    echo -e "${YELLOW}   Inserisci le tue credenziali nella sezione TEST_CONFIG${NC}"
    echo ""
    read -p "Vuoi continuare comunque? (y/n) " -n 1 -r
    echo ""
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        echo -e "${RED}Test annullato${NC}"
        exit 1
    fi
fi

# Controlla se l'applicazione è raggiungibile
echo -e "${BLUE}🔌 Verifica applicazione su http://localhost:8081...${NC}"
if ! curl -s -o /dev/null -w "%{http_code}" http://localhost:8081 > /dev/null 2>&1; then
    echo -e "${YELLOW}⚠️  L'applicazione non sembra essere in esecuzione su localhost:8081${NC}"
    echo -e "${YELLOW}   Assicurati che l'applicazione sia avviata prima di eseguire il test${NC}"
    echo ""
    read -p "Vuoi continuare comunque? (y/n) " -n 1 -r
    echo ""
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        echo -e "${RED}Test annullato${NC}"
        exit 1
    fi
else
    echo -e "${GREEN}✅ Applicazione raggiungibile${NC}"
fi

echo ""
echo -e "${BLUE}╔════════════════════════════════════════════════════════════════╗${NC}"
echo -e "${BLUE}║  Esecuzione test...                                            ║${NC}"
echo -e "${BLUE}╚════════════════════════════════════════════════════════════════╝${NC}"
echo ""

# Esegui il test
# Controlla se è stata richiesta una modalità specifica
MODE="${1:-headless}"

case $MODE in
    "headed")
        echo -e "${BLUE}🖥️  Modalità: Browser visibile${NC}"
        npm run test:headed
        ;;
    "debug")
        echo -e "${BLUE}🐛 Modalità: Debug${NC}"
        npm run test:debug
        ;;
    "ui")
        echo -e "${BLUE}🎨 Modalità: UI interattiva${NC}"
        npm run test:ui
        ;;
    "headless"|*)
        echo -e "${BLUE}👻 Modalità: Headless (senza browser visibile)${NC}"
        npm test
        ;;
esac

EXIT_CODE=$?

echo ""
if [ $EXIT_CODE -eq 0 ]; then
    echo -e "${GREEN}╔════════════════════════════════════════════════════════════════╗${NC}"
    echo -e "${GREEN}║  ✅ Test completato con successo!                              ║${NC}"
    echo -e "${GREEN}╚════════════════════════════════════════════════════════════════╝${NC}"
    echo ""
    echo -e "${BLUE}📊 Per vedere il report HTML:${NC}"
    echo -e "${YELLOW}   npm run test:report${NC}"
else
    echo -e "${RED}╔════════════════════════════════════════════════════════════════╗${NC}"
    echo -e "${RED}║  ❌ Test fallito!                                              ║${NC}"
    echo -e "${RED}╚════════════════════════════════════════════════════════════════╝${NC}"
    echo ""
    echo -e "${BLUE}📊 Per vedere cosa è andato storto:${NC}"
    echo -e "${YELLOW}   npm run test:report${NC}"
    echo ""
    echo -e "${BLUE}🐛 Per debuggare il test:${NC}"
    echo -e "${YELLOW}   ./run-playwright-test.sh debug${NC}"
fi

echo ""
echo -e "${BLUE}Modalità disponibili:${NC}"
echo -e "  ${YELLOW}./run-playwright-test.sh${NC}          → Headless (default)"
echo -e "  ${YELLOW}./run-playwright-test.sh headed${NC}   → Con browser visibile"
echo -e "  ${YELLOW}./run-playwright-test.sh debug${NC}    → Modalità debug"
echo -e "  ${YELLOW}./run-playwright-test.sh ui${NC}       → UI interattiva"
echo ""

exit $EXIT_CODE
