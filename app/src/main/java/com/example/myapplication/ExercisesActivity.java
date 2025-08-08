package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        Button smallExerciseButton4 = findViewById(R.id.smallExerciseButton4);
        smallExerciseButton4.setBackgroundColor(Color.parseColor("#30e64949"));

        ShortCutClasses shortCutClasses = new ShortCutClasses();

        //CHEST BUTTON
        Button chestButton = findViewById(R.id.chestButton);
        chestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAFterExercisesAtivity();
            }
        });

        //BACK EXERCISE BUTTON
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackExercisesAtivity();
            }
        });

        //SHOULDER BUTTON
        Button shoudlerButton = findViewById(R.id.shoudlerButton);
        shoudlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShoulderExercisesActivity();
            }
        });

        //BICEPS BUTTON
        Button bicepButton = findViewById(R.id.bicepButton);
        bicepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBicepsExercises();
            }
        });

        //TRICEP BUTTON
        Button tricepButton = findViewById(R.id.tricepButton);
        tricepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTricepActivity();
            }
        });

        //LEG BUTTON
        Button legButton = findViewById(R.id.legButton);
        legButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLegActivity();
            }
        });

        //BACK BUTTON
        Button backButton2 = findViewById(R.id.backbutton2);
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button smallMembershipButton4 = findViewById(R.id.smallMembershipButton4);
        smallMembershipButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openMembershipActivity(ExercisesActivity.this);
            }
        });

        Button smallScheduleButton4 = findViewById(R.id.smallScheduleButton4);
        smallScheduleButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openScheduleActivity(ExercisesActivity.this);
            }
        });

        Button smallSupplementsButton4 = findViewById(R.id.smallSupplementsButton4);
        smallSupplementsButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openSupplementsActivity(ExercisesActivity.this);
            }
        });


    }

    public void openAFterExercisesAtivity() {
        Intent intent = new Intent(this, AfterExercisesActivity.class);
        startActivity(intent);
    }

    public void openBackExercisesAtivity() {
        Intent intent = new Intent(this, BackExerciseActivity.class);
        startActivity(intent);
    }

    public void openShoulderExercisesActivity() {
        Intent intent = new Intent(this, ShoulderActivity.class);
        startActivity(intent);
    }

    public void openBicepsExercises() {
        Intent intent = new Intent(this, BicepsActivity.class);
        startActivity(intent);
    }

    public void openTricepActivity(){
        Intent intent = new Intent(this, TricepActivity.class);
        startActivity(intent);
    }

    public void openLegActivity() {
        Intent intent = new Intent(this, LegActivity.class);
        startActivity(intent);
    }
}

