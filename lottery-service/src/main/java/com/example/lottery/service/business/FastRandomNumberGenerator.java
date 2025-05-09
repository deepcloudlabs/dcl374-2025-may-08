package com.example.lottery.service.business;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberGenerator;

@Service
//@ServiceQuality(QualityLevel.FAST)
//@ConditionalOnProperty(value = "serviceQuality", havingValue = "fast")
@Profile({"test","dev","default"})
public class FastRandomNumberGenerator implements RandomNumberGenerator {

	@Override
	public int generate(int min, int max) {
		System.err.println("FastRandomNumberGenerator::generate");
		return ThreadLocalRandom.current().nextInt(min,max);
	}

}
