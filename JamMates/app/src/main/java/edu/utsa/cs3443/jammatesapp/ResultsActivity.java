package edu.utsa.cs3443.jammatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.*;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Sofia Nieves
 * screen that tallies and presents the results of the quiz using a scoring system
 */


public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ImageView resultsImage = findViewById(R.id.genrePicture);
        TextView genreResult = findViewById(R.id.result);

        int score = getIntent().getIntExtra("userScore",0);

        // Setting the screen to give the correct results
        if (score <= 20) {
            resultsImage.setImageResource(R.drawable.popimage);
            genreResult.setText(R.string.pop);
        }
        else if ((20 < score) && (score <= 30)) {
            resultsImage.setImageResource(R.drawable.countryimage);
            genreResult.setText(R.string.country);
        }
        else if ((30 < score) && (score < 42)) {
            resultsImage.setImageResource(R.drawable.classicalimage);
            genreResult.setText(R.string.classical);
        }
        else {
            resultsImage.setImageResource(R.drawable.rockimage);
            genreResult.setText(R.string.rock);
        }

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            resultsImage.setVisibility(View.VISIBLE);
            genreResult.setVisibility(View.VISIBLE);
        }, 3000);


        // BUTTON THAT GOES BACK TO JAMMATES MAIN SCREEN -
        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }
}