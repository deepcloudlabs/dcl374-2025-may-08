package com.example.crm.dto.request;

import com.example.crm.entity.Phone;
import com.example.crm.entity.PhoneType;

public record PhoneRequest(long phoneId,PhoneType type,String country,String number,String extension) {
	public Phone toPhone() {
		var phone = new Phone();
		phone.setPhoneId(phoneId);
		phone.setType(type);
		phone.setCountry(country);
		phone.setNumber(number);
		phone.setExtension(extension);
		return phone;
	}
}
