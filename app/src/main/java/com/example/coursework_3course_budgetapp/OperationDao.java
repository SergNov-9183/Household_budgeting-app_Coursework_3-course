package com.example.coursework_3course_budgetapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface OperationDao {

    @Query("SELECT * FROM operation")
    List<Operation> getAll();

    @Insert
    void insert(Operation operation);

    @Delete
    void delete(Operation operation);

    @Update
    void update(Operation operation);
}
