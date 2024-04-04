package ru.mirea.edu.practice7.proxy;

public class Entity {
    private String heavyConnection;

    Entity(String url) {
        connect();
    }

    public String getConnection() {
        return this.heavyConnection;
    }

    public void connect() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.heavyConnection = "something";
        System.out.println("Established connection!");
    }
}
