package com.example.household_budgeting_app

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "operations",
        foreignKeys = [ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("categoryID"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BankAccount::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("bankAccountID"),
            onDelete = ForeignKey.CASCADE
        )])
class Operation(
    @ColumnInfo(name = "desc") var desc: String,
    @ColumnInfo(name = "sum") var sum: Int,
    @ColumnInfo(name = "count") var count: Int,
    @ColumnInfo(name = "categoryID") var categoryID: Int,
    @ColumnInfo(name = "bankAccountID") var bankAccauntID: Int,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
{
}