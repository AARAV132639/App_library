package com.example.a02_to_do_list_app

import android.R.attr.label
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import java.time.temporal.TemporalAdjusters.next

@Composable
fun ToDoScreen(){

    var taskText by remember{
        mutableStateOf("")
    }

    var tasks by remember {
        mutableStateOf(listOf<TodoTask>())
    }

    var nextId by remember {
        mutableStateOf(1)
    }

    var editingTask by remember {
        mutableStateOf<TodoTask?>(null)
    }

    Column(modifier= Modifier.fillMaxSize().padding(16.dp)){
        Text (text="My To-Do List")
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
                    if(taskText.isNotBlank()){
                        tasks= tasks+TodoTask(id = nextId, title = taskText.trim())
                        nextId++
                        taskText=""
                    }
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
                        tasks=tasks.map{
                            if(it.id==task.id){
                                it.copy(isDone=!it.isDone)
                            }
                            else{
                                it
                            }
                        }
                    },

                    onDelete = {
                        tasks = tasks.filter{
                            it.id!=task.id
                        }
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
                        if(editedText.isNotBlank()){
                            tasks=tasks.map{
                                if(it.id==task.id){
                                    it.copy(title=editedText.trim())
                                }
                                else {
                                    it
                                }
                            }

                            editingTask=null
                        }
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