package com.pollaktamas.interfaze;

public class Main {

    public static void main(String[] args) {
        Eagle eagle = new Eagle();

        System.out.println(eagle.getWingSpan());
        eagle.land();

        System.out.println(Fly.calculateSpeed(200, 4));
    }
}
