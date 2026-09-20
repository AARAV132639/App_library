package com.example.a02_to_do_list_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecyle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a02_to_do_list_app.data.*

class MainActivity : ComponentActivity()
{
    //updating the MainActivity
    private val viewModel: TodoViewModel by viewModel{
        val database = TodoDatabse.getDatabase(applicationContext)
        val repository = TodoRepository(database.todoDao())
        TodoViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent{
             ToDoScreen(viewModel = viewModel)
        }
    }
}