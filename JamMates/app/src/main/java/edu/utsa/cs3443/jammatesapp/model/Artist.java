package edu.utsa.cs3443.jammatesapp.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Artist {

    // **** ATTRIBUTES ****
    private String name;
    private String genre;
    private ArrayList<Song> songList;

    private boolean isFavorite;

    // **** CONSTRUCTORS ****
    public Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.songList = new ArrayList<>();
        this.isFavorite = false;
    }
    public Artist() {
        this.songList = new ArrayList<>();
        this.isFavorite = false;
    }

    // **** GETTERS AND SETTERS ****

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }
    public void addSong ( String song ) {
        if (songList == null) {
            songList = new ArrayList<>();
            Log.e("Artist", "songList was null. Initialized.");
        }
        songList.add(new Song(song));
    }

    public boolean isFavorite() {
        return isFavorite; }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite; }


}
