package ru.mirea.edu.practice1;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        char[] chars = s.toCharArray();

        for (int i = 2; i < chars.length; i += 3) {
            chars[i] = Character.toUpperCase(chars[i]);
        }

        System.out.println(chars);
    }
}
