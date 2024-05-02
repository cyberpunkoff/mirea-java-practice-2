package ru.mirea.edu.practice15.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Market {
    @Id
    private String name;
    private String address;
    @OneToMany(mappedBy = "market")
    private Set<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
