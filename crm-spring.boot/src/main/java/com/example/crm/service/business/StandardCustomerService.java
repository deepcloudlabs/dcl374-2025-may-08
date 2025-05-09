package com.example.crm.service.business;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.crm.dto.request.AcquireCustomerRequest;
import com.example.crm.dto.request.UpdateCustomerRequest;
import com.example.crm.dto.response.AcquireCustomerResponse;
import com.example.crm.dto.response.CustomerDTO;
import com.example.crm.dto.response.PatchCustomerResponse;
import com.example.crm.dto.response.ReleaseCustomerResponse;
import com.example.crm.dto.response.UpdateCustomerResponse;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO findCustomerByIdentity(String identity) {
		// TODO Auto-generated method stub
		return null;
	}

	// Command -> Domain Event?
	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	public AcquireCustomerResponse acquireCustomer(AcquireCustomerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ReleaseCustomerResponse releaseCustomer(String identity) {
		// TODO Auto-generated method stub
		return null;
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
