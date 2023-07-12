package com.funnycode.ministore.PermissionAPI.entity;

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
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idPermission;
    String describePermission;

    @OneToOne()
    @JoinColumn(name = "id_role")
    Role role;

}
