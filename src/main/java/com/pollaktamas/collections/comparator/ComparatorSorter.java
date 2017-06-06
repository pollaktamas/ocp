package com.pollaktamas.collections.comparator;

import com.pollaktamas.collections.comparable.Duck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorSorter {
    public static void main(String[] args) {
        Comparator<Duck> byWeight = new Comparator<Duck>() {
            public int compare(Duck d1, Duck d2) {
                return d1.getWeight()-d2.getWeight();
            }
        };

        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks);                      // [Puddles, Quack]
        Collections.sort(ducks, byWeight);
        System.out.println(ducks);                      // [Quack, Puddles]
    }
}
