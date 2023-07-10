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
public class Permission {

    @Id
    String idPermission;
    String describePermission;

    @OneToOne()
    @JoinColumn(name = "id_role")
    Role role;

}
