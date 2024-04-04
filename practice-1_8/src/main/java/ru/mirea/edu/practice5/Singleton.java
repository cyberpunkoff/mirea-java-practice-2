package ru.mirea.edu.practice5;

public enum Singleton {
    INSTANCE;

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
