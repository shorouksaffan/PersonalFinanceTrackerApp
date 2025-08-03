package com.example.personalfinancetrackerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.personalfinancetrackerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!

    val adapter = ExpenseAdapter(expenses)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, FinanceActivity::class.java)
            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {
            val balance = expenses.sumOf { it.amount }
            val message = if (balance == 0.0) {
                getString(R.string.no_expenses)
            } else {
                getString(R.string.total_expenses) + ": $balance\n" +
                        expenses.joinToString("\n") { "${it.name} – ${it.amount} (${it.category})" }
            }
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, message)
            }
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share_expenses)))
        }
        binding.expensesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.expensesRecyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        if (expenses.isEmpty()) {
            binding.emptyTextView.visibility = android.view.View.VISIBLE
        } else {
            binding.emptyTextView.visibility = android.view.View.GONE
        }
        adapter.notifyDataSetChanged()
    }
}
