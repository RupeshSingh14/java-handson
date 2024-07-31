package com.singh.rupesh.collections;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //syntax of array
        //datatype[] variable_name = new datatype[size];

        int[] rnos = new int[5];
        int[] rnos2 = {1,2,3,4,5};

        int[] ros; // declaration of array. ros is getting defined in the stack
        ros = new int[5]; //initialization. actually here object is bring created in the memory(heap)

        for(int i = 0; i < rnos.length; i++){
            rnos[i] = scanner.nextInt();
        }

        for(int i = 0; i < rnos.length; i++){
            System.out.print(rnos[i] + " ");
        }
        System.out.println();

        for( int num : rnos) { // for every element num in array print element
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println(Arrays.toString(rnos)); // utility method. behind the scenes implements simple for loop

    }

}
