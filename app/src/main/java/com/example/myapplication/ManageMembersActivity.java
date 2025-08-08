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
import android.widget.Toast;
import java.util.ArrayList;

import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ManageMembersActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    MyDatabaseHelper myDB;
    ArrayList<String> _id, first_name, last_name, address, gender, age, email, password;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_members);


        recyclerView = findViewById(R.id.attendanceView);
        myDB = new MyDatabaseHelper(ManageMembersActivity.this);
        _id = new ArrayList<>();
        first_name = new ArrayList<>();
        last_name = new ArrayList<>();
        address = new ArrayList<>();
        gender = new ArrayList<>();
        age = new ArrayList<>();
        email = new ArrayList<>();
        password = new ArrayList<>();

        storeDataInArray();


        customAdapter = new CustomAdapter(ManageMembersActivity.this, ManageMembersActivity.this, _id, first_name, last_name, address, gender, age, email, password);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ManageMembersActivity.this));
        //BUTTONS

        Button addAccount = findViewById(R.id.addAccount);
        addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddAccountActivity();
            }
        });

        Button backbutton123 = findViewById(R.id.backbutton123);
        backbutton123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity();
            }
        });



        // Initialize the search functionality
        TextInputEditText searchEditText = findViewById(R.id.searchAttendanceTxt); // Change to use correct ID
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                customAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            recreate();
        }
    }

    void storeDataInArray() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                _id.add(cursor.getString(0));
                first_name.add(cursor.getString(1));
                last_name.add(cursor.getString(2));
                address.add(cursor.getString(3));
                gender.add(cursor.getString(4));
                age.add(cursor.getString(5));
                email.add(cursor.getString(6));
                password.add(cursor.getString(7));
            }
        }
        cursor.close(); // Close the cursor to avoid memory leaks
    }

    void closeActivity() {
        this.finish();
    }

    void openAddAccountActivity() {
        Intent intent = new Intent(this, AddAccountActivity.class);
        startActivity(intent);
        finish();
    }
}

