package com.example.personalfinancetrackerapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.personalfinancetrackerapp.databinding.ActivityFinanceBinding

class FinanceActivity : AppCompatActivity() {

    private var _binding: ActivityFinanceBinding? = null
    private val binding get() = _binding!!

    val TAG = "Lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityFinanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            if (binding.editExpenseName.text.isNullOrBlank() || binding.editExpenseName.text.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.expenses_name_can_not_be_empty), Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (binding.editExpenseName.text.toString().lowercase()
                    .filter { it >= 'a' && it <= 'z' }.length != binding.editExpenseName.text.toString().length
            ) {
                Toast.makeText(
                    this,
                    getString(R.string.expenses_name_must_contain_letters_only), Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (binding.editAmount.text.isNullOrBlank() || binding.editAmount.text.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.the_amount_can_not_be_empty), Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (binding.editAmount.text.toString().toDoubleOrNull() == null) {
                Toast.makeText(
                    this,
                    getString(R.string.the_amount_must_be_integers_only), Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (binding.editCategory.text.isNullOrBlank() || binding.editCategory.text.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.category_name_can_not_be_empty), Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (binding.editCategory.text.toString().lowercase()
                    .filter { it >= 'a' && it <= 'z' }.length != binding.editCategory.text.toString().length
            ) {
                Toast.makeText(
                    this,
                    getString(R.string.category_name_must_contain_letters_only), Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val name = binding.editExpenseName.text.toString()
            val amount = binding.editAmount.text.toString().toDoubleOrNull()!!
            val category = binding.editCategory.text.toString()
            Toast.makeText(
                this,
                getString(R.string.expenses_added_successfully),
                Toast.LENGTH_SHORT
            ).show()
            binding.editAmount.text.clear()
            binding.editCategory.text.clear()
            binding.editExpenseName.text.clear()
            expenses.add(Expense(name = name, amount = amount, category = category))
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
            finish()
        }


        Log.d(TAG, "onCreate called")
    }

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

