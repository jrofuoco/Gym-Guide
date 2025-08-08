package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LegActivity extends AppCompatActivity {

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg);

        Button legsquatButton = findViewById(R.id.legsquatButton);
        legsquatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Barbell Squat";
                openAfterAfterExercise();
            }
        });

        Button legpressButton = findViewById(R.id.legpressButton);
        legpressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Leg Press";
                openAfterAfterExercise();
            }
        });

        Button legKickBackButton = findViewById(R.id.legKickBackButton);
        legKickBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Leg Kickback";
                openAfterAfterExercise();
            }
        });

        Button legcalfButton = findViewById(R.id.legcalfButton);
        legcalfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Barbell Calf Raises";
                openAfterAfterExercise();
            }
        });

        Button backbutton8 = findViewById(R.id.backbutton8);
        backbutton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void openAfterAfterExercise(){
        Intent intent = new Intent(this, AfterAfterExerciseActivity.class);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}