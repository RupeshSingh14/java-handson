package com.singh.rupesh.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Sorting a list of string values using Collections class sort utility
 */
public class Jukebox1 {

    public static void main(String[] args) {
        new Jukebox1().go();
    }

    public void go() {
        List<String> songList = MockSongs.getSongStrings();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }

}

class MockSongs {

    public static List<String> getSongStrings() {

        List<String> songs = new ArrayList<>();
        songs.add("somersault");
        songs.add("cassidy");
        songs.add("$10");
        songs.add("havana");
        songs.add("Cassidy");
        songs.add("50 Ways");
        return songs;
    }
}