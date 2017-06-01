package com.pollaktamas.generics.genericinterface;

public class Main {
    public static void main(String[] args) {
        ShippableAbstractCrate<Robot> shippable = new ShippableAbstractCrate<>();
        shippable.ship(new Robot());
    }
}
