package com.example.lottery.service.business;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberGenerator;

@Service
//@ServiceQuality(QualityLevel.SECURE)
//@ConditionalOnProperty(value="serviceQuality", havingValue = "secure")
@Profile({"prod","preprod"})
public class SecureRandomNumberGenerator implements RandomNumberGenerator {

	private Random secureRandom = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		System.err.println("SecureRandomNumberGenerator::generate");
		return secureRandom.nextInt(min,max);
	}

}
