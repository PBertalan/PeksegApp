package com.example.pekseeg.service;

import com.example.pekseeg.model.User;
import com.example.pekseeg.repository.UserRepository;
import com.example.pekseeg.util.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public JwtUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDetails loadUserByUsername(String username){
        User user = repository.findByEmail(username);

        return new UserPrincipal(user);
    }
}
