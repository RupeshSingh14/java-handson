package com.singh.rupesh.dataStructures.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45};
        System.out.println(binarySearch(arr, 100));

    }

    //assumption is array is sorted in ascending order
    //return the index
    // return -1 if it does not exists
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
             //find the middle element
            int mid = (start + end) / 2; // or better start + (end - start) / 2
            if(target < arr[mid]) {
                end = mid - 1;
            }else if(target > arr[mid]) {
                start = mid + 1;
            }else {
                return mid; // match found
            }
        }
        return -1;
    }
}
