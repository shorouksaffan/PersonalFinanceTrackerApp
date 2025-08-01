package com.example.personalfinancetrackerapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val TAG = "Lifecycle"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trackExpenseButton = findViewById<Button>(R.id.btnTrack)
        val shareButton = findViewById<Button>(R.id.btnShare)

        trackExpenseButton.setOnClickListener {
            val intent = Intent(this, FinanceActivity::class.java)
            startActivity(intent)
            val TAG = "Lifecycle"
            Log.d(TAG, "navigate success")
        }
        shareButton.setOnClickListener {

            val TAG = "Lifecycle"

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "I just added a new expense: Lunch – $10")
            }
            Log.d(TAG, "share button clicked")
            startActivity(Intent.createChooser(shareIntent, "Share expense via"))
        }
    }
    val TAG = "Lifecycle"
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}
