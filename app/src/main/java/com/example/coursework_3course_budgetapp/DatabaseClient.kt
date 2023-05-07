package com.example.coursework_3course_budgetapp

import android.content.Context
import androidx.room.Room

class DatabaseClient private constructor(private val mCtx: Context) {
    //our app database object
    val appDatabase: AppDatabase

    init {

        //creating the app database with Room database builder
        //SaleCars is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "coursework3_database").build()
    }

    companion object {
        private var mInstance: DatabaseClient? = null
        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient? {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance
        }
    }
}