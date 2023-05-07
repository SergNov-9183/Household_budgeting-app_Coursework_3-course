package com.example.coursework_3course_budgetapp

import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey
import java.io.Serializable


@Entity (tableName = "Categories")
class Category : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "kind")
    var kind: String? = null

}
