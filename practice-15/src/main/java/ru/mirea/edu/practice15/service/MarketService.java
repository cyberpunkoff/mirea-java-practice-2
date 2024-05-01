package ru.mirea.edu.practice15.service;

import jakarta.annotation.*;
import org.hibernate.*;
import org.springframework.stereotype.*;
import ru.mirea.edu.practice15.model.*;

import java.util.*;

@Service
public class MarketService {
    private final Map<Integer, Market> markets = new HashMap<>();
    private int count;
    private final SessionFactory sessionFactory;
    private Session session;

    public MarketService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Market> getAllMarkets() {
        return session.createQuery("select u from Market u", Market.class).getResultList();
    }

    public Market getMarket(String name) {
        return session.createQuery("select u from Market u where u.id = :name", Market.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public String addMarket(Market market) {
        session.persist(market);
        return market.getName();
    }

    public void deleteMarket(String name) {
        session.createQuery("delete from Market u where u.name = :name", Market.class)
                .setParameter("name", name);
    }


}
