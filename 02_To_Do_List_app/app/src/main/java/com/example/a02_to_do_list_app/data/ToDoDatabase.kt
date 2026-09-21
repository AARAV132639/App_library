package com.example.a02_to_do_list_app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a02_to_do_list_app.TodoTask
import com.example.a02_to_do_list_app.TodoDao
import kotlin.jvm.java

@Database(

    entities = [TodoTask::class],
    version = 1,
    exportSchema = false
)

abstract class TodoDatabase: RoomDatabase()
{
    abstract fun todoDao(): TodoDao

    companion object {

        @Volatile
        private var INSTANCE: TodoDatabase?= null

        fun getDatabase(context:Context): TodoDatabase{
            return INSTANCE?: synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todo_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}

// This is persistent SQLite- backed databse through Room