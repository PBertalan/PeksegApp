package com.example.pekseeg.service;

import com.example.pekseeg.model.Product;
import com.example.pekseeg.model.User;

import java.util.List;

public interface ProductService {

    public Product save(Product product, long id);

    public List<Product> getProducts(long id);

    public List<Product> getSpecificProduct(String name);

    public void delete(long id);

    public Product update(Product product, long id);
}
