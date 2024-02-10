package io.github.agusprayogi02.learningclass.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.agusprayogi02.learningclass.model.UserModel;
import io.github.agusprayogi02.learningclass.repository.AuthRepository;

@Service
public class UserDetailsSeriveImpl implements UserDetailsService {

    final AuthRepository auth;

    public UserDetailsSeriveImpl(AuthRepository auth) {
        this.auth = auth;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = auth.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

}
