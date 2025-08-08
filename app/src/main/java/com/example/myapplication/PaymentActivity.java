package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //GET THE TEXT FROM BASIC MEMBERSHIP
        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        int type = intent.getIntExtra("type", 0);
        Button basicmembershipDisplay = findViewById(R.id.basicmembershipDisplay);
        basicmembershipDisplay.setText(text);


        System.out.println(type);

        //BACK BUTTON
        Button paymentBackButton = findViewById(R.id.paymentBackButton);
        paymentBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButton();
            }
        });

        Button payButton = findViewById(R.id.payButton);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type == 1){
                    openLink("https://invoice-staging.xendit.co/od/basicmembershippaymentlink");
                }else if (type == 2){
                    openLink("https://invoice-staging.xendit.co/od/standardmembershippaymentlink");
                }else if (type == 3){
                    openLink("https://invoice-staging.xendit.co/od/premiummembershippaymentlinkk");
                }
            }
        });

    }

    public void backButton() {
        finish();
    }
    private void openLink(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}