package com.example.crm.dto.request;

import java.util.Set;

import com.example.crm.entity.Address;
import com.example.crm.entity.AddressType;

public record AddressRequest(Long addressId, AddressType type, String country, String city, Set<String> lines) {
	public Address toAddress() {
		var address = new Address();
		address.setId(addressId);
		address.setType(type);
		address.setAddressLines(Set.copyOf(lines));
		address.setCountry(country);
		address.setCity(city);
		return address;
	}
}
