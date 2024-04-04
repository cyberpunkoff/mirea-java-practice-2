package ru.mirea.edu.practice7.proxy;

public class EntityProxy {
    private Entity entity;
    private String url;

    EntityProxy(String url) {
        this.url = url;
    }

    public String getConnection() {
        if (entity == null) {
            entity = new Entity(url);
        }

        return entity.getConnection();
    }
}
