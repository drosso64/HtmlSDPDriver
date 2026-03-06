#!/bin/bash

###############################################################################
# Script per eseguire i test Playwright in Docker
###############################################################################

set -e

# Colori
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
NC='\033[0m'

echo -e "${BLUE}╔════════════════════════════════════════════════════════════════╗${NC}"
echo -e "${BLUE}║     Docker Run - Playwright Tests                             ║${NC}"
echo -e "${BLUE}╚════════════════════════════════════════════════════════════════╝${NC}"
echo ""

IMAGE_NAME="tradeimpact-playwright"
IMAGE_TAG="${IMAGE_TAG:-latest}"

# Verifica se l'immagine esiste
if ! docker images ${IMAGE_NAME}:${IMAGE_TAG} | grep -q ${IMAGE_NAME}; then
    echo -e "${YELLOW}⚠️  Immagine ${IMAGE_NAME}:${IMAGE_TAG} non trovata${NC}"
    echo -e "${BLUE}📦 Building immagine...${NC}"
    ./docker-build-playwright.sh
    echo ""
fi

# Modalità di esecuzione
MODE="${1:-headless}"

# Determina il comando da eseguire
case $MODE in
    "headed")
        CMD="npm run test:headed"
        ;;
    "api")
        CMD="npm run test:api"
        ;;
    "debug")
        CMD="npm run test:debug"
        ;;
    "ui")
        CMD="npm run test:ui"
        ;;
    "bash")
        CMD="/bin/bash"
        INTERACTIVE="-it"
        ;;
    "headless"|*)
        CMD="npm test"
        ;;
esac

echo -e "${BLUE}🐳 Esecuzione container...${NC}"
echo -e "${BLUE}   Immagine: ${IMAGE_NAME}:${IMAGE_TAG}${NC}"
echo -e "${BLUE}   Modalità: ${MODE}${NC}"
echo -e "${BLUE}   Comando: ${CMD}${NC}"
echo ""

# Determina l'indirizzo del backend
# Se l'app gira su localhost:8081, usa host.docker.internal per raggiungerla dal container
BACKEND_URL="${BACKEND_URL:-http://host.docker.internal:8081}"

echo -e "${YELLOW}ℹ️  Backend URL: ${BACKEND_URL}${NC}"
echo -e "${YELLOW}   Se l'app non risponde, verifica che sia raggiungibile dal container${NC}"
echo ""

# Crea le directory per i report se non esistono
echo -e "${BLUE}📁 Preparazione directory per report...${NC}"
mkdir -p playwright-report test-results
echo ""

# Esegui il container
# Aggiunta etichetta SELinux (:Z) sui bind-mount per evitare errori EACCES
docker run --rm ${INTERACTIVE} \
    --user 0 \
    --name playwright-tests \
    --network host \
    -e BASE_URL=${BACKEND_URL} \
    -v "$(pwd)/tests:/tests/tests:ro,Z" \
    -v "$(pwd)/playwright-report:/tests/playwright-report:Z" \
    -v "$(pwd)/test-results:/tests/test-results:Z" \
    ${IMAGE_NAME}:${IMAGE_TAG} \
    ${CMD}

EXIT_CODE=$?

echo ""
if [ $EXIT_CODE -eq 0 ]; then
    echo -e "${GREEN}╔════════════════════════════════════════════════════════════════╗${NC}"
    echo -e "${GREEN}║  ✅ Test completato con successo!                              ║${NC}"
    echo -e "${GREEN}╚════════════════════════════════════════════════════════════════╝${NC}"
    echo ""
    echo -e "${BLUE}📊 Report salvato in: playwright-report/${NC}"
    if [ -f "playwright-report/index.html" ]; then
        echo -e "${YELLOW}   Apri: file://$(pwd)/playwright-report/index.html${NC}"
    fi
else
    echo -e "${RED}╔════════════════════════════════════════════════════════════════╗${NC}"
    echo -e "${RED}║  ❌ Test fallito!                                              ║${NC}"
    echo -e "${RED}╚════════════════════════════════════════════════════════════════╝${NC}"
    echo ""
    echo -e "${BLUE}📊 Controlla i report in: test-results/${NC}"
fi

echo ""
echo -e "${BLUE}Modalità disponibili:${NC}"
echo -e "  ${YELLOW}./docker-run-playwright.sh${NC}          → Headless (default)"
echo -e "  ${YELLOW}./docker-run-playwright.sh headed${NC}   → Con browser visibile"
echo -e "  ${YELLOW}./docker-run-playwright.sh bash${NC}     → Shell interattiva"
echo ""

exit $EXIT_CODE
