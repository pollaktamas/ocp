package com.pollaktamas.advancedclassdesign.nestedclass.staticnested;

import com.pollaktamas.advancedclassdesign.nestedclass.staticnested.Enclosing.Nested;

public class Main {

    public static void main(String[] args) {
        System.out.println(Nested.width);

        Nested nested = new Nested();
        nested.printPrice();
    }
}
