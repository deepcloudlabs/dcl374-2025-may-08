package com.example.crm.dto.response;

import java.util.List;

public record CustomerQLResponse(String identity,String fullname,String email,List<PhoneQLResponse> phones,List<AddressQLResponse> addresses) {

}
