package ru.mirea.edu.practice6.builder;

import ru.mirea.edu.practice6.builder.model.CarType;
import ru.mirea.edu.practice6.builder.model.Color;
import ru.mirea.edu.practice6.builder.model.Engine;

public interface Builder {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setColor(Color color);
}
