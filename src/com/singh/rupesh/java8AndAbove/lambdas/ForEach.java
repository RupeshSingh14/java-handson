package com.singh.rupesh.java8AndAbove.lambdas;

import java.util.List;

public class ForEach {

    public static void main(String[] args) {

      List<String> colors = List.of("Red", "white", "orange", "green");

//        for (String color: colors) {
//            System.out.println(color);
//        }

        colors.forEach(color -> System.out.println(color));

    }


}
