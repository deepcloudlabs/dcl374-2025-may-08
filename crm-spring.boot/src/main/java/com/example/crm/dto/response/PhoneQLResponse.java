package com.example.crm.dto.response;

import com.example.crm.entity.Phone;
import com.example.crm.entity.PhoneType;

public record PhoneQLResponse(Long phoneId,PhoneType type,String country,String number,String extension) {
	public static PhoneQLResponse valueOf(Phone phone) {
		return new PhoneQLResponse(phone.getPhoneId(),phone.getType(),phone.getCountry(),phone.getNumber(),phone.getExtension());
	}
}	
