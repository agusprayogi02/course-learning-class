package io.github.agusprayogi02.learningclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.github.agusprayogi02.learningclass.model.UserModel;
import io.github.agusprayogi02.learningclass.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") UserModel user, RedirectAttributes attributes) {
        UserModel u = authService.saveUser(user);
        if (u == null) {
            attributes.addFlashAttribute("failed", "User gagal dibuat!");
        } else {
            attributes.addFlashAttribute("success", "User berhasil dibuat!");
        }
        return "redirect:/auth/register";
    }

}
