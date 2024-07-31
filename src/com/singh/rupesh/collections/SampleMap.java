package com.singh.rupesh.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Map Demo
 */
public class SampleMap {

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Rupesh", 07);
        scores.put("Pihu", 100);
        scores.put("Raunak", 82);

        System.out.println(scores);
        System.out.println(scores.get("Pihu"));

        System.out.println(scores.keySet());
        System.out.println(scores.entrySet());
        System.out.println(scores.containsValue(82));
        List<Map<String, Integer>> test = new ArrayList<>();
    }



}
