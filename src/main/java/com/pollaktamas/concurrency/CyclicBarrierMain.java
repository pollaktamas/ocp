package com.pollaktamas.concurrency;

import java.util.concurrent.*;

public class CyclicBarrierMain {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(1, () -> System.out.println("Barrier released!"));

        cyclicBarrier.await();
        cyclicBarrier2.await();

        // -----

        CyclicBarrier cyclicBarrierFor4 = new CyclicBarrier(4);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> cyclicBarrierFor4.await());
        executorService.submit(() -> cyclicBarrierFor4.await());
        executorService.submit(() -> cyclicBarrierFor4.await());
        executorService.submit(() -> cyclicBarrierFor4.await());
        executorService.shutdown();
    }
}
