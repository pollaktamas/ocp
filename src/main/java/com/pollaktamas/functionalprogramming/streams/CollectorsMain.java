package com.pollaktamas.functionalprogramming.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMain {

    public static void main(String[] args) {

        Stream<Integer> ints = Stream.of(1, 2, 3);

        List<Integer> collect3 = ints.collect(Collectors.toCollection(ArrayList::new));

        Double collect2 = ints.collect(Collectors.averagingInt(e -> e));
        Double collect1 = ints.collect(Collectors.averagingDouble(e -> e));
        Double collect = ints.collect(Collectors.averagingLong(e -> e));

        Long collect4 = ints.collect(Collectors.counting());

        Map<Integer, String> collect5 = ints.collect(Collectors.toMap(k -> k, Object::toString));
        Map<Integer, String> collect6 = ints.collect(Collectors.toMap(k -> k, Object::toString, (s1, s2) -> s1 + s2));
        TreeMap<Integer, String> collect7 = ints.collect(Collectors.toMap(k -> k, Object::toString, (s1, s2) -> s1 + s2, TreeMap::new));
    }
}
