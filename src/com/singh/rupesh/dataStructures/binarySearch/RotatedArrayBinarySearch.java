package com.singh.rupesh.dataStructures.binarySearch;

/*
For a given asc sorted array which has been rotated several times. Find the target element.
 */
public class RotatedArrayBinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 11, 1};
        System.out.println(search(arr, 5));
    }

    static int search(int[] arr, int target) {
        int pivot = findPivot(arr);
        if(pivot == -1) {
            System.out.println("it is not a sorted rotated array");
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        //if pivot is found, there are 2 asc sorted arrays
        if(arr[pivot] == target) {
            return arr[pivot];
        }
        if( target >= arr[0])
            return arr[binarySearch(arr, target, 0, pivot-1)];
        else {
            return arr[binarySearch(arr, target, pivot +1 , arr.length-1)];
        }
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
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

    // when array has duplicates
    static int findPivotWithDuplicates(int[] arr) {
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

            // if elements at start, middle and end are equal then just skip the duplicates
            if( arr[mid] == arr[start] && arr[mid] == arr[end] ) { // ie.. arr[mid] = arr[start] = arr[end]
                // skip the duplicates
                // FIXME: 07/07/2023 unsure if below logic of checking start and end for pivot is correct
                // but before that check if start and end are not the pivot
                // check if start is pivot
                if( arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                // check if end is pivot
                if( arr[end] < arr[end - 1]) {
                    return end-1;
                }
                end--;
            } // if left side is sorted, check for pivot on right side else opposite
            else if ( arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end] ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}