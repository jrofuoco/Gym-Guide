package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class AttendanceAdminActivity extends AppCompatActivity {

    RecyclerView attendanceView;

    AttendanceDatabaseHelper myDB;
    ArrayList<String> _id, name, date, time;
    AttendanceAdapter attendanceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_admin);

        attendanceView = findViewById(R.id.attendanceView);
        myDB = new AttendanceDatabaseHelper(AttendanceAdminActivity.this);
        _id = new ArrayList<>();
        name = new ArrayList<>();
        date = new ArrayList<>();
        time = new ArrayList<>();

        storeDataInArray();

        attendanceAdapter = new AttendanceAdapter(AttendanceAdminActivity.this, _id, name, date, time);
        attendanceView.setAdapter(attendanceAdapter);
        attendanceView.setLayoutManager(new LinearLayoutManager(AttendanceAdminActivity.this));

        // BUTTON TO OPEN ATTENDANCE ACTIVITY
        Button addAttendanceBtn = findViewById(R.id.addAttendanceBtn);
        addAttendanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAttendancePanel();
                finish();
            }
        });

        Button backAttendanceutonn = findViewById(R.id.backAttendanceutonn);
        backAttendanceutonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Initialize the search functionality
        TextInputEditText searchEditText = findViewById(R.id.searchAttendanceTxt);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                attendanceAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    void storeDataInArray() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                _id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                date.add(cursor.getString(2));
                time.add(cursor.getString(3));
            }
        }
        cursor.close(); // Close the cursor to avoid memory leaks
    }

    void openAttendancePanel() {
        Intent intent = new Intent(this, AttendancePanelActivity.class);
        startActivity(intent);
    }
}
