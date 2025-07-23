package com.example.crm.document;

import java.util.Base64;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.example.validation.TcKimlikNo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document(collection="customers")
public class Customer {
	@Id
	@TcKimlikNo
	private String identity;
	@Field(name = "fname")
	@NotBlank
	@Size(min=2)
	private String fullname;
	@Field(name="eposta")
	@Email
	private String email;
	private List<Phone> phones;
	private List<Address> addresses;
	private String photo;
	
	public Customer() {
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getPhoto() {
		return photo;
	}
	
	public byte[] getBinaryPhoto() {
		return Base64.getDecoder().decode(photo);
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = Base64.getEncoder().encodeToString(photo);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(identity, other.identity);
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullname=" + fullname + ", email=" + email + ", phones=" + phones
				+ ", addresses=" + addresses + "]";
	}

}
