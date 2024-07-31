package com.singh.rupesh.dataStructures.strings;

public class PatternsUsingLoop {

    public static void main(String[] args) {

        pattern1(4);
        System.out.println();
        pattern2(5);
        System.out.println();
        pattern3(4);
        System.out.println();
        pattern31(4);
        System.out.println();
        pattern4(5);
        System.out.println();
        pattern5(5);
        System.out.println();
        pattern6(5);
        System.out.println();
        pattern7(5);

    }

    private static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            //for every row, run the column
            for (int column = 1; column <= row ; column++) {
                System.out.print("* ");
            }// when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    private static void pattern2(int n) {
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <= n ; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            //for every row, run the column
            for (int column = 1; column <= n - row + 1 ; column++) { // n - row + 1 is the iteration
                System.out.print("* ");
            }// when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    private static void pattern31(int n) {
        for (int row = 0; row <= n; row++) {
            //for every row, run the column
            for (int column = 1; column <= n - row ; column++) { // n - row, if we start row with 0
                System.out.print("* ");
            }// when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    private static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            //for every row, run the column
            for (int column = 1; column <= row ; column++) { // n - row, if we start row with 0
                System.out.print(column + " ");
            }// when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    private static void pattern5(int n) {
        for (int row = 1; row < 2 * n; row++) {
            //for every row, run the column
            int totalColsInRow = row > n ? 2 * n - row : row; // go in increasing order till n and then start decreasing
            for (int column = 1; column <= totalColsInRow; column++) {
                    System.out.print("* ");
            }// when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    private static void pattern6(int n) {
        for (int row = 1; row < 2 * n; row++) {
            //for every row, run the column
            int totalColsInRow = row > n ? 2 * n - row : row; // go in increasing order till n and then start decreasing

            int noOfSpaces = n - totalColsInRow;
            for (int s = 0; s <= noOfSpaces ; s++) {
                System.out.print(" ");
            }

            for (int column = 1; column <= totalColsInRow; column++) {
                System.out.print("* ");
            }// when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    private static void pattern7(int n) {
        for (int row = 1; row <= n; row++) {
            //for every row, run the column
            for (int space = 1; space <= n - row  ; space++) {
                System.out.print("  ");
            }

            for (int column = row; column >= 1 ; column--) {
                System.out.print(column + " ");
            }
            for (int column = 2; column <= row ; column++) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }








}
