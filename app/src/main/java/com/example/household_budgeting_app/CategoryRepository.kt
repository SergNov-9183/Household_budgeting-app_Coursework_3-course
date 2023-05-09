package com.example.household_budgeting_app

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val categoryDao: CategoryDao)
{
    val allCategoryItems: Flow<List<Category>> = categoryDao.allCategories()

    @WorkerThread
    suspend fun insertCategoryItem(category: Category)
    {
        categoryDao.insertCategory(category)
    }

    @WorkerThread
    suspend fun updateCategory(category: Category)
    {
        categoryDao.updateCategory(category)
    }
}