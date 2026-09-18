package com.example.a02_to_do_list_app

import android.widget.CheckBox
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp

@Composable
fun TodoItem(
    task: TodoTask,
    onDone:()->Unit,
    onDelete: ()->Unit,
    onEdit:()->Unit
){

    Row(modifier = Modifier.fillMaxWidth().padding(vertical=8.dp), horizontalArrangement = Arrangement.SpaceBetween){

        Row(modifier = Modifier.weight(1f)){
            Checkbox(
                checked = task.isDone,
                onCheckedChange = {
                    onDone()
                }
            )

            Text(
                text = task.title,
                modifier = Modifier.padding(start=8.dp,top=12.dp)
            )

        }

        Row{
            TextButton(onClick=onEdit){
                Text("Edit")
            }
            TextButton(onClick=onDelete){
                Text("Delete")
            }
        }
    }

}