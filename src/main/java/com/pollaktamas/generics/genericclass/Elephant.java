package com.pollaktamas.generics.genericclass;

public class Elephant {
    public static <T> T ship(T t) {
        System.out.println("Preparing " + t);
        return t;
    }
}
