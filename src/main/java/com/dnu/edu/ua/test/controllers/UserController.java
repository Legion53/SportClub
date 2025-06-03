package com.dnu.edu.ua.test.controllers;

import com.dnu.edu.ua.test.entities.User;
import com.dnu.edu.ua.test.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    @GetMapping("/login")
    public String login() {
        return "users/login";
    }

    @GetMapping("/profile")
    public String userProfile(Model model) {
        LOG.info("Opened user profile page");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "users/profile";
    }
}
