package com.example.uddishverma.quiz_app.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.uddishverma.quiz_app.Fragments.QuizFragment;
import com.example.uddishverma.quiz_app.R;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        QuizFragment fragment = new QuizFragment();
        fragmentTransaction.add(R.id.fragment_container, fragment, "Bonus Guidelines");
        fragmentTransaction.commit();

    }
}
