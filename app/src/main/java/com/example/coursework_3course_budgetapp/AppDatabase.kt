package com.example.coursework_3course_budgetapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Operation::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun operationDao(): OperationDao?
    abstract fun categoryDao(): CategoryDao?
    abstract fun accountDao(): BillDao?
}