package com.singh.rupesh.java8AndAbove.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String[] args) {

        List<String> strings = List.of("I", "am", "a", "list", "of", "strings");
        Stream<String> stream = strings.stream();
        Stream<String> only4Strings = stream.limit(4);
        //only4Strings.forEach(System.out::println);
        //Long result = only4Strings.count();
        //System.out.println("result is " + result);
        List<String> list = only4Strings.collect(Collectors.toList());
        System.out.println(list);

        List<String> result = strings.stream()
                                     .sorted((o1, o2) -> o1.compareToIgnoreCase(o2))
                                     .skip(2)
                                     .limit(4)
                                     //.filter()
                                     .collect(Collectors.toList());

        System.out.println("result = " + result);

    }


}
