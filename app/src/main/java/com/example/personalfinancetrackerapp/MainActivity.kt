package com.example.personalfinancetrackerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalfinancetrackerapp.ExpenseRepository.expenses
import com.example.personalfinancetrackerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!

    val adapter = ExpenseAdapter(ExpenseRepository.expenses)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, FinanceActivity::class.java)
            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "I just added a new expense: Lunch – $10")
            }
            startActivity(Intent.createChooser(shareIntent, "Share expense via"))
        }

        binding.expensesRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter.notifyItemInserted(expenses.size - 1)
        binding.expensesRecyclerView.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}
