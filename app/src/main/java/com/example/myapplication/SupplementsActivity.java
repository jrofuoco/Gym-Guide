package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SupplementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplements);

        Button smallSupplementsButton11 = findViewById(R.id.smallSupplementsButton11);
        smallSupplementsButton11.setBackgroundColor(Color.parseColor("#30e64949"));

        ShortCutClasses shortCutClasses = new ShortCutClasses();

        Button backbutton11 = findViewById(R.id.backbutton11);
        backbutton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button smallMembershipButton11 = findViewById(R.id.smallMembershipButton11);
        smallMembershipButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openMembershipActivity(SupplementsActivity.this);
            }
        });

        Button smallExerciseButton11 = findViewById(R.id.smallExerciseButton11);
        smallExerciseButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openExercisesActivity(SupplementsActivity.this);
            }
        });

        Button smallScheduleButton11 = findViewById(R.id.smallScheduleButton11);
        smallScheduleButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openScheduleActivity(SupplementsActivity.this);
            }
        });

    }
}