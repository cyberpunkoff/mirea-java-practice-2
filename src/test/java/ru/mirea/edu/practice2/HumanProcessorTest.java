package ru.mirea.edu.practice2;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HumanProcessorTest {
    @Test
    void testHumanProcessor() {
        List<Human> humans = List.of(
                new Human("Семён", "Петров", LocalDate.of(2006, 2, 10), 90),
                new Human("Евгений", "Черемушкин", LocalDate.of(2005, 2, 10), 68),
                new Human("Никита", "Максимов", LocalDate.of(1995, 5, 17), 79)
        );

        String result = HumanProcessor.process(humans);

        assertThat(result).isEqualTo("СЕ");
    }
}
