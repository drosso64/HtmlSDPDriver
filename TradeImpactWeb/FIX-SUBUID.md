# 🚨 FIX Urgente - Errore subuid/subgid

## Il Problema

Podman rootless **NON PUÒ** funzionare senza configurazione subuid/subgid. L'errore è inevitabile:

```
cannot find UID/GID for user drosso: no subuid ranges found
```

## ✅ SOLUZIONE 1: Chiedi all'Admin (RACCOMANDATO)

Contatta l'amministratore di sistema e chiedi di eseguire:

```bash
# Come root/admin:
sudo usermod --add-subuids 100000-165535 --add-subgids 100000-165535 drosso
sudo usermod --add-subgids 100000-165535 drosso

# Verifica
grep drosso /etc/subuid /etc/subgid
# Deve mostrare:
# /etc/subuid:drosso:100000:65536  
# /etc/subgid:drosso:100000:65536

# Poi come utente drosso:
podman system migrate
```

**Dopo questa configurazione (UNA VOLTA):**
```bash
./docker-build.sh  # Funzionerà!
```

## ✅ SOLUZIONE 2: Build con sudo (TEMPORANEO)

Se hai accesso sudo:

```bash
chmod +x build-with-sudo.sh
./build-with-sudo.sh
```

Questo script:
1. Fa build con `sudo podman`
2. Esporta l'immagine per il tuo utente
3. L'immagine sarà utilizzabile senza sudo

## ✅ SOLUZIONE 3: Build Manuale Locale (SENZA DOCKER)

Se nessuna delle precedenti funziona, puoi compilare localmente:

### Prerequisiti
```bash
# Verifica Java e Maven
java -version   # Serve Java 17+
mvn -version    # Serve Maven 3.6+
```

### Build Frontend + Backend

```bash
# 1. Installa Node.js localmente (se non disponibile, chiedi admin)
# O usa nvm (Node Version Manager) senza root:
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
source ~/.bashrc
nvm install 18
nvm use 18

# 2. Build frontend
cd frontend
npm install
npm run build

# 3. Build backend (include frontend)
cd ..
mvn clean package

# 4. Run applicazione
java -jar target/TradeImpactWeb-0.0.1-SNAPSHOT.jar

# Accedi: http://localhost:8080
```

## 🔍 Verifica Configurazione

```bash
# Check subuid/subgid
cat /etc/subuid | grep $USER
cat /etc/subgid | grep $USER

# Se vuoti → Servono permessi admin
# Se popolati → Fai: podman system migrate
```

## 📋 Riepilogo Opzioni

| Metodo | Pro | Contro | Tempo |
|--------|-----|--------|-------|
| **1. Admin configura subuid** | Permanente, migliore | Richiede admin | 1 min (admin) |
| **2. Build con sudo** | Funziona subito | Serve sudo | 5 min |
| **3. Build locale (no Docker)** | No Docker needed | Serve Node.js locale | 10 min |

## 🎯 Raccomandazione

**MIGLIORE**: Chiedi all'admin di eseguire:
```bash
sudo usermod --add-subuids 100000-165535 --add-subgids 100000-165535 drosso
```

È una configurazione di 30 secondi che risolve definitivamente il problema.

## 📞 Template Email per Admin

```
Oggetto: Configurazione subuid/subgid per Podman rootless

Ciao,

ho bisogno di usare Podman in modalità rootless per il progetto TradeImpact.
Potresti eseguire questi comandi come root?

  sudo usermod --add-subuids 100000-165535 --add-subgids 100000-165535 drosso

Grazie!
```

## 🚀 Dopo la Configurazione

Una volta configurato subuid/subgid:

```bash
podman system migrate
./docker-build.sh
docker-compose up -d
```

Tutto funzionerà perfettamente! 🎉
