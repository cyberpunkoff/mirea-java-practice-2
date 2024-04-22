package ru.mirea.edu.practice15.service;

import jakarta.annotation.PostConstruct;
import ru.mirea.edu.practice15.model.Market;

import java.util.List;

public interface MarketService {
    List<Market> getAllMarkets();

    Market getMarket(String name);

    String addMarket(Market market);

    void deleteMarket(String name);
}
