package com.example.household_budgeting_app

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface OperationDao
{
    @Query("SELECT * FROM operations ORDER BY id ASC")
    fun allOperations(): Flow<List<Operation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOperation(operation: Operation)

    @Update
    suspend fun updateOperation(operation: Operation)

    @Delete
    suspend fun deleteOperation(operation: Operation)
}