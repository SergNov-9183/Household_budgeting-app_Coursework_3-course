package com.example.household_budgeting_app

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class AnalyticsRepository(private val operationDao: OperationDao, beginDate: Long, endDate: Long) {
    val operationItems: Flow<List<Analytics>> = operationDao.operations(beginDate, endDate)
}