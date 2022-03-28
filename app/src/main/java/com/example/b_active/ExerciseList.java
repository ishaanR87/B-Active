package com.example.b_active;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseList extends AppCompatActivity {

    String buttonValue;
    Button startButton;
    private CountDownTimer countDownTimer;
    TextView time;
    private boolean timeRunning;
    private long timeLeft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exerciselist);

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

        startButton = findViewById(R.id.starttimerex1);
        time = findViewById(R.id.time);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timeRunning)

                {


                }

                else
                {

                }
            }
        });
    }

    private void stopTimer()
    {
        countDownTimer.cancel();
        timeRunning=false;
        startButton.setText("Start");
    }

    private void startTimer()
    {
        final CharSequence value = time.getText();
        String num1 = value.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);

        final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
        timeLeft = number * 1000;

        countDownTimer = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long millisecondsUntilFinish) {

            }

            @Override
            public void onFinish() {

            }
        }

    }
}