package edu.utsa.cs3443.jammatesapp.model;

public class Song {

    // **** ATTRIBUTES ****
    private String title;
    private String length;
    private String genre;
    private boolean isFavorite;

    // **** CONSTRUCTORS ****

    public Song() {
        this.title = "N/A";
        this.length = "N/A";
        this.genre = "N/A";
    }

    public Song(String title, String length, String genre) {
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.isFavorite = false;
    }

    public Song (String title) {
        this.title = title;
    }

    // **** GETTERS AND SETTERS ****

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isFavorite() {
        return isFavorite; }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite; }


}
