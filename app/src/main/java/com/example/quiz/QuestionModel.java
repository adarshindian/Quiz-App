package com.example.quiz;


public class QuestionModel {
    int id;
    String question_text;
    String optionOne;
    String optionTwo;
    String optionThree;
    String optionFour;
    int correctAnswer;

    public QuestionModel(int id, String question_text, String optionOne, String optionTwo, String optionThree, String optionFour, int correctAnswer) {
        this.id = id;
        this.question_text = question_text;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.correctAnswer = correctAnswer;
    }
}
