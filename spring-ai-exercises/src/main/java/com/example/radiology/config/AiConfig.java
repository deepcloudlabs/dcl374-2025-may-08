package com.example.radiology.config;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
	@Value("${ollama.api.url:http://localhost:11434}")
    private String ollamaApiUrl;

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder.build() ;
    }
}
