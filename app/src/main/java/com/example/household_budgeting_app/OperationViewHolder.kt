package com.example.household_budgeting_app

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.household_budgeting_app.databinding.OperationItemCellBinding
import java.text.SimpleDateFormat

class OperationViewHolder(
    private val context: Context,
    private val binding: OperationItemCellBinding,
    private val clickListener: OperationClickListener
): RecyclerView.ViewHolder(binding.root)
{
    private val simpleDateFormat = SimpleDateFormat("dd/MM/yy HH:mm")

    fun bindOperationItem(operation: Operation)
    {
        //binding.categoryID.text = operation.categoryID.toString()
        binding.sum.text = "price: "+ operation.sum.toString() + "$"
        //binding.count.text = operation.count.toString()
        binding.desc.text = operation.desc.toString()
        //binding.bankAccauntID.text = operation.bankAccauntID.toString()
        binding.date.text = simpleDateFormat.format(operation.dateTime * 1000L)

        binding.operationCellContainer.setOnClickListener{
            clickListener.editOperationItem(operation)
        }

    }
}