package com.example.crm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.crm.document.Customer;

public interface CustomerDocumentMongoRepository extends MongoRepository<Customer, String> {
	List<Customer> findAllByAddressesCountryAndAddressesCity(String country,String city);
	@Query("{eposta: ?1}")
	Optional<Customer> getir(String email);
	@Query("{\"adresses.country\": {$in: [?1]},\"adresses.city\": {$in: [?2]}}")
	List<Customer> bul(String country,String city);
}
