package com.singh.rupesh.dataStructures.binarySearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45};
        int[] arr1 = {99, 54, 23, 12, 8, 0, -31, -23, -99, -104, -1000};
        System.out.println(orderAgnosticsBinarySearch(arr, 22));

        System.out.println(orderAgnosticsBinarySearch(arr1, -31));
    }

    static int orderAgnosticsBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //find whether array is sorted in ascending order or not
//        boolean isAsc;
//        if(arr[start] < arr[end]){
//            isAsc = true;
//        } else {
//            isAsc = false;
//        }

        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            //find the middle element
            int mid = (start + end) / 2; // or better start + (end - start) / 2

            if(arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                    if(target > arr[mid]) {
                        end = mid - 1;
                    }else {
                        start = mid + 1;
                    }
                }
        }
        return -1;
    }

}
