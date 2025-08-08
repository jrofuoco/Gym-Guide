package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MembershipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        ShortCutClasses shortCutClasses = new ShortCutClasses();

        Button smallMembershipButton = findViewById(R.id.smallMembershipButton);
        smallMembershipButton.setBackgroundColor(Color.parseColor("#30e64949"));

        //BASIC MEMBERSHIP BUTTON
        Button basicmembershipBtn = findViewById(R.id.basicmembershipBtn);
        basicmembershipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaymentActivityBasic();
            }
        });

        //STANDARD MEMBERSHIP BUTTON
        Button standardmembershipBtn = findViewById(R.id.standardmembershipBtn);
        standardmembershipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaymentActivityStandard();
            }
        });

        //PREMIUM MEMBERSHIP BUTTON
        Button premiummembershipBtn = findViewById(R.id.premiummembershipBtn);
        premiummembershipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaymentActivityPremium();
            }
        });

        //BACK BUTTON
        Button backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backUserHome();
            }
        });


        Button smallExerciseButton = findViewById(R.id.smallExerciseButton);
        smallExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openExercisesActivity(MembershipActivity.this);
            }
        });

        Button smallScheduleButton = findViewById(R.id.smallScheduleButton);
        smallScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openScheduleActivity(MembershipActivity.this);
            }
        });

        Button smallSupplementsButton = findViewById(R.id.smallSupplementsButton);
        smallSupplementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortCutClasses.openSupplementsActivity(MembershipActivity.this);
            }
        });



    }

    public void backUserHome() {
        finish();
    }

    public void openPaymentActivityBasic() {
        Intent intent = new Intent(this, PaymentActivity.class);
        String text = "Basic Membership\n\n\nFeatures\n\n" +
                "•Access to basic gym facilities and equipment.\n" +
                "•Standard fitness classes.\n" +
                "•Limited hours of access (e.g., non-peak hours).\n" +
                "\n\nPrice:\n" +
                "Monthly Fee: ₱300";
        int type = 1;
        intent.putExtra("text", text);
        intent.putExtra("type", type);
        startActivity(intent);
    }

    public void openPaymentActivityStandard() {
        Intent intent = new Intent(this, PaymentActivity.class);
        String text = "Standard Membership\n\n\nFeatures\n\n" +
                "•Full access to gym facilities and equipment.\n" +
                "•Unlimited access to fitness classes.\n" +
                "•Extended hours of access (including peak hours)\n" +
                "•Access to personal training sessions at an additional cost." +
                "\n\nPrice:\n" +
                "Monthly Fee: ₱600";
        int type = 2;
        intent.putExtra("text", text);
        intent.putExtra("type", type);
        startActivity(intent);
    }

    public void openPaymentActivityPremium() {
        Intent intent = new Intent(this, PaymentActivity.class);
        String text = "Premium Membership\n\n\nFeatures\n\n" +
                "•Full access to gym facilities and equipment.\n" +
                "•Unlimited access to fitness classes.\n" +
                "•Extended hours of access (including peak hours)\n" +
                "•Access to personal training sessions at an additional cost." +
                "•Priority access to classes and equipment.\n" +
                "•Complimentary personal training sessions (limited per month).\n" +
                "•Exclusive gym amenities (e.g., sauna, towel service).\n" +
                "•Discounts on merchandise and additional services." +
                "\n\nPrice:\n" +
                "Monthly Fee: ₱1000";
        intent.putExtra("text", text);
        intent.putExtra("type", 3);
        startActivity(intent);
    }

}