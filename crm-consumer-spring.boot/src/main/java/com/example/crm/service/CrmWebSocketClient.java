package com.example.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import jakarta.annotation.PostConstruct;

@Service
public class CrmWebSocketClient implements WebSocketHandler{
	private final WebSocketClient webSocketClient;

	public CrmWebSocketClient(WebSocketClient webSocketClient) {
		this.webSocketClient = webSocketClient;
	}

	@PostConstruct
	public void connectToWebSocketServer() {
		System.err.println("Trying to connect to the server..."); 
		this.webSocketClient.execute(this, "ws://localhost:6100/crm/api/v1/crm-events");
	}
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.err.println("Successfully connected to the server.");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.err.println("New event has arrived from ws endpoint: %s".formatted(message.getPayload()));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
