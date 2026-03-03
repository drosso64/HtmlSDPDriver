#!/bin/bash
# Run TradeImpact Web in Docker

set -e

IMAGE_NAME="tradeimpact-web:latest"
CONTAINER_NAME="tradeimpact-web"

echo "========================================="
echo "TradeImpact Web - Docker Run"
echo "========================================="
echo ""

# Check if image exists
if ! docker image inspect $IMAGE_NAME &> /dev/null; then
    echo "❌ Immagine $IMAGE_NAME non trovata!"
    echo ""
    echo "Build prima l'immagine:"
    echo "  ./docker-build.sh"
    echo ""
    exit 1
fi

# Stop existing container
if docker ps -a --format '{{.Names}}' | grep -q "^${CONTAINER_NAME}$"; then
    echo "🛑 Stopping existing container..."
    docker stop $CONTAINER_NAME
    docker rm $CONTAINER_NAME
fi

# Create data directory
mkdir -p ./data ./logs

echo "🚀 Starting container..."
echo ""

# Run container
docker run -d \
  --name $CONTAINER_NAME \
  -p 8080:8080 \
  -v "$(pwd)/data:/app/data" \
  -v "$(pwd)/logs:/app/logs" \
    -e PLATFORM_ID="${PLATFORM_ID:-1}" \
    -e IPSP_HOST="${IPSP_HOST:-}" \
    -e IPSP_PORT="${IPSP_PORT:-8800}" \
    -e IPSP_SSL="${IPSP_SSL:-true}" \
  --restart unless-stopped \
  $IMAGE_NAME

if [ $? -ne 0 ]; then
    echo "❌ Errore durante docker run"
    exit 1
fi

echo "========================================="
echo "✨ Container avviato!"
echo "========================================="
echo ""
echo "Container: $CONTAINER_NAME"
echo "Porta: http://localhost:8080"
echo ""
echo "Comandi utili:"
echo "  docker logs -f $CONTAINER_NAME       # Visualizza logs"
echo "  docker stop $CONTAINER_NAME          # Ferma container"
echo "  docker restart $CONTAINER_NAME       # Riavvia container"
echo ""
echo "Attendere ~30 secondi per l'avvio completo..."
echo ""
