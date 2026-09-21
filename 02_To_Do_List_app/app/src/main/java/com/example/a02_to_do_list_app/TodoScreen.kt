package com.example.a02_to_do_list_app

import android.R.attr.label
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp

import kotlin.collections.emptyList


@Composable
fun ToDoScreen(viewModel:TodoViewModel){

    val tasks by viewModel.tasks.collectAsState(initial = emptyList());
    
    var taskText by remember{
        mutableStateOf("")
    }

    var editingTask by remember {
        mutableStateOf<TodoTask?>(null)
    }

     Column(modifier= Modifier.fillMaxSize().padding(16.dp)){

        Text ("My To-Do List")

        Spacer(modifier= Modifier.height(16.dp))

        //Add task section
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.spacedBy(8.dp)){

            OutlinedTextField(value=taskText, onValueChange={taskText=it},
                modifier = Modifier.weight(1f),
                label={
                    Text("Enter task")
                }
            )

            Button(
                onClick= {  
                        viewModel.addTask(taskText)
                        taskText = ""
                }
            ){
                Text("Add")
            }
        }
        Spacer(modifier=Modifier.height(16.dp))

        //Task list
        LazyColumn{

            items(items = tasks, key = {it.id}){
                task-> TodoItem(task = task,
                    onDone = {
                        viewModel.toggleTask(task)
                    },

                    onDelete = {
                        viewModel.deleteTask(task)
                    },

                    onEdit ={
                        editingTask=task
                    }

                    )
            }
        }
    }

    //edit dialog
    editingTask?.let{
        task-> var editedText by remember(task.id){
            mutableStateOf(task.title)
    }
        AlertDialog(onDismissRequest ={editingTask=null},
            title ={
            Text("Edit Task")},
            text = {
                OutlinedTextField(
                    value = editedText,
                    onValueChange = {
                        editedText = it
                    },
                    label = {
                        Text("Task")
                    }
                )
            },

            confirmButton={
                TextButton(
                    onClick = {
                        
                        viewModel.editTask(task, editedText)

                            editingTask=null
                        
                    }
                ){
                    Text("Save")
                }
            },

            dismissButton ={
                TextButton(
                    onClick = {
                        editingTask=null
                    }
                ){
                    Text("Cancel")
                }
            }

        )
    }
}