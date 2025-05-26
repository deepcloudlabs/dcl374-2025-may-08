package com.example.crm.document;

import java.util.Objects;
import java.util.Set;

public class Address {
	private Long id;
	private Set<String> addressLines;
	private AddressType type;
	private String country;
	private String city;

	public Address() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Set<String> getAddressLines() {
		return addressLines;
	}

	public void setAddressLines(Set<String> addressLines) {
		this.addressLines = addressLines;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLines=" + addressLines + ", type=" + type + ", country=" + country + ", city=" + city
				+ "]";
	}

}
