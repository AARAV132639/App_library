package com.example.a02_to_do_list_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a02_to_do_list_app.TodoRepository
import com.example.a02_to_do_list_app.TodoTask
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository): ViewModel()
{
    val tasks = repository.allTasks

    fun addTask(title: String)
    {
        if(title.isBlank()) return
        
        viewModelScope.launch{
            repository.addTask(title.trim())
        }
    }

    fun toggleTask(task: TodoTask)
    {
        viewModelScope.launch{
            repository.updateTask(
                task.copy(isdone = !task.isdone)
            )
        }
    }

    fun editTask(task:TodoTask, newTitle:String)
    {
        if(newTitle.isBlank()) return
        viewModelScope.launch{
            repository.updateTask(
                task.copy(
                    title = newTitle.trim()
                )
            )
        }
    }

    fun deleteTask(task: TodoTask)
    {
        viewModelScope.launch{
            repository.deleteTask(task)
        }
    }
}

// Now the state no longer sits inside the Composable
