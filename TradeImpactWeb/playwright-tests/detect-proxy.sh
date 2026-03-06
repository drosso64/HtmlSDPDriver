#!/bin/bash

###############################################################################
# Script per rilevare automaticamente le impostazioni proxy dal sistema
###############################################################################

echo "🔍 Rilevamento configurazione proxy..."
echo ""

# Funzione per estrarre valore da variabili d'ambiente
check_env_var() {
    local var_name=$1
    local value=$(printenv $var_name 2>/dev/null)
    if [ -n "$value" ]; then
        echo "$var_name=$value"
        return 0
    fi
    return 1
}

# Controlla variabili d'ambiente comuni
echo "📡 Controllo variabili d'ambiente..."
FOUND=0

for var in HTTP_PROXY http_proxy HTTPS_PROXY https_proxy NO_PROXY no_proxy; do
    if check_env_var $var; then
        FOUND=1
    fi
done

if [ $FOUND -eq 0 ]; then
    echo "   ❌ Nessuna variabile proxy trovata nelle variabili d'ambiente"
fi

echo ""

# Controlla file di configurazione di sistema
echo "📄 Controllo file di configurazione sistema..."

if [ -f /etc/environment ]; then
    echo "   File: /etc/environment"
    grep -i proxy /etc/environment 2>/dev/null || echo "   ❌ Nessun proxy trovato"
fi

if [ -f ~/.bashrc ]; then
    echo "   File: ~/.bashrc"
    grep -i proxy ~/.bashrc 2>/dev/null || echo "   ❌ Nessun proxy trovato"
fi

if [ -f ~/.bash_profile ]; then
    echo "   File: ~/.bash_profile"
    grep -i proxy ~/.bash_profile 2>/dev/null || echo "   ❌ Nessun proxy trovato"
fi

echo ""

# Controlla configurazione npm (se installato)
if command -v npm &> /dev/null; then
    echo "📦 Controllo configurazione npm..."
    NPM_PROXY=$(npm config get proxy 2>/dev/null)
    NPM_HTTPS_PROXY=$(npm config get https-proxy 2>/dev/null)
    
    if [ "$NPM_PROXY" != "null" ] && [ -n "$NPM_PROXY" ]; then
        echo "   npm proxy: $NPM_PROXY"
        FOUND=1
    fi
    
    if [ "$NPM_HTTPS_PROXY" != "null" ] && [ -n "$NPM_HTTPS_PROXY" ]; then
        echo "   npm https-proxy: $NPM_HTTPS_PROXY"
        FOUND=1
    fi
    
    if [ $FOUND -eq 0 ]; then
        echo "   ❌ Nessun proxy configurato in npm"
    fi
else
    echo "📦 npm non installato, controllo saltato"
fi

echo ""

# Genera file .env.proxy se trovato qualcosa
if [ $FOUND -eq 1 ]; then
    echo "✅ Proxy rilevato!"
    echo ""
    echo "📝 Vuoi creare il file .env.proxy automaticamente? (y/n)"
    read -r response
    
    if [[ "$response" =~ ^[Yy]$ ]]; then
        HTTP_PROXY_VAL=$(printenv HTTP_PROXY || printenv http_proxy || npm config get proxy 2>/dev/null)
        HTTPS_PROXY_VAL=$(printenv HTTPS_PROXY || printenv https_proxy || npm config get https-proxy 2>/dev/null)
        NO_PROXY_VAL=$(printenv NO_PROXY || printenv no_proxy)
        
        cat > .env.proxy <<EOF
# Configurazione Proxy - Generata automaticamente
# Data: $(date)

HTTP_PROXY=${HTTP_PROXY_VAL}
HTTPS_PROXY=${HTTPS_PROXY_VAL}
NO_PROXY=${NO_PROXY_VAL:-localhost,127.0.0.1}
EOF
        
        echo "✅ File .env.proxy creato!"
        echo ""
        echo "📄 Contenuto:"
        cat .env.proxy
        echo ""
        echo "Puoi modificarlo con: nano .env.proxy"
    fi
else
    echo "❌ Nessun proxy rilevato"
    echo ""
    echo "💡 Possibili soluzioni:"
    echo "   1. Chiedi al tuo IT le impostazioni proxy"
    echo "   2. Copia e modifica il file di esempio:"
    echo "      cp .env.proxy.example .env.proxy"
    echo "      nano .env.proxy"
    echo "   3. Se non sei dietro un proxy, ignora questo messaggio"
fi

echo ""
