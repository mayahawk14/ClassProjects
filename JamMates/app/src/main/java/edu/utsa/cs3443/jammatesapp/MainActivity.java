package edu.utsa.cs3443.jammatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isHeart1Filled = false;
    private boolean isHeart2Filled = false;
    private boolean isHeart3Filled = false;
    private boolean isHeart4Filled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Artist 1
        ImageButton heart1 = findViewById(R.id.heart1);
        heart1.setOnClickListener(v -> {
            isHeart1Filled = !isHeart1Filled;
            heart1.setImageResource(isHeart1Filled ? R.drawable.heartfill : R.drawable.heartoutline);
        });

        // Artist 2
        ImageButton heart2 = findViewById(R.id.heart2);
        heart2.setOnClickListener(v -> {
            isHeart2Filled = !isHeart2Filled;
            heart2.setImageResource(isHeart2Filled ? R.drawable.heartfill : R.drawable.heartoutline);
        });

        // Artist 3
        ImageButton heart3 = findViewById(R.id.heart3);
        heart3.setOnClickListener(v -> {
            isHeart3Filled = !isHeart3Filled;
            heart3.setImageResource(isHeart3Filled ? R.drawable.heartfill : R.drawable.heartoutline);
        });

        // Artist 4
        ImageButton heart4 = findViewById(R.id.heart4);
        heart4.setOnClickListener(v -> {
            isHeart4Filled = !isHeart4Filled;
            heart4.setImageResource(isHeart4Filled ? R.drawable.heartfill : R.drawable.heartoutline);
        });

        Button profileButton = findViewById(R.id.profileButton);
        Button quizButton = findViewById(R.id.quizButton);
        Button settingsButton = findViewById(R.id.settingsButton);
        Button exploreButton = findViewById(R.id.exploreButton);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        exploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });


    }
}