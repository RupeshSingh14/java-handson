package com.singh.rupesh.dataStructures.sorting;

import java.util.ArrayList;
import java.util.List;

/*
   Given a set of integers s, which originally contains all the numbers from 1 to n except a number which has been repeated
   twice causing loss of another number. Find the numbers that occurs twice and the missing number.
     */
public class SetMismatch {
        public static void main(String[] args) {
            int[] arr = {1, 1};
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
                    list.add(index + 1);
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
