package ru.mirea.edu.practice1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public class MyConsumerTest {
    @ParameterizedTest
    @CsvSource({
            "abc,abC",
            "abobab,abObaB",
            "ab,ab"
    })
    void shouldChangeAllThirdLetterToUpperCase(String input, String expected) {
        Consumer<String> consumer = new MyConsumer();
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        consumer.accept(input);

        assertThat(outputStreamCaptor.toString().strip()).isEqualTo(expected);
    }
}
