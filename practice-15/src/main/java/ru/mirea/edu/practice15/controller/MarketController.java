package ru.mirea.edu.practice15.controller;

import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.practice15.model.*;
import ru.mirea.edu.practice15.service.*;


import java.util.*;

@RestController
@RequestMapping("/market")
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping()
    public List<Market> getAllMarkets() {
        return marketService.getAllMarkets();
    }

    @GetMapping("/{id}")
    public Market getMarket(@PathVariable String id) {
        return marketService.getMarket(id);
    }

    @PostMapping()
    public String addMarket(@RequestBody Market market) {
        return marketService.addMarket(market);
    }

    @DeleteMapping("/{id}")
    public void deleteMarket(@PathVariable String id) {
        marketService.deleteMarket(id);
    }
}
