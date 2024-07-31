package com.singh.rupesh.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Sorting a list of objects using comparable
 */
public class Jukebox2 {

    public static void main(String[] args) {
        new Jukebox2().go();
    }

    public void go() {
        List<SongV2> songList = MockSongs2.getSongV2();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }

}

class MockSongs2 {

    public static List<SongV2> getSongV2() {
        List<SongV2> songs = new ArrayList<>();
        songs.add(new SongV2("somersault", "zero 7", 147));
        songs.add(new SongV2("cassidy", "grateful dead", 158));
        songs.add(new SongV2("$10", "hitchhiker", 140));
        songs.add(new SongV2("havana", "cabello", 105));
        songs.add(new SongV2("Cassidy", "grateful dead", 158));
        songs.add(new SongV2("50 Ways", "simon", 102));
        return songs;
    }
}

class SongV2 implements Comparable<SongV2>{
    private String title;
    private String artist;
    private int bpm;

    public SongV2(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    @Override
    public int compareTo(SongV2 songV2) {
        return title.compareTo(songV2.getTitle());
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    @Override
    public String toString() {
        return title;
    }

}