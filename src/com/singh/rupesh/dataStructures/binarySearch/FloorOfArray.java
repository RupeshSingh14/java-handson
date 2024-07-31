package com.singh.rupesh.dataStructures.binarySearch;

/*
Floor of a given number (target) in a sorted array is the greatest number in that array which is smaller than or equal to the target.
 */
public class FloorOfArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 15, 16, 18, 22, 45};
        int target = 1;
        int floor = floorOfArray(arr, target);
        System.out.println(floor);

    }

    static int floorOfArray(int[] arr, int target) {

        // for handling edge case where target is smaller than all the numbers in the array
        if( target < arr[0]) {
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
        return arr[end]; // as the target is not available in the array, the while loop broke. In such condition the greatest number in the array
        // which is just smaller than the target is current position of end.
    }
}
