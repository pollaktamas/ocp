package com.pollaktamas.designpatterns.builder;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal.AnimalBuilder().setAge(6).setSpecies("tiger").setFavoriteFoods(Arrays.asList("meat", "food")).build();
        System.out.println(animal);
    }
}
