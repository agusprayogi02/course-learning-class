package io.github.agusprayogi02.learningclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.agusprayogi02.learningclass.model.UserModel;
import io.github.agusprayogi02.learningclass.repository.AuthRepository;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserModel saveUser(UserModel user) {
        if (user == null) {
            return null;
        }
        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        user.setRole("ROLE_USER");
        return authRepo.save(user);
    }
}
