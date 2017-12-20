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
import com.example.uddishverma.quiz_app.Utils.Preferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "QuestionActivity";
    TextView ans1Tv, ans2Tv, ans3Tv, ans4Tv;
    TextView questionTv;
    ArrayList<String> totalQuestions, correctQuestions, wrongQuestions;
    HashMap<String, Integer> reviewQuestionsMap;
    Intent i;
    JSONObject levelWiseQuestions;
    JSONObject questionsObject;
    int questionIndex = 0;
    String selectedAnswer;
    String source;
    ArrayList<String> wrongAnswersLevelOne, wrongAnswersLevelTwo, wrongAnswersLevelThree, wrongAnswersLevelFour, wrongAnswersLevelFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        i = getIntent();

        totalQuestions = new ArrayList<>();
        correctQuestions = new ArrayList<>();
        reviewQuestionsMap = new HashMap<String, Integer>();

        try {

            if (i.getStringExtra("levelSelected").equals("one")) {
                source = "one";

                /**
                 * Retrieving the data from the shared preferences
                 * When not found -> copying the questions to arraylist
                 */

                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelOneQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);

                if (Preferences.getPrefs("levelOneList", QuestionActivity.this).equals("notfound")) {
                    totalQuestions = new ArrayList<>();
                    Log.d(TAG, "onCreate: Arraylist 1 does not exists");
                    for (int i = 0; i < 10; i++) {
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id")) - 1));
                    }
                } else {
                    String preferenceString = Preferences.getPrefs("levelOneList", QuestionActivity.this);
                    totalQuestions = changeStringToList(preferenceString);
                }

            } else if (i.getStringExtra("levelSelected").equals("two")) {
                source = "two";
                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelTwoQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);

                if (Preferences.getPrefs("levelTwoList", QuestionActivity.this).equals("notfound")) {
                    totalQuestions = new ArrayList<>();
                    Log.d(TAG, "onCreate: Arraylist 2 does not exists");
                    for (int i = 0; i < 10; i++) {
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id")) - 1));
                    }
                } else {
                    String preferenceString = Preferences.getPrefs("levelTwoList", QuestionActivity.this);
                    totalQuestions = changeStringToList(preferenceString);
                }
            } else if (i.getStringExtra("levelSelected").equals("three")) {
                source = "three";
                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelThreeQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);

                if (Preferences.getPrefs("levelThreeList", QuestionActivity.this).equals("notfound")) {
                    totalQuestions = new ArrayList<>();
                    Log.d(TAG, "onCreate: Arraylist 3 does not exists");
                    for (int i = 0; i < 10; i++) {
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id")) - 1));
                    }
                } else {
                    String preferenceString = Preferences.getPrefs("levelThreeList", QuestionActivity.this);
                    totalQuestions = changeStringToList(preferenceString);
                }
            } else if (i.getStringExtra("levelSelected").equals("four")) {
                source = "four";

                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelFourQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);

                if (Preferences.getPrefs("levelFourList", QuestionActivity.this).equals("notfound")) {
                    totalQuestions = new ArrayList<>();
                    Log.d(TAG, "onCreate: Arraylist 4 does not exists");
                    for (int i = 0; i < 10; i++) {
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id")) - 1));
                    }
                } else {
                    String preferenceString = Preferences.getPrefs("levelFourList", QuestionActivity.this);
                    totalQuestions = changeStringToList(preferenceString);
                }

            } else if (i.getStringExtra("levelSelected").equals("five")) {
                source = "five";

                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelFiveQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);

                if (Preferences.getPrefs("levelFiveList", QuestionActivity.this).equals("notfound")) {
                    totalQuestions = new ArrayList<>();
                    Log.d(TAG, "onCreate: Arraylist 5 does not exists");
                    for (int i = 0; i < 10; i++) {
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id")) - 1));
                    }
                } else {
                    String preferenceString = Preferences.getPrefs("levelFiveList", QuestionActivity.this);
                    totalQuestions = changeStringToList(preferenceString);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        initView();

    }

    //Change string retrieved from preferences to ArrayList
    private ArrayList<String> changeStringToList(String preferenceString) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        ArrayList<String> arrayList = gson.fromJson(preferenceString, type);
        return arrayList;
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
            questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(Integer.parseInt(totalQuestions.get(0)));
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

        Log.d(TAG, "changeQuestion: Total Questions " + totalQuestions);
        questionIndex++;

        //TODO check if the question is repeated or not
        //Shuffle arraylist and show a random question;
        String previousIndex = null;

        if (totalQuestions.size() > 0) {
            previousIndex = totalQuestions.get(0);
            Collections.shuffle(totalQuestions);
        }

        //Check for same questions if repeating
        int randomIndex = 0;
        if (totalQuestions.size() != 1 && totalQuestions.size() > 0) {
            while (totalQuestions.get(0).equals(previousIndex)) {
                Log.d(TAG, "changeQuestion: Repeating questions");
                Collections.shuffle(totalQuestions);
            }
            randomIndex = Integer.parseInt(totalQuestions.get(0));
        }

        if (totalQuestions.size() == 0) {
            Toast.makeText(this, "Level " + source + " completed!", Toast.LENGTH_SHORT).show();
        }

        //Adding current questions in shared preferences

        Gson gson = new Gson();
        String remainingQuestions = gson.toJson(totalQuestions);
        if (source.equals("one")) {
            Preferences.setPrefs("levelOneList", remainingQuestions, getApplicationContext());
        } else if (source.equals("two")) {
            Preferences.setPrefs("levelTwoList", remainingQuestions, getApplicationContext());
        } else if (source.equals("three")) {
            Preferences.setPrefs("levelThreeList", remainingQuestions, getApplicationContext());
        } else if (source.equals("four")) {
            Preferences.setPrefs("levelFourList", remainingQuestions, getApplicationContext());
        } else {
            Preferences.setPrefs("levelFiveList", remainingQuestions, getApplicationContext());
        }
        try {
            //getting the correct indexed question
            questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(randomIndex);
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

            String questionId = String.valueOf(Integer.parseInt(questionsObject.getString("id")) - 1);

            if (selectedAnswer.equals(questionsObject.getString("correct_answer"))) {

                if (reviewQuestionsMap.containsKey(questionId)) {
                    reviewQuestionsMap.put(questionId, reviewQuestionsMap.get(questionId) - 1);
                    if (reviewQuestionsMap.get(questionId) == 0) {
                        totalQuestions.remove(String.valueOf(questionId));
                    }
                } else {
                    totalQuestions.remove(String.valueOf(questionId));
                }

                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();

                //Adding the id of the correct questions;
                correctQuestions.add(questionId);

                //removing the correct answer from the arraylist

                changeQuestion();

            } else {

                //Add the status of wrong questions into the hashmap
                reviewQuestionsMap.put(questionId, 3);

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


            }

            Log.d(TAG, "checkForCorrectAnswer: " + questionId + "--->" + reviewQuestionsMap.get(questionId));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
