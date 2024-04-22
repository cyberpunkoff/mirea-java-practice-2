package ru.mirea.edu.practice14.service;

import org.springframework.stereotype.*;
import ru.mirea.edu.practice14.model.*;

import java.util.*;

@Service
public class MarketService {
    private final Map<Integer, Market> markets = new HashMap<>();
    private int count;

    public List<Market> getAllMarkets() {
        return markets.values().stream().toList();
    }

    public Market getMarket(Integer id) {
        return markets.get(id);
    }

    public Integer addMarket(Market market) {
        markets.put(count, market);
        count++;
        return count - 1;
    }

    public Market deleteMarket(Integer id) {
        return markets.remove(id);
    }
}
