package com.example.uddishverma.quiz_app.Activities;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
    ProgressBar progressBarOne, progressBarTwo, progressBarThree, progressBarFour, progressBarFive;
    String levelOneSize, levelTwoSize, levelThreeSize, levelFourSize, levelFiveSize;
    TextView levelSizeOneTv, levelSizeTwoTv, levelSizeThreeTv, levelSizeFourTv, levelSizeFiveTv;
    ImageView imgOne, imgTwo, imgThree, imgFour, imgFive;

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

        progressBarOne = findViewById(R.id.prog_bar_1);
        progressBarTwo = findViewById(R.id.prog_bar_2);
        progressBarThree = findViewById(R.id.prog_bar_3);
        progressBarFour = findViewById(R.id.prog_bar_4);
        progressBarFive = findViewById(R.id.prog_bar_5);

        levelSizeOneTv = findViewById(R.id.level_size_one);
        levelSizeTwoTv = findViewById(R.id.level_size_two);
        levelSizeThreeTv = findViewById(R.id.level_size_three);
        levelSizeFourTv = findViewById(R.id.level_size_four);
        levelSizeFiveTv = findViewById(R.id.level_size_five);

        imgOne = findViewById(R.id.img_one);
        imgTwo = findViewById(R.id.img_two);
        imgThree = findViewById(R.id.img_three);
        imgFour = findViewById(R.id.img_four);
        imgFive = findViewById(R.id.img_five);

        levelOneSize = Preferences.getPrefs("sizeListLevelOne", MainActivity.this);
        levelTwoSize = Preferences.getPrefs("sizeListLevelTwo", MainActivity.this);
        levelThreeSize = Preferences.getPrefs("sizeListLevelThree", MainActivity.this);
        levelFourSize = Preferences.getPrefs("sizeListLevelFour", MainActivity.this);
        levelFiveSize = Preferences.getPrefs("sizeListLevelFive", MainActivity.this);

        if (levelOneSize.equals("notfound")) {
            levelSizeOneTv.setText("0/10");
            mAnimator = ObjectAnimator.ofInt(progressBarOne, "progress", 2);
            mAnimator.start();
        } else {
            if (Integer.parseInt(levelOneSize) == 0) {
                //Setting the icons
                imgOne.setImageResource(R.drawable.tick_icon);
                imgTwo.setImageResource(R.drawable.ic_keyboard_arrow_right);
            }
            levelSizeOneTv.setText((10 - Integer.parseInt(levelOneSize)) + "/10");
            mAnimator = ObjectAnimator.ofInt(progressBarOne, "progress", (10 - Integer.parseInt(levelOneSize)) * 10);
            mAnimator.start();
        }

        if (levelTwoSize.equals("notfound")) {
            levelSizeTwoTv.setText("0/10");
            mAnimator = ObjectAnimator.ofInt(progressBarTwo, "progress", 2);
            mAnimator.start();
        } else {
            if (Integer.parseInt(levelTwoSize) == 0) {
                //Setting the icons
                imgTwo.setImageResource(R.drawable.tick_icon);
                imgThree.setImageResource(R.drawable.ic_keyboard_arrow_right);
            }

            levelSizeTwoTv.setText((10 - Integer.parseInt(levelTwoSize)) + "/10");
            mAnimator = ObjectAnimator.ofInt(progressBarTwo, "progress", (10 - Integer.parseInt(levelTwoSize)) * 10);
            mAnimator.start();
        }

        if (levelThreeSize.equals("notfound")) {
            levelSizeThreeTv.setText("0/10");
            mAnimator = ObjectAnimator.ofInt(progressBarThree, "progress", 2);
            mAnimator.start();

        } else {
            if (Integer.parseInt(levelThreeSize) == 0) {
                //Setting the icons
                imgThree.setImageResource(R.drawable.tick_icon);
                imgFour.setImageResource(R.drawable.ic_keyboard_arrow_right);
            }
            levelSizeThreeTv.setText((10 - Integer.parseInt(levelThreeSize)) + "/10");
            mAnimator = ObjectAnimator.ofInt(progressBarThree, "progress", (10 - Integer.parseInt(levelThreeSize)) * 10);
            mAnimator.start();
        }

        if (levelFourSize.equals("notfound")) {
            levelSizeFourTv.setText("0/10");
            mAnimator = ObjectAnimator.ofInt(progressBarFour, "progress", 2);
            mAnimator.start();
        } else {
            if (Integer.parseInt(levelFourSize) == 0) {
                //Setting the icons
                imgFour.setImageResource(R.drawable.tick_icon);
                imgFive.setImageResource(R.drawable.ic_keyboard_arrow_right);
            }
            levelSizeFourTv.setText((10 - Integer.parseInt(levelFourSize)) + "/10");
            mAnimator = ObjectAnimator.ofInt(progressBarFour, "progress", (10 - Integer.parseInt(levelFourSize)) * 10);
            mAnimator.start();
        }

        if (levelFiveSize.equals("notfound")) {
            levelSizeFiveTv.setText("0/10");
            mAnimator = ObjectAnimator.ofInt(progressBarFive, "progress", 2);
            mAnimator.start();
        } else {
            if (Integer.parseInt(levelFiveSize) == 0) {
                //Setting the icons
                imgFive.setImageResource(R.drawable.tick_icon);
            }
            levelSizeFiveTv.setText((10 - Integer.parseInt(levelFiveSize)) + "/10");
            mAnimator = ObjectAnimator.ofInt(progressBarFive, "progress", (10 - Integer.parseInt(levelFiveSize)) * 10);
            mAnimator.start();
        }

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
                    Toast.makeText(this, "Level 1 Completed!", Toast.LENGTH_SHORT).show();
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
            case R.id.level_two:
                levelSelected = "two";
                if ((Preferences.getPrefs("isLevelTwoCompleted", MainActivity.this)).equals("2002")) {
                    Toast.makeText(this, "Level 2 Completed!", Toast.LENGTH_SHORT).show();
                } else if (!(Preferences.getPrefs("isLevelOneCompleted", MainActivity.this)).equals("2001")) {
                    Toast.makeText(this, "Complete Level 1 First", Toast.LENGTH_SHORT).show();
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
            case R.id.level_three:
                levelSelected = "three";
                if ((Preferences.getPrefs("isLevelThreeCompleted", MainActivity.this)).equals("2003")) {
                    Toast.makeText(this, "Level 3 Completed!", Toast.LENGTH_SHORT).show();
                } else if (!(Preferences.getPrefs("isLevelTwoCompleted", MainActivity.this)).equals("2002")) {
                    Toast.makeText(this, "Complete Level 2 First", Toast.LENGTH_SHORT).show();
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
            case R.id.level_four:
                levelSelected = "four";
                if ((Preferences.getPrefs("isLevelFourCompleted", MainActivity.this)).equals("2004")) {
                    Toast.makeText(this, "Level 4 Completed!", Toast.LENGTH_SHORT).show();
                } else if (!(Preferences.getPrefs("isLevelThreeCompleted", MainActivity.this)).equals("2003")) {
                    Toast.makeText(this, "Complete Level 3 First", Toast.LENGTH_SHORT).show();
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
            case R.id.level_five:
                levelSelected = "five";
                if ((Preferences.getPrefs("isLevelFiveCompleted", MainActivity.this)).equals("2005")) {
                    Toast.makeText(this, "Level 5 Completed!", Toast.LENGTH_SHORT).show();
                } else if (!(Preferences.getPrefs("isLevelFourCompleted", MainActivity.this)).equals("2004")) {
                    Toast.makeText(this, "Complete Level 4 First", Toast.LENGTH_SHORT).show();
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
        }
    }


}
