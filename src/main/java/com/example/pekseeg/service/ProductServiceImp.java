package com.example.pekseeg.service;

import com.example.pekseeg.model.Product;
import com.example.pekseeg.model.User;
import com.example.pekseeg.repository.ProductRepository;
import com.example.pekseeg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{

    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    @Override
    public Product save(Product product, long id) {
        User user = userRepository.findById(id).orElse(new User());
            product.setUser(user);
            user.getProducts().add(product);
            userRepository.save(user); log.info("jhhh");
            return product;
    }



    @Override
    public List<Product> getProducts(long id) {
        User user = userRepository.findById(id).orElse(new User());
        return user.getProducts();
    }

    @Override
    public List<Product> getSpecificProduct(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void delete(long id) {
        Product deletedProduct = productRepository.findById(id).orElse(new Product());
        User user = userRepository.findById(deletedProduct.getUser().getId()).orElse(new User());
        user.getProducts().remove(deletedProduct);
        productRepository.delete(deletedProduct);
        userRepository.save(user);
    }

    @Override
    public Product update(Product product, long id) {
        User user = userRepository.findById(id).orElse(new User());
        product.setUser(user);
        productRepository.save(product);
        return product;
    }
}
