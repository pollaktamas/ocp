package com.pollaktamas.genericsandcollections.collections.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCollectionMethods {

    public static void main(String[] args) {
        // RemoveIf
        removeIf();

        // Replace all
        replaceAll();

        // ForEach
        forEach();
    }

    private static void removeIf() {
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list);               // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list);               // [Magician]
    }

    private static void replaceAll() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list1.replaceAll(x -> x * 2);
        System.out.println(list1); // [2, 4, 6]
    }

    private static void forEach() {
        List<String> cats = Arrays.asList("Annie", "Ripley");
        cats.forEach(System.out::println);
    }
}
