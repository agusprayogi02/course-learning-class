package io.github.agusprayogi02.learningclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.agusprayogi02.learningclass.service.UserDetailsSeriveImpl;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String register(@RequestParam String param) {
        return "auth/register";
    }

}
