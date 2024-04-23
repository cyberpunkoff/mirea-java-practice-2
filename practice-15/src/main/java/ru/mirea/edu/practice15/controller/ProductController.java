package ru.mirea.edu.practice15.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.practice15.model.Product;
import ru.mirea.edu.practice15.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        logger.info("Get all products called!");
        return productService.getAllProducts();
    }

    @GetMapping("/filter")
    public List<Product> getAllProductsMoreExpensiveThan(@RequestParam("minPrice") Integer filter) {
        logger.info("Getting products with price filter more than {}", filter);
        return productService.getProductMoreExpensiveThan(filter);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        logger.info("Getting product with id {}", id);
        return productService.getProduct(id);
    }

    @PostMapping()
    public String addProduct(@RequestBody Product product) {
        logger.info("Adding new product {}", product);
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        logger.info("Deleting product with id {}", id);
        productService.deleteProduct(id);
    }
}
