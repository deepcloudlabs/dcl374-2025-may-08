package com.example.radiology.service;

import com.example.radiology.dto.request.GenerateAnamnesisRequest;
import com.example.radiology.dto.response.GenerateAnamnesisResponse;

public interface AnamnesisGanService {
	GenerateAnamnesisResponse generateAnemnesis(GenerateAnamnesisRequest request);
}	
