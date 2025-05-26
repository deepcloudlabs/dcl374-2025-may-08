package com.example.crm.document;

import java.util.Objects;

public class Phone {
	private Long phoneId;
	private PhoneType type;
	private String country;
	private String number;
	private String extension;

	public Phone() {
	}

	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public int hashCode() {
		return Objects.hash(phoneId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(phoneId, other.phoneId);
	}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", type=" + type + ", country=" + country + ", number=" + number
				+ ", extension=" + extension + "]";
	}

}
