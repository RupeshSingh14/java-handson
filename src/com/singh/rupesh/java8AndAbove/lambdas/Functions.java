package com.singh.rupesh.java8AndAbove.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//Demo of function usage
public class Functions {
    public static void main(String[] args) {
        List<String> listOfStrings = List.of("Rupesh", "", "Ram", "Raunak", "Riddhi", "Ratnesh", "", "Ranjesh");
        System.out.println(map(listOfStrings, s -> s.toUpperCase())); //String::toUpperCase
    }

    // A generic method that takes a list, a function to be applied on the list and returns a list as result with value of applied function.
    private static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T t: list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
