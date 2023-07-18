package com.funnycode.ministore.EmployeeAPI.service.impl;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.EmployeeAPI.dto.CreateEmployeeDTO;
import com.funnycode.ministore.EmployeeAPI.dto.ResponseEmployeeDTO;
import com.funnycode.ministore.EmployeeAPI.entity.Employee;
import com.funnycode.ministore.EmployeeAPI.util.mapper.EmployeeMapper;
import com.funnycode.ministore.EmployeeAPI.repository.IEmployeeRepository;
import com.funnycode.ministore.EmployeeAPI.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final IEmployeeRepository iEmployeeRepository;

    @Override
    public ResponseEmployeeDTO createEmployee(CreateEmployeeDTO createEmployeeDTO) {
        Employee emp = EmployeeMapper.toEmployee(createEmployeeDTO);
        emp = iEmployeeRepository.save(emp);
        return EmployeeMapper.toResponseEmployeeDTO(emp);
    }

    @Override
    public List<ResponseEmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = iEmployeeRepository.findAll();
        List<ResponseEmployeeDTO> responseEmployeeDTOList = new ArrayList<>();
        for (Employee em: employeeList
             ) {
            responseEmployeeDTOList.add(EmployeeMapper.toResponseEmployeeDTO(em));

        }
        return responseEmployeeDTOList;
    }
}
