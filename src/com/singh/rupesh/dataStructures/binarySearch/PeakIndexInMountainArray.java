package com.singh.rupesh.dataStructures.binarySearch;

/*
For a given mounted array ie.. an array with elements in first sorted ascending order and then in
descending order, find the peak element of the array.
No duplicate elements are there in array.
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,7,9,8,6,5,3,2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while( start < end ) {
            int mid = start + (end - start) / 2;
            if( arr[mid] > arr[mid + 1]) { // we are in decreasing part of array
                end = mid; // this may be the answer but look at left
            } else {   // arr[mid] < arr[mid + 1]
                //you are in the ascending part of array
                start = mid + 1; // because we know mid+1 element > mid element
            }
        }
        //in the end, start == end and pointing to the largest number because of 2 above cases
        // as start and end are always trying to find max element in the above 2 checks
        //hence, when they are pointing to just one element, that is max one because that is
        //what the check says
        return arr[start]; // or end as both are pointing now at the largest element in the array

    }


}

