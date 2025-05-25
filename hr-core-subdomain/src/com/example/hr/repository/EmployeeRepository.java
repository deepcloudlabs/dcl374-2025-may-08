package com.example.hr.repository;

import java.util.Optional;

import com.example.ddd.Repository;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.hexagonal.Port;
import com.example.hr.hexagonal.PortType;

@Repository(entity=Employee.class)
@Port(PortType.DRIVEN)
public interface EmployeeRepository {

	boolean exists(TcKimlikNo identity);

	Employee persist(Employee employee);

	Optional<Employee> findById(TcKimlikNo identity);

	Optional<Employee> remove(Employee employee);

}
