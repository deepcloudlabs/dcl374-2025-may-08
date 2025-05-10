package com.example.crm.dto.response;

import com.example.crm.entity.PhoneType;

public record PhoneQLResponse(Long phoneId,PhoneType type,String country,String number,String extension) {

}
