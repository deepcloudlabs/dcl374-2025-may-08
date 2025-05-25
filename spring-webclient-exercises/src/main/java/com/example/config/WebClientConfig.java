package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Configuration
public class WebClientConfig {
	@Bean
	WebClient webClient(WebClientPoolProperties poolProps) {
        ConnectionProvider provider = ConnectionProvider.builder("custom")
                .maxConnections(poolProps.getMaxConnections())
                .pendingAcquireMaxCount(poolProps.getPendingAcquireMaxCount())
                .pendingAcquireTimeout(poolProps.getPendingAcquireTimeout())
                .build();

        HttpClient httpClient = HttpClient.create(provider);

        return WebClient.builder()
        		.baseUrl("https://api.binance.com/api/v3")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
	}
}
