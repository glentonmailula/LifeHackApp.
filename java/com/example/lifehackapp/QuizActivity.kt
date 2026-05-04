package com.example.lifehackapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.*



class QuizActivity : AppCompatActivity() {
    // the score that will appear along with the first question and the total number of questions
    var index = 0
    var score = 0
    lateinit var questionText: TextView
    lateinit var feedbackText: TextView
    // the list of the questions
    val questions = arrayOf(
        "A program has an error so it will run properly",
        "A variable stores a value",
        "an array stores few values",
        "A loop is a short cut",
        "debugging a program doesn't help it run better"
    )
    //the order in which the user is suppose to answer

    val answers = arrayOf(false, true, false, true, false)

        val explanations = arrayOf(
        "Myth: the program will run properly.",
        "Hack: name used to store a value that can change.",
        "Myth: a way to store fewer values at the same place.",
        "Hack: instead of writing things many times a loop does that for you.",
        "Myth: debugging is not a thing that should be done."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // what to expect when you click on the true or false buttons
        setContentView(R.layout.activity_quiz)
        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)

        val hackButton = findViewById<Button>(R.id.hackButton)
        val mythButton = findViewById<Button>(R.id.mythButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        loadQuestion()

        hackButton.setOnClickListener { checkAnswer(true) }
        mythButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            index++

            if (index < questions.size) {
                loadQuestion()
                feedbackText.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    fun loadQuestion() {
        questionText.text = questions[index]
    }

    @SuppressLint("SetTextI18n")
    fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            // what you will see then you get a question correct or wrong
            feedbackText.text = "Correct! 🎉\n${explanations[index]}"
            score++
        } else {
            feedbackText.text = "Wrong! ❌\n${explanations[index]}"
        }
    }
}

