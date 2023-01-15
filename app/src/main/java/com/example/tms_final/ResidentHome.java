package com.example.tms_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResidentHome extends AppCompatActivity {

    public void onBackPressed() {
        //  super.onBackPressed();
        moveTaskToBack(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident_home);
        getSupportActionBar().hide();

        TextView username=findViewById(R.id.usrname);
        Button sr=findViewById(R.id.srbtn);
        Button visitor=findViewById(R.id.visitorbtn);
        Button bill=findViewById(R.id.billsbtn);

        username.setText(GlobalVar.name);

        sr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),ServiceRequest.class);
                startActivity(intent);
            }
        });


        visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Visitor.class);
                startActivity(intent);
            }
        });

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Bills.class);
                startActivity(intent);
            }
        });
    }
    }
