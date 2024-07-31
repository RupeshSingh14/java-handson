package com.singh.rupesh.dataStructures.sorting;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {

        int[] arr = {3, 5, 2, 1, 4};
        cycle(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cycle(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correct = arr[i] - 1; // correct index of i should be arr[i] - 1
            if(arr[i] != arr[correct]) {
                swap(arr, i, correct);
            }else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
