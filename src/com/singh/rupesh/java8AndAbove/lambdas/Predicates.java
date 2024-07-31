package com.singh.rupesh.java8AndAbove.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Demo of predicate usage
public class Predicates {

    public static void main(String[] args) {

        List<String> listOfStrings = List.of("Rupesh", "", "Ram", "Raunak", "Riddhi", "Ratnesh", "", "Ranjesh");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();

        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        List<String> nonEmpty2 = filter(listOfStrings, (String s) -> !s.isEmpty());
        System.out.println(nonEmpty);
        System.out.println(nonEmpty2);
    }

    // A generic method that takes a list, a predicate condition to apply on the list and returns an array list with the filtered values.
    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T t: list) {
            if(p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }
}