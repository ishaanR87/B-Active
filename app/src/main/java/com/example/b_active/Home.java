package com.example.b_active;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button stepCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        stepCounter = (Button) findViewById(R.id.stepcntr);
    }
}