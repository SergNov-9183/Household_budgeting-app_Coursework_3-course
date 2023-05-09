package com.example.household_budgeting_app

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.household_budgeting_app.databinding.AccauntItemCellBinding


class BankAccountViewHolder(
    private val context: Context,
    private val binding: AccauntItemCellBinding,
    private val clickListener: BankAccountClickListener
): RecyclerView.ViewHolder(binding.root)
{
    fun bindAccauntItem(bankAccount: BankAccount)
    {
        binding.name.text = bankAccount.name
        binding.dueTime.text = bankAccount.moneyAmount.toString()

        binding.accauntCellContainer.setOnClickListener{
            clickListener.editBankAccountItem(bankAccount)
        }

    }
}