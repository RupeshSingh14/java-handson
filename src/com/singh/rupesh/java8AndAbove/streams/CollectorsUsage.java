package com.singh.rupesh.java8AndAbove.streams;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class CollectorsUsage {
    public static void main(String[] args) {
        List<Dish> menu = asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        //counting dishes
        long howManyDishes = menu
                .stream()
                .collect(counting());

        // better way
        long howManyDishes1 = menu
                .size();

        //using maxBy() and minBy()
        Optional<Dish> mostCalorieDish = menu
                .stream()
                .collect(maxBy(Comparator.comparing(Dish::getCalories)));

        mostCalorieDish.ifPresent(System.out::println);

        // summarization
        // using summingInt() - to sum values
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories)); // better replaced with mapToInt(Dish::getCalories).sum()
        System.out.println(totalCalories);

        // averagingInt() - to get the average of any values
        Double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        // summarizingInt() - to get all the data related to values
        IntSummaryStatistics menuStatistics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));

        System.out.println(menuStatistics);

        // joining - concatenates toString all the items by internally making use of a StringBuilder to append the generated
        //strings into one
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu);

        String shortMenu1 = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu1);

        //The Collectors.reducing factory method is a generalization of all of them stated above
        int totalCalories1 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        int totalCalories2 = menu.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j); // also valid
        System.out.println(totalCalories1);

        Optional<Dish> mostCalorieDish1 = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        Optional<Dish> mostCalorieDish2 = menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);


        /*
        Basic understanding of selecting collect or reduce for usage is that reduce method is meant to combine two values and
        produce a new one; it’s an immutable reduction. In contrast, the collect method is designed to mutate a container to
        accumulate the result it’s supposed to produce.

        This is the main reason why the collect method is useful for expressing reduction working on a mutable container
         */

        int totalCalories3 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        int totalCalories4 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();

        int totalCalories5 = menu.stream().mapToInt(Dish::getCalories).sum();

        //grouping
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        // grouping on basis of custom grouping classifications
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =
                menu.stream().collect(
                        groupingBy(dish -> {
                            if (dish.getCalories() < 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })
                );

        System.out.println(dishesByCaloricLevel);

        //using filtering() in groupBy()
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println(caloricDishesByType);

        //using mapping() in groupBy()
        Map<Dish.Type, List<String>> dishNamesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        System.out.println(dishNamesByType);

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        Map<Dish.Type, Set<String>> dishNamesByType1 = menu.stream()
                .collect(groupingBy(Dish::getType, flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));

        System.out.println(dishNamesByType1);

        // Multilevel Grouping
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeAndCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                }))
                );

        System.out.println(dishesByTypeAndCaloricLevel);

        //Collecting data in subgroups
        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));

        System.out.println(typesCount);

        /*
        The values in this Map are Optionals because this is the resulting type of the collector generated by the maxBy factory method,
        but in reality if there’s no Dish in the menu for a given type, that type won’t have an Optional.empty() as value;
        it won’t be present at all as a key in the Map. The grouping By collector lazily adds a new key in the grouping Map only the first
        time it finds an element in the stream, producing that key when applying on it the grouping criteria being used. This means
        that in this case, the Optional wrapper isn’t useful, because it’s not modeling a value that could be possibly absent but is
        there incidentally, only because this is the type returned by the reducing collector
         */
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

        System.out.println(mostCaloricByType);

        //ADAPTING THE COLLECTOR RESULT TO A DIFFERENT TYPE by using Collectors.collectingAndThen()
        Map<Dish.Type, Dish> mostCaloricByType1 =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get
                                )));

        System.out.println(mostCaloricByType1);

        // using summing inside grouping
        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));

        // using mapping inside grouping
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                },
                                toSet())));

        // using toCollection() to specify type of set to be used.
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType1 =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                },
                                toCollection(HashSet::new))));

        //Partitioning
        /*
        Partitioning is a special case of grouping: having a predicate called a partitioning function as a classification
        function. The fact that the partitioning function returns a boolean means the resulting grouping Map will have a
        Boolean as a key type, and therefore, there can be at most two different groups — one for true and one for false
         */
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        System.out.println(partitionedMenu);
        System.out.println(partitionedMenu.get(true));

        // alternative
        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());

        //Partitioning has the advantage of keeping both lists of the stream elements, for which
        //the application of the partitioning function returns true or false

        //Here the grouping of the dishes by their type is applied individually to both of the
        //substreams of vegetarian and nonvegetarian dishes resulting from the partitioning
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType))
                );

        System.out.println(vegetarianDishesByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));

        System.out.println(mostCaloricPartitionedByVegetarian);

        System.out.println(partitionPrimes(50));

    }

    //Partitioning numbers into prime or non prime
    public static boolean isPrime(int number) {
        int numberRoot = (int) Math.sqrt((double) number);
        return IntStream.rangeClosed(2, numberRoot)
                .noneMatch(i -> number % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(candidate -> isPrime(candidate)));
    }


}
