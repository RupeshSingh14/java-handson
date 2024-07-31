package com.singh.rupesh.dataStructures.binarySearch;

/*
For a given infinite array, find the index of a given target element.
 */
public class ElementInInfiniteArray {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 7, 9, 11, 12, 14, 15, 18, 19, 30, 33, 56, 59, 60};
        // Imagining an infinite means an array with no known arr.length ie..
        // so solving these without using arr.length
        System.out.println(ans(arr, 15));
    }

    static int ans(int[] arr, int target) {
        //first find the range
        //first start with box of size 2
        int start = 0;
        int end = 1;

        //condition for the target to lie in between the range
        while( target > arr[end]) {
            int newStart = end + 1; // used for temporary store of new start value
            // double the box value
            // end = previous end + (size of box * 2)
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

//        int start = 0;
//        int end = arr.length - 1;

        while (start <= end ) {
            int mid = ( start + end ) / 2;

            if(target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else
                return mid;

        }
        return -1;
    }

}
