package com.example.pedro.authservice.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.pedro.authservice.domain.repositories")
public class JpaConfig {

}
