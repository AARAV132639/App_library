package com.example.a02_to_do_list_app

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao{

    @Query("SELECT*FROM tasks ORDER BY id DESC")
    
    fun getAllTasks(): Flow<List<TodoTask>>

    // Flow<list<TodoTask>> means UI can continously observe the database change

    @Insert
    suspend fun insertTask(task:TodoTask)

    @Update
    suspend fun updateTask(task:TodoTask)

    @Delete
    suspend fun deleteTask(task:TodoTask)

    @Query("SELECT*FROM tasks WHERE isDone =0")
    suspend fun getIncompleteTasks(): List<TodoTask>
}

