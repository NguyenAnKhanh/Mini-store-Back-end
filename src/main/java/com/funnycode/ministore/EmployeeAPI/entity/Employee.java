package com.funnycode.ministore.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    String idEmp;
    String fullnameEmp;
    String CCCD;
    Date dob;
    String phoneEmp;
    Date dateJoin;
    String pictureEmp;

}
