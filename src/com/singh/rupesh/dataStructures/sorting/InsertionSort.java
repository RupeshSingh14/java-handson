package com.singh.rupesh.dataStructures.sorting;

import java.util.Arrays;

// sorts from beginning of the array by breaking it into a iterative incremental sorted array
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertion(int[] arr) {
        // iterate i only till arr.length - 2, so that j can go till last element ie.. arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            // iterate the j to compare the all the previous values in the array till index 0 and swapping it for
            // bigger values and decreasing the j value in iteration
            for (int j = i+1; j > 0 ; j--) {
                if( arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    // if there is not need of sorting ie.. all the values before it are already sorted wrt. to
                    // current value of j break the current iteration
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
