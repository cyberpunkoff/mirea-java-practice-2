package ru.mirea.edu.practice6.factory_method;

public abstract class ItemGenerator {
    public void openReward() {
        GameItem gameItem = createItem();
        gameItem.open();
    }

    public abstract GameItem createItem();
}
