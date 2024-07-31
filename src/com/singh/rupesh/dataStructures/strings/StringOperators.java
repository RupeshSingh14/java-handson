package com.singh.rupesh.dataStructures.strings;

import java.util.Arrays;

public class StringOperators {
    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            series += ch;
        }
        System.out.println(series);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch);
        }

        System.out.println(builder.toString());

        System.out.println(Arrays.toString(series.toCharArray()));

    }
}
