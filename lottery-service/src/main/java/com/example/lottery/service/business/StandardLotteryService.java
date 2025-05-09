package com.example.lottery.service.business;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.lottery.dto.response.LotteryModel;
import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberGenerator;

@Service
public class StandardLotteryService implements LotteryService {

	private final int lotteryMax;
	private final int lotterySize;
	private final List<RandomNumberGenerator> randomNumberGenerators;
	private final Map<String,RandomNumberGenerator> randomNumberGeneratorsMap;
	private static final AtomicInteger counter = new AtomicInteger(0);
	
	public StandardLotteryService(
			@Value("${lotteryMax}") int lotteryMax, 
			@Value("${lotterySize}")int lotterySize, 
			//@ServiceQuality(QualityLevel.FAST) 
			List<RandomNumberGenerator> randomNumberGenerators, Map<String, RandomNumberGenerator> randomNumberGeneratorsMap) {			 
		this.lotteryMax = lotteryMax;
		this.lotterySize = lotterySize;
		this.randomNumberGenerators = randomNumberGenerators;
		this.randomNumberGeneratorsMap = randomNumberGeneratorsMap;
		randomNumberGeneratorsMap.forEach((name,component)->System.out.println("%s: %s".formatted(name,component.getClass().getName())));
	}

	@Override
	public LotteryModel draw() {
		var randomNumberGenerator = randomNumberGenerators.get(counter.getAndIncrement() % randomNumberGenerators.size());
		return new LotteryModel(IntStream.generate(() -> randomNumberGenerator.generate(1,lotteryMax))
				        .distinct()
				        .limit(lotterySize)
				        .sorted()
				        .boxed()
				        .toList());
	}

}
