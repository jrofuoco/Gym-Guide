package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BackExerciseActivity extends AppCompatActivity {

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_exercise);

        //DEADLIFT BUTTON
        Button deadliftButton = findViewById(R.id.deadliftButton);
        deadliftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Deadlift";
                openAfterAfterExercise();
            }
        });

        //CHIN UPS
        Button pullUpsButton = findViewById(R.id.pullUpsButton);
        pullUpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Chinups";
                openAfterAfterExercise();
            }
        });

        //BENT OVER BUTTON
        Button bentoverButton = findViewById(R.id.bentoverButton);
        bentoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Bent Over";
                openAfterAfterExercise();
            }
        });

        //LAT PULLDOWN BUTTON
        Button latPullDownButton = findViewById(R.id.latPullDownButton);
        latPullDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Lat Pulldown";
                openAfterAfterExercise();
            }
        });

        //SEATED CABLE ROW BUTTON
        Button seatedCableRowsButton = findViewById(R.id.seatedCableRowsButton);
        seatedCableRowsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = "Seated Cable Row";
                openAfterAfterExercise();
            }
        });

        Button backbutton7 = findViewById(R.id.backbutton7);
        backbutton7.setOnClickListener(new View.OnClickListener() {
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