package com.example.crm.dto.response;

import java.util.List;

import com.example.crm.entity.Customer;

public record CustomerQLResponse(String identity,String fullname,String email,List<PhoneQLResponse> phones,List<AddressQLResponse> addresses) {
	public static CustomerQLResponse valueOf(Customer customer) {
		return new CustomerQLResponse(customer.getIdentity(),customer.getFullname(),customer.getEmail(),customer.getPhones().stream().map(PhoneQLResponse::valueOf).toList(),customer.getAddresses().stream().map(AddressQLResponse::valueOf).toList());

	}
}
