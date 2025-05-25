package com.example.crm.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ReactiveWebSocketService implements WebSocketHandler {

    private final Map<String, WebSocketSession> activeSessions = new ConcurrentHashMap<>();
	
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        String sessionId = session.getId();
        activeSessions.put(sessionId, session);

        return session.receive()
            .doOnNext(textMessage -> broadcastMessage(sessionId, "Hello Mars: %s".formatted(textMessage)))
            .doFinally(signalType -> {
                if (signalType == reactor.core.publisher.SignalType.ON_COMPLETE
                        || signalType == reactor.core.publisher.SignalType.CANCEL
                        || signalType == reactor.core.publisher.SignalType.ON_ERROR) {
                    activeSessions.remove(sessionId);
                }
            })
            .then();
    }
	
	public void broadcastMessage(String senderSessionId, String message) {
        WebSocketMessage webSocketMessage = activeSessions.get(senderSessionId).textMessage(message);

        Flux.fromIterable(activeSessions.entrySet())
            //.filter(entry -> !entry.getKey().equals(senderSessionId))
            .parallel()
            .runOn(Schedulers.boundedElastic())
            .flatMap(entry -> entry.getValue().send(Mono.just(webSocketMessage)).onErrorResume(_ -> Mono.empty()))
            .sequential()
            .subscribe();
    }
}
