package edu.utsa.cs3443.jammatesapp.model;

import edu.utsa.cs3443.jammatesapp.model.UserProfile;
import java.util.List;

public class ProfileController {
    private UserProfile userProfile;

    public ProfileController(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public void updateProfilePicture(String newPath) {
        userProfile.setProfilePicturePath(newPath);
    }

    public void saveArtist(String artist) {
        userProfile.addSavedArtist(artist);
    }

    public void removeArtist(String artist) {
        userProfile.removeSavedArtist(artist);
    }

    public void saveLyric(String lyric) {
        userProfile.addSavedLyric(lyric);
    }

    public void removeLyric(String lyric) {
        userProfile.removeSavedLyric(lyric);
    }

    public List<String> getSavedArtists() {
        return userProfile.getSavedArtists();
    }

    public List<String> getSavedLyrics() {
        return userProfile.getSavedLyrics();
    }
}

