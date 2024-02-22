package ru.mirea.edu.practice3;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SynchronizedSetTest {
    @Test
    void testRaceCondition() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Set<Integer> set = new SynchronizedSet<>();

        Thread first = new Thread(() -> {
            IntStream.range(0, 10_000).forEach(set::add);
            countDownLatch.countDown();
        });

        Thread second = new Thread(() -> {
            IntStream.range(0, 10_000).forEach(set::add);
            countDownLatch.countDown();
        });

        first.start();
        second.start();

        countDownLatch.await();

        assertThat(set.size()).isEqualTo(10000);
    }
}
