package com.example.b_active

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle
import android.view.View
import android.content.Intent

class Home : AppCompatActivity() {
    var stepCounter: Button? = null
    var workOut: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        stepCounter = findViewById<View>(R.id.stepcntr) as Button
        workOut = findViewById<View>(R.id.workoutbtn) as Button
        stepCounter!!.setOnClickListener {
            val intent = Intent(applicationContext, StepCounter::class.java)
            startActivity(intent)
        }
        workOut!!.setOnClickListener {
            val intent = Intent(applicationContext, Workout::class.java)
            startActivity(intent)
        }
    }
}