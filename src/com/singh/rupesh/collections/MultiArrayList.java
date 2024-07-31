package com.singh.rupesh.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiArrayList {

    public static void main(String[] args) {

        System.out.println("Enter the values to array list: ");
        Scanner in = new Scanner(System.in);

        List<ArrayList<Integer>> list = new ArrayList<>(); // 2D arraylist

        //Initializing the arraylists in the main arraylist
        for(int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }

        //adding data to the arraylists
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                list.get(i).add(in.nextInt()); // gets the arraylists sequentially and adds 3 values to it in iteration and like so
            }
        }

        System.out.println(list);


    }

}
