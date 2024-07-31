package com.singh.rupesh.java8AndAbove.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorMethodReferences {

    public static void main(String[] args) {

        // Using function to create many apple objects
        List<Integer> weights = Arrays.asList(7, 4, 3, 10);
        List<Apple> apples = map(weights, Apple::new);
        System.out.println(apples);

        //Using function to create an apple weight
        Function<Integer, Apple> f = Apple::new;
        Apple apple = f.apply(10);
        System.out.println(apple);

        //Using Bi function to create an apple with color and weight
        BiFunction<String, Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply("GREEN", 110);
        System.out.println(a3);



    }

    // A method which maps a list of integers as weight to create new apple objects for each
    private static <T, E> List<T> map(List<E> list, Function<E, T> f) {
        List<T> result = new ArrayList<>();
        for(E i : list) {
            result.add(f.apply(i));
        }
        return result;
    }
}

// A class apple for demo with 2 constructors
 class Apple {
    int weight;
    String color;

    public Apple(String color, int weight) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}
