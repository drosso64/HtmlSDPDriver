package com.mts.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * SDP Configuration Properties
 * 
 * Binds application.yml sdp.* properties to Java objects.
 */
@Configuration
@ConfigurationProperties(prefix = "sdp")
@Data
public class SDPConfigProperties {

    /**
     * Platform Identifier (numeric) - defines which platform this container serves
     */
    private Integer platformId;

    /**
     * Path to market classes JAR file (loaded dynamically at runtime)
     */
    private String marketClassesJar;
    
    /**
     * Market Factory class name (optional - will scan JAR if not specified)
     */
    private String marketFactoryClass;
    
    /**
     * Classes CSV file path - contains: ClassName,ClassId,ServiceId
     */
    private String classesCsv;

    /**
     * Additional JAR paths (comma-separated)
     */
    private String additionalJars;

    /**
     * Enable auto-reload of JAR on file change
     */
    private boolean autoReload = false;

    /**
     * Interval for checking JAR file changes
     */
    private Duration reloadCheckInterval = Duration.ofSeconds(60);

    /**
     * Connection pool configuration
     */
    private ConnectionPool connectionPool = new ConnectionPool();

    /**
     * IPSP configuration
     */
    private Ipsp ipsp = new Ipsp();

    /**
     * Subscription configuration
     */
    private Subscriptions subscriptions = new Subscriptions();

    /**
     * Query configuration
     */
    private Query query = new Query();
    
    /**
     * Database configuration
     */
    private Database database = new Database();

    @Data
    public static class ConnectionPool {
        private int minSize = 2;
        private int maxSize = 10;
        private Duration acquireTimeout = Duration.ofSeconds(10);
        private Duration maxIdleTime = Duration.ofMinutes(5);
        private int maxConnectionsPerService = 5;
        private Duration connectionTimeout = Duration.ofSeconds(30);
        private Duration keepAliveInterval = Duration.ofSeconds(30);
        private Duration reconnectDelay = Duration.ofSeconds(5);
    }

    @Data
    public static class Ipsp {
        private String host;
        private int port = 8800;
        private String username;
        private String password;
        private boolean useSsl = true;
        
        /**
         * SSL certificate configuration
         */
        private Ssl ssl = new Ssl();
        
        /**
         * Get host from system property if set, otherwise from config
         */
        public String getHost() {
            String systemHost = System.getProperty("IPSP_HOST");
            return systemHost != null ? systemHost : host;
        }
        
        /**
         * Get port from system property if set, otherwise from config
         */
        public int getPort() {
            String systemPort = System.getProperty("IPSP_PORT");
            return systemPort != null ? Integer.parseInt(systemPort) : port;
        }
        
        /**
         * Get SSL flag from system property if set, otherwise from config
         */
        public boolean isUseSsl() {
            String systemSsl = System.getProperty("IPSP_SSL");
            return systemSsl != null ? Boolean.parseBoolean(systemSsl) : useSsl;
        }
    }
    
    @Data
    public static class Ssl {
        /**
         * Enable SSL/TLS for IPSP connections
         */
        private boolean enabled = false;
        
        /**
         * PKCS12 (.pfx) file path - contains both key and trust certificates
         * If specified, this takes precedence over keystore/truststore
         */
        private String pfxPath;
        
        /**
         * PKCS12 (.pfx) file password
         */
        private String pfxPassword;
        
        /**
         * Keystore path (JKS format) - contains private key
         * Used only if pfxPath is not specified
         */
        private String keystorePath;
        
        /**
         * Keystore password
         */
        private String keystorePassword;
        
        /**
         * Truststore path (JKS format) - contains trusted CA certificates
         * Used only if pfxPath is not specified
         */
        private String truststorePath;
        
        /**
         * Truststore password
         */
        private String truststorePassword;
    }

    @Data
    public static class Subscriptions {
        private String defaultType = "ONTIME";
        private boolean enablePersistence = true;
        private int batchSize = 100;
    }

    @Data
    public static class Query {
        private int defaultPageSize = 100;
        private int maxPageSize = 1000;
        private Duration resultSetTtl = Duration.ofSeconds(300);
    }
    
    @Data
    public static class Database {
        private int retentionDays = 30;
    }
}
