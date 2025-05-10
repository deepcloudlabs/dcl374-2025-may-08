package com.example.crm.dto.response;

import java.util.List;

import com.example.crm.entity.Customer;

public record CustomerAddressResponse(String identity, List<AddressResponse> addresses) {
	public static CustomerAddressResponse valueOf(Customer customer) {
		return new CustomerAddressResponse(customer.getIdentity(),
				customer.getAddresses().stream().map(AddressResponse::valueOf).toList());
	}
}
