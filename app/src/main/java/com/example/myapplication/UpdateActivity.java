package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText first_name, last_name, address, gender, email, password, age;
    Button update_button;

    String id, firstname, lastname, address1, gender1, email1, password1, age1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        first_name = findViewById(R.id.pnameEdit);
        last_name = findViewById(R.id.plastnameEdit);
        address = findViewById(R.id.paddressEdit);
        gender = findViewById(R.id.pgenderEdit);
        email = findViewById(R.id.pmailEdit);
        password = findViewById(R.id.ppasswordEdit);
        age = findViewById(R.id.pageEdit);

        getAndSetIntentData();

        Button archiveAccountButton2 = findViewById(R.id.archiveAccountButton2);
        archiveAccountButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (last_name.getText().toString().contains("[Archived]")){
                    Toast.makeText(getApplicationContext(), "The account is already ARCHIVED.", Toast.LENGTH_SHORT).show();
                }else {
                    // Ensure the values are updated
                    firstname = first_name.getText().toString();
                    lastname = last_name.getText().toString() + " [Archived]";
                    address1 = address.getText().toString();
                    gender1 = gender.getText().toString();
                    age1 = age.getText().toString();
                    email1 = email.getText().toString();
                    password1 = password.getText().toString();

                    Log.d("UpdateActivity", "ID: " + id);
                    Log.d("UpdateActivity", "First Name: " + firstname);
                    Log.d("UpdateActivity", "Last Name: " + lastname);
                    Log.d("UpdateActivity", "Address: " + address1);
                    Log.d("UpdateActivity", "Gender: " + gender1);
                    Log.d("UpdateActivity", "Age: " + age1);
                    Log.d("UpdateActivity", "Email: " + email1);
                    Log.d("UpdateActivity", "Password: " + password1);

                    MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                    myDB.updateData(id, firstname, lastname, address1, gender1, age1, email1, password1);
                }
            }
        });

        // Initialize the update_button
        update_button = findViewById(R.id.archiveAccountButton);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ensure the values are updated
                firstname = first_name.getText().toString();
                lastname = last_name.getText().toString();
                address1 = address.getText().toString();
                gender1 = gender.getText().toString();
                age1 = age.getText().toString();
                email1 = email.getText().toString();
                password1 = password.getText().toString();

                Log.d("UpdateActivity", "ID: " + id);
                Log.d("UpdateActivity", "First Name: " + firstname);
                Log.d("UpdateActivity", "Last Name: " + lastname);
                Log.d("UpdateActivity", "Address: " + address1);
                Log.d("UpdateActivity", "Gender: " + gender1);
                Log.d("UpdateActivity", "Age: " + age1);
                Log.d("UpdateActivity", "Email: " + email1);
                Log.d("UpdateActivity", "Password: " + password1);

                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.updateData(id, firstname, lastname, address1, gender1, age1, email1, password1);

            }
        });

        Button backbutton13 = findViewById(R.id.backbutton13);
        backbutton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") &&
                getIntent().hasExtra("firstname") &&
                getIntent().hasExtra("lastname") &&
                getIntent().hasExtra("address") &&
                getIntent().hasExtra("gender") &&
                getIntent().hasExtra("password") &&
                getIntent().hasExtra("age") &&
                getIntent().hasExtra("email")) {

            id = getIntent().getStringExtra("id");
            firstname = getIntent().getStringExtra("firstname");
            lastname = getIntent().getStringExtra("lastname");
            address1 = getIntent().getStringExtra("address");
            gender1 = getIntent().getStringExtra("gender");
            password1 = getIntent().getStringExtra("password");
            age1 = getIntent().getStringExtra("age");
            email1 = getIntent().getStringExtra("email");

            first_name.setText(firstname);
            last_name.setText(lastname);
            address.setText(address1);
            gender.setText(gender1);
            email.setText(email1);
            password.setText(password1);
            age.setText(age1);

        } else {
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }
    }
}
