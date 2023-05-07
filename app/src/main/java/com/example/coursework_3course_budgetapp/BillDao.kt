package com.example.coursework_3course_budgetapp

import androidx.room.*

@Dao
public interface BillDao {

    @Query("SELECT * FROM Bills")
    fun getAll(): List<Bill?>?

    @Insert
    fun insert(account: Bill?)

    @Delete
    fun delete(account: Bill?)

    @Update
    fun update(account: Bill?)
}