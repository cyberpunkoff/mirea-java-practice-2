package ru.mirea.edu.practice14.service;

import org.springframework.stereotype.*;
import ru.mirea.edu.practice14.model.*;

import java.util.*;

@Service
public class ProductService {
    private final Map<Integer, Product> products = new HashMap<>();
    private int count;

    public List<Product> getAllProducts() {
        return products.values().stream().toList();
    }

    public Product getProduct(Integer id) {
        return products.get(id);
    }

    public Integer addProduct(Product product) {
        products.put(count, product);
        count++;
        return count - 1;
    }

    public Product deleteProduct(Integer id) {
        return products.remove(id);
    }
}
