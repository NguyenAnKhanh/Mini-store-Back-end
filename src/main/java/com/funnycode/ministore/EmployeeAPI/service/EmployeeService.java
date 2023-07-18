package com.funnycode.ministore.EmployeeAPI.service;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.EmployeeAPI.dto.CreateEmployeeDTO;
import com.funnycode.ministore.EmployeeAPI.dto.ResponseEmployeeDTO;

import java.util.List;

public interface EmployeeService {

    ResponseEmployeeDTO createEmployee(CreateEmployeeDTO createEmployeeDTO);

    List<ResponseEmployeeDTO> getAllEmployees();
}
