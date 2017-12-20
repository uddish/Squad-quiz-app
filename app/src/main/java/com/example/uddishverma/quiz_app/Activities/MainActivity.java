package com.example.uddishverma.quiz_app.Activities;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.uddishverma.quiz_app.R;
import com.example.uddishverma.quiz_app.Utils.Preferences;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final String TAG = "MainActivity";
    CardView levelOne, levelTwo, levelThree, levelFour, levelFive;
    String levelSelected;
    Intent i;
    ObjectAnimator mAnimator;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        i = new Intent(MainActivity.this, QuestionActivity.class);

        //Handling click listeners on the card views
        levelOne.setOnClickListener(this);
        levelTwo.setOnClickListener(this);
        levelThree.setOnClickListener(this);
        levelFour.setOnClickListener(this);
        levelFive.setOnClickListener(this);

    }

    private void initView() {

        levelOne = findViewById(R.id.level_one);
        levelTwo = findViewById(R.id.level_two);
        levelThree = findViewById(R.id.level_three);
        levelFour = findViewById(R.id.level_four);
        levelFive = findViewById(R.id.level_five);
        progressBar = findViewById(R.id.prog_bar);

        mAnimator = ObjectAnimator.ofInt(progressBar, "progress", 50);
//        mAnimator.setDuration(1000);     //0.5 sec
//        mAnimator.setInterpolator(new DecelerateInterpolator());
        mAnimator.start();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.level_one:
                levelSelected = "one";
                if ((Preferences.getPrefs("isLevelOneCompleted", MainActivity.this)).equals("2001")) {
                    Log.d(TAG, "TOAST: " + Preferences.getPrefs("isLevelOneSelected", getApplicationContext()));
                    Toast.makeText(this, "Level 1 Completed!", Toast.LENGTH_SHORT).show();
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    Log.d(TAG, "START ACTIVITY: " + Preferences.getPrefs("isLevelOneCompleted", getApplicationContext()));
                    startActivity(i);
                }
                break;
            case R.id.level_two:
                levelSelected = "two";
                i.putExtra("levelSelected", levelSelected);
                startActivity(i);
                break;
            case R.id.level_three:
                levelSelected = "three";
                i.putExtra("levelSelected", levelSelected);
                startActivity(i);
                break;
            case R.id.level_four:
                levelSelected = "four";
                i.putExtra("levelSelected", levelSelected);
                startActivity(i);
                break;
            case R.id.level_five:
                levelSelected = "five";
                i.putExtra("levelSelected", levelSelected);
                startActivity(i);
                break;
        }
    }
}
