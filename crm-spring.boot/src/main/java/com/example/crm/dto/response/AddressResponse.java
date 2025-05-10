package com.example.crm.dto.response;

import java.util.Set;

import com.example.crm.entity.Address;
import com.example.crm.entity.AddressType;

public record AddressResponse(Long addressId, AddressType type, String country, String city, Set<String> lines) {
	public static AddressResponse valueOf(Address address) {
		return new AddressResponse(address.getId(), address.getType(), address.getCountry(), address.getCity(),
				Set.copyOf(address.getAddressLines()));
	}
}
