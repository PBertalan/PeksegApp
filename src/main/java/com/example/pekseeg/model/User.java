package com.example.pekseeg.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String email;

    private String fullName;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public User() {
    }

    public User(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }
}

