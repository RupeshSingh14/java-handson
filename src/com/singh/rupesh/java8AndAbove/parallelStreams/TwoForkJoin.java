package com.singh.rupesh.java8AndAbove.parallelStreams;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

// implementing fork join framework class
public class TwoForkJoin {
    public static void main(String[] args) {
        System.out.println(forkJoinSum(100000000L));
    }

    /*
     Note that in a real-world application, it doesn’t make sense to use more than one ForkJoinPool. For this reason,
     what you typically should do is instantiate it only once and keep this instance in a static field, making it a
     singleton, so it could be conveniently reused by any part of your software.
     Here, to create it you’re using its default no-argument constructor, meaning that you want to allow the pool to use
     all the processors available to the JVM. More precisely, this constructor will use the value returned by
     Runtime.availableProcessors to determine the number of threads used by the pool.
     */
    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);

    }
}

/*
When you pass the ForkJoinSumCalculator task to the ForkJoinPool, this task is executed by a thread of the pool that in
turn calls the compute method of the task. This method checks to see if the task is small enough to be performed sequentially;
 otherwise, it splits the array of numbers to be summed into two halves and assigns them to two new ForkJoinSumCalculators
 that are scheduled to be executed by the ForkJoinPool. As a result, this process can be recursively repeated.
 */
class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long THRESHOLD = 10000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        leftTask.fork();

        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private Long computeSequentially() {
        long sum = 0;
        for( int i = start; i < end; i++ ) {
            sum += numbers[i];
    }
        return sum;
    }
}
