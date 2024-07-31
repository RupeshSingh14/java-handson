package com.singh.rupesh.dataStructures.linearSearch;


// finding even digit numbers in an array
public class FindEvenDigitNumbersInAArray {

    public static void main(String[] args) {
        int[] arr = {1,53,2,6,3456775,5532,42322455};
        System.out.println(countOfEvenNumbersInAArray(arr));
    }

    // iterating through each element in array and counting all that matches the condition
    private static int countOfEvenNumbersInAArray(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if(even(num)) {
                count++;
            }
        }
        return count;
    }

    // evaluating if the counted digit is even or not
    private static boolean even(int num) {
        int value = digits3(num);
        return value % 2 == 0;
    }

    // counting the number of digits in the integer
    private static int digits(int num) {
        // to handle edge cases of number being negative
        if (num < 0) {
            num = num * -1;
        }
        // to handle edge cases of number itself being 0
        if (num == 0) {
            return 1;
        }

        int count = 0;
        while( num > 0 ) {
            count++;
            num = num/10;
        }
        return count;
    }

    // counting the number of digits in the integer
    private static int digits2(int num) {
        // to handle edge cases of number being negative
        if (num < 0) {
            num = num * -1;
        }
        // to handle edge cases of number itself being 0
        if (num == 0) {
            return 1;
        }

        return (int) (Math.log10(num)) + 1; // fastest way of calculating
    }

    // counting the number of digits in the integer
    private static int digits3(int num) {
        // to handle edge cases of number being negative
        if (num < 0) {
            num = num * -1;
        }
        // to handle edge cases of number itself being 0
        if (num == 0) {
            return 1;
        }

        String s = num + ""; // converting the number into string and getting its length
        return s.length();
    }

}
