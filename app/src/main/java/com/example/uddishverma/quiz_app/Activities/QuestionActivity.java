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
    ArrayList<String> wrongAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        i = getIntent();


        try {

            Log.d(TAG, "onCreate: " + LevelWiseQuestions.levelThreeQuestions);

            if (i.getStringExtra("levelSelected").equals("one")) {
                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelOneQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);
            } else if (i.getStringExtra("levelSelected").equals("two")) {
                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelTwoQuestions);
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
        wrongAnswers = new ArrayList<>();

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
        Log.d(TAG, "changeQuestion: " + wrongAnswers);
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
                Toast.makeText(this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                wrongAnswers.add(questionsObject.getString("id"));
                changeQuestion();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
