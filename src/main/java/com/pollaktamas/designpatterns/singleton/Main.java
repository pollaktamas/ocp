package com.pollaktamas.designpatterns.singleton;

public class Main {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton other = Singleton.getInstance();
        System.out.println(singleton == other);
    }
}
