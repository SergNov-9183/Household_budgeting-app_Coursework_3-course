package com.example.coursework_3course_budgetapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Operation.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract OperationDao operationDao();
}
