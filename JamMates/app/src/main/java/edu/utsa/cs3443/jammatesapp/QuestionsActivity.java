package edu.utsa.cs3443.jammatesapp;

import static android.content.ContentValues.TAG;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import java.util.ArrayList;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.jammatesapp.model.Question;
import edu.utsa.cs3443.jammatesapp.model.Quiz;

/**
 * @author Sofia Nieves
 * Screen that populates the questions and answer choices for the quiz, parses through an array list from csv file
 */

public class QuestionsActivity extends AppCompatActivity {
    ArrayList<Question> questionList;
    private int currentIndex = 0;
    private int userScore = 0;
    TextView quizQuestion;
    Button[] answerChoices;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Quiz practiceQuiz = new Quiz("Practice Quiz");

        try {
            practiceQuiz.loadQuestions( this,"questions.csv" );
        }catch( Exception e ) {
            Log.d(TAG, "Error loading questions from file");
        }

        questionList = practiceQuiz.getQuestionList();

        answerChoices = new Button[4];

        answerChoices[0] = findViewById(R.id.answerChoice1);
        answerChoices[1] = findViewById(R.id.answerChoice2);
        answerChoices[2] = findViewById(R.id.answerChoice3);
        answerChoices[3] = findViewById(R.id.answerChoice4);


        quizQuestion = findViewById(R.id.question);

        if (!questionList.isEmpty()) {
            showQuestion(currentIndex);
            for (int i = 0; i < answerChoices.length; i++) {
                final int buttonIndex = i;
                answerChoices[i].setOnClickListener(v -> handleAnswer(buttonIndex));
            }

        }
        else {
            Log.e(TAG, "Cannot show questions bc questionList was not loaded properly");
        }



        // BUTTON THAT GOES BACK TO JAMMATES MAIN SCREEN
        Button backToHome = findViewById(R.id.backToHomePage);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
    private void showQuestion (int num) {
        Question q = questionList.get(num);
        quizQuestion.setText(q.getQuestion());
        String[] choices = q.getChoices();
        for (int i = 0; i < answerChoices.length; i++) {
            answerChoices[i].setText(choices[i]);
        }
    }

    private void handleAnswer(int choiceIndex) {
        Question current = questionList.get(currentIndex);
        userScore += current.getPoints(choiceIndex);
        currentIndex++;
        if (currentIndex < 6) {
            showQuestion(currentIndex);
        } else {
            Intent intent = new Intent(QuestionsActivity.this, ResultsActivity.class);
            intent.putExtra("userScore", userScore);
            startActivity(intent);
        }
    }


}