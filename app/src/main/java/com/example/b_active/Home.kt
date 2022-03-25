package com.example.b_active

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle
import com.example.b_active.R
import android.view.View
import android.content.Intent
import com.example.b_active.StepCounter

class Home : AppCompatActivity() {
    var stepCounter: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        stepCounter = findViewById<View>(R.id.stepcntr) as Button
        stepCounter!!.setOnClickListener {
            val intent = Intent(applicationContext, StepCounter::class.java)
            startActivity(intent)
        }
    }
}