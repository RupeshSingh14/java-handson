package com.singh.rupesh.dataStructures.sorting;

/*
Given an array nums containing n distinct numbers in the range [0,n], return the only number
in the range that is missing from the array.

Use O(1) of space complexity and O(n) of time complexity.
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr));

    }

    // for [0,n] means arr[0] 0 and so on ie.. arr[i] must be i.
    private static int missingNumber(int[] arr) {
        int i = 0;
        while( i < arr.length) {
            int correct = arr[i]; // arr[i] must be i
            if(arr[i] < arr.length && arr[i] != arr[correct]) { // don't check for the last item (nth)  and arr[i] must be i
                swap(arr, i, correct); // swap and sort the array
            } else {
                i++;
            }
        }

        // once sorted
        // case 1, search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index) {
                return index;
            }
        }
        // case 2, if no missing number found in array, ie.. nth number is the one missing
        return arr.length;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
