package com.example.pekseeg.controller;

import com.example.pekseeg.model.Product;
import com.example.pekseeg.model.User;
import com.example.pekseeg.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value="/product/{id}/add")
    public Product addProduct(@RequestParam(value="id") long id, @RequestBody Product product){
        return productService.save(product,id);
    }

    @GetMapping(value="/product/{id}/products")
    public List<Product> getProducts(@RequestParam(value="id")long id){
        return productService.getProducts(id);
    }

    @GetMapping(value="/product/{id}")
    public List<Product> getProduct(@RequestParam(value="name")String name){
        return productService.getSpecificProduct(name);
    }

    @DeleteMapping(value="/product/delete/{id}")
    public void deleteProduct(@RequestParam(value="id")long id){
        productService.delete(id);
    }

    @PostMapping(value="/product/{id}/update")
    public Product updateProduct(@RequestParam(value="id") long id, @RequestBody Product product){
        return productService.update(product,id);
    }

}
