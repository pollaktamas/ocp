package com.pollaktamas.generics.genericinterface;

public class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) {
        System.out.println("ShippableAbstractCrate > ship");
    }
}
