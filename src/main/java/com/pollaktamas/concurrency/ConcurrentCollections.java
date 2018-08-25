package com.pollaktamas.concurrency;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConcurrentCollections {

    public static void main(String[] args) {

        BlockingQueue blockingQueue = new LinkedBlockingDeque();
    }

    public void synchronizedVersionsOfCollections() {
        List<Integer> integers = Collections.synchronizedList(Arrays.asList(1, 2, 3));
    }
}
