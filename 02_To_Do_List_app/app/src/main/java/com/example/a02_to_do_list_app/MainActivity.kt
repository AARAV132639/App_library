package com.example.a02_to_do_list_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.activity.viewModels

import com.example.a02_to_do_list_app.TodoDatabase
import com.example.a02_to_do_list_app.TodoRepository
import com.example.a02_to_do_list_app.TodoViewwModelFactory

class MainActivity : ComponentActivity()
{
    //updating the MainActivity
    private val viewModel: TodoViewModel by viewModels{
        val database = TodoDatabase.getDatabase(applicationContext)
        val repository = TodoRepository(database.todoDao())
        TodoViewwModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent{
             ToDoScreen(viewModel = viewModel)
        }
    }
}