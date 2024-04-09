package ru.mirea.edu.practice14.controller;

import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.practice14.model.*;
import ru.mirea.edu.practice14.service.*;

import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    @PostMapping()
    public Integer addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }
}
