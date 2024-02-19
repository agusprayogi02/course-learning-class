package io.github.agusprayogi02.learningclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.github.agusprayogi02.learningclass.model.CustomUserDetails;
import io.github.agusprayogi02.learningclass.model.UserModel;
import io.github.agusprayogi02.learningclass.repository.AuthRepository;

@Component
public class UserDetailsSeriveImpl implements UserDetailsService {

    @Autowired
    private AuthRepository authRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = authRepo.findByEmailIgnoreCase(username);
        if (user == null) {
            throw new UsernameNotFoundException("User tidak ditemukan");
        }
        return new CustomUserDetails(user);
    }
}
