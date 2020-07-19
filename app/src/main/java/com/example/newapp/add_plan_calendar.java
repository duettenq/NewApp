package com.example.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class add_plan_calendar extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan_calendar);



        ImageButton backtomenu = (ImageButton) findViewById(R.id.imageButton10);
        backtomenu.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), add_plan.class);
                startActivity(intent);
            }
        });



        ImageButton checkmenu = (ImageButton) findViewById(R.id.imageButton11);
        checkmenu.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), add_plan.class);
                startActivity(intent);
            }
        });







    }





}
