package com.funnycode.ministore.SalaryAPI.repository;

import com.funnycode.ministore.SalaryAPI.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEntityRepository extends JpaRepository<Salary, String> {
}
