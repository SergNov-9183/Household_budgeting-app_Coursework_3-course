package com.example.household_budgeting_app

import android.app.Application


class HouseholdBudgettingApplication : Application()
{
    private val database by lazy { HouseholdBudgettingDatabase.getDatabase(this) }
    val repository by lazy { BankAccountRepository(database.bankAccountDao()) }
}