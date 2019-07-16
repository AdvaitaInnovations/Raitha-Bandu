package com.example.saishekar.rbnavigation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog.Builder;

public class UserDetailsActivity extends AppCompatActivity {
    Button Submit;
    Button View;
    Button Clear;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.rblogo);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Submit = (Button) findViewById(R.id.submit);

        Clear = (Button) findViewById(R.id.clear);
        db = openOrCreateDatabase("RaithaBandu", Context.MODE_PRIVATE, null);

        Submit.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(UserDetailsActivity.this, NavMainActivity.class);
                startActivity(intent);
            }
        });

    }
}

