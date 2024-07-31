package com.singh.rupesh.dataStructures.linearSearch;

public class MaxItemInArray {
    public static void main(String[] args) {
        int[] arr = {1, 65, 345, 45, 29};
        System.out.println(max(arr));
    }

    //finding max value in an array
    //assuming that array is non empty
    static int max(int[] array) {
        int max = array[0];
        for( int i = 1; i < array.length; i ++ ) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}
