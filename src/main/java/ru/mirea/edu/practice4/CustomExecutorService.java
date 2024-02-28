package ru.mirea.edu.practice4;

import java.util.*;
import java.util.concurrent.*;

public class CustomExecutorService implements ExecutorService {
    private final int threadCount;
    private final Thread[] threads;
    private final Queue<Runnable> taskQueue;
    private volatile boolean isShutdown;

    public CustomExecutorService(int threadCount) {
        this.threadCount = threadCount;
        threads = new Thread[threadCount];
        taskQueue = new ArrayDeque<>();
        isShutdown = false;

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new WorkerThread();
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable command) {
        synchronized (taskQueue) {
            if (isShutdown) {
                throw new IllegalStateException("ExecutorService has been shut down");
            }
            taskQueue.add(command);
            taskQueue.notify();
        }
    }

    @Override
    public void shutdown() {
        synchronized (taskQueue) {
            isShutdown = true;
            taskQueue.notifyAll();
        }
    }

    @Override
    public List<Runnable> shutdownNow() {
        synchronized (taskQueue) {
            isShutdown = true;
            for (Thread thread : threads) {
                thread.interrupt();
            }
            List<Runnable> unfinishedTasks = new ArrayList<>(taskQueue);
            taskQueue.clear();
            return unfinishedTasks;
        }
    }

    @Override
    public boolean isShutdown() {
        return this.isShutdown;
    }

    @Override
    public boolean isTerminated() {
        boolean allThreadsTerminated = true;
        for (Thread thread : threads) {
            if (thread.isAlive()) {
                allThreadsTerminated = false;
                break;
            }
        }
        return isShutdown && allThreadsTerminated;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long endTime = System.currentTimeMillis() + unit.toMillis(timeout);
        synchronized (taskQueue) {
            while (!isTerminated() && System.currentTimeMillis() < endTime) {
                taskQueue.wait(endTime - System.currentTimeMillis());
            }
            return isTerminated();
        }
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        throw new UnsupportedOperationException("submit(Callable) is not implemented");
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        throw new UnsupportedOperationException("submit(Runnable, T) is not implemented");
    }

    @Override
    public Future<?> submit(Runnable task) {
        throw new UnsupportedOperationException("submit(Runnable) is not implemented");
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        throw new UnsupportedOperationException("invokeAll is not implemented");
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException("invokeAll with timeout is not implemented");
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        throw new UnsupportedOperationException("invokeAny is not implemented");
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new UnsupportedOperationException("invokeAny with timeout is not implemented");
    }

    private class WorkerThread extends Thread {
        public void run() {
            while (true) {
                Runnable task;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && !isShutdown) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (isShutdown) {
                        break;
                    }
                    task = taskQueue.poll();
                }

                task.run();
            }
        }
    }
}

