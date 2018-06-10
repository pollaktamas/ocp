package com.pollaktamas.genericsandcollections.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key : map.keySet()) {
            System.out.print(key + ","); // koala,giraffe,lion,
        }

        System.out.println("----- * -----");

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("koala", "bamboo");
        treeMap.put("lion", "meat");
        treeMap.put("giraffe", "leaf");
        String koala = map.get("koala"); // bamboo
        for (String key: map.keySet()) {
            System.out.print(key + ","); // giraffe,koala,lion,
        }

        System.out.println("----- * -----");

        System.out.println(treeMap.containsKey("lion")); // true
        System.out.println(treeMap.containsValue("lion")); // false
        System.out.println(treeMap.size());
    }
}
