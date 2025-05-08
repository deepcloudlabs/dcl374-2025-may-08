package com.example.lottery.service.business;

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
	private final RandomNumberGenerator randomNumberGenerator;
	
	public StandardLotteryService(
			@Value("${lotteryMax}") int lotteryMax, 
			@Value("${lotterySize}")int lotterySize, RandomNumberGenerator randomNumberGenerator) {
		this.lotteryMax = lotteryMax;
		this.lotterySize = lotterySize;
		this.randomNumberGenerator = randomNumberGenerator;
	}

	@Override
	public LotteryModel draw() {
		return new LotteryModel(IntStream.generate(() -> randomNumberGenerator.generate(1,lotteryMax))
				        .distinct()
				        .limit(lotterySize)
				        .sorted()
				        .boxed()
				        .toList());
	}

}
