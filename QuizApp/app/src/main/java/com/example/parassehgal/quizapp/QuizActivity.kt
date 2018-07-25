package com.example.parassehgal.quizapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

   lateinit var questions:Array<String>
    lateinit var options:Array<String>
    lateinit var answers:Array<String>
    var counter=0
    var score=0
lateinit var userChoice:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        var intent= intent
        var value=intent.getIntExtra("request",0)

        when(value){
            1-> {
                questions = resources.getStringArray(R.array.cQuestions)
                options = resources.getStringArray(R.array.cOptions)
                answers = resources.getStringArray(R.array.cAnswers)
            }
            2-> {
                questions = resources.getStringArray(R.array.cPlusQuestions)
                options = resources.getStringArray(R.array.cPlusOptions)
                answers = resources.getStringArray(R.array.cPlusAnswers)
            }
            3-> {
                questions = resources.getStringArray(R.array.javaQuestions)
                options = resources.getStringArray(R.array.javaOptions)
                answers = resources.getStringArray(R.array.javaAnswers)
            }
            4-> {
                questions = resources.getStringArray(R.array.kotlinQuestions)
                options = resources.getStringArray(R.array.kotlinOptions)
                answers = resources.getStringArray(R.array.kotlinAnswers)
            }
            5-> {
                questions = resources.getStringArray(R.array.androidQuestions)
                options = resources.getStringArray(R.array.androidOptions)
                answers = resources.getStringArray(R.array.androidAnswers)

            }
            else -> {""}
        }

fetchQuestionOptions()
    }

    fun loadData(view: View){
        checkScore()
        counter++
        if(counter>=questions.size){
            var intent=Intent(this,ScoreActivity :: class.java)
            intent.putExtra("Score",score)
            startActivity(intent)
            finish()
        }
        else{
            fetchQuestionOptions()
        }
    }

    fun fetchQuestionOptions(){
        questionTextView.text=questions[counter]
        option1.text=options[counter*4]
        option2.text=options[counter*4 +1]
        option3.text=options[counter*4 +2]
        option4.text=options[counter*4 +3]

    }

    fun checkScore(){
        var radiobutton:RadioButton=findViewById(radioGroup.checkedRadioButtonId)
        if(radiobutton.text==answers[counter]){
            score++
        }
        radiobutton.isChecked=false
    }

}
