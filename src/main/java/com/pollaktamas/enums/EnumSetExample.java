package com.pollaktamas.enums;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetExample {

    public static void main(String[] args) {
        Set<Planet> bigPlanets = EnumSet.of(Planet.SATURN, Planet.JUPITER);
        printPlanets(bigPlanets);
    }

    private static void printPlanets(Set<Planet> planets) {
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }
}
