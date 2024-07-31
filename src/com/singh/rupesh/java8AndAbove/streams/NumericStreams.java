package com.singh.rupesh.java8AndAbove.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {

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

        /*
        The problem with this code is that there’s an insidious boxing cost. Behind the scenes each Integer needs to be
        unboxed to a primitive before performing the summation
        So we can use IntStream, DoubleStream and LongStream by using functions like mapToInt, mapToDouble, mapToLong.
         */
        Long time = System.currentTimeMillis();
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        Long time1 = System.currentTimeMillis();
        //System.out.println(calories);

        Long time2 = System.currentTimeMillis();
        int calories1 = menu.stream()
                // the method mapToInt extracts all the calories from each dish (represented as an Integer) and returns
                // an IntStream as the result, if the stream were empty, sum would return 0 by default
                .mapToInt(Dish::getCalories)
                .sum();
        Long time3 = System.currentTimeMillis();

        //System.out.println(calories1);
        System.out.println("time taken with boxing: " +  (time1 - time) + " and time taken without boxing: " + (time3 - time2));

        // Stream to Int stream conversion having ints and converting it back to Integer using boxed()
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> dishStream = intStream.boxed();

        //There’s a primitive specialized version of Optional as well for the three primitive stream specializations:
        //OptionalInt, OptionalDouble, and OptionalLong which can be used in cases where we want a customized value in
        // case of default ie.. not 0, 0.00. 0.0L
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        //Provides an explicit default maximum if there’s no value
        int max = maxCalories.orElse(1);
        System.out.println(max);

        //IntStream and LongStream has 2 static methods for ranges: range (end exclusive) and rangeClosed (end inclusive)

        IntStream.rangeClosed(1,100)
                .dropWhile(i -> i < 95)
                .forEach(System.out::println);

         IntStream.range(1, 100)
                .dropWhile(i -> i < 95)
                .forEach(System.out::println);

         // using stream to create pythagoras triplets ie.. a^2 * b^2 = c^2
        Stream<int []> pythagoreanTriplets =
                IntStream
                        .rangeClosed(1, 100)
                        .boxed() // to change the IntStream to Stream
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                .mapToObj(b -> new int[] {a, b, (int) Math.sqrt(a*a + b*b)}) // this is same as boxed() + mapping
                                );

        pythagoreanTriplets.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        // writing the program more efficiently
        Stream<double []> pythagoreanTriplets1 =
                IntStream
                .rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                .mapToObj(b -> new double[] {a, b, Math.sqrt(a*a + b*b)})
                .filter(t -> t[2] % 1 == 0)); // filtering for whole number once at last

        pythagoreanTriplets1.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        //generating streams

        Stream<String> name = Stream.of("Hi,", "my", "name", "is", "Rupesh");
        name.forEach(System.out::println);

        // Empty stream
        Stream<String> emptyStream = Stream.empty();

        //Stream for nullable
        //In Java 9, a new method was added that lets you create a stream from a nullable object.
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream =
                homeValue == null ? Stream.empty() : Stream.of(homeValue);

        // better way
        Stream<String> homeValueStream1 = Stream.ofNullable(System.getProperty("home"));

        //This pattern can be particularly handy in conjunction with flatMap and a stream of
        //values that may include nullable objects
        String home = "pihu";
        String user = "pihu";
        System.setProperty(user, "Rupesh");
        System.setProperty(home, "/root");
        Stream<String> values =
                Stream.of("config", "home", "user")
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        System.out.println(System.getProperty(user));
        values.forEach(System.out::println); // FIXME: 13/07/2023 not working

        //Streams from arrays
        int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9};
        int sum = Arrays.stream(numbers).sum();

        //Streams from files
        //Streams are AutoCloseable. We can use stream on files using NIO and perform operations

        // method to find out the number of unique words in a file
        //Once you have a stream of lines, you can then split each line into words by calling the
        //split method on line. Notice how you use flatMap to produce one flattened stream of words.
        long uniqueWordsInFile;
        try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWordsInFile = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            System.out.println("No such file exists");
        }

        /*
        The Streams API provides two static methods to generate a stream from a function: Stream.iterate and Stream.generate.
        These two operations let you create what we call an infinite stream (unbounded stream)
         */

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        //fibonacci series that prints tuples
        Stream.iterate(new int[]{0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        //prints fibonacci series
        Stream.iterate(new int[] {0, 1},
                t -> new int[] {t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0]) // prints only t[0] values
                .forEach(System.out::println);

        //the iterate method was enhanced with support for a predicate in java 9
        IntStream.iterate(0, i -> i < 10, i -> i + 4)
                .forEach(System.out::println);

        //Similarly generate can be used but it doesn’t apply successively a function on each new produced value.
        // It takes a lambda of type Supplier<T> to provide new values
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);







    }
}
