package edu.utsa.cs3443.jammatesapp.model;

public class Question {

    private String question;
    private int questionNumber;
    private String[] choices = new String[4];
    private final int[] points = {2,4,6,8};

    public Question ( String question, int questionNumber, String[] choices ) {
        this.question = question;
        this.questionNumber = questionNumber;
        this.choices = choices;
    }
    public Question ( String question, int questionNumber ) {
        this.question = question;
        this.questionNumber = questionNumber;
    }


    // getters and setters
    public String getQuestion () {
        return question;
    }
    public void setQuestion ( String question ) {
        this.question = question;
    }

    public int getQuestionNumber () {
        return questionNumber;
    }
    public void setQuestionNumber ( int questionNumber ){
        this.questionNumber = questionNumber;
    }

    public String[] getChoices () {
        return choices;
    }

    public String getAnswerChoice ( int i ) {
        return choices[i];
    }


    public void setChoices ( String[] choices ) {
        this.choices = choices;
    }

    public int getPoints ( int index) {
        return points[index];
    }
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("\n\n - Question Number " + questionNumber + ": " + question);
        for (int i = 0; i < 4; i++) {
            sb.append("\nAnswerChoice " + (i+1) + ": " + getAnswerChoice(i));

        }
        return sb.toString();
    }


}
