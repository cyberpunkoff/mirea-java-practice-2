package ru.mirea.edu.practice7.composite;

// Листовой компонент
class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }
}
