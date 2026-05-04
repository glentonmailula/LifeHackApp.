package com.example.lifehackapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ReviewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)
        val layout = findViewById<LinearLayout>(R.id.reviewLayout)

        val questions = arrayOf(
            " the program will run properly.",
            " name used to store a value that can change.",
            " a way to store fewer values at the same place.",
            " instead of writing things many times a loop does that for you.",
            " debugging is not a thing that should be done."
        )

        val answers = arrayOf(false, true, false, true, false)

        for (i in questions.indices) {
            val tv = TextView(this)
            val answerText = if (answers[i]) "Hack" else "Myth"
            tv.text = "${questions[i]}\nAnswer: $answerText\n"
            tv.setPadding(0, 0, 0, 20)
            layout.addView(tv)
        }
    }
}
