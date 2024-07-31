package com.singh.rupesh.java8AndAbove.streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Filtering {
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

        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName() );
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());

        System.out.println(names);

        // filter() uses predicate
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        System.out.println(vegetarianMenu);

        // distinct() uses equals and hashcode for checking for duplicates
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // ordered list of dishes as per calories
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));


        // takeWhile stops once it has found an element that fails to match
        // useful in sorted list of data
        List<Dish> lessCalorieDishes = specialMenu.stream()
                 .takeWhile(dish -> {
                    System.out.println("take while: " + dish.getName());
                    return dish.getCalories() < 320;
                })
                .collect(toList());
        System.out.println(lessCalorieDishes);

        // dropWhile is complement of takeWhile. It stops once it has found an element that fails to match and gives the latter part
        // useful in sorted list of data
        List<Dish> MoreCalorieDishes = specialMenu.stream()
                .dropWhile(dish -> {
                    System.out.println("drop while: " + dish.getName());
                    return dish.getCalories() < 320;
                })
                .collect(toList());
        System.out.println(MoreCalorieDishes);

        // truncating the list is done by limit and skip
        // skip(n) method to return a stream that discards the first n elements.
        // If the stream has fewer than n elements, an empty stream is returned. Note that limit(n) and skip(n) are complementary!
                List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 500)
                        //.skip(2)
                .limit(3)
                .collect(toList());
        System.out.println(dishes);
    }

}
