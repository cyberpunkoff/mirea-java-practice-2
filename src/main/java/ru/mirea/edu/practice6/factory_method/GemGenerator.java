package ru.mirea.edu.practice6.factory_method;

public class GemGenerator extends ItemGenerator{
    @Override
    public GameItem createItem() {
        return new GemReward();
    }
}
