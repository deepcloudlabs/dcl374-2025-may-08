package com.example.crm.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.DynamicUpdate;

import com.example.validation.TcKimlikNo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customers")
@DynamicUpdate
public class Customer {
	@Id
	@TcKimlikNo
	private String identity;
	@Column(name = "fname")
	@NotBlank
	@Size(min=2)
	private String fullname;
	@Column(name="eposta")
	@Email
	private String email;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
	private List<Phone> phones;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Address> addresses;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] photo;
	
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
				+ ", addresses=" + addresses + ", photo=" + Arrays.toString(photo) + "]";
	}

}
