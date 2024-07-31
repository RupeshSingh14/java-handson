package com.singh.rupesh.collections;

import java.util.*;

/*
Sorting a Set(TreeSet) of objects using comparator passed via lambda and method reference
 */
public class Jukebox6 {
    public static void main(String[] args) {
        new Jukebox6().go();
    }

    public void go() {
        List<SongV6> songList = MockSongs6.getSongV6();
        System.out.println(songList);

        songList.sort(Comparator.comparing(SongV6::getTitle));
        System.out.println(songList);

        // Set<SongV6> songSet = new TreeSet<>((o1, o2) -> o1.getBpm() - o2.getBpm()); // using lambda
        Set<SongV6> songSet = new TreeSet<>(Comparator.comparingInt(SongV6::getBpm)); // compared on based of int value
        songSet.addAll(songList);
        System.out.println(songSet); // [50 Ways, havana, $10, somersault, cassidy]

    }
}


class MockSongs6 {
    public static List<SongV6> getSongV6() {
        List<SongV6> songs = new ArrayList<>();
        songs.add(new SongV6("somersault", "zero 7", 147));
        songs.add(new SongV6("cassidy", "grateful dead", 158));
        songs.add(new SongV6("$10", "hitchhiker", 140));
        songs.add(new SongV6("havana", "cabello", 105));
        songs.add(new SongV6("$10", "hitchhiker", 140));
        songs.add(new SongV6("cassidy", "grateful dead", 158));
        songs.add(new SongV6("50 Ways", "simon", 102));
        return songs;
    }
}

class SongV6 {
    private String title;
    private String artist;
    private int bpm;

    public SongV6(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    @Override
    public boolean equals(Object aSong) {
        SongV6 other = (SongV6) aSong;
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