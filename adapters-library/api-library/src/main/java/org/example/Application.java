package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableMapRepositories(basePackages = "org.example.persistence")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
