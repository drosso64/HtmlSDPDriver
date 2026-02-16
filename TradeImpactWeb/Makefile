.PHONY: help build run stop restart logs clean rebuild shell test

# Default target
.DEFAULT_GOAL := help

# Variables
IMAGE_NAME := tradeimpact-web
CONTAINER_NAME := tradeimpact-web
TAG := latest

help: ## Mostra questo messaggio di aiuto
	@echo "TradeImpact Web - Docker Commands"
	@echo "=================================="
	@echo ""
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2}'
	@echo ""

build: ## Build Docker image
	@echo "🔨 Building Docker image..."
	docker build -t $(IMAGE_NAME):$(TAG) .
	@echo "✅ Build completato: $(IMAGE_NAME):$(TAG)"

run: ## Avvia container con docker-compose
	@echo "🚀 Starting container..."
	docker-compose up -d
	@echo "✅ Container avviato su http://localhost:8080"

stop: ## Ferma container
	@echo "🛑 Stopping container..."
	docker-compose down
	@echo "✅ Container fermato"

restart: stop run ## Riavvia container

logs: ## Visualizza logs in tempo reale
	docker-compose logs -f

clean: ## Rimuovi container, volumi e immagini
	@echo "🧹 Cleaning up..."
	docker-compose down -v
	docker rmi $(IMAGE_NAME):$(TAG) 2>/dev/null || true
	@echo "✅ Cleanup completato"

rebuild: clean build run ## Rebuild completo e restart

shell: ## Apri shell nel container
	docker exec -it $(CONTAINER_NAME) sh

test: ## Test health endpoint
	@echo "🧪 Testing application..."
	@curl -f http://localhost:8080/actuator/health 2>/dev/null && echo "\n✅ Application is healthy" || echo "\n❌ Application is not responding"

ps: ## Mostra stato container
	docker-compose ps

stats: ## Mostra statistiche container
	docker stats $(CONTAINER_NAME) --no-stream

backup: ## Backup database
	@echo "💾 Creating backup..."
	@mkdir -p backups
	tar -czf backups/backup-$$(date +%Y%m%d-%H%M%S).tar.gz data/
	@echo "✅ Backup creato in backups/"

dev: ## Avvia in modalità development (con logs visibili)
	docker-compose up

pull: ## Pull immagini base aggiornate
	docker pull node:18-alpine
	docker pull maven:3.9-eclipse-temurin-17
	docker pull eclipse-temurin:17-jre-alpine
