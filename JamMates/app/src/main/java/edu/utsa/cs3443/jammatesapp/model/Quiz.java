package edu.utsa.cs3443.jammatesapp.model;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import java.util.*;
import java.io.*;
public class Quiz{

    String quizName;
    ArrayList<Question> questionList = new ArrayList<Question>();
    private int userScore;

    // constructor
    public Quiz ( String quizName ) {
        this.quizName = quizName;
    }

    //getters and setters
    public int getUserScore () {
        return userScore;
    }
    public void setUserScore ( int userScore ) {
        this.userScore = userScore;
    }

    public ArrayList<Question> getQuestionList () {
        return questionList;
    }

    // METHOD THAT READS IN CSV FILE AND LOADS QUESTIONS INTO ARRAYLIST
    public void loadQuestions ( Context context, String filename ) {
        questionList.clear();
        int count = 1;
        try {
            InputStream is = context.getAssets().open(filename);
            Scanner scan = new Scanner(is);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split(",");

                if (tokens.length < 5) continue;

                String question = tokens[0];

                String[] ac = new String[4];
                int j = 1;

                for (int i = 0; i < 4; i++) {
                    ac[i] = tokens[j];
                    j++;
                }

                questionList.add(new Question(question, count, ac));
                count++;
            }

            scan.close();
            is.close();

        } catch (Exception e) {
            Log.d(TAG, "Error loading questions from file: " + filename, e);
            //System.out.printf("Error loading files - " + e.getMessage());
        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quiz: " + quizName + "\nQuestion List:");
        for (int i = 0; i < questionList.size(); i++) {
            sb.append(questionList.get(i).toString());

        }
        return sb.toString();
    }


}
