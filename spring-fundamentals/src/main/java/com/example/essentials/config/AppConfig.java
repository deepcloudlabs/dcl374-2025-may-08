package com.example.essentials.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.essentials.service.MovieService;
import com.example.essentials.service.SequenceService;
import com.example.essentials.service.business.InMemoryMovieService;

@Configuration
public class AppConfig {

	@Bean(initMethod = "populate")
	MovieService createMovieService(SequenceService sequenceSrv) {
		return new InMemoryMovieService(sequenceSrv);
	}
}
