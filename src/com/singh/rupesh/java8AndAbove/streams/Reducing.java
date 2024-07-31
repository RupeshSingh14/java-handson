package com.singh.rupesh.java8AndAbove.streams;

import java.util.List;
import java.util.Optional;

/*
A chain of map and reduce is commonly known as the map-reduce pattern, made famous by Google’s use of it for web
searching because it can be easily parallelized
 */
public class Reducing {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 3, 4, 5, 6, 7, 9);

        // reduce option used earlier using for each which uses a mutable variable sum which will cause issues to parallelize this operation
        int sum = 0; // declaring initial value
        for (int x : numbers) {
            sum += x;
        }
        System.out.println(sum);

        int sum1 = numbers.stream().reduce(0, (a,b) -> a + b);
        System.out.println(sum1);

        //From Java 8 the Integer class now comes with a static sum method to add two numbers
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        //an overloaded variant of reduce that doesn’t take an initial value, but it returns an Optional object
        Optional<Integer> sum3 = numbers.stream().reduce(Integer::sum);
        sum3.ifPresent(System.out::println);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);

        // Min
        Optional<Integer> min = numbers.stream().reduce((x, y) -> x < y ? x : y);
        Optional<Integer> min1 = numbers.stream().reduce(Integer::min);
        System.out.println(min.get());
        min1.ifPresent(System.out::println);
        // Max
        Optional<Integer> max = numbers.stream().reduce((x, y) -> x < y ? y : x);
        Optional<Integer> max1 = numbers.stream().reduce(Integer::max);
        System.out.println(max.orElse(100));
        max1.ifPresent(System.out::println);

    }
}
