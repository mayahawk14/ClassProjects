package edu.utsa.cs3443.jammatesapp.model;

public class Friends {

    public String name;
    public String username;
    public String email;
    public Song favSong;
    public Artist favArtist;
    public boolean isFriend;

    public Friends(String name, String username, String email, Song favSong, Artist favArtist, boolean isFriend) {
        super();
        this.name = name;
        this.username = username;
        this.email = email;
        this.favSong = favSong;
        this.favArtist = favArtist;
        this.isFriend = isFriend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Song getFavSong() {
        return favSong;
    }

    public void updateFavSong(Song favSong) {
        this.favSong = favSong;
    }

    public Artist getFavArtist() {
        return favArtist;
    }

    public void updateFavArtist(Artist favArtist) {
        this.favArtist = favArtist;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void addFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }


}
