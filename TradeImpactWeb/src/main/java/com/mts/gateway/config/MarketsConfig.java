package com.mts.gateway.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
@Slf4j
public class MarketsConfig {

    private final List<Market> markets = new ArrayList<>();
    private final List<Ipsp> ipsps = new ArrayList<>();

    @PostConstruct
    public void load() {
        try {
            FileSystemResource res = new FileSystemResource("config/markets.yml");
            if (!res.exists()) {
                log.warn("config/markets.yml not found - no markets loaded");
                return;
            }

            YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
            yaml.setResources(res);
            Properties props = yaml.getObject();

            if (props == null) {
                log.warn("No properties parsed from config/markets.yml");
                return;
            }

            // Parse markets list: markets[0].id, markets[0].name
            for (int i = 0; ; i++) {
                String base = String.format("markets[%d].id", i);
                String id = props.getProperty(base);
                if (id == null) break;
                String name = props.getProperty(String.format("markets[%d].name", i));
                markets.add(new Market(id.trim(), name != null ? name.trim() : id.trim()));
            }

            // Parse ipsps
            for (int i = 0; ; i++) {
                String base = String.format("ipsps[%d].host", i);
                String host = props.getProperty(base);
                if (host == null) break;
                String portS = props.getProperty(String.format("ipsps[%d].port", i));
                String sslS = props.getProperty(String.format("ipsps[%d].ssl", i));
                int port = portS != null ? Integer.parseInt(portS) : 8800;
                boolean ssl = sslS != null && Boolean.parseBoolean(sslS);
                ipsps.add(new Ipsp(host.trim(), port, ssl));
            }

            log.info("Loaded {} markets and {} IPSP entries from config/markets.yml", markets.size(), ipsps.size());

        } catch (Exception e) {
            log.error("Failed to load config/markets.yml", e);
        }
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public List<Ipsp> getIpsps() {
        return ipsps;
    }

    @Data
    public static class Market {
        private final String id;
        private final String name;
    }

    @Data
    public static class Ipsp {
        private final String host;
        private final int port;
        private final boolean ssl;
    }
}
