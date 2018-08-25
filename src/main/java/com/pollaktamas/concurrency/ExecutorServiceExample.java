package com.pollaktamas.concurrency;

import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<?> submit = singleThreadExecutor.submit(() -> System.out.println());
        Callable<Integer> callable = () -> {
            throw new Exception();
        };

        schedulingTasks();
    }

    private static void schedulingTasks() {
        Runnable runnable = () -> System.out.println("Running.");
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(runnable, 1, TimeUnit.MINUTES);
        schedule.getDelay(TimeUnit.MINUTES);
    }
}
