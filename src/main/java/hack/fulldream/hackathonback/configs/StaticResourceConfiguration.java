package hack.fulldream.hackathonback.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.MalformedURLException;
import java.nio.file.Paths;

@Configuration
@RequiredArgsConstructor
public class StaticResourceConfiguration implements WebMvcConfigurer {
    private final StorageServiceProperties storageServiceProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        try {
            String path = Paths.get(storageServiceProperties.path()).toAbsolutePath().toUri().toURL().toString();
            registry.addResourceHandler("/res/**")
                    .addResourceLocations(path);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}