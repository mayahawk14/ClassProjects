package edu.utsa.cs3443.jammatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.jammatesapp.model.UserSettings;
import edu.utsa.cs3443.jammatesapp.model.SettingsController;

/**
 * @author Ariel Martinez
 * Page where the user can adjust their settings, and log out
 */

public class SettingsActivity extends AppCompatActivity {

    private Switch notificationsSwitch;
    private TextView editProfile, accountManagement, recentActivity, profileVisibility;
    private Button logOutButton;


    private UserSettings userSettings;
    private SettingsController settingsController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Create dummy settings data (this could come from a file later)
        userSettings = new UserSettings("Ariel", "Music fan", true, true);
        settingsController = new SettingsController(userSettings);

        // Connect UI elements
        logOutButton = findViewById(R.id.logOut);
        notificationsSwitch = findViewById(R.id.notificationsSwitch);
        editProfile = findViewById(R.id.editProfile);
        accountManagement = findViewById(R.id.accountManagement);
        recentActivity = findViewById(R.id.recentActivity);
        profileVisibility = findViewById(R.id.profileVisibility);

        // Set switch initial state
        notificationsSwitch.setChecked(userSettings.isNotificationsEnabled());

        // Toggle Notifications
        notificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsController.toggleNotifications(isChecked);
            Toast.makeText(this, "Notifications " + (isChecked ? "enabled" : "disabled"), Toast.LENGTH_SHORT).show();
        });

        // Profile Visibility toggle on tap (not switch-based)
        profileVisibility.setOnClickListener(view -> {
            boolean current = userSettings.isProfileVisible();
            settingsController.toggleProfileVisibility(!current);
            String msg = current ? "Profile is now hidden" : "Profile is now visible";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });

        // Edit Profile Click
        editProfile.setOnClickListener(view ->
                Toast.makeText(this, "Edit Profile clicked", Toast.LENGTH_SHORT).show()
        );

        // Account Management Click
        accountManagement.setOnClickListener(view ->
                Toast.makeText(this, "Account Management clicked", Toast.LENGTH_SHORT).show()
        );

        // Recent Activity Click
        recentActivity.setOnClickListener(view ->
                Toast.makeText(this, "Recent Activity clicked", Toast.LENGTH_SHORT).show()
        );

        // Log Out button goes back to login page
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // button goes back to home page
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}

