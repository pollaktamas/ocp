package com.pollaktamas.functionalprogramming.streams;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {
        printIfHas3Digits(Optional.of(4567));
        printIfHas3Digits(Optional.of(123));
        printIfHas3Digits(Optional.ofNullable(null));
    }

    public static void printIfHas3Digits(Optional<Integer> optional) {
        optional.map(Object::toString)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }
}
