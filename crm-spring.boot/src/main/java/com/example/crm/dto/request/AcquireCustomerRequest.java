package com.example.crm.dto.request;

import java.util.List;

import com.example.crm.entity.Customer;

public record AcquireCustomerRequest(String identity,String fullname,String email,List<PhoneRequest> phones,List<AddressRequest> addresses) {

	public Customer toCustomer() {
		var customer = new Customer();
		customer.setIdentity(identity);
		customer.setFullname(fullname);
		customer.setEmail(email);
		customer.setPhones(phones.stream().map(PhoneRequest::toPhone).toList());
		customer.setAddresses(addresses.stream().map(AddressRequest::toAddress).toList());
		return customer;
	}

}
