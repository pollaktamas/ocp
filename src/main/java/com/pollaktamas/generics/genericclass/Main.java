package com.pollaktamas.generics.genericclass;

public class Main {
    public static void main(String[] args) {
        Crate<Elephant> crate = new Crate<>();
        Elephant elephant = new Elephant();
        crate.packCrate(elephant);
        crate.emptyCrate();

        Elephant.ship(new Elephant());
        Elephant.<Elephant>ship(new Elephant());
    }
}
