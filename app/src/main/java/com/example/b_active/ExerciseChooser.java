package com.example.b_active;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseChooser extends AppCompatActivity {

    String buttonValue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mTextView;
    private boolean MtimeRunning;
    private long MtimeLeftInMillis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercisechooser);

        Intent intent = getIntent();
        buttonValue = intent.getStringExtra("value");

        int intValue = Integer.valueOf(buttonValue);

        switch (intValue) {

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

        startBtn = findViewById(R.id.start);
        mTextView = findViewById(R.id.timer);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MtimeRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });
    }

    private void stopTimer()
    {
        countDownTimer.cancel();
        MtimeRunning=false;
        startBtn.setText("Start Timer");
    }

    private void startTimer()
    {
        final CharSequence value1 = mTextView.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);

        final int number = Integer.valueOf(num2) * 60+ Integer.valueOf(num3);
        MtimeLeftInMillis = number* 1000L;

        countDownTimer = new CountDownTimer(MtimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinish) {

               MtimeLeftInMillis = millisUntilFinish;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue = Integer.valueOf(buttonValue)+1;
                if(newvalue<=7)
                {
                    Intent intent = new Intent(ExerciseChooser.this, Workout.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else
                {
                    newvalue = 1;
                    Intent intent = new Intent(ExerciseChooser.this, Workout.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
            }
        }.start();
            startBtn.setText("Pause Timer");
            MtimeRunning = true;
    }

    private void updateTimer()
    {
        int minutes = (int) MtimeLeftInMillis/60000;
        int seconds = (int) MtimeLeftInMillis%60000 /1000;

        String timeLeftText="";
        if(minutes<10)
            timeLeftText="0";
        timeLeftText = timeLeftText+minutes+":";
        if(seconds<10)
            timeLeftText="0";
            timeLeftText+=seconds;
        mTextView.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}