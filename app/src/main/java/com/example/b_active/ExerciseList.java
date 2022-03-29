package com.example.b_active;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseList extends AppCompatActivity {

    String buttonValue;
    Button startButton;
    private CountDownTimer countDownTimer;
    TextView timeTextView;
    private boolean timeRunning;
    private long timeLeftInMilliseconds;



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
        timeTextView = findViewById(R.id.time);

        startButton.setOnClickListener(v -> {
            if(timeRunning)
            {
                stopTimer();

            }
            else
            {
                startTimer();
            }
        });
    }

    private void stopTimer()
    {
        countDownTimer.cancel();
        timeRunning=false;
        startButton.setText("Start Timer");
    }

    private void startTimer()
    {
        final CharSequence value = timeTextView.getText();
        String num1 = value.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);

        final int number = Integer.valueOf(num2) * 60+ Integer.valueOf(num3);
        timeLeftInMilliseconds = number*1000;

        countDownTimer = new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long millisecondsUntilFinish) {

                timeLeftInMilliseconds = millisecondsUntilFinish;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue = Integer.valueOf(buttonValue)+1;
                if(newvalue<=7)
                {
                    Intent intent = new Intent(ExerciseList.this,ExerciseList.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else
                {
                    newvalue = 1;
                    Intent intent = new Intent(ExerciseList.this,ExerciseList.class);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
            }
        }.start();
            startButton.setText("Pause Timer");
            timeRunning = true;
    }

    private void updateTimer()
    {
        int minutes = (int) timeLeftInMilliseconds/60000;
        int seconds = (int) timeLeftInMilliseconds%60000 /1000;

        String timeLeftText="";
        if(minutes<10)
            timeLeftText="0";
        timeLeftText = timeLeftText+minutes+":";
        if(seconds<10)
            timeLeftText+=seconds;
        timeTextView.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}