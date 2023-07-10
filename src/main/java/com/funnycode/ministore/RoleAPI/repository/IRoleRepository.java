package com.funnycode.ministore.RoleAPI.repository;

import com.funnycode.ministore.RoleAPI.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {

}
