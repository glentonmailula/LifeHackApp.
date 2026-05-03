package com.example.lifehackapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.*


class ScoreActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        val score = intent.getIntExtra("score", 5)
        val total = intent.getIntExtra("total", 10)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val reviewButton = findViewById<Button>(R.id.reviewButton)

        val message = if (score >= 5) "Master Hacker! 💪" else "Keep practising!"

        scoreText.text = "Score: $score / $total\n$message"

        reviewButton.setOnClickListener {
            startActivity(Intent(this, ReviewActivity::class.java))
        }
    }
}

