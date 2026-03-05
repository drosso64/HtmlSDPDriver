package com.mts.gateway.ssl;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

/**
 * SSL Context Factory - creates SSLContext from various certificate formats
 * 
 * Supports two configuration modes:
 * 1. PKCS12 (.pfx) - single file containing both key and trust certificates
 * 2. Keystore/Truststore - separate files for key and trust certificates
 */
@Slf4j
public class SSLContextFactory {
    
    /**
     * SSL Configuration holder
     */
    public static class SslConfig {
        private boolean enabled = false;
        
        // PKCS12 (.pfx) configuration
        private String pfxPath;
        private String pfxPassword;
        
        // Keystore/Truststore configuration
        private String keystorePath;
        private String keystorePassword;
        private String truststorePath;
        private String truststorePassword;
        
        // Getters and setters
        public boolean isEnabled() {
            return enabled;
        }
        
        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
        
        public String getPfxPath() {
            return pfxPath;
        }
        
        public void setPfxPath(String pfxPath) {
            this.pfxPath = pfxPath;
        }
        
        public String getPfxPassword() {
            return pfxPassword;
        }
        
        public void setPfxPassword(String pfxPassword) {
            this.pfxPassword = pfxPassword;
        }
        
        public String getKeystorePath() {
            return keystorePath;
        }
        
        public void setKeystorePath(String keystorePath) {
            this.keystorePath = keystorePath;
        }
        
        public String getKeystorePassword() {
            return keystorePassword;
        }
        
        public void setKeystorePassword(String keystorePassword) {
            this.keystorePassword = keystorePassword;
        }
        
        public String getTruststorePath() {
            return truststorePath;
        }
        
        public void setTruststorePath(String truststorePath) {
            this.truststorePath = truststorePath;
        }
        
        public String getTruststorePassword() {
            return truststorePassword;
        }
        
        public void setTruststorePassword(String truststorePassword) {
            this.truststorePassword = truststorePassword;
        }
        
        /**
         * Determine if PKCS12 mode is configured
         */
        public boolean isPkcs12Mode() {
            return pfxPath != null && !pfxPath.isEmpty();
        }
        
        /**
         * Determine if keystore/truststore mode is configured
         */
        public boolean isKeystoreMode() {
            return keystorePath != null && !keystorePath.isEmpty();
        }
    }
    
    /**
     * Create SSLContext from configuration
     * 
     * @param config SSL configuration
     * @return SSLContext configured with certificates, or null if SSL not enabled
     * @throws Exception if SSL is enabled but configuration is invalid
     */
    public static SSLContext createSSLContext(SslConfig config) throws Exception {
        if (!config.isEnabled()) {
            log.debug("SSL is disabled");
            return null;
        }
        
        log.info("Creating SSLContext...");
        
        // Determine configuration mode
        if (config.isPkcs12Mode()) {
            return createFromPkcs12(config);
        } else if (config.isKeystoreMode()) {
            return createFromKeystoreTruststore(config);
        } else {
            throw new IllegalArgumentException(
                "SSL is enabled but no certificate configuration provided. " +
                "Either provide pfx-path or keystore-path/truststore-path");
        }
    }
    
    /**
     * Create SSLContext from PKCS12 (.pfx) file
     * 
     * PKCS12 format contains both private key and trust certificates in one file.
     * This is simpler to manage and commonly used in enterprise environments.
     */
    private static SSLContext createFromPkcs12(SslConfig config) throws Exception {
        log.info("Creating SSLContext from PKCS12 file: {}", config.getPfxPath());
        
        // Load PKCS12 keystore (contains both key and trust)
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        char[] password = config.getPfxPassword() != null 
            ? config.getPfxPassword().toCharArray() 
            : null;
        
        try (InputStream is = new FileInputStream(config.getPfxPath())) {
            keyStore.load(is, password);
            log.debug("PKCS12 keystore loaded successfully with {} entries", 
                keyStore.size());
        }
        
        // Initialize KeyManager from PKCS12
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(
            KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, password);
        KeyManager[] keyManagers = kmf.getKeyManagers();
        log.debug("KeyManager initialized with {} key managers", keyManagers.length);
        
        // Use same keystore for trust (PKCS12 can contain trust certs)
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(
            TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);
        TrustManager[] trustManagers = tmf.getTrustManagers();
        log.debug("TrustManager initialized with {} trust managers", trustManagers.length);
        
        // Create SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, trustManagers, null);
        
        log.info("✓ SSLContext created successfully from PKCS12");
        return sslContext;
    }
    
    /**
     * Create SSLContext from separate keystore and truststore files
     * 
     * Keystore contains the private key, truststore contains trusted CA certificates.
     * This is the traditional Java approach.
     */
    private static SSLContext createFromKeystoreTruststore(SslConfig config) throws Exception {
        log.info("Creating SSLContext from keystore/truststore:");
        log.info("  Keystore: {}", config.getKeystorePath());
        log.info("  Truststore: {}", config.getTruststorePath());
        
        // Load keystore (private key)
        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] keystorePassword = config.getKeystorePassword() != null 
            ? config.getKeystorePassword().toCharArray() 
            : null;
        
        try (InputStream is = new FileInputStream(config.getKeystorePath())) {
            keyStore.load(is, keystorePassword);
            log.debug("Keystore loaded successfully with {} entries", keyStore.size());
        }
        
        // Initialize KeyManager
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(
            KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, keystorePassword);
        KeyManager[] keyManagers = kmf.getKeyManagers();
        log.debug("KeyManager initialized with {} key managers", keyManagers.length);
        
        // Load truststore (trusted certificates)
        TrustManager[] trustManagers = null;
        if (config.getTruststorePath() != null && !config.getTruststorePath().isEmpty()) {
            KeyStore trustStore = KeyStore.getInstance("JKS");
            char[] truststorePassword = config.getTruststorePassword() != null 
                ? config.getTruststorePassword().toCharArray() 
                : null;
            
            try (InputStream is = new FileInputStream(config.getTruststorePath())) {
                trustStore.load(is, truststorePassword);
                log.debug("Truststore loaded successfully with {} entries", trustStore.size());
            }
            
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            trustManagers = tmf.getTrustManagers();
            log.debug("TrustManager initialized with {} trust managers", trustManagers.length);
        } else {
            log.info("No truststore specified, using default trust manager");
        }
        
        // Create SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, trustManagers, null);
        
        log.info("✓ SSLContext created successfully from keystore/truststore");
        return sslContext;
    }
}
