package com.example.b_active;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity implements View.OnClickListener {
    Button stepcounter;
    Button workout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        stepcounter = findViewById(R.id.stepcntr);
        workout = findViewById(R.id.workoutbtn);

        stepcounter.setOnClickListener(this);
        workout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            // cases applied over different buttons
            case R.id.stepcntr:
                Intent stepcounting = new Intent(Home.this, StepCounter.class);
                startActivity((stepcounting));
                break;

            case R.id.workoutbtn:
                Intent workingout = new Intent(Home.this, Workout.class);
                startActivity((workingout));
                break;
        }
    }
}

