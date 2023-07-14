package com.funnycode.ministore.EmployeeAPI.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {
    String idEmp;

    String fullnameEmp;
    String CCCD;
    Date dob;
    String phoneEmp;
    Date dateJoin;
    String pictureEmp;
}
