package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.CalculationRequest;
import com.example.service.Calculator;

@RestController
@RequestMapping("/apply")
public class CalculatorRestController {

	private final Calculator calculator;

	public CalculatorRestController(Calculator calculator) {
		this.calculator = calculator;
		System.out.println(calculator.getClass());
	}
	
	@PostMapping
	public double calculate(@RequestBody CalculationRequest request) {
		return switch (request.op()) {
		case "+": {
			yield calculator.add(request.x(), request.y());
		}
		case "-": {
			yield calculator.sub(request.x(), request.y());
		}
		case "*": {
			yield calculator.mul(request.x(), request.y());
		}
		case "/": {
			yield calculator.div(request.x(), request.y());
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + request.op());
		};
	}
}
