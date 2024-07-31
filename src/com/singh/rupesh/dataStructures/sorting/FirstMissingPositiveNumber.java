package com.singh.rupesh.dataStructures.sorting;

public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {1, -1, 0, -11, 4, 6};
        System.out.println(allDuplicates(arr));
    }

    // for [0,n] means arr[0] 0 and so on ie.. arr[i] must be i.
    private static int allDuplicates(int[] arr) {
        int i = 0;
        while (i < arr.length) {
                int correct = arr[i] - 1;
                if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
                    swap(arr, i, correct);
                } else {
                    i++;
                }
            }

        // once sorted
        // case 1, search for first missing number
            for (int index = 0; index < arr.length; index++) {
                    if (arr[index] != index + 1) { //
                        return index + 1;
                    }
            }

        // case 2, if no missing number found in array, ie.. nth + 1 number will be the first missing positive
        return arr.length + 1;
        }


        private static void swap ( int[] arr, int i, int correct){
            int temp = arr[i];
            arr[i] = arr[correct];
            arr[correct] = temp;
        }
    }
