package com.example.crm.service.business;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crm.dto.request.AcquireCustomerRequest;
import com.example.crm.dto.request.UpdateCustomerRequest;
import com.example.crm.dto.response.AcquireCustomerResponse;
import com.example.crm.dto.response.CustomerDTO;
import com.example.crm.dto.response.PatchCustomerResponse;
import com.example.crm.dto.response.ReleaseCustomerResponse;
import com.example.crm.dto.response.UpdateCustomerResponse;
import com.example.crm.event.CustomerAcquiredEvent;
import com.example.crm.event.CustomerReleasedEvent;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.service.CustomerService;

// Event-Driven Systems
@Service
public class StandardCustomerService implements CustomerService {
	private final CustomerRepository customerRepository;
	private final ApplicationEventPublisher eventPublisher;

	public StandardCustomerService(CustomerRepository customerRepository, ApplicationEventPublisher eventPublisher) {
		this.customerRepository = customerRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public List<CustomerDTO> findAll(int page, int size) {
		return customerRepository.findAll(PageRequest.of(page, size))
				                 .stream()
				                 .map(CustomerDTO::valueOf).toList();
	}

	@Override
	public CustomerDTO findCustomerByIdentity(String identity) {
		return customerRepository.findById(identity)
				                 .map(CustomerDTO::valueOf)
				                 .orElseThrow(() -> new IllegalArgumentException("Cannot find the customer with identity no: %s".formatted(identity)));
	}

	// Command -> Domain Event?
	@Override
	@Transactional
	public AcquireCustomerResponse acquireCustomer(AcquireCustomerRequest request) {
		var savedCustomer = customerRepository.save(request.toCustomer());
		var event = new CustomerAcquiredEvent(request.identity());
		eventPublisher.publishEvent(event);
		return AcquireCustomerResponse.valueOf(savedCustomer);
	}

	@Override
	@Transactional
	public ReleaseCustomerResponse releaseCustomer(String identity) {
		var customer = customerRepository.findById(identity).orElseThrow(() -> new IllegalArgumentException("Cannot find the customer to delete: %s".formatted(identity)));
		customerRepository.delete(customer);
		var event = new CustomerReleasedEvent(identity);
		eventPublisher.publishEvent(event);
		return new ReleaseCustomerResponse(identity);
	}

	@Override
	@Transactional
	public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public PatchCustomerResponse patchCustomer(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return null;
	}

}
