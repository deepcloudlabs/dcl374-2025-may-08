package com.example.crm.service.business;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.example.crm.event.CrmBaseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CrmEventWebSocketService implements WebSocketHandler {

	private final Map<String,WebSocketSession> sessions = new ConcurrentHashMap<>() ;
	private final ObjectMapper objectMapper;
	
	public CrmEventWebSocketService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.put(session.getId(),session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.err.println("Unexpected message has been received: %s".formatted(message.getPayload()));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.err.println("An error has occured in the session [%s]: %s".formatted(session.getId(),exception.getMessage()));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		sessions.remove(session.getId());
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	@EventListener
	public void publishCrmEventsThroughWS(CrmBaseEvent event) throws JsonProcessingException {
	    var eventAsJson = objectMapper.writeValueAsString(event);
		sessions.forEach((sessionId,session) -> {
			try {
				session.sendMessage(new TextMessage(eventAsJson));
			} catch (IOException e) {
				System.err.println("Error has occured while sending crm event through web socket session [%s]: %s".formatted(sessionId,e.getMessage()));
			}
		});
	}
}
