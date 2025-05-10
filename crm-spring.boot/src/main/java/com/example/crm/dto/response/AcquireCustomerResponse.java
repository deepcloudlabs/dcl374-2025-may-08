package com.example.crm.dto.response;

import com.example.crm.entity.Customer;

public record AcquireCustomerResponse(String identity,String fullname,String email) {
	public static AcquireCustomerResponse valueOf(Customer customer) {
		return new AcquireCustomerResponse(customer.getIdentity(),customer.getFullname(),customer.getEmail());
	}
}
