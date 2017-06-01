package com.pollaktamas.interfaze;

public class Eagle implements Fly {
    public int getWingSpan() {
        return 15;
    }

    public void land() {
        System.out.println("Eagle is diving fast");
    }

    @Override
    public void takeOff() {
        System.out.println("TakeOff.");
    }
}