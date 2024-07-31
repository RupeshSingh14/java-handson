package com.singh.rupesh.java8AndAbove.streams;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.Arrays.asList;

public class CollectorInterface {
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

        // using custom implementation of collector method
        List<Dish> dishes = menu.stream().collect(new ToListCollector<Dish>());
        System.out.println(dishes);

        /*
        In the case of an IDENTITY_FINISH collection operation, there’s a further possibility of obtaining the same result
        without developing a completely new implementation of the Collector interface. Streams has an overloaded collect
        method accepting the three other functions—supplier, accumulator, and combiner.
        NOTE that you’re not allowed to pass any Characteristics to this second collect method, so it always behaves as an
        IDENTITY_FINISH and CONCURRENT but not UNORDERED collector
         */
        List<Dish> dishes1 = menu.stream().collect(
                ArrayList::new,  //supplier
                List::add,       //accumulator
                List::addAll     //combiner
        );
        System.out.println(dishes1);
    }
}

//Creating a custom implementation of collector
class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT
        ));
    }
}