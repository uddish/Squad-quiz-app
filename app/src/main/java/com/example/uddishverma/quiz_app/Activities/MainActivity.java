package com.example.uddishverma.quiz_app.Activities;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.uddishverma.quiz_app.R;
import com.example.uddishverma.quiz_app.Utils.Globals;
import com.example.uddishverma.quiz_app.Utils.Preferences;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

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

        //Fetching the reset value of the levels
        if (!Preferences.getPrefs("isLevelOneReset", MainActivity.this).equals("notfound"))
            Globals.isLevelOneReset = Integer.parseInt(Preferences.getPrefs("isLevelOneReset", MainActivity.this));
        if (!Preferences.getPrefs("isLevelTwoReset", MainActivity.this).equals("notfound"))
            Globals.isLevelTwoReset = Integer.parseInt(Preferences.getPrefs("isLevelTwoReset", MainActivity.this));
        if (!Preferences.getPrefs("isLevelThreeReset", MainActivity.this).equals("notfound"))
            Globals.isLevelThreeReset = Integer.parseInt(Preferences.getPrefs("isLevelThreeReset", MainActivity.this));
        if (!Preferences.getPrefs("isLevelFourReset", MainActivity.this).equals("notfound"))
            Globals.isLevelFourReset = Integer.parseInt(Preferences.getPrefs("isLevelFourReset", MainActivity.this));
        if (!Preferences.getPrefs("isLevelFiveReset", MainActivity.this).equals("notfound"))
            Globals.isLevelFiveReset = Integer.parseInt(Preferences.getPrefs("isLevelFiveReset", MainActivity.this));

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
        if (Globals.isLevelOneReset == 8001)
            imgTwo.setImageResource(R.drawable.ic_keyboard_arrow_right);


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
        if (Globals.isLevelTwoReset == 8002)
            imgThree.setImageResource(R.drawable.ic_keyboard_arrow_right);


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
        if (Globals.isLevelThreeReset == 8003)
            imgFour.setImageResource(R.drawable.ic_keyboard_arrow_right);


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
        if (Globals.isLevelFourReset == 8004)
            imgFive.setImageResource(R.drawable.ic_keyboard_arrow_right);

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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_opensource) {
            startActivity(new Intent(getApplicationContext(), OpenSource.class));
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
                if ((Preferences.getPrefs("isLevelOneCompleted", MainActivity.this)).equals("2001")
                        && Globals.isLevelOneReset == 7001) {
                    showResetAlert(levelSelected);
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
            case R.id.level_two:
                levelSelected = "two";
                if ((Preferences.getPrefs("isLevelTwoCompleted", MainActivity.this)).equals("2002")
                        && Globals.isLevelTwoReset == 7002) {
                    showResetAlert(levelSelected);
                } else if (!(Preferences.getPrefs("isLevelOneCompleted", MainActivity.this)).equals("2001")
                        && Globals.isLevelOneReset == 7001) {
                    showAlert("Complete Level 1 First");
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
            case R.id.level_three:
                levelSelected = "three";
                if ((Preferences.getPrefs("isLevelThreeCompleted", MainActivity.this)).equals("2003")
                        && Globals.isLevelThreeReset == 7003) {
                    showResetAlert(levelSelected);
                } else if (!(Preferences.getPrefs("isLevelTwoCompleted", MainActivity.this)).equals("2002")) {
                    showAlert("Complete Level 2 First");
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
            case R.id.level_four:
                levelSelected = "four";
                if ((Preferences.getPrefs("isLevelFourCompleted", MainActivity.this)).equals("2004")
                        && Globals.isLevelFourReset == 7004) {
                    showResetAlert(levelSelected);
                } else if (!(Preferences.getPrefs("isLevelThreeCompleted", MainActivity.this)).equals("2003")) {
                    showAlert("Complete Level 3 First");
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
            case R.id.level_five:
                levelSelected = "five";
                if ((Preferences.getPrefs("isLevelFiveCompleted", MainActivity.this)).equals("2005")
                        && Globals.isLevelFiveReset == 7005) {
                    showResetAlert(levelSelected);

                } else if (!(Preferences.getPrefs("isLevelFourCompleted", MainActivity.this)).equals("2004")) {
                    showAlert("Complete Level 4 First");
                } else {
                    i.putExtra("levelSelected", levelSelected);
                    startActivity(i);
                    finish();
                }
                break;
        }
    }

    private void showAlert(String s) {

        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Level Locked!")
                .setContentText(s)
                .show();
    }

    private void showResetAlert(String source) {
        final String level = source;
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Level Completed!")
                .setContentText("Do you want to reset this level?")
                .setConfirmText("Reset")
                .setCancelButton("No", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                        resetLevel(level);
                    }
                })
                .show();
    }

    private void resetLevel(String source) {

        if (source.equals("one")) {
            Globals.isLevelOneReset = 8001;
            Preferences.setPrefs("isLevelOneReset", String.valueOf(8001), MainActivity.this);
            Preferences.setPrefs("levelOneList", "notfound", MainActivity.this);
            levelSizeOneTv.setText("0/10");
            Preferences.setPrefs("sizeListLevelOne", "notfound", MainActivity.this);
            Preferences.setPrefs("levelOneMap", "notfound", MainActivity.this);
            imgOne.setImageResource(R.drawable.ic_keyboard_arrow_right);
            mAnimator = ObjectAnimator.ofInt(progressBarOne, "progress", 2);
        }
        if (source.equals("two")) {
            Globals.isLevelTwoReset = 8002;
            Preferences.setPrefs("isLevelTwoReset", String.valueOf(8002), MainActivity.this);
            Preferences.setPrefs("levelTwoList", "notfound", MainActivity.this);
            levelSizeTwoTv.setText("0/10");
            Preferences.setPrefs("sizeListLevelTwo", "notfound", MainActivity.this);
            Preferences.setPrefs("levelTwoMap", "notfound", MainActivity.this);
            imgTwo.setImageResource(R.drawable.ic_keyboard_arrow_right);
            mAnimator = ObjectAnimator.ofInt(progressBarTwo, "progress", 2);
        }
        if (source.equals("three")) {
            Globals.isLevelThreeReset = 8003;
            Preferences.setPrefs("isLevelThreeReset", String.valueOf(8003), MainActivity.this);
            Preferences.setPrefs("levelThreeList", "notfound", MainActivity.this);
            levelSizeThreeTv.setText("0/10");
            Preferences.setPrefs("sizeListLevelThree", "notfound", MainActivity.this);
            Preferences.setPrefs("levelThreeMap", "notfound", MainActivity.this);
            imgThree.setImageResource(R.drawable.ic_keyboard_arrow_right);
            mAnimator = ObjectAnimator.ofInt(progressBarThree, "progress", 2);
        }
        if (source.equals("four")) {
            Globals.isLevelFourReset = 8004;
            Preferences.setPrefs("isLevelFourReset", String.valueOf(8004), MainActivity.this);
            Preferences.setPrefs("levelFourList", "notfound", MainActivity.this);
            levelSizeFourTv.setText("0/10");
            Preferences.setPrefs("sizeListLevelFour", "notfound", MainActivity.this);
            Preferences.setPrefs("levelFourMap", "notfound", MainActivity.this);
            imgFour.setImageResource(R.drawable.ic_keyboard_arrow_right);
            mAnimator = ObjectAnimator.ofInt(progressBarFour, "progress", 2);
        }
        if (source.equals("five")) {
            Globals.isLevelFiveReset = 8005;
            Preferences.setPrefs("isLevelFiveReset", String.valueOf(8005), MainActivity.this);
            Preferences.setPrefs("levelFiveList", "notfound", MainActivity.this);
            levelSizeFiveTv.setText("0/10");
            Preferences.setPrefs("sizeListLevelFive", "notfound", MainActivity.this);
            Preferences.setPrefs("levelFiveMap", "notfound", MainActivity.this);
            imgFive.setImageResource(R.drawable.ic_keyboard_arrow_right);
            mAnimator = ObjectAnimator.ofInt(progressBarFive, "progress", 2);
        }


        mAnimator.start();
    }


}
