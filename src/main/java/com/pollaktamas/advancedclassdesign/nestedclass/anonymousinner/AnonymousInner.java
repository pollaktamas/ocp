package com.pollaktamas.advancedclassdesign.nestedclass.anonymousinner;

public class AnonymousInner {

    abstract class Animal {
        abstract void shout();
    }

    interface Car {
        int getMaxSpeed();
    }

    public void shoutOut() {
        Animal tiger = new Animal() {
            @Override
            void shout() {
                System.out.println("Wrrrr!");
            }
        };

        tiger.shout();
    }

    public void useAnonymInnerParam() {
        printCarMaxSpeed(new Car() {
            @Override
            public int getMaxSpeed() {
                return 280;
            }
        });
    }

    public void printCarMaxSpeed(Car car) {
        System.out.println(car.getMaxSpeed());
    }

    public static void main(String[] args) {
        AnonymousInner anonymousInner = new AnonymousInner();
        anonymousInner.shoutOut();
        anonymousInner.useAnonymInnerParam();
    }
}
