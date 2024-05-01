package ru.mirea.edu.practice15.service;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mirea.edu.practice15.model.Market;
import ru.mirea.edu.practice15.model.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ManagedResource
public class ScheduleService {
    private final JpaProductService productService;
    private final JpaMarketService marketService;
    private final static String DIR = "./db_entities";

    public ScheduleService(JpaProductService productService, JpaMarketService marketService) {
        this.productService = productService;
        this.marketService = marketService;
    }

    @Scheduled(cron = "*/30 * * * * *")
    @ManagedOperation
    public void doScheduledTask() {
        System.out.println("Doing scheduled task!");

        createDirectoryIfDoesntExist(DIR);
        clearDirectory(new File(DIR));
        saveEntitiesToFiles();

        System.out.println("Scheduled task done!");

    }

    private void createDirectoryIfDoesntExist(String path) {
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }

    private void saveEntitiesToFiles() {
        saveMarketsToFile();
        saveProductsToFile();
    }

    private void saveMarketsToFile() {
        List<Market> markets = marketService.getAllMarkets();

        String output = markets.stream()
                .map(Market::toString)
                .collect(Collectors.joining("\n"));

        writeToFile(DIR+"/markets.txt", output);
    }

    private void saveProductsToFile() {
        List<Product> markets = productService.getAllProducts();

        String output = markets.stream()
                .map(Product::toString)
                .collect(Collectors.joining("\n"));

        writeToFile(DIR+"/products.txt", output);
    }

    private void writeToFile(String fileName, String content) {
        try {
            Path newFilePath = Paths.get(fileName);
            Files.createFile(newFilePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
