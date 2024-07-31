package com.singh.rupesh.dataStructures.linearSearch;

// calculating the max of sum of all the value in a column of  2D arrays
public class MaxOfSumInA2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 3, 5},
                {4, 5, 2},
                {1, 0, 1, 3, 4}
        };

        System.out.println(maxOfSum(arr));

    }

    static int maxOfSum(int[][] arr) {
        int max = 0;
        for( int[] arrays : arr) {
            int sum  = 0; // resetting the sum after every row of iteration
            for( int element : arrays ) {
                sum = sum + element;
            }
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
