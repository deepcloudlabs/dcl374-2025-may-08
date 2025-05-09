package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import jakarta.annotation.PostConstruct;

@Service
public class BinanceWebSocketClientService implements WebSocketHandler{
	private final WebSocketClient webSocketClient;
	private final String binanceWsUrl;
	
	
	public BinanceWebSocketClientService(WebSocketClient webSocketClient, @Value("${binanceWsUrl}") String binanceWsUrl) {
		this.webSocketClient = webSocketClient;
		this.binanceWsUrl = binanceWsUrl;
	}

	@PostConstruct
	public void handshakeWithWSServer() {
		webSocketClient.execute(this, binanceWsUrl);
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.err.println("Successfuly connected to the binance server.");
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.err.println("New message has arrrived: %s".formatted(message.getPayload()));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.err.println("An error has occured: %s".formatted(exception.getMessage()));		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.err.println("Disconnected to the binance server.");
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}
