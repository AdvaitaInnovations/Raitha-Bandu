package com.example.saishekar.rbnavigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Contact_us extends AppCompatActivity {
    Button Send,Cancel;
    ImageButton phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.rblogo);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Send = (Button) findViewById(R.id.button4);
        Cancel = (Button) findViewById(R.id.button2);
    phone= (ImageButton) findViewById(R.id.phone1);

        phone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" +"7204949774"));
                startActivity(intent);
            }
        });

        Send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(Contact_us.this,NavMainActivity.class));
//                Intent intent = new Intent(Contact_us.this, NavMainActivity.class);
//                startActivity(intent);
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(Contact_us.this,Contact_us.class));
//                Intent intent = new Intent(Contact_us.this, NavMainActivity.class);
//                startActivity(intent);
            }
        });
    }
}

