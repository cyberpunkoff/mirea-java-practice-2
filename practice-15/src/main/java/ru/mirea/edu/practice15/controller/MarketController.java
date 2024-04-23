package ru.mirea.edu.practice15.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.practice15.model.*;
import ru.mirea.edu.practice15.service.*;


import java.util.*;

@RestController
@RequestMapping("/market")
public class MarketController {
    private final MarketService marketService;
    private final Logger logger = LoggerFactory.getLogger(MarketController.class);

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping()
    public List<Market> getAllMarkets() {
        logger.info("Get all markets called!");
        return marketService.getAllMarkets();
    }

    @GetMapping("/{id}")
    public Market getMarket(@PathVariable String id) {
        logger.info("Get market called for id {}", id);
        return marketService.getMarket(id);
    }

    @PostMapping()
    public String addMarket(@RequestBody Market market) {
        logger.info("Adding new market {}", market);
        return marketService.addMarket(market);
    }

    @DeleteMapping("/{id}")
    public void deleteMarket(@PathVariable String id) {
        logger.info("Deleting market {}", id);
        marketService.deleteMarket(id);
    }
}
