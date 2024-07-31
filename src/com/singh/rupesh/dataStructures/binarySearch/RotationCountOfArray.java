package com.singh.rupesh.dataStructures.binarySearch;

/*
Count the number of times an asc sorted Array has been rotated
 */
public class RotationCountOfArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int rotationCount = countRotations(arr);
        System.out.println(rotationCount);
    }

    private static int countRotations(int[] arr) {
        int pivot = findPivot(arr);
//        if( pivot == -1) { // for array which is not rotated
//            return 0;
//        }
// not required as -1 + 1 by below statement is anyways = 0;
        return pivot + 1;

    }

    // finding the pivot in the rotated sorted array ie.. element from where array is rotated.
    // will not work in case of duplicates
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ( end - start ) / 2;
            // 4 cases over here
            if(mid < end && arr[mid] > arr[mid + 1]) { // if mid is greater that means it is pivot
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid-1]) {
                return mid -1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
