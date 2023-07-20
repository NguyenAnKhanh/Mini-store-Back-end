package com.funnycode.ministore.WorkSheetAPI.entity;

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
public class WorkSheet {

    @Id
    String idWorkSheet;
    Date date;
    int sheet;

    @OneToOne()
    @JoinColumn(name = "id_emp")
    Employee employee;

}
