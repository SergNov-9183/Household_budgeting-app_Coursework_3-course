package com.example.household_budgeting_app

import androidx.room.ColumnInfo

data class Analytics(
    @ColumnInfo(name = "desc") var desc: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "sum") var sum: Int,
    @ColumnInfo(name = "count") var count: Int,
)