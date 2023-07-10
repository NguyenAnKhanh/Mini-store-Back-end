package com.funnycode.ministore.AccountAPI.entity;

import com.funnycode.ministore.EmployeeAPI.entity.Employee;
import com.funnycode.ministore.RoleAPI.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    String username;
    String password;

    @OneToOne()
    @JoinColumn(name = "id_emp")
    Employee employee;

    @OneToOne()
    @JoinColumn(name = "id_role")
    Role role;

}
