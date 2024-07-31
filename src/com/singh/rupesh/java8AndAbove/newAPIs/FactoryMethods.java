package com.singh.rupesh.java8AndAbove.newAPIs;

import java.util.*;

import static java.util.Map.entry;

/*
Unless you need to set up some form of data processing and transformation of the data, it is recommended to use the factory methods;
they’re simpler to use, and the implementation of the factory methods is simpler and more adequate.
 */
public class FactoryMethods {

    public static void main(String[] args) {

        /*
        a fixed-sized list that you can update, but not add elements to or remove elements from. Attempting to add
        elements, for example, results in an UnsupportedModificationException, but updating by using the method set is allowed
         */
        List<String> friends = Arrays.asList("Rupesh", "Raunak", "Riddhi");
        friends.set(0, "Ranjesh");
       // friends.add("Ratnesh"); //throws error
        System.out.println(friends);

        /*
        Returns an unmodifiable list containing three elements ie.. can't update or add to list
         */
        List<String> family = List.of("Ranjesh", "Raunak", "Riddhi");
        //family.set(0, "Rupesh");

        // Using Set.of to create unmodifiable set
        Set<String> friends1 = Set.of("Ram", "Ramesh", "Rajesh");
        System.out.println(friends1);

        //For map - Map.of and Map.ofEntries
        Map<String, Integer> ageOfFriends = Map.of("Ram", 30,"Ramesh", 43,"Raj", 23);
        System.out.println(ageOfFriends);

        // To go beyond 10 key, values, use the alternative factory method called Map.ofEntries, which takes Map.Entry<K, V>
        // objects but is implemented with varargs
        Map<String, Integer> ageOfFriends1 = Map.ofEntries(entry("Rupesh", 32),
                entry("Rahul", 28),
                entry("Raj", 34));

        System.out.println(ageOfFriends1);

/*
removeIf - removes element matching a predicate. It’s available on all classes
that implement List or Set (and is inherited from the Collection interface).
replaceAll - is available on List and replaces elements using a (UnaryOperator)
function.
sort - is also available on the List interface and sorts the list itself
 */

        //forEach in MAPS
        //without stream
        for(Map.Entry<String, Integer> entry: ageOfFriends.entrySet()) {
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + " is " + age + " years old.");
        }

        //with stream
        ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " + age + " years old."));
        System.out.println(ageOfFriends.entrySet());

        // sorting in Maps using comparingByKey()
        ageOfFriends.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        // sorting using comparingByValue()
        ageOfFriends.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((a,b) -> b.compareTo(a)))
                .forEach(System.out::println);

        // getOrDefault to handle null scenarios
        /*
        Note that if the key existed in the Map but was accidentally associated with a null value, getOrDefault can still
        return null. Also note that the expression you pass as a fallback is always evaluated, whether the key exists or not
         */
        Map<String, String> favouriteMovies
                = Map.ofEntries(entry("Raphael", "Star Wars"),
                entry("Olivia", "James Bond"));

        System.out.println(favouriteMovies.getOrDefault("Olivia", "Matrix"));
        System.out.println(favouriteMovies.getOrDefault("Thibaut", "Matrix"));

        /*
        computeIfAbsent—If there’s no specified value for the given key (it’s absent or its value is null), calculate a
        new value by using the key and add it to the Map.
        computeIfPresent—If the specified key is present, calculate a new value for it and add it to the Map.
        compute—This operation calculates a new value for a given key and stores it in the Map
         */

        // replacement patterns
        Map<String, String> favouriteMovies1 = new HashMap<>();
        favouriteMovies1.put("Raphael", "Star Wars");
        favouriteMovies1.put("Olivia", "james bond");
        favouriteMovies1.replaceAll((friend, movie) -> movie.toUpperCase());
        System.out.println(favouriteMovies1);























    }
}
