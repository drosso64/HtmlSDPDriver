package com.mts.gateway.security;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class SecurityServerConfig {

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

        boolean enabled = Boolean.parseBoolean(Optional.ofNullable(System.getenv("SERVER_SSL_ENABLED")).orElse("false"));
        if (!enabled) {
            return tomcat;
        }

        int httpsPort = Integer.parseInt(Optional.ofNullable(System.getenv("SERVER_SSL_PORT")).orElse("8443"));

        String pfx = System.getenv("SERVER_SSL_PFX_PATH");
        String pfxPass = System.getenv("SERVER_SSL_PFX_PASSWORD");
        String keystore = System.getenv("SERVER_SSL_KEYSTORE_PATH");
        String keystorePass = System.getenv("SERVER_SSL_KEYSTORE_PASSWORD");
        String truststore = System.getenv("SERVER_SSL_TRUSTSTORE_PATH");
        String truststorePass = System.getenv("SERVER_SSL_TRUSTSTORE_PASSWORD");
        String clientAuth = Optional.ofNullable(System.getenv("SERVER_SSL_CLIENT_AUTH")).orElse("false");

        // Prefer to rely on Spring Boot's built-in `server.ssl.*` properties.
        // Set system properties so the auto-configured embedded server picks them up.
        System.setProperty("server.port", String.valueOf(httpsPort));

        if (pfx != null && !pfx.isBlank()) {
            System.setProperty("server.ssl.key-store", pfx);
            if (pfxPass != null) System.setProperty("server.ssl.key-store-password", pfxPass);
            System.setProperty("server.ssl.key-store-type", "PKCS12");
        } else if (keystore != null && !keystore.isBlank()) {
            System.setProperty("server.ssl.key-store", keystore);
            if (keystorePass != null) System.setProperty("server.ssl.key-store-password", keystorePass);
            System.setProperty("server.ssl.key-store-type", "JKS");
            if (truststore != null && !truststore.isBlank()) {
                System.setProperty("server.ssl.trust-store", truststore);
                if (truststorePass != null) System.setProperty("server.ssl.trust-store-password", truststorePass);
            }
        }

        // Map clientAuth values: 'need' -> need, 'want' -> want, anything else -> none
        String clientAuthProp = "none";
        if ("need".equalsIgnoreCase(clientAuth)) clientAuthProp = "need";
        else if ("want".equalsIgnoreCase(clientAuth)) clientAuthProp = "want";
        System.setProperty("server.ssl.client-auth", clientAuthProp);
        return tomcat;
    }
}
