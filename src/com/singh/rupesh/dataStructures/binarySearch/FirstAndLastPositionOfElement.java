package com.singh.rupesh.dataStructures.binarySearch;

import java.util.Arrays;

/*
Given an array of integers, sorted in ascending order, find the starting and ending position
of a given target value using an algorithm of O(log n) runtime complexity.
if target is not found, return [-1, -1]

Run the binary search twice, first to search from start get the first occurrence and then to search
from end to ger last occurrence. O(log n) + O(log n) will be O(log n) only since 2 as constant will be
ignored.
 */
public class FirstAndLastPositionOfElement {
    public static void main(String[] args) {
        int[] num = {5, 7, 7, 7, 7, 8, 8, 10};
        int target = 7;
        int[] firstAndLastPosition = searchRange(num, target);
        System.out.println(Arrays.toString(firstAndLastPosition));

    }

    private static int[] searchRange(int[] num, int target) {
        int[] ans = {-1, -1};
//        int start = search(num, target, true);
//        int end = search(num, target, false);
//        ans[0] = start;
//        ans[1] = end;

        ans[0] = search(num, target, true);
        if(ans[0] != -1) {
            ans[1] = search(num, target, false);
        }
        return ans;
    }

    static int search(int[] num, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = num.length - 1;

        while( start <= end) {

            int mid = ( start + end ) / 2;

            if(target < num[mid]) {
                end = mid - 1;
            } else if(target > num[mid]) {
                start = mid + 1;
            } else { // code to iterate till finding the first and last occurrence of the target
                ans = mid;
                if(findStartIndex) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }


}
