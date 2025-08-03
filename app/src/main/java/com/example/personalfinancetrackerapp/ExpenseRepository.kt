package com.example.personalfinancetrackerapp

object ExpenseRepository {
    val expenses = mutableListOf(
        Expense("Lunch", 10.0, "Food"),
        Expense("Transport", 5.0, "Travel"),
        Expense("Groceries", 20.0, "Food")
    )
}