package com.singh.rupesh.java8AndAbove.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
A common data processing idiom is to select information from certain objects. For example, in SQL you can select a
particular column from a table. The Streams API provides similar facilities through the map and flatMap methods.
Streams support the map method, which takes a function as argument. The function is applied to each element, mapping it
into a new element (the word mapping is used because it has a meaning similar to transforming but with the nuance of
“creating a new version of” rather than “modifying”)
 */
public class Mapping {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<Integer> dishNames = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(dishNames);

        //using flatMap
        //the flatMap method lets you replace each value of a stream with another stream and then concatenates all the
        // generated streams into a single stream.
        List<String> words = List.of("Hello", "World");

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        streamOfWords.forEach(System.out::println);

        List<String> word = words.stream()
                //Converts each word into an array of its individual letters
                .map(list -> list.split(""))
                //Flattens each generated stream into a single stream
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(word);

        /*
        Given two lists of numbers, how would you return all pairs of numbers? For example, given a list [1, 2, 3] and
        a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4),(3, 3), (3, 4)] and return only pairs whose sum
        is divisible by 3
         */
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs =
                numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                .map(j -> new int[] {i, j})
                ).collect(toList());

        for( int[] i : pairs) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("*******");
        pairs.forEach(i -> System.out.println(Arrays.toString(i)));

        //matching - anyMatch, allMatch, noneMatch - they all are boolean terminal operators and make use of short-circuiting
        /*
        In relation to streams, certain operations such as allMatch, noneMatch, findFirst, and findAny don’t need to
        process the whole stream to produce a result. As soon as an element is found, a result can be produced.
        Similarly, limit is also a short circuiting operation. The operation only needs to create a stream of a given size
        without processing all the elements in the stream. Such operations are useful (for example, when you need to deal
         with streams of infinite size, because they can turn an infinite stream into a stream of finite size)
         */
        boolean isVegetarian = menu.stream().anyMatch(Dish::isVegetarian);
        System.out.println(isVegetarian);

        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

        if(menu.stream().noneMatch(dish -> dish.getCalories() >= 1000)) {
            System.out.println("Food options are healthy");
        }

        // findAny, findFirst, findAll  are also short-circuit terminal operations
        //The Optional<T> class (java.util.Optional) is a container class to represent the existence or absence of a value
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        //
        dish.ifPresent(System.out::println);
        System.out.println(dish.get());
        // if present return the dish else return an default defined dish
        System.out.println(dish.orElse(new Dish("salmon", false, 450, Dish.Type.FISH)));

        //findFirst()
        // If we are using parallel stream if better to use findAny as finding the first element is more constraining in parallel.
        // If you don’t care about which element is returned, use findAny because it’s less constraining when using
        //parallel streams.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> firstSquareDivisibleBy3 = numbers.stream()
                .map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findFirst();
        firstSquareDivisibleBy3.ifPresent(System.out::println);
















    }
}
