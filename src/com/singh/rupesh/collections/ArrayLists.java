package com.singh.rupesh.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayLists {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(5); // specifying initial capacity
        list.add(24);
        list.add(42);
        list.add(84);
        list.add(168);
        list.add(336);
        list.add(672);
        list.add(1344);
        System.out.println(list);
        System.out.println(list.toString());

        if(list.contains(1344)) {
            list.set(list.indexOf(1344), 1345);
        }
        System.out.println(list);

        list.remove(list.indexOf(1345));
        System.out.println(list);

        System.out.print("[");
        for(Integer i : list) {
            if(list.iterator().hasNext()) {
                System.out.print(i + ", ");
            } else
                System.out.println(i);
        }
        System.out.print(" ]");
        System.out.println();

    }

}
