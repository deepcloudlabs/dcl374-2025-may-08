package com.example.service;

import java.net.URI;
import java.time.Duration;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

@Service
public class ReactiveWebSocketClientService {
    private final ReactorNettyWebSocketClient client = new ReactorNettyWebSocketClient();

    @PostConstruct
    public void connect() {
        URI uri = URI.create("ws://localhost:3300/ws/events"); 
        System.out.println("Connecting ws server....");

        client.execute(uri, session -> {
        	System.out.println("Connected....");
            Mono<Void> send = session.send(Mono.just(session.textMessage("Hello from Spring Boot WebSocket client")));

            // Handle incoming messages
            Mono<Void> receive = session.receive()
                    .doOnNext(message -> {
                        String text = message.getPayloadAsText();
                        System.out.println("Received: " + text);
                    })
                    .then();

            return send.then(receive);
        }).block(Duration.ofHours(24)); 
    }

}
