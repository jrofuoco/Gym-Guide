package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BicepsActivity extends AppCompatActivity {

    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);

        Button seateddumbellCurlButton = findViewById(R.id.seateddumbellCurlButton);
        seateddumbellCurlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Seated Dumbbell Curl";
                openAfterAfterExercise();
            }
        });

        Button preacherCurlButton = findViewById(R.id.preacherCurlButton);
        preacherCurlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Preacher Curl";
                openAfterAfterExercise();
            }
        });

        Button cablecurlButton = findViewById(R.id.cablecurlButton);
        cablecurlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Cable Curl";
                openAfterAfterExercise();
            }
        });

        Button ezbarButton = findViewById(R.id.ezbarButton);
        ezbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Ez Bar Curl";
                openAfterAfterExercise();
            }
        });

        Button backbutton6 = findViewById(R.id.backbutton6);
        backbutton6.setOnClickListener(new View.OnClickListener() {
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