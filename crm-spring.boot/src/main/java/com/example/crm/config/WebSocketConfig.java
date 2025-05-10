package com.example.crm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.crm.service.business.CrmEventWebSocketService;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{
	private final CrmEventWebSocketService crmEventWebSocketService;
	
	public WebSocketConfig(CrmEventWebSocketService crmEventWebSocketService) {
		this.crmEventWebSocketService = crmEventWebSocketService;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(crmEventWebSocketService, "/crm-events")
		        .setAllowedOrigins("*")
		        .withSockJS();
	}

}
