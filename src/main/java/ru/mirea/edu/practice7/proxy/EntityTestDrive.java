package ru.mirea.edu.practice7.proxy;

public class EntityTestDrive {
    public static void main(String[] args) {
        EntityProxy entity = new EntityProxy("test");
        entity.getConnection();
    }
}
