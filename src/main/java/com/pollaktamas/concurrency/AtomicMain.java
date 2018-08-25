package com.pollaktamas.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMain {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(100);
        System.out.println(atomicInteger.get());

    }

    public void synchronizedBlock() {
        synchronized (this) {
            System.out.println("Sync block.");
        }
    }

    public synchronized void synchronizedMethod() {
        System.out.println("Sync method.");
    }
}
