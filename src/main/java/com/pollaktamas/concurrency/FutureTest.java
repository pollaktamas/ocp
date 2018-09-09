package com.pollaktamas.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<?> submit = singleThreadExecutor.submit(() -> {
            throw new Exception();
        });

        Thread.sleep(1000);

        submit.get();

        singleThreadExecutor.shutdown();
    }
}
