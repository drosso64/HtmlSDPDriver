#!/bin/bash
# Quick Setup Script - TradeImpact Web Frontend

set -e

echo "========================================="
echo "TradeImpact Web - Frontend Setup"
echo "========================================="
echo ""

# Check Node.js
if ! command -v node &> /dev/null; then
    echo "❌ Node.js non trovato!"
    echo ""
    echo "Installalo con:"
    echo "  curl -fsSL https://rpm.nodesource.com/setup_lts.x | sudo bash -"
    echo "  sudo yum install -y nodejs"
    echo ""
    exit 1
fi

NODE_VERSION=$(node --version)
echo "✅ Node.js trovato: $NODE_VERSION"

# Check npm
if ! command -v npm &> /dev/null; then
    echo "❌ npm non trovato!"
    exit 1
fi

NPM_VERSION=$(npm --version)
echo "✅ npm trovato: $NPM_VERSION"
echo ""

# Navigate to frontend
cd "$(dirname "$0")/frontend"

# Install dependencies
echo "📦 Installazione dipendenze..."
npm install

if [ $? -ne 0 ]; then
    echo "❌ Errore durante npm install"
    exit 1
fi

echo "✅ Dipendenze installate"
echo ""

# Build frontend
echo "🔨 Build frontend..."
npm run build

if [ $? -ne 0 ]; then
    echo "❌ Errore durante npm run build"
    exit 1
fi

echo "✅ Frontend compilato in src/main/resources/static/"
echo ""

# Back to project root
cd ..

# Build Spring Boot
echo "🔨 Build Spring Boot..."
mvn clean package -DskipTests

if [ $? -ne 0 ]; then
    echo "❌ Errore durante mvn package"
    exit 1
fi

echo "✅ JAR creato: target/TradeImpactWeb-0.0.1-SNAPSHOT.jar"
echo ""

echo "========================================="
echo "✨ Setup completato!"
echo "========================================="
echo ""
echo "Per avviare l'applicazione:"
echo "  java -jar target/TradeImpactWeb-0.0.1-SNAPSHOT.jar"
echo ""
echo "L'app sarà disponibile su: http://localhost:8080"
echo ""
