package com.example.household_budgeting_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.household_budgeting_app.databinding.AccauntItemCellBinding

class BankAccountAdapter(
    private val bankAccounts: List<BankAccount>,
    private val clickListener: BankAccountClickListener
): RecyclerView.Adapter<BankAccountViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankAccountViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = AccauntItemCellBinding.inflate(from, parent, false)
        return BankAccountViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: BankAccountViewHolder, position: Int) {
        holder.bindAccauntItem(bankAccounts[position])
    }

    override fun getItemCount(): Int = bankAccounts.size
}