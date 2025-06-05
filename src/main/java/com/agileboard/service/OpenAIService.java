package com.agileboard.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.openai.com/v1/chat/completions")
            .defaultHeader("Authorization", "Bearer " + openAiApiKey) // O usa la variable
            .defaultHeader("Content-Type", "application/json")
            .build();

    public Mono<String> generarIdeas(List<String> productBacklog) {
        String prompt = """
            Basado en el siguiente Product Backlog:
            %s
            Genera una lista de ideas para el Sprint Backlog (5 historias de usuario tipo "Como usuario quiero... para...").
            """.formatted(String.join("\n", productBacklog));

        String requestBody = """
            {
              "model": "gpt-3.5-turbo",
              "messages": [{"role": "user", "content": "%s"}],
              "temperature": 0.7
            }
            """.formatted(prompt);

        return webClient.post()
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);
    }
}
