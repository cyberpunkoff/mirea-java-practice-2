package ru.mirea.edu.practice15.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.edu.practice15.model.Product;
import ru.mirea.edu.practice15.repository.ProductRepository;

import java.util.List;

@Service
@Primary
@Transactional
public class JpaProductService implements ProductService {
    private final ProductRepository productRepository;
    private final EmailService emailService;

    public JpaProductService(ProductRepository productRepository, EmailService emailService) {
        this.productRepository = productRepository;
        this.emailService = emailService;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String name) {
        return productRepository.findById(name).orElseThrow();
    }

    @Override
    public String addProduct(Product product) {
        emailService.sendLogMail("Add new product");
        return productRepository.save(product).getName();
    }

    @Override
    public void deleteProduct(String name) {
        productRepository.deleteById(name);
    }

    @Override
    public List<Product> getProductMoreExpensiveThan(Integer amount) {
        return productRepository.findByPriceGreaterThanEqual(amount);
    }
}
