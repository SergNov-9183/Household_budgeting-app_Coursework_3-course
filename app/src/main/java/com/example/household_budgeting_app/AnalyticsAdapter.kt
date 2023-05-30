package com.example.household_budgeting_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.household_budgeting_app.databinding.AnalyticsItemCellBinding

class AnalyticsAdapter(
    private val operations: List<Analytics>,
): RecyclerView.Adapter<AnalyticsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalyticsViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = AnalyticsItemCellBinding.inflate(from, parent, false)
        return AnalyticsViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: AnalyticsViewHolder, position: Int) {
        holder.bindOperationItem(operations[position])
    }

    override fun getItemCount(): Int = operations.size
}