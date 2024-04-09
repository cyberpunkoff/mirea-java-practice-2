package ru.mirea.edu.practice14.controller;

import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.practice14.model.*;
import ru.mirea.edu.practice14.service.*;

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
    public Market getMarket(@PathVariable Integer id) {
        return marketService.getMarket(id);
    }

    @PostMapping()
    public Integer addMarket(@RequestBody Market market) {
        return marketService.addMarket(market);
    }

    @DeleteMapping("/{id}")
    public Market deleteMarket(@PathVariable Integer id) {
        return marketService.deleteMarket(id);
    }
}
