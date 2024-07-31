package com.singh.rupesh.dataStructures.recursion;

public class SimpleExample {

    public static void main(String[] args) {
        print(1);
    }

    static void print(int n) {
        if(n == 5) {  // defining base condition where the recursive calls will stop
            System.out.println(5);
            return;
        }
        System.out.println(n);
        print(n + 1);
    }
}