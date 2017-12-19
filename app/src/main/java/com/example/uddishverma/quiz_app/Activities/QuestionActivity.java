package com.example.uddishverma.quiz_app.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.uddishverma.quiz_app.R;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    TextView ans1Tv, ans2Tv, ans3Tv, ans4Tv;
    TextView questionTv;
    ArrayList<String> questions;
    ArrayList<ArrayList<String>> answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }
}
