package com.example.radiology.service.business;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import com.example.radiology.dto.request.GenerateAnamnesisRequest;
import com.example.radiology.dto.response.GenerateAnamnesisResponse;
import com.example.radiology.service.AnamnesisGanService;

@Service
public class StandardAnamnesisGanService implements AnamnesisGanService {
	private final String PROMPT_TEXT_TEMPLATE = """
			create a detailed anamnesis of type %s that can be detected using %s imaging in json format
			using HL7 FHIR json schema.
			Add birth date, gender, address, condition, radiology findings, lab results, medications, follow ups, and symptoms
			""";
	private final ChatClient chatClient;

	public StandardAnamnesisGanService(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@Override
	public GenerateAnamnesisResponse generateAnemnesis(GenerateAnamnesisRequest request) {
		var chatResponse = chatClient.prompt(new Prompt(
				PROMPT_TEXT_TEMPLATE.formatted(request.abnormalityType().name(), request.medicalImagingType().name())))
				.call().chatResponse();
		return new GenerateAnamnesisResponse(chatResponse.getResults().get(0).getOutput().getText().split("```")[1]);
	}

}
