package com.code4life.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/.ecommerce/application-prod.properties")
public class ProdConfig {
}
