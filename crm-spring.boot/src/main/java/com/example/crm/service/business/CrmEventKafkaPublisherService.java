package com.example.crm.service.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.crm.event.CrmBaseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CrmEventKafkaPublisherService {
	private final KafkaTemplate<String,String> kafkaTemplate;
	private final ObjectMapper objectMapper;
	private final String crmEventTopic;
	
	public CrmEventKafkaPublisherService(
			KafkaTemplate<String, String> kafkaTemplate, 
			ObjectMapper objectMapper, 
			@Value("${crmEventTopic}") String crmEventTopic) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
		this.crmEventTopic = crmEventTopic;
	}
	
	@EventListener
	public void publishCrmEventsThroughWS(CrmBaseEvent event) throws JsonProcessingException {
	    var eventAsJson = objectMapper.writeValueAsString(event);
		kafkaTemplate.send(crmEventTopic, event.getEventType().name(), eventAsJson);
	}
}
