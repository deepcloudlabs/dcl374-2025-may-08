package com.example.crm.dto.request;

import java.util.Base64;
import java.util.List;

import com.example.crm.entity.Customer;

public record UpdateCustomerRequest(String identity,String fullname,String email,List<PhoneRequest> phones,List<AddressRequest> addresses,String photo) {

	public Customer toCustomer() {
		var customer = new Customer();
		customer.setIdentity(identity);
		customer.setFullname(fullname);
		customer.setEmail(email);
		customer.setPhones(phones.stream().map(PhoneRequest::toPhone).toList());
		customer.setAddresses(addresses.stream().map(AddressRequest::toAddress).toList());
		customer.setPhoto(Base64.getDecoder().decode(photo));
		return customer;
	}
}
