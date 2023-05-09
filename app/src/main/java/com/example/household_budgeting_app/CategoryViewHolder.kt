package com.example.household_budgeting_app

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.household_budgeting_app.databinding.AccauntItemCellBinding
import com.example.household_budgeting_app.databinding.CategoryItemCellBinding

class CategoryViewHolder(
    private val context: Context,
    private val binding: CategoryItemCellBinding,
    private val clickListener: CategoryClickListener
): RecyclerView.ViewHolder(binding.root)
{
    fun bindCategoryItem(category: Category)
    {
        binding.categoryName.text = category.name
        binding.categoryType.text = category.type

        binding.categoryCellContainer.setOnClickListener{
            clickListener.editCategoryItem(category)
        }

    }
}