package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class UserHome extends AppCompatActivity {

    private String firstname, lastname;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        //to set username names
        Intent intent = getIntent();
        firstname = intent.getStringExtra("FIRSTNAME");

        email = intent.getStringExtra("email");
        lastname = intent.getStringExtra("LASTNAME");
        TextView firstnameTextView = findViewById(R.id.usernameTxt);
        firstnameTextView.setText("Hi\n " + firstname + "!");

        //EXERCISES BUTTON
        Button exercisesBtn = findViewById(R.id.premiummembershipBtn);
        exercisesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExercisesActivity();
            }
        });

        //MEMBERSHIP BUTTON
        Button membershipButton = findViewById(R.id.basicmembershipBtn);
        membershipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMemberShipActivitiy();
            }
        });

        //SCHEDULE BUTTON
        Button scheduleBtn = findViewById(R.id.standardmembershipBtn);
        scheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScheduleActivity();
            }
        });

        //SUPPLEMETS BUTTON
        Button supplementsBtn = findViewById(R.id.supplementsBtn);
        supplementsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opemSuppelemtsActivity();
            }
        });

        ImageButton profile = findViewById(R.id.profileButtonn);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileActivity();
                Toast.makeText(UserHome.this, "Oepn Profile", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openMemberShipActivitiy() {
        Intent intent = new Intent(this, MembershipActivity.class);
        startActivity(intent);
    }

    public void openExercisesActivity(){
        Intent intent = new Intent(this, ExercisesActivity.class);
        startActivity(intent);
    }

    public void openScheduleActivity(){
        Intent intent = new Intent(this, ScheduleActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("name", firstname + " " + lastname);
        startActivity(intent);
    }

    public void opemSuppelemtsActivity(){
        Intent intent = new Intent(this, SupplementsActivity.class);
        startActivity(intent);
    }

    public void openProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }

}