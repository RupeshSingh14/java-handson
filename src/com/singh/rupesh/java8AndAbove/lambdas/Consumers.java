package com.singh.rupesh.java8AndAbove.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//Demo of consumer usage
public class Consumers {

    public static void main(String[] args) {
        List<String> listOfStrings = List.of("Rupesh", "", "Ram", "Raunak", "Riddhi", "Ratnesh", "", "Ranjesh");
        forEach(listOfStrings, s -> System.out.println(s));
    }

    // A generic method that takes a list, a consumer action to be performed on the list and returns void ie. performs some action.
    private static <T> void forEach(List<T> list, Consumer<T> c) {
        List<T> results = new ArrayList<>();
        for(T t: list) {
            c.accept(t);
            }
    }
}
