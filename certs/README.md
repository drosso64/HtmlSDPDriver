This folder contains scripts to generate development TLS and mTLS test certificates and keystores.

Usage:

```bash
# generate server keystore and a test client cert
bash generate-dev-certs.sh

# start the application with the generated keystores (example)
export SERVER_KEYSTORE_PATH=certs/server-keystore.p12
export SERVER_KEYSTORE_PASSWORD=changeit
export SERVER_TRUSTSTORE_PATH=certs/server-truststore.jks
export SERVER_TRUSTSTORE_PASSWORD=changeit
mvn -pl TradeImpactWeb spring-boot:run -Dspring-boot.run.profiles=proxy
```

Test connections with mTLS client keystore:

```bash
curl --insecure --cert-type P12 --cert certs/client1-keystore.p12:changeit https://localhost:8443/api/status
```
