package com.example.radiology.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.radiology.dto.request.GenerateAnamnesisRequest;
import com.example.radiology.dto.response.GenerateAnamnesisResponse;
import com.example.radiology.service.AnamnesisGanService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/anamnesis")
@Validated
@CrossOrigin
@OpenAPIDefinition(
		info = @Info(title = "Anamnesis GAN Service Rest API", contact = @Contact(name = "Binnur Kurt", email = "binnur.kurt@deepcloudlabs.com",url = "https://www.deepcloudlabs.com")))
public class AnamnesisGanRestController {
	private final AnamnesisGanService anamnesisGanService;

	public AnamnesisGanRestController(AnamnesisGanService anamnesisGanService) {
		this.anamnesisGanService = anamnesisGanService;
	}

	@Operation(summary = "Generates anamnesis for given abnormality and medical imaging technology")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Generated Anamnesis", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = GenerateAnamnesisResponse.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid/Not supported medical imaging technology", 
	    content = @Content) 
	  })	
	@PostMapping
	public GenerateAnamnesisResponse generateAnemnesis(GenerateAnamnesisRequest request) {
		return this.anamnesisGanService.generateAnemnesis(request);
	}

}
