package edu.utsa.cs3443.jammatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Sofia Nieves
 * Intro page to the quiz, gives quick note and prompts user to proceed to quiz
 */

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // button that continues to questions page
        Button continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, QuestionsActivity.class);
                startActivity(intent);
            }
        });


        // BUTTON THAT GOES BACK TO JAMMATES MAIN SCREEN
        Button backToHomeButton = findViewById(R.id.backToHomePage);
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });







    }
}