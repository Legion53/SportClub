package com.dnu.edu.ua.test.controllers;

import com.dnu.edu.ua.test.entities.User;
import com.dnu.edu.ua.test.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RegistrationRestController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());

        boolean registered = userService.registerUser(user);
        if (!registered) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("A user with this email already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @Data
    public static class UserRegistrationRequest {
        private String email;
        private String password;
        private String firstname;
        private String lastname;
    }
}
