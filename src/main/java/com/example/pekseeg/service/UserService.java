package com.example.pekseeg.service;

import com.example.pekseeg.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User register(User user);

    public User getUser(String email);

    public void delete(Long id) throws IOException;

    public void createRole();
}