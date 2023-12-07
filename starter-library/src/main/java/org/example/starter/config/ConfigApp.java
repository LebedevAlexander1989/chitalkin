package org.example.starter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@Configuration
@EnableMapRepositories(basePackages = "org.example.persistence")
@ComponentScan(basePackages = {"org.example.api", "org.example.core"})
public class ConfigApp {
}
