package com.singh.rupesh.dataStructures.recursion;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(fibo(5000));
    }

    static int fibo(int n) {
        // base condition
        if(n <2 ) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
