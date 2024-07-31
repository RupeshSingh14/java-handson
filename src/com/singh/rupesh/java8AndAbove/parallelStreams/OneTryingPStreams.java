package com.singh.rupesh.java8AndAbove.parallelStreams;

import java.util.stream.LongStream;
import java.util.stream.Stream;

//choosing the right data structures is often more important than parallelizing the algorithm that uses them
public class OneTryingPStreams {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        long t1 = System.currentTimeMillis();
        System.out.println(parallelSum1(10000000L));
        long t2 = System.currentTimeMillis();
        System.out.println(parallelSum2(10000000L));
        long t3 = System.currentTimeMillis();

        System.out.println(t2 -t1);
        System.out.println(t3 - t2);

    }

    static long sequentialStream(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    static long parallelSum1(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    // best parallelism
    /*
    LongStream.rangeClosed works on primitive long numbers directly so there’s no boxing and unboxing overhead
     LongStream.rangeClosed produces ranges of numbers, which can be easily split into independent chunks.
     For example, the range 1–20 can be split into 1–5, 6–10, 11–15, and 16–20.
     The numeric stream is much faster than the earlier sequential version, generated with the iterate factory method,
     because the numeric stream avoids all the overhead caused by all the unnecessary autoboxing and auto-unboxing operations performed
     by the non specialized stream.
     */
    static long parallelSum2(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
        }

}
