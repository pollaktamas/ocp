package com.pollaktamas.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

    public static void main(String[] args) {
        recursiveActionExample();
        recursiveTaskExample();
    }

    private static void recursiveActionExample() {
        Double[] weights = new Double[10];
        ForkJoinTask<?> task = new WeighAnimalAction(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        // Print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));
    }

    private static void recursiveTaskExample() {
        Double[] weights = new Double[10];
        ForkJoinTask<Double> task = new WeighAnimalTask(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(task);
        System.out.println("Sum: " + sum);
    }
}

class WeighAnimalAction extends RecursiveAction {
    private int start;
    private int end;
    private Double[] weights;

    public WeighAnimalAction(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    protected void compute() {
        if (end - start <= 3)
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(200);
                System.out.println("Animal Weighed: " + i);
            }
        else {
            int middle = start + ((end - start) / 2);
            System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
            invokeAll(new WeighAnimalAction(weights, start, middle),
                    new WeighAnimalAction(weights, middle, end));
        }
    }
}

class WeighAnimalTask extends RecursiveTask<Double> {
    private int start;
    private int end;
    private Double[] weights;

    public WeighAnimalTask(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    protected Double compute() {
        if (end - start <= 3) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
                sum += weights[i];
            }
            return sum;
        } else {
            int middle = start + ((end - start) / 2);
            System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");

            RecursiveTask<Double> otherTask = new WeighAnimalTask(weights, start, middle);
            otherTask.fork();

            // Azért csak az egyik taszk fork+join jellegű, mert az fusson külön szálban
            // viszont van egy akutális szálunk is, az pedig elvégezheti az egyik új feladatot
            return new WeighAnimalTask(weights, middle, end).compute() + otherTask.join();
        }
    }
}