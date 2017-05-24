package com.pollaktamas.nestedclass.memberinner;

public class Outer {
    private String greeting;
    private Inner inner;

    public Outer(String greeting) {
        this.greeting = greeting;
    }

    public class Inner {
        public int repeat = 3;

        public void go() {
            for (int i = 0; i < repeat; i++) {
                System.out.println(greeting);
            }
        }
    }

    public void callInner() {
        inner.go();
    }

    public Inner initInner() {
        inner = new Inner();
        return inner;
    }
}