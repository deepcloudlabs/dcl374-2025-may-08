package com.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dto.Ticker;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ReactiveBinanceClient {
	private final WebClient webClient;

	public ReactiveBinanceClient(WebClient webClient) {
		this.webClient = webClient;
	}

	@Scheduled(fixedRate = 30_000)
	public void callBinanceRestAPI() {
		getTickers()
		    .take(100)
		    .parallel()
		    .runOn(Schedulers.boundedElastic())
		    .map(ticker -> ticker.symbol())
		    .flatMap(this::getTicker)
			.subscribe(System.err::println);
	}

	public Mono<Ticker> getTicker(String symbol) {
		return webClient.get()
		 		 .uri(uriBuilder -> uriBuilder.path("/ticker/price").queryParam("symbol", symbol).build() )
		        .retrieve()
		        .bodyToMono(Ticker.class);
	}
	
	public Flux<Ticker> getTickers() {
		return webClient.get()
		 		 .uri(uriBuilder -> uriBuilder.path("/ticker/price").build() )
		        .retrieve()
		        .bodyToFlux(Ticker.class);
	}
}
