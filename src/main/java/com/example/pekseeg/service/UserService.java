package com.example.pekseeg.service;

import com.example.pekseeg.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User register(User user);

    public User getUser(String email);
}