package edu.utsa.cs3443.jammatesapp.model;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String username;
    private String profilePicturePath;
    private List<String> savedArtists;
    private List<String> savedLyrics;

    public UserProfile(String username, String profilePicturePath) {
        this.username = username;
        this.profilePicturePath = profilePicturePath;
        this.savedArtists = new ArrayList<>();
        this.savedLyrics = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getProfilePicturePath() { return profilePicturePath; }
    public void setProfilePicturePath(String path) { this.profilePicturePath = path; }

    public List<String> getSavedArtists() { return savedArtists; }
    public void addSavedArtist(String artist) { this.savedArtists.add(artist); }
    public void removeSavedArtist(String artist) { this.savedArtists.remove(artist); }

    public List<String> getSavedLyrics() { return savedLyrics; }
    public void addSavedLyric(String lyric) { this.savedLyrics.add(lyric); }
    public void removeSavedLyric(String lyric) { this.savedLyrics.remove(lyric); }
}
