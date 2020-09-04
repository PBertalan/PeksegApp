package com.example.pekseeg.controller;

import com.example.pekseeg.model.User;
import com.example.pekseeg.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value ="/createrole")
    public void createRole() {
        userService.createRole();
    }

    @PostMapping(value="/user/reg")
    public void registerUser(@RequestBody User user){
        userService.register(user);

    }

    @GetMapping(value = "/user/profile")
    public User findUser(@RequestParam(value="email") String email){
        return userService.getUser(email);
    }

    @DeleteMapping(value="/user/{id}}")
    public void deleteUser(@PathVariable(value="id") Long id) throws IOException {

        userService.delete(id);

    }

}
