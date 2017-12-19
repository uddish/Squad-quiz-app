package com.example.uddishverma.quiz_app.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uddishverma.quiz_app.R;
import com.example.uddishverma.quiz_app.Utils.LevelWiseQuestions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "QuestionActivity";
    TextView ans1Tv, ans2Tv, ans3Tv, ans4Tv;
    TextView questionTv;
    ArrayList<String> questions;
    Intent i;
    JSONObject levelWiseQuestions, levelTwoQuestions;
    JSONObject questionsObject, lTwoQuestionsObject;
    int questionIndex = 0;
    String selectedAnswer;
    String source;
    ArrayList<String> wrongAnswersLevelOne, wrongAnswersLevelTwo, wrongAnswersLevelThree, wrongAnswersLevelFour, wrongAnswersLevelFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        i = getIntent();


        try {

            if (i.getStringExtra("levelSelected").equals("one")) {
                source = "one";
                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelOneQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);
            } else if (i.getStringExtra("levelSelected").equals("two")) {
                source = "two";
                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelTwoQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);
            } else if (i.getStringExtra("levelSelected").equals("three")) {
                source = "three";
                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelThreeQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);
            } else if (i.getStringExtra("levelSelected").equals("four")) {
                source = "four";
                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelFourQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);
            } else {
                source = "five";
                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelFiveQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        initView();

    }

    private void initView() {
        ans1Tv = findViewById(R.id.answer1_tv);
        ans2Tv = findViewById(R.id.answer2_tv);
        ans3Tv = findViewById(R.id.answer3_tv);
        ans4Tv = findViewById(R.id.answer4_tv);
        questionTv = findViewById(R.id.question_tv);

        ans1Tv.setOnClickListener(this);
        ans2Tv.setOnClickListener(this);
        ans3Tv.setOnClickListener(this);
        ans4Tv.setOnClickListener(this);

        //Arraylist to store index of wrong answers
        wrongAnswersLevelOne = new ArrayList<>();
        wrongAnswersLevelTwo = new ArrayList<>();
        wrongAnswersLevelThree = new ArrayList<>();
        wrongAnswersLevelFour = new ArrayList<>();
        wrongAnswersLevelFive = new ArrayList<>();

        try {
            if (questionsObject != null) {
                questionTv.setText(questionsObject.getString("question"));
                ans1Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(0));
                ans2Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(1));
                ans3Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(2));
                ans4Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(3));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.answer1_tv:
                selectedAnswer = ans1Tv.getText().toString();
                checkForCorrectAnswer();
                break;
            case R.id.answer2_tv:
                selectedAnswer = ans2Tv.getText().toString();
                checkForCorrectAnswer();
                break;
            case R.id.answer3_tv:
                selectedAnswer = ans3Tv.getText().toString();
                checkForCorrectAnswer();
                break;
            case R.id.answer4_tv:
                selectedAnswer = ans4Tv.getText().toString();
                checkForCorrectAnswer();
                break;

        }
    }

    //Switch to next question
    private void changeQuestion() {
        questionIndex++;
        try {

            questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);
            questionTv.setText(questionsObject.getString("question"));
            ans1Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(0));
            ans2Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(1));
            ans3Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(2));
            ans4Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Check the answer
    private void checkForCorrectAnswer() {
        try {
            if (selectedAnswer.equals(questionsObject.getString("correct_answer"))) {
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                changeQuestion();

            } else {

                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Wrong Answer!")
                        .setContentText("Correct Answer : " + questionsObject.getString("correct_answer"))
                        .setConfirmText("Next")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();
                                changeQuestion();
                            }
                        })
                        .show();

                if (source.equals("one"))
                    wrongAnswersLevelOne.add(questionsObject.getString("id"));
                else if (source.equals("two"))
                    wrongAnswersLevelTwo.add(questionsObject.getString("id"));
                else if (source.equals("three"))
                    wrongAnswersLevelThree.add(questionsObject.getString("id"));
                else if (source.equals("four"))
                    wrongAnswersLevelFour.add(questionsObject.getString("id"));
                else
                    wrongAnswersLevelFive.add(questionsObject.getString("id"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
