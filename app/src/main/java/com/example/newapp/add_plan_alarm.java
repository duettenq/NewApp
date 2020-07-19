package com.example.newapp;


import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newapp.R;

public class add_plan_alarm extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        ImageButton backmenu = (ImageButton) findViewById(R.id.imageButton);
        backmenu.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), add_plan.class);
                startActivity(intent);
            }
        });















    }
}