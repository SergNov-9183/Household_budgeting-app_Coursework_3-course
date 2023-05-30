package com.example.household_budgeting_app

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.household_budgeting_app.databinding.AnalyticsItemCellBinding
import java.text.SimpleDateFormat

class AnalyticsViewHolder(
    private val context: Context,
    private val binding: AnalyticsItemCellBinding
) : RecyclerView.ViewHolder(binding.root)
{
    private val simpleDateFormat = SimpleDateFormat("dd/MM/yy HH:mm")

    fun bindOperationItem(operation: Analytics)
    {
        binding.name.text = operation.name.toString()
        binding.desc.text = operation.desc.toString()
        binding.sum.text = "price: " + operation.sum.toString() + "$"
        binding.count.text = "count: " + operation.count.toString()
    }
}