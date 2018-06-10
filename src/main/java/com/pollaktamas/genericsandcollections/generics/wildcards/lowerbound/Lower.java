package com.pollaktamas.genericsandcollections.generics.wildcards.lowerbound;

import java.util.ArrayList;
import java.util.List;

public class Lower {

    public static void main(String[] args) {
        List<? super String> my = new ArrayList<>();
        my.add("first");

        // Does not compile
        //my.add(new Object());
    }
}
