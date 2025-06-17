package com.example.Employee.repository;

import com.example.Employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmpId(String empId);
}
