package com.example.a02_to_do_list_app

import androidx.room.Entity
import androidx.room.PrimaryKey

//This class represents databse table

@Entity(tableName="tasks")
data class TodoTask(

    @PrimaryKey(autoGenerate= true)
    val id: Int =0,
    val title: String,
    val isdone: Boolean = false
)