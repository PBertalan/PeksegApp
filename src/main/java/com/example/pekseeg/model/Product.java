package com.example.pekseeg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;

    private int price;

    private int quantity;

    @JsonIgnore
    private String userName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Product() {
    }

    public Product(String name, int price, int quantity, User user) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.user = user;
    }
}

