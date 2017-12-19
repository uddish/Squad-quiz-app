package com.example.uddishverma.quiz_app.Models;

import java.util.ArrayList;

/**
 * Created by uddishverma on 19/12/17.
 */

public class Questions {

    ArrayList<ArrayList<String>> questions;
    String correctAnswer;
    ArrayList<String> answers;
    int questionId;

    public Questions(ArrayList<ArrayList<String>> questions, String correctAnswer, ArrayList<String> answers, int questionId) {
        this.questions = questions;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
        this.questionId = questionId;
    }
}
