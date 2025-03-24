package com.example.foroPyC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // Crear un bean de WebClient que será inyectado en otros componentes
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}