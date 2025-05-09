package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class RestConfig {

	@Bean
	@Qualifier("bianance")
	RestTemplate createRestTemplateForBinance() {
		return new RestTemplate();
	}
}
