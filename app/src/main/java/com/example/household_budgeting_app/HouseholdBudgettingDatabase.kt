package com.example.household_budgeting_app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BankAccount::class, Category::class, Operation::class], version = 2, exportSchema = false)
public abstract class HouseholdBudgettingDatabase : RoomDatabase()
{
    abstract fun bankAccountDao(): BankAccountDao
    abstract fun categoryDao(): CategoryDao
    abstract fun operationDao(): OperationDao

    companion object
    {
        @Volatile
        private var INSTANCE: HouseholdBudgettingDatabase? = null

        fun getDatabase(context: Context): HouseholdBudgettingDatabase
        {
            return INSTANCE ?: synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HouseholdBudgettingDatabase::class.java,
                    "household_budgeting_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}