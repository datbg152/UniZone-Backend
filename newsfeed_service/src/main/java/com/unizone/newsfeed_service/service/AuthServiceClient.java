package com.unizone.newsfeed_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;

@Service
public class AuthServiceClient {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public AuthServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String verifyToken(String token) {
        String authServiceUrl = "http://localhost:8081/auth/verify-token"; // URL to auth_service
        WebClient webClient = webClientBuilder.baseUrl(authServiceUrl).build();

        return webClient.post()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class)  // Asynchronously retrieve userId
                .block();  // blocking for simplicity, can be reactive if needed
    }
}
