package com.pollaktamas.concurrency;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {
        reduce_accumulationAndCombineLogic();
        collect_accumulationAndCombineLogic();
        orderBasedOperations();
        collectorCharacteristics();
    }

    public void createParallelStreamFromExistingStream() {
        Stream<Integer> parallel = Stream.of(1, 2, 3).parallel();
    }

    public void createParallelStreamFromCollection() {
        Stream<Integer> parallelStream2 = Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream();
    }

    public static void reduce_accumulationAndCombineLogic() {

        Stream<Integer> stream = Stream.iterate(1, i -> ++i).limit(100);

        CopyOnWriteArrayList<Integer> reduce = stream.parallel().reduce(new CopyOnWriteArrayList<>(), (cwlist, i) -> {
            System.out.println("Accumulation-Thread-" + Thread.currentThread().getId() + " i: " + i);
            CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>(cwlist);
            integers.add(i);
            return integers;
        }, (cwlist1, cwlist2) -> {
            CopyOnWriteArrayList<Integer> objects = new CopyOnWriteArrayList<>();
            System.out.println("Combine-Thread-" + Thread.currentThread().getId() + " --- combine operation started on lists:");
            System.out.println("Combine-Thread-" + Thread.currentThread().getId() + " cwlist1: " + cwlist1);
            System.out.println("Combine-Thread-" + Thread.currentThread().getId() + " cwlist2: " + cwlist2);
            objects.addAll(cwlist1);
            objects.addAll(cwlist2);
            return objects;
        });

        System.out.println(reduce);
    }

    public static void collect_accumulationAndCombineLogic() {
        System.out.println("collect_accumulationAndCombineLogic");

        Stream<Integer> stream = Stream.iterate(1, i -> ++i).limit(100);

        CopyOnWriteArrayList<Integer> collect = stream.parallel().collect(CopyOnWriteArrayList::new,
                (r, i) -> {
                    System.out.println("Accumulation-Thread-" + Thread.currentThread().getId() + " i: " + i);
                    r.add(i);
                }, (r, r2) -> {
                    System.out.println("Combine-Thread-" + Thread.currentThread().getId() + " r: " + r);
                    System.out.println("Combine-Thread-" + Thread.currentThread().getId() + " r2: " + r2);
                    r.addAll(r2);
                });

        System.out.println(collect);
    }

    public static void orderBasedOperations() {
        System.out.println("orderBasedOperations");

        Stream<Integer> streamFindFirst = Stream.iterate(10, i -> ++i).parallel().limit(1000);
        System.out.println("findFirst: " + streamFindFirst.filter(i -> (i - 2) % 100 == 0).findFirst().get());

        //System.out.println("Skipped");
        //Stream<Integer> streamSkipped = Stream.iterate(1, i -> ++i).parallel().skip(90).limit(10);
        //System.out.println(streamSkipped.findFirst().get());

    }

    public static void collectorCharacteristics() {
        System.out.println(Collectors.toSet().characteristics());
    }
}
