package com.example.crm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	List<Customer> findAllByAddressesCountryAndAddressesCity(String country,String city);
	@Query(nativeQuery = true, value = "select c from CUSTOMERS c where c.eposta = :email")
	Optional<Customer> getir(String email);
	@Query(nativeQuery = false, value = "select c from Customer c where c.email = :email")
	Optional<Customer> bul(String email);
}
