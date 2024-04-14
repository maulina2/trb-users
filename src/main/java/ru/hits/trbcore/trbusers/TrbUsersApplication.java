package ru.hits.trbcore.trbusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.hits.trbcore.trbusers.config.RandomErrorProperties;

@SpringBootApplication
@EnableConfigurationProperties(RandomErrorProperties.class)
public class TrbUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrbUsersApplication.class, args);
    }

}
