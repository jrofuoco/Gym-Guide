package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AttendancePanelActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private EditText nameEdit, timeEdit;
    private Button addAttendButton;
    private AttendanceDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_panel);

        // Initialize views
        calendarView = findViewById(R.id.calendarView1);
        nameEdit = findViewById(R.id.pnameEdit);
        timeEdit = findViewById(R.id.timeEdit);
        addAttendButton = findViewById(R.id.addAttendButton);

        // Initialize database helper
        databaseHelper = new AttendanceDatabaseHelper(this);

        // Set click listener for the addAttendButton
        addAttendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAttendance();
            }
        });

        Button backAttendanccePanelButton = findViewById(R.id.backAttendanccePanelButton);
        backAttendanccePanelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, AttendanceAdminActivity.class);
        startActivity(intent);

        // If you want to perform the default behavior (close the current activity), you can call super.onBackPressed()
        super.onBackPressed();
    }

    private void addAttendance() {
        // Get data from views
        String name = nameEdit.getText().toString().trim();

        // Get the selected date from calendarView
        long selectedDate = calendarView.getDate();

        // Format the date as "MM/dd/yy"
        String formattedDate = formatDate(selectedDate);

        // Get the time from timeEdit
        String time = timeEdit.getText().toString().trim();

        // Validate input
        if (name.isEmpty() || formattedDate.isEmpty() || time.isEmpty()) {
            Toast.makeText(this, "Please enter name, date, and time", Toast.LENGTH_SHORT).show();
            return;
        }

        // Insert data into the database
        long rowId = databaseHelper.insertAttendance(name, formattedDate, time);

        // Check if the insertion was successful
        if (rowId != -1) {
            Toast.makeText(this, "Attendance added successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add attendance", Toast.LENGTH_SHORT).show();
        }

        // Optionally, you can clear the input fields after adding attendance
        nameEdit.setText("");
        timeEdit.setText("");
    }

    // Format the date as "MM/dd/yy"
    private String formatDate(long dateInMillis) {
        // Create a Date object using the timestamp
        Date date = new Date(dateInMillis);

        // Format the date as a string using SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

        return dateFormat.format(date);
    }
}
