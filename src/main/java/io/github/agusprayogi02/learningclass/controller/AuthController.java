package io.github.agusprayogi02.learningclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.agusprayogi02.learningclass.model.UserModel;
import io.github.agusprayogi02.learningclass.service.UserDetailsSeriveImpl;

@Controller
@RequestMapping("/auth")
public class AuthController {

    final UserDetailsSeriveImpl service;

    public AuthController(UserDetailsSeriveImpl service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @PostMapping("/register")
    public UserModel postRegister(@ModelAttribute("user") UserModel user) {
        // TODO: process POST request

        return user;
    }

}
