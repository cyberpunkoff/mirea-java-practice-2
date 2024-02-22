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

        IntStream.range(0, 500).forEach(set::add);

        Thread first = new Thread(() -> {
//            IntStream.range(500, 6000).forEach(set::add);
            for (int i = 500; i < 600; i++) {
                set.add(i);
            }
            countDownLatch.countDown();
        });

        Thread second = new Thread(() -> {
//            IntStream.range(500, 6000).forEach(set::remove);
            for (int i = 500; i < 600; i++) {
                set.remove(i);
            }
            countDownLatch.countDown();
        });

        first.start();
        second.start();

        countDownLatch.await();

        assertThat(set.size()).isEqualTo(500);
    }
}
