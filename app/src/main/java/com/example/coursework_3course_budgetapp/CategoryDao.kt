package com.example.coursework_3course_budgetapp

import androidx.room.*

@Dao
interface CategoryDao {
    @get:Query("SELECT * FROM Categories")
    val all: List<Category?>?

    @Insert
    fun insert(category: Category?)

    @Delete
    fun delete(category: Category?)

    @Update
    fun update(category: Category?)
}