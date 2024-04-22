package ru.mirea.edu.practice15.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.practice15.model.*;
import ru.mirea.edu.practice15.service.*;


import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/filter")
    public List<Product> getAllProductsMoreExpensiveThan(@RequestParam("minPrice") Integer filter) {
        return productService.getProductMoreExpensiveThan(filter);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @PostMapping()
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
