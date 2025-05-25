package com.example.crm.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.crm.document.CustomerDocument;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerDocumentRepository extends ReactiveMongoRepository<CustomerDocument, String> {
		Flux<CustomerDocument> findAllByAddressesCountry(String country);
		Mono<CustomerDocument> findOneByPhonesCountryCodeAndPhonesNumber(String countryCode,String number);
		@Query("{}")
		Flux<CustomerDocument> findAll(PageRequest page);
}
