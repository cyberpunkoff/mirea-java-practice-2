package ru.mirea.edu.practice15.service;

import ru.mirea.edu.practice15.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(String name);

    String addProduct(Product product);

    void deleteProduct(String name);

    List<Product> getProductMoreExpensiveThan(Integer amount);
}
