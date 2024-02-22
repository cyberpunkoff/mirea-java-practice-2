package ru.mirea.edu.practice3;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;

public class SynchronizedListTest {
    @Test
    public void testRaceCondition() throws InterruptedException {
        List<Integer> list = new SynchronizedList<>();
        CountDownLatch latch = new CountDownLatch(2);

        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                list.add(i);
            }
            latch.countDown();
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                list.removeFirst();
            }
            latch.countDown();
        });

        thread1.start();
        thread2.start();

        latch.await();

        assertThat(list.size()).isEqualTo(10000);
    }
}

