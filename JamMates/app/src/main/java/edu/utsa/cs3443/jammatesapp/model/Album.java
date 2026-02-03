package edu.utsa.cs3443.jammatesapp.model;

import java.util.List;

public class Album {

    // **** ATTRIBUTES ****
    private String tile;
    private String genre;
    private int lengthInMinutes;
    private List<Song> songs;
    private boolean isFavorite;

    // **** CONSTRUCTORS ****

    public Album() {
        this.tile = "N/A";
        this.genre = "N/A";
        this.lengthInMinutes = -1;
    }

    public Album(String tile, String genre, int lengthInMinutes, List<Song> songs) {
        this.tile = tile;
        this.genre = genre;
        this.lengthInMinutes = lengthInMinutes;
        this.songs = songs;
        this.isFavorite = false;
    }

    // **** GETTERS AND SETTERS ****

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean isFavorite() {
        return isFavorite; }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite; }


}
