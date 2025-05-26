package com.example.hr.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.hr.document.EmployeeDocument;
import com.mongodb.client.result.UpdateResult;

@Repository
public class SimpleEmployeeRepository {
	private final MongoTemplate mongoTemplate;
	
	public SimpleEmployeeRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<EmployeeDocument> getEmployeesByEmail(String email){
		var query = new Query(Criteria.where("email").is(email));
		return mongoTemplate.find(query, EmployeeDocument.class);
	}

	public UpdateResult updateEmployeeSalary(String identity,double salary){
		var query = new Query(Criteria.where("_id").is(identity));
		Update update = new Update().set("salary", salary);
		return mongoTemplate.updateFirst(query, update,EmployeeDocument.class);
	}
}
