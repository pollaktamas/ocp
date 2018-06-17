package com.pollaktamas.functionalprogramming.streams;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count()); // 3
    }
}
