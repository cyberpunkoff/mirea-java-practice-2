package ru.mirea.edu.practice2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HumanProcessor {
    public static String process(List<Human> humans) {
        return humans.stream()
                .sorted(Comparator.comparingInt(Human::getAge))
                .peek(e -> System.out.println("Sorted: " + e))
                .filter(human -> human.getAge() < 20)
                .peek(e -> System.out.println("Age less 20 : " + e))
                .filter(human -> human.getFirstName().contains("е"))
                .peek(e -> System.out.println("Name contains е : " + e))
                .map(human -> human.getFirstName().charAt(0))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
