package com.pollaktamas.advancedclassdesign.nestedclass.localinner;

public class Outer {
    private int length = 5;

    public void calculate() {
        final int width = 20;
        // Effectively final
        int factor = 10;
        class Inner {
            public void multiply() {
                System.out.println(length * width * factor);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.calculate();
    }
}