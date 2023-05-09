package com.example.household_budgeting_app

import android.app.Application


class HouseholdBudgettingApplication : Application()
{
    private val database by lazy { HouseholdBudgettingDatabase.getDatabase(this) }
    val bankAccauntRepository by lazy { BankAccauntRepository(database.bankAccountDao()) }
    val categoryRepository by lazy { CategoryRepository(database.categoryDao()) }
}