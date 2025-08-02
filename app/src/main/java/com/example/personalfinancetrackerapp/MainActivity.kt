package com.example.personalfinancetrackerapp

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val recyclerView = findViewById<RecyclerView>(R.id.expensesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val expenses = listOf(
            Expense("Lunch", 10.0, "Food"),
            Expense("Transport", 5.0, "Travel"),
            Expense("Groceries", 20.0, "Food")
        )
        val adapter = ExpenseAdapter(expenses)
        recyclerView.adapter = adapter
    }
}
=======
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

}
>>>>>>> origin/FinanceActivity
