package com.example.lottery.service.business;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberGenerator;

@Service
public class SecureRandomNumberGenerator implements RandomNumberGenerator {

	private Random secureRandom = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		return secureRandom.nextInt(min,max);
	}

}
