# Podman Rootless - Fix Errori subuid/subgid

## Problema

L'errore che stai vedendo:
```
ERRO[0000] cannot find UID/GID for user drosso: no subuid ranges found for user "drosso" in /etc/subuid
```

Significa che Podman rootless non può creare user namespace perché mancano le configurazioni in `/etc/subuid` e `/etc/subgid`.

## ✅ Soluzioni (in ordine di preferenza)

### Soluzione 1: Build Automatico (CONSIGLIATO)

Ho creato uno script che rileva automaticamente il problema e usa il metodo appropriato:

```bash
./build-auto.sh
```

Questo script:
- Rileva se hai subuid/subgid configurati
- Usa Dockerfile ottimizzato per rootless se necessario
- Applica flag `--userns=keep-id` automaticamente
- Funziona senza permessi root

### Soluzione 2: Script Podman Rootless Dedicato

```bash
./podman-build-rootless.sh
```

Usa un Dockerfile modificato che non richiede user specifici.

### Soluzione 3: Configurazione subuid/subgid (richiede admin)

Se hai accesso sudo o puoi chiedere all'amministratore:

```bash
# Configurazione (UNA VOLTA, da admin)
sudo usermod --add-subuids 100000-165535 --add-subgids 100000-165535 drosso
podman system migrate

# Poi usa il build normale
./docker-build.sh
```

Verifica configurazione:
```bash
grep "^$(whoami):" /etc/subuid /etc/subgid
# Dovrebbe mostrare qualcosa come:
# /etc/subuid:drosso:100000:65536
# /etc/subgid:drosso:100000:65536
```

### Soluzione 4: Build con sudo (temporaneo)

Se hai accesso sudo:

```bash
sudo podman build -t tradeimpact-web:latest .
```

**Nota**: Questo crea l'immagine nel repository root, dovrai poi copiarla:
```bash
sudo podman save tradeimpact-web:latest | podman load
```

## 🔍 Differenze tra i Dockerfile

### Dockerfile (standard)
```dockerfile
# Crea user non-root nel container
RUN addgroup -g 1000 appuser && \
    adduser -D -u 1000 -G appuser appuser
USER appuser
```
**Richiede**: subuid/subgid configurati

### Dockerfile.rootless (workaround)
```dockerfile
# NON crea user specifico
# Podman gestisce automaticamente il mapping con --userns=keep-id
```
**Funziona**: Anche senza subuid/subgid

## 🧪 Test Setup

```bash
# Check se subuid/subgid sono configurati
grep "^$USER:" /etc/subuid /etc/subgid

# Test build
./build-auto.sh

# Se funziona, avvia
podman run -d -p 8080:8080 --name tradeimpact-web tradeimpact-web:latest

# Verifica
podman ps
curl http://localhost:8080/actuator/health
```

## 📋 Quale metodo usare?

| Scenario | Comando | Note |
|----------|---------|------|
| **Nessun permesso root** | `./build-auto.sh` | ✅ Consigliato - funziona sempre |
| **Admin disponibile** | Configura subuid → `./docker-build.sh` | Migliore a lungo termine |
| **Docker disponibile** | `docker build -t tradeimpact-web .` | Alternative se Podman problematico |
| **Emergenza con sudo** | `sudo podman build ...` | Solo per test rapidi |

## 🐛 Debugging

### Verifica setup Podman
```bash
podman info | grep -A5 "rootless"
podman system info | grep -i subuid
```

### Reset Podman (se problemi persistono)
```bash
podman system reset  # ⚠️ Cancella tutte le immagini/container
podman system migrate
```

### Log dettagliati
```bash
podman build --log-level=debug -t tradeimpact-web .
```

## 🔗 Link Utili

- **Rootless Podman**: https://github.com/containers/podman/blob/main/docs/tutorials/rootless_tutorial.md
- **subuid/subgid**: `man subuid`, `man subgid`
- **User Namespaces**: https://docs.podman.io/en/latest/markdown/podman-run.1.html#userns-mode

## 💡 Best Practice

Per nuovi sistemi, chiedi all'admin di configurare subuid/subgid per tutti gli utenti che useranno Podman:

```bash
# Script admin per configurare nuovo utente
sudo usermod --add-subuids 100000-165535 --add-subgids 100000-165535 USERNAME
```

## ✨ Quick Start Ora

```bash
# Usa build automatico (funziona senza root)
./build-auto.sh

# Attendi 3-5 minuti per il build

# Avvia
podman run -d \
  -p 8080:8080 \
  --name tradeimpact-web \
  -v $(pwd)/data:/app/data:Z \
  tradeimpact-web:latest

# Verifica
podman logs -f tradeimpact-web
```

Apri browser: http://localhost:8080
