# TradeImpact Web - Podman Setup

## Compatibilità Podman

Il sistema usa **Podman** che è 100% compatibile con Docker CLI.

Podman è già configurato per emulare Docker, quindi tutti i comandi Docker funzionano:

```bash
# Questi comandi sono equivalenti:
docker build -t app .     # ✅ Funziona
podman build -t app .     # ✅ Funziona

docker run app            # ✅ Funziona  
podman run app            # ✅ Funziona

docker-compose up         # ✅ Funziona (usa podman sotto)
podman-compose up         # ✅ Funziona
```

## Quick Start con Podman

### 1. Build Immagine

**Opzione A: Script automatico**
```bash
./podman-build.sh
```

**Opzione B: Comando diretto**
```bash
podman build -t tradeimpact-web:latest .
```

**Opzione C: Usa alias docker** (già configurato nel sistema)
```bash
docker build -t tradeimpact-web:latest .
```

### 2. Esegui Container

```bash
# Run in background
podman run -d \
  --name tradeimpact-web \
  -p 8080:8080 \
  -v $(pwd)/data:/app/data:Z \
  tradeimpact-web:latest

# Visualizza logs
podman logs -f tradeimpact-web

# Ferma container
podman stop tradeimpact-web
```

### 3. Usa Docker Compose

```bash
# docker-compose usa automaticamente podman
docker-compose up -d

# Oppure esplicitamente
podman-compose up -d
```

## Comandi Podman

Tutti i comandi Docker funzionano sostituendo `docker` con `podman`:

```bash
# Build
podman build -t tradeimpact-web .

# Run
podman run -d -p 8080:8080 tradeimpact-web

# List containers
podman ps

# Logs
podman logs -f tradeimpact-web

# Stop
podman stop tradeimpact-web

# Remove
podman rm tradeimpact-web

# Images
podman images

# System info
podman info
```

## Differenze Podman vs Docker

### Vantaggi Podman

✅ **Rootless by default** - Più sicuro, non richiede root
✅ **Daemonless** - Nessun daemon in background
✅ **Systemd integration** - Container come servizi systemd
✅ **Drop-in replacement** - Compatibile al 100% con Docker CLI

### SELinux Context (importante!)

Quando monti volumi su sistemi con SELinux (Red Hat/CentOS), aggiungi `:Z`:

```bash
# ❌ Senza :Z potrebbe dare errori di permessi
-v $(pwd)/data:/app/data

# ✅ Con :Z funziona correttamente
-v $(pwd)/data:/app/data:Z
```

Il docker-compose.yml è già configurato correttamente.

## Rootless Podman

Podman può eseguire container senza root:

```bash
# Container rootless (già il default)
podman run -d -p 8080:8080 tradeimpact-web

# Verifica user
podman exec tradeimpact-web whoami
# Output: appuser (non root!)
```

### Port Binding Rootless

Per porte < 1024 senza root, configura:

```bash
# Abilita porte privilegiate per user
echo "net.ipv4.ip_unprivileged_port_start=80" | sudo tee /etc/sysctl.d/podman-ports.conf
sudo sysctl -p /etc/sysctl.d/podman-ports.conf

# Ora puoi usare porta 80
podman run -p 80:8080 tradeimpact-web
```

## Podman Compose

Se `docker-compose` non funziona, installa `podman-compose`:

```bash
# Installa podman-compose
pip3 install --user podman-compose

# Usa come docker-compose
podman-compose up -d
podman-compose down
podman-compose logs -f
```

## Systemd Integration

Podman si integra perfettamente con systemd:

```bash
# Genera unit file systemd
podman generate systemd --new --name tradeimpact-web > ~/.config/systemd/user/tradeimpact-web.service

# Abilita e avvia
systemctl --user enable tradeimpact-web.service
systemctl --user start tradeimpact-web.service

# Status
systemctl --user status tradeimpact-web.service

# Logs
journalctl --user -u tradeimpact-web.service -f

# Auto-start al boot
loginctl enable-linger $USER
```

## Storage

Podman usa storage diverso da Docker:

```bash
# Info storage
podman info --format '{{.Store.GraphRoot}}'
# Output: /home/user/.local/share/containers/storage

# Pulisci storage
podman system prune -a -f
```

## Networking

Podman crea network automaticamente:

```bash
# List networks
podman network ls

# Inspect network
podman network inspect podman

# Create custom network
podman network create tradeimpact-net

# Run con network
podman run --network tradeimpact-net tradeimpact-web
```

## Build Cache

```bash
# Build senza cache
podman build --no-cache -t tradeimpact-web .

# Pulisci build cache
podman system prune --all

# Info cache
podman system df
```

## Troubleshooting Podman

### Permission Denied su Volumi

```bash
# Aggiungi :Z per SELinux
podman run -v $(pwd)/data:/app/data:Z tradeimpact-web
```

### Port Already in Use

```bash
# Trova processo
sudo lsof -i :8080

# O usa porta diversa
podman run -p 8081:8080 tradeimpact-web
```

### Subuid/Subgid not configured

```bash
# Check configurazione
cat /etc/subuid
cat /etc/subgid

# Se vuoti, configura
echo "$USER:100000:65536" | sudo tee -a /etc/subuid
echo "$USER:100000:65536" | sudo tee -a /etc/subgid

# Reset podman
podman system migrate
```

## Best Practices Podman

✅ Usa volumi con `:Z` per SELinux
✅ Preferisci rootless quando possibile
✅ Usa systemd per produzione
✅ Configura loginctl linger per auto-start
✅ Monta volumi esplicitamente per persistenza

## Makefile Aggiornato

Il Makefile funziona già con Podman (tramite alias docker).

```bash
# Tutti questi comandi usano podman sotto
make build    # Build immagine
make run      # Avvia container
make logs     # Visualizza logs
make stop     # Ferma container
make restart  # Riavvia
```

## Verifica Setup

```bash
# Check Podman
podman --version

# Check podman-compose (opzionale)
podman-compose --version

# Test build
podman build -t test .

# Test run
podman run --rm test echo "OK"
```

## Risorse

- [Podman Documentation](https://docs.podman.io/)
- [Podman vs Docker](https://docs.podman.io/en/latest/Introduction.html)
- [Rootless Containers](https://docs.podman.io/en/latest/markdown/podman.1.html#rootless-mode)
- [Podman Compose](https://github.com/containers/podman-compose)

## Summary

**Podman è già pronto** nel tuo sistema! 

Usa questi comandi per iniziare:

```bash
# Build
./docker-build.sh        # Usa podman automaticamente

# Run  
docker-compose up -d     # Usa podman sotto

# Or
make build && make run   # Usa podman via Makefile
```

Tutto funziona esattamente come Docker! 🎉
