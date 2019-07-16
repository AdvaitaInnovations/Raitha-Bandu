package com.example.saishekar.rbnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class Oldcropplan extends AppCompatActivity {
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6;
    Button btnSubmit;
    Spinner cropspinner;
    String[] crop = { "Beetroot", "Tomato", "Cabbage", "Radish", "Green Chilli", "BitterGourd"};
    ImageView beetroot,cabbage,radish,tomato,greenchilli,bittergourd;
    ImageView sugbeet,sugcabg,sugrad,sugtom,suggc,sugbg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oldcropplan);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.rblogo);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        cb1=(CheckBox)findViewById(R.id.checkBox1);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb4=(CheckBox)findViewById(R.id.checkBox4);
        cb5=(CheckBox)findViewById(R.id.checkBox5);
        cb6=(CheckBox)findViewById(R.id.checkBox6);

        beetroot=(ImageView)findViewById(R.id.beetroot);
        cabbage=(ImageView)findViewById(R.id.cabbage);
        radish=(ImageView)findViewById(R.id.radish);
        tomato=(ImageView)findViewById(R.id.tomato);
        greenchilli=(ImageView)findViewById(R.id.greenchilli);
        bittergourd=(ImageView)findViewById(R.id.bittergourd);

        sugbeet=(ImageView)findViewById(R.id.sugbeetroot);
        sugcabg=(ImageView)findViewById(R.id.sugcabbage);
        sugrad=(ImageView)findViewById(R.id.sugradish);
        sugtom=(ImageView)findViewById(R.id.sugtomato);
        suggc=(ImageView)findViewById(R.id.suggreenchilli);
        sugbg=(ImageView)findViewById(R.id.sugbittergourd);
        //Applying the Listener on the Button click
        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                StringBuilder result=new StringBuilder();
                result.append("Selected Crops:");
                if(cb1.isChecked()){
                    result.append("\nCabbage");

                }
                if(cb2.isChecked()){
                    result.append("\nRadish");
                    Intent intent = new Intent (Oldcropplan.this,Assistance1.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Oldcropplan.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                //Displaying the message on the toast
//                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

            }

        });
        cropspinner=(Spinner)findViewById(R.id.cropspinner);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,crop);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        cropspinner.setAdapter(aa);
        cropspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),crop[position] , Toast.LENGTH_LONG).show();
               if(crop[position]=="Beetroot"){
                   cb1.setVisibility(View.VISIBLE);
                   cb2.setVisibility(View.VISIBLE);
                   cb3.setVisibility(View.GONE);
                   cb4.setVisibility(View.GONE);
                   cb5.setVisibility(View.GONE);
                   cb6.setVisibility(View.GONE);

                   beetroot.setVisibility(View.VISIBLE);
                   radish.setVisibility(View.GONE);
                   cabbage.setVisibility(View.GONE);
                   tomato.setVisibility(View.GONE);
                   greenchilli.setVisibility(View.GONE);
                   bittergourd.setVisibility(View.GONE);

                   sugbeet.setVisibility(View.GONE);
                   sugrad.setVisibility(View.VISIBLE);
                   sugcabg.setVisibility(View.VISIBLE);
                   sugtom.setVisibility(View.GONE);
                   suggc.setVisibility(View.GONE);
                   sugbg.setVisibility(View.GONE);
               }
               else if (crop[position]=="Tomato"){
                   cb1.setVisibility(View.GONE);
                   cb2.setVisibility(View.GONE);
                   cb3.setVisibility(View.VISIBLE);
                   cb4.setVisibility(View.VISIBLE);
                   cb5.setVisibility(View.GONE);
                   cb6.setVisibility(View.GONE);

                   beetroot.setVisibility(View.GONE);
                   radish.setVisibility(View.GONE);
                   cabbage.setVisibility(View.GONE);
                   tomato.setVisibility(View.VISIBLE);
                   greenchilli.setVisibility(View.GONE);
                   bittergourd.setVisibility(View.GONE);

                   sugbeet.setVisibility(View.VISIBLE);
                   sugrad.setVisibility(View.GONE);
                   sugcabg.setVisibility(View.GONE);
                   sugtom.setVisibility(View.GONE);
                   suggc.setVisibility(View.VISIBLE);
                   sugbg.setVisibility(View.GONE);
               }
               else if (crop[position]=="Cabbage"){
                   cb1.setVisibility(View.GONE);
                   cb2.setVisibility(View.GONE);
                   cb3.setVisibility(View.GONE);
                   cb4.setVisibility(View.GONE);
                   cb5.setVisibility(View.VISIBLE);
                   cb6.setVisibility(View.VISIBLE);

                   beetroot.setVisibility(View.GONE);
                   radish.setVisibility(View.GONE);
                   cabbage.setVisibility(View.VISIBLE);
                   tomato.setVisibility(View.GONE);
                   greenchilli.setVisibility(View.GONE);
                   bittergourd.setVisibility(View.GONE);

                   sugbeet.setVisibility(View.GONE);
                   sugrad.setVisibility(View.GONE);
                   sugcabg.setVisibility(View.GONE);
                   sugtom.setVisibility(View.VISIBLE);
                   suggc.setVisibility(View.GONE);
                   sugbg.setVisibility(View.VISIBLE);
               }
               else if (crop[position]=="Radish"){
                   cb1.setVisibility(View.GONE);
                   cb2.setVisibility(View.GONE);
                   cb3.setVisibility(View.VISIBLE);
                   cb4.setVisibility(View.VISIBLE);
                   cb5.setVisibility(View.GONE);
                   cb6.setVisibility(View.GONE);

                   beetroot.setVisibility(View.GONE);
                   radish.setVisibility(View.VISIBLE);
                   cabbage.setVisibility(View.GONE);
                   tomato.setVisibility(View.GONE);
                   greenchilli.setVisibility(View.GONE);
                   bittergourd.setVisibility(View.GONE);

                   sugbeet.setVisibility(View.VISIBLE);
                   sugrad.setVisibility(View.GONE);
                   sugcabg.setVisibility(View.GONE);
                   sugtom.setVisibility(View.GONE);
                   suggc.setVisibility(View.VISIBLE);
                   sugbg.setVisibility(View.GONE);
               }
               else if (crop[position]=="Green Chilli"){
                   cb1.setVisibility(View.GONE);
                   cb2.setVisibility(View.GONE);
                   cb3.setVisibility(View.GONE);
                   cb4.setVisibility(View.GONE);
                   cb5.setVisibility(View.VISIBLE);
                   cb6.setVisibility(View.VISIBLE);

                   beetroot.setVisibility(View.GONE);
                   radish.setVisibility(View.GONE);
                   cabbage.setVisibility(View.GONE);
                   tomato.setVisibility(View.GONE);
                   greenchilli.setVisibility(View.VISIBLE);
                   bittergourd.setVisibility(View.GONE);

                   sugbeet.setVisibility(View.GONE);
                   sugrad.setVisibility(View.GONE);
                   sugcabg.setVisibility(View.GONE);
                   sugtom.setVisibility(View.VISIBLE);
                   suggc.setVisibility(View.GONE);
                   sugbg.setVisibility(View.VISIBLE);
               }
               else if (crop[position]=="BitterGourd"){
                   cb1.setVisibility(View.VISIBLE);
                   cb2.setVisibility(View.VISIBLE);
                   cb3.setVisibility(View.GONE);
                   cb4.setVisibility(View.GONE);
                   cb5.setVisibility(View.GONE);
                   cb6.setVisibility(View.GONE);

                   beetroot.setVisibility(View.GONE);
                   radish.setVisibility(View.GONE);
                   cabbage.setVisibility(View.GONE);
                   tomato.setVisibility(View.GONE);
                   greenchilli.setVisibility(View.GONE);
                   bittergourd.setVisibility(View.VISIBLE);

                   sugbeet.setVisibility(View.GONE);
                   sugrad.setVisibility(View.VISIBLE);
                   sugcabg.setVisibility(View.VISIBLE);
                   sugtom.setVisibility(View.GONE);
                   suggc.setVisibility(View.GONE);
                   sugbg.setVisibility(View.GONE);
               }
else{
                   Toast.makeText(getApplicationContext(),"Nothing selected",Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    // add items into spinner dynamically





//


  /*  public void addListenerOnButtonClick(){
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        cb1=(CheckBox)findViewById(R.id.checkBox1);
        cb2=(CheckBox)findViewById(R.id.checkBox2);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Oldcropplan.this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner1.setAdapter(aa);

        //Applying the Listener on the Button click
        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                StringBuilder result=new StringBuilder();
                result.append("Selected Crops:");
                if(cb1.isChecked()){
                    result.append("\nCabbage");

                }
                if(cb2.isChecked()){
                    result.append("\nRadish");
                    Intent intent = new Intent (Oldcropplan.this,Assistance.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Oldcropplan.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                //Displaying the message on the toast
//                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

            }

        });
    }*/


}