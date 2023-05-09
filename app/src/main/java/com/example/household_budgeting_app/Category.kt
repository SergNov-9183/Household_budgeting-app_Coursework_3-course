package com.example.household_budgeting_app

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
class Category(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "desc") var type: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
{
}