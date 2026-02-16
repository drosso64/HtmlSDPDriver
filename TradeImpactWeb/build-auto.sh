#!/bin/bash
# Build automatico - rileva e usa il metodo appropriato

set -e

echo "========================================="
echo "TradeImpact Web - Smart Build"
echo "========================================="
echo ""

# Funzione per controllare subuid/subgid
check_subuid() {
    if grep -q "^$(whoami):" /etc/subuid 2>/dev/null && \
       grep -q "^$(whoami):" /etc/subgid 2>/dev/null; then
        return 0
    else
        return 1
    fi
}

# Funzione per build con Podman rootless
build_podman_rootless() {
    echo "📦 Usando Podman rootless con Dockerfile.rootless"
    echo ""
    
    # Prova prima senza --userns
    if podman build --format docker -f Dockerfile.rootless -t tradeimpact-web:latest . 2>&1 | grep -q "invalid argument"; then
        echo "⚠️  Build standard fallito, provo con --isolation=chroot"
        podman build \
          --isolation=chroot \
          --format docker \
          -f Dockerfile.rootless \
          -t tradeimpact-web:latest \
          .
    else
        podman build \
          --format docker \
          -f Dockerfile.rootless \
          -t tradeimpact-web:latest \
          .
    fi
}

# Funzione per build con Podman standard
build_podman_standard() {
    echo "📦 Usando Podman con subuid/subgid configurati"
    echo ""
    
    podman build \
      --format docker \
      -t tradeimpact-web:latest \
      .
}

# Funzione per build con Docker
build_docker() {
    echo "🐳 Usando Docker"
    echo ""
    
    docker build -t tradeimpact-web:latest .
}

# Rileva quale tool usare
if command -v docker &> /dev/null && ! grep -q podman "$(which docker)"; then
    echo "✅ Docker nativo trovato"
    BUILD_METHOD="docker"
elif command -v podman &> /dev/null; then
    echo "✅ Podman trovato"
    if check_subuid; then
        echo "✅ subuid/subgid configurati"
        BUILD_METHOD="podman-standard"
    else
        echo "⚠️  subuid/subgid NON configurati - uso modalità rootless"
        BUILD_METHOD="podman-rootless"
    fi
else
    echo "❌ Né Docker né Podman trovati!"
    exit 1
fi

echo ""
echo "Metodo selezionato: $BUILD_METHOD"
echo ""
echo "🔨 Avvio build..."
echo "Questo processo può richiedere 3-5 minuti..."
echo ""

# Esegui build
case $BUILD_METHOD in
    docker)
        build_docker
        ;;
    podman-standard)
        build_podman_standard
        ;;
    podman-rootless)
        build_podman_rootless
        ;;
esac

if [ $? -ne 0 ]; then
    echo ""
    echo "❌ Build fallito"
    echo ""
    echo "Soluzioni:"
    echo "1. Configura subuid/subgid (richiede admin):"
    echo "   sudo usermod --add-subuids 100000-165535 --add-subgids 100000-165535 $(whoami)"
    echo "   podman system migrate"
    echo ""
    echo "2. Usa Docker invece di Podman"
    echo ""
    echo "3. Chiedi supporto all'amministratore di sistema"
    echo ""
    exit 1
fi

echo ""
echo "========================================="
echo "✨ Build completato con successo!"
echo "========================================="
echo ""
echo "Immagine creata: tradeimpact-web:latest"
echo ""
echo "Per avviare:"
if [ "$BUILD_METHOD" = "docker" ]; then
    echo "  docker-compose up -d"
else
    echo "  podman-compose up -d"
    echo "  # oppure"
    echo "  podman run -d -p 8080:8080 --name tradeimpact-web tradeimpact-web:latest"
fi
echo ""
