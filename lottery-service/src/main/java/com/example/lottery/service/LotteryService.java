package com.example.lottery.service;

import java.util.List;
import java.util.stream.IntStream;

import com.example.lottery.dto.response.LotteryModel;

public interface LotteryService {

	LotteryModel draw();

	default List<LotteryModel> draw(int column){
		return IntStream.range(0, column)
				.mapToObj( _ -> draw())
				.toList();
	}

}
