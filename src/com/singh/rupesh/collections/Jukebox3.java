package com.singh.rupesh.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Sorting a list of objects using comparator in List.sort(comparator)
 */
public class Jukebox3 {
    public static void main(String[] args) {
        new Jukebox3().go();
    }

    public void go() {
        List<SongV3> songList = MockSongs3.getSongV3();
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        songList.sort(artistCompare);
        System.out.println(songList);

        TitleCompare titleCompare = new TitleCompare();
        songList.sort(titleCompare);
        System.out.println(songList);

    }

}

class ArtistCompare implements Comparator<SongV3> {

    @Override
    public int compare(SongV3 o1, SongV3 o2) {
        return o1.getArtist().compareTo(o2.getArtist());
    }
}

class TitleCompare implements Comparator<SongV3> {

    @Override
    public int compare(SongV3 o1, SongV3 o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}


class MockSongs3 {

    public static List<SongV3> getSongV3() {
        List<SongV3> songs = new ArrayList<>();
        songs.add(new SongV3("somersault", "zero 7", 147));
        songs.add(new SongV3("cassidy", "grateful dead", 158));
        songs.add(new SongV3("$10", "hitchhiker", 140));
        songs.add(new SongV3("havana", "cabello", 105));
        songs.add(new SongV3("Cassidy", "grateful dead", 158));
        songs.add(new SongV3("50 Ways", "simon", 102));
        return songs;
    }
}

class SongV3 {
    private String title;
    private String artist;
    private int bpm;

    public SongV3(String title, String artist, int bpm) {
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
        return title;
    }
}