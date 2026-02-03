package edu.utsa.cs3443.jammatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.jammatesapp.model.UserProfile;
import edu.utsa.cs3443.jammatesapp.model.ProfileController;

/**
 * @author Maya Hawkins
 * Page that shows the user's profile page and shows the saved artists and lyrics
 */

public class ProfileActivity extends AppCompatActivity {

    private TextView usernameText;
    private ImageView profileImage, savedArtists, savedLyrics;

    private UserProfile userProfile;
    private ProfileController profileController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userProfile = new UserProfile("@my_username", "path/to/profile.jpg");
        profileController = new ProfileController(userProfile);

        usernameText = findViewById(R.id.usernameText);
        profileImage = findViewById(R.id.profileImage);
        savedArtists = findViewById(R.id.savedArtists);
        savedLyrics = findViewById(R.id.savedLyrics);

        usernameText.setText(userProfile.getUsername());

        savedArtists.setOnClickListener(view ->
                Toast.makeText(this, "Viewing saved artists...", Toast.LENGTH_SHORT).show()
        );

        savedLyrics.setOnClickListener(view ->
                Toast.makeText(this, "Viewing saved lyrics...", Toast.LENGTH_SHORT).show()
        );

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

