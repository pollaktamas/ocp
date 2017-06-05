package com.pollaktamas.generics.wildcards.upperbound;

import java.util.ArrayList;
import java.util.List;

public class Upper {

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list)
            count += number.longValue();
        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(2));
        list.add(new Integer(5));
        System.out.println(total(list));
    }
}