package com.example.saishekar.rbnavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Beetroot extends AppCompatActivity {
    Button predict;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beetroot);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.rblogo);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////        predict = (Button) findViewById(R.id.predict1);
//        predict.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//               Intent intent = new Intent(Beetroot.this, BeetrootPredictionActivity.class);
//                startActivity(intent);
//    }
//});
    }
}
