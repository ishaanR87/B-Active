package com.example.b_active;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CalorieSignUp extends AppCompatActivity {


    /* Variables */
    private String[] arraySpinnerDOBDay = new String[31];
    private String[] arraySpinnerDOBYear = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caloriesignup);


        /* Fill numbers for date of birth days */
        int human_counter = 0;
        for (int x = 0; x < 31; x++) {
            human_counter = x + 1;
            this.arraySpinnerDOBDay[x] = "" + human_counter;
        }
        Spinner spinnerDOBDay = (Spinner) findViewById(R.id.spinnerDOBDay);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, arraySpinnerDOBDay);
        spinnerDOBDay.setAdapter(adapter);

        /* Fill numbers for date of birth year */
        // get current year、month and day
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int end = year - 100;
        int index = 0;
        for (int x = year; x > end; x--) {
            this.arraySpinnerDOBYear[index] = "" + x;
            // Toast.makeText(this, "x = " + x, Toast.LENGTH_SHORT).show();

            index++;
        }
    }
}
