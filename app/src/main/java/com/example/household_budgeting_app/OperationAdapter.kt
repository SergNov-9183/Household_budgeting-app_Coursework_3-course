package com.example.household_budgeting_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.household_budgeting_app.databinding.AccauntItemCellBinding
import com.example.household_budgeting_app.databinding.OperationItemCellBinding

class OperationAdapter(
    private val operations: List<Operation>,
    private val clickListener: OperationClickListener
): RecyclerView.Adapter<OperationViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = OperationItemCellBinding.inflate(from, parent, false)
        return OperationViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: OperationViewHolder, position: Int) {
        holder.bindOperationItem(operations[position])
    }

    override fun getItemCount(): Int = operations.size
}