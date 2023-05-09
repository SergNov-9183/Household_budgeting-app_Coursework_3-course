package com.example.household_budgeting_app

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank_accounts")
class BankAccount(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "desc") var desc: String,
    @ColumnInfo(name = "moneyAmount") var moneyAmount: Int,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
{
}