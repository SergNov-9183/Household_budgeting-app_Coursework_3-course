package com.example.household_budgeting_app

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BankAccountDao
{
    @Query("SELECT * FROM bank_accounts ORDER BY id ASC")
    fun allBankAccounts(): Flow<List<BankAccount>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBankAccount(bankAccount: BankAccount)

    @Update
    suspend fun updateBankAccount(bankAccount: BankAccount)

    @Delete
    suspend fun deleteBankAccount(bankAccount: BankAccount)
}