package com.pollaktamas.collections.comparator;

import com.pollaktamas.collections.comparable.Duck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MultipleFieldComparator {
    public static void main(String[] args) {
        Comparator<Duck> multiple = new Comparator<Duck>() {
            @Override
            public int compare(Duck o1, Duck o2) {
                Comparator<Duck> c = Comparator.comparing(d -> d.getName());
                c = c.thenComparingInt(d -> d.getWeight());
                return c.compare(o1, o2);
            }
        };

        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Puddles", 12));
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks);
        Collections.sort(ducks, multiple);
        System.out.println(ducks);
    }
}
