package com.pollaktamas.enums;

public class EnumMain {
    public static void main(String[] args) {
        Season fall = Season.FALL;
        System.out.println(fall);
        System.out.println(fall == Season.FALL);

        for (Season season: Season.values()){
            System.out.println(season);
        }

        Season fromString = Season.valueOf("FALL");
        fromString.printAbbreviation();
        fromString.printExpectedVisitors();
    }
}
