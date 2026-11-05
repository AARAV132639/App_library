package com.example.a02_to_do_list_app.reminder

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.a02_to_do_list_app.TodoDatabase
import com.example.a02_to_do_list_app.TodoRepository

class IncompleteTasksWorker(
    context: Context,
    params: WorkerParameters,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val repository = TodoRepository(
            TodoDatabase.getDatabase(applicationContext).todoDao(),
        )
        val content = incompleteTaskNotification(
            repository.getIncompleteTasks().map { it.title },
        )
        if (content == null) {
            TaskNotifications.cancel(applicationContext)
            return Result.success()
        }
        if (!TaskNotifications.canPost(applicationContext)) {
            return Result.success()
        }
        TaskNotifications.show(applicationContext, content)
        return Result.success()
    }
}
