package com.singh.rupesh.collections;

import javax.print.attribute.standard.OrientationRequested;
import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArray {

    public static void main(String[] args) {
        /*
        Matrix - 3 rows * 3 columns
            1 2 3
            4 5 6
            7 8 9
         */

        int[][] arr = new int[3][]; // defining no of rows is necessary but not required for columns

        int[][] arr1 = {
                {1, 2, 3},  // 0th index
                {4, 5},     // 1st index
                {6, 7, 8, 9} // 2nd index
        };

        for (int[] array : arr1) {
            System.out.println(Arrays.toString(array));
        }

        for (int row = 0; row < arr1.length; row++) {
            System.out.println(Arrays.toString(arr1[row]));
        }

        System.out.println("Enter the values for 2D array [3][3] : ");
        Scanner scanner = new Scanner(System.in);

        int[][] array2D = new int[3][3];
        System.out.println(array2D.length);

        for(int row = 0; row < array2D.length; row ++) {
            for( int col = 0; col < array2D[row].length; col++) {
                array2D[row][col] = scanner.nextInt();
            }
        }

        for (int row = 0; row < array2D.length; row++) {
            for(int col = 0; col < array2D[row].length; col++) {
                System.out.print(array2D[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Since each row is an individual arrays itself, we can print the each of these array

        for (int row = 0; row < array2D.length; row++) {
            System.out.println(Arrays.toString(array2D[row]));
        }

        System.out.println();

        // sout each array of type int[array] in two dimensional array2D
        for( int[] array : array2D) {
            System.out.println(Arrays.toString(array));
        }















    }

}
