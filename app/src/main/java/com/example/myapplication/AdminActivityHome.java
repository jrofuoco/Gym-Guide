package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        Button membershipBtn = findViewById(R.id.basicmembershipBtn);
        membershipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMangeMembersActivity();
            }
        });

        Button adminSchedulebtn = findViewById(R.id.standardmembershipBtn);
        adminSchedulebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminSchedule();
            }
        });

        Button attendanceButton = findViewById(R.id.premiummembershipBtn);
        attendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAttendanceActivity();
            }
        });
    }

    public void openMangeMembersActivity() {
        Intent intent = new Intent(this, ManageMembersActivity.class);
        startActivity(intent);
    }

    public void openAdminSchedule(){
        Intent intent = new Intent(this, AdminSchedule.class);
        startActivity(intent);
    }

    public void openAttendanceActivity() {
        Intent intent = new Intent(this, AttendanceAdminActivity.class);
        startActivity(intent);
    }
}