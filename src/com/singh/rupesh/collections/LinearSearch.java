package com.singh.rupesh.collections;

public class LinearSearch {

    public static void main(String[] args) {
        int[] array = {1, 43, 23, 567, 674, 34, 67, 45, 78, 88, 80, 4, 7};
        int target = 45;
        System.out.println(linearSearch(array, target));
        System.out.println(linearSearch1(array, target));
        System.out.println(linearSearch2(array, target));

        String name = "Rupesh";
        System.out.println(linearSearchString(name, 'e'));
    }

    // search the array: return the index if item found
    // otherwise if item not found return -1
    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // search the array: return the element if it is found
    // otherwise if item not found return -1
    static int linearSearch1(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int element : arr) {
            if (element == target) {
                return element;
            }
        }
        return -1;
    }

    // search the array: return true if it is found
    // otherwise if item not found return false
    static boolean linearSearch2(int[] arr, int target) {
        if (arr.length == 0) {
            return false;
        }
        for (int element : arr) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }

    // for strings using for loop
    static boolean linearSearchString(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return true;
            }
        }
        return false;
    }

    // using for each on converting string to char array
    static boolean linearSearchString1(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        for (char ch : str.toCharArray()) {  // str to char array
            if ( ch == target) {
                return true;
            }
        }
        return false;
    }

}