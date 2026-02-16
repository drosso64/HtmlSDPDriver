#!/bin/bash
# Build con Podman rootless - workaround per subuid/subgid

set -e

echo "========================================="
echo "TradeImpact Web - Podman Build (Rootless Fix)"
echo "========================================="
echo ""

# Check Podman
if ! command -v podman &> /dev/null; then
    echo "❌ Podman non trovato!"
    exit 1
fi

echo "✅ Podman trovato: $(podman --version)"
echo ""

# Check subuid/subgid
if ! grep -q "^$(whoami):" /etc/subuid 2>/dev/null; then
    echo "⚠️  ATTENZIONE: subuid/subgid non configurati"
    echo ""
    echo "Soluzione: Chiedi all'amministratore di eseguire:"
    echo "  sudo usermod --add-subuids 100000-165535 --add-subgids 100000-165535 $(whoami)"
    echo "  podman system migrate"
    echo ""
    echo "In alternativa, uso --userns=keep-id per build rootless..."
    echo ""
    USERNS_FLAG="--userns=keep-id"
else
    echo "✅ subuid/subgid configurati"
    USERNS_FLAG=""
fi

# Build image con flag appropriati
echo "🔨 Building image con Podman (rootless mode)..."
echo ""

podman build \
  $USERNS_FLAG \
  --format docker \
  -t tradeimpact-web:latest \
  .

if [ $? -ne 0 ]; then
    echo ""
    echo "❌ Errore durante podman build"
    echo ""
    echo "Se l'errore persiste, prova una di queste soluzioni:"
    echo ""
    echo "1. Chiedi all'admin di configurare subuid/subgid:"
    echo "   sudo usermod --add-subuids 100000-165535 --add-subgids 100000-165535 $(whoami)"
    echo "   sudo usermod --add-subuids 100000-165535 --add-subgids 100000-165535 $(whoami)"
    echo "   podman system migrate"
    echo ""
    echo "2. Oppure usa Docker (se disponibile):"
    echo "   docker build -t tradeimpact-web:latest ."
    echo ""
    echo "3. Oppure esegui con sudo:"
    echo "   sudo podman build -t tradeimpact-web:latest ."
    echo ""
    exit 1
fi

echo ""
echo "========================================="
echo "✨ Build completato!"
echo "========================================="
echo ""
echo "Immagine creata: tradeimpact-web:latest"
echo ""
echo "Per avviare:"
echo "  podman run -d -p 8080:8080 --name tradeimpact-web tradeimpact-web:latest"
echo ""
