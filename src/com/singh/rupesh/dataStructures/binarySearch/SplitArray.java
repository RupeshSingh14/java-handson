package com.singh.rupesh.dataStructures.binarySearch;

/*
for a given array and a number n, divide the array in n sub arrays such that largest sum
of values in the divided array is minimum.
 */
public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 8, 10};
        System.out.println(splitArray(arr,2));
    }

    static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for( int i = 0; i < nums.length; i++ ) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        // binary search
        while( start < end ) {
            //try for the middle as potential answer
            int mid = start + (end -start) / 2;

            // calculating how many pieces you can divide this in with this max sum aka mid
            int sum = 0;
            int pieces = 1;

            for( int num : nums) {
                if (sum + num > mid) {
                    //cannot add this num in this sub array, make new sub array
                    sum = num; // making a new array by forwarding the iteration
                    pieces++; // counter to count the number of sub arrays (virtually)
                } else {
                    sum += num;
                }
            }
            if( pieces > m ) { // if num of sub arrays formed is more than required than we need to increase size (mid) ie.. by increasing start.
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }



}
