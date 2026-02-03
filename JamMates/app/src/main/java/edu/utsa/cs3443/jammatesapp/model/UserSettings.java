package edu.utsa.cs3443.jammatesapp.model;

import java.util.ArrayList;
import java.util.List;

public class UserSettings {
    private String displayName;
    private String bio;
    private boolean notificationsEnabled;
    private boolean profileVisible;
    private List<String> recentActivity;

    public UserSettings(String displayName, String bio, boolean notificationsEnabled, boolean profileVisible) {
        this.displayName = displayName;
        this.bio = bio;
        this.notificationsEnabled = notificationsEnabled;
        this.profileVisible = profileVisible;
        this.recentActivity = new ArrayList<>();
    }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public boolean isNotificationsEnabled() { return notificationsEnabled; }
    public void setNotificationsEnabled(boolean notificationsEnabled) { this.notificationsEnabled = notificationsEnabled; }

    public boolean isProfileVisible() { return profileVisible; }
    public void setProfileVisible(boolean profileVisible) { this.profileVisible = profileVisible; }

    public List<String> getRecentActivity() { return recentActivity; }
    public void addRecentActivity(String activity) { this.recentActivity.add(activity); }
}

