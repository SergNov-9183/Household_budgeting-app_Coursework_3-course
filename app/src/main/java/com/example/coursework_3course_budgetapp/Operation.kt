package com.example.coursework_3course_budgetapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "Operations",
 foreignKeys = [ForeignKey(entity = Category::class,
     parentColumns = ["id"],
     childColumns = ["categoryID"],
     onDelete = ForeignKey.CASCADE),
     ForeignKey(entity = Bill::class,
         parentColumns = ["id"],
         childColumns = ["billID"],
         onDelete = ForeignKey.CASCADE)])

class Operation : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "CategoryID")
    var categoryID: Int? = null

    @ColumnInfo(name = "MoneyAmmount")
    var ammount = 0f

    @ColumnInfo(name = "Type")
    var type: String? = null

    @ColumnInfo(name = "Count")
    var count = 0

    @ColumnInfo(name = "Description")
    var description: String? = null

    @ColumnInfo(name = "BillID")
    var accountID: Int? = null
}