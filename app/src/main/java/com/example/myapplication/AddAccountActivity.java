package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class AddAccountActivity extends AppCompatActivity {

    // ... (other imports and class definition)

    private TextInputLayout firstnameInput, lastnameInput, addressInput,
            genderInput, ageInput, emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        // Initialize TextInputLayouts
        firstnameInput = findViewById(R.id.nameUpdate);
        lastnameInput = findViewById(R.id.lastnameUpdate);
        addressInput = findViewById(R.id.addressUpdate);
        genderInput = findViewById(R.id.genderUpdate);
        ageInput = findViewById(R.id.ageUpdate);
        emailInput = findViewById(R.id.emailUpdate);
        passwordInput = findViewById(R.id.passwordInput);

        // Add Account Button
        Button addButton = findViewById(R.id.archiveAccountButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract user input from TextInputLayouts
                String firstname = Objects.requireNonNull(firstnameInput.getEditText()).getText().toString().trim();
                String lastname = Objects.requireNonNull(lastnameInput.getEditText()).getText().toString().trim();
                String address = Objects.requireNonNull(addressInput.getEditText()).getText().toString().trim();
                String gender = Objects.requireNonNull(genderInput.getEditText()).getText().toString().trim();
                String ageText = Objects.requireNonNull(ageInput.getEditText()).getText().toString().trim();
                String email = Objects.requireNonNull(emailInput.getEditText()).getText().toString().trim();
                String password = Objects.requireNonNull(passwordInput.getEditText()).getText().toString().trim();

                // Validate input and add account to the database
                if (validateInput(firstname, lastname, address, gender, ageText, email, password)) {
                    // Input is valid, proceed with adding account to the database
                    int age = Integer.parseInt(ageText);

                    MyDatabaseHelper dbHelper = new MyDatabaseHelper(AddAccountActivity.this);
                    long result = dbHelper.addUser(firstname, lastname, address, gender, age, email, password, password);

                    if (result != -1) {
                        // Account added successfully
                        Toast.makeText(AddAccountActivity.this, "Account Added Successfully", Toast.LENGTH_SHORT).show();
                        // Optionally, you can navigate to another activity or perform additional actions.
                    } else {
                        // Failed to add account
                        Toast.makeText(AddAccountActivity.this, "Failed to Add Account", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button backbutton14 = findViewById(R.id.backbutton14);
        backbutton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ManageMembersActivity.class);
        startActivity(intent);

        // If you want to perform the default behavior (close the current activity), you can call super.onBackPressed()
        super.onBackPressed();
    }

    // Validate user input
    private boolean validateInput(String firstname, String lastname, String address, String gender,
                                  String age, String email, String password) {

        // Check if firstname contains integers
        if (firstname.matches(".*\\d+.*")) {
            showToast("Invalid firstname: Should not contain integers");
            return false;
        }

        // Check if lastname contains integers
        if (lastname.matches(".*\\d+.*")) {
            showToast("Invalid lastname: Should not contain integers");
            return false;
        }

        // Check if email is valid
        if (!isValidEmail(email)) {
            showToast("Invalid email format");
            return false;
        }

        // Check if age contains letters
        if (age.matches(".*[a-zA-Z]+.*")) {
            showToast("Invalid age: Should not contain letters");
            return false;
        }

        // Additional validations for address, gender, and password can be added if needed

        return true; // Input is valid
    }

    private boolean isValidEmail(String email) {
        // Check if email contains one of the specified domains
        String[] allowedDomains = {"@gmail.com", "@myyahoo.com", "@icloud.com", "@admin.com"};
        boolean isValidDomain = false;

        for (String domain : allowedDomains) {
            if (email.endsWith(domain)) {
                isValidDomain = true;
                break;
            }
        }

        return isValidDomain;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
