package com.example.crm.dto.response;

import java.util.List;

import com.example.crm.entity.Customer;
import com.example.crm.entity.Phone;

public record CustomerDTO(String identity,String fullname,String email,List<Phone> phones) {
	public static CustomerDTO valueOf(Customer customer) {
		return new CustomerDTO(customer.getIdentity(), customer.getFullname(), customer.getEmail(), List.copyOf(customer.getPhones()));
	}
}
