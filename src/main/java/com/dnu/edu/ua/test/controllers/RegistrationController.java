package com.dnu.edu.ua.test.controllers;

import com.dnu.edu.ua.test.entities.User;
import com.dnu.edu.ua.test.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;
    private static final Logger LOG = Logger.getLogger(RegistrationController.class.getName());

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult, Model model) {
        LOG.info("Registrating new user");
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userService.registerUser(user)) {
            model.addAttribute("usernameError", "A user with this email already exists");
            return "registration";
        }
        return "redirect:/profile";
    }
}
