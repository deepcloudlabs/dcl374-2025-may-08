package com.example.crm.dto.response;

import java.util.Set;

import com.example.crm.entity.Address;
import com.example.crm.entity.AddressType;

public record AddressQLResponse(Long addressId, AddressType type, String country, String city, Set<String> lines) {
	public static AddressQLResponse valueOf(Address address) {
		return new AddressQLResponse(address.getId(),address.getType(),address.getCountry(),address.getCity(),Set.copyOf(address.getAddressLines()));
	}
}
