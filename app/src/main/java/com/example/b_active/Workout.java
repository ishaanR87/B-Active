package com.example.b_active;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Workout extends AppCompatActivity {

    int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout);

       setTitle("Workout");

        newArray = new int[]{
                R.id.exercise1, R.id.exercise2, R.id.exercise3, R.id.exercise4, R.id.exercise5,
                R.id.exercise6, R.id.exercise7, R.id.exercise8, R.id.exercise9, R.id.exercise10,
        };
    }

    public void imagebuttonclicked(View view) {
        for(int i = 0; i< newArray.length; i++){
            if(view.getId() == newArray[i]) {
                int value = i + 1;
                Log.i("First",String.valueOf(value));
                Intent intent = new Intent(Workout.this, ExerciseChooser.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}