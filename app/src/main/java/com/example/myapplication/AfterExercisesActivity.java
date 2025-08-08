package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfterExercisesActivity extends AppCompatActivity {

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_exercises);

        //BARBELL BENCH PRESS BUTTON
        Button barbellBenchPressButton = findViewById(R.id.militarypressButton);
        barbellBenchPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Barbell Press";
                openAfterAfterExercise();
            }
        });

        //DUMBBELL BENCH PRESS BUTTON
        Button dumbellBenchPressButton = findViewById(R.id.seatedDumbellPressButton);
        dumbellBenchPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Dumbbell Press";
                openAfterAfterExercise();
            }
        });

        //INCLINE BARBELL BENCH PRESS
        Button inclineBenchPressButton = findViewById(R.id.cablesideButton);
        inclineBenchPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Incline Barbell Press";
                openAfterAfterExercise();
            }
        });

        //INCLINE DUMBBEL BENCH PRESS
        Button inclineDumbellBenchPressButton = findViewById(R.id.benchDipButton);
        inclineDumbellBenchPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Incline Dumbbell Press";
                openAfterAfterExercise();
            }
        });

        //PECK DECK MACHINE FLIES BUTTON
        Button peckdeckFliesButton = findViewById(R.id.peckdeckFliesButton);
        peckdeckFliesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Peck Deck Flies";
                openAfterAfterExercise();
            }
        });

        //BACKBUTTON
        Button backbutton3 = findViewById(R.id.backbutton3);
        backbutton3.setOnClickListener(new View.OnClickListener() {
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