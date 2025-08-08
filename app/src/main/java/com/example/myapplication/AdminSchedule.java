package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminSchedule extends AppCompatActivity {

    RecyclerView recyclerView;

    ProgramScheduleDatabaseHelper DATABASE_NAME;

    ArrayList<String> sched_id, sched_date, sched_Start, sched_ampm, usernameSchedText, emailSchedText, lastname;
    ScheduleAdapter scheduleAdapter;
    MyDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_schedule);

        db = new MyDatabaseHelper(AdminSchedule.this);
        usernameSchedText = new ArrayList<>();
        emailSchedText = new ArrayList<>();
        lastname = new ArrayList<>();

        DATABASE_NAME = new ProgramScheduleDatabaseHelper(AdminSchedule.this);
        sched_id = new ArrayList<>();
        sched_date = new ArrayList<>();
        sched_Start = new ArrayList<>();
        sched_ampm = new ArrayList<>();

        recyclerView = findViewById(R.id.attendanceView);

        storeDataInArrays();

        scheduleAdapter = new ScheduleAdapter(
                AdminSchedule.this,
                sched_id,
                sched_date,
                sched_Start,
                sched_ampm,
                usernameSchedText,
                emailSchedText,
                lastname,
                DATABASE_NAME // Pass the ProgramScheduleDatabaseHelper instance
        );

        recyclerView.setAdapter(scheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AdminSchedule.this));

        Button backbutton12 = findViewById(R.id.backbutton12);
        backbutton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void storeDataInArrays() {
        Cursor cursor = DATABASE_NAME.readAllData();
        Cursor cursor1 = db.readAllData();

        if (cursor.getCount() == 0 || cursor1.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext() && cursor1.moveToNext()) {
                sched_id.add(cursor.getString(0));
                sched_date.add(cursor.getString(3));
                sched_Start.add(cursor.getString(2));
                sched_ampm.add(cursor.getString(5));

                usernameSchedText.add(cursor1.getString(1));
                lastname.add(cursor1.getString(2));
                emailSchedText.add(cursor1.getString(6));
            }
        }

        cursor.close();
        cursor1.close();
    }
}