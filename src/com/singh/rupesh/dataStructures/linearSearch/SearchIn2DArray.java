package com.singh.rupesh.dataStructures.linearSearch;

import java.util.Arrays;

//search in 2D array and returning an array of {row, col}.
public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {18, 12}
        };
        int target = 12;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
        System.out.println(max(arr));
    }

    //search a value in a 2D array
    private static int[] search(int[][] arr, int target) {
        for( int row = 0; row < arr.length; row++) {
            for( int col = 0; col < arr[row].length; col++) {
                if( arr[row][col] == target) {
                    return new int[] {row, col};
                }
            }
        }
        return new int[] {-1, -1};
    }

    //search max value in a 2D array
    private static int max(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for( int[] ints : arr ) {
            for( int element : ints ) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }


}
