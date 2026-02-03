package edu.utsa.cs3443.jammatesapp.model;

import edu.utsa.cs3443.jammatesapp.model.UserSettings;
import java.util.List;

public class SettingsController {
    private UserSettings userSettings;

    public SettingsController(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

    public void updateProfile(String newName, String newBio) {
        userSettings.setDisplayName(newName);
        userSettings.setBio(newBio);
    }

    public void toggleNotifications(boolean isEnabled) {
        userSettings.setNotificationsEnabled(isEnabled);
    }

    public void toggleProfileVisibility(boolean isVisible) {
        userSettings.setProfileVisible(isVisible);
    }

    public void logOut() {
        // Placeholder for logout logic
        System.out.println("User logged out.");
    }

    public List<String> getActivityLog() {
        return userSettings.getRecentActivity();
    }
}

