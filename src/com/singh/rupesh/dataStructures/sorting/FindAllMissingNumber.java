package com.singh.rupesh.dataStructures.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array arr of n integers where num[i] is in the range [1, n], return all the
integers in the range [1, n] that do not appear in arr.
 */
public class FindAllMissingNumber {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findAllMissingNumbers(arr));

    }

    private static List<Integer> findAllMissingNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        //just find the missing numbers
        List<Integer> list = new ArrayList();
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                list.add(index + 1);
            }
        }
        return list;
    }

        private static void swap ( int[] arr, int i, int correct){
            int temp = arr[i];
            arr[i] = arr[correct];
            arr[correct] = temp;
        }
}