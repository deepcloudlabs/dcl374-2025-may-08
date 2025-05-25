package com.example.crm.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import com.example.crm.service.ReactiveWebSocketService;

@Configuration
public class WebSocketConfig {

	private final ReactiveWebSocketService reactiveWebSocketService;

	public WebSocketConfig(ReactiveWebSocketService reactiveWebSocketService) {
		this.reactiveWebSocketService = reactiveWebSocketService;
	}

	@Bean
	HandlerMapping handlerMapping() {
		Map<String, WebSocketHandler> urlMap = new HashMap<>();
		urlMap.put("/ws/events", reactiveWebSocketService);

		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setOrder(-1);
		mapping.setUrlMap(urlMap);
		return mapping;
	}

	@Bean
	WebSocketHandlerAdapter handlerAdapter() {
		return new WebSocketHandlerAdapter();
	}
}
