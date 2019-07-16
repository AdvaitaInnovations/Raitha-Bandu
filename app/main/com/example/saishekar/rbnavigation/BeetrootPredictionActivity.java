package com.example.saishekar.rbnavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class BeetrootPredictionActivity extends AppCompatActivity {
//    ListView listView1,listView2;
//    String[] listitem;
//    Integer[] listitem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.rblogo);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        listitem=getResources().getStringArray(R.array.price);
//        listitem=getResources().getStringArray(R.array.price1);
//        listView1=(ListView) findViewById(R.id.price_list);
//        listView2=(ListView) findViewById(R.id.price);
//        ArrayAdapter<String> adapter = new
//                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,listitem);
//        listView1.setAdapter(adapter);
//        ArrayAdapter<Integer> adapter1 = new
//                ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_2,android.R.id.text2,listitem1);
//        listView2.setAdapter(adapter);

       // Intent intent = getIntent();
        //Bundle b = intent.getExtras();
        //if(b!=null){
         // String value = b.getString("key");
        // if(value.equals("abc")){

            //}
       // }
    }
}
