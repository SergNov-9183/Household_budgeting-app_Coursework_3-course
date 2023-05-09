package com.example.household_budgeting_app

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao
{
    @Query("SELECT * FROM categories ORDER BY id ASC")
    fun allCategories(): Flow<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)
}