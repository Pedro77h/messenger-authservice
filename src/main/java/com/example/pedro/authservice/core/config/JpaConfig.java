package com.example.pedro.authservice.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.pedro.authservice.domain.repositories")
@EnableAutoConfiguration
public class JpaConfig {

}
