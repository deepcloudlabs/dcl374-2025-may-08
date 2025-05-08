package com.example.essentials.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.example.essentials.service.MovieService;
import com.example.essentials.service.SequenceService;
import com.example.essentials.service.business.InMemoryMovieService;

@Configuration
public class AppConfig {

	@Bean(initMethod = "populate",name = "myComponent")
	@Scope("singleton")
	@Lazy
	MovieService createMovieService(SequenceService sequenceSrv) {
		System.out.println("createMovieService(SequenceService sequenceSrv) is running...");
		return new InMemoryMovieService(sequenceSrv);
	}
}
