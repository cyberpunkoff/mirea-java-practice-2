package ru.mirea.edu.practice6.factory_method;

public class GoldGenerator extends ItemGenerator{
    @Override
    public GameItem createItem() {
        return new GoldReward();
    }
}
