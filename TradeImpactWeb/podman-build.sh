#!/bin/bash
# Build con Podman (compatibile Docker)

set -e

echo "========================================="
echo "TradeImpact Web - Podman Build"
echo "========================================="
echo ""

# Check Podman
if ! command -v podman &> /dev/null; then
    echo "❌ Podman non trovato!"
    exit 1
fi

echo "✅ Podman trovato: $(podman --version)"
echo ""

# Build image
echo "🔨 Building image con Podman..."
echo "Questo processo include:"
echo "  1. Build frontend React con Node.js"
echo "  2. Build backend Spring Boot con Maven"
echo "  3. Creazione immagine runtime minimale"
echo ""

podman build -t tradeimpact-web:latest .

if [ $? -ne 0 ]; then
    echo "❌ Errore durante podman build"
    exit 1
fi

echo ""
echo "========================================="
echo "✨ Build completato!"
echo "========================================="
echo ""
echo "Immagine creata: tradeimpact-web:latest"
echo ""
echo "Per avviare l'applicazione:"
echo "  podman run -d -p 8080:8080 --name tradeimpact-web tradeimpact-web:latest"
echo ""
echo "Oppure usa docker-compose (podman-compose):"
echo "  podman-compose up -d"
echo ""
