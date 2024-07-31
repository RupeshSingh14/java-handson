package com.singh.rupesh.dataStructures.binarySearch;

/*
For a given sorted array of characters and a given letter(target), find the letter which is the smallest character in that array
and larger than the target.
The letters in the array wrap around ie.. z is followed by a, like a circular linked list.
 */
public class SmallestLetterInArray {

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'g';
        char x = customisedBinarySearch(letters, target);
        System.out.println(x);

    }

    private static char customisedBinarySearch(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {  // condition goes till start == end
            int mid = (start + end) / 2;
            if(target > letters[mid]) {
                start = mid + 1; // start can max reach this way to length of array.
            } else {
                end = mid - 1; // end can max reach to value of -1
            }
        }
         return letters[start % letters.length]; // this will give index 0 value if start is as last position
//        if( start == letters.length ) {
//            return letters[0];
//        }
//        return letters[start];
    }


}
