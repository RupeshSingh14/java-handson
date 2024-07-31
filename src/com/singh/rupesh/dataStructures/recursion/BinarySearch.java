package com.singh.rupesh.dataStructures.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 22, 32, 35, 49, 61};
        int target = 4;
        System.out.println(binarySearch(arr, target, 0, arr.length-1));
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        if( arr[middle] == target) {
            return middle;
        }
        if( target < arr[middle]) {
            return binarySearch(arr, target, start, middle - 1);
        }
        return binarySearch(arr, target, middle + 1, end);
    }

}
