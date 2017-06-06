package com.pollaktamas.collections.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapMethods {

    public static void main(String[] args) {

        // PutIfAbsent
        putIfAbsent();

        // Merge
        merge();

        // ComputeIfPresent
        computeIfPresent();

        // ComputeIfAbsent
        computeIfAbsent();
    }

    private static void putIfAbsent() {
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites);          // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
    }

    private static void merge() {
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1: v2;

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        favorites.put("Anne", null);

        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);
        String anne = favorites.merge("Anne", "Sightseeing", mapper);

        System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny); // Bus Tour
        System.out.println(tom); // Skyride
        System.out.println(anne); // Sightseeing
    }

    private static void computeIfPresent() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
        Integer jenny = counts.computeIfPresent("Jenny", mapper);
        Integer sam = counts.computeIfPresent("Sam", mapper);
        System.out.println(counts);                                 // {Jenny=2}
        System.out.println(jenny);                                  // 2
        System.out.println(sam);                                    // null
    }

    private static void computeIfAbsent() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 15);
        counts.put("Tom", null);
        Function<String, Integer> mapper = (k) -> 1;
        Integer jenny = counts.computeIfAbsent("Jenny", mapper); // 15
        Integer sam = counts.computeIfAbsent("Sam", mapper); // 1
        Integer tom = counts.computeIfAbsent("Tom", mapper); // 1
        System.out.println(counts); // {Tom=1, Jenny=15, Sam=1}
    }
}
