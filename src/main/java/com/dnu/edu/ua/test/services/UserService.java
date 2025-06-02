package com.dnu.edu.ua.test.services;

import com.dnu.edu.ua.test.entities.Member;
import com.dnu.edu.ua.test.entities.User;
import com.dnu.edu.ua.test.repositories.UserRepository;
import com.dnu.edu.ua.test.repositories.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger LOG = Logger.getLogger(UserService.class.getName());

    public List<User> getAllUsers() {
        LOG.info("Finding all users");
        return userRepository.findAll();
    }
    public boolean registerUser(User user) {
        LOG.info("Registering new user: " + user.getEmail());
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return false;
        }
        user.setRole(userRoleRepository.findByRoleName("USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
    public User getUserByEmail(String email) {
        LOG.info("Fetching user by email: " + email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new NoSuchElementException("User not found");
        }
        return user;
    }
    public User createUser(User user) {
        LOG.info("Creating new user: " + user.getEmail());
        return userRepository.save(user);
    }
    public Optional<User> getUserById(Long id) {
        LOG.info("Fetching user by id: " + id);
        return userRepository.findById(id);
    }
}
