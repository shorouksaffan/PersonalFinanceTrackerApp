package com.example.personalfinancetrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trackExpenseButton = findViewById<Button>(R.id.btnTrack)
        val shareButton = findViewById<Button>(R.id.btnShare)

        trackExpenseButton.setOnClickListener {
            val intent = Intent(this, FinanceActivity::class.java)
            startActivity(intent)
        }

        shareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "I just added a new expense: Lunch – $10")
            }
            startActivity(Intent.createChooser(shareIntent, "Share expense via"))
        }
    }
}
