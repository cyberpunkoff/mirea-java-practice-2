package ru.mirea.edu.practice7.composite;

import java.util.ArrayList;
import java.util.List;

// Контейнерный компонент
class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite operation");
        for (Component component : components) {
            component.operation();
        }
    }
}
