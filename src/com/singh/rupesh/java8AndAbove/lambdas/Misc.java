package com.singh.rupesh.java8AndAbove.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Misc {

    static Map<String, BiFunction<String, Integer, Fruit>> map = new HashMap<>();

    public static Fruit giveMeFruit(String fruit, Integer weight){
        return map.get(fruit.toLowerCase())
                .apply(fruit, weight);
    }

    public static void main(String[] args) {
            map.put("apple", Fruit::new);
            map.put("orange", Fruit::new);
        System.out.println(giveMeFruit("apple", 10));
    }

}

class Fruit {
    String name;
    Integer weight;

    public Fruit(Integer weight) {
        this.weight = weight;
    }

    public Fruit(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                '}';
    }
}