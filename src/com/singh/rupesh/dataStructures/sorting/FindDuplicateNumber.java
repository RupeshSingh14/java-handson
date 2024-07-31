package com.singh.rupesh.dataStructures.sorting;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the
range [1, n] inclusive. Find the one repeated number in the array.
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(duplicateNumber(arr));
    }

    private static int duplicateNumber(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            if(arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct]) {
                    swap(arr, i, correct);
                } else {
                    return arr[i];  // at this flow, we are at a point where one element is already at its required location,
                    // hence we return this duplicate element
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


}
