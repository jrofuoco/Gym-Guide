package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TricepActivity extends AppCompatActivity {

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tricep);

        Button tricepDicpsButton = findViewById(R.id.tricepDicpsButton);
        tricepDicpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Tricep Dips";
                openAfterAfterExercise();
            }
        });

        Button tricepExtentsionButton = findViewById(R.id.tricepExtentsionButton);
        tricepExtentsionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Tricep Overhead";
                openAfterAfterExercise();
            }
        });

        Button tricepCableKickBackButton = findViewById(R.id.tricepCableKickBackButton);
        tricepCableKickBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Tricep Kicback";
                openAfterAfterExercise();
            }
        });

        Button tricepPushDown = findViewById(R.id.tricepPushDown);
        tricepPushDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Tricep Pushdown";
                openAfterAfterExercise();
            }
        });

        Button backbutton10 = findViewById(R.id.backbutton10);
        backbutton10.setOnClickListener(new View.OnClickListener() {
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