package com.example.household_budgeting_app

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface OperationDao
{
    @Query("SELECT * FROM operations ORDER BY id ASC")
    fun allOperations(): Flow<List<Operation>>

    @Query("SELECT A.name, A.`desc`, " +
           "(SELECT sum(B.sum) FROM operations B WHERE B.categoryID = A.ID AND B.dateTime >= :beginDate AND B.dateTime <= :endDate) as sum, " +
           "(SELECT sum(C.count) FROM operations C WHERE C.categoryID = A.ID AND C.dateTime >= :beginDate AND C.dateTime <= :endDate) as count " +
           "FROM categories A ORDER BY sum DESC")
    fun operations(beginDate: Long, endDate: Long): Flow<List<Analytics>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOperation(operation: Operation)

    @Update
    suspend fun updateOperation(operation: Operation)

    @Delete
    suspend fun deleteOperation(operation: Operation)
}