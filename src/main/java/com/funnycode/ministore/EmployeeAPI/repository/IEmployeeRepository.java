package com.funnycode.ministore.EmployeeAPI.repository;

import com.funnycode.ministore.EmployeeAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
}
