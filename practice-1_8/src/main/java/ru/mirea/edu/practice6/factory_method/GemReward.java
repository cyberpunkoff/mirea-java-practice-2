package ru.mirea.edu.practice6.factory_method;

public class GemReward implements GameItem {
    @Override
    public void open() {
        System.out.println("GemReward opened");
    }
}
