package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout firstnameInput, lastnameInput, addressInput,
            genderInput, ageInput, emailInput, passwordInput, repeatPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstnameInput = findViewById(R.id.firstnameInput);
        lastnameInput = findViewById(R.id.lastnameInput);
        addressInput = findViewById(R.id.addressInput);
        genderInput = findViewById(R.id.genderInput);
        ageInput = findViewById(R.id.ageInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        repeatPasswordInput = findViewById(R.id.repeatPasswordInput);

        //SIGNUP BUTTON
        Button signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = Objects.requireNonNull(firstnameInput.getEditText()).getText().toString().trim();
                String lastname = Objects.requireNonNull(lastnameInput.getEditText()).getText().toString().trim();
                String address = Objects.requireNonNull(addressInput.getEditText()).getText().toString().trim();
                String gender = Objects.requireNonNull(genderInput.getEditText()).getText().toString().trim();
                String ageText = Objects.requireNonNull(ageInput.getEditText()).getText().toString().trim();
                String email = Objects.requireNonNull(emailInput.getEditText()).getText().toString().trim();
                String password = Objects.requireNonNull(passwordInput.getEditText()).getText().toString().trim();
                String repeatPassword = Objects.requireNonNull(repeatPasswordInput.getEditText()).getText().toString().trim();

                if (validateInput(firstname, lastname, address, gender, ageText, email, password, repeatPassword)) {
                    // Input is valid, check if email is already registered
                    MyDatabaseHelper dbHelper = new MyDatabaseHelper(SignUpActivity.this);

                    if (dbHelper.isEmailRegistered(email)) {
                        // Email is already registered
                        Toast.makeText(SignUpActivity.this, "Email is already registered", Toast.LENGTH_SHORT).show();
                    } else {
                        // Email is not registered, proceed with adding user to the database
                        int age = Integer.parseInt(ageText);
                        long result = dbHelper.addUser(firstname, lastname, address, gender, age, email, password, repeatPassword);

                        if (result != -1) {
                            // User added successfully
                            Toast.makeText(SignUpActivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            // Failed to add user
                            Toast.makeText(SignUpActivity.this, "User Creation Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        //BTN TO OPEN SIGNUP ACTIVITY------------------
        //SIGNIN
        TextView signinTxt = findViewById(R.id.signinTxt);
        signinTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });
    }

    //Function--openSignupActivity-------------------------------------------------
    public void openSignUpActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private boolean validateInput(String firstname, String lastname, String address, String gender,
                                  String age, String email, String password, String repeatPassword) {

        //fill all validation
        if (firstname.isEmpty() || lastname.isEmpty() || address.isEmpty() || gender.isEmpty()
                || age.isEmpty() || email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            // Display an error message or use Toast to inform the user to fill in all fields
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        //password validation
        if (!password.equals(repeatPassword)) {
            // Password and repeat password do not match
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return false;
        }

        //age validation
        try {
            int ageValue = Integer.parseInt(age);
            if (ageValue < 0 || ageValue > 120) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid age", Toast.LENGTH_SHORT).show();
            return false;
        }

        //email Validation
        email = email.trim();

        if (!email.toLowerCase().endsWith("@gmail.com") &&
                !email.toLowerCase().endsWith("@yahoo.com") &&
                !email.toLowerCase().endsWith("@icloud.com") &&
                !email.toLowerCase().endsWith("@outlook.com")) {

            Log.d("EmailValidation", "Invalid Email"); // Log the invalid email message

            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
