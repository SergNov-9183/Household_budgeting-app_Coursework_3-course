package com.example.household_budgeting_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.household_budgeting_app.databinding.CategoryItemCellBinding

class CategoryAdapter(
    private val categories: List<Category>,
    private val clickListener: CategoryClickListener
): RecyclerView.Adapter<CategoryViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CategoryItemCellBinding.inflate(from, parent, false)
        return CategoryViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindCategoryItem(categories[position])
    }

    override fun getItemCount(): Int = categories.size
}