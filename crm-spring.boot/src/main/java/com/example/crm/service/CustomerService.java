package com.example.crm.service;

import java.util.List;
import java.util.Map;

import com.example.crm.dto.request.AcquireCustomerRequest;
import com.example.crm.dto.request.UpdateCustomerRequest;
import com.example.crm.dto.response.AcquireCustomerResponse;
import com.example.crm.dto.response.CustomerDTO;
import com.example.crm.dto.response.PatchCustomerResponse;
import com.example.crm.dto.response.ReleaseCustomerResponse;
import com.example.crm.dto.response.UpdateCustomerResponse;

public interface CustomerService {

	List<CustomerDTO> findAll(int page, int size);

	CustomerDTO findCustomerByIdentity(String identity);

	AcquireCustomerResponse acquireCustomer(AcquireCustomerRequest request);

	ReleaseCustomerResponse releaseCustomer(String identity);

	UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request);

	PatchCustomerResponse patchCustomer(Map<String, Object> request);

}
