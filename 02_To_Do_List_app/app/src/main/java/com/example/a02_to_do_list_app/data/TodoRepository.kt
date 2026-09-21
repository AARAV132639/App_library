package com.example.a02_to_do_list_app

import com.example.a02_to_do_list_app.TodoDao

class TodoRepository(private val dao: TodoDao)
{
    val allTasks = dao.getAllTasks()

    suspend fun addTask(title: String){
        dao.insertTask(
            TodoTask(title=title)
        )
    }


suspend fun updateTask(task: TodoTask)
{
    dao.updateTask(task)
}

suspend fun deleteTask(task: TodoTask)
{
    dao.deleteTask(task)
}

suspend fun getIncompleteTasks():List<TodoTask>{
    return dao.getIncompleteTasks()
}

}

/*
Repository gives us a clean seperation:

UI ---> Viewmodel ---> Repository ---> DAO ---> Room

*/