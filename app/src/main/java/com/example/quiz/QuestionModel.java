package com.example.quiz;


public class QuestionModel {

    String question_text;
    String optionOne;
    String optionTwo;
    String optionThree;
    String optionFour;
    int correctAnswer;

    public QuestionModel( String question_text, String optionOne, String optionTwo, String optionThree, String optionFour, int correctAnswer) {

        this.question_text = question_text;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.correctAnswer = correctAnswer;
    }
}
