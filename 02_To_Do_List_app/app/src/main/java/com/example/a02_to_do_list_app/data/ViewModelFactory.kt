package com.example.a02_to_do_list_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a02_to_do_list_app.TodoRepository

class TodoViewwModelFactory( private val repository: TodoRepository): ViewModelProvider.Factory
{
    @Suppress("UNCHECKED_CAST") override fun <T: ViewModel> create(modelClass: Class<T>):T
    {
        if(modelClass.isAssignableFrom(TodoViewModel::class.java))
        {
            return TodoViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}