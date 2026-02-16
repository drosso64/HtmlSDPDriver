#!/bin/bash
# Script per verificare configurazione Docker/Podman per utenza tecnica

echo "========================================="
echo "Verifica Configurazione Container Runtime"
echo "========================================="
echo ""

echo "👤 Utente corrente: $(whoami)"
echo "📁 Directory: $(pwd)"
echo ""

# Check Docker
echo "🔍 Verifica Docker..."
if command -v docker &> /dev/null; then
    echo "✅ Docker trovato: $(docker --version)"
    echo ""
    echo "🧪 Test permessi Docker..."
    if docker ps &> /dev/null; then
        echo "✅ Docker funziona correttamente!"
        DOCKER_WORKS=true
    else
        echo "⚠️  Docker trovato ma permessi insufficienti"
        echo "   Prova: sudo docker ps"
        DOCKER_WORKS=false
    fi
else
    echo "❌ Docker non trovato"
    DOCKER_WORKS=false
fi

echo ""

# Check Podman
echo "🔍 Verifica Podman..."
if command -v podman &> /dev/null; then
    echo "✅ Podman trovato: $(podman --version)"
    echo ""
    echo "🧪 Test permessi Podman..."
    if podman ps &> /dev/null; then
        echo "✅ Podman funziona correttamente!"
        
        # Check subuid/subgid
        echo ""
        echo "🔍 Verifica subuid/subgid..."
        if grep -q "^$(whoami):" /etc/subuid 2>/dev/null && grep -q "^$(whoami):" /etc/subgid 2>/dev/null; then
            echo "✅ subuid/subgid configurati:"
            grep "^$(whoami):" /etc/subuid /etc/subgid
            PODMAN_WORKS=true
        else
            echo "⚠️  subuid/subgid NON configurati"
            PODMAN_WORKS=false
        fi
    else
        echo "⚠️  Podman trovato ma non funziona"
        PODMAN_WORKS=false
    fi
else
    echo "❌ Podman non trovato"
    PODMAN_WORKS=false
fi

echo ""
echo "========================================="
echo "📊 RIEPILOGO"
echo "========================================="

if [ "$DOCKER_WORKS" = true ]; then
    echo "✅ Puoi usare: ./docker-build.sh"
    echo "   (usa Docker)"
elif [ "$PODMAN_WORKS" = true ]; then
    echo "✅ Puoi usare: ./docker-build.sh"
    echo "   (usa Podman con subuid/subgid configurati)"
else
    echo "❌ Nessun runtime funzionante trovato"
    echo ""
    echo "Prova:"
    echo "  - sudo docker build ..."
    echo "  - sudo podman build ..."
fi

echo ""
