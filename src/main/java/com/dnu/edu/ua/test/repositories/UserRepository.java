package com.dnu.edu.ua.test.repositories;

import com.dnu.edu.ua.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
