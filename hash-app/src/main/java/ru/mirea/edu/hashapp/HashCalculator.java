package ru.mirea.edu.hashapp;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class HashCalculator implements CommandLineRunner {
    private String inputFilePath;
    private String outputFilePath;

    @Override
    public void run(String... args) throws Exception {
        this.inputFilePath = getFilePath(args[0]);
        this.outputFilePath = getFilePath(args[1]);


        System.out.println(inputFilePath);

        createFile(outputFilePath);

        if (Files.exists(Path.of(inputFilePath))) {
            byte[] hash = hashFile(inputFilePath);
            String hashHex = bytesToHex(hash);
            writeText(outputFilePath, hashHex);
        } else {
            writeText(outputFilePath, "null");
        }
    }

    private void createFile(String fileName) {
        try {
            Files.createFile(Path.of(fileName).toAbsolutePath());
        } catch (FileAlreadyExistsException ignored) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeText(String fileName, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.append(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void preDestroy() {
        deleteFile(inputFilePath);
    }

    private void deleteFile(String fileName) {
        try {
            Files.deleteIfExists(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] hashFile(String fileName) {
        byte[] fileBytes = readFile(fileName);
        return calculateHash(fileBytes);
    }

    private byte[] readFile(String fileName) {
        try (FileInputStream reader = new FileInputStream(fileName)) {
            return reader.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] calculateHash(byte[] data) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return digest.digest(data);
    }

    private String getFilePath(String fileName) {
        return fileName;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
