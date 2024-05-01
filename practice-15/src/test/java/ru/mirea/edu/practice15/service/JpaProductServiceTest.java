package ru.mirea.edu.practice15.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.edu.practice15.model.Product;
import ru.mirea.edu.practice15.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class JpaProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private EmailService emailService;
    @Captor
    ArgumentCaptor<Product> captor;

    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = new JpaProductService(productRepository, emailService);
    }

    @Test
    void getAllProductsTest() {
        Product product1 = new Product();
        product1.setName("first");
        Product product2 = new Product();
        product1.setName("second");

        when(productRepository.findAll()).thenReturn(List.of(product1, product2));

        ProductService productService = new JpaProductService(productRepository, emailService);

        assertThat(productService.getAllProducts()).isEqualTo(List.of(product1, product2));
    }

    @Test
    void getAllProductTest() {
        Product product1 = new Product();
        product1.setName("first");
        Product product2 = new Product();
        product1.setName("second");

        when(productRepository.findById("first")).thenReturn(Optional.of(product1));

        assertThat(productService.getProduct("first")).isEqualTo(product1);
    }

    @Test
    void addProductTest() {
        Product product1 = new Product();
        product1.setName("first");

        when(productRepository.save(any())).thenReturn(product1);

        productService.addProduct(product1);

        Mockito.verify(productRepository).save(captor.capture());
        Product product = captor.getValue();

        assertThat(product).isEqualTo(product1);
    }

    @Test
    void getProductMoreExpensiveThanTest() {
        Product product1 = new Product();
        product1.setName("first");
        product1.setPrice(100);

        Product product2 = new Product();
        product1.setName("second");
        product1.setPrice(200);

        when(productRepository.findByPriceGreaterThanEqual(150)).thenReturn(List.of(product2));

        List<Product> result = productService.getProductMoreExpensiveThan(150);

        assertThat(result).isEqualTo(List.of(product2));
    }
}
