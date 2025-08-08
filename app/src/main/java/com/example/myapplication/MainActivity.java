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

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    String enteredEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDatabaseHelper(this);

        TextInputLayout emailInputLayout = findViewById(R.id.emailInput);
        TextInputLayout passwordInputLayout = findViewById(R.id.passwordInput);

        Intent intent = new Intent(this, UserHome.class);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredEmail = emailInputLayout.getEditText().getText().toString().trim();
                String enteredPassword = passwordInputLayout.getEditText().getText().toString().trim();
                boolean hehe = true;

                if (validateInput(enteredEmail, enteredPassword)) {
                    hehe = true;
                    if (dbHelper.checkUser(enteredEmail, enteredPassword)) {
                        String firstname = dbHelper.getFirstnameByEmail(enteredEmail);
                        String lastname = dbHelper.getLastnameByEmail(enteredEmail);
                        if (lastname != null && lastname.toLowerCase().contains("[archived")) {
                            Toast.makeText(getApplicationContext(), "Your Account is Disabled, Please Email Us", Toast.LENGTH_SHORT).show();
                        }
                        // Check if the email ends with "@admin.com"
                        else if (enteredEmail.toLowerCase().endsWith("@admin.com")) {
                            openAdminActivity();
                        } else {
                            openUserHomeActivity(firstname, enteredEmail, lastname);
                        }
                    }else if (enteredEmail.equals("admin@admin.com") && enteredPassword.equals("ctrlgroup")){
                        openAdminActivity();
                    } else {
                            showToast("Invalid email or password");
                            System.out.println(hehe);
                    }
                }
            }
        });


        TextView signUpTxt = findViewById(R.id.signUptxt);
        signUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });
    }

    private boolean validateInput(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            showToast("Fill in all the fields");
            return false;
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void openSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void openUserHomeActivity(String firstname, String enteredEmail, String lastname) {
        Intent intent = new Intent(this, UserHome.class);
        intent.putExtra("FIRSTNAME", firstname);
        intent.putExtra("LASTNAME", lastname);
        intent.putExtra("email", enteredEmail);
        startActivity(intent);
        showToast("Welcome: " + firstname);
    }

    private void openAdminActivity() {
        Intent intent =  new Intent(this, AdminActivityHome.class);
        startActivity(intent);
    }
    private void openManageMembersActivity() {
        Intent intent = new Intent(this, AdminActivityHome.class);
        startActivity(intent);
    }
}
