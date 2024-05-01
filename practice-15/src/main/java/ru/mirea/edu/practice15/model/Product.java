package ru.mirea.edu.practice15.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    private String name;
    private int price;
    @ManyToOne
    private Market market;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", market=" + market +
                '}';
    }
}
