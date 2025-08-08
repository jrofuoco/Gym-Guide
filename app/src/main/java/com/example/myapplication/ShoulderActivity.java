package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoulderActivity extends AppCompatActivity {

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder);

        //MILITARY PRESS BUTTON
        Button militarypressButton = findViewById(R.id.militarypressButton);
        militarypressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Military Press";
                openAfterAfterExercise();
            }
        });

        //SEATED DUMBELL PRESS BUTTON
        Button seatedDumbellPressButton = findViewById(R.id.seatedDumbellPressButton);
        seatedDumbellPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Seated Dumbell Press";
                openAfterAfterExercise();
            }
        });

        //CABLE SIDE LATERAL RAISES BUTTON
        Button cablesideButton = findViewById(R.id.cablesideButton);
        cablesideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Cable Side Lateral Raises";
                openAfterAfterExercise();
            }
        });

        //BENCH DIPS BUTTONS
        Button benchDipButton = findViewById(R.id.benchDipButton);
        benchDipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Bench Dip";
                openAfterAfterExercise();
            }
        });

        Button backbutton5 = findViewById(R.id.backbutton5);
        backbutton5.setOnClickListener(new View.OnClickListener() {
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