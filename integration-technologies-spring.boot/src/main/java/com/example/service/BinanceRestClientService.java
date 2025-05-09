package com.example.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.response.TickerPrice;

@Service
public class BinanceRestClientService {
	private final RestTemplate restTemplate;
	private final String binanceRestApiUrl;
	
	public BinanceRestClientService(
			@Qualifier("bianance") RestTemplate restTemplate, 
			@Value("${binanceRestApiUrl}") String binanceRestApiUrl) {
		this.restTemplate = restTemplate;
		this.binanceRestApiUrl = binanceRestApiUrl;
	}

	@Scheduled(fixedRateString = "${pollingTime}")
	public void callBinanceRestApi() {
		var tickerPrice = restTemplate.getForEntity(binanceRestApiUrl, TickerPrice.class).getBody();
		System.out.println(tickerPrice);
				
	}
}
