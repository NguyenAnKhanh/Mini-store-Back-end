package com.funnycode.ministore.PermissionAPI.repository;

import com.funnycode.ministore.PermissionAPI.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermissionRepository extends JpaRepository<Permission, String> {
}
