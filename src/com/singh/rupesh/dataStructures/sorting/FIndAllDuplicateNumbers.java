package com.singh.rupesh.dataStructures.sorting;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array arr of length n where all the integers of arr are in the range [1,n] and each integer appears once or
twice, return an array of all integers that appears twice using O(n) time complexity and constant time space.
 */
public class FIndAllDuplicateNumbers {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = allDuplicates(arr);
        System.out.println(list);
    }

    private static List<Integer> allDuplicates(int[] arr) {
        int i = 0;
        while(i < arr.length) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct]) {
                    swap(arr, i, correct);
                }else {
                    i++;
                }
            }

        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index + 1) {
                list.add(arr[index]);
            }
        }
        return list;
    }

    private static void swap(int[] arr, int i, int correct) {
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }


}
