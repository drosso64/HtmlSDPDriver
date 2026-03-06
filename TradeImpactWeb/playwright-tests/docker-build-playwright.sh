#!/bin/bash

###############################################################################
# Script per buildare l'immagine Docker Playwright
###############################################################################

set -e

# Colori
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
NC='\033[0m'

echo -e "${BLUE}╔════════════════════════════════════════════════════════════════╗${NC}"
echo -e "${BLUE}║     Docker Build - Playwright Test Image                      ║${NC}"
echo -e "${BLUE}╚════════════════════════════════════════════════════════════════╝${NC}"
echo ""

IMAGE_NAME="tradeimpact-playwright"
IMAGE_TAG="${1:-latest}"

echo -e "${BLUE}📦 Building image: ${IMAGE_NAME}:${IMAGE_TAG}${NC}"

# Carica configurazione proxy se esiste
PROXY_ARGS=""
if [ -f ".env.proxy" ]; then
    echo -e "${BLUE}📡 Caricamento configurazione proxy da .env.proxy${NC}"
    source .env.proxy
    
    if [ -n "$HTTP_PROXY" ]; then
        PROXY_ARGS="$PROXY_ARGS --build-arg HTTP_PROXY=$HTTP_PROXY"
        echo -e "${BLUE}   HTTP_PROXY: ${HTTP_PROXY}${NC}"
    fi
    if [ -n "$HTTPS_PROXY" ]; then
        PROXY_ARGS="$PROXY_ARGS --build-arg HTTPS_PROXY=$HTTPS_PROXY"
        echo -e "${BLUE}   HTTPS_PROXY: ${HTTPS_PROXY}${NC}"
    fi
    if [ -n "$NO_PROXY" ]; then
        PROXY_ARGS="$PROXY_ARGS --build-arg NO_PROXY=$NO_PROXY"
        echo -e "${BLUE}   NO_PROXY: ${NO_PROXY}${NC}"
    fi
else
    echo -e "${YELLOW}ℹ️  File .env.proxy non trovato - build senza proxy${NC}"
    echo -e "${YELLOW}   Se sei dietro un proxy, crea il file .env.proxy (vedi .env.proxy.example)${NC}"
fi

#
# Build dell'immagine
# Disabilita set -e temporaneamente per gestire fallback su errori di build
set +e
docker build \
    -f Dockerfile.playwright \
    -t ${IMAGE_NAME}:${IMAGE_TAG} \
    $PROXY_ARGS \
    .

RC=$?
set -e
if [ $RC -ne 0 ]; then
        echo ""
        echo -e "${YELLOW}⚠️  Build fallita con 'docker build'. Provo il fallback con podman (--userns=keep-id)...${NC}"
        echo ""
        # Prova a usare podman con userns keep-id per evitare errori di UID/GID in rootless
        if command -v podman &> /dev/null; then
                podman build --userns=keep-id \
                    -f Dockerfile.playwright \
                    -t ${IMAGE_NAME}:${IMAGE_TAG} \
                    $PROXY_ARGS \
                    . || true
                RC=$?
                if [ $RC -ne 0 ]; then
                        echo ""
                        echo -e "${RED}❌ Fallback podman (--userns=keep-id) fallito.${NC}"
                        echo -e "${YELLOW}➡️  Se hai i permessi sudo, prova: sudo podman build -f Dockerfile.playwright -t ${IMAGE_NAME}:${IMAGE_TAG} .${NC}"
                        exit $RC
                fi
        else
                echo -e "${RED}❌ Podman non installato, e 'docker build' è fallito.${NC}"
                echo -e "${YELLOW}➡️  Se possibile, esegui il build come root: sudo docker build -f Dockerfile.playwright -t ${IMAGE_NAME}:${IMAGE_TAG} .${NC}"
                exit $RC
        fi
fi

if [ $RC -eq 0 ]; then
    echo ""
    echo -e "${GREEN}╔════════════════════════════════════════════════════════════════╗${NC}"
    echo -e "${GREEN}║  ✅ Immagine creata con successo!                              ║${NC}"
    echo -e "${GREEN}╚════════════════════════════════════════════════════════════════╝${NC}"
    echo ""
    echo -e "${BLUE}📋 Informazioni immagine:${NC}"
    docker images ${IMAGE_NAME}:${IMAGE_TAG}
    echo ""
    echo -e "${BLUE}🚀 Per eseguire i test:${NC}"
    echo -e "${YELLOW}   ./docker-run-playwright.sh${NC}"
    echo ""
else
    echo -e "${RED}❌ Build fallita${NC}"
    exit 1
fi
