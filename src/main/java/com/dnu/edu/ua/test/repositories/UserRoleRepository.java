package com.dnu.edu.ua.test.repositories;

import com.dnu.edu.ua.test.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRoleName(String roleName);
}
