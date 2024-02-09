package hack.fulldream.hackathonback.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public record StorageServiceProperties(String path) {
}
