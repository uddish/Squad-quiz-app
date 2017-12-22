package com.example.uddishverma.quiz_app.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uddishverma.quiz_app.R;
import com.example.uddishverma.quiz_app.Utils.Globals;
import com.example.uddishverma.quiz_app.Utils.Preferences;

import java.util.logging.Level;

public class LevelCompleted extends AppCompatActivity {

    Button nextLevel;
    Intent i;
    String source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_completed);

        i = getIntent();

        Globals.isMasteredQuestionsAdded = 9001;
        Preferences.setPrefs("isMasteredQuestionsAdded", String.valueOf(Globals.isMasteredQuestionsAdded), LevelCompleted.this);

        nextLevel = findViewById(R.id.next_level_button);

        source = i.getStringExtra("source");

        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LevelCompleted.this, QuestionActivity.class);

                if (source.equals("one")) {
                    i.putExtra("levelSelected", "two");
                    Preferences.setPrefs("isLevelOneReset", String.valueOf(7001), LevelCompleted.this);
                    if (!Preferences.getPrefs("levelTwoList", LevelCompleted.this).equals("notfound")) {
                        startActivity(new Intent(LevelCompleted.this, MainActivity.class));
                    } else {
                        startActivity(i);
                    }
                    finish();
                }
                if (source.equals("two")) {
                    i.putExtra("levelSelected", "three");
                    Preferences.setPrefs("isLevelTwoReset", String.valueOf(7002), LevelCompleted.this);
                    if (!Preferences.getPrefs("levelThreeList", LevelCompleted.this).equals("notfound")) {
                        startActivity(new Intent(LevelCompleted.this, MainActivity.class));
                    } else {
                        startActivity(i);
                    }
                    finish();
                }
                if (source.equals("three")) {
                    i.putExtra("levelSelected", "four");
                    Globals.isLevelThreeReset = 7003;
                    Preferences.setPrefs("isLevelThreeReset", String.valueOf(7003), LevelCompleted.this);
                    if (!Preferences.getPrefs("levelFourList", LevelCompleted.this).equals("notfound")) {
                        startActivity(new Intent(LevelCompleted.this, MainActivity.class));
                    } else {
                        startActivity(i);
                    }
                    finish();
                }
                if (source.equals("four")) {
                    i.putExtra("levelSelected", "five");
                    Globals.isLevelFourReset = 7004;
                    Preferences.setPrefs("isLevelFourReset", String.valueOf(7004), LevelCompleted.this);
                    if (!Preferences.getPrefs("levelFiveList", LevelCompleted.this).equals("notfound")) {
                        startActivity(new Intent(LevelCompleted.this, MainActivity.class));
                    } else {
                        startActivity(i);
                    }
                    finish();
                }
                if (source.equals("five")) {
                    Globals.isLevelFiveReset = 7005;
                    Preferences.setPrefs("isLevelFiveReset", String.valueOf(7005), LevelCompleted.this);
                    startActivity(new Intent(LevelCompleted.this, MainActivity.class));
                }
            }
        });
    }

    public void onBackPressed() {
        this.startActivity(new Intent(LevelCompleted.this, MainActivity.class));
        finish();
        return;
    }
}
