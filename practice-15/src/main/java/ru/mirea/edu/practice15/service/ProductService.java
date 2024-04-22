package ru.mirea.edu.practice15.service;

import jakarta.annotation.*;
import org.hibernate.*;
import org.springframework.stereotype.*;
import ru.mirea.edu.practice15.model.*;

import java.util.*;

@Service
public class ProductService {
    private final SessionFactory sessionFactory;
    private Session session;

    public ProductService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Product> getAllProducts() {
        return session.createQuery("select u from Product u", Product.class).getResultList();
    }

    public Product getProduct(String name) {
        return session.createQuery("select u from Product u where u.name = :name", Product.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public String addProduct(Product product) {

        var transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();

        return product.getName();
    }

    public void deleteProduct(String name) {
        session.createQuery("delete from Product u where u.id = :name", Product.class)
                .setParameter("name", name);
    }
}