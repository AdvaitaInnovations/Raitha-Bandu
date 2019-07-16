package com.example.saishekar.rbnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class newpredict extends AppCompatActivity {
    ImageButton beetroot,tomato,cabbage,radish,greenchilli,bittergourd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpredict);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.rblogo);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        beetroot= (ImageButton) findViewById(R.id.beetroot);
        tomato= (ImageButton) findViewById(R.id.tomato);
        cabbage= (ImageButton) findViewById(R.id.cabbage);
        radish= (ImageButton) findViewById(R.id.radish);
       greenchilli= (ImageButton) findViewById(R.id.greenchilli);
        bittergourd= (ImageButton) findViewById(R.id.bittergourd);

        beetroot.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(newpredict.this, Beetroot.class);
                startActivity(intent);
            }
        });
        tomato.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(newpredict.this, Tomato.class);
                startActivity(intent);
            }
        });
        cabbage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(newpredict.this, Cabbage.class);
                startActivity(intent);
            }
        });
        radish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(newpredict.this, Radish.class);
                startActivity(intent);
            }
        });
        greenchilli.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(newpredict.this, GreenChilly.class);
                startActivity(intent);
            }
        });
        bittergourd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(newpredict.this, Bittergourd.class);
                startActivity(intent);
            }
        });
    }
}
