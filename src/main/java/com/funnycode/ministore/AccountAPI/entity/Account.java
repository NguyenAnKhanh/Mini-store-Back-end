package com.funnycode.ministore.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table
@Data
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
