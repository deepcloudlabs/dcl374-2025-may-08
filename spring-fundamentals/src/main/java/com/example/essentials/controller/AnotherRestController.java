package com.example.essentials.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.essentials.domain.Genre;
import com.example.essentials.service.MovieService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

@RestController
@Lazy
@RequestMapping("/samples")
public class AnotherRestController {
    // @Autowired
	//@Inject
	@Resource
	private MovieService movieService;
	@Autowired
	private ConfigurableApplicationContext applicationContext;
	
	@PostConstruct
	public void init() {
	   for (var beanName : applicationContext.getBeanDefinitionNames()) {
		   var definition = applicationContext.getBeanFactory().getBeanDefinition(beanName);
		   System.out.println("init(): %s, %s, %s".formatted(beanName,definition.getScope(),definition.getInitMethodName()));
	   }	
	}
	
	@GetMapping("/genres")
	public Collection<Genre> getAllGenres(){
		return movieService.findAllGenres();
	}
}
