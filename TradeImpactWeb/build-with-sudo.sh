#!/bin/bash
# Soluzione per build senza subuid/subgid - usa sudo temporaneo

set -e

echo "========================================="
echo "TradeImpact Web - Build con sudo"
echo "========================================="
echo ""
echo "⚠️  ATTENZIONE:"
echo "Questo script richiede sudo per il build"
echo "L'immagine sarà disponibile anche per il tuo utente"
echo ""

# Check sudo
if ! sudo -n true 2>/dev/null; then
    echo "Richiedo password sudo..."
    sudo -v
fi

echo "🔨 Build con sudo podman..."
echo ""

# Build con sudo
sudo podman build \
  --format docker \
  -t tradeimpact-web:latest \
  .

if [ $? -ne 0 ]; then
    echo "❌ Build fallito"
    exit 1
fi

echo ""
echo "📦 Esporto immagine per utente corrente..."

# Esporta e importa per utente corrente
sudo podman save tradeimpact-web:latest | podman load

echo ""
echo "========================================="
echo "✨ Build completato!"
echo "========================================="
echo ""
echo "L'immagine è ora disponibile anche per il tuo utente"
echo ""
echo "Per avviare:"
echo "  podman run -d -p 8080:8080 --name tradeimpact-web tradeimpact-web:latest"
echo ""
