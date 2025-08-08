package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private TextInputLayout fromInput;
    // Remove the following line
    // private TextInputLayout toInput;
    private TextInputLayout amPmInput;
    private Button confirmButton;
    private ProgramScheduleDatabaseHelper dbHelper;
    private String email, fullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Button smallScheduleButton9 = findViewById(R.id.smallScheduleButton9);
        smallScheduleButton9.setBackgroundColor(Color.parseColor("#30e64949"));

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        fullName = intent.getStringExtra("name");

        ShortCutClasses shortCutClasses = new ShortCutClasses();

        dbHelper = new ProgramScheduleDatabaseHelper(this);

        calendarView = findViewById(R.id.calendarView1);
        fromInput = findViewById(R.id.fromInput);
        // Remove the following line
        // toInput = findViewById(R.id.toInput);
        amPmInput = findViewById(R.id.ampmInput);
        confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveClassInformation();
            }
        });

        Button backbutton9 = findViewById(R.id.backbutton9);
        backbutton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button smallMembershipButton9 = findViewById(R.id.smallMembershipButton9);
        smallMembershipButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openMembershipActivity(ScheduleActivity.this);
            }
        });

        Button smallExerciseButton9 = findViewById(R.id.smallExerciseButton9);
        smallExerciseButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openExercisesActivity(ScheduleActivity.this);
            }
        });

        Button smallSupplementsButton9 = findViewById(R.id.smallSupplementsButton9);
        smallSupplementsButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openSupplementsActivity(ScheduleActivity.this);
            }
        });
    }

    private void saveClassInformation() {
        // Retrieve the selected date from the calendarView
        String selectedDate = getSelectedDateFromCalendar();

        // Retrieve the text from TextInputLayouts
        String fromTimeText = fromInput.getEditText().getText().toString().trim();
        // Remove the following line
        // String toTimeText = toInput.getEditText().getText().toString().trim();
        String amPmValue = amPmInput.getEditText().getText().toString().trim();

        // Perform validation for empty fields
        if (selectedDate.isEmpty() || fromTimeText.isEmpty() || amPmValue.isEmpty()) {
            // Show an error message or handle the case where any of the fields is empty
            // For example, you can display a Toast message
            Toast.makeText(ScheduleActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return; // Exit the method without saving if validation fails
        }

        // Perform validation for integer values
        int fromTime;
        try {
            fromTime = Integer.parseInt(fromTimeText);
        } catch (NumberFormatException e) {
            // Handle the case where "from" is not a valid integer
            Toast.makeText(ScheduleActivity.this, "Invalid Time", Toast.LENGTH_SHORT).show();
            return; // Exit the method without saving if validation fails
        }

        // Validate amPmValue
        if (!amPmValue.equalsIgnoreCase("am") && !amPmValue.equalsIgnoreCase("pm")) {
            // Show an error message or handle the case where amPmValue is not "AM" or "PM"
            Toast.makeText(ScheduleActivity.this, "Invalid AM/PM value", Toast.LENGTH_SHORT).show();
            return; // Exit the method without saving if validation fails
        }
        // Save the information to the database
        long result = dbHelper.addClass(email, String.valueOf(fromTime), selectedDate, fullName, amPmValue);

        if (result != -1) {
            // Successful insertion
            Toast.makeText(ScheduleActivity.this, "Class information saved", Toast.LENGTH_SHORT).show();
        } else {
            // Failed insertion
            Toast.makeText(ScheduleActivity.this, "Failed to save class information", Toast.LENGTH_SHORT).show();
        }
    }

    private String getSelectedDateFromCalendar() {
        // Retrieve the selected date from the calendarView
        // This is a simplified example, and you might need to format the date according to your needs
        // You may also want to handle time zones appropriately
        long selectedTimestamp = calendarView.getDate();

        // Convert the timestamp to your desired date format
        // For example, you can use SimpleDateFormat or another approach based on your requirements
        Date selectedDate = new Date(selectedTimestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Use your desired date format
        return sdf.format(selectedDate);
    }
}
