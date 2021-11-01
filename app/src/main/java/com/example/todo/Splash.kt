package com.example.todolistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.todo.R
import com.example.todolistapp.view.MainActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // hide the actionbar
        supportActionBar?.hide()

        // set time for splash
        val intent= Intent(this,MainActivity::class.java)
        object : CountDownTimer(2000,1000){
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                startActivity(intent)
                finish()
            }
        }.start()
    }
    }
