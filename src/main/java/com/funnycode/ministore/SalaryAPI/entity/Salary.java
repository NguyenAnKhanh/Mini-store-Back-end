package com.funnycode.ministore.SalaryAPI.entity;

import com.funnycode.ministore.EmployeeAPI.entity.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idSalary;
    float totalSalary;
    Date dateIMonth;
    Date dateOMonth;

    @OneToOne()
    @JoinColumn(name = "id_emp")
    Employee employee;

}
