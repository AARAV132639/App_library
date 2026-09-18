package com.example.a02_to_do_list_app

//represent one task

data class TodoTask(
    val id: Int,
    var title:String,
    var isDone:Boolean = false
)