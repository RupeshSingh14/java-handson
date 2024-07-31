package com.singh.rupesh.dataStructures.linearSearch;

import java.util.Arrays;

public class SwappingValuesInArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 23, 9, 18};

        swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));

        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    //swapping Array[index] values
    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // reversing the array
    static void reverse(int[] arr) {
        // setting 2 variables to save values is called 2 pointer method
        int start = 0;
        int end = arr.length-1;

        while(start < end) {
            // swap
            swap(arr, start, end);
            start++;
            end--;
        }
    }

}
