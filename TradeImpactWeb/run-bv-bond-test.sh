#!/bin/bash

# Script per eseguire il test di sottoscrizione BV_BOND via WebSocket
# Questo script automatizza l'ottenimento del token e l'esecuzione del test k6

set -e

# Colori
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Configurazione predefinita
BASE_URL="${BASE_URL:-http://localhost:8081}"
USERNAME="${USERNAME:-trader1}"
PASSWORD="${PASSWORD:-password}"
IPSP_HOST="${IPSP_HOST:-localhost}"
IPSP_PORT="${IPSP_PORT:-7001}"
USE_SSL="${USE_SSL:-false}"
DURATION="${DURATION:-30}"
VERBOSE="${VERBOSE:-false}"

# Token può essere passato come primo argomento o variabile d'ambiente
TOKEN="${1:-$TOKEN}"

# Banner
print_banner() {
    echo -e "${BLUE}"
    echo "╔═══════════════════════════════════════════════════════════╗"
    echo "║      k6 BV_BOND WebSocket Subscription Test Runner       ║"
    echo "╚═══════════════════════════════════════════════════════════╝"
    echo -e "${NC}"
}

# Funzione per verificare se k6 è installato
check_k6_installed() {
    if ! command -v k6 &> /dev/null; then
        echo -e "${RED}❌ Errore: k6 non è installato${NC}"
        echo "Installalo con:"
        echo "  Ubuntu/Debian: sudo apt-get install k6"
        echo "  Fedora/RHEL:   sudo dnf install k6"
        echo "  macOS:         brew install k6"
        exit 1
    fi
}

# Funzione per verificare che jq sia installato (per parsing JSON)
check_jq_installed() {
    if ! command -v jq &> /dev/null; then
        echo -e "${YELLOW}⚠️  jq non installato (necessario per parsing JSON)${NC}"
        echo "Installalo con:"
        echo "  Ubuntu/Debian: sudo apt-get install jq"
        echo "  Fedora/RHEL:   sudo dnf install jq"
        echo "  macOS:         brew install jq"
        exit 1
    fi
}

# Funzione per ottenere il token via login
get_token() {
    echo -e "${YELLOW}🔑 Ottengo token di autenticazione...${NC}"
    echo "   Username:  ${USERNAME}"
    echo "   IPSP Host: ${IPSP_HOST}:${IPSP_PORT}"
    
    local login_payload=$(cat <<EOF
{
  "username": "${USERNAME}",
  "password": "${PASSWORD}",
  "ipspHost": "${IPSP_HOST}",
  "ipspPort": ${IPSP_PORT},
  "useSsl": ${USE_SSL}
}
EOF
)
    
    local response=$(curl -s -X POST "${BASE_URL}/api/auth/login" \
        -H "Content-Type: application/json" \
        -d "${login_payload}")
    
    if [ $? -ne 0 ]; then
        echo -e "${RED}❌ Errore di connessione al server${NC}"
        exit 1
    fi
    
    local success=$(echo "${response}" | jq -r '.success // false')
    
    if [ "${success}" != "true" ]; then
        echo -e "${RED}❌ Login fallito${NC}"
        echo "Response: ${response}"
        exit 1
    fi
    
    local token=$(echo "${response}" | jq -r '.token')
    
    if [ -z "${token}" ] || [ "${token}" = "null" ]; then
        echo -e "${RED}❌ Token non ricevuto dal server${NC}"
        echo "Response: ${response}"
        exit 1
    fi
    
    echo -e "${GREEN}✅ Token ottenuto: ${token:0:20}...${NC}"
    echo ""
    
    echo "${token}"
}

# Funzione per verificare che il server sia raggiungibile
check_server() {
    echo -e "${YELLOW}🔍 Verifico connessione al server ${BASE_URL}...${NC}"
    
    if curl -s -f -o /dev/null "${BASE_URL}" 2>/dev/null; then
        echo -e "${GREEN}✅ Server raggiungibile${NC}"
        echo ""
    else
        echo -e "${RED}❌ Server non raggiungibile: ${BASE_URL}${NC}"
        echo "Assicurati che il server sia in esecuzione"
        exit 1
    fi
}

# Funzione per stampare la configurazione
print_config() {
    echo -e "${BLUE}📋 Configurazione Test:${NC}"
    echo "   BASE_URL:  ${BASE_URL}"
    echo "   USERNAME:  ${USERNAME}"
    echo "   PASSWORD:  ********"
    echo "   IPSP_HOST: ${IPSP_HOST}"
    echo "   IPSP_PORT: ${IPSP_PORT}"
    echo "   USE_SSL:   ${USE_SSL}"
    echo "   DURATION:  ${DURATION} secondi"
    echo "   VERBOSE:   ${VERBOSE}"
    echo ""
}

# Funzione per eseguire il test k6
run_test() {
    local token=$1
    
    echo -e "${GREEN}🚀 Avvio test k6...${NC}"
    echo ""
    
    k6 run \
        -e TOKEN="${token}" \
        -e BASE_URL="${BASE_URL}" \
        -e USERNAME="${USERNAME}" \
        -e DURATION="${DURATION}" \
        -e VERBOSE="${VERBOSE}" \
        k6-bv-bond-subscription.js
    
    local exit_code=$?
    
    echo ""
    if [ $exit_code -eq 0 ]; then
        echo -e "${GREEN}✅ Test completato con successo${NC}"
    else
        echo -e "${RED}❌ Test fallito con codice ${exit_code}${NC}"
    fi
    
    return $exit_code
}

# Funzione per il logout (cleanup)
logout() {
    local token=$1
    
    if [ -z "${token}" ]; then
        return
    fi
    
    echo ""
    echo -e "${YELLOW}🚪 Logout...${NC}"
    
    curl -s -X POST "${BASE_URL}/api/auth/logout" \
        -H "Authorization: Bearer ${token}" \
        -H "Content-Type: application/json" > /dev/null
    
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}✅ Logout completato${NC}"
    fi
}

# Main
main() {
    print_banner
    
    # Verifica dipendenze
    check_k6_installed
    check_jq_installed
    
    # Stampa configurazione
    print_config
    
    # Verifica server
    check_server
    
    # Ottieni token (se non fornito)
    if [ -z "${TOKEN}" ]; then
        TOKEN=$(get_token)
    else
        echo -e "${GREEN}✅ Utilizzo token fornito: ${TOKEN:0:20}...${NC}"
        echo ""
    fi
    
    # Esegui test
    run_test "${TOKEN}"
    local test_exit_code=$?
    
    # Logout (cleanup)
    logout "${TOKEN}"
    
    exit $test_exit_code
}

# Help
if [ "$1" = "-h" ] || [ "$1" = "--help" ]; then
    print_banner
    echo "Esegue il test k6 di sottoscrizione WebSocket per la classe BV_BOND"
    echo ""
    echo "UTILIZZO:"
    echo "  $0 [TOKEN]"
    echo ""
    echo "PARAMETRI:"
    echo "  TOKEN    Token di autenticazione (opzionale, se omesso viene fatto login)"
    echo ""
    echo "VARIABILI D'AMBIENTE:"
    echo "  BASE_URL   URL del server (default: http://localhost:8081)"
    echo "  USERNAME   Username per login (default: trader1)"
    echo "  PASSWORD   Password per login (default: password)"
    echo "  IPSP_HOST  Host IPSP (default: localhost)"
    echo "  IPSP_PORT  Porta IPSP (default: 7001)"
    echo "  USE_SSL    Usa SSL (default: false)"
    echo "  DURATION   Durata test in secondi (default: 30)"
    echo "  VERBOSE    Stampa dettagli messaggi (default: false)"
    echo ""
    echo "ESEMPI:"
    echo ""
    echo "  1. Test con token esistente:"
    echo "     $0 eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    echo ""
    echo "  2. Test con login automatico:"
    echo "     $0"
    echo ""
    echo "  3. Test con configurazione personalizzata:"
    echo "     BASE_URL=http://prod:8081 USERNAME=admin PASSWORD=secret $0"
    echo ""
    echo "  4. Test lungo (5 minuti) con output verbose:"
    echo "     DURATION=300 VERBOSE=true $0"
    echo ""
    echo "  5. Solo ottenimento token (per uso successivo):"
    echo "     TOKEN=\$(BASE_URL=http://localhost:8081 USERNAME=trader1 PASSWORD=password $0 get-token)"
    echo ""
    exit 0
fi

# Comando speciale per ottenere solo il token
if [ "$1" = "get-token" ]; then
    check_jq_installed
    get_token
    exit 0
fi

# Esegui main
main "$@"
