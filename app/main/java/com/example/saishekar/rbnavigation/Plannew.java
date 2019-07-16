package com.example.saishekar.rbnavigation;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Plannew extends AppCompatActivity {
    CheckBox cb1,cb2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plannew);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.rblogo);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cb1=(CheckBox)findViewById(R.id.checkBox3);
        cb2=(CheckBox)findViewById(R.id.checkBox4);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button = (Button) findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        Intent intent=new Intent(Plannew.this,planned.class);
                        startActivity(intent);
                    }
                });
//                StringBuilder sb=new StringBuilder("");
//
                if(cb1.isChecked()== true ){
//                    new AlertDialog.Builder(Plannew.this)
//                            .setTitle(" 1 crop selected");
                    Intent intent = new Intent(Plannew.this, planned.class);
                    //intent.putExtra("key","abc");
                    startActivity(intent);
                }
//
                if(cb2.isChecked() && (cb1.isChecked() ) ){
//                    String s2=cb2.getText().toString();
//                    sb.append("\n"+s2);
                    Intent intent = new Intent(Plannew.this, planned.class);
                    //intent.putExtra("key","abc");
                    startActivity(intent);

                }
//                if(sb!=null && !sb.toString().equals("")){
//                    Toast.makeText(getApplicationContext(), sb, Toast.LENGTH_LONG).show();
//
//                }
                else{
//                    Toast.makeText(getApplicationContext(),"Nothing Selected", Toast.LENGTH_LONG).show();
                }

            }

        });
    }
}