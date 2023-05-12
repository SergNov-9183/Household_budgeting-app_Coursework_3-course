package com.example.household_budgeting_app

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class OperationRepository(private val operationDao: OperationDao)
{
    val allOperationItems: Flow<List<Operation>> = operationDao.allOperations()

    @WorkerThread
    suspend fun insertOperationItem(operation: Operation)
    {
        operationDao.insertOperation(operation)
    }

    @WorkerThread
    suspend fun updateOperation(operation: Operation)
    {
        operationDao.updateOperation(operation)
    }
}