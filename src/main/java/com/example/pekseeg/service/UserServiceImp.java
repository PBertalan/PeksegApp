package com.example.pekseeg.service;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.pekseeg.model.User;
import com.example.pekseeg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;



    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
