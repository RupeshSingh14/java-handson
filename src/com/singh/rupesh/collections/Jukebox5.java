package com.singh.rupesh.collections;

import java.util.*;

/*
Sorting a Set(HashSet) of objects using comparator passed via lambda and method reference
 */
public class Jukebox5 {
    public static void main(String[] args) {
        new Jukebox5().go();
    }

    public void go() {
        List<SongV5> songList = MockSongs5.getSongV5();
        System.out.println(songList);
        // songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle())); // even using lambda for comparator is replaced with method reference
        songList.sort(Comparator.comparing(SongV5::getTitle));
        System.out.println(songList);

        Set<SongV5> songSet = new HashSet<>(songList);
        System.out.println(songSet);

    }
}


class MockSongs5 {
    public static List<SongV5> getSongV5() {
        List<SongV5> songs = new ArrayList<>();
        songs.add(new SongV5("somersault", "zero 7", 147));
        songs.add(new SongV5("cassidy", "grateful dead", 158));
        songs.add(new SongV5("$10", "hitchhiker", 140));
        songs.add(new SongV5("havana", "cabello", 105));
        songs.add(new SongV5("$10", "hitchhiker", 140));
        songs.add(new SongV5("cassidy", "grateful dead", 158));
        songs.add(new SongV5("50 Ways", "simon", 102));
        return songs;
    }
}

class SongV5 {
    private String title;
    private String artist;
    private int bpm;

    public SongV5(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    @Override
    public boolean equals(Object aSong) {
        SongV5 other = (SongV5) aSong;
        return title.equals(other.getTitle());
    }

    @Override
    public int hashCode() {
        return title.hashCode();
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