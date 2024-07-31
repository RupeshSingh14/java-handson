package com.singh.rupesh.dataStructures.binarySearch;

/*
Ceiling of given number (target) in a sorted array is the smallest number in that array which is greater than or equal to the target.
 */
public class CeilingOfArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 15, 16, 18, 22, 45};
        int target = 17;
        int ceiling = ceilingOfArray(arr, target);
        System.out.println(ceiling);

    }

    static int ceilingOfArray(int[] arr, int target) {

        // for handling edge case where target is greater than all the numbers in the array
        if( target > arr[arr.length - 1]) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while ( start <= end) {
            int mid = ( start + end ) / 2;

            if( target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return arr[start]; // as the target is not available in the array, the while loop broke. In such condition the smallest number in the array
        // which is just greater than the target is current position of start.
    }

}
