package com.example.crm.service.business;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.crm.event.CrmBaseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CrmEventRabbitPublisherService {
	private final RabbitTemplate rabbitTemplate;
	private final ObjectMapper objectMapper;
	private final String crmEventExchange;
	
	public CrmEventRabbitPublisherService(
			RabbitTemplate rabbitTemplate, 
			ObjectMapper objectMapper,
			@Value("${crmEventExchange}") String crmEventExchange) { 
		this.rabbitTemplate = rabbitTemplate;
		this.objectMapper = objectMapper;
		this.crmEventExchange = crmEventExchange;
	}
	
	@EventListener
	public void publishCrmEventsThroughWS(CrmBaseEvent event) throws JsonProcessingException {
	    var eventAsJson = objectMapper.writeValueAsString(event);
		rabbitTemplate.convertAndSend(crmEventExchange, null,eventAsJson);
	}
	
}
