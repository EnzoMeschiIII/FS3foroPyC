package com.example.foroPyC.service;

import com.example.foroPyC.DTO.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class UsuarioService {

    private final WebClient webClient;

    public UsuarioService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080")  // URL del microservicio de Usuario
                                        .build();
    }

    public UsuarioDTO obtenerUsuario(Long id) {
        try {
            return webClient.get()
                            .uri("/usuarios/{id}", id)
                            .retrieve()
                            .bodyToMono(UsuarioDTO.class)
                            .block();
        } catch (WebClientResponseException e) {
            // Maneja el error si no se encuentra el usuario
            return null;
        }
    }
}
