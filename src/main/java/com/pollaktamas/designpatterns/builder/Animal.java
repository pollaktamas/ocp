package com.pollaktamas.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

public final class Animal {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    private Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", age=" + age +
                ", favoriteFoods=" + favoriteFoods +
                '}';
    }

    public static class AnimalBuilder {
        private String species;
        private int age;
        private List<String> favoriteFoods;

        public AnimalBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public AnimalBuilder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
            this.favoriteFoods = favoriteFoods;
            return this;
        }

        public Animal build() {
            return new Animal(species, age, favoriteFoods);
        }
    }
}
