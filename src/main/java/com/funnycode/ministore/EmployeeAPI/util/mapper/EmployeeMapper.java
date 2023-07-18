package com.funnycode.ministore.EmployeeAPI.util.mapper;

import com.funnycode.ministore.AccountAPI.dto.CreateAccountDTO;
import com.funnycode.ministore.EmployeeAPI.dto.CreateEmployeeDTO;
import com.funnycode.ministore.EmployeeAPI.dto.ResponseEmployeeDTO;
import com.funnycode.ministore.EmployeeAPI.entity.Employee;

public class EmployeeMapper {


    public static Employee toEmployee(CreateEmployeeDTO createEmployeeDTO) {
        return Employee.builder().idEmp(createEmployeeDTO.getIdEmp())
                .CCCD(createEmployeeDTO.getCCCD())
                .dateJoin(createEmployeeDTO.getDateJoin())
                .dob(createEmployeeDTO.getDob())
                .fullnameEmp(createEmployeeDTO.getFullnameEmp())
                .phoneEmp(createEmployeeDTO.getPhoneEmp())
                .pictureEmp(createEmployeeDTO.getPictureEmp())
                .build();
    }

    public static ResponseEmployeeDTO toResponseEmployeeDTO(Employee emp) {
        return ResponseEmployeeDTO.builder()
                .dateJoin(emp.getDateJoin())
                .dob(emp.getDob())
                .fullnameEmp(emp.getFullnameEmp())
                .phoneEmp(emp.getPhoneEmp())
                .pictureEmp(emp.getPictureEmp())
                .build();
    }
}
