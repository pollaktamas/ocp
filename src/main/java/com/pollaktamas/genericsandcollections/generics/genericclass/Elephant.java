package com.pollaktamas.genericsandcollections.generics.genericclass;

public class Elephant {
    public static <T> T ship(T t) {
        System.out.println("Preparing " + t);
        return t;
    }

    public static class ExtendedElephant extends Elephant {

    }
}
