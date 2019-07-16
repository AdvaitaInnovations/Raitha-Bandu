package com.example.saishekar.rbnavigation;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class About_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.rblogo);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getActionBar();

//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//
//        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

//        public boolean onOptionsItemSelected(MenuItem item) {
//            Intent myIntent = new Intent(getApplicationContext(), NavMainActivity.class);
//            startActivityForResult(myIntent, 0);
//            return true;
//        }
    }
}
