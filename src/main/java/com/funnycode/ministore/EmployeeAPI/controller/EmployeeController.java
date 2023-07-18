package com.funnycode.ministore.EmployeeAPI.controller;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.ResponseAccountDTO;
import com.funnycode.ministore.AccountAPI.dto.UpdateAccountDTO;
import com.funnycode.ministore.AccountAPI.service.AccountService;
import com.funnycode.ministore.EmployeeAPI.dto.CreateEmployeeDTO;
import com.funnycode.ministore.EmployeeAPI.dto.ResponseEmployeeDTO;
import com.funnycode.ministore.EmployeeAPI.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    //Create
    @PostMapping("/employees")
    public ResponseEmployeeDTO createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO){
        return employeeService.createEmployee(createEmployeeDTO);
    }

    //Get list employee
    @GetMapping("/employees")
    public List<ResponseEmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


}
