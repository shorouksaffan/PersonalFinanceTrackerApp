package com.example.personalfinancetrackerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter(var expenses: List<Expense>) :
    RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val expenseName: TextView? = null
        private val expenseAmount: TextView? = null
        private val expenseCategory: TextView? = null

        fun getExpenseName(): TextView? {
            return expenseName ?: itemView.findViewById<TextView>(R.id.expenseName)
        }

        fun getExpenseAmount(): TextView? {
            return expenseAmount ?: itemView.findViewById<TextView>(R.id.expenseAmount)
        }

        fun getExpenseCategory(): TextView? {
            return expenseCategory ?: itemView.findViewById<TextView>(R.id.expenseCategory)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_expense_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.getExpenseName()?.text = expenses[position].name
        holder.getExpenseAmount()?.text = expenses[position].amount.toString()
        holder.getExpenseCategory()?.text = expenses[position].category
    }

    override fun getItemCount(): Int {
        return expenses.size
    }

}