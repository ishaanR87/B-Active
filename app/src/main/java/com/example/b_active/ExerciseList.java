package com.example.b_active;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ExerciseList extends AppCompatActivity {

    String buttonValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ExerciseList);

        Intent intent = getIntent();
        buttonValue = intent.getStringExtra("value");

        int intValue = Integer.valueOf(buttonValue);

        switch(intValue){

            case 1:
                setContentView(R.layout.exercise1);
                break;
            case 2:
                setContentView(R.layout.exercise2);
                break;
            case 3:
                setContentView(R.layout.exercise3);
                break;
            case 4:
                setContentView(R.layout.exercise4);
                break;
            case 5:
                setContentView(R.layout.exercise5);
                break;
            case 6:
                setContentView(R.layout.exercise6);
                break;
            case 7:
                setContentView(R.layout.exercise7);
                break;
            case 8:
                setContentView(R.layout.exercise8);
                break;
            case 9:
                setContentView(R.layout.exercise9);
                break;
            case 10:
                setContentView(R.layout.exercise10);
                break;

        }
    }
}