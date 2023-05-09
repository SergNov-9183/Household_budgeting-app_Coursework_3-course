package com.example.household_budgeting_app

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class BankAccauntRepository(private val bankAccountDao: BankAccountDao)
{
    val allAccauntItems: Flow<List<BankAccount>> = bankAccountDao.allBankAccounts()

    @WorkerThread
    suspend fun insertAccauntItem(bankAccount: BankAccount)
    {
        bankAccountDao.insertBankAccount(bankAccount)
    }

    @WorkerThread
    suspend fun updateBankAccount(bankAccount: BankAccount)
    {
        bankAccountDao.updateBankAccount(bankAccount)
    }
}