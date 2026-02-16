#!/bin/bash
# Build Docker image per TradeImpact Web

set -e

echo "========================================="
echo "TradeImpact Web - Docker Build"
echo "========================================="
echo ""

# Check Docker
if ! command -v docker &> /dev/null; then
    echo "❌ Docker non trovato!"
    echo "Installa Docker: https://docs.docker.com/engine/install/"
    exit 1
fi

echo "✅ Docker trovato: $(docker --version)"
echo ""

# Build image
echo "🔨 Building Docker image..."
echo "Questo processo include:"
echo "  1. Build frontend React con Node.js"
echo "  2. Build backend Spring Boot con Maven"
echo "  3. Creazione immagine runtime minimale"
echo ""

# Check se forzare rebuild completo
NO_CACHE_FLAG=""
if [ "$1" == "--no-cache" ] || [ "$1" == "-f" ]; then
    echo "⚠️  Build senza cache (download completo dipendenze)"
    NO_CACHE_FLAG="--no-cache"
fi

# Passa variabili proxy al build
docker build \
  $NO_CACHE_FLAG \
  --build-arg HTTP_PROXY="${HTTP_PROXY}" \
  --build-arg HTTPS_PROXY="${HTTPS_PROXY}" \
  --build-arg NO_PROXY="${NO_PROXY}" \
  -t tradeimpact-web:latest .

if [ $? -ne 0 ]; then
    echo "❌ Errore durante docker build"
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
echo "  ./docker-run.sh"
echo ""
echo "Oppure con docker-compose:"
echo "  docker-compose up -d"
echo ""
echo "💡 Per forzare rebuild completo (scarica tutte le dipendenze):"
echo "  ./docker-build.sh --no-cache"
echo ""
