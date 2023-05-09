package com.example.household_budgeting_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.household_budgeting_app.databinding.ActivityCategoriesBinding


class CategoriesActivity : AppCompatActivity(), CategoryClickListener
{
    private lateinit var binding: ActivityCategoriesBinding
    private val categoryViewModel: CategoryViewModel by viewModels {
        CategoryModelFactory((application as HouseholdBudgettingApplication).categoryRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newCategoryButton.setOnClickListener {
            CategorySheet(null).show(supportFragmentManager, "newCategoryTag")
        }
        setRecyclerView()
    }

    private fun setRecyclerView()
    {
        val mainActivity = this
        categoryViewModel.categoryItems.observe(this){
            binding.categoriesRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = CategoryAdapter(it, mainActivity)
            }
        }
    }

    override fun editCategoryItem(category: Category)
    {
        CategorySheet(category).show(supportFragmentManager,"newAccauntTag")
    }
}