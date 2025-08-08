package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class ProfileActivity extends AppCompatActivity {

    String id, get_firstname, get_lastname, get_address, get_gender, get_age, get_email_db, get_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String firstname, lastname, address, gender, age, email_db, password;

        EditText pnameEdit = findViewById(R.id.pnameEdit);
        EditText plastnameEdit = findViewById(R.id.plastnameEdit);
        EditText paddressEdit = findViewById(R.id.paddressEdit);
        EditText pgenderEdit = findViewById(R.id.pgenderEdit);
        EditText pageEdit = findViewById(R.id.pageEdit);
        EditText pmailEdit = findViewById(R.id.pmailEdit);
        EditText ppasswordEdit = findViewById(R.id.ppasswordEdit);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        System.out.println(email);

        MyDatabaseHelper readDataByEmail = new MyDatabaseHelper(this);
        Cursor cursor = readDataByEmail.readDataByEmail(email);

        Button pupdateButton = findViewById(R.id.pupdateButton);
        pupdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_firstname = pnameEdit.getText().toString();
                get_lastname = plastnameEdit.getText().toString();
                get_address = paddressEdit.getText().toString();
                get_gender = pgenderEdit.getText().toString();
                get_age = pageEdit.getText().toString();
                get_email_db = pmailEdit.getText().toString();
                get_password = ppasswordEdit.getText().toString();

                MyDatabaseHelper myDB = new MyDatabaseHelper(ProfileActivity.this);
                myDB.updateDataProfile(id, get_firstname, get_lastname, get_address, get_gender, get_age, get_email_db, get_password);
            }
        });

        Button backbutton16 = findViewById(R.id.backbutton16);
        backbutton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (cursor.moveToFirst()) {
            do {
                // TO GET ALL THE DATA FROM DATABASE
                firstname = cursor.getString(1);
                lastname = cursor.getString(2);
                address = cursor.getString(3);
                gender = cursor.getString(4);
                age = cursor.getString(5);
                email_db = cursor.getString(6);
                password = cursor.getString(7);

                pnameEdit.setText(firstname);
                plastnameEdit.setText(lastname);
                paddressEdit.setText(address);
                pgenderEdit.setText(gender);
                pageEdit.setText(age);
                pmailEdit.setText(email_db);
                ppasswordEdit.setText(password);


            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}