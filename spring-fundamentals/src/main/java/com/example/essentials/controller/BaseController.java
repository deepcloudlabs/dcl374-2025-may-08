package com.example.essentials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.essentials.service.SequenceService;

import jakarta.annotation.PostConstruct;

@Component
public abstract class BaseController {
	@Autowired
	private SequenceService sequenceService;

	
	public BaseController() {
		System.out.println("BaseController()");
	}


	@PostConstruct
	public void ilklendir3() {
		System.out.println("ilklendir3()");
		System.out.println(sequenceService);
	}
}
