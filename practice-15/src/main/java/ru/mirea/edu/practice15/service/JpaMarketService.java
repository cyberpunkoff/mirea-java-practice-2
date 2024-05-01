package ru.mirea.edu.practice15.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.mirea.edu.practice15.model.Market;
import ru.mirea.edu.practice15.repository.MarketRepository;

import java.util.List;

@Service
@Primary
public class JpaMarketService implements MarketService {
    private final MarketRepository marketRepository;

    public JpaMarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @Override
    public List<Market> getAllMarkets() {
        return marketRepository.findAll();
    }

    @Override
    public Market getMarket(String name) {
        return marketRepository.findById(name).orElseThrow();
    }

    @Override
    public String addMarket(Market market) {
        return marketRepository.save(market).getName();
    }

    @Override
    public void deleteMarket(String name) {
        marketRepository.deleteById(name);
    }
}
