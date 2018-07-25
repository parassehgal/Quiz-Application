package com.example.parassehgal.quizapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    var delayRun=1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var handler = Handler()
        var run=Runnable{
            startActivity(Intent(this,MenuActivity :: class.java))
            finish()
        }
       handler.postDelayed(run,delayRun)

    }
}
