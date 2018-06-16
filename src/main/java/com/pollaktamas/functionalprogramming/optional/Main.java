package com.pollaktamas.functionalprogramming.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<Double> opt0 = average(90, 100);
        if (opt0.isPresent()) {
            System.out.println(opt0.get());
        }

        // Empty optional
        System.out.println(average());

        // ifPresent
        Optional<Double> opt1 = average(90, 100);
        opt1.ifPresent(System.out::println);

        Optional<Object> empty = Optional.empty();
        Optional<Integer> integer = Optional.of(6);
        Optional<Object> o = Optional.ofNullable(null);

        // Other methods
        Optional<Double> opt2 = average();
        System.out.println(opt2.orElse(Double.NaN));
        System.out.println(opt2.orElseGet(() -> Math.random()));
        System.out.println(opt2.orElseThrow(() -> new IllegalStateException()));
    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length);
    }

}
