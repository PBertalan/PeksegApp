package com.example.pekseeg.service;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.pekseeg.model.Role;
import com.example.pekseeg.model.User;
import com.example.pekseeg.repository.RoleRepository;
import com.example.pekseeg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final String ROLE_USER = "ROLE_USER";

    private final String ROLE_ADMIN = "ROLE_ADMIN";



    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User register(User user) {
        user.setRole(roleRepository.findByRole(ROLE_USER));
        return userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void delete(Long id) throws IOException {
        User user = userRepository.findById(id).orElse(new User());
        userRepository.delete(user);
    }

    @Override
    public void createRole() {

        Role roleUser = new Role();
        roleUser.setRole("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setRole("ROLE_ADMIN");
        roleRepository.save(roleAdmin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserDetailsImpl(user);
    }
}
