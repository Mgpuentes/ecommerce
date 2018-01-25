package com.code4life.ecommerce.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.code4life.ecommerce.repositories")
@EntityScan(basePackages = "com.code4life.ecommerce.model")
public class ApplicationConfig {
}
