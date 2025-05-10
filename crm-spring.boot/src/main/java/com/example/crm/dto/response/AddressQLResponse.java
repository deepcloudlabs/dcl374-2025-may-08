package com.example.crm.dto.response;

import java.util.Set;

import com.example.crm.entity.AddressType;

public record AddressQLResponse(Long addressId, AddressType type, String country, String city, Set<String> lines) {

}
