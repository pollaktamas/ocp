package com.pollaktamas.nestedclass.staticnested;

public class Main {

    public static void main(String[] args) {
        System.out.println(Enclosing.Nested.width);

        Enclosing.Nested nested = new Enclosing.Nested();
        nested.printPrice();
    }
}
