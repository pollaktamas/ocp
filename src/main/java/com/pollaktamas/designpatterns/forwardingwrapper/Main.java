package com.pollaktamas.designpatterns.forwardingwrapper;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //Set<Date> s = new InstrumentedSet<Date>(new TreeSet<Date>(cmp));
        Set<String> s2 = new InstrumentedSet<String>(new HashSet<String>(50));
    }
}
