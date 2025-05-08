package com.example.essentials.controller;

import com.example.essentials.service.SequenceService;

import jakarta.annotation.PostConstruct;

public abstract class BaseController {
	
	private final SequenceService sequenceService;

	
	public BaseController(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
		System.out.println("BaseController(SequenceService sequenceService)");
	}


	@PostConstruct
	public void ilklendir3() {
		System.out.println("ilklendir3()");
		System.out.println(sequenceService);
	}
}
