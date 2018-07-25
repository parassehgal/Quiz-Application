package com.example.parassehgal.quizapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity(),View.OnClickListener {

    override fun onClick(view : View?){
        var value=when(view!!.id){
            cbutton.id -> 1
            cplusbutton.id ->2
            javabutton.id -> 3
            kotlinbutton.id ->4
            androidbutton.id -> 5
            else -> 0
        }
        var intent=Intent(this,QuizActivity :: class.java)
        intent.putExtra("request",value)
        startActivity(intent)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        cbutton.setOnClickListener(this)
        cplusbutton.setOnClickListener(this)
        javabutton.setOnClickListener(this)
        kotlinbutton.setOnClickListener(this)
        androidbutton.setOnClickListener(this)
    }
}
