package com.example.household_budgeting_app

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.household_budgeting_app.databinding.OperationItemCellBinding

class OperationViewHolder(
    private val context: Context,
    private val binding: OperationItemCellBinding,
    private val clickListener: OperationClickListener
): RecyclerView.ViewHolder(binding.root)
{
    fun bindOperationItem(operation: Operation)
    {
        //binding.categoryID.text = operation.categoryID.toString()
        binding.sum.text = operation.sum.toString()
        //binding.count.text = operation.count.toString()
        binding.desc.text = operation.desc.toString()
        //binding.bankAccauntID.text = operation.bankAccauntID.toString()

        binding.operationCellContainer.setOnClickListener{
            clickListener.editOperationItem(operation)
        }

    }
}