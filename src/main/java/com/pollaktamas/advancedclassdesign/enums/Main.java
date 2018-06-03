package com.pollaktamas.advancedclassdesign.enums;

public class Main {
    public static void main(String[] args) {
        Season fall = Season.FALL;
        System.out.println(fall);
        System.out.println(fall == Season.FALL);

        for (Season season : Season.values()) {
            System.out.println(season);
        }

        Season fromString = Season.valueOf("FALL");
        fromString.printAbbreviation();
        fromString.printExpectedVisitors();

        Planet earth = Planet.EARTH;
        System.out.println(earth.surfaceGravity());

        printSurfaceWeightsOnAllPlanets(74);

        System.out.println(Operation.PLUS.apply(6, 4));
        System.out.println(Operation.TIMES.apply(5, 20));
    }

    private static void printSurfaceWeightsOnAllPlanets(double earthWeight) {
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
    }
}
