package com.example.coursework_3course_budgetapp

import androidx.room.*

@Dao
interface OperationDao {
    @get:Query("SELECT * FROM Operations")
    val all: List<Operation?>?

    @Insert
    fun insert(operation: Operation?)

    @Delete
    fun delete(operation: Operation?)

    @Update
    fun update(operation: Operation?)
}