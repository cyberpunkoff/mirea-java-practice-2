package ru.mirea.edu.practice4;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;

public class CustomExecutorServiceTest {
    @Test
    void testExecuteTask() {
        ExecutorService threadPool = new CustomExecutorService(10);

        threadPool.execute(() -> System.out.println("Выполнение в собственном threadPool!"));
    }
}
