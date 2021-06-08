package ro.ubb.monitorweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ro.ubb")
@EnableJpaRepositories("ro.ubb.monitorcore.repository")
@EntityScan("ro.ubb.monitorcore.model")
public class MonitorWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorWebApplication.class, args);
    }

}
