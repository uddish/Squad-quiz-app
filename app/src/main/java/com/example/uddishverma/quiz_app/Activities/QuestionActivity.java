package com.example.uddishverma.quiz_app.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uddishverma.quiz_app.R;
import com.example.uddishverma.quiz_app.Utils.Globals;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "QuestionActivity";
    TextView ans1Tv, ans2Tv, ans3Tv, ans4Tv;
    TextView questionTv, reviewTv;
    ArrayList<String> totalQuestions, correctQuestions;
    HashMap<String, Integer> reviewQuestionsMap;
    Intent i;
    JSONObject levelWiseQuestions;
    JSONObject questionsObject;
    int questionIndex = 0;
    String selectedAnswer;
    String source;
    ArrayList<String> wrongAnswersLevelOne, wrongAnswersLevelTwo, wrongAnswersLevelThree, wrongAnswersLevelFour, wrongAnswersLevelFive;
    static int randomIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        i = getIntent();

        totalQuestions = new ArrayList<>();
        correctQuestions = new ArrayList<>();
        reviewQuestionsMap = loadHashMap(i.getStringExtra("levelSelected"));

        try {

            /*
             * Retrieving the data from the shared preferences
             * When not found -> copying the questions to arraylist
             */

            if (i.getStringExtra("levelSelected").equals("one")) {
                source = "one";

                levelWiseQuestions = new JSONObject(LevelWiseQuestions.levelOneQuestions);
                questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(questionIndex);

                if (Preferences.getPrefs("levelOneList", QuestionActivity.this).equals("notfound")) {
                    totalQuestions = new ArrayList<>();
                    Log.d(TAG, "onCreate: Arraylist 1 does not exists");
                    for (int i = 0; i < 10; i++) {
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id"))));
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
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id"))));
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
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id"))));
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
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id"))));
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
                        totalQuestions.add(String.valueOf(Integer.parseInt(levelWiseQuestions.getJSONArray("results").getJSONObject(i).getString("id"))));
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
        reviewTv = findViewById(R.id.review_tv);

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

        //Shuffle arraylist and show a random question;
        String previousIndex = null;


        if (totalQuestions.size() > 0) {
            previousIndex = totalQuestions.get(0);
            Collections.shuffle(totalQuestions);
        }

        //Check for same questions if repeating
        if (totalQuestions.size() != 1 && totalQuestions.size() > 0) {
            while (totalQuestions.get(0).equals(previousIndex)) {
                Log.d(TAG, "changeQuestion: Repeating questions");
                Collections.shuffle(totalQuestions);
            }
            randomIndex = Integer.parseInt(totalQuestions.get(0));
        } else if (totalQuestions.size() == 1) {
            randomIndex = Integer.parseInt(totalQuestions.get(0));
        }

        //Setting if the question is reviewed or learned
        try {
//
            if (totalQuestions.size() == 0) {
                Intent i = new Intent(QuestionActivity.this, LevelCompleted.class);
                i.putExtra("source", source);
                if (source.equals("one")) {
                    Globals.isLevelOneCompleted = 2001;
                    Preferences.setPrefs("isLevelOneCompleted", String.valueOf(Globals.isLevelOneCompleted), QuestionActivity.this);
                } else if (source.equals("two")) {
                    Globals.isLevelTwoCompleted = 2002;
                    Preferences.setPrefs("isLevelTwoCompleted", String.valueOf(Globals.isLevelTwoCompleted), QuestionActivity.this);
                } else if (source.equals("three")) {
                    Globals.isLevelThreeCompleted = 2003;
                    Preferences.setPrefs("isLevelThreeCompleted", String.valueOf(Globals.isLevelThreeCompleted), QuestionActivity.this);
                } else if (source.equals("four")) {
                    Globals.isLevelTwoCompleted = 2004;
                    Preferences.setPrefs("isLevelFourCompleted", String.valueOf(Globals.isLevelFourCompleted), QuestionActivity.this);
                } else if (source.equals("five")) {
                    Globals.isLevelTwoCompleted = 2005;
                    Preferences.setPrefs("isLevelFiveCompleted", String.valueOf(Globals.isLevelFiveCompleted), QuestionActivity.this);
                }

                startActivity(i);
                finish();
            }

            /**
             *
             * Saving Arraylist of wrong questions
             * Saving hashmap of wrong questions for reviewing
             * Saving size of arraylist
             */
            Gson gson = new Gson();
            String remainingQuestions = gson.toJson(totalQuestions);
            if (source.equals("one")) {
                Preferences.setPrefs("levelOneList", remainingQuestions, getApplicationContext());
                //Saving the size of the arraylist
                Preferences.setPrefs("sizeListLevelOne", String.valueOf(totalQuestions.size()), QuestionActivity.this);
                //Saving hashmap of level 1
                saveHashMap(reviewQuestionsMap, source);
            } else if (source.equals("two")) {
                Preferences.setPrefs("levelTwoList", remainingQuestions, getApplicationContext());
                //Saving the size of the arraylist
                Preferences.setPrefs("sizeListLevelTwo", String.valueOf(totalQuestions.size()), QuestionActivity.this);
                //Saving hashmap of level 2
                saveHashMap(reviewQuestionsMap, source);
            } else if (source.equals("three")) {
                Preferences.setPrefs("sizeListLevelThree", String.valueOf(totalQuestions.size()), QuestionActivity.this);
                //Saving the size of the arraylist
                Preferences.setPrefs("levelThreeList", remainingQuestions, getApplicationContext());
                //Saving hashmap of level 3
                saveHashMap(reviewQuestionsMap, source);
            } else if (source.equals("four")) {
                Preferences.setPrefs("levelFourList", remainingQuestions, getApplicationContext());
                //Saving the size of the arraylist
                Preferences.setPrefs("sizeListLevelFour", String.valueOf(totalQuestions.size()), QuestionActivity.this);
                //Saving hashmap of level 4
                saveHashMap(reviewQuestionsMap, source);
            } else {
                Preferences.setPrefs("levelFiveList", remainingQuestions, getApplicationContext());
                //Saving the size of the arraylist
                Preferences.setPrefs("sizeListLevelFive", String.valueOf(totalQuestions.size()), QuestionActivity.this);
                //Saving hashmap of level 5
                saveHashMap(reviewQuestionsMap, source);
            }

            //getting the correct indexed question
            questionsObject = levelWiseQuestions.getJSONArray("results").getJSONObject(randomIndex);
            questionTv.setText(questionsObject.getString("question"));
            ans1Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(0));
            ans2Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(1));
            ans3Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(2));
            ans4Tv.setText(questionsObject.getJSONArray("incorrect_answers").getString(3));

            //Checking the status of wrong question (Review/Learning)
            if (reviewQuestionsMap.containsKey(questionsObject.getString("id"))) {
                if (reviewQuestionsMap.get(questionsObject.getString("id")) == 3) {
                    reviewTv.setText("Learning");
                    reviewTv.setBackgroundResource(R.drawable.red_box);
                } else if (reviewQuestionsMap.get(questionsObject.getString("id")) < 3) {
                    reviewTv.setText("Revising");
                    reviewTv.setBackgroundResource(R.drawable.green_box);
                }
            } else {
                reviewTv.setBackgroundResource(R.color.white);
                reviewTv.setText(" ");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Check the answer
    private void checkForCorrectAnswer() {
        try {

            String questionId = String.valueOf(questionsObject.getString("id"));

            if (selectedAnswer.equals(questionsObject.getString("correct_answer"))) {

                if (reviewQuestionsMap.containsKey(questionId)) {
                    reviewQuestionsMap.put(questionId, reviewQuestionsMap.get(questionId) - 1);
                    if (reviewQuestionsMap.get(questionId) == 0) {
                        totalQuestions.remove(0);
                    }
                } else {
                    totalQuestions.remove(0);
                }

                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();

                //Adding the id of the correct questions;
                correctQuestions.add(questionId);

                changeQuestion();

                Log.d(TAG, " Value ---> " + reviewQuestionsMap.get(questionId) + ", Key -----> " + questionId);

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

                Log.d(TAG, " Value ---> " + reviewQuestionsMap.get(questionId) + ", Key -----> " + questionId);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void saveHashMap(HashMap<String, Integer> map, String source) {
        JSONObject jsonObject = new JSONObject(map);
        String mapString = jsonObject.toString();
        if (source.equals("one")) {
            Preferences.setPrefs("levelOneMap", mapString, QuestionActivity.this);
        } else if (source.equals("two")) {
            Preferences.setPrefs("levelTwoMap", mapString, QuestionActivity.this);
        } else if (source.equals("three")) {
            Preferences.setPrefs("levelthreeMap", mapString, QuestionActivity.this);
        } else if (source.equals("four")) {
            Preferences.setPrefs("levelFourMap", mapString, QuestionActivity.this);
        } else if (source.equals("five")) {
            Preferences.setPrefs("levelFiveMap", mapString, QuestionActivity.this);
        }
    }

    private HashMap<String, Integer> loadHashMap(String source) {
        HashMap<String, Integer> map = new HashMap<>();

        String mapString = null;

        if (source.equals("one")) {
            mapString = Preferences.getPrefs("levelOneMap", QuestionActivity.this);
        } else if (source.equals("two")) {
            mapString = Preferences.getPrefs("levelTwoMap", QuestionActivity.this);
        } else if (source.equals("three")) {
            mapString = Preferences.getPrefs("levelThreeMap", QuestionActivity.this);
        } else if (source.equals("four")) {
            mapString = Preferences.getPrefs("levelFourMap", QuestionActivity.this);
        } else if (source.equals("five")) {
            mapString = Preferences.getPrefs("levelFiveMap", QuestionActivity.this);
        }

        try {
            //If no stored hashmap is found return a new hashmap
            if (mapString.equals("notfound")) {
                Log.d(TAG, "loadHashMap: Returning new Hashmap as no saved hashmap is found");
                map = new HashMap<>();
                return map;
            } else {
                Log.d(TAG, "loadHashMap: Loading hashmap from memory");
                JSONObject jsonObject = new JSONObject(mapString);
                Iterator<String> keyItr = jsonObject.keys();
                while (keyItr.hasNext()) {
                    String k = keyItr.next();
                    Integer v = (Integer) jsonObject.get(k);
                    map.put(k, v);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return map;
    }

    public void onBackPressed() {
        this.startActivity(new Intent(QuestionActivity.this, MainActivity.class));
        finish();
        return;
    }

}
