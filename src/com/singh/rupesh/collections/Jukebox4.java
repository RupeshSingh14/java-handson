package com.singh.rupesh.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Sorting a list of objects using comparator passed via lambda and method reference
 */
public class Jukebox4 {
    public static void main(String[] args) {
        new Jukebox4().go();
    }

    public void go() {
        List<SongV4> songList = MockSongs4.getSongV4();
        System.out.println(songList);
        // songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        // even using lambda for comparator is replaced with method reference
        Comparator<SongV4> compareByTitle = Comparator.comparing(SongV4::getTitle);
        songList.sort(compareByTitle);
        System.out.println(songList);

        songList.sort(Comparator.comparing(SongV4::getArtist));
        System.out.println(songList);

    }

}


class MockSongs4 {

    public static List<SongV4> getSongV4() {
        List<SongV4> songs = new ArrayList<>();
        songs.add(new SongV4("somersault", "zero 7", 147));
        songs.add(new SongV4("cassidy", "grateful dead", 158));
        songs.add(new SongV4("$10", "hitchhiker", 140));
        songs.add(new SongV4("havana", "cabello", 105));
        songs.add(new SongV4("Cassidy", "grateful dead", 158));
        songs.add(new SongV4("50 Ways", "simon", 102));
        return songs;
    }
}

class SongV4 {
    private String title;
    private String artist;
    private int bpm;

    public SongV4(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
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
        return title + ": " + artist ;
    }
}