package com.pollaktamas.functionalprogramming.methodreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Comparator<Duck> byWeightWithLambda = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
        Comparator<Duck> byWeightWithMethodReference = DuckHelper::compareByWeight;

        // Static methods
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);
        Consumer<List<Integer>> anonymClass = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                Collections.sort(integers);
            }
        };

        // Instance methods on a particular instance
        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);

        // Instance methods on an instance to be determined at runtime
        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();

        // Constructors
        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();
    }
}
