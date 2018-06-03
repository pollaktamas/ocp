package com.pollaktamas.advancedclassdesign.enums;

public enum Season {

    WINTER("LOW") {
        public void printAbbreviation() {
            System.out.println("W");
        }
    },
    SPRING("MEDIUM") {
        public void printAbbreviation() {
            System.out.println("SP");
        }
    },
    SUMMER("HIGH") {
        public void printAbbreviation() {
            System.out.println("SU");
        }
    },
    FALL("MEDIUM") {
        public void printAbbreviation() {
            System.out.println("F");
        }
    };

    private String expectedVisitors;

    Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
        System.out.println("Enum value created with expected visitors: " + expectedVisitors);
    }

    abstract void printAbbreviation();

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}


