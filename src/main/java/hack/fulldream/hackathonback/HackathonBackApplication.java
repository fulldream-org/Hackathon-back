package hack.fulldream.hackathonback;

import hack.fulldream.hackathonback.configs.RsaKeyProperties;
import hack.fulldream.hackathonback.configs.StorageServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({RsaKeyProperties.class, StorageServiceProperties.class})
public class HackathonBackApplication {

  public static void main(String[] args) {
    SpringApplication.run(HackathonBackApplication.class, args);
  }
}
