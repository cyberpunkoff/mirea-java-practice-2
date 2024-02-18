package ru.mirea.edu.practice2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HumanProcessor {
    public static String process(List<Human> humans) {
        return humans.stream()
                .sorted(Comparator.comparingInt(Human::getAge))
                .filter(human -> human.getAge() < 20)
                .filter(human -> human.getFirstName().contains("е"))
                .map(human -> human.getFirstName().charAt(0))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
