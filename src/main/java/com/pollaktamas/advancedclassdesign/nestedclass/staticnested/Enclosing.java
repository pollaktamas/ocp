package com.pollaktamas.advancedclassdesign.nestedclass.staticnested;

public class Enclosing {
    static class Nested {
        private int price = 6;
        static int width = 100;

        void printPrice() {
            System.out.println(price);
        }
    }
}
