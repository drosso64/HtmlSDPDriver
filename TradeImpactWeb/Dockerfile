# Multi-stage build per TradeImpact Web Application

# Argomenti per proxy aziendale
ARG HTTP_PROXY
ARG HTTPS_PROXY
ARG NO_PROXY

# Stage 1: Build Frontend con Node.js
FROM node:18-alpine AS frontend-builder

# Configura proxy per npm
ARG HTTP_PROXY
ARG HTTPS_PROXY
ARG NO_PROXY
ENV HTTP_PROXY=${HTTP_PROXY} \
    HTTPS_PROXY=${HTTPS_PROXY} \
    NO_PROXY=${NO_PROXY} \
    http_proxy=${HTTP_PROXY} \
    https_proxy=${HTTPS_PROXY} \
    no_proxy=${NO_PROXY}

WORKDIR /app/frontend

# Copia package.json e installa dipendenze (serve anche dev per vite)
COPY frontend/package*.json ./
RUN npm install

# Copia sorgenti frontend
COPY frontend/ ./

# Modifica vite.config per generare in dist (non in ../src/main/resources/static)
RUN sed -i "s|outDir: '../src/main/resources/static'|outDir: 'dist'|g" vite.config.js

# Build frontend (output in dist/)
RUN npm run build

# Stage 2: Build Backend con Maven
FROM maven:3.9-eclipse-temurin-17 AS backend-builder

# Configura proxy per Maven
ARG HTTP_PROXY
ARG HTTPS_PROXY
ARG NO_PROXY
ENV HTTP_PROXY=${HTTP_PROXY} \
    HTTPS_PROXY=${HTTPS_PROXY} \
    NO_PROXY=${NO_PROXY} \
    http_proxy=${HTTP_PROXY} \
    https_proxy=${HTTPS_PROXY} \
    no_proxy=${NO_PROXY}

WORKDIR /app

# Importa certificato Artifactory nel truststore Java
COPY artifactory-cert.pem /tmp/artifactory-cert.pem
RUN keytool -import -trustcacerts -alias artifactory \
    -file /tmp/artifactory-cert.pem \
    -keystore $JAVA_HOME/lib/security/cacerts \
    -storepass changeit -noprompt && \
    rm /tmp/artifactory-cert.pem

# Copia configurazione Maven aziendale (Artifactory)
COPY settings.xml /root/.m2/settings.xml
COPY settings-security.xml /root/.m2/settings-security.xml

# Copia pom.xml e scarica dipendenze (cache layer)
COPY pom.xml ./
COPY libs/ ./libs/
RUN mvn dependency:go-offline -B

# Copia sorgenti backend
COPY src/ ./src/

# Copia frontend buildato in resources/static
COPY --from=frontend-builder /app/frontend/dist ./src/main/resources/static/

# Build JAR (skip tests per velocità)
RUN mvn clean package -DskipTests

# Stage 3: Runtime con JRE minimale
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Importa certificato Artifactory anche nel runtime
COPY artifactory-cert.pem /tmp/artifactory-cert.pem
RUN keytool -import -trustcacerts -alias artifactory \
    -file /tmp/artifactory-cert.pem \
    -keystore $JAVA_HOME/lib/security/cacerts \
    -storepass changeit -noprompt && \
    rm /tmp/artifactory-cert.pem

# Crea directory per database H2
RUN mkdir -p /app/data

# Copia JAR dal builder
COPY --from=backend-builder /app/target/*.jar /app/app.jar

# Copia libs SDP (necessarie a runtime)
COPY libs/ /app/libs/

# Esponi porta
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/actuator/health || exit 1

# User non-root per sicurezza
RUN addgroup -g 1000 appuser && \
    adduser -D -u 1000 -G appuser appuser && \
    chown -R appuser:appuser /app && \
    chmod -R 755 /app/data
USER appuser

# Variabili ambiente di default
ENV JAVA_OPTS="-Xmx512m -Xms256m"
ENV SERVER_PORT=8080

# Entrypoint
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
