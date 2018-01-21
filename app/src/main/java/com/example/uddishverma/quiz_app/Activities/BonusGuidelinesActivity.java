package com.example.uddishverma.quiz_app.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.uddishverma.quiz_app.Fragments.BonusGuidelinesFragment;
import com.example.uddishverma.quiz_app.R;

public class BonusGuidelinesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_guidelines);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Bonus");


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BonusGuidelinesFragment hello = new BonusGuidelinesFragment();
        fragmentTransaction.add(R.id.fragment_container, hello, "Bonus Guidelines");
        fragmentTransaction.commit();

    }

}
