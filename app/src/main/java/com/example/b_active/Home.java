package com.example.b_active;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener {
    Button stepcounter;
    Button workout;
    Button logout;
    Button bmi;
    Button cal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        setTitle("Home");

        stepcounter = findViewById(R.id.stepcntr);
        workout = findViewById(R.id.workoutbtn);
        logout = (Button) findViewById(R.id.home);
        bmi = (Button) findViewById(R.id.bmibtn);
        cal = (Button) findViewById(R.id.caloriebtn);

        stepcounter.setOnClickListener(this);
        workout.setOnClickListener(this);
        bmi.setOnClickListener(this);
        cal.setOnClickListener(this);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Home.this,Login.class));
            }
        });
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

            case R.id.bmibtn:
                Intent calculating = new Intent(Home.this, Bmi.class);
                startActivity((calculating));
                break;

            case R.id.caloriebtn:
                Intent calpage = new Intent(Home.this, FragmentActivity.class);
                startActivity((calpage));
                break;
        }
    }
}

